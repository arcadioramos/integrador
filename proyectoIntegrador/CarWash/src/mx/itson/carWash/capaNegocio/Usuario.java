/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mx.itson.carWash.capaNegocio;

import java.io.FileNotFoundException;
import java.io.UnsupportedEncodingException;
import java.security.InvalidKeyException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.sql.Blob;
import java.sql.SQLException;
import java.util.Arrays;
import java.util.Base64;
import javax.crypto.BadPaddingException;
import javax.crypto.Cipher;
import javax.crypto.IllegalBlockSizeException;
import javax.crypto.NoSuchPaddingException;
import javax.crypto.spec.SecretKeySpec;
import javax.swing.JOptionPane;
import mx.itson.carWash.capaPersistencia.AgregarEmpleadoImpl;
import mx.itson.carWash.capaPersistencia.AgregarProductoImpl;
import mx.itson.carWash.capaPersistencia.EditarClienteImpl;
import mx.itson.carWash.capaPersistencia.IniciarSesionImpl;

/**
 *
 * @author HP Pavilion
 */
public class Usuario {

    /**
     * @return the imgBlob
     */
    public Blob getImgBlob() {
        return imgBlob;
    }

    /**
     * @param imgBlob the imgBlob to set
     */
    public void setImgBlob(Blob imgBlob) {
        this.imgBlob = imgBlob;
    }

    /**
     * @return the imagen
     */
    public String getImagen() {
        return imagen;
    }

    /**
     * @param imagen the imagen to set
     */
    public void setImagen(String imagen) {
        this.imagen = imagen;
    }
    private int id;
    private String nombre;
    private String apellidos;
    private String correo;
    private String password;
    private int tipoUsuario;
    private String imagen;
    private Blob imgBlob;

    /**
     * @return the id
     */
    public int getId() {
        return id;
    }

    /**
     * @param id the id to set
     */
    public void setId(int id) {
        this.id = id;
    }

    /**
     * @return the nombre
     */
    public String getNombre() {
        return nombre;
    }

    /**
     * @param nombre the nombre to set
     */
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    /**
     * @return the apellidos
     */
    public String getApellidos() {
        return apellidos;
    }

    /**
     * @param apellidos the apellidos to set
     */
    public void setApellidos(String apellidos) {
        this.apellidos = apellidos;
    }

    /**
     * @return the correo
     */
    public String getCorreo() {
        return correo;
    }

    /**
     * @param correo the correo to set
     */
    public void setCorreo(String correo) {
        this.correo = correo;
    }

    /**
     * @return the password
     */
    public String getPassword() {
        return password;
    }

    /**
     * @param password the password to set
     */
    public void setPassword(String password) {
        this.password = password;
    }

    /**
     * @return the tipoUsuario
     */
    public int getTipoUsuario() {
        return tipoUsuario;
    }

    /**
     * @param tipoUsuario the tipoUsuario to set
     */
    public void setTipoUsuario(int tipoUsuario) {
        this.tipoUsuario = tipoUsuario;
    }

    public void guardarEmpleado(Object u) {
        Usuario usuario = (Usuario) u;
        try{
        if (usuario.getNombre().equals("") || usuario.getApellidos().equals("") || usuario.getCorreo().equals("")
                || usuario.getPassword().equals("") || usuario.getImagen().equals("")) {
            JOptionPane.showMessageDialog(null, "No campos vacios");
        } else {
            AgregarEmpleadoImpl a = new AgregarEmpleadoImpl();
            if (a.agregarEmpleado(usuario)) {
                JOptionPane.showMessageDialog(null, "Usuario agregado");
            } else {
                JOptionPane.showMessageDialog(null, "Error al agregar");
            }
        }
        }catch(FileNotFoundException ex){
            System.out.println("Error");
        }
    }

