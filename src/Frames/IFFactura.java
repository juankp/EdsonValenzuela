/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Frames;

import Codigo.Numero_a_Letra;
import Codigo.factura;
import java.awt.HeadlessException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.DecimalFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.table.DefaultTableModel;
import net.sf.jasperreports.engine.JREmptyDataSource;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.JasperReport;
import net.sf.jasperreports.engine.data.JRBeanCollectionDataSource;
import net.sf.jasperreports.engine.util.JRLoader;
import net.sf.jasperreports.view.JasperViewer;

/**
 *
 * @author Yo elijo mi pc
 */
public class IFFactura extends javax.swing.JInternalFrame {
    
    
    private  Numero_a_Letra NL = new  Numero_a_Letra();
    int codigo,codigo2,codigo3,codigo4;
   
    
    public IFFactura() throws ClassNotFoundException, SQLException {
        initComponents();
        JScrollPane scrollPane = new JScrollPane();
        scrollPane.add(this);
        refreshcombo();
        refreshcombo2();
        refreshcombo3();
        refreshcombo4();
       
       SpinCant.setValue(1);
        
        try {

            Class.forName("org.apache.derby.jdbc.EmbeddedDriver");//prueba es base de datos
            String url = "jdbc:derby:C:/Edson;create=true;user=edson;password=edson";
            Connection conn = DriverManager.getConnection(url);
            //conn.setSchema("EDSON");
            Statement s = conn.createStatement();
            s.execute("SELECT NUM_FACTV FROM FACT_V");
            ResultSet rs = s.getResultSet();

            while (rs.next()) {

                txtnumero.setText(rs.getString("NUM_FACTV"));
            }
            conn.close();
        } catch (ClassNotFoundException | SQLException e) {
            JOptionPane.showMessageDialog(null, "error: " + e);
        }
        
    }
    
