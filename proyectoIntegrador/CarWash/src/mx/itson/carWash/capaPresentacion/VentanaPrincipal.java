/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mx.itson.carWash.capaPresentacion;

import java.awt.Image;
import java.awt.image.BufferedImage;
import java.io.ByteArrayInputStream;
import java.sql.Blob;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;
import mx.itson.carWash.capaNegocio.Session;
import mx.itson.carWash.capaNegocio.Usuario;
import mx.itson.carWash.capaPersistencia.CerrarSesionImpl;
import mx.itson.carWash.capaPersistencia.Conexion;
import mx.itson.carWash.capaPersistencia.IniciarSesionImpl;

/**
 *
 * @author PAVILION
 */
public class VentanaPrincipal extends javax.swing.JFrame {

    private static AgregarEmpleado agregarEmpleado = new AgregarEmpleado();
    private static AgregarProducto agregarProducto = new AgregarProducto();

    /**
     * Creates new form VentanaPrincipal
     */
    public VentanaPrincipal() {
        initComponents();
        try {
            IniciarSesionImpl i = new IniciarSesionImpl();
            Session s = (Session) i.Session();
            label.setText(s.getNombre() + " " + s.getApellidos());
            Blob blob = s.getImagen();
            byte[] data = blob.getBytes(1, (int) blob.length());
            BufferedImage img = null;
            try{
                img = ImageIO.read(new ByteArrayInputStream(data));
            }catch(Exception ex){
                System.out.println(ex);
            }
            ImageIcon image = new ImageIcon(img);
            ImageIcon icono=new ImageIcon(image.getImage().getScaledInstance(imagenLbl.getWidth(), imagenLbl.getHeight(),Image.SCALE_DEFAULT));
            imagenLbl.setIcon(icono);
        } catch (Exception ex) {
            System.out.println(ex);
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

        jPanel1 = new javax.swing.JPanel();
        agregarEmpleadoBtn = new javax.swing.JButton();
        agregarProductoBtn = new javax.swing.JButton();
        label = new javax.swing.JLabel();
        logOutBtn = new javax.swing.JButton();
        editarClientesBtn = new javax.swing.JButton();
        editarEmpleadosBtn = new javax.swing.JButton();
        imagenLbl = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setBackground(new java.awt.Color(51, 153, 255));
        jPanel1.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 0, 0), 4, true));

        agregarEmpleadoBtn.setText("Agregar empleado");
        agregarEmpleadoBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                agregarEmpleadoBtnActionPerformed(evt);
            }
        });

        agregarProductoBtn.setText("Agregar producto");
        agregarProductoBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                agregarProductoBtnActionPerformed(evt);
            }
        });

        label.setText("label");

        logOutBtn.setText("Cerrar sesión");
        logOutBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                logOutBtnActionPerformed(evt);
            }
        });

        editarClientesBtn.setText("Editar clientes");
        editarClientesBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                editarClientesBtnActionPerformed(evt);
            }
        });

        editarEmpleadosBtn.setText("Editar empleados");
        editarEmpleadosBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                editarEmpleadosBtnActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(56, 56, 56)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(logOutBtn)
                        .addGap(41, 41, 41))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(agregarProductoBtn, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(agregarEmpleadoBtn, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addGap(97, 97, 97)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(editarClientesBtn)
                            .addComponent(editarEmpleadosBtn))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 76, Short.MAX_VALUE)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(imagenLbl, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(label)))))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(65, 65, 65)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(agregarEmpleadoBtn)
                            .addComponent(editarClientesBtn)))
                    .addComponent(imagenLbl, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(26, 26, 26)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(agregarProductoBtn)
                            .addComponent(editarEmpleadosBtn)))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(18, 18, 18)
                        .addComponent(label)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 180, Short.MAX_VALUE)
                .addComponent(logOutBtn)
                .addGap(32, 32, 32))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void agregarEmpleadoBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_agregarEmpleadoBtnActionPerformed

        this.dispose();
        agregarEmpleado.setVisible(true);

    }//GEN-LAST:event_agregarEmpleadoBtnActionPerformed

    private void agregarProductoBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_agregarProductoBtnActionPerformed
        this.dispose();
        agregarProducto.setVisible(true);
    }//GEN-LAST:event_agregarProductoBtnActionPerformed

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

    private void editarEmpleadosBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_editarEmpleadosBtnActionPerformed
        EditarEmpleados ee = new EditarEmpleados();
        ee.setVisible(true);
        dispose();
    }//GEN-LAST:event_editarEmpleadosBtnActionPerformed

    private void editarClientesBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_editarClientesBtnActionPerformed
        EditarClientes ec = new EditarClientes();
        ec.setVisible(true);
        dispose();
    }//GEN-LAST:event_editarClientesBtnActionPerformed

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
            java.util.logging.Logger.getLogger(VentanaPrincipal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(VentanaPrincipal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(VentanaPrincipal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(VentanaPrincipal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new VentanaPrincipal().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton agregarEmpleadoBtn;
    private javax.swing.JButton agregarProductoBtn;
    private javax.swing.JButton editarClientesBtn;
    private javax.swing.JButton editarEmpleadosBtn;
    private javax.swing.JLabel imagenLbl;
    private javax.swing.JPanel jPanel1;
    public javax.swing.JLabel label;
    private javax.swing.JButton logOutBtn;
    // End of variables declaration//GEN-END:variables

    private Usuario Usuario(Usuario u) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}