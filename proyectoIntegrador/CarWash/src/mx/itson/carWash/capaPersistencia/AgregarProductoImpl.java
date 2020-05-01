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
import java.util.ArrayList;
import java.util.List;

import javax.swing.JOptionPane;
import mx.itson.carWash.capaNegocio.Producto;

/**
 *
 * @author HP Pavilion
 */
public class AgregarProductoImpl {

	public boolean agregarProducto(Object p) {
		Producto pro = (Producto) p;
		boolean exito = false;
		PreparedStatement st = null;
		try {
			Connection conx = Conexion.getConnection();
			String query = "INSERT INTO producto(nombre,costo,descripcion,codigo)VALUES(?,?,?,?)";
			st = conx.prepareStatement(query);
			st.setString(1, pro.getNombre());
			st.setDouble(2, pro.getCosto());
			st.setString(3, pro.getDescripcion());
			st.setString(4, pro.getCodigo());
			st.execute();
			conx.close();
			exito = true;
		} catch (Exception ex) {
			JOptionPane.showMessageDialog(null, "No se ha introducido");
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

	public boolean editarProductoImpl(Object p) {
		Producto pro = (Producto) p;
		boolean exito = false;
		PreparedStatement st = null;
		try {
			Connection conx = Conexion.getConnection();
			String query = "UPDATE producto SET "
					+ "nombre = ?"
					+ ",costo = ?"
					+ ",descripcion= ?"
					+ "WHERE codigo=" + pro.getCodigo()
					+ " LIMIT 1;";
			st = conx.prepareStatement(query);
			st.setString(1, pro.getNombre());
			st.setDouble(2, pro.getCosto());
			st.setString(3, pro.getDescripcion());
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

	public boolean eliminarProductoImpl(Object p) {
		boolean exito = false;
		Producto pro = (Producto) p;
		PreparedStatement st = null;
		try {
			Connection conx = Conexion.getConnection();
			String query = "DELETE FROM producto WHERE codigo=" + pro.getCodigo()
					+ " LIMIT 1;";
			;
			st = conx.prepareStatement(query);
			st.execute();
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

	public Object mostrarProductos() {
		List<Producto> listaProductos = new ArrayList();

		PreparedStatement st = null;
		try {
			Connection conx = Conexion.getConnection();
			String query = "SELECT * FROM producto";
			st = conx.prepareStatement(query);
			ResultSet rs = st.executeQuery();
			while (rs.next()) {
				Producto producto = new Producto();
				producto.setId(rs.getInt(1));
				producto.setNombre(rs.getString(2));
				producto.setCosto(rs.getDouble(3));
				producto.setDescripcion(rs.getString(4));
				producto.setCodigo(rs.getString(5));
				listaProductos.add(producto);

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
		return listaProductos;

	}
}
