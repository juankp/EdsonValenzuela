/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package Frames;

import java.awt.HeadlessException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JOptionPane;

/**
 *
 * @author Yo elijo mi pc
 */
public class IFModificarChofer extends javax.swing.JInternalFrame {

    /**
     * Creates new form IFModificarChofer
     */
    public IFModificarChofer() {
        initComponents();
        refreshcombo();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        txtNombre = new javax.swing.JTextField();
        txtCod = new javax.swing.JTextField();
        txtFono = new javax.swing.JTextField();
        cbxRut = new javax.swing.JComboBox();
        btnModificar = new javax.swing.JButton();

        setClosable(true);
        setIconifiable(true);
        setMaximizable(true);
        setTitle("MODIFICAR CHOFER ::: TRANSPORTES EDSON");

        jLabel1.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel1.setText("Codigo:");

        jLabel2.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel2.setText("Nombre:");

        jLabel3.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel3.setText("Fono:");

        jLabel4.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel4.setText("Rut:");

        txtNombre.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtNombreActionPerformed(evt);
            }
        });

        txtCod.setEditable(false);

        cbxRut.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        cbxRut.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cbxRutActionPerformed(evt);
            }
        });

        btnModificar.setText("MODIFICAR");
        btnModificar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnModificarActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(56, 56, 56)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel2)
                                    .addComponent(jLabel3))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 9, Short.MAX_VALUE))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(jLabel4)
                                .addGap(28, 28, 28)))
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(cbxRut, 0, 84, Short.MAX_VALUE)
                            .addComponent(txtNombre)
                            .addComponent(txtFono))
                        .addGap(18, 18, 18)
                        .addComponent(jLabel1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(txtCod, javax.swing.GroupLayout.PREFERRED_SIZE, 81, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(147, 147, 147)
                        .addComponent(btnModificar)))
                .addGap(32, 32, 32))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(51, 51, 51)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(txtCod, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(cbxRut, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel4))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(txtNombre, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(txtFono, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(41, 41, 41)
                .addComponent(btnModificar)
                .addContainerGap(98, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    public void refreshcombo() {
            try {
                DefaultComboBoxModel modeloCombo = new DefaultComboBoxModel();
                Class.forName("org.apache.derby.jdbc.EmbeddedDriver");//prueba es base de datos
            String url = "jdbc:derby:C:/Edson;create=true;user=edson;password=edson";
            Connection conn = DriverManager.getConnection(url);
            //conn.setSchema("EDSON");
                Statement s = conn.createStatement();
                s.execute("SELECT * FROM CHOFER");
                ResultSet rs = s.getResultSet();

                while (rs.next()) {
                    modeloCombo.addElement(rs.getObject("RUT"));
                }
                conn.close();
                cbxRut.setModel(modeloCombo);

            } catch (ClassNotFoundException | SQLException e) {
                JOptionPane.showMessageDialog(null, e);
            }

    }       
    private void txtNombreActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtNombreActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtNombreActionPerformed

    private void cbxRutActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cbxRutActionPerformed
        
        String rut = cbxRut.getSelectedItem().toString();

        try {
            DefaultComboBoxModel modeloCombo = new DefaultComboBoxModel();
            Class.forName("org.apache.derby.jdbc.EmbeddedDriver");//prueba es base de datos
            String url = "jdbc:derby:C:/Edson;create=true;user=edson;password=edson";
            Connection conn = DriverManager.getConnection(url);
            //conn.setSchema("EDSON");
            Statement s = conn.createStatement();
            s.execute("SELECT * FROM CHOFER where RUT = '" + rut + "'");
            ResultSet rs = s.getResultSet();

            while (rs.next()) {

                txtNombre.setText(rs.getString("NOMBRE"));
                txtCod.setText(rs.getString("COD_CHOFER"));
                txtFono.setText(rs.getString("FONO"));
             
                
            }
            conn.close();
            
            

           
        } catch (ClassNotFoundException | SQLException e) {
            JOptionPane.showMessageDialog(this, e);
        }
    }//GEN-LAST:event_cbxRutActionPerformed

    private void btnModificarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnModificarActionPerformed
        String rut = cbxRut.getSelectedItem().toString();
        
        try {
            Class.forName("org.apache.derby.jdbc.EmbeddedDriver");//prueba es base de datos
            String url = "jdbc:derby:C:/Edson;create=true;user=edson;password=edson";
            Connection conn = DriverManager.getConnection(url);
            //conn.setSchema("EDSON");
            Statement s = conn.createStatement();
            s.execute("UPDATE CHOFER SET NOMBRE = '" + txtNombre.getText().toUpperCase() + "',"
                    + " FONO = '" + txtFono.getText() + "'"
                    + " WHERE RUT = '" +rut+ "' ");
            
           
            conn.close();
            JOptionPane.showMessageDialog(null, "Se han actualizado correctamente los datos del chofer");
        
           //Limpiar Campos 
        txtFono.setText(" ");
        txtNombre.setText(" ");
        txtCod.setText(" ");
       
        
        
            
        } catch (HeadlessException | ClassNotFoundException | SQLException e) {
        JOptionPane.showMessageDialog(null, e);
        }
    }//GEN-LAST:event_btnModificarActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnModificar;
    private javax.swing.JComboBox cbxRut;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JTextField txtCod;
    private javax.swing.JTextField txtFono;
    private javax.swing.JTextField txtNombre;
    // End of variables declaration//GEN-END:variables
}
