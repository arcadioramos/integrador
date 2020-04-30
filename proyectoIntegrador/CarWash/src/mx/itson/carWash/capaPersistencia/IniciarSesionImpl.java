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
import mx.itson.carWash.capaNegocio.Session;
import mx.itson.carWash.capaNegocio.Usuario;

/**
 *
 * @author PAVILION
 */
public class IniciarSesionImpl {

    public Object LogIn(Object u) throws FileNotFoundException {
        Usuario usr = (Usuario) u;
        boolean exito = false;
        try {
            Connection conx = Conexion.getConnection();
            String query = "SELECT id, nombre, apellidos, correo, password, tipoUsuario, imagen FROM usuario WHERE correo = '" + usr.getCorreo() + "' and password = '" + usr.getPassword() + "'";
            PreparedStatement st = conx.prepareStatement(query);
            ResultSet rs = st.executeQuery();

            if (rs.next()) {
                usr.setId(rs.getInt(1));
                usr.setNombre(rs.getString(2));
                usr.setApellidos(rs.getString(3));
                usr.setCorreo(rs.getString(4));
                usr.setPassword(rs.getString(5));
                usr.setTipoUsuario(rs.getInt(6));
                usr.setImgBlob(rs.getBlob(7));
                String query2 = "INSERT INTO session(idUsuario, nombre, apellidos, correo, password, tipoUsuario, imagen) VALUES (?,?,?,?,?,?,?)";
                PreparedStatement st2 = conx.prepareStatement(query2);
                st2.setInt(1, rs.getInt(1));
                st2.setString(2, rs.getString(2));
                st2.setString(3, rs.getString(3));
                st2.setString(4, rs.getString(4));
                st2.setString(5, rs.getString(5));
                st2.setInt(6, rs.getInt(6));
                st2.setBlob(7, rs.getBlob(7));
                st2.execute();
                conx.close();
            }
        } catch (SQLException ex) {
            System.out.println(ex);
        }
        return usr;
    }

    public Object Session() {
        Session session = new Session();
        try {
            Connection conx = Conexion.getConnection();
            String query = "SELECT idUsuario, nombre, apellidos, correo, password, tipoUsuario, imagen FROM session WHERE id=(SELECT MAX(id) FROM session)";
            PreparedStatement st = conx.prepareStatement(query);
            ResultSet rs = st.executeQuery();
            if (rs.next()) {
                session.setId(rs.getInt(1));
                session.setNombre(rs.getString(2));
                session.setApellidos(rs.getString(3));
                session.setCorreo(rs.getString(4));
                session.setPassword(rs.getString(5));
                session.setTipoUsuario(rs.getInt(6));
                session.setImagen(rs.getBlob(7));
                conx.close();
            }}catch (SQLException ex) {
            System.out.println(ex);
        }
            return session;
        }
    }
