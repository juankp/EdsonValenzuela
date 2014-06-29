/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package Frames;

import Codigo.camion;
import java.awt.HeadlessException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Yo elijo mi pc
 */
public class IFIngresoCamion extends javax.swing.JInternalFrame {

    ResultSetMetaData rsm;
    DefaultTableModel dtm;
    public IFIngresoCamion() {
        initComponents();
        refreshtabla();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        txtPatente = new javax.swing.JTextField();
        txtAnio = new javax.swing.JTextField();
        txtMarca = new javax.swing.JTextField();
        txtModelo = new javax.swing.JTextField();
        btnIngresar = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();

        setClosable(true);
        setIconifiable(true);
        setMaximizable(true);
        setTitle("INGRESO CAMIONES ::: TRANSPORTES EDSON");

        jLabel2.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel2.setText("Patente:");

        jLabel3.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel3.setText("Marca: ");

        jLabel4.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel4.setText("Modelo:");

        jLabel5.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel5.setText("Año:");

        txtAnio.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtAnioKeyTyped(evt);
            }
        });

        btnIngresar.setText("INGRESAR");
        btnIngresar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnIngresarActionPerformed(evt);
            }
        });

        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null}
            },
            new String [] {
                "Codigo", "Patente", "Marca", "Modelo", "Año"
            }
        ));
        jScrollPane1.setViewportView(jTable1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(41, 41, 41)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel2)
                        .addGap(18, 18, 18)
                        .addComponent(txtPatente, javax.swing.GroupLayout.PREFERRED_SIZE, 77, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(26, 26, 26))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(0, 0, Short.MAX_VALUE)
                                .addComponent(btnIngresar))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel3)
                                .addGap(25, 25, 25)
                                .addComponent(txtMarca, javax.swing.GroupLayout.PREFERRED_SIZE, 77, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(0, 0, Short.MAX_VALUE)))
                        .addGap(29, 29, 29)))
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel5)
                        .addGap(18, 18, 18)
                        .addComponent(txtAnio, javax.swing.GroupLayout.PREFERRED_SIZE, 77, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel4)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txtModelo, javax.swing.GroupLayout.PREFERRED_SIZE, 77, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(layout.createSequentialGroup()
                .addGap(26, 26, 26)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 452, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(31, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(41, 41, 41)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel2)
                            .addComponent(jLabel5)))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(txtAnio, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtPatente, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(jLabel4)
                    .addComponent(txtMarca, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtModelo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(33, 33, 33)
                .addComponent(btnIngresar)
                .addGap(18, 18, 18)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 133, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(81, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents
    public void limpiarTabla(JTable tabla){
        try {
	            DefaultTableModel modelo=(DefaultTableModel) tabla.getModel();
	            int filas=tabla.getRowCount();
	            for (int i = 0;filas>i; i++) {
	                modelo.removeRow(0);
	            }
	        } catch (Exception e) {
	            JOptionPane.showMessageDialog(null, "Error al limpiar la tabla.");
	        }
	    }
        
        //refrescar tabla 
        public void refreshtabla(){
        limpiarTabla(jTable1);
        try {
            
            Class.forName("org.apache.derby.jdbc.EmbeddedDriver");
            String url = "jdbc:derby:C:/Edson;create=true;user=edson;password=edson";
            Connection conn = DriverManager.getConnection(url);
            //conn.setSchema("EDSON");
            Statement s = conn.createStatement();
            s.execute("SELECT * FROM CAMION");
            
            ResultSet rs = s.getResultSet();
            rsm = rs.getMetaData();
            ArrayList<Object[]> data = new ArrayList<>();
            data.clear();
            while(rs.next()){
                Object[] rows = new Object[rsm.getColumnCount()];
                for(int i=0;i< rows.length;i++){
                    rows[i]=rs.getObject(i+1);
                    
                }
                
                data.add(rows);
                
            }
            dtm = (DefaultTableModel)this.jTable1.getModel();
            for (int i = 0; i < data.size(); i++) {
                dtm.addRow(data.get(i));
                
            }
        } catch (ClassNotFoundException | SQLException e) {
            JOptionPane.showMessageDialog(rootPane, e.getMessage());
        }
    }
    private void btnIngresarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnIngresarActionPerformed
       
        try {
            camion nuevo = new camion();
            
            nuevo.patente = txtPatente.getText().toUpperCase();
            nuevo.modelo = txtModelo.getText().toUpperCase();
            nuevo.marca = txtMarca.getText().toUpperCase();
            nuevo.anio = txtAnio.getText().toUpperCase();
            
            Class.forName("org.apache.derby.jdbc.EmbeddedDriver");//prueba es base de datos

            String url = "jdbc:derby:C:/Edson;create=true;user=edson;password=edson";
            Connection conn = DriverManager.getConnection(url);
            //conn.setSchema("EDSON");
            Statement s = conn.createStatement();
            s.execute("INSERT INTO CAMION (PATENTE,MARCA,MODELO,ANIO) VALUES ('"+nuevo.patente+"','"+nuevo.marca+"','"+nuevo.modelo+"','"+nuevo.anio+"')");
            ResultSet rs = s.getResultSet();

            refreshtabla();
            limpiarTabla(jTable1);
            refreshtabla();
            JOptionPane.showMessageDialog(null, "Se ha Ingresado correctamente el camion");

            txtAnio.setText(" ");
            txtMarca.setText(" ");
            txtModelo.setText(" ");
            txtPatente.setText(" ");
           
            conn.close();
        } catch (ClassNotFoundException | SQLException | HeadlessException e) {
            JOptionPane.showMessageDialog(this, e);
        }
            
    }//GEN-LAST:event_btnIngresarActionPerformed

    private void txtAnioKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtAnioKeyTyped
       char car = evt.getKeyChar();
        if((car<'0' || car>'9')) evt.consume();
    }//GEN-LAST:event_txtAnioKeyTyped


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnIngresar;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTable1;
    private javax.swing.JTextField txtAnio;
    private javax.swing.JTextField txtMarca;
    private javax.swing.JTextField txtModelo;
    private javax.swing.JTextField txtPatente;
    // End of variables declaration//GEN-END:variables
}
