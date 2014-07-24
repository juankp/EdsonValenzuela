/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package Frames;

import Codigo.Datos;
import Codigo.TablePacker;
import Codigo.conexion;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JDialog;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import net.sf.jasperreports.engine.JRReport;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.JasperReport;
import net.sf.jasperreports.engine.data.JRBeanCollectionDataSource;
import net.sf.jasperreports.engine.util.JRLoader;
import net.sf.jasperreports.view.JRDesignViewer;
import net.sf.jasperreports.view.JRViewer;
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
        refreshcombo();
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
        jLabel1 = new javax.swing.JLabel();
        cbxFiltro = new javax.swing.JComboBox();
        jLabel2 = new javax.swing.JLabel();
        jSpinner1 = new javax.swing.JSpinner();
        jLabel3 = new javax.swing.JLabel();
        jPanel1 = new javax.swing.JPanel();
        jLabel4 = new javax.swing.JLabel();
        cbxCliente = new javax.swing.JComboBox();
        jLabel6 = new javax.swing.JLabel();
        cbxFiltro1 = new javax.swing.JComboBox();
        jLabel7 = new javax.swing.JLabel();
        jSpinner2 = new javax.swing.JSpinner();
        jCheckBox1 = new javax.swing.JCheckBox();
        jLabel5 = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        jLabel8 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        lblneto = new javax.swing.JLabel();
        lbliva = new javax.swing.JLabel();
        lbltotal = new javax.swing.JLabel();
        btnImprimir = new javax.swing.JButton();

        setClosable(true);
        setIconifiable(true);
        setMaximizable(true);
        setResizable(true);
        setTitle("LISTA DE VENTA ::: TRANSPORTES EDSON");
        setAutoscrolls(true);

        tablaVentas.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "RAZON", "NUMERO", "COD CHOFER", "COD CAMION", "COD RAMPLA", "DESCRIPCION", "CANTIDAD", "PRECIO_U", "TOTAL", "IVA", "COND VENTA", "OC", "GUIA", "FECHA", "EXCENTO"
            }
        ));
        tablaVentas.setAutoResizeMode(javax.swing.JTable.AUTO_RESIZE_OFF);
        jScrollPane1.setViewportView(tablaVentas);

        jLabel1.setText("Filtro por fecha: ");

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

        jPanel1.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        jLabel4.setText("Cliente: ");

        cbxCliente.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        cbxCliente.setEnabled(false);
        cbxCliente.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cbxClienteActionPerformed(evt);
            }
        });

        jLabel6.setText("Mes:");

        cbxFiltro1.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "ENERO", "FEBRERO", "MARZO", "ABRIL", "MAYO", "JUNIO", "JULIO", "AGOSTO", "SEPTIEMBRE", "OCTUBRE", "NOVIEMBRE", "DICIEMBRE" }));
        cbxFiltro1.setEnabled(false);
        cbxFiltro1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cbxFiltro1ActionPerformed(evt);
            }
        });

        jLabel7.setText("Año:");

        jSpinner2.setModel(new javax.swing.SpinnerNumberModel(2014, 1992, 2100, 1));
        jSpinner2.setEnabled(false);
        jSpinner2.addChangeListener(new javax.swing.event.ChangeListener() {
            public void stateChanged(javax.swing.event.ChangeEvent evt) {
                jSpinner2StateChanged(evt);
            }
        });

        jCheckBox1.setLabel("Filtro por Cliente");
        jCheckBox1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jCheckBox1ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 53, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(cbxCliente, javax.swing.GroupLayout.PREFERRED_SIZE, 246, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jLabel6)
                .addGap(18, 18, 18)
                .addComponent(cbxFiltro1, javax.swing.GroupLayout.PREFERRED_SIZE, 129, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(31, 31, 31)
                .addComponent(jLabel7)
                .addGap(18, 18, 18)
                .addComponent(jSpinner2, javax.swing.GroupLayout.PREFERRED_SIZE, 82, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(42, Short.MAX_VALUE))
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addComponent(jCheckBox1)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addComponent(jCheckBox1)
                .addGap(32, 32, 32)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(cbxCliente, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(cbxFiltro1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel6)
                    .addComponent(jSpinner2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel7))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jLabel5.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel5.setText("Totales Tabla:");

        jLabel8.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel8.setText("Neto:");

        jLabel9.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel9.setText("I.V.A:");

        jLabel10.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel10.setText("Total:");

        lblneto.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        lblneto.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        lblneto.setText(".");

        lbliva.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        lbliva.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        lbliva.setText(".");

        lbltotal.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        lbltotal.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        lbltotal.setText(".");

        btnImprimir.setText("IMPRIMIR LISTADO");
        btnImprimir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnImprimirActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addComponent(jLabel10, javax.swing.GroupLayout.PREFERRED_SIZE, 54, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(lbltotal, javax.swing.GroupLayout.DEFAULT_SIZE, 94, Short.MAX_VALUE))
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addComponent(jLabel9, javax.swing.GroupLayout.PREFERRED_SIZE, 54, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(lbliva, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addComponent(jLabel8, javax.swing.GroupLayout.PREFERRED_SIZE, 54, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(lblneto, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(90, 90, 90)
                        .addComponent(btnImprimir)))
                .addContainerGap(110, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(18, 18, 18)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel8)
                    .addComponent(lblneto))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel9)
                    .addComponent(lbliva))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel10)
                    .addComponent(lbltotal))
                .addGap(18, 18, 18)
                .addComponent(btnImprimir)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jScrollPane1))
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
                                .addComponent(jSpinner1, javax.swing.GroupLayout.PREFERRED_SIZE, 82, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createSequentialGroup()
                                .addGap(24, 24, 24)
                                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createSequentialGroup()
                                .addGap(142, 142, 142)
                                .addComponent(jLabel5)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(0, 58, Short.MAX_VALUE)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(cbxFiltro, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel2)
                    .addComponent(jSpinner1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel3))
                .addGap(27, 27, 27)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 243, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel5)
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 22, Short.MAX_VALUE))))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnImprimirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnImprimirActionPerformed
        
            try{
            int fila = 0;
            int sumaneto=0,sumaiva=0,sumatotal=0;
            DecimalFormat formateador = new DecimalFormat("$###,###'.-'");
            List resultados = new ArrayList();
            Datos tipo;
            resultados.clear();
            for (fila = 0;  fila< tablaVentas.getRowCount(); fila++) {
                if("-".equals(tablaVentas.getValueAt(fila,6).toString())){
                    tablaVentas.setValueAt(0, fila, 6);
                    tablaVentas.setValueAt(0, fila, 7);
                    tablaVentas.setValueAt(0, fila, 8);
                    tablaVentas.setValueAt(0, fila, 9);
                }
                tipo = new Datos(String.valueOf(tablaVentas.getValueAt(fila,0)),
                       String.valueOf(tablaVentas.getValueAt(fila,1)),String.valueOf(tablaVentas.getValueAt(fila,2)),
                        String.valueOf(tablaVentas.getValueAt(fila,5)),String.valueOf(formateador.format(Integer.parseInt(tablaVentas.getValueAt(fila,8).toString()) - Integer.parseInt(tablaVentas.getValueAt(fila,9).toString()))),
                        String.valueOf(formateador.format(Integer.parseInt(tablaVentas.getValueAt(fila,9).toString()))),String.valueOf(formateador.format(Integer.parseInt(tablaVentas.getValueAt(fila,8).toString()))),
                        String.valueOf(tablaVentas.getValueAt(fila,13)),String.valueOf(tablaVentas.getValueAt(fila,12)),
                        String.valueOf(formateador.format(Integer.parseInt(tablaVentas.getValueAt(fila,8).toString()))));
                        if((!"-".equals(tablaVentas.getValueAt(fila,6).toString())) && (!"-".equals(tablaVentas.getValueAt(fila,7).toString())) && (!"-".equals(tablaVentas.getValueAt(fila,8).toString()) ) && (!"-".equals(tablaVentas.getValueAt(fila,9).toString()))){
                        sumaneto = sumaneto +(Integer.parseInt(tablaVentas.getValueAt(fila,8).toString()) - Integer.parseInt(tablaVentas.getValueAt(fila,9).toString()));
                        sumaiva = sumaiva + Integer.parseInt(tablaVentas.getValueAt(fila,9).toString());
                        sumatotal = sumatotal + Integer.parseInt(tablaVentas.getValueAt(fila,8).toString());
                        
                         }
                resultados.add(tipo);
            }
            Map parametro = new HashMap();
            parametro.put("sumneto",formateador.format(sumaneto));
            parametro.put("sumiva",formateador.format(sumaiva));
            parametro.put("sumtotal",formateador.format(sumatotal));
            parametro.put("Mes", cbxFiltro.getSelectedItem());
            parametro.put("Año", jSpinner1.getValue().toString());
            String ubicacion = System.getProperty("user.dir")+"/src/Reportes/VentasFiltradas.jasper";
           
            JasperReport jasperReport = (JasperReport) JRLoader.loadObject(ubicacion);
            JasperPrint print = JasperFillManager.fillReport(jasperReport, parametro, new JRBeanCollectionDataSource(resultados));
            JasperViewer view = new JasperViewer(print,false);
            view.setVisible(true);
           }catch (Exception e){
               
               JOptionPane.showMessageDialog(this, e);
           }
            
           
        
    }//GEN-LAST:event_btnImprimirActionPerformed

    private void cbxFiltroActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cbxFiltroActionPerformed
        limpiarTabla(tablaVentas);
        refreshtabla();
        new TablePacker(TablePacker.ALL_ROWS, true).pack(tablaVentas);
        new TablePacker(TablePacker.ALL_ROWS, true).pack(tablaVentas);
        calculos();
    }//GEN-LAST:event_cbxFiltroActionPerformed

    private void jSpinner1StateChanged(javax.swing.event.ChangeEvent evt) {//GEN-FIRST:event_jSpinner1StateChanged
        limpiarTabla(tablaVentas);
        refreshtabla();
        new TablePacker(TablePacker.ALL_ROWS, true).pack(tablaVentas);
        new TablePacker(TablePacker.ALL_ROWS, true).pack(tablaVentas);
        calculos();
    }//GEN-LAST:event_jSpinner1StateChanged

    private void cbxClienteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cbxClienteActionPerformed

        limpiarTabla(tablaVentas);
        porCliente();
        new TablePacker(TablePacker.ALL_ROWS, true).pack(tablaVentas);
        new TablePacker(TablePacker.ALL_ROWS, true).pack(tablaVentas);
        calculos();
    }//GEN-LAST:event_cbxClienteActionPerformed

    private void cbxFiltro1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cbxFiltro1ActionPerformed
        limpiarTabla(tablaVentas);
        porCliente();
        new TablePacker(TablePacker.ALL_ROWS, true).pack(tablaVentas);
        new TablePacker(TablePacker.ALL_ROWS, true).pack(tablaVentas);
        calculos();
    }//GEN-LAST:event_cbxFiltro1ActionPerformed

    private void jSpinner2StateChanged(javax.swing.event.ChangeEvent evt) {//GEN-FIRST:event_jSpinner2StateChanged
        limpiarTabla(tablaVentas);
        porCliente();
        new TablePacker(TablePacker.ALL_ROWS, true).pack(tablaVentas);
        new TablePacker(TablePacker.ALL_ROWS, true).pack(tablaVentas);
        calculos();
    }//GEN-LAST:event_jSpinner2StateChanged

    private void jCheckBox1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jCheckBox1ActionPerformed
       if(jCheckBox1.isSelected()){
           cbxCliente.setEnabled(true);
           cbxFiltro1.setEnabled(true);
           jSpinner2.setEnabled(true);
       }
       else{
           cbxCliente.setEnabled(false);
           cbxFiltro1.setEnabled(false);
           jSpinner2.setEnabled(false);
       }
               
    }//GEN-LAST:event_jCheckBox1ActionPerformed
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
    public void refreshcombo() {
            
               
            try {
                DefaultComboBoxModel modeloCombo = new DefaultComboBoxModel();
                Class.forName("org.apache.derby.jdbc.EmbeddedDriver");//prueba es base de datos
            String url = "jdbc:derby:C:/Edson;create=true;user=edson;password=edson";
            Connection conn = DriverManager.getConnection(url);
            //conn.setSchema("EDSON");
                Statement s = conn.createStatement();
                s.execute("SELECT * FROM CLIENTE");
                ResultSet rs = s.getResultSet();

                while (rs.next()) {
                    modeloCombo.addElement(rs.getObject("RAZON"));
                }
                conn.close();
                cbxCliente.setModel(modeloCombo);
               
            } catch (ClassNotFoundException | SQLException e) {
                JOptionPane.showMessageDialog(null, e);
            }

    }    
    public void porCliente(){
        int ano = Integer.parseInt(jSpinner2.getValue().toString());
        int mes = 0;
        if(cbxFiltro1.getSelectedItem()== "ENERO"){
            mes = 1;
            }
        else{
        if(cbxFiltro1.getSelectedItem()=="FEBRERO"){
            mes = 2;}
        if(cbxFiltro1.getSelectedItem()=="MARZO"){
            mes = 3;}
        if(cbxFiltro1.getSelectedItem()=="ABRIL"){
            mes = 4;}
        if(cbxFiltro1.getSelectedItem()=="MAYO"){
            mes = 5;}
        if(cbxFiltro1.getSelectedItem()=="JUNIO"){
            mes = 6;}
        if(cbxFiltro1.getSelectedItem()=="JULIO"){
            mes = 7;}
        if(cbxFiltro1.getSelectedItem()=="AGOSTO"){
            mes = 8;}
        if(cbxFiltro1.getSelectedItem()=="SEPTIEMBRE"){
            mes = 9;}
        if(cbxFiltro1.getSelectedItem()=="OCTUBRE"){
            mes = 10;}
        if(cbxFiltro1.getSelectedItem()=="NOVIEMBRE"){
            mes = 11;}
        if(cbxFiltro1.getSelectedItem()=="DICIEMBRE"){
            mes = 12;}
        
        }
        try {
             ArrayList<Object[]> data = new ArrayList<>();
            String rut = "";
            Class.forName("org.apache.derby.jdbc.EmbeddedDriver");//prueba es base de datos
            String url = "jdbc:derby:C:/Edson;create=true;user=edson;password=edson";
            Connection conn = DriverManager.getConnection(url);
            //conn.setSchema("EDSON");
            Statement s = conn.createStatement();
            Statement s2 = conn.createStatement();
            s2.execute("SELECT RUT,RAZON FROM CLIENTE WHERE RAZON = '"+cbxCliente.getSelectedItem().toString()+"'");
            ResultSet rs2 = s2.getResultSet();
            data.clear();
            while(rs2.next()){
                 rut = rs2.getString("RUT");
            }
          
//            s.execute("SELECT RAZON,NUM_FACTV,RUT,COD_CHOFER,COD_CAMION,COD_RAMPLA,DESCRIPCION,CANTIDAD,PRECIO_U,TOTAL,IVA,COND_VENTA,ORDEN_C,GUIA_D,FECHA,EXCENTO FROM FACT_V INNER JOIN "
//                    + "WHERE RUT IN (SELECT RUT FROM FACT_V WHERE RUT ='"+rut+"')");
               s.execute("SELECT RAZON,NUM_FACTV,COD_CHOFER,COD_CAMION,COD_RAMPLA,DESCRIPCION,CANTIDAD,PRECIO_U,TOTAL,IVA,COND_VENTA,ORDEN_C,GUIA_D,FECHA,EXCENTO FROM EDSON.CLIENTE JOIN "
                    + "EDSON.FACT_V ON CLIENTE.RUT = FACT_V.RUT WHERE RAZON = '"+cbxCliente.getSelectedItem().toString()+"' AND MONTH(FECHA) = "+mes+" AND YEAR(FECHA) = "+ano+"ORDER BY NUM_FACTV");
            
            ResultSet rs = s.getResultSet();
            rsm = rs.getMetaData();
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
            conn.close();
        } catch (ClassNotFoundException | SQLException e) {
            JOptionPane.showMessageDialog(rootPane, e.getMessage());
        }
    }
    public void calculos(){
        int fila = 0;
        DecimalFormat formateador = new DecimalFormat("$###,###'.-'");
        int sumaneto=0,sumaiva=0,sumatotal=0;
        for (fila = 0;  fila< tablaVentas.getRowCount(); fila++) {
                    if(!"-".equals(tablaVentas.getValueAt(fila,6).toString()) && (!"-".equals(tablaVentas.getValueAt(fila,7).toString())) && (!"-".equals(tablaVentas.getValueAt(fila,8).toString()) ) && (!"-".equals(tablaVentas.getValueAt(fila,9).toString()))) {
                        sumaneto = sumaneto + Integer.parseInt(tablaVentas.getValueAt(fila,8).toString()) - Integer.parseInt(tablaVentas.getValueAt(fila,9).toString());
                        sumaiva = sumaiva + Integer.parseInt(tablaVentas.getValueAt(fila,9).toString());
                        sumatotal = sumatotal + Integer.parseInt(tablaVentas.getValueAt(fila,8).toString());
            }
                    }
        lblneto.setText(formateador.format(sumaneto));
        lbliva.setText(formateador.format(sumaiva));
        lbltotal.setText(formateador.format(sumatotal));
        
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
           // s.execute("SELECT NUM_FACTV,RUT,COD_CHOFER,COD_CAMION,COD_RAMPLA,DESCRIPCION,CANTIDAD,PRECIO_U,TOTAL,IVA,COND_VENTA,ORDEN_C,GUIA_D,FECHA,EXCENTO FROM FACT_V WHERE MONTH(FECHA) = "+mes+" AND YEAR(FECHA) = "+ano+"");
            s.execute("SELECT RAZON,NUM_FACTV,COD_CHOFER,COD_CAMION,COD_RAMPLA,DESCRIPCION,CANTIDAD,PRECIO_U,TOTAL,IVA,COND_VENTA,ORDEN_C,GUIA_D,FECHA,EXCENTO FROM EDSON.CLIENTE JOIN "
                    + "EDSON.FACT_V ON CLIENTE.RUT = FACT_V.RUT WHERE MONTH(FECHA) = "+mes+" AND YEAR(FECHA) = "+ano+" ORDER BY NUM_FACTV");
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
            conn.close();
            
             
        } catch (ClassNotFoundException | SQLException e) {
            JOptionPane.showMessageDialog(rootPane, e.getMessage());
        }
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnImprimir;
    private javax.swing.JComboBox cbxCliente;
    private javax.swing.JComboBox cbxFiltro;
    private javax.swing.JComboBox cbxFiltro1;
    private javax.swing.JCheckBox jCheckBox1;
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
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JSpinner jSpinner1;
    private javax.swing.JSpinner jSpinner2;
    private javax.swing.JLabel lbliva;
    private javax.swing.JLabel lblneto;
    private javax.swing.JLabel lbltotal;
    private javax.swing.JTable tablaVentas;
    // End of variables declaration//GEN-END:variables
}
