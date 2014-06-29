/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package Frames;

import Codigo.factura;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JOptionPane;

/**
 *
 * @author Yo elijo mi pc
 */
public class IFAnularFactura extends javax.swing.JInternalFrame {

    /**
     * Creates new form IFAnularFactura
     */
    public IFAnularFactura() {
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

        cbxNumero = new javax.swing.JComboBox();
        jLabel1 = new javax.swing.JLabel();
        btnAnular = new javax.swing.JButton();
        jLabel2 = new javax.swing.JLabel();

        setClosable(true);
        setIconifiable(true);
        setMaximizable(true);
        setTitle("ANULAR FACTURA ::: TRANSPORTES EDSON");

        cbxNumero.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        jLabel1.setText("N° Factura:");

        btnAnular.setText("Anular");
        btnAnular.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAnularActionPerformed(evt);
            }
        });

        jLabel2.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel2.setText("Seleccione el número de la  factura que desea anular: ");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                        .addComponent(jLabel2)
                        .addGroup(layout.createSequentialGroup()
                            .addGap(93, 93, 93)
                            .addComponent(jLabel1)
                            .addGap(40, 40, 40)
                            .addComponent(cbxNumero, javax.swing.GroupLayout.PREFERRED_SIZE, 174, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(208, 208, 208)
                        .addComponent(btnAnular, javax.swing.GroupLayout.PREFERRED_SIZE, 83, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(76, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(43, 43, 43)
                .addComponent(jLabel2)
                .addGap(52, 52, 52)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(cbxNumero, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(39, 39, 39)
                .addComponent(btnAnular, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(66, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnAnularActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAnularActionPerformed
        int numero = Integer.parseInt(cbxNumero.getSelectedItem().toString());
        try {
            
            factura f = new factura();
            f.descripcion = "-";
            f.cantidad = "-";
            f.precio_u = "-";
            f.total = "-";
            f.iva = "-";
            f.especifico = "-";
            f.excento = "-";
            f.cond_venta = "-";
            f.orden_c = "-";
            f.guia_d = "-";
            f.cod_camion = 0;
            f.cod_rampla = 0;
            f.cod_chofer = 0;
            f.rut = "-";
            
            
            
            //DefaultComboBoxModel modeloCombo = new DefaultComboBoxModel();
            Class.forName("org.apache.derby.jdbc.EmbeddedDriver");//prueba es base de datos
            String url = "jdbc:derby:C:/Edson;create=true;user=edson;password=edson";
            Connection conn = DriverManager.getConnection(url);
            //conn.setSchema("EDSON");
            Statement s = conn.createStatement();
            s.execute("UPDATE FACT_V SET DESCRIPCION = '" + f.descripcion + "',"
                    + " CANTIDAD = '" + f.cantidad + "',"
                    + " PRECIO_U = '" + f.precio_u + "',"
                    + " TOTAL = '" + f.total + "',"
                    + " IVA = '" + f.iva + "',"
                    + " ESPECIFICO = '" + f.especifico + "',"
                    + " EXCENTO = '" + f.excento + "',"
                    + " COND_VENTA = '" + f.cond_venta + "',"
                    + " ORDEN_C = '" + f.orden_c + "',"
                    + " GUIA_D = '" + f.guia_d + "'"
                    + " where NUM_FACTV = " + numero + " ");
            
           
            conn.close();
            JOptionPane.showMessageDialog(null, "Se ha anulado la factura  "+numero);
        
           //Limpiar Campos 
        
        

        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e);
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
                s.execute("SELECT * FROM FACT_V");
                ResultSet rs = s.getResultSet();

                while (rs.next()) {
                    modeloCombo.addElement(rs.getInt("NUM_FACTV"));
                }
                conn.close();
                cbxNumero.setModel(modeloCombo);

            } catch (Exception e) {
            }

         
        
    }//GEN-LAST:event_btnAnularActionPerformed
    

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAnular;
    private javax.swing.JComboBox cbxNumero;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    // End of variables declaration//GEN-END:variables
}
