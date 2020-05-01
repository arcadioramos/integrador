/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mx.itson.carWash.capaPersistencia;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import javax.swing.JOptionPane;

/**
 *
 * @author HP Pavilion
 */
public class CerrarSesionImpl {
	public boolean cerrarSesion() {
		boolean exito = false;
		PreparedStatement st = null;
		try {
			Connection conx = Conexion.getConnection();
			String query = "DELETE FROM session WHERE id > 0";
			st = conx.prepareStatement(query);
			st.execute();
			conx.close();
			exito = true;
		} catch (Exception ex) {
			JOptionPane.showMessageDialog(null, "Error al cerrar sesión");
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
}
