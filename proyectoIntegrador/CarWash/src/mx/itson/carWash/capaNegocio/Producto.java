/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mx.itson.carWash.capaNegocio;

import mx.itson.carWash.capaPersistencia.Conexion;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import javax.swing.JOptionPane;
import mx.itson.carWash.capaPersistencia.AgregarProductoImpl;

/**
 *
 * @author HP Pavilion
 */
public class Producto {

    /**
     * @return the codigo
     */
    public String getCodigo() {
        return codigo;
    }

    /**
     * @param codigo the codigo to set
     */
    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }
    private int id;
    private String nombre;
    private double costo;
    private String descripcion;
    private Connection _con;
    private String codigo;

    @Override
    public String toString() {
        return "Producto{" + "id=" + id + ", nombre=" + nombre + ", costo=" + costo + ", descripcion=" + descripcion + ", _con=" + _con + ", codigo=" + codigo + '}';
    }

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
     * @return the costo
     */
    public double getCosto() {
        return costo;
    }

    /**
     * @param costo the costo to set
     */
    public void setCosto(double costo) {
        this.costo = costo;
    }

    /**
     * @return the descripcion
     */
    public String getDescripcion() {
        return descripcion;
    }

    /**
     * @param descripcion the descripcion to set
     */
    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public void guardarProducto(Object p) {
        Producto producto = (Producto) p;
        if (producto.getNombre().equals("") || producto.getDescripcion().equals("")) {
            JOptionPane.showMessageDialog(null, "No campos vacios");
        } else {
            AgregarProductoImpl a = new AgregarProductoImpl();
            if (a.agregarProducto(producto)) {
                JOptionPane.showMessageDialog(null, "Producto agregado");
            } else {
                JOptionPane.showMessageDialog(null, "Error al agregar");
            }
        }
    }

    public void editarProducto(Object p) {
        Producto producto = (Producto) p;
        if (producto.getNombre().equals("") || producto.getDescripcion().equals("") || producto.getCosto() == 0) {
            JOptionPane.showMessageDialog(null, "No campos vacíos");
        } else {
            AgregarProductoImpl a = new AgregarProductoImpl();
            if (a.editarProductoImpl(producto)) {
                JOptionPane.showMessageDialog(null, "Producto editado correctamente");
            } else {
                JOptionPane.showMessageDialog(null, "Error al editar");
            }
        }
    }

    public void eliminarProducto(Object p) {
        Producto producto = (Producto) p;
        if (producto.getCodigo().equals("")) {
            JOptionPane.showMessageDialog(null, "Ingrese código del producto a eliminar");
        } else {
            AgregarProductoImpl a = new AgregarProductoImpl();
            if (a.eliminarProductoImpl(producto)) {
                JOptionPane.showMessageDialog(null, "Producto eliminado correctamente");
            } else {
                JOptionPane.showMessageDialog(null, "Error al eliminar");
            }
        }
    }
}
