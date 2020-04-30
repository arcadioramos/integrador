/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mx.itson.carWash.capaPresentacion;

import static com.sun.org.apache.xalan.internal.lib.ExsltDatetime.date;
import com.toedter.calendar.JCalendar;
import java.awt.Image;
import java.awt.image.BufferedImage;
import java.io.ByteArrayInputStream;
import java.sql.Blob;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Vector;
import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import mx.itson.carWash.capaNegocio.Producto;
import mx.itson.carWash.capaNegocio.Servicio;
import mx.itson.carWash.capaNegocio.Session;
import mx.itson.carWash.capaNegocio.Usuario;
import mx.itson.carWash.capaPersistencia.AgregarProductoImpl;
import mx.itson.carWash.capaPersistencia.AgregarServicioImpl;
import mx.itson.carWash.capaPersistencia.CerrarSesionImpl;
import mx.itson.carWash.capaPersistencia.EditarClienteImpl;
import mx.itson.carWash.capaPersistencia.IniciarSesionImpl;

/**
 *
 * @author HP Pavilion
 */
public class AgregarServicio extends javax.swing.JFrame {

    private static VentanaPrincipal vp = new VentanaPrincipal();
    DefaultTableModel modelo;
    DefaultTableModel modelo2;
    DefaultTableModel modelo3;

    /**
     * Creates new form AgregarServicio
     */
    public AgregarServicio() {
        initComponents();
        modelo = (DefaultTableModel) tablaClientes.getModel();
        modelo2 = (DefaultTableModel) tablaEmpleados.getModel();
        modelo3 = (DefaultTableModel) tablaProductos.getModel();

        rellenarTablaCliente();
        rellenarTablaEmpleado();
        rellenarTablaProductos();
        try {
            IniciarSesionImpl i = new IniciarSesionImpl();
            Session s = (Session) i.Session();
            label.setText("Bienvenido: " + s.getNombre() + " " + s.getApellidos());
            Blob blob = s.getImagen();
            byte[] data = blob.getBytes(1, (int) blob.length());
            BufferedImage img = null;
            try {
                img = ImageIO.read(new ByteArrayInputStream(data));
            } catch (Exception ex) {
                System.out.println(ex);
            }
            ImageIcon image = new ImageIcon(img);
            ImageIcon icono = new ImageIcon(image.getImage().getScaledInstance(imagenLbl.getWidth(), imagenLbl.getHeight(), Image.SCALE_DEFAULT));
            imagenLbl.setIcon(icono);
            modelo = (DefaultTableModel) tablaClientes.getModel();
        } catch (Exception ex) {
            System.out.println(ex);
        }
        //rellenarTabla(busqueda);
    }

    public void rellenarTablaCliente() {
        AgregarServicioImpl asi = new AgregarServicioImpl();
        java.util.List<Usuario> listaUsuarios = new ArrayList();
        listaUsuarios = (ArrayList) asi.MostrarClientes();
        //Se crea esta condición para que no duplique valores
        modelo.setRowCount(0);
        //Se crea un for para recorrer el array con los productos
        for (int i = 0; i < listaUsuarios.size(); i++) {
            //Se crea un vector para poder añadir filas
            Vector v = new Vector();
            //Cada variable representa una columna en la fila del vector
            int a = listaUsuarios.get(i).getId();
            String b = listaUsuarios.get(i).getNombre();
            String c = listaUsuarios.get(i).getApellidos();
            String d = listaUsuarios.get(i).getCorreo();
            int e = listaUsuarios.get(i).getTipoUsuario();
            //v.add(a);
            v.add(b); //Get del nombre
            v.add(c); //Get de apellidos
            v.add(d); //Get de correo
            // v.add(e);
            //Se añade la fila a la tabla
            modelo.addRow(v);

        }

    }

    public void rellenarTablaEmpleado() {
        AgregarServicioImpl asi = new AgregarServicioImpl();
        java.util.List<Usuario> listaUsuarios = new ArrayList();
        listaUsuarios = (ArrayList) asi.MostrarEmpleados();
        //Se crea esta condición para que no duplique valores
        modelo2.setRowCount(0);
        //Se crea un for para recorrer el array con los productos
        for (int i = 0; i < listaUsuarios.size(); i++) {
            //Se crea un vector para poder añadir filas
            Vector v = new Vector();
            //Cada variable representa una columna en la fila del vector
            int a = listaUsuarios.get(i).getId();
            String b = listaUsuarios.get(i).getNombre();
            String c = listaUsuarios.get(i).getApellidos();
            String d = listaUsuarios.get(i).getCorreo();
            int e = listaUsuarios.get(i).getTipoUsuario();
            //v.add(a);
            v.add(b); //Get del nombre
            v.add(c); //Get de apellidos
            v.add(d); //Get de correo
            // v.add(e);
            //Se añade la fila a la tabla
            modelo2.addRow(v);

        }

    }

