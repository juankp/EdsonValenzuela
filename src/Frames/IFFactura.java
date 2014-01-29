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
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.Locale;
import java.util.Map;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import net.sf.jasperreports.engine.JREmptyDataSource;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.JasperReport;
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
        refreshcombo();
        refreshcombo2();
        refreshcombo3();
        refreshcombo4();
        
        Date fecha = new Date();
        SimpleDateFormat dia = new SimpleDateFormat("dd");
        SimpleDateFormat mes = new SimpleDateFormat("MMMM");
        SimpleDateFormat anio = new SimpleDateFormat("yyyy");
        String resultado1 = dia.format(fecha);
        String resultado2 = mes.format(fecha);
        String resultado3 = anio.format(fecha);
        lblfecha.setText(resultado1+" de "+resultado2+ " de "+resultado3);
        


        try {

            Class.forName("org.apache.derby.jdbc.ClientDriver"); //prueba es base de datos
            String url = "jdbc:derby://localhost/Edson;create=true;user=edson;password=edson";
            Connection conn = DriverManager.getConnection(url);
            conn.setSchema("EDSON");
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
                Class.forName("org.apache.derby.jdbc.ClientDriver"); //prueba es base de datos
                String url = "jdbc:derby://localhost/Edson;create=true;user=edson;password=edson";
                Connection conn = DriverManager.getConnection(url);
                conn.setSchema("EDSON");
                Statement s = conn.createStatement();
                s.execute("SELECT * FROM CLIENTE");
                ResultSet rs = s.getResultSet();

                while (rs.next()) {
                    modeloCombo.addElement(rs.getObject("NOMBRE"));
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
                Class.forName("org.apache.derby.jdbc.ClientDriver"); //prueba es base de datos
                String url = "jdbc:derby://localhost/Edson;create=true;user=edson;password=edson";
                Connection conn = DriverManager.getConnection(url);
                conn.setSchema("EDSON");
                Statement s = conn.createStatement();
                s.execute("SELECT * FROM CHOFER");
                ResultSet rs = s.getResultSet();

                while (rs.next()) {
                    modeloCombo.addElement(rs.getObject("RUT"));
                }
                Statement s2 = conn.createStatement();
                s2.execute("SELECT * FROM CHOFER WHERE NOMBRE = '" + cbxChofer.getSelectedItem() + "'");
                ResultSet rs2 = s2.getResultSet();
                while(rs2.next()){
                    codigo2 = rs2.getInt("COD_CHOFER");
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
                Class.forName("org.apache.derby.jdbc.ClientDriver"); //prueba es base de datos
                String url = "jdbc:derby://localhost/Edson;create=true;user=edson;password=edson";
                Connection conn = DriverManager.getConnection(url);
                conn.setSchema("EDSON");
                Statement s = conn.createStatement();
                s.execute("SELECT * FROM CAMION");
                ResultSet rs = s.getResultSet();

                while (rs.next()) {
                    modeloCombo.addElement(rs.getObject("PATENTE"));
                }
                Statement s2 = conn.createStatement();
                s2.execute("SELECT COD_CAMION FROM CAMION WHERE PATENTE = '" + cbxcamion.getSelectedItem().toString() + "'");
                ResultSet rs2 = s2.getResultSet();
                while(rs2.next()){
                    codigo3 = rs2.getInt("COD_CAMION");
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
                Class.forName("org.apache.derby.jdbc.ClientDriver"); //prueba es base de datos
                String url = "jdbc:derby://localhost/Edson;create=true;user=edson;password=edson";
                Connection conn = DriverManager.getConnection(url);
                conn.setSchema("EDSON");
                Statement s = conn.createStatement();
                s.execute("SELECT * FROM RAMPLA");
                ResultSet rs = s.getResultSet();
                
                while (rs.next()) {
                    modeloCombo.addElement(rs.getObject("PATENTE"));
                }
                
                Statement s2 = conn.createStatement();
                s2.execute("SELECT COD_RAMPLA FROM RAMPLA WHERE PATENTE = '" + (String)cbxrampla.getSelectedItem() + "'");
                ResultSet rs2 = s2.getResultSet();
                while(rs2.next()){
                    codigo4 = rs2.getInt("COD_RAMPLA");
                }
                conn.close();
                cbxrampla.setModel(modeloCombo);

            } catch (Exception e) {
                JOptionPane.showMessageDialog(null, "error: " + e);
            }
    }
    
    public int obtenerCodigoRampla()
    {
        String chofer;
        chofer = cbxrampla.getSelectedItem().toString();
        try {
                
                Class.forName("org.apache.derby.jdbc.ClientDriver"); //prueba es base de datos
                String url = "jdbc:derby://localhost/Edson;create=true;user=edson;password=edson";
                Connection conn = DriverManager.getConnection(url);
                conn.setSchema("EDSON");
                Statement s = conn.createStatement();
                s.execute("SELECT * FROM RAMPLA WHERE PATENTE = '"+ chofer +"'");
                ResultSet rs = s.getResultSet();
                
                while (rs.next()) {
                    codigo4 = rs.getInt("COD_RAMPLA");
                }
                
                conn.close();
                return codigo4;
            } catch (ClassNotFoundException | SQLException e) {
                JOptionPane.showMessageDialog(null, "error: " + e);
            }
        return 0;
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
        lblfecha = new javax.swing.JLabel();
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
        jLabel18 = new javax.swing.JLabel();
        jLabel19 = new javax.swing.JLabel();
        txtEspecifico = new javax.swing.JTextField();
        txtExcento = new javax.swing.JTextField();
        btnGenerar = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        tablaFactura = new javax.swing.JTable();
        btnAgregarFila = new javax.swing.JButton();
        btnQuitarFila = new javax.swing.JButton();
        btnIngresar = new javax.swing.JButton();

        setClosable(true);
        setIconifiable(true);
        setMaximizable(true);
        setResizable(true);
        setTitle("NUEVA FACTURA ::: TRANSPORTES EDSON");

        jLabel1.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel1.setText("R.U.T. 76.134.741-1");

        jLabel2.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel2.setText("FACTURA");

        jLabel3.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel3.setText("N°");

        txtnumero.setEditable(false);

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap(63, Short.MAX_VALUE)
                .addComponent(jLabel1)
                .addGap(59, 59, 59))
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(108, 108, 108)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel2)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel3)
                        .addGap(18, 18, 18)
                        .addComponent(txtnumero, javax.swing.GroupLayout.PREFERRED_SIZE, 63, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(txtnumero)
                        .addGap(1, 1, 1))
                    .addComponent(jLabel3))
                .addGap(12, 12, 12))
        );

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

        jLabel18.setText("Específico: ");

        jLabel19.setText("Excento:");

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
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
                        .addGap(27, 27, 27)
                        .addComponent(lblfecha, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGap(27, 27, 27)
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
                        .addGap(179, 179, 179))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(jLabel18)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(txtEspecifico, javax.swing.GroupLayout.PREFERRED_SIZE, 110, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jLabel19)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(txtExcento, javax.swing.GroupLayout.PREFERRED_SIZE, 110, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE))))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(14, 14, 14)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                        .addComponent(jLabel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(lblfecha, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel15)
                        .addComponent(cbxChofer, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jLabel16)
                        .addComponent(cbxcamion, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jLabel17)
                        .addComponent(cbxrampla, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
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
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel18)
                    .addComponent(txtEspecifico, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel19)
                    .addComponent(txtExcento, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        btnGenerar.setText("IMPRIMIR");
        btnGenerar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnGenerarActionPerformed(evt);
            }
        });

        tablaFactura.setAutoCreateRowSorter(true);
        tablaFactura.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "#", "CANTIDAD", "DESCRIPCION", "P. UNITARIO", "TOTAL"
            }
        ));
        jScrollPane1.setViewportView(tablaFactura);

        btnAgregarFila.setText("+");
        btnAgregarFila.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAgregarFilaActionPerformed(evt);
            }
        });

        btnQuitarFila.setText("-");
        btnQuitarFila.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnQuitarFilaActionPerformed(evt);
            }
        });

        btnIngresar.setText("INGRESAR");
        btnIngresar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnIngresarActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jPanel2, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 826, Short.MAX_VALUE)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(24, 24, 24))
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(105, 105, 105)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 584, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(59, 59, 59)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(btnAgregarFila, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(btnQuitarFila, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(204, 204, 204)
                        .addComponent(btnIngresar)
                        .addGap(33, 33, 33)
                        .addComponent(btnGenerar)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnAgregarFila)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(18, 18, 18)
                        .addComponent(btnQuitarFila))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(7, 7, 7)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 128, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(29, 29, 29)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnGenerar)
                    .addComponent(btnIngresar))
                .addContainerGap(217, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void txtrutActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtrutActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtrutActionPerformed

    private void txttelefonoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txttelefonoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txttelefonoActionPerformed

    private void cbxsenoresActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cbxsenoresActionPerformed
        String nombre = cbxsenores.getSelectedItem().toString();

        try {
            
            Class.forName("org.apache.derby.jdbc.ClientDriver"); //prueba es base de datos
            String url = "jdbc:derby://localhost/Edson;create=true;user=edson;password=edson";
            Connection conn = DriverManager.getConnection(url);
            conn.setSchema("EDSON");
            Statement s = conn.createStatement();
            s.execute("SELECT * FROM CLIENTE where NOMBRE = '" + nombre + "'");
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

    private void btnGenerarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnGenerarActionPerformed
        double iva,total2;
        iva = (Integer.parseInt(tablaFactura.getValueAt(0, 4).toString()))*0.19;
        total2 = Integer.parseInt(tablaFactura.getValueAt(0, 4).toString()) *1.19;
        
        try {
            factura f = new factura();
            
            f.rut= txtrut.getText();
            f.cod_cliente = codigo;
            f.cod_chofer = codigo2;
            f.cod_camion = codigo3;
            f.cod_rampla = obtenerCodigoRampla();
            f.descripcion = tablaFactura.getValueAt(0, 2).toString();
            f.cantidad = tablaFactura.getValueAt(0, 1).toString();
            f.precio_u = tablaFactura.getValueAt(0, 3).toString();
            f.total = Double.toString(total2);
            f.iva = Double.toString(iva);
            f.especifico = txtEspecifico.getText(); //falta agregar los campos a la interfaz
            f.excento = txtExcento.getText();    // lo mismo 
            f.cond_venta = txtcond.getText();
            f.orden_c = txtoc.getText();
            
//            Class.forName("org.apache.derby.jdbc.ClientDriver");//prueba es base de datos
//
//            String url = "jdbc:derby://localhost/Edson;create=true;user=edson;password=edson";
//            Connection conn = DriverManager.getConnection(url);
//            conn.setSchema("EDSON");
//            Statement s = conn.createStatement();
//            s.execute("INSERT INTO FACT_V (RUT,COD_CHOFER,COD_CAMION,COD_RAMPLA,DESCRIPCION,CANTIDAD,PRECIO_U,TOTAL,IVA,ESPECIFICO,EXCENTO,COND_VENTA,ORDEN_C,GUIA_D) VALUES ('"+f.rut+"','"+f.cod_chofer+"','"+f.cod_camion+"','"+f.cod_rampla+"','"+f.descripcion+"','"+f.cantidad+"','"+f.precio_u+"','"+f.total+"','"+f.iva+"','"+f.especifico+"','"+f.excento+"','"+f.cond_venta+"','"+f.orden_c+"','"+f.guia_d+"')");
//            ResultSet rs = s.getResultSet();
//            
//            conn.close();
//            JOptionPane.showMessageDialog(null, "Se ha Ingresado correctamente la factura");
        } catch (Exception e) {
        }
        
        
        String mes = null;
        Calendar cal = Calendar.getInstance();
        int dia = cal.get(Calendar.DAY_OF_MONTH);
       
        int ano = cal.get(Calendar.YEAR);
        
        if(cal.get(Calendar.MONTH) == Calendar.JANUARY){
            mes = "ENERO";
        }
        if(cal.get(Calendar.MONTH) == Calendar.FEBRUARY){
            mes = "FEBRERO";
        }
        if(cal.get(Calendar.MONTH) == Calendar.MARCH){
            mes = "MARZO";
        }
        if(cal.get(Calendar.MONTH) == Calendar.APRIL){
            mes = "ABRIL";
        }
        if(cal.get(Calendar.MONTH) == Calendar.MAY){
            mes = "MAYO";
        }
        if(cal.get(Calendar.MONTH) == Calendar.JUNE){
            mes = "JUNIO";
        }
        if(cal.get(Calendar.MONTH) == Calendar.JULY){
            mes = "JULIO";
        }
        if(cal.get(Calendar.MONTH) == Calendar.AUGUST){
            mes = "AGOSTO";
        }
        if(cal.get(Calendar.MONTH) == Calendar.SEPTEMBER){
            mes = "SEPTIEMBRE";
        }
        if(cal.get(Calendar.MONTH) == Calendar.OCTOBER){
            mes = "OCTUBRE";
        }
        if(cal.get(Calendar.MONTH) == Calendar.NOVEMBER){
            mes = "NOVIEMBRE";
        }
        if(cal.get(Calendar.MONTH) == Calendar.DECEMBER){
            mes = "DICIEMBRE";
        }
         try {
//            Class.forName("org.apache.derby.jdbc.ClientDriver");
//            String url = "jdbc:derby://localhost/Edson;create=true;user=edson;password=edson";
//            Connection conn = DriverManager.getConnection(url);
//            conn.setSchema("EDSON");
            
            String ubicacion = System.getProperty("user.dir")+"/src/Reportes/Factura.jasper";
            JasperReport jasperReport = (JasperReport) JRLoader.loadObject(ubicacion);
            Map parametro = new HashMap();
            parametro.put("Direccion", txtdireccion.getText());
            parametro.put("rut", txtrut.getText());
            parametro.put("senores", (String)cbxsenores.getSelectedItem());
            parametro.put("giro", txtgiro.getText());
            parametro.put("ciudad", txtciudad.getText());
            parametro.put("telefono", txttelefono.getText());
            parametro.put("comuna", txtcomuna.getText());
            parametro.put("cantidad", tablaFactura.getValueAt(0, 1).toString());
            parametro.put("descripcion", tablaFactura.getValueAt(0, 2).toString());
            parametro.put("punitario", tablaFactura.getValueAt(0, 3).toString());
            parametro.put("total", tablaFactura.getValueAt(0, 4).toString());
            parametro.put("numeroletras", NL.Convertir(Double.toString(total2),true));
            parametro.put("condicion", txtcond.getText());
            parametro.put("oc", txtoc.getText());
            parametro.put("guia", txtguia.getText());
            parametro.put("neto", tablaFactura.getValueAt(0, 4).toString());
            parametro.put("iva", Double.toString(iva));
            parametro.put("total2", Double.toString(total2));
            parametro.put("dia", Integer.toString(dia));
            parametro.put("anio", Integer.toString(ano));
            parametro.put("mes", mes);
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

    private void btnAgregarFilaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAgregarFilaActionPerformed
        DefaultTableModel temp = (DefaultTableModel) tablaFactura.getModel();
        Object nuevo[]= {temp.getRowCount(),"",""};
        temp.addRow(nuevo);
    }//GEN-LAST:event_btnAgregarFilaActionPerformed

    @SuppressWarnings("empty-statement")
    private void btnQuitarFilaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnQuitarFilaActionPerformed
        try
        {
            DefaultTableModel temp = (DefaultTableModel) tablaFactura.getModel();
            temp.removeRow(temp.getRowCount()-1);
        }catch(ArrayIndexOutOfBoundsException e){;}
    }//GEN-LAST:event_btnQuitarFilaActionPerformed

    private void cbxChoferActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cbxChoferActionPerformed
       
    }//GEN-LAST:event_cbxChoferActionPerformed

    private void btnIngresarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnIngresarActionPerformed
    double iva,total2;
        iva = (Integer.parseInt(tablaFactura.getValueAt(0, 4).toString()))*0.19;
        total2 = Integer.parseInt(tablaFactura.getValueAt(0, 4).toString()) *1.19;
        
        try {
            factura f = new factura();
            
            f.rut= txtrut.getText();
            f.cod_chofer = codigo2;
            f.cod_camion = codigo3;
            f.cod_rampla = codigo4;
            f.descripcion = tablaFactura.getValueAt(0, 2).toString();
            f.cantidad = tablaFactura.getValueAt(0, 1).toString();
            f.precio_u = tablaFactura.getValueAt(0, 3).toString();
            //f.total = Double.toString(total2);
            //f.iva = Double.toString(iva);
            f.especifico = txtEspecifico.getText(); //falta agregar los campos a la interfaz
            f.excento = txtExcento.getText();    // lo mismo 
            f.cond_venta = txtcond.getText();
            f.orden_c = txtoc.getText();
            
            Class.forName("org.apache.derby.jdbc.ClientDriver");//prueba es base de datos

            String url = "jdbc:derby://localhost/Edson;create=true;user=edson;password=edson";
            Connection conn = DriverManager.getConnection(url);
            conn.setSchema("EDSON");
            Statement s = conn.createStatement();
            s.execute("INSERT INTO FACT_V (RUT,COD_CHOFER,COD_CAMION,COD_RAMPLA,DESCRIPCION,CANTIDAD,PRECIO_U,TOTAL,IVA,ESPECIFICO,EXCENTO,COND_VENTA,ORDEN_C,GUIA_D) VALUES ('"+f.rut+"','"+f.cod_chofer+"','"+f.cod_camion+"','"+f.cod_rampla+"','"+f.descripcion+"','"+f.cantidad+"','"+f.precio_u+"','"+f.total+"','"+f.iva+"','"+f.especifico+"','"+f.excento+"','"+f.cond_venta+"','"+f.orden_c+"','"+f.guia_d+"')");
//            ResultSet rs = s.getResultSet();
            
            JOptionPane.showMessageDialog(null, "Se ha Ingresado correctamente la factura");
        } catch (ClassNotFoundException | SQLException | HeadlessException e) {
   
            JOptionPane.showMessageDialog(null, e);
        }        // TODO add your handling code here:
    }//GEN-LAST:event_btnIngresarActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAgregarFila;
    private javax.swing.JButton btnGenerar;
    private javax.swing.JButton btnIngresar;
    private javax.swing.JButton btnQuitarFila;
    private javax.swing.JComboBox cbxChofer;
    private javax.swing.JComboBox cbxcamion;
    private javax.swing.JComboBox cbxrampla;
    private javax.swing.JComboBox cbxsenores;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel17;
    private javax.swing.JLabel jLabel18;
    private javax.swing.JLabel jLabel19;
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
    private javax.swing.JLabel lblfecha;
    private javax.swing.JTable tablaFactura;
    private javax.swing.JTextField txtEspecifico;
    private javax.swing.JTextField txtExcento;
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
