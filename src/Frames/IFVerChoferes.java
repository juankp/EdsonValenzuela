/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package Frames;

import Codigo.conexion;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.JasperReport;
import net.sf.jasperreports.engine.util.JRLoader;
import net.sf.jasperreports.view.JasperViewer;

/**
 *
 * @author Yo elijo mi pc
 */
public class IFVerChoferes extends javax.swing.JInternalFrame {

     Connection cn;
    PreparedStatement ps;
    ResultSet rs;
    ResultSetMetaData rsm;
    DefaultTableModel dtm;
    public IFVerChoferes() {
        initComponents();
        refreshtabla();
        conexion con = new conexion();
        con.conectar();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        TablaChofer = new javax.swing.JTable();
        btnGenerar = new javax.swing.JButton();

        setClosable(true);
        setIconifiable(true);
        setMaximizable(true);
        setResizable(true);
        setTitle("LISTA DE CHOFERES ::: TRANSPORTES EDSON");

        TablaChofer.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null}
            },
            new String [] {
                "CODIGO", "RUT", "NOMBRE", "APELLIDO", "FONO"
            }
        ));
        jScrollPane1.setViewportView(TablaChofer);

        btnGenerar.setText("GENERAR");
        btnGenerar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnGenerarActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 714, Short.MAX_VALUE)
                .addContainerGap())
            .addGroup(layout.createSequentialGroup()
                .addGap(330, 330, 330)
                .addComponent(btnGenerar)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 282, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 29, Short.MAX_VALUE)
                .addComponent(btnGenerar)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnGenerarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnGenerarActionPerformed
        try {
            Class.forName("org.apache.derby.jdbc.ClientDriver");
            String url = "jdbc:derby://localhost/Edson;create=true;user=edson;password=edson";
            Connection conn = DriverManager.getConnection(url);
            conn.setSchema("EDSON");
            
            String ubicacion = System.getProperty("user.dir")+"/src/Reportes/chofer.jasper";
            JasperReport jasperReport = (JasperReport) JRLoader.loadObject(ubicacion);
            JasperPrint print = JasperFillManager.fillReport(jasperReport, null,conn);
            JasperViewer view = new JasperViewer(print,false);
            view.setVisible(true);
            
           
        } catch (Exception e) {
            JOptionPane.showMessageDialog(this, e);
        }
    }//GEN-LAST:event_btnGenerarActionPerformed
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
    public void refreshtabla(){
        limpiarTabla(TablaChofer);
        try {
            
            Class.forName("org.apache.derby.jdbc.ClientDriver");
            String url = "jdbc:derby://localhost/Edson;create=true;user=edson;password=edson";
            Connection conn = DriverManager.getConnection(url);
            conn.setSchema("EDSON");
            Statement s = conn.createStatement();
            s.execute("SELECT COD_CHOFER,RUT,NOMBRE,APELLIDO,FONO FROM CHOFER");
            
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
            dtm = (DefaultTableModel)this.TablaChofer.getModel();
            for (int i = 0; i < data.size(); i++) {
                dtm.addRow(data.get(i));
                
            }
        } catch (ClassNotFoundException | SQLException e) {
            JOptionPane.showMessageDialog(rootPane, e.getMessage());
        }
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTable TablaChofer;
    private javax.swing.JButton btnGenerar;
    private javax.swing.JScrollPane jScrollPane1;
    // End of variables declaration//GEN-END:variables
}