    public Object IniciarSesion(Object u) throws FileNotFoundException {
        Usuario usuario = (Usuario) u;
        Usuario usr = new Usuario();
        try {
            if (usuario.getCorreo().equals("") || usuario.getPassword().equals("")) {
                JOptionPane.showMessageDialog(null, "No campos vacios");
            } else {
                IniciarSesionImpl i = new IniciarSesionImpl();
                usr = (Usuario) i.LogIn(usuario);
                if (usr.getId() != 0) {
                    JOptionPane.showMessageDialog(null, "Correcto inicio de sesión");

                } else {
                    JOptionPane.showMessageDialog(null, "Verificar correo y/o contraseña");
                }

            }
        } catch (FileNotFoundException ex) {
            System.out.println(ex);
        }
        return usr;
    }

    public void editarEmpleado(Object u) {
        Usuario usuario = (Usuario) u;
        if (usuario.getNombre().equals("") || usuario.getApellidos().equals("") || usuario.getPassword().equals("")) {
            JOptionPane.showMessageDialog(null, "No campos vacíos");
        } else {
            AgregarEmpleadoImpl ae = new AgregarEmpleadoImpl();
            if (ae.editarEmpleadoImpl(usuario)) {
                JOptionPane.showMessageDialog(null, "Usuario editado correctamente");
            } else {
                JOptionPane.showMessageDialog(null, "Error al editar");
            }
        }
    }

    public void editarCliente(Object u) {
        Usuario usuario = (Usuario) u;
        if (usuario.getNombre().equals("") || usuario.getApellidos().equals("") || usuario.getPassword().equals("")) {
            JOptionPane.showMessageDialog(null, "No campos vacíos");
        } else {
            EditarClienteImpl ec = new EditarClienteImpl();
            if (ec.editarClienteImpl(usuario)) {
                JOptionPane.showMessageDialog(null, "Usuario editado correctamente");
            } else {
                JOptionPane.showMessageDialog(null, "Error al editar");
            }
        }
    }

    private SecretKeySpec crearClave(String clave) throws UnsupportedEncodingException, NoSuchAlgorithmException {
        byte[] claveEncriptacion = clave.getBytes("UTF-8");

        MessageDigest sha = MessageDigest.getInstance("SHA-1");

        claveEncriptacion = sha.digest(claveEncriptacion);
        claveEncriptacion = Arrays.copyOf(claveEncriptacion, 16);

        SecretKeySpec secretKey = new SecretKeySpec(claveEncriptacion, "AES");

        return secretKey;
    }

    public String encriptar(String datos, String claveSecreta) throws UnsupportedEncodingException, NoSuchAlgorithmException, InvalidKeyException, NoSuchPaddingException, IllegalBlockSizeException, BadPaddingException {
        SecretKeySpec secretKey = this.crearClave(claveSecreta);

        Cipher cipher = Cipher.getInstance("AES/ECB/PKCS5Padding");
        cipher.init(Cipher.ENCRYPT_MODE, secretKey);

        byte[] datosEncriptar = datos.getBytes("UTF-8");
        byte[] bytesEncriptados = cipher.doFinal(datosEncriptar);
        String encriptado = Base64.getEncoder().encodeToString(bytesEncriptados);

        return encriptado;
    }

    public String desencriptar(String datosEncriptados, String claveSecreta) throws UnsupportedEncodingException, NoSuchAlgorithmException, InvalidKeyException, NoSuchPaddingException, IllegalBlockSizeException, BadPaddingException {
        SecretKeySpec secretKey = this.crearClave(claveSecreta);

        Cipher cipher = Cipher.getInstance("AES/ECB/PKCS5PADDING");
        cipher.init(Cipher.DECRYPT_MODE, secretKey);

        byte[] bytesEncriptados = Base64.getDecoder().decode(datosEncriptados);
        byte[] datosDesencriptados = cipher.doFinal(bytesEncriptados);
        String datos = new String(datosDesencriptados);

        return datos;
    }
}
