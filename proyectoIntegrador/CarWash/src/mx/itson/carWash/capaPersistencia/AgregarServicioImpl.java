/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mx.itson.carWash.capaPersistencia;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Date;
import javax.swing.JOptionPane;
import mx.itson.carWash.capaNegocio.Producto;
import mx.itson.carWash.capaNegocio.Usuario;

/**
 *
 * @author PAVILION
 */
public class AgregarServicioImpl {

	public boolean agregarServicio(Object s) {
		boolean exito = false;
		return exito;
	}

	public Object MostrarClientes() {
		java.util.List<Usuario> listaUsuarios = new ArrayList();

		PreparedStatement st = null;
		try {
			Connection conx = Conexion.getConnection();
			String query = "SELECT id,nombre,apellidos,correo,tipoUsuario FROM usuario where  tipoUsuario=1";
			st = conx.prepareStatement(query);
			ResultSet rs = st.executeQuery();
			while (rs.next()) {
				Usuario usuario = new Usuario();
				usuario.setId(rs.getInt(1));
				usuario.setNombre(rs.getString(2));
				usuario.setApellidos(rs.getString(3));
				usuario.setCorreo(rs.getString(4));
				usuario.setTipoUsuario(rs.getInt(5));

				listaUsuarios.add(usuario);

			}

		} catch (Exception e) {
			System.err.println(e);
		} finally {
			try {
				st.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return listaUsuarios;

	}

	public Object MostrarEmpleados() {
		java.util.List<Usuario> listaUsuarios = new ArrayList();

		PreparedStatement st = null;
		try {
			Connection conx = Conexion.getConnection();
			String query = "SELECT id,nombre,apellidos,correo,tipoUsuario FROM usuario where  tipoUsuario=2";
			st = conx.prepareStatement(query);
			ResultSet rs = st.executeQuery();
			while (rs.next()) {
				Usuario usuario = new Usuario();
				usuario.setId(rs.getInt(1));
				usuario.setNombre(rs.getString(2));
				usuario.setApellidos(rs.getString(3));
				usuario.setCorreo(rs.getString(4));
				usuario.setTipoUsuario(rs.getInt(5));

				listaUsuarios.add(usuario);

			}

		} catch (Exception e) {
			System.err.println(e);
		} finally {
			try {
				st.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return listaUsuarios;

	}

	public Object MostrarClientesBusqueda(String nombre) {
		java.util.List<Usuario> listaUsuarios = new ArrayList();

		PreparedStatement st = null;
		try {
			Connection conx = Conexion.getConnection();
			String query = "SELECT id,nombre,apellidos,correo,tipoUsuario FROM usuario where  tipoUsuario=1 and nombre LIKE '%" + nombre + "%'";
			st = conx.prepareStatement(query);
			ResultSet rs = st.executeQuery();
			while (rs.next()) {
				Usuario usuario = new Usuario();
				usuario.setId(rs.getInt(1));
				usuario.setNombre(rs.getString(2));
				usuario.setApellidos(rs.getString(3));
				usuario.setCorreo(rs.getString(4));
				usuario.setTipoUsuario(rs.getInt(5));

				listaUsuarios.add(usuario);

			}

		} catch (Exception e) {
			System.err.println(e);
		} finally {
			try {
				st.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return listaUsuarios;

	}

	public Object MostrarEmpleadosBusqueda(String nombre) {
		java.util.List<Usuario> listaUsuarios = new ArrayList();

		PreparedStatement st = null;
		try {
			Connection conx = Conexion.getConnection();
			String query = "SELECT id,nombre,apellidos,correo,tipoUsuario FROM usuario where  tipoUsuario=2 and nombre LIKE '%" + nombre + "%'";
			st = conx.prepareStatement(query);
			ResultSet rs = st.executeQuery();
			while (rs.next()) {
				Usuario usuario = new Usuario();
				usuario.setId(rs.getInt(1));
				usuario.setNombre(rs.getString(2));
				usuario.setApellidos(rs.getString(3));
				usuario.setCorreo(rs.getString(4));
				usuario.setTipoUsuario(rs.getInt(5));

				listaUsuarios.add(usuario);

			}

		} catch (Exception e) {
			System.err.println(e);
		} finally {
			try {
				st.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return listaUsuarios;

	}

	public boolean agregarServicioImpl(String correoCliente, String correoEmpleado, String codigoProducto, String fecha) {

		boolean exito = false;
		PreparedStatement st = null;
		PreparedStatement st1 = null;
		PreparedStatement st2 = null;
		PreparedStatement st3 = null;
		PreparedStatement st4 = null;
		try {
			int idCliente = 0;
			int idEmpleado = 0;
			int idProducto = 0;
			Connection conx = Conexion.getConnection();
			String query1 = "SELECT id FROM usuario WHERE correo='" + correoCliente + "'";
			String query2 = "SELECT id from usuario where correo='" + correoEmpleado + "'";
			String query3 = "SELECT id from producto where codigo='" + codigoProducto + "'";
			st1 = conx.prepareStatement(query1);
			ResultSet rs1 = st1.executeQuery();
			while (rs1.next()) {
				idCliente = rs1.getInt(1);

			}
			st2 = conx.prepareStatement(query2);
			ResultSet rs2 = st2.executeQuery();
			while (rs2.next()) {
				idEmpleado = rs2.getInt(1);

			}
			st3 = conx.prepareStatement(query3);
			ResultSet rs3 = st3.executeQuery();
			while (rs3.next()) {
				idProducto = rs3.getInt(1);

			}

			String query4 = "INSERT INTO servicio(idProducto,idCliente,idEmpleado,fecha)VALUES(?,?,?,?)";
			st4 = conx.prepareStatement(query4);
			st4.setInt(1, idProducto);
			st4.setInt(2, idCliente);
			st4.setInt(3, idEmpleado);
			st4.setString(4, fecha);
			st4.execute();
			conx.close();
			exito = true;
		} catch (Exception ex) {
			JOptionPane.showMessageDialog(null, "Algo fallá...");
			System.err.println(ex);
			exito = false;
		} finally {
			try {
				st.close();
				st1.close();
				st2.close();
				st3.close();
				st4.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return exito;
	}
}
