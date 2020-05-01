/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mx.itson.carWash.capaPersistencia;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import javax.swing.JOptionPane;
import mx.itson.carWash.capaNegocio.Producto;
import mx.itson.carWash.capaNegocio.Usuario;

/**
 *
 * @author PAVILION
 */
public class AgregarEmpleadoImpl {
	public boolean agregarEmpleado(Object u) throws FileNotFoundException {
		Usuario usr = (Usuario) u;
		boolean exito;
		PreparedStatement st = null;
		try {
			FileInputStream fi = null;
			File file = new File(usr.getImagen());
			fi = new FileInputStream(file);
			Connection conx = Conexion.getConnection();
			String query = "INSERT INTO usuario(nombre,apellidos,correo,password,tipoUsuario,imagen)VALUES(?,?,?,?,?,?)";
			st = conx.prepareStatement(query);
			st.setString(1, usr.getNombre());
			st.setString(2, usr.getApellidos());
			st.setString(3, usr.getCorreo());
			st.setString(4, usr.getPassword());
			st.setInt(5, usr.getTipoUsuario());
			st.setBinaryStream(6, fi);
			st.execute();
			conx.close();
			exito = true;
		} catch (FileNotFoundException | SQLException ex) {
			System.out.println(ex);
			exito = false;
		} finally {
			try {
				st.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return exito;
	}

	public Object mostrarEmpleados() {
		java.util.List<Usuario> listaUsuarios = new ArrayList();

		PreparedStatement st = null;
		try {
			Connection conx = Conexion.getConnection();
			String query = "SELECT nombre,apellidos,correo,password,imagen FROM usuario WHERE tipoUsuario = 2";
			st = conx.prepareStatement(query);
			ResultSet rs = st.executeQuery();
			while (rs.next()) {
				Usuario usuario = new Usuario();
				usuario.setNombre(rs.getString(1));
				usuario.setApellidos(rs.getString(2));
				usuario.setCorreo(rs.getString(3));
				usuario.setPassword(rs.getString(4));
				usuario.setImgBlob(rs.getBlob(5));
				listaUsuarios.add(usuario);

			}
		} catch (Exception e) {

		} finally {
			try {
				st.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return listaUsuarios;

	}

	public boolean editarEmpleadoImpl(Object u) {
		Usuario usr = (Usuario) u;
		boolean exito = false;
		if (!usr.getImagen().equals("")) {
			PreparedStatement st = null;
			try {
				FileInputStream fi = null;
				File file = new File(usr.getImagen());
				fi = new FileInputStream(file);
				Connection conx = Conexion.getConnection();
				String query = "UPDATE usuario SET "
						+ "nombre = ?"
						+ ",apellidos = ?"
						+ ",password= ?"
						+ ",imagen= ?"
						+ "WHERE correo='" + usr.getCorreo() + "'"
						+ " LIMIT 1;";
				st = conx.prepareStatement(query);
				st.setString(1, usr.getNombre());
				st.setString(2, usr.getApellidos());
				st.setString(3, usr.getPassword());
				st.setBinaryStream(4, fi);
				st.executeUpdate();
				conx.close();
				exito = true;

			} catch (Exception e) {
				System.err.println(e);
			} finally {
				try {
					st.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
			return exito;
		} else {
			PreparedStatement st = null;
			try {
				Connection conx = Conexion.getConnection();
				String query = "UPDATE usuario SET "
						+ "nombre = ?"
						+ ",apellidos = ?"
						+ ",password= ?"
						+ "WHERE correo='" + usr.getCorreo() + "'"
						+ " LIMIT 1;";
				st = conx.prepareStatement(query);
				st.setString(1, usr.getNombre());
				st.setString(2, usr.getApellidos());
				st.setString(3, usr.getPassword());
				st.executeUpdate();
				conx.close();
				exito = true;

			} catch (Exception e) {
				System.err.println(e);
			} finally {
				try {
					st.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
			return exito;
		}

	}
}
