/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mx.itson.carWash.capaPresentacion;

import java.awt.Image;
import java.awt.image.BufferedImage;
import java.io.ByteArrayInputStream;
import java.io.UnsupportedEncodingException;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;
import java.sql.Blob;
import java.util.ArrayList;
import java.util.Vector;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.crypto.BadPaddingException;
import javax.crypto.IllegalBlockSizeException;
import javax.crypto.NoSuchPaddingException;
import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import javax.swing.filechooser.FileNameExtensionFilter;
import javax.swing.table.DefaultTableModel;
import mx.itson.carWash.capaNegocio.Producto;
import mx.itson.carWash.capaNegocio.Usuario;
import mx.itson.carWash.capaPersistencia.AgregarEmpleadoImpl;
import mx.itson.carWash.capaPersistencia.AgregarProductoImpl;

/**
 *
 * @author HP Pavilion
 */
public class EditarEmpleados extends javax.swing.JFrame {

    DefaultTableModel modelo;
    String ruta = null;
    /**
     * Creates new form EditarEmpleados
     */
    public EditarEmpleados() {
        initComponents();
        modelo = (DefaultTableModel) tablaEmpleados.getModel();
        tablaEmpleados.removeColumn(tablaEmpleados.getColumnModel().getColumn(3));
        rutaLbl.setVisible(false);
        ocultarCampos();
        rellenarTabla();
    }
    
    public void ocultarCampos(){
        nombreTxt.setEnabled(false);
        apellidosTxt.setEnabled(false);
        correoTxt.setEnabled(false);
        passwordTxt.setEnabled(false);
        imagenLbl.setText(null);
        nombreTxt.setText(null);
        apellidosTxt.setText(null);
        correoTxt.setText(null);
        passwordTxt.setText(null);
        editarBtn.setEnabled(false);
        btnSeleccionar.setEnabled(false);
    }
    
    public void mostrarCampos(){
        nombreTxt.setEnabled(true);
        apellidosTxt.setEnabled(true);
        correoTxt.setEnabled(true);
        passwordTxt.setEnabled(true);
        editarBtn.setEnabled(true);
        btnSeleccionar.setEnabled(true);
    }
    
    public void rellenarTabla() {
        AgregarEmpleadoImpl ae = new AgregarEmpleadoImpl();
        java.util.List<Usuario> listaUsuarios = new ArrayList();
        listaUsuarios = (ArrayList) ae.mostrarEmpleados();
        //Se crea esta condición para que no duplique valores
        if (modelo.getRowCount() >= listaUsuarios.size()) {
            while (listaUsuarios.size() != modelo.getRowCount()) {
                modelo.removeRow(1);
            }

        } else {
            //Se crea un for para recorrer el array con los productos
            for (int i = 0; i < listaUsuarios.size(); i++) {
                //Se crea un vector para poder añadir filas
                Vector v = new Vector();
                //Cada variable representa una columna en la fila del vector
                String x = listaUsuarios.get(i).getNombre();
                String y = listaUsuarios.get(i).getApellidos();
                String z = listaUsuarios.get(i).getCorreo();
                Blob a = listaUsuarios.get(i).getImgBlob();
                v.add(x);
                v.add(y);
                v.add(z);
                v.add(a);
                //Se añade la fila a la tabla
                modelo.addRow(v);

            }
        }
    }

