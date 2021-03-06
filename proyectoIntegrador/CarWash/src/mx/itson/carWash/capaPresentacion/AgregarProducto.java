/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mx.itson.carWash.capaPresentacion;

import java.awt.Component;
import java.util.ArrayList;
import java.util.Vector;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;
import mx.itson.carWash.capaNegocio.Producto;
import mx.itson.carWash.capaPersistencia.AgregarProductoImpl;

/**
 *
 * @author HP Pavilion
 */
public class AgregarProducto extends javax.swing.JFrame {

    private static VentanaPrincipal vp = new VentanaPrincipal();
    DefaultTableModel modelo;

    /**
     * Creates new form AgregarProducto
     */
    public AgregarProducto() {
        initComponents();

        modelo = (DefaultTableModel) tablaProductos.getModel();
        rellenarTabla();

    }

    public void rellenarTabla() {
        AgregarProductoImpl ap = new AgregarProductoImpl();
        java.util.List<Producto> listaProductos = new ArrayList();
        listaProductos = (ArrayList) ap.mostrarProductos();
        //Se crea esta condición para que no duplique valores
        if (modelo.getRowCount() >= listaProductos.size()) {
            while (listaProductos.size() != modelo.getRowCount()) {
                modelo.removeRow(1);
            }

        } else {
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
                v.add(b);
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
        ingresaNombreTxt = new javax.swing.JTextField();
        ingresaCostoTxt = new javax.swing.JTextField();
        ingresaDescripcionTxt = new javax.swing.JTextField();
        regresarBtn = new javax.swing.JButton();
        guardarBtn = new javax.swing.JButton();
        botonMostrarProducto = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        tablaProductos = new javax.swing.JTable();
        botonEditar = new javax.swing.JButton();
        ingresaCodigoTxt = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        ingresaCodigoEliminarTxt = new javax.swing.JTextField();
        botonEliminar = new javax.swing.JButton();
        jLabel5 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setBackground(new java.awt.Color(0, 255, 255));

        jLabel1.setText("Nombre:");

        jLabel2.setText("Costo:");

        jLabel3.setText("Descripción:");

        ingresaNombreTxt.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ingresaNombreTxtActionPerformed(evt);
            }
        });

        ingresaCostoTxt.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ingresaCostoTxtActionPerformed(evt);
            }
        });

        regresarBtn.setText("Regresar");
        regresarBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                regresarBtnActionPerformed(evt);
            }
        });

        guardarBtn.setText("Guardar");
        guardarBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                guardarBtnActionPerformed(evt);
            }
        });

        botonMostrarProducto.setText("Mostrar productos");
        botonMostrarProducto.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botonMostrarProductoActionPerformed(evt);
            }
        });

        tablaProductos.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Nombre", "Costo", "Descripcion", "Codigo"
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
        jScrollPane1.setViewportView(tablaProductos);

        botonEditar.setText("Editar");
        botonEditar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botonEditarActionPerformed(evt);
            }
        });

        jLabel4.setText("Código:");

        ingresaCodigoEliminarTxt.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ingresaCodigoEliminarTxtActionPerformed(evt);
            }
        });

        botonEliminar.setText("Eliminar");
        botonEliminar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botonEliminarActionPerformed(evt);
            }
        });

        jLabel5.setText("Ingrese código de producto a eliminar:");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(30, 30, 30)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(ingresaCostoTxt, javax.swing.GroupLayout.DEFAULT_SIZE, 180, Short.MAX_VALUE)
                            .addComponent(jLabel3)
                            .addComponent(jLabel2)
                            .addComponent(jLabel1)
                            .addComponent(ingresaNombreTxt))
                        .addGap(58, 58, 58)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel4)
                            .addComponent(ingresaCodigoTxt, javax.swing.GroupLayout.PREFERRED_SIZE, 180, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(143, 143, 143))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(ingresaDescripcionTxt, javax.swing.GroupLayout.PREFERRED_SIZE, 260, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(regresarBtn)
                    .addComponent(botonEditar)
                    .addComponent(botonMostrarProducto)
                    .addComponent(guardarBtn)
                    .addComponent(ingresaCodigoEliminarTxt, javax.swing.GroupLayout.PREFERRED_SIZE, 184, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel5)
                    .addComponent(botonEliminar, javax.swing.GroupLayout.PREFERRED_SIZE, 121, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(350, 350, 350))
            .addComponent(jScrollPane1, javax.swing.GroupLayout.Alignment.TRAILING)
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(19, 19, 19)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel1)
                            .addComponent(jLabel4)
                            .addComponent(regresarBtn))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(ingresaCodigoTxt, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(ingresaNombreTxt, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jLabel2)
                                .addGap(27, 27, 27)
                                .addComponent(ingresaCostoTxt, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(botonEditar)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(botonMostrarProducto)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(guardarBtn)
                                .addGap(18, 18, 18)
                                .addComponent(jLabel5)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel3)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(ingresaCodigoEliminarTxt, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)))
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(ingresaDescripcionTxt, javax.swing.GroupLayout.PREFERRED_SIZE, 75, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(botonEliminar))
                .addGap(18, 18, 18)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 330, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void ingresaCostoTxtActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ingresaCostoTxtActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_ingresaCostoTxtActionPerformed

    private void ingresaNombreTxtActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ingresaNombreTxtActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_ingresaNombreTxtActionPerformed

    private void guardarBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_guardarBtnActionPerformed
        try {
            Producto p = new Producto();
            String nombre = ingresaNombreTxt.getText();
            double costo = Double.parseDouble(ingresaCostoTxt.getText());
            String descripcion = ingresaDescripcionTxt.getText();
            String codigo = ingresaCodigoTxt.getText();
            p.setNombre(nombre);
            p.setCosto(costo);
            p.setDescripcion(descripcion);
            p.setCodigo(codigo);
            p.guardarProducto(p);
            remover();
            rellenarTabla();
        } catch (NumberFormatException ex) {
            JOptionPane.showMessageDialog(null, "Introducir valores númericos en campo costo");

        }
    }//GEN-LAST:event_guardarBtnActionPerformed

    private void botonMostrarProductoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botonMostrarProductoActionPerformed
        rellenarTabla();
    }//GEN-LAST:event_botonMostrarProductoActionPerformed

    private void tablaProductosMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tablaProductosMouseClicked
        //Se crea variable para obtener el renglón/fila de la tabla que estamos seleccionando
        int filaSeleccionada = tablaProductos.getSelectedRow();
        //Se genera el modelo de la tabla
        DefaultTableModel modelotabla = (DefaultTableModel) tablaProductos.getModel();
        //Se crea una variable para guardar el valor obtenido en la fila seleccionada en su columna tal
        String x = (String) modelotabla.getValueAt(filaSeleccionada, 0);
        double y = (Double) modelotabla.getValueAt(filaSeleccionada, 1);
        String z = (String) modelotabla.getValueAt(filaSeleccionada, 2);
        String a = (String) modelotabla.getValueAt(filaSeleccionada, 3);
        ingresaNombreTxt.setText(x);
        ingresaCostoTxt.setText(Double.toString(y));
        ingresaDescripcionTxt.setText(z);
        ingresaCodigoTxt.setText(a);
    }//GEN-LAST:event_tablaProductosMouseClicked

    private void botonEditarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botonEditarActionPerformed
        try {
            Producto p = new Producto();
            String nombre = ingresaNombreTxt.getText();
            double costo = Double.parseDouble(ingresaCostoTxt.getText());
            String descripcion = ingresaDescripcionTxt.getText();
            String codigo = ingresaCodigoTxt.getText();
            AgregarProductoImpl ap = new AgregarProductoImpl();
            p.setNombre(nombre);
            p.setCosto(costo);
            p.setDescripcion(descripcion);
            p.setCodigo(codigo);
            p.editarProducto(p);
            remover();
            rellenarTabla();
        } catch (NumberFormatException ex) {
            JOptionPane.showMessageDialog(null, "Introducir valores númericos en campo costo");

        }

    }//GEN-LAST:event_botonEditarActionPerformed

    private void regresarBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_regresarBtnActionPerformed
        this.dispose();
        vp.setVisible(true);
    }//GEN-LAST:event_regresarBtnActionPerformed

    private void ingresaCodigoEliminarTxtActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ingresaCodigoEliminarTxtActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_ingresaCodigoEliminarTxtActionPerformed

    private void botonEliminarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botonEliminarActionPerformed
                try {
            Producto p = new Producto();
            String codigoAEliminar = ingresaCodigoEliminarTxt.getText();
           
            AgregarProductoImpl ap = new AgregarProductoImpl();
            p.setCodigo(codigoAEliminar);
            p.eliminarProducto(p);
            remover();
            rellenarTabla();
        } catch (NumberFormatException ex) {
            JOptionPane.showMessageDialog(null, "Introducir valores númericos en campo costo");

        }
    }//GEN-LAST:event_botonEliminarActionPerformed

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
            java.util.logging.Logger.getLogger(AgregarProducto.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(AgregarProducto.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(AgregarProducto.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(AgregarProducto.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new AgregarProducto().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton botonEditar;
    private javax.swing.JButton botonEliminar;
    private javax.swing.JButton botonMostrarProducto;
    private javax.swing.JButton guardarBtn;
    private javax.swing.JTextField ingresaCodigoEliminarTxt;
    private javax.swing.JTextField ingresaCodigoTxt;
    private javax.swing.JTextField ingresaCostoTxt;
    private javax.swing.JTextField ingresaDescripcionTxt;
    private javax.swing.JTextField ingresaNombreTxt;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JButton regresarBtn;
    private javax.swing.JTable tablaProductos;
    // End of variables declaration//GEN-END:variables
}