    public void rellenarTablaBusquedaCliente(String nombre) {
        AgregarServicioImpl asi = new AgregarServicioImpl();
        java.util.List<Usuario> listaUsuarios = new ArrayList();
        listaUsuarios = (ArrayList) asi.MostrarClientesBusqueda(nombre);
        //Se crea esta condición para que no duplique valores
        modelo.setRowCount(0);
        //Se crea un for para recorrer el array con los productos
        for (int i = 0; i < listaUsuarios.size(); i++) {
            //Se crea un vector para poder añadir filas
            Vector v = new Vector();
            //Cada variable representa una columna en la fila del vector
            int a = listaUsuarios.get(i).getId();
            String b = listaUsuarios.get(i).getNombre();
            String c = listaUsuarios.get(i).getApellidos();
            String d = listaUsuarios.get(i).getCorreo();
            int e = listaUsuarios.get(i).getTipoUsuario();
            //v.add(a);
            v.add(b); //Get del nombre
            v.add(c); //Get de apellidos
            v.add(d); //Get de correo
            // v.add(e);
            //Se añade la fila a la tabla
            modelo.addRow(v);

        }

    }

    public void rellenarTablaBusquedaEmpleado(String nombre) {
        AgregarServicioImpl asi = new AgregarServicioImpl();
        java.util.List<Usuario> listaUsuarios = new ArrayList();
        listaUsuarios = (ArrayList) asi.MostrarEmpleadosBusqueda(nombre);
        //Se crea esta condición para que no duplique valores
        modelo2.setRowCount(0);
        //Se crea un for para recorrer el array con los productos
        for (int i = 0; i < listaUsuarios.size(); i++) {
            //Se crea un vector para poder añadir filas
            Vector v = new Vector();
            //Cada variable representa una columna en la fila del vector
            int a = listaUsuarios.get(i).getId();
            String b = listaUsuarios.get(i).getNombre();
            String c = listaUsuarios.get(i).getApellidos();
            String d = listaUsuarios.get(i).getCorreo();
            int e = listaUsuarios.get(i).getTipoUsuario();
            //v.add(a);
            v.add(b); //Get del nombre
            v.add(c); //Get de apellidos
            v.add(d); //Get de correo
            // v.add(e);
            //Se añade la fila a la tabla
            modelo2.addRow(v);

        }

    }