    public void remover() {
        do {
            modelo.removeRow(0);
        } while (modelo.getRowCount() != 0);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        nombreTxt = new javax.swing.JTextField();
        apellidosTxt = new javax.swing.JTextField();
        jScrollPane1 = new javax.swing.JScrollPane();
        tablaEmpleados = new javax.swing.JTable();
        editarBtn = new javax.swing.JButton();
        jLabel4 = new javax.swing.JLabel();
        correoTxt = new javax.swing.JTextField();
        passwordTxt = new javax.swing.JPasswordField();
        correoAEliminarTxt = new javax.swing.JPasswordField();
        jLabel5 = new javax.swing.JLabel();
        imagenLbl = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        btnSeleccionar = new javax.swing.JButton();
        rutaLbl = new javax.swing.JLabel();
        regresarBtn = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setBackground(new java.awt.Color(51, 153, 255));

        jLabel1.setText("Nombre:");

        jLabel2.setText("Apellidos:");

        jLabel3.setText("Contraseña");

        nombreTxt.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                nombreTxtActionPerformed(evt);
            }
        });

        tablaEmpleados.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Nombre", "Apellidos", "Correo", "Imagen"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.Object.class
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
        jScrollPane1.setViewportView(tablaEmpleados);

        editarBtn.setText("Editar");
        editarBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                editarBtnActionPerformed(evt);
            }
        });

        jLabel4.setText("Correo:");

        correoTxt.setEditable(false);

        jLabel5.setText("Ingresar correo de empleado a eliminar");

        jLabel6.setText("Foto de perfil:");

        btnSeleccionar.setText("Seleccionar nueva...");
        btnSeleccionar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSeleccionarActionPerformed(evt);
            }
        });

        regresarBtn.setText("Regresar");
        regresarBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                regresarBtnActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(44, 44, 44)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                        .addComponent(apellidosTxt, javax.swing.GroupLayout.DEFAULT_SIZE, 173, Short.MAX_VALUE)
                        .addComponent(nombreTxt)
                        .addComponent(jLabel3)
                        .addComponent(jLabel2)
                        .addComponent(jLabel1))
                    .addComponent(passwordTxt, javax.swing.GroupLayout.PREFERRED_SIZE, 173, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(51, 51, 51)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel1Layout.createSequentialGroup()
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(correoTxt, javax.swing.GroupLayout.PREFERRED_SIZE, 174, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel4))
                                .addGap(124, 124, 124)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(editarBtn)
                                    .addComponent(regresarBtn)))
                            .addComponent(correoAEliminarTxt, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 173, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel5, javax.swing.GroupLayout.Alignment.LEADING))
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 331, Short.MAX_VALUE)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel6)
                            .addComponent(btnSeleccionar)
                            .addComponent(imagenLbl, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(rutaLbl))
                        .addGap(213, 213, 213))))
            .addComponent(jScrollPane1)
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(34, 34, 34)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel1)
                            .addComponent(jLabel4))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(nombreTxt, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(correoTxt, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(53, 53, 53)
                        .addComponent(regresarBtn)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(editarBtn)))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(rutaLbl))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(apellidosTxt, javax.swing.GroupLayout.PREFERRED_SIZE, 46, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(60, 60, 60)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel3)
                            .addComponent(jLabel5))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(passwordTxt, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(correoAEliminarTxt, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel6)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnSeleccionar)
                        .addGap(18, 18, 18)
                        .addComponent(imagenLbl, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(76, 76, 76)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 256, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void nombreTxtActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_nombreTxtActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_nombreTxtActionPerformed

    private void tablaEmpleadosMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tablaEmpleadosMouseClicked
        //Se crea variable para obtener el renglón/fila de la tabla que estamos seleccionando
        int filaSeleccionada = tablaEmpleados.getSelectedRow();
        //Se genera el modelo de la tabla
        DefaultTableModel modelotabla = (DefaultTableModel) tablaEmpleados.getModel();
        //Se crea una variable para guardar el valor obtenido en la fila seleccionada en su columna tal
        String x = (String) modelotabla.getValueAt(filaSeleccionada, 0);
        String y = (String) modelotabla.getValueAt(filaSeleccionada, 1);
        String z = (String) modelotabla.getValueAt(filaSeleccionada, 2);
        Blob a = (Blob) modelotabla.getValueAt(filaSeleccionada, 3);
        nombreTxt.setText(x);
        apellidosTxt.setText(y);
        correoTxt.setText(z);
        try {
            byte[] data = a.getBytes(1, (int) a.length());
            BufferedImage img = null;
            try {
                img = ImageIO.read(new ByteArrayInputStream(data));
            } catch (Exception ex) {
                System.out.println(ex);
            }
            ImageIcon image = new ImageIcon(img);
            ImageIcon icono = new ImageIcon(image.getImage().getScaledInstance(imagenLbl.getWidth(), imagenLbl.getHeight(), Image.SCALE_DEFAULT));
            imagenLbl.setIcon(icono);
            mostrarCampos();
        } catch (Exception ex) {
            System.out.println(ex);
        }
    }//GEN-LAST:event_tablaEmpleadosMouseClicked

    private void editarBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_editarBtnActionPerformed
        try {
            Usuario u = new Usuario();
            String nombre = nombreTxt.getText();
            String apellidos = apellidosTxt.getText();
            String correo = correoTxt.getText();
            String password = passwordTxt.getText();
            String imagen = rutaLbl.getText();
            AgregarEmpleadoImpl ae = new AgregarEmpleadoImpl();
            if(!password.equals("")){
            String claveEncriptacion = "key";
            String datosOriginales = password;
            String encriptado = u.encriptar(datosOriginales, claveEncriptacion);
            u.setNombre(nombre);
            u.setApellidos(apellidos);
            u.setCorreo(correo);
            u.setPassword(encriptado);
            u.setImagen(imagen);
            u.editarEmpleado(u);
            remover();
            rellenarTabla();
            ocultarCampos();
            }else{
                JOptionPane.showMessageDialog(null, "No campos vacios");
            }
        } catch (NumberFormatException ex) {
            JOptionPane.showMessageDialog(null, "Introducir valores númericos en campo costo");
        } catch (UnsupportedEncodingException | NoSuchAlgorithmException | InvalidKeyException | NoSuchPaddingException | IllegalBlockSizeException | BadPaddingException ex) {
            Logger.getLogger(Usuario.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_editarBtnActionPerformed

    private void btnSeleccionarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSeleccionarActionPerformed
        JFileChooser j = new JFileChooser();
        FileNameExtensionFilter filtro = new FileNameExtensionFilter("JPG & PNG", "jpg", "png", "jpeg");
        j.setFileFilter(filtro);
        j.setFileSelectionMode(JFileChooser.FILES_ONLY);
        int ap = j.showOpenDialog(this);
        if (ap == JFileChooser.APPROVE_OPTION) {
            ruta = j.getSelectedFile().getAbsolutePath();
            ImageIcon i = new ImageIcon(ruta);
            ImageIcon icono = new ImageIcon(i.getImage().getScaledInstance(imagenLbl.getWidth(), imagenLbl.getHeight(), Image.SCALE_DEFAULT));
            imagenLbl.setIcon(icono);
            rutaLbl.setText(ruta);
        }
    }//GEN-LAST:event_btnSeleccionarActionPerformed

    private void regresarBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_regresarBtnActionPerformed
        VentanaPrincipal vp = new VentanaPrincipal();
        vp.setVisible(true);
        dispose();
    }//GEN-LAST:event_regresarBtnActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(EditarEmpleados.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(EditarEmpleados.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(EditarEmpleados.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(EditarEmpleados.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new EditarEmpleados().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextField apellidosTxt;
    private javax.swing.JButton btnSeleccionar;
    private javax.swing.JPasswordField correoAEliminarTxt;
    private javax.swing.JTextField correoTxt;
    private javax.swing.JButton editarBtn;
    private javax.swing.JLabel imagenLbl;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTextField nombreTxt;
    private javax.swing.JPasswordField passwordTxt;
    private javax.swing.JButton regresarBtn;
    private javax.swing.JLabel rutaLbl;
    private javax.swing.JTable tablaEmpleados;
    // End of variables declaration//GEN-END:variables
}
