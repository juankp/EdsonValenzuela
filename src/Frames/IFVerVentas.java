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
public class IFVerVentas extends javax.swing.JInternalFrame {

     Connection cn;
    PreparedStatement ps;
    ResultSet rs;
    ResultSetMetaData rsm;
    DefaultTableModel dtm;
    public IFVerVentas() {
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
        tablaVentas = new javax.swing.JTable();
        btnImprimir = new javax.swing.JButton();

        setClosable(true);
        setIconifiable(true);
        setMaximizable(true);
        setResizable(true);
        setTitle("LISTA DE VENTA ::: TRANSPORTES EDSON");

        tablaVentas.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "NUMERO", "RUT", "COD CHOFER", "COD CAMION", "COD RAMPLA", "DESCRIPCION", "CANTIDAD", "PRECIO_U", "TOTAL", "IVA", "ESPECIFICO", "EXCENTO", "COND VENTA", "OC", "GUIA", "FECHA"
            }
        ));
        jScrollPane1.setViewportView(tablaVentas);

        btnImprimir.setText("IMPRIMIR LISTADO");
        btnImprimir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnImprimirActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 569, Short.MAX_VALUE)
                .addContainerGap())
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(btnImprimir)
                .addGap(243, 243, 243))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 311, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 22, Short.MAX_VALUE)
                .addComponent(btnImprimir)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnImprimirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnImprimirActionPerformed
        try {
            Class.forName("org.apache.derby.jdbc.ClientDriver");
            String url = "jdbc:derby://localhost/Edson;create=true;user=edson;password=edson";
            Connection conn = DriverManager.getConnection(url);
            conn.setSchema("EDSON");
            
            String ubicacion = System.getProperty("user.dir")+"/src/Reportes/venta.jasper";
            JasperReport jasperReport = (JasperReport) JRLoader.loadObject(ubicacion);
            JasperPrint print = JasperFillManager.fillReport(jasperReport, null,conn);
            JasperViewer view = new JasperViewer(print,false);
            view.setVisible(true);
            
           
        } catch (Exception e) {
            JOptionPane.showMessageDialog(this, e);
        }
    }//GEN-LAST:event_btnImprimirActionPerformed
    public void refreshtabla(){
        
        try {
            
            Class.forName("org.apache.derby.jdbc.ClientDriver");
            String url = "jdbc:derby://localhost/Edson;create=true;user=edson;password=edson";
            Connection conn = DriverManager.getConnection(url);
            conn.setSchema("EDSON");
            Statement s = conn.createStatement();
            s.execute("SELECT NUM_FACTV,RUT,COD_CHOFER,COD_CAMION,COD_RAMPLA,DESCRIPCION,CANTIDAD,PRECIO_U,IVA,TOTAL,ESPECIFICO,EXCENTO,COND_VENTA,ORDEN_C,GUIA_D,FECHA FROM FACT_V");
            
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
            dtm = (DefaultTableModel)this.tablaVentas.getModel();
            for (int i = 0; i < data.size(); i++) {
                dtm.addRow(data.get(i));
                
            }
        } catch (ClassNotFoundException | SQLException e) {
            JOptionPane.showMessageDialog(rootPane, e.getMessage());
        }
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnImprimir;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable tablaVentas;
    // End of variables declaration//GEN-END:variables
}