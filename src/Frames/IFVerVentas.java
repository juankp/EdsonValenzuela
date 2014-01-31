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
        jLabel1 = new javax.swing.JLabel();
        cbxFiltro = new javax.swing.JComboBox();
        jLabel2 = new javax.swing.JLabel();
        jSpinner1 = new javax.swing.JSpinner();
        jLabel3 = new javax.swing.JLabel();

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

        jLabel1.setText("Filtrar: ");

        cbxFiltro.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "ENERO", "FEBRERO", "MARZO", "ABRIL", "MAYO", "JUNIO", "JULIO", "AGOSTO", "SEPTIEMBRE", "OCTUBRE", "NOVIEMBRE", "DICIEMBRE" }));
        cbxFiltro.setSelectedIndex(-1);
        cbxFiltro.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cbxFiltroActionPerformed(evt);
            }
        });

        jLabel2.setText("Mes:");

        jSpinner1.setModel(new javax.swing.SpinnerNumberModel(2014, 1992, 2100, 1));
        jSpinner1.addChangeListener(new javax.swing.event.ChangeListener() {
            public void stateChanged(javax.swing.event.ChangeEvent evt) {
                jSpinner1StateChanged(evt);
            }
        });

        jLabel3.setText("Año:");

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
                .addGap(217, 217, 217))
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(23, 23, 23)
                        .addComponent(jLabel1))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(24, 24, 24)
                        .addComponent(jLabel2)
                        .addGap(18, 18, 18)
                        .addComponent(cbxFiltro, javax.swing.GroupLayout.PREFERRED_SIZE, 129, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(31, 31, 31)
                        .addComponent(jLabel3)
                        .addGap(18, 18, 18)
                        .addComponent(jSpinner1, javax.swing.GroupLayout.PREFERRED_SIZE, 82, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(cbxFiltro, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel2)
                    .addComponent(jSpinner1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel3))
                .addGap(19, 19, 19)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 263, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(btnImprimir)
                .addContainerGap(25, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnImprimirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnImprimirActionPerformed
        try {
            Class.forName("org.apache.derby.jdbc.EmbeddedDriver");//prueba es base de datos
            String url = "jdbc:derby:C:/Edson;create=true;user=edson;password=edson";
            Connection conn = DriverManager.getConnection(url);
            //conn.setSchema("EDSON");
            
            String ubicacion = System.getProperty("user.dir")+"/src/Reportes/venta.jasper";
            JasperReport jasperReport = (JasperReport) JRLoader.loadObject(ubicacion);
            JasperPrint print = JasperFillManager.fillReport(jasperReport, null,conn);
            JasperViewer view = new JasperViewer(print,false);
            view.setVisible(true);
            
           
        } catch (Exception e) {
            JOptionPane.showMessageDialog(this, e);
        }
    }//GEN-LAST:event_btnImprimirActionPerformed

    private void cbxFiltroActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cbxFiltroActionPerformed
        limpiarTabla(tablaVentas);
        refreshtabla();
    }//GEN-LAST:event_cbxFiltroActionPerformed

    private void jSpinner1StateChanged(javax.swing.event.ChangeEvent evt) {//GEN-FIRST:event_jSpinner1StateChanged
        limpiarTabla(tablaVentas);
        refreshtabla();
    }//GEN-LAST:event_jSpinner1StateChanged
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
        
        int ano = Integer.parseInt(jSpinner1.getValue().toString());
        int mes = 0;
        if(cbxFiltro.getSelectedItem()== "ENERO"){
            mes = 1;
            }
        else{
        if(cbxFiltro.getSelectedItem()=="FEBRERO"){
            mes = 2;}
        if(cbxFiltro.getSelectedItem()=="MARZO"){
            mes = 3;}
        if(cbxFiltro.getSelectedItem()=="ABRIL"){
            mes = 4;}
        if(cbxFiltro.getSelectedItem()=="MAYO"){
            mes = 5;}
        if(cbxFiltro.getSelectedItem()=="JUNIO"){
            mes = 6;}
        if(cbxFiltro.getSelectedItem()=="JULIO"){
            mes = 7;}
        if(cbxFiltro.getSelectedItem()=="AGOSTO"){
            mes = 8;}
        if(cbxFiltro.getSelectedItem()=="SEPTIEMBRE"){
            mes = 9;}
        if(cbxFiltro.getSelectedItem()=="OCTUBRE"){
            mes = 10;}
        if(cbxFiltro.getSelectedItem()=="NOVIEMBRE"){
            mes = 11;}
        if(cbxFiltro.getSelectedItem()=="DICIEMBRE"){
            mes = 12;}
        
        }
        try {
            
            Class.forName("org.apache.derby.jdbc.EmbeddedDriver");//prueba es base de datos
            String url = "jdbc:derby:C:/Edson;create=true;user=edson;password=edson";
            Connection conn = DriverManager.getConnection(url);
            //conn.setSchema("EDSON");
            Statement s = conn.createStatement();
            s.execute("SELECT NUM_FACTV,RUT,COD_CHOFER,COD_CAMION,COD_RAMPLA,DESCRIPCION,CANTIDAD,PRECIO_U,IVA,TOTAL,ESPECIFICO,EXCENTO,COND_VENTA,ORDEN_C,GUIA_D,FECHA FROM FACT_V WHERE MONTH(FECHA) = "+mes+" AND YEAR(FECHA) = "+ano+"");
            
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
    private javax.swing.JComboBox cbxFiltro;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JSpinner jSpinner1;
    private javax.swing.JTable tablaVentas;
    // End of variables declaration//GEN-END:variables
}