    public void rellenarTablaProductos() {
        AgregarProductoImpl ap = new AgregarProductoImpl();
        java.util.List<Producto> listaProductos = new ArrayList();
        listaProductos = (ArrayList) ap.mostrarProductos();
        //Se crea esta condición para que no duplique valores
        modelo3.setRowCount(0);

        //Se crea un for para recorrer el array con los productos
        for (int i = 0; i < listaProductos.size(); i++) {
            //Se crea un vector para poder añadir filas
            Vector v = new Vector();
            //Cada variable representa una columna en la fila del vector
            String x = listaProductos.get(i).getNombre();
            double y = listaProductos.get(i).getCosto();
            String z = listaProductos.get(i).getDescripcion();
            String a = listaProductos.get(i).getCodigo();
            int b = listaProductos.get(i).getId();
            v.add(x);
            v.add(y);
            v.add(z);
            v.add(a);
            //  v.add(b);
            //Se añade la fila a la tabla
            modelo3.addRow(v);

        }

    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLocaleChooser1 = new com.toedter.components.JLocaleChooser();
        jPanel1 = new javax.swing.JPanel();
        regresarBtn = new javax.swing.JButton();
        logOutBtn = new javax.swing.JButton();
        label = new javax.swing.JLabel();
        agregarServicioBoton = new javax.swing.JButton();
        ingreseNombreClienteTxt = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();
        imagenLbl = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        tablaProductos = new javax.swing.JTable();
        jScrollPane3 = new javax.swing.JScrollPane();
        tablaEmpleados = new javax.swing.JTable();
        jLabel2 = new javax.swing.JLabel();
        correoClienteTxt = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        ingreseNombreEmpleadoTxt = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        correoEmpleadoTxt = new javax.swing.JTextField();
        buscarClienteBoton = new javax.swing.JButton();
        mostrarClientesBoton = new javax.swing.JButton();
        buscarEmpleadoBoton = new javax.swing.JButton();
        mostrarEmpleadosBoton = new javax.swing.JButton();
        jLabel5 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tablaClientes = new javax.swing.JTable();
        codigoProductoTxt = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setBackground(new java.awt.Color(51, 102, 255));

        regresarBtn.setText("Regresar");
        regresarBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                regresarBtnActionPerformed(evt);
            }
        });

        logOutBtn.setText("Cerrar sesión");
        logOutBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                logOutBtnActionPerformed(evt);
            }
        });

        label.setText("label");

        agregarServicioBoton.setText("Agregar servicio");
        agregarServicioBoton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                agregarServicioBotonActionPerformed(evt);
            }
        });

        ingreseNombreClienteTxt.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ingreseNombreClienteTxtActionPerformed(evt);
            }
        });

        jLabel1.setText("Nombre cliente:");

        tablaProductos.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Nombre", "Costo", "Descripcion", "código"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.String.class, java.lang.Double.class, java.lang.String.class, java.lang.String.class
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }
        });
        tablaProductos.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tablaProductosMouseClicked(evt);
            }
        });
        jScrollPane2.setViewportView(tablaProductos);

        tablaEmpleados.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Nombre", "Apellidos", "Correo"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.String.class, java.lang.String.class, java.lang.String.class
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }
        });
        tablaEmpleados.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tablaEmpleadosMouseClicked(evt);
            }
        });
        jScrollPane3.setViewportView(tablaEmpleados);

        jLabel2.setText("Nombre empleado:");

        correoClienteTxt.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                correoClienteTxtActionPerformed(evt);
            }
        });

        jLabel3.setText("Correo cliente:");

        ingreseNombreEmpleadoTxt.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ingreseNombreEmpleadoTxtActionPerformed(evt);
            }
        });

        jLabel4.setText("Correo empleado:");

        correoEmpleadoTxt.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                correoEmpleadoTxtActionPerformed(evt);
            }
        });

        buscarClienteBoton.setText("Buscar cliente");
        buscarClienteBoton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buscarClienteBotonActionPerformed(evt);
            }
        });

        mostrarClientesBoton.setText("Mostrar clientes");
        mostrarClientesBoton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                mostrarClientesBotonActionPerformed(evt);
            }
        });

        buscarEmpleadoBoton.setText("Buscar empleado");
        buscarEmpleadoBoton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buscarEmpleadoBotonActionPerformed(evt);
            }
        });

        mostrarEmpleadosBoton.setText("Mostrar empleados");
        mostrarEmpleadosBoton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                mostrarEmpleadosBotonActionPerformed(evt);
            }
        });

        jLabel5.setText("Código producto:");

        tablaClientes.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Nombre", "Apellidos", "Correo"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.String.class, java.lang.String.class, java.lang.String.class
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }
        });
        tablaClientes.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tablaClientesMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tablaClientes);

        jLabel6.setFont(new java.awt.Font("Trebuchet MS", 1, 24)); // NOI18N
        jLabel6.setText("TABLA PRODUCTOS");

        jLabel7.setFont(new java.awt.Font("Trebuchet MS", 1, 24)); // NOI18N
        jLabel7.setText("TABLA EMPLEADOS");

        jLabel8.setFont(new java.awt.Font("Trebuchet MS", 1, 24)); // NOI18N
        jLabel8.setText("Agregar servicio");

        jLabel9.setFont(new java.awt.Font("Trebuchet MS", 1, 24)); // NOI18N
        jLabel9.setText("TABLA CLIENTES");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(24, 24, 24)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(codigoProductoTxt, javax.swing.GroupLayout.PREFERRED_SIZE, 161, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(0, 0, Short.MAX_VALUE)
                                .addComponent(jLabel6))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(jLabel4)
                                            .addComponent(jLabel2)
                                            .addComponent(jLabel5))
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                            .addGroup(jPanel1Layout.createSequentialGroup()
                                                .addGap(0, 0, Short.MAX_VALUE)
                                                .addComponent(jLabel9))
                                            .addGroup(jPanel1Layout.createSequentialGroup()
                                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                                    .addComponent(correoEmpleadoTxt, javax.swing.GroupLayout.DEFAULT_SIZE, 161, Short.MAX_VALUE)
                                                    .addComponent(correoClienteTxt, javax.swing.GroupLayout.Alignment.LEADING)
                                                    .addComponent(jLabel1, javax.swing.GroupLayout.Alignment.LEADING)
                                                    .addComponent(jLabel3, javax.swing.GroupLayout.Alignment.LEADING)
                                                    .addComponent(ingreseNombreClienteTxt, javax.swing.GroupLayout.Alignment.LEADING)
                                                    .addComponent(ingreseNombreEmpleadoTxt, javax.swing.GroupLayout.Alignment.LEADING))
                                                .addGap(18, 18, 18)
                                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                    .addComponent(mostrarEmpleadosBoton, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                                    .addComponent(buscarEmpleadoBoton, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                                    .addComponent(mostrarClientesBoton, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                                    .addComponent(buscarClienteBoton, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                                .addGap(158, 158, 158)
                                                .addComponent(jLabel8)))
                                        .addGap(233, 233, 233)))
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(agregarServicioBoton)
                                    .addComponent(regresarBtn)
                                    .addComponent(logOutBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 117, javax.swing.GroupLayout.PREFERRED_SIZE))))
                        .addGap(37, 37, 37)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(imagenLbl, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(label)))))
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 380, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(28, 28, 28)
                .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 380, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 332, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 52, Short.MAX_VALUE))
            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(jPanel1Layout.createSequentialGroup()
                    .addGap(73, 73, 73)
                    .addComponent(jLabel7)
                    .addContainerGap(894, Short.MAX_VALUE)))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(19, 19, 19)
                        .addComponent(jLabel1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(ingreseNombreClienteTxt, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(buscarClienteBoton))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jLabel3)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(0, 0, Short.MAX_VALUE)
                                .addComponent(agregarServicioBoton))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(correoClienteTxt, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(mostrarClientesBoton))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(jLabel2)
                                .addGap(0, 0, Short.MAX_VALUE))))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel8)
                            .addComponent(imagenLbl, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(11, 11, 11)))
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(9, 9, 9)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(label)
                            .addComponent(buscarEmpleadoBoton))
                        .addGap(1, 1, 1))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(ingreseNombreEmpleadoTxt, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(regresarBtn)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(logOutBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(33, 33, 33))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel4)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(correoEmpleadoTxt, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(mostrarEmpleadosBoton))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel5)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(codigoProductoTxt, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(99, 99, 99)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 193, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel6)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 193, javax.swing.GroupLayout.PREFERRED_SIZE))))
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(jLabel9)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 193, javax.swing.GroupLayout.PREFERRED_SIZE))
            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                    .addContainerGap(330, Short.MAX_VALUE)
                    .addComponent(jLabel7)
                    .addGap(201, 201, 201)))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void logOutBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_logOutBtnActionPerformed
        CerrarSesionImpl c = new CerrarSesionImpl();
        int opcion = JOptionPane.showConfirmDialog(null, "¿Cerrar sesion?", "Cerrar sesion", JOptionPane.YES_NO_OPTION);
        if (opcion == JOptionPane.YES_OPTION) {
            if (c.cerrarSesion()) {
                LogIn l = new LogIn();
                JOptionPane.showMessageDialog(null, "Sesion cerrada");
                this.dispose();
                l.setVisible(true);
            }
        }
    }//GEN-LAST:event_logOutBtnActionPerformed

    private void tablaClientesMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tablaClientesMouseClicked
        //Se crea variable para obtener el renglón/fila de la tabla que estamos seleccionando
        int filaSeleccionada = tablaClientes.getSelectedRow();
        //Se genera el modelo de la tabla
        DefaultTableModel modelotabla = (DefaultTableModel) tablaClientes.getModel();
        //Se crea una variable para guardar el valor obtenido en la fila seleccionada en su columna tal
        String x = (String) modelotabla.getValueAt(filaSeleccionada, 0);
        String y = (String) modelotabla.getValueAt(filaSeleccionada, 1);
        String z = (String) modelotabla.getValueAt(filaSeleccionada, 2);
