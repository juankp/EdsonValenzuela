/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Frames;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JComboBox;
import javax.swing.JOptionPane;

/**
 *
 * @author Yo elijo mi pc
 */
public class IFModificarProve extends javax.swing.JInternalFrame {

    /**
     * Creates new form IFProveActualizar
     */
    public IFModificarProve() {
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
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        cbxProv = new javax.swing.JComboBox();
        txtRutAct = new javax.swing.JTextField();
        txtRazonProv = new javax.swing.JTextField();
        txtGiroProv = new javax.swing.JTextField();
        txtComunaProv = new javax.swing.JTextField();
        txtFonoProv = new javax.swing.JTextField();
        txtCiudadProv = new javax.swing.JTextField();
        txtDirProv = new javax.swing.JTextField();
        txtEmailProv = new javax.swing.JTextField();
        txtWebProv = new javax.swing.JTextField();
        btnModificarProv = new javax.swing.JButton();

        setClosable(true);
        setIconifiable(true);
        setMaximizable(true);
        setTitle("MODIFICAR PROVEEDORES ::: TRANSPORTES EDSON");

        jLabel1.setText("Nombre:");

        jLabel2.setText("Rut:");

        jLabel3.setText("Razón:");

        jLabel4.setText("Giro");

        jLabel5.setText("Dirección:");

        jLabel6.setText("Comuna:");

        jLabel7.setText("Fono:");

        jLabel8.setText("Ciudad:");

        jLabel9.setText("Web:");

        jLabel10.setText("Email:");

        cbxProv.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        cbxProv.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cbxProvActionPerformed(evt);
            }
        });

        txtRutAct.setEnabled(false);
        txtRutAct.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtRutActActionPerformed(evt);
            }
        });

        txtRazonProv.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtRazonProvActionPerformed(evt);
            }
        });

        txtGiroProv.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtGiroProvActionPerformed(evt);
            }
        });

        txtComunaProv.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtComunaProvActionPerformed(evt);
            }
        });

        txtFonoProv.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtFonoProvActionPerformed(evt);
            }
        });
        txtFonoProv.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtFonoProvKeyTyped(evt);
            }
        });

        txtCiudadProv.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtCiudadProvActionPerformed(evt);
            }
        });

        txtDirProv.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtDirProvActionPerformed(evt);
            }
        });

        txtEmailProv.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtEmailProvActionPerformed(evt);
            }
        });

        txtWebProv.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtWebProvActionPerformed(evt);
            }
        });

        btnModificarProv.setText("Modificar");
        btnModificarProv.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnModificarProvActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(30, 30, 30)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel3)
                    .addComponent(jLabel4)
                    .addComponent(jLabel2)
                    .addComponent(jLabel1))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(cbxProv, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(txtRutAct)
                    .addComponent(txtRazonProv)
                    .addComponent(txtGiroProv, javax.swing.GroupLayout.PREFERRED_SIZE, 82, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel5, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel6, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(jLabel7)
                        .addGap(9, 9, 9))
                    .addComponent(jLabel8, javax.swing.GroupLayout.Alignment.TRAILING))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addComponent(txtComunaProv, javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(txtCiudadProv, javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(txtFonoProv, javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(txtDirProv, javax.swing.GroupLayout.PREFERRED_SIZE, 109, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel10, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel9, javax.swing.GroupLayout.Alignment.TRAILING))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(txtEmailProv, javax.swing.GroupLayout.DEFAULT_SIZE, 109, Short.MAX_VALUE)
                    .addComponent(txtWebProv))
                .addGap(50, 50, 50))
            .addGroup(layout.createSequentialGroup()
                .addGap(237, 237, 237)
                .addComponent(btnModificarProv)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(29, 29, 29)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel1)
                            .addComponent(cbxProv, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel2)
                            .addComponent(txtRutAct, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(txtRazonProv, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel3))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(txtGiroProv, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel4)))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(26, 26, 26)
                        .addComponent(txtComunaProv, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(txtCiudadProv, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel8)))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel5)
                            .addComponent(txtDirProv, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel6)
                        .addGap(35, 35, 35)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel7)
                            .addComponent(txtFonoProv, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel10)
                            .addComponent(txtEmailProv, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel9)
                            .addComponent(txtWebProv, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addGap(35, 35, 35)
                .addComponent(btnModificarProv)
                .addContainerGap(65, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void txtRutActActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtRutActActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtRutActActionPerformed

    private void txtRazonProvActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtRazonProvActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtRazonProvActionPerformed

    private void txtGiroProvActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtGiroProvActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtGiroProvActionPerformed

    private void txtComunaProvActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtComunaProvActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtComunaProvActionPerformed

    private void txtFonoProvActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtFonoProvActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtFonoProvActionPerformed

    private void txtCiudadProvActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtCiudadProvActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtCiudadProvActionPerformed

    private void txtDirProvActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtDirProvActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtDirProvActionPerformed

    private void txtEmailProvActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtEmailProvActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtEmailProvActionPerformed

    private void txtWebProvActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtWebProvActionPerformed
        // TODO dd your handling code here:
    }//GEN-LAST:event_txtWebProvActionPerformed

    private void btnModificarProvActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnModificarProvActionPerformed
        
        String rut = txtRutAct.getText();
        try {
            
            
            //DefaultComboBoxModel modeloCombo = new DefaultComboBoxModel();
            Class.forName("org.apache.derby.jdbc.EmbeddedDriver");//prueba es base de datos
            String url = "jdbc:derby:C:/Edson;create=true;user=edson;password=edson";
            Connection conn = DriverManager.getConnection(url);
            //conn.setSchema("EDSON");
            Statement s = conn.createStatement();
            s.execute("UPDATE PROVEEDOR SET RAZON_PROV = '" + txtRazonProv.getText().toUpperCase() + "',"
                    + " GIRO_PROV = '" + txtGiroProv.getText().toUpperCase() + "',"
                    + " DIRECCION_PROV = '" + txtDirProv.getText().toUpperCase() + "',"
                    + " COMUNA_PROV = '" + txtComunaProv.getText().toUpperCase() + "',"
                    + " CIUDAD_PROV = '" + txtCiudadProv.getText().toUpperCase() + "',"
                    + " FONO_PROV = '" + txtFonoProv.getText() + "',"
                    + " EMAIL_PROV = '" + txtEmailProv.getText().toUpperCase() + "',"
                    + " WEB_PROV = '" + txtWebProv.getText().toUpperCase() + "'"
                    + " where RUT_PROV = '" + rut + "' ");
            
           
            conn.close();
            JOptionPane.showMessageDialog(null, "Se han actualizado correctamente los datos de "+rut);
        
           //Limpiar Campos 
        txtRutAct.setText(" ");
        txtRazonProv.setText(" ");
        txtGiroProv.setText(" ");
        txtDirProv.setText(" ");
        txtComunaProv.setText(" ");
        txtCiudadProv.setText(" ");
        txtFonoProv.setText(" ");
        txtEmailProv.setText(" ");
        txtWebProv.setText(" ");

        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e);
        }
    }//GEN-LAST:event_btnModificarProvActionPerformed

    private void cbxProvActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cbxProvActionPerformed

        String nombre = cbxProv.getSelectedItem().toString();

            

        try {
            DefaultComboBoxModel modeloCombo = new DefaultComboBoxModel();
            Class.forName("org.apache.derby.jdbc.EmbeddedDriver");//prueba es base de datos
            String url = "jdbc:derby:C:/Edson;create=true;user=edson;password=edson";
            Connection conn = DriverManager.getConnection(url);
            //conn.setSchema("EDSON");
            Statement s = conn.createStatement();
            s.execute("SELECT * FROM PROVEEDOR where NOMBRE_PROV = '" + nombre + "'");
            ResultSet rs = s.getResultSet();

            while (rs.next()) {

                txtRutAct.setText(rs.getString("RUT_PROV"));
                txtRazonProv.setText(rs.getString("RAZON_PROV"));
                txtGiroProv.setText(rs.getString("GIRO_PROV"));
                txtDirProv.setText(rs.getString("DIRECCION_PROV"));
                txtComunaProv.setText(rs.getString("COMUNA_PROV"));
                txtCiudadProv.setText(rs.getString("CIUDAD_PROV"));
                txtFonoProv.setText(rs.getString("FONO_PROV"));
                txtEmailProv.setText(rs.getString("EMAIL_PROV"));
                txtWebProv.setText(rs.getString("WEB_PROV"));

            }
          
            conn.close();
           
        } catch (Exception e) {
        }
        }

        public void refreshcombo() {
            try {
                DefaultComboBoxModel modeloCombo = new DefaultComboBoxModel();
                Class.forName("org.apache.derby.jdbc.EmbeddedDriver");//prueba es base de datos
            String url = "jdbc:derby:C:/Edson;create=true;user=edson;password=edson";
            Connection conn = DriverManager.getConnection(url);
            //conn.setSchema("EDSON");
                Statement s = conn.createStatement();
                s.execute("SELECT * FROM PROVEEDOR");
                ResultSet rs = s.getResultSet();

                while (rs.next()) {
                    modeloCombo.addElement(rs.getObject("NOMBRE_PROV"));
                }
                conn.close();
                cbxProv.setModel(modeloCombo);

            } catch (Exception e) {
            }

    }//GEN-LAST:event_cbxProvActionPerformed

    private void txtFonoProvKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtFonoProvKeyTyped
        char car = evt.getKeyChar();
        if((car<'0' || car>'9')) evt.consume();
    }//GEN-LAST:event_txtFonoProvKeyTyped

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnModificarProv;
    private javax.swing.JComboBox cbxProv;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JTextField txtCiudadProv;
    private javax.swing.JTextField txtComunaProv;
    private javax.swing.JTextField txtDirProv;
    private javax.swing.JTextField txtEmailProv;
    private javax.swing.JTextField txtFonoProv;
    private javax.swing.JTextField txtGiroProv;
    private javax.swing.JTextField txtRazonProv;
    private javax.swing.JTextField txtRutAct;
    private javax.swing.JTextField txtWebProv;
    // End of variables declaration//GEN-END:variables
}
