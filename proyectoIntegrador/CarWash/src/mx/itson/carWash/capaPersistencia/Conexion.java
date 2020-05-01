/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mx.itson.carWash.capaPersistencia;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 *
 * @author PAVILION
 */
public class Conexion {
	private static Connection conexion;
	public static String db = "basedatoslara";
	private static String driver = "com.mysql.jdbc.Driver";
	public static String stringConexion = "jdbc:mysql://integradordb-do-user-7302372-0.a.db.ondigitalocean.com:25060/integrador?allowPublicKeyRetrieval=true&useSSL=false";
	public static String password = "pyk9hr3ex3cun2ri";
	public static String usuario = "doadmin";

	public static Connection getConnection() {
		try {
			Class.forName(driver);
			try {
				conexion = DriverManager.getConnection(stringConexion, usuario, password);
			} catch (SQLException ex) {
				System.out.println("Ocurrió un error al conectar: " + ex.getMessage());
			}
		} catch (ClassNotFoundException ex) {
			System.out.println("Ocurrió un error: " + ex.getMessage());
		}
		return conexion;

	}

}