//        nombreTxt.setText(x);
//        apellidosTxt.setText(y);
        ingreseNombreClienteTxt.setText(x);
        correoClienteTxt.setText(z);


    }//GEN-LAST:event_tablaClientesMouseClicked

    private void agregarServicioBotonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_agregarServicioBotonActionPerformed

        try {
            AgregarServicioImpl asi = new AgregarServicioImpl();
            Usuario usuarioCliente = new Usuario();
            Usuario usuarioEmpleado = new Usuario();
            Producto codigoProducto = new Producto();
            String correoCliente = correoClienteTxt.getText();
            String correoEmpleado = correoEmpleadoTxt.getText();
            String codigo = codigoProductoTxt.getText();
            usuarioCliente.setCorreo(correoCliente);
            usuarioEmpleado.setCorreo(correoEmpleado);
            codigoProducto.setCodigo(codigo);
            JCalendar j = new JCalendar();
            String fecha = new SimpleDateFormat("yyyy/MM/dd").format(j.getDate());
            asi.agregarServicioImpl(correoCliente, correoEmpleado, codigo, fecha);

        } catch (NumberFormatException ex) {
            JOptionPane.showMessageDialog(null, "Introducir valores númericos en campo costo");

        }
        //Así se obtiene la fecha actual...
//        JCalendar j = new JCalendar();
//        String fecha = new SimpleDateFormat("yyyy/MM/dd").format(j.getDate());
//        Date fechaActual = j.getCalendar().getTime();
//        System.out.println(fechaActual);
//        System.out.println(fecha);
        
    }//GEN-LAST:event_agregarServicioBotonActionPerformed

    private void regresarBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_regresarBtnActionPerformed
        this.dispose();
        vp.setVisible(true);
    }//GEN-LAST:event_regresarBtnActionPerformed

    private void ingreseNombreClienteTxtActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ingreseNombreClienteTxtActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_ingreseNombreClienteTxtActionPerformed

    private void tablaProductosMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tablaProductosMouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_tablaProductosMouseClicked

    private void tablaEmpleadosMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tablaEmpleadosMouseClicked
                //Se crea variable para obtener el renglón/fila de la tabla que estamos seleccionando
        int filaSeleccionada = tablaEmpleados.getSelectedRow();
        //Se genera el modelo de la tabla
        DefaultTableModel modelotabla = (DefaultTableModel) tablaEmpleados.getModel();
        //Se crea una variable para guardar el valor obtenido en la fila seleccionada en su columna tal
        String x = (String) modelotabla.getValueAt(filaSeleccionada, 0);
        String y = (String) modelotabla.getValueAt(filaSeleccionada, 1);
        String z = (String) modelotabla.getValueAt(filaSeleccionada, 2);
//        nombreTxt.setText(x);
//        apellidosTxt.setText(y);
        ingreseNombreEmpleadoTxt.setText(x);
        correoEmpleadoTxt.setText(z);


    }//GEN-LAST:event_tablaEmpleadosMouseClicked

    private void correoClienteTxtActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_correoClienteTxtActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_correoClienteTxtActionPerformed

    private void ingreseNombreEmpleadoTxtActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ingreseNombreEmpleadoTxtActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_ingreseNombreEmpleadoTxtActionPerformed

    private void correoEmpleadoTxtActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_correoEmpleadoTxtActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_correoEmpleadoTxtActionPerformed

    private void buscarClienteBotonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buscarClienteBotonActionPerformed
        String nombre = ingreseNombreClienteTxt.getText();
        rellenarTablaBusquedaCliente(nombre);
    }//GEN-LAST:event_buscarClienteBotonActionPerformed

    private void mostrarClientesBotonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_mostrarClientesBotonActionPerformed
        rellenarTablaCliente();
    }//GEN-LAST:event_mostrarClientesBotonActionPerformed

    private void buscarEmpleadoBotonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buscarEmpleadoBotonActionPerformed
        String nombre = ingreseNombreEmpleadoTxt.getText();
        rellenarTablaBusquedaEmpleado(nombre);
    }//GEN-LAST:event_buscarEmpleadoBotonActionPerformed

    private void mostrarEmpleadosBotonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_mostrarEmpleadosBotonActionPerformed
        rellenarTablaEmpleado();
    }//GEN-LAST:event_mostrarEmpleadosBotonActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */

        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new AgregarServicio().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton agregarServicioBoton;
    private javax.swing.JButton buscarClienteBoton;
    private javax.swing.JButton buscarEmpleadoBoton;
    private javax.swing.JTextField codigoProductoTxt;
    private javax.swing.JTextField correoClienteTxt;
    private javax.swing.JTextField correoEmpleadoTxt;
    private javax.swing.JLabel imagenLbl;
    private javax.swing.JTextField ingreseNombreClienteTxt;
    private javax.swing.JTextField ingreseNombreEmpleadoTxt;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private com.toedter.components.JLocaleChooser jLocaleChooser1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JLabel label;
    private javax.swing.JButton logOutBtn;
    private javax.swing.JButton mostrarClientesBoton;
    private javax.swing.JButton mostrarEmpleadosBoton;
    private javax.swing.JButton regresarBtn;
    private javax.swing.JTable tablaClientes;
    private javax.swing.JTable tablaEmpleados;
    private javax.swing.JTable tablaProductos;
    // End of variables declaration//GEN-END:variables
}