    public void refreshcombo() { // LLENA EL COMBOBOX DE SEÑOR
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
                cbxsenores.setModel(modeloCombo);

            } catch (Exception e) {
                JOptionPane.showMessageDialog(null, "error: " + e);
            }
    }
    
    public void refreshcombo2() { //LLENA EL COMBOBOX DE CHOFER
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
                    modeloCombo.addElement(rs.getObject("NOMBRE"));
                }
               
                
                conn.close();
                cbxChofer.setModel(modeloCombo);

            } catch (Exception e) {
                JOptionPane.showMessageDialog(null, "error: " + e);
            }
    }
    
    public void refreshcombo3() { //LLENA EL COMBOBOX DE CAMION
            try {
                DefaultComboBoxModel modeloCombo = new DefaultComboBoxModel();
               Class.forName("org.apache.derby.jdbc.EmbeddedDriver");//prueba es base de datos
            String url = "jdbc:derby:C:/Edson;create=true;user=edson;password=edson";
            Connection conn = DriverManager.getConnection(url);
            //conn.setSchema("EDSON");
                Statement s = conn.createStatement();
                s.execute("SELECT * FROM CAMION");
                ResultSet rs = s.getResultSet();

                while (rs.next()) {
                    modeloCombo.addElement(rs.getObject("PATENTE"));
                }
                
                conn.close();
                cbxcamion.setModel(modeloCombo);

            } catch (Exception e) {
                JOptionPane.showMessageDialog(null, "error: " + e);
            }
    }
    
    public void refreshcombo4() { //LLENA EL COMBOBOX DE CHOFER
        
            try {
                DefaultComboBoxModel modeloCombo = new DefaultComboBoxModel();
                Class.forName("org.apache.derby.jdbc.EmbeddedDriver");//prueba es base de datos
            String url = "jdbc:derby:C:/Edson;create=true;user=edson;password=edson";
            Connection conn = DriverManager.getConnection(url);
            //conn.setSchema("EDSON");
                Statement s = conn.createStatement();
                s.execute("SELECT * FROM RAMPLA");
                ResultSet rs = s.getResultSet();
                
                while (rs.next()) {
                    modeloCombo.addElement(rs.getObject("PATENTE"));
                }
                
                
                conn.close();
                cbxrampla.setModel(modeloCombo);

            } catch (Exception e) {
                JOptionPane.showMessageDialog(null, "error: " + e);
            }
    }
    public int obtenerCodigoChofer()
    {
        String chofer;
        chofer = cbxChofer.getSelectedItem().toString();
        try {
                
                Class.forName("org.apache.derby.jdbc.EmbeddedDriver");//prueba es base de datos
            String url = "jdbc:derby:C:/Edson;create=true;user=edson;password=edson";
            Connection conn = DriverManager.getConnection(url);
            //conn.setSchema("EDSON");
                Statement s = conn.createStatement();
                s.execute("SELECT * FROM CHOFER WHERE NOMBRE = '" + chofer + "'");
                ResultSet rs = s.getResultSet();
                
                while (rs.next()) {
                    codigo2 = rs.getInt("COD_CHOFER");
                }
                
                conn.close();
                
            } catch (ClassNotFoundException | SQLException e) {
                JOptionPane.showMessageDialog(null, "error: " + e);
            }
        return codigo2;
    }
    
    public int obtenerCodigoCamion()
    {
        String chofer;
        chofer = cbxcamion.getSelectedItem().toString();
        try {
                
                Class.forName("org.apache.derby.jdbc.EmbeddedDriver");//prueba es base de datos
            String url = "jdbc:derby:C:/Edson;create=true;user=edson;password=edson";
            Connection conn = DriverManager.getConnection(url);
            //conn.setSchema("EDSON");
                Statement s = conn.createStatement();
                s.execute("SELECT * FROM CAMION WHERE PATENTE = '"+ chofer +"'");
                ResultSet rs = s.getResultSet();
                
                while (rs.next()) {
                    codigo3 = rs.getInt("COD_CAMION");
                }
                
                conn.close();
                
            } catch (ClassNotFoundException | SQLException e) {
                JOptionPane.showMessageDialog(null, "error: " + e);
            }
        return codigo3;
        
    }
    public int obtenerCodigoRampla()
    {
        String chofer;
        chofer = cbxrampla.getSelectedItem().toString();
        try {
                
                Class.forName("org.apache.derby.jdbc.EmbeddedDriver");//prueba es base de datos
            String url = "jdbc:derby:C:/Edson;create=true;user=edson;password=edson";
            Connection conn = DriverManager.getConnection(url);
            //conn.setSchema("EDSON");
                Statement s = conn.createStatement();
                s.execute("SELECT * FROM RAMPLA WHERE PATENTE = '"+ chofer +"'");
                ResultSet rs = s.getResultSet();
                
                while (rs.next()) {
                    codigo4 = rs.getInt("COD_RAMPLA");
                }
                
                conn.close();
                
            } catch (ClassNotFoundException | SQLException e) {
                JOptionPane.showMessageDialog(null, "error: " + e);
            }
        return codigo4;
    }
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane2 = new javax.swing.JScrollPane();
        jScrollPane3 = new javax.swing.JScrollPane();
        jScrollPane4 = new javax.swing.JScrollPane();
        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        txtnumero = new javax.swing.JTextField();
        jPanel2 = new javax.swing.JPanel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();
        jLabel13 = new javax.swing.JLabel();
        jLabel14 = new javax.swing.JLabel();
        cbxsenores = new javax.swing.JComboBox();
        txtdireccion = new javax.swing.JTextField();
        txtgiro = new javax.swing.JTextField();
        txtcond = new javax.swing.JTextField();
        txtrut = new javax.swing.JTextField();
        txtcomuna = new javax.swing.JTextField();
        txttelefono = new javax.swing.JTextField();
        txtguia = new javax.swing.JTextField();
        txtciudad = new javax.swing.JTextField();
        txtoc = new javax.swing.JTextField();
        jLabel15 = new javax.swing.JLabel();
        cbxChofer = new javax.swing.JComboBox();
        jLabel16 = new javax.swing.JLabel();
        cbxcamion = new javax.swing.JComboBox();
        jLabel17 = new javax.swing.JLabel();
        cbxrampla = new javax.swing.JComboBox();
        jDateChooser1 = new com.toedter.calendar.JDateChooser();
        jPanel3 = new javax.swing.JPanel();
        btnIngresar = new javax.swing.JButton();
        btnGenerar = new javax.swing.JButton();
        btnLimpiar = new javax.swing.JButton();
        txtTotal = new javax.swing.JTextField();
        Txtiva = new javax.swing.JTextField();
        jLabel26 = new javax.swing.JLabel();
        jLabel25 = new javax.swing.JLabel();
        jLabel24 = new javax.swing.JLabel();
        txtSubtotal = new javax.swing.JTextField();
        jScrollPane1 = new javax.swing.JScrollPane();
        tablaFactura = new javax.swing.JTable();
        btnQuitarFila = new javax.swing.JButton();
        jPanel4 = new javax.swing.JPanel();
        jLabel20 = new javax.swing.JLabel();
        jLabel27 = new javax.swing.JLabel();
        jLabel23 = new javax.swing.JLabel();
        SpinCant = new javax.swing.JSpinner();
        jLabel22 = new javax.swing.JLabel();
        txtPreciou = new javax.swing.JTextField();
        jLabel21 = new javax.swing.JLabel();
        btnAgregar = new javax.swing.JButton();
        jScrollPane5 = new javax.swing.JScrollPane();
        txtDesc = new javax.swing.JTextArea();
        ChboxExcento = new javax.swing.JCheckBox();

        jScrollPane2.setHorizontalScrollBarPolicy(javax.swing.ScrollPaneConstants.HORIZONTAL_SCROLLBAR_ALWAYS);
        jScrollPane2.setVerticalScrollBarPolicy(javax.swing.ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);

        jScrollPane3.setHorizontalScrollBarPolicy(javax.swing.ScrollPaneConstants.HORIZONTAL_SCROLLBAR_ALWAYS);
        jScrollPane3.setVerticalScrollBarPolicy(javax.swing.ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);

        setClosable(true);
        setIconifiable(true);
        setTitle("NUEVA FACTURA ::: TRANSPORTES EDSON");
        setAutoscrolls(true);

        jLabel1.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel1.setText("R.U.T. 76.134.741-1");

        jLabel2.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel2.setText("FACTURA");

        jLabel3.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel3.setText("N°");

        jPanel2.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        jLabel4.setText("Fecha:");

        jLabel5.setText("Señor(es):");

        jLabel6.setText("Direccion:");

        jLabel7.setText("Giro");

        jLabel8.setText("Cond. de Venta");

        jLabel9.setText("R.U.T.:");

        jLabel10.setText("Ciudad");

        jLabel11.setText("Guía Despacho");

        jLabel12.setText("Comuna:");

        jLabel13.setText("O/C");

        jLabel14.setText("Teléfono:");

        cbxsenores.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        cbxsenores.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cbxsenoresActionPerformed(evt);
            }
        });

        txtrut.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtrutActionPerformed(evt);
            }
        });

        txttelefono.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txttelefonoActionPerformed(evt);
            }
        });

        jLabel15.setText("Chofer:");

        cbxChofer.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        cbxChofer.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cbxChoferActionPerformed(evt);
            }
        });

        jLabel16.setText("Camión:");

        cbxcamion.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        jLabel17.setText("Rampla:");

        cbxrampla.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        jDateChooser1.setName("Fecha"); // NOI18N

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel6)
                                    .addComponent(jLabel7))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addGroup(jPanel2Layout.createSequentialGroup()
                                        .addComponent(txtgiro, javax.swing.GroupLayout.PREFERRED_SIZE, 332, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(jLabel10)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(txtciudad))
                                    .addComponent(txtdireccion, javax.swing.GroupLayout.PREFERRED_SIZE, 500, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addComponent(jLabel8)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(txtcond, javax.swing.GroupLayout.PREFERRED_SIZE, 310, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jLabel13)
                                .addGap(18, 18, 18)
                                .addComponent(txtoc))
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addComponent(jLabel5)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(cbxsenores, javax.swing.GroupLayout.PREFERRED_SIZE, 287, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(jLabel14)
                                    .addComponent(jLabel12))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(txtcomuna)
                                    .addComponent(txttelefono)))
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addComponent(jLabel11)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(txtguia))
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addComponent(jLabel9)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(txtrut, javax.swing.GroupLayout.PREFERRED_SIZE, 142, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(226, 226, 226))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(jLabel4)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jDateChooser1, javax.swing.GroupLayout.PREFERRED_SIZE, 208, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jLabel15)
                        .addGap(18, 18, 18)
                        .addComponent(cbxChofer, javax.swing.GroupLayout.PREFERRED_SIZE, 146, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jLabel16)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(cbxcamion, javax.swing.GroupLayout.PREFERRED_SIZE, 101, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel17)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(cbxrampla, javax.swing.GroupLayout.PREFERRED_SIZE, 91, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(179, 179, 179))))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(37, 37, 37)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel4)
                    .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel15)
                        .addComponent(cbxChofer, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jLabel16)
                        .addComponent(cbxcamion, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jLabel17)
                        .addComponent(cbxrampla, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jDateChooser1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel5)
                    .addComponent(cbxsenores, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel9)
                    .addComponent(txtrut, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel6)
                    .addComponent(txtdireccion, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel12, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtcomuna, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(4, 4, 4)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel7)
                    .addComponent(jLabel10)
                    .addComponent(jLabel14, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtgiro, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txttelefono, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtciudad, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel8)
                        .addComponent(txtcond, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jLabel13, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(txtoc, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel11, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(txtguia, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(23, Short.MAX_VALUE))
        );

        btnIngresar.setText("INGRESAR VENTA");
        btnIngresar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnIngresarActionPerformed(evt);
            }
        });

        btnGenerar.setText("IMPRIMIR");
        btnGenerar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnGenerarActionPerformed(evt);
            }
        });

        btnLimpiar.setText("LIMPIAR");
        btnLimpiar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnLimpiarActionPerformed(evt);
            }
        });

        txtTotal.setEditable(false);

        Txtiva.setEditable(false);

        jLabel26.setText("Total:");

        jLabel25.setText("I.V.A:");

        jLabel24.setText("SubTotal:");

        txtSubtotal.setEditable(false);

        tablaFactura.setAutoCreateRowSorter(true);
        tablaFactura.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "CANTIDAD", "DESCRIPCION", "P. UNITARIO", "TOTAL"
            }
        ));
        jScrollPane1.setViewportView(tablaFactura);

        btnQuitarFila.setText("-");
        btnQuitarFila.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnQuitarFilaActionPerformed(evt);
            }
        });

        jPanel4.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        jLabel20.setText("Cantidad:");

        jLabel27.setText("Descripción:");

        jLabel23.setText("$");

        jLabel22.setText("Precio Unitario:");

        jLabel21.setText("Ingrese detalle");

        btnAgregar.setText("Agregar");
        btnAgregar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAgregarActionPerformed(evt);
            }
        });

        txtDesc.setColumns(20);
        txtDesc.setRows(5);
        jScrollPane5.setViewportView(txtDesc);

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel21)
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addComponent(jLabel20)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(SpinCant, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(37, 37, 37)
                        .addComponent(jLabel22)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jLabel23, javax.swing.GroupLayout.PREFERRED_SIZE, 15, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txtPreciou, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addComponent(jLabel27)
                        .addGap(18, 18, 18)
                        .addComponent(jScrollPane5, javax.swing.GroupLayout.PREFERRED_SIZE, 293, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(47, 47, 47)
                        .addComponent(btnAgregar)))
                .addContainerGap(82, Short.MAX_VALUE))
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addComponent(jLabel21)
                .addGap(18, 18, 18)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel20)
                    .addComponent(SpinCant, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel22)
                    .addComponent(jLabel23)
                    .addComponent(txtPreciou, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel27)
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addGap(9, 9, 9)
                        .addComponent(btnAgregar, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jScrollPane5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(20, Short.MAX_VALUE))
        );

        ChboxExcento.setText("Excento");
        ChboxExcento.addChangeListener(new javax.swing.event.ChangeListener() {
            public void stateChanged(javax.swing.event.ChangeEvent evt) {
                ChboxExcentoStateChanged(evt);
            }
        });
        ChboxExcento.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ChboxExcentoActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                .addContainerGap(106, Short.MAX_VALUE)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addComponent(ChboxExcento)
                        .addGap(28, 28, 28)
                        .addComponent(jLabel25)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(Txtiva, javax.swing.GroupLayout.PREFERRED_SIZE, 74, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addComponent(jLabel26)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(txtTotal, javax.swing.GroupLayout.PREFERRED_SIZE, 74, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel24)
                            .addGroup(jPanel3Layout.createSequentialGroup()
                                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 516, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(35, 35, 35)
                                .addComponent(btnQuitarFila, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(txtSubtotal, javax.swing.GroupLayout.PREFERRED_SIZE, 74, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap())
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGap(89, 89, 89)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGap(62, 62, 62)
                        .addComponent(btnIngresar)
                        .addGap(33, 33, 33)
                        .addComponent(btnGenerar)
                        .addGap(31, 31, 31)
                        .addComponent(btnLimpiar)))
                .addGap(0, 0, Short.MAX_VALUE))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 128, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGap(26, 26, 26)
                        .addComponent(btnQuitarFila)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel24, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtSubtotal, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel25, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(Txtiva, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(ChboxExcento))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel26, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtTotal, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnGenerar)
                    .addComponent(btnIngresar)
                    .addComponent(btnLimpiar))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel1, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel2)
                        .addGap(50, 50, 50))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel3)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(txtnumero, javax.swing.GroupLayout.PREFERRED_SIZE, 63, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(42, 42, 42)))
                .addGap(291, 291, 291))
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, 825, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(282, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(21, 21, 21)
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(txtnumero, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(30, 30, 30)
                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(439, Short.MAX_VALUE))
        );

        jScrollPane4.setViewportView(jPanel1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane4, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 865, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane4, javax.swing.GroupLayout.DEFAULT_SIZE, 897, Short.MAX_VALUE)
                .addGap(21, 21, 21))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnAgregarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAgregarActionPerformed
        int cant,precio,subtotal=0;
        int iva,total;
        DefaultTableModel modelo = (DefaultTableModel) tablaFactura.getModel();
        cant = Integer.parseInt(SpinCant.getValue().toString());
        precio = Integer.parseInt(txtPreciou.getText());

        Object[] data = new Object[4];
        data[0] = SpinCant.getValue();
        data[2] = txtPreciou.getText();
        data[1]= txtDesc.getText();
        data[3]= (cant*precio);

        modelo.addRow(data);
        tablaFactura.setModel(modelo);

        SpinCant.setValue(1);
        txtDesc.setText("");
        txtPreciou.setText("");

        for (int fila = 0;  fila< tablaFactura.getRowCount(); fila++) {

            subtotal = subtotal + Integer.parseInt(String.valueOf(tablaFactura.getValueAt(fila, 3)));

        }

        txtSubtotal.setText(String.valueOf(subtotal));
        iva = (int)(subtotal * 0.19);
        if(ChboxExcento.isSelected())
        {
            iva = 0;
        }
        Txtiva.setText(Integer.toString(iva));
        total = (int)(subtotal + iva);
        txtTotal.setText(Integer.toString(total));

    }//GEN-LAST:event_btnAgregarActionPerformed

    @SuppressWarnings("empty-statement")
    private void btnQuitarFilaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnQuitarFilaActionPerformed
        int iva=0,subtotal=0,total = 0;
        try
        {
            DefaultTableModel temp = (DefaultTableModel) tablaFactura.getModel();
            temp.removeRow(temp.getRowCount()-1);
            for (int fila = 0;  fila< tablaFactura.getRowCount(); fila++) {

                subtotal = subtotal + Integer.parseInt(String.valueOf(tablaFactura.getValueAt(fila, 3)));

            }

            txtSubtotal.setText(String.valueOf(subtotal));
            iva = (int)(subtotal * 0.19);
            Txtiva.setText(Integer.toString(iva));
            total = (int)(subtotal * 1.19);
            txtTotal.setText(Integer.toString(total));
        }catch(ArrayIndexOutOfBoundsException e){;}
    }//GEN-LAST:event_btnQuitarFilaActionPerformed
    public void limpiar()
    {
       txtdireccion.setText(" ");
        jDateChooser1.setCalendar(null);
        txtDesc.setText(" ");
        txtcomuna.setText(" ");
        txtciudad.setText(" ");
        txtgiro.setText(" ");
        txttelefono.setText(" ");
        txtcond.setText(" ");
        txtguia.setText(" ");
        Txtiva.setText(" ");
        txtTotal.setText(" ");
        txtrut.setText(" ");
        txtnumero.setText(" ");
        txtoc.setText(" ");
        cbxChofer.setSelectedItem(0);
        txtSubtotal.setText(" ");
        
        try {
            DefaultTableModel modelo=(DefaultTableModel) tablaFactura.getModel();
            int filas=tablaFactura.getRowCount();
            for (int i = 0;filas>i; i++) {
                modelo.removeRow(0);
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Error al limpiar la tabla.");
        
        }
    }
    private void btnLimpiarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnLimpiarActionPerformed

         limpiar();
    }//GEN-LAST:event_btnLimpiarActionPerformed

    private void btnGenerarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnGenerarActionPerformed
        int iva,total2,total,subtotal = 0;
        int dia,mes,ano;
        String mesletras = null;

        dia = jDateChooser1.getCalendar().get(Calendar.DAY_OF_MONTH);
        mes = jDateChooser1.getCalendar().get(Calendar.MONTH)+ 1;
        ano = jDateChooser1.getCalendar().get(Calendar.YEAR);
        if(mes == 1){
            mesletras = "enero";
        }
        if(mes == 2){
            mesletras = "febrero";
        }
        if(mes == 3){
            mesletras = "marzo";
        }
        if(mes == 4){
            mesletras = "abril";
        }
        if(mes == 5){
            mesletras = "mayo";
        }
        if(mes == 6){
            mesletras = "junio";
        }
        if(mes == 7){
            mesletras = "julio";
        }
        if(mes == 8){
            mesletras = "agosto";
        }
        if(mes == 9){
            mesletras = "septiembre";
        }
        if(mes == 10){
            mesletras = "octubre";
        }
        if(mes == 11){
            mesletras = "noviembre";
        }
        if(mes == 12){
            mesletras = "diciembre";
        }
        try {
            //            Class.forName("org.apache.derby.jdbc.ClientDriver");
            //            String url = "jdbc:derby://localhost/Edson;create=true;user=edson;password=edson";
            //            Connection conn = DriverManager.getConnection(url);
            //            conn.setSchema("EDSON");
            Map parametro = new HashMap();
            int fila = 0;

            //iva = (int) ((Integer.parseInt(tablaFactura.getValueAt(0, 3).toString()))*0.19);
            //subtotal = Integer.parseInt(tablaFactura.getValueAt(0, 3).toString());

            factura tipo = new factura("","","","");
            //tipo = new factura(String.valueOf(tablaFactura.getValueAt(fila,1)),String.valueOf(tablaFactura.getValueAt(fila,0)),String.valueOf(tablaFactura.getValueAt(fila,2)),String.valueOf(tablaFactura.getValueAt(fila,3)));

            for (fila = 0;  fila< tablaFactura.getRowCount(); fila++) {

                tipo.descripcion= tipo.descripcion + "\n" + (String.valueOf(tablaFactura.getValueAt(fila,1)));
                tipo.cantidad = tipo.cantidad + "\n" + (String.valueOf(tablaFactura.getValueAt(fila,0)));
                tipo.precio_u = tipo.precio_u + "\n" + (String.valueOf(tablaFactura.getValueAt(fila,2)));
                tipo.total = tipo.total + "\n" + (String.valueOf(tablaFactura.getValueAt(fila,3)));

                subtotal = subtotal + Integer.parseInt(String.valueOf(tablaFactura.getValueAt(fila, 3)));
            }
            iva = (int)(subtotal * 0.19);
            total = (int)(subtotal * 1.19);
            if(ChboxExcento.isSelected())
            {
                iva = 0;
                total = subtotal;
            }

            String ubicacion = System.getProperty("user.dir")+"/src/Reportes/Factura.jasper";
            JasperReport jasperReport = (JasperReport) JRLoader.loadObject(ubicacion);
            parametro.put("cantidad", tipo.cantidad);
            parametro.put("descripcion", tipo.descripcion.toUpperCase());
            parametro.put("punitario", tipo.precio_u);
            parametro.put("total", tipo.total);
            parametro.put("Direccion", txtdireccion.getText());
            parametro.put("rut", txtrut.getText());
            parametro.put("senores", (String)cbxsenores.getSelectedItem());
            parametro.put("giro", txtgiro.getText());
            parametro.put("ciudad", txtciudad.getText());
            parametro.put("telefono", txttelefono.getText());
            parametro.put("comuna", txtcomuna.getText());
            parametro.put("numeroletras", NL.Convertir(Integer.toString(total),true));
            parametro.put("condicion", txtcond.getText().toUpperCase());
            parametro.put("oc", txtoc.getText());
            parametro.put("guia", txtguia.getText());
            parametro.put("neto", Integer.toString(subtotal));
            parametro.put("iva", Integer.toString(iva));
            parametro.put("total2", Integer.toString(total));
            parametro.put("dia", Integer.toString(dia));
            parametro.put("anio", Integer.toString(ano));
            parametro.put("mes", mesletras);
            parametro.put("chofer", (String)cbxChofer.getSelectedItem());
            parametro.put("patente", (String)cbxcamion.getSelectedItem());
            parametro.put("rampla", (String)cbxrampla.getSelectedItem());
            JasperPrint print = JasperFillManager.fillReport(jasperReport, parametro, new JREmptyDataSource());
            JasperViewer view = new JasperViewer(print,false);
            view.setVisible(true);

        } catch (Exception e) {

            JOptionPane.showMessageDialog(this, e);
        }
    }//GEN-LAST:event_btnGenerarActionPerformed

    private void btnIngresarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnIngresarActionPerformed
        int iva,total2,total;
        int dia,mes,año;
        int fila=0;
        String exento = "no";
        iva = (int) ((Integer.parseInt(tablaFactura.getValueAt(0, 3).toString()))*0.19);
        total = Integer.parseInt(tablaFactura.getValueAt(0, 3).toString());

        factura tipo;
        tipo = new factura(String.valueOf(tablaFactura.getValueAt(fila,1)),String.valueOf(tablaFactura.getValueAt(fila,0)),String.valueOf(tablaFactura.getValueAt(fila,2)),String.valueOf(tablaFactura.getValueAt(fila,3)));

        for (fila = 1;  fila< tablaFactura.getRowCount(); fila++) {

            tipo.descripcion= tipo.descripcion + "+\n" + (String.valueOf(tablaFactura.getValueAt(fila,1)));
            tipo.cantidad = tipo.cantidad + "+\n" + String.valueOf(tablaFactura.getValueAt(fila,0));
            tipo.precio_u = tipo.precio_u + "+\n" + String.valueOf(tablaFactura.getValueAt(fila,2));
            tipo.total = tipo.total + "\n" + String.valueOf(tablaFactura.getValueAt(fila,3));
            iva = (int) (iva + (Integer.parseInt(tablaFactura.getValueAt(fila, 3).toString()))*0.19);
            total = total + Integer.parseInt(tablaFactura.getValueAt(fila, 3).toString());
        }

        total2 = total + iva;
        if(ChboxExcento.isSelected())
        {
            iva = 0;
            exento = "si";
        }
        try {
            factura f = new factura();
            dia = jDateChooser1.getCalendar().get(Calendar.DAY_OF_MONTH);
            mes = jDateChooser1.getCalendar().get(Calendar.MONTH)+ 1;
            año = jDateChooser1.getCalendar().get(Calendar.YEAR);

            tipo.fecha = año+"-"+mes+"-"+dia;
            tipo.rut= txtrut.getText();
            tipo.cod_chofer = obtenerCodigoChofer();
            tipo.cod_camion = obtenerCodigoCamion();
            tipo.cod_rampla = obtenerCodigoRampla();

            tipo.total = String.valueOf(total2);
            tipo.iva = String.valueOf(iva);

            tipo.cond_venta = txtcond.getText();
            tipo.orden_c = txtoc.getText();
            tipo.guia_d = txtguia.getText();
            Integer numero = Integer.parseInt(txtnumero.getText());

            Class.forName("org.apache.derby.jdbc.EmbeddedDriver");//prueba es base de datos
            String url = "jdbc:derby:C:/Edson;create=true;user=edson;password=edson";
            Connection conn = DriverManager.getConnection(url);
            //conn.setSchema("EDSON");
            Statement s = conn.createStatement();
            s.execute("INSERT INTO FACT_V (NUM_FACTV,RUT,COD_CHOFER,COD_CAMION,COD_RAMPLA,DESCRIPCION,CANTIDAD,PRECIO_U,TOTAL,IVA,COND_VENTA,ORDEN_C,GUIA_D,FECHA,EXCENTO) VALUES ("+numero+",'"+tipo.rut+"',"+tipo.cod_chofer+","+tipo.cod_camion+","+tipo.cod_rampla+",'"+tipo.descripcion.toUpperCase()+"','"+tipo.cantidad+"','"+tipo.precio_u+"','"+tipo.total+"','"+tipo.iva+"','"+tipo.cond_venta.toUpperCase()+"','"+tipo.orden_c+"','"+tipo.guia_d+"','"+tipo.fecha+"','"+exento+"')");
            //            ResultSet rs = s.getResultSet();

            JOptionPane.showMessageDialog(null, "Se ha Ingresado correctamente la factura");
        } catch (ClassNotFoundException | SQLException | HeadlessException e) {

            
            JOptionPane.showMessageDialog(null, e);
        }        // TODO add your handling code here:
    }//GEN-LAST:event_btnIngresarActionPerformed

    private void cbxChoferActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cbxChoferActionPerformed

    }//GEN-LAST:event_cbxChoferActionPerformed

    private void txttelefonoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txttelefonoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txttelefonoActionPerformed

    private void txtrutActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtrutActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtrutActionPerformed

    private void cbxsenoresActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cbxsenoresActionPerformed
        String nombre = cbxsenores.getSelectedItem().toString();

        try {

            Class.forName("org.apache.derby.jdbc.EmbeddedDriver");//prueba es base de datos
            String url = "jdbc:derby:C:/Edson;create=true;user=edson;password=edson";
            Connection conn = DriverManager.getConnection(url);
            //conn.setSchema("EDSON");
            Statement s = conn.createStatement();
            s.execute("SELECT * FROM CLIENTE where RAZON = '" + nombre + "'");
            ResultSet rs = s.getResultSet();

            while (rs.next()) {

                txtrut.setText(rs.getString("RUT"));
                txtgiro.setText(rs.getString("GIRO"));
                txtdireccion.setText(rs.getString("DIRECCION"));
                txtcomuna.setText(rs.getString("COMUNA"));
                txtciudad.setText(rs.getString("CIUDAD"));
                txttelefono.setText(rs.getString("FONO"));

            }
            conn.close();

        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "error: " + e);
        }
    }//GEN-LAST:event_cbxsenoresActionPerformed

    private void ChboxExcentoStateChanged(javax.swing.event.ChangeEvent evt) {//GEN-FIRST:event_ChboxExcentoStateChanged

    }//GEN-LAST:event_ChboxExcentoStateChanged

    private void ChboxExcentoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ChboxExcentoActionPerformed
        int fila = 0,iva=0,total=0;
        iva = (int)(Integer.parseInt(txtSubtotal.getText()) * 0.19);

        total = (int) (Integer.parseInt(txtSubtotal.getText()) * 1.19);
        if(ChboxExcento.isSelected()){
            Txtiva.setText("0");
            txtTotal.setText((txtSubtotal.getText()));
        }else{
            Txtiva.setText((String.valueOf(iva)));
            txtTotal.setText(String.valueOf(total));
        }
    }//GEN-LAST:event_ChboxExcentoActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JCheckBox ChboxExcento;
    private javax.swing.JSpinner SpinCant;
    private javax.swing.JTextField Txtiva;
    private javax.swing.JButton btnAgregar;
    private javax.swing.JButton btnGenerar;
    private javax.swing.JButton btnIngresar;
    private javax.swing.JButton btnLimpiar;
    private javax.swing.JButton btnQuitarFila;
    private javax.swing.JComboBox cbxChofer;
    private javax.swing.JComboBox cbxcamion;
    private javax.swing.JComboBox cbxrampla;
    private javax.swing.JComboBox cbxsenores;
    private com.toedter.calendar.JDateChooser jDateChooser1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel17;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel20;
    private javax.swing.JLabel jLabel21;
    private javax.swing.JLabel jLabel22;
    private javax.swing.JLabel jLabel23;
    private javax.swing.JLabel jLabel24;
    private javax.swing.JLabel jLabel25;
    private javax.swing.JLabel jLabel26;
    private javax.swing.JLabel jLabel27;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JScrollPane jScrollPane4;
    private javax.swing.JScrollPane jScrollPane5;
    private javax.swing.JTable tablaFactura;
    private javax.swing.JTextArea txtDesc;
    private javax.swing.JTextField txtPreciou;
    private javax.swing.JTextField txtSubtotal;
    private javax.swing.JTextField txtTotal;
    private javax.swing.JTextField txtciudad;
    private javax.swing.JTextField txtcomuna;
    private javax.swing.JTextField txtcond;
    private javax.swing.JTextField txtdireccion;
    private javax.swing.JTextField txtgiro;
    private javax.swing.JTextField txtguia;
    private javax.swing.JTextField txtnumero;
    private javax.swing.JTextField txtoc;
    private javax.swing.JTextField txtrut;
    private javax.swing.JTextField txttelefono;
    // End of variables declaration//GEN-END:variables
}
