package Vista;

import Modelo.Conexion;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;
import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.JasperReport;
import net.sf.jasperreports.engine.util.JRLoader;
import net.sf.jasperreports.view.JasperViewer;

public class frmRegistrarventa extends javax.swing.JInternalFrame {

    Conexion con = new Conexion();
    Connection cn = con.getConexion();
    String atributo = "Id_producto";

    public frmRegistrarventa() {
        initComponents();

        consultaIdVenta();
        bloquearparte1();

        DefaultTableModel modelo = (DefaultTableModel) jTable9.getModel();
        modelo.addColumn("ID_Venta");
        modelo.addColumn("ID_producto");
        modelo.addColumn("Existencia");
        modelo.addColumn("Nombre");
        modelo.addColumn("Marca");
        modelo.addColumn("Precio mayoreo");
        modelo.addColumn("Precio menudeo");
        modelo.addColumn("Categoria");
        modelo.addColumn("Cantidad");
        modelo.addColumn("Precio Total");
        jTable9.setModel(modelo);
    }

    void bloquearparte1() {
        jLabel5.setVisible(false);
        jLabel6.setVisible(false);
        jLabel7.setVisible(false);
        jLabel8.setVisible(false);
        lbNombreusuario9.setVisible(false);
        lbApellidoUsuario9.setVisible(false);
        lblAmaternoUsuario9.setVisible(false);

        lbIDVenta9.setEnabled(false);
        lbNombreusuario9.setEnabled(false);
        lbApellidoUsuario9.setEnabled(false);
        lblAmaternoUsuario9.setEnabled(false);
        lbIDusuario9.setEnabled(false);
        btnRegistrarfactura9.setEnabled(false);
        lbFecha.setEnabled(false);

        comboModoConsulta9.setEnabled(false);
        txtConsultarproducto9.setEnabled(false);
        btnConsultar9.setEnabled(false);
        btnSeleccionar9.setEnabled(false);
        IDSeleccionado9.setEnabled(false);
        NombreSeleccionado9.setEnabled(false);
        MarcaSeleccionado9.setEnabled(false);
        PrecioMayoreoSeleccionado9.setEnabled(false);
        Preciomenudeoseleccionado9.setEnabled(false);
        ExistenciaSeleccionado9.setEnabled(false);
        cbxCategoría9.setEnabled(false);
        txtCantidad9.setEnabled(false);
        listo9.setEnabled(false);
        TotalDetalle9.setEnabled(false);
        btnRegistrardetalle9.setEnabled(false);
        txtEfectivo9.setEnabled(false);
        Cambio9.setEnabled(false);
        Totalfactura9.setEnabled(false);
        btnRegistrarfactura9.setEnabled(true);
        btnImprimirTicket9.setEnabled(false);
        btnCancelar.setEnabled(false);
        btnRegistrarTotal9.setEnabled(false);

        IDSeleccionado9.setText(null);
        NombreSeleccionado9.setText(null);
        MarcaSeleccionado9.setText(null);
        PrecioMayoreoSeleccionado9.setText(null);
        Preciomenudeoseleccionado9.setText(null);
        ExistenciaSeleccionado9.setText(null);
        txtCantidad9.setText(null);
        TotalDetalle9.setText(null);
        txtConsultarproducto9.setText(null);
        Totalfactura9.setText(null);
        txtEfectivo9.setText(null);
        Cambio9.setText(null);
    }

    void desbloquearparte1() {
        jLabel5.setVisible(false);
        jLabel6.setVisible(false);
        jLabel7.setVisible(false);
        lbNombreusuario9.setVisible(false);
        lbApellidoUsuario9.setVisible(false);
        lblAmaternoUsuario9.setVisible(false);

        lbIDVenta9.setEnabled(true);
        lbNombreusuario9.setEnabled(true);
        lbApellidoUsuario9.setEnabled(true);
        lblAmaternoUsuario9.setEnabled(true);
        lbIDusuario9.setEnabled(true);
        btnRegistrarfactura9.setEnabled(true);
        lbFecha.setEnabled(true);

        comboModoConsulta9.setEnabled(true);
        txtConsultarproducto9.setEnabled(true);
        btnConsultar9.setEnabled(true);
        btnSeleccionar9.setEnabled(true);
        IDSeleccionado9.setEnabled(true);
        NombreSeleccionado9.setEnabled(true);
        MarcaSeleccionado9.setEnabled(true);
        PrecioMayoreoSeleccionado9.setEnabled(true);
        Preciomenudeoseleccionado9.setEnabled(true);
        ExistenciaSeleccionado9.setEnabled(true);
        cbxCategoría9.setEnabled(true);
        txtCantidad9.setEnabled(true);
        listo9.setEnabled(true);
        TotalDetalle9.setEnabled(true);
        btnRegistrardetalle9.setEnabled(true);
        txtEfectivo9.setEnabled(true);
        Cambio9.setEnabled(true);
        Totalfactura9.setEnabled(true);
        btnRegistrarfactura9.setEnabled(true);
        btnImprimirTicket9.setEnabled(true);
        btnRegistrarTotal9.setEnabled(true);
        btnCancelar.setEnabled(true);

        IDSeleccionado9.setText(null);
        NombreSeleccionado9.setText(null);
        MarcaSeleccionado9.setText(null);
        PrecioMayoreoSeleccionado9.setText(null);
        Preciomenudeoseleccionado9.setText(null);
        ExistenciaSeleccionado9.setText(null);
        txtCantidad9.setText(null);
        TotalDetalle9.setText(null);
        txtConsultarproducto9.setText(null);
        Totalfactura9.setText(null);
        txtEfectivo9.setText(null);
        Cambio9.setText(null);
        lbIDusuario9.setText(null);
        lbFecha.setDate(null);
        lbIDVenta9.setVisible(true);
        lbNombreusuario9.setText(null);
        lbApellidoUsuario9.setText(null);;
        lblAmaternoUsuario9.setText(null);

    }

    void limpiartabla() {

    }

    void mostraretiquetasusuario() {
        jLabel5.setVisible(true);
        jLabel6.setVisible(true);
        jLabel7.setVisible(true);
        jLabel8.setVisible(true);
        lbNombreusuario9.setVisible(true);
        lbApellidoUsuario9.setVisible(true);
        lblAmaternoUsuario9.setVisible(true);
        lbIDVenta9.setVisible(true);
        lbIDusuario9.setVisible(true);

    }

    void consultausuario() {
        String sql = "";
        sql = "select c.id_usuario, c.nombre, c.A_paterno, c.A_materno from usuario c, rol_usuario d where c.id_usuario=d.id_usuario and d.rol='Administrador'";
        Statement st;
        try {
            st = cn.createStatement();
            ResultSet rs = st.executeQuery(sql);
            while (rs.next()) {
                lbIDusuario9.setText(rs.getString(1));
                lbNombreusuario9.setText(rs.getString(2));
                lbApellidoUsuario9.setText(rs.getString(3));
                lblAmaternoUsuario9.setText(rs.getString(4));
            }
        } catch (SQLException ex) {
            System.out.println("Error");
        }
    }

    void consultaIdVenta() {
        int contenidoID;
        String sql = "";
        sql = "SELECT MAX(Id_venta) AS Id_venta FROM Venta";
        Statement st;
        try {
            st = cn.createStatement();
            ResultSet rs = st.executeQuery(sql);
            while (rs.next()) {
                contenidoID = rs.getInt("Id_venta");
                int contenidototal = contenidoID + 1;

                lbIDVenta9.setText(String.valueOf(contenidototal));
            }
        } catch (SQLException ex) {
            System.out.println("Error");
        }
    }

    void mostrarTablaConsultarproductos(String valor) {
        DefaultTableModel modelo = new DefaultTableModel();
        modelo.addColumn("ID");
        modelo.addColumn("Nombre");
        modelo.addColumn("Marca");
        modelo.addColumn("Existencia");
        modelo.addColumn("Contenido");
        modelo.addColumn("Precio mayoreo");
        modelo.addColumn("Precio menudeo");

        tabla9.setModel(modelo);

        String sql = "";
        if (valor.equals("")) {
            sql = "select c.Id_producto, c.Nombre, c.Marca, c.Existencia, d.Contenido, d.Precio_mayoreo, d.Precio_menudeo from Producto c, detalle_de_producto d where d.id_producto=c.id_producto";
        } else {

            sql = "select c.Id_producto, c.Nombre, c.Marca, c.Existencia, d.Contenido, d.Precio_mayoreo, d.Precio_menudeo from Producto c, detalle_de_producto d where d.id_producto=c.id_producto and c." + atributo + " like '" + valor + "%'";

        }
        String datos[] = new String[7];
        Statement st;
        try {
            st = cn.createStatement();
            ResultSet rs = st.executeQuery(sql);
            while (rs.next()) {
                datos[0] = rs.getString(1);
                datos[1] = rs.getString(2);
                datos[2] = rs.getString(3);
                datos[3] = rs.getString(4);
                datos[4] = rs.getString(5);
                datos[5] = rs.getString(6);
                datos[6] = rs.getString(7);
                modelo.addRow(datos);
            }
            tabla9.setModel(modelo);
        } catch (SQLException ex) {
            System.out.println("Error");
        }
    }

    void TablaDetalle() {

        DefaultTableModel modelo = (DefaultTableModel) jTable9.getModel();
        String datos[] = new String[10];
        datos[0] = lbIDVenta9.getText();
        datos[1] = IDSeleccionado9.getText();
        datos[2] = ExistenciaSeleccionado9.getText();
        datos[3] = NombreSeleccionado9.getText();
        datos[4] = MarcaSeleccionado9.getText();
        datos[5] = PrecioMayoreoSeleccionado9.getText();
        datos[6] = Preciomenudeoseleccionado9.getText();
        datos[7] = cbxCategoría9.getSelectedItem().toString();
        datos[8] = txtCantidad9.getText();
        datos[9] = TotalDetalle9.getText();
        modelo.addRow(datos);

        jTable9.setModel(modelo);
    }

    public double sumandodetalle() {
        int contar = jTable9.getRowCount();
        double suma = 0;
        for (int i = 0; i < contar; i++) {
            suma = suma + Double.parseDouble(jTable9.getValueAt(i, 9).toString());

        }
        return suma;
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel2 = new javax.swing.JPanel();
        btnRegistrarfactura9 = new javax.swing.JButton();
        btnCancelar = new javax.swing.JButton();
        jPanel20 = new javax.swing.JPanel();
        lblAmaternoUsuario9 = new javax.swing.JLabel();
        lbApellidoUsuario9 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        lbNombreusuario9 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        lbIDusuario9 = new javax.swing.JLabel();
        jLabel187 = new javax.swing.JLabel();
        jLabel188 = new javax.swing.JLabel();
        comboModoConsulta9 = new javax.swing.JComboBox();
        Cambio9 = new javax.swing.JLabel();
        btnRegistrarTotal9 = new javax.swing.JButton();
        btnImprimirTicket9 = new javax.swing.JButton();
        txtConsultarproducto9 = new javax.swing.JTextField();
        btnConsultar9 = new javax.swing.JButton();
        btnSeleccionar9 = new javax.swing.JButton();
        jLabel172 = new javax.swing.JLabel();
        jScrollPane19 = new javax.swing.JScrollPane();
        tabla9 = new javax.swing.JTable();
        jPanel19 = new javax.swing.JPanel();
        jLabel170 = new javax.swing.JLabel();
        btnRegistrardetalle9 = new javax.swing.JButton();
        jScrollPane20 = new javax.swing.JScrollPane();
        jTable9 = new javax.swing.JTable();
        jLabel186 = new javax.swing.JLabel();
        Totalfactura9 = new javax.swing.JLabel();
        txtEfectivo9 = new javax.swing.JTextField();
        jPanel4 = new javax.swing.JPanel();
        jLabel177 = new javax.swing.JLabel();
        IDSeleccionado9 = new javax.swing.JLabel();
        jLabel178 = new javax.swing.JLabel();
        Preciomenudeoseleccionado9 = new javax.swing.JLabel();
        jLabel185 = new javax.swing.JLabel();
        TotalDetalle9 = new javax.swing.JLabel();
        jLabel180 = new javax.swing.JLabel();
        NombreSeleccionado9 = new javax.swing.JLabel();
        jLabel179 = new javax.swing.JLabel();
        ExistenciaSeleccionado9 = new javax.swing.JLabel();
        jLabel181 = new javax.swing.JLabel();
        MarcaSeleccionado9 = new javax.swing.JLabel();
        jLabel183 = new javax.swing.JLabel();
        PrecioMayoreoSeleccionado9 = new javax.swing.JLabel();
        jLabel182 = new javax.swing.JLabel();
        cbxCategoría9 = new javax.swing.JComboBox();
        jLabel184 = new javax.swing.JLabel();
        txtCantidad9 = new javax.swing.JTextField();
        listo9 = new javax.swing.JButton();
        lbIDVenta9 = new javax.swing.JLabel();
        jLabel171 = new javax.swing.JLabel();
        lbFecha = new com.toedter.calendar.JDateChooser();

        jPanel2.setBackground(new java.awt.Color(0, 153, 153));

        btnRegistrarfactura9.setText("Nueva factura");
        btnRegistrarfactura9.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnRegistrarfactura9ActionPerformed(evt);
            }
        });

        btnCancelar.setText("Cancelar");
        btnCancelar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCancelarActionPerformed(evt);
            }
        });

        jPanel20.setBackground(new java.awt.Color(0, 204, 204));
        jPanel20.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        lblAmaternoUsuario9.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N

        lbApellidoUsuario9.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N

        jLabel5.setText("Nombre del usuario:");

        jLabel7.setText("A. Materno:");

        jLabel6.setText("A. Paterno:");

        lbNombreusuario9.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N

        jLabel8.setText("ID_Usuario:");

        lbIDusuario9.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N

        javax.swing.GroupLayout jPanel20Layout = new javax.swing.GroupLayout(jPanel20);
        jPanel20.setLayout(jPanel20Layout);
        jPanel20Layout.setHorizontalGroup(
            jPanel20Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel20Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel20Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel20Layout.createSequentialGroup()
                        .addComponent(jLabel7)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(lblAmaternoUsuario9, javax.swing.GroupLayout.PREFERRED_SIZE, 231, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel20Layout.createSequentialGroup()
                        .addComponent(jLabel5)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(lbNombreusuario9, javax.swing.GroupLayout.PREFERRED_SIZE, 231, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel20Layout.createSequentialGroup()
                        .addComponent(jLabel6)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(lbApellidoUsuario9, javax.swing.GroupLayout.PREFERRED_SIZE, 231, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel8)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(lbIDusuario9, javax.swing.GroupLayout.PREFERRED_SIZE, 231, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel20Layout.setVerticalGroup(
            jPanel20Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel20Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel20Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel20Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                        .addComponent(lbNombreusuario9, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jLabel5))
                    .addGroup(jPanel20Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(lbIDusuario9, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jLabel8, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel20Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lbApellidoUsuario9, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel20Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lblAmaternoUsuario9, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE)))
        );

        jLabel187.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel187.setText("Efectivo:");

        jLabel188.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel188.setText("Cambio:");

        comboModoConsulta9.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Consultar por:", "Id_producto", "Nombre", "Marca" }));

        Cambio9.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N

        btnRegistrarTotal9.setText("Registrar Venta");
        btnRegistrarTotal9.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnRegistrarTotal9ActionPerformed(evt);
            }
        });

        btnImprimirTicket9.setText("ImprimirTicket");
        btnImprimirTicket9.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnImprimirTicket9ActionPerformed(evt);
            }
        });

        txtConsultarproducto9.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtConsultarproducto9KeyReleased(evt);
            }
        });

        btnConsultar9.setText("Mostrar todos los productos");
        btnConsultar9.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnConsultar9ActionPerformed(evt);
            }
        });

        btnSeleccionar9.setText("Seleccionar");
        btnSeleccionar9.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSeleccionar9ActionPerformed(evt);
            }
        });

        jLabel172.setText("Fecha:");

        tabla9.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {

            }
        ));
        jScrollPane19.setViewportView(tabla9);

        jPanel19.setBackground(new java.awt.Color(0, 102, 102));
        jPanel19.setBorder(new javax.swing.border.MatteBorder(null));

        jLabel170.setFont(new java.awt.Font("Algerian", 1, 36)); // NOI18N
        jLabel170.setForeground(new java.awt.Color(255, 255, 255));
        jLabel170.setText("Registrar venta");

        javax.swing.GroupLayout jPanel19Layout = new javax.swing.GroupLayout(jPanel19);
        jPanel19.setLayout(jPanel19Layout);
        jPanel19Layout.setHorizontalGroup(
            jPanel19Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel19Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel170)
                .addGap(390, 390, 390))
        );
        jPanel19Layout.setVerticalGroup(
            jPanel19Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel19Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel170, javax.swing.GroupLayout.PREFERRED_SIZE, 48, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        btnRegistrardetalle9.setText("Registrar detalle");
        btnRegistrardetalle9.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnRegistrardetalle9ActionPerformed(evt);
            }
        });

        jTable9.setFont(new java.awt.Font("Tahoma", 0, 10)); // NOI18N
        jTable9.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {

            }
        ));
        jScrollPane20.setViewportView(jTable9);

        jLabel186.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel186.setText("Total factura:");

        Totalfactura9.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N

        txtEfectivo9.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtEfectivo9KeyReleased(evt);
            }
        });

        jPanel4.setBackground(new java.awt.Color(255, 255, 255));
        jPanel4.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        jLabel177.setText("ID:");

        IDSeleccionado9.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N

        jLabel178.setText("Precio Menudeo:");

        Preciomenudeoseleccionado9.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N

        jLabel185.setText("Total producto:");

        TotalDetalle9.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N

        jLabel180.setText("Nombre:");

        NombreSeleccionado9.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N

        jLabel179.setText("Existencia:");

        ExistenciaSeleccionado9.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N

        jLabel181.setText("Marca:");

        MarcaSeleccionado9.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N

        jLabel183.setText("Precio Mayoreo:");

        PrecioMayoreoSeleccionado9.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N

        jLabel182.setText("Categoria:");

        cbxCategoría9.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Mayoreo", "Menudeo" }));

        jLabel184.setText("Cantidad:");

        txtCantidad9.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtCantidad9ActionPerformed(evt);
            }
        });
        txtCantidad9.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtCantidad9KeyReleased(evt);
            }
        });

        listo9.setText("$");
        listo9.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                listo9ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addComponent(jLabel179)
                        .addGap(18, 18, 18)
                        .addComponent(ExistenciaSeleccionado9, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addComponent(jLabel182)
                        .addGap(18, 18, 18)
                        .addComponent(cbxCategoría9, javax.swing.GroupLayout.PREFERRED_SIZE, 132, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                        .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel4Layout.createSequentialGroup()
                            .addComponent(jLabel177)
                            .addGap(18, 18, 18)
                            .addComponent(IDSeleccionado9, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel4Layout.createSequentialGroup()
                            .addComponent(jLabel180)
                            .addGap(18, 18, 18)
                            .addComponent(NombreSeleccionado9, javax.swing.GroupLayout.DEFAULT_SIZE, 98, Short.MAX_VALUE)))
                    .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                        .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel4Layout.createSequentialGroup()
                            .addComponent(jLabel178)
                            .addGap(18, 18, 18)
                            .addComponent(Preciomenudeoseleccionado9, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addGroup(jPanel4Layout.createSequentialGroup()
                            .addComponent(jLabel183)
                            .addGap(18, 18, 18)
                            .addComponent(PrecioMayoreoSeleccionado9, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addGroup(jPanel4Layout.createSequentialGroup()
                            .addComponent(jLabel181)
                            .addGap(18, 18, 18)
                            .addComponent(MarcaSeleccionado9, javax.swing.GroupLayout.PREFERRED_SIZE, 110, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addComponent(jLabel184)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txtCantidad9, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(listo9, javax.swing.GroupLayout.PREFERRED_SIZE, 47, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addComponent(jLabel185)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(TotalDetalle9, javax.swing.GroupLayout.PREFERRED_SIZE, 51, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jLabel177, javax.swing.GroupLayout.DEFAULT_SIZE, 21, Short.MAX_VALUE)
                    .addComponent(IDSeleccionado9, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jLabel180, javax.swing.GroupLayout.DEFAULT_SIZE, 21, Short.MAX_VALUE)
                    .addComponent(NombreSeleccionado9, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel179)
                    .addComponent(ExistenciaSeleccionado9, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jLabel181, javax.swing.GroupLayout.DEFAULT_SIZE, 21, Short.MAX_VALUE)
                    .addComponent(MarcaSeleccionado9, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel183, javax.swing.GroupLayout.PREFERRED_SIZE, 21, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(PrecioMayoreoSeleccionado9, javax.swing.GroupLayout.PREFERRED_SIZE, 21, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jLabel178, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(Preciomenudeoseleccionado9, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(cbxCategoría9, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel182))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtCantidad9, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(listo9)
                    .addComponent(jLabel184, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(TotalDetalle9, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel4Layout.createSequentialGroup()
                        .addComponent(jLabel185, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap())))
        );

        lbIDVenta9.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        lbIDVenta9.setPreferredSize(new java.awt.Dimension(0, 23));

        jLabel171.setText("ID Venta:");

        lbFecha.setDateFormatString("yyyy/MM/dd HH:mm:ss");

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel19, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(jLabel171)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(lbIDVenta9, javax.swing.GroupLayout.PREFERRED_SIZE, 149, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jLabel172)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(lbFecha, javax.swing.GroupLayout.PREFERRED_SIZE, 137, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(95, 95, 95))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jPanel20, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addGap(0, 0, Short.MAX_VALUE)
                                .addComponent(btnRegistrarfactura9)
                                .addGap(29, 29, 29)
                                .addComponent(btnCancelar, javax.swing.GroupLayout.PREFERRED_SIZE, 101, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addComponent(comboModoConsulta9, javax.swing.GroupLayout.PREFERRED_SIZE, 151, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(txtConsultarproducto9, javax.swing.GroupLayout.PREFERRED_SIZE, 123, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(73, 73, 73)
                                .addComponent(btnConsultar9, javax.swing.GroupLayout.PREFERRED_SIZE, 243, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(btnSeleccionar9, javax.swing.GroupLayout.PREFERRED_SIZE, 137, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(88, 88, 88))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(jScrollPane19)
                        .addContainerGap())
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addComponent(jLabel187)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(txtEfectivo9, javax.swing.GroupLayout.PREFERRED_SIZE, 98, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(67, 67, 67)
                                .addComponent(jLabel188)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(Cambio9, javax.swing.GroupLayout.PREFERRED_SIZE, 98, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, 209, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addGroup(jPanel2Layout.createSequentialGroup()
                                        .addGap(294, 294, 294)
                                        .addComponent(btnRegistrardetalle9, javax.swing.GroupLayout.PREFERRED_SIZE, 132, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(90, 90, 90)
                                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addGroup(jPanel2Layout.createSequentialGroup()
                                                .addComponent(btnRegistrarTotal9, javax.swing.GroupLayout.PREFERRED_SIZE, 153, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addGap(18, 18, 18)
                                                .addComponent(btnImprimirTicket9, javax.swing.GroupLayout.PREFERRED_SIZE, 138, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addGap(24, 24, 24))
                                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                                                .addGap(69, 69, 69)
                                                .addComponent(jLabel186)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                .addComponent(Totalfactura9, javax.swing.GroupLayout.PREFERRED_SIZE, 165, javax.swing.GroupLayout.PREFERRED_SIZE))))
                                    .addGroup(jPanel2Layout.createSequentialGroup()
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(jScrollPane20)))))
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addComponent(jPanel19, javax.swing.GroupLayout.PREFERRED_SIZE, 71, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(19, 19, 19)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jLabel171, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(lbIDVenta9, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel172, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(lbFecha, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel20, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnCancelar)
                    .addComponent(btnRegistrarfactura9))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(comboModoConsulta9, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtConsultarproducto9, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnConsultar9, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnSeleccionar9, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane19, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(Cambio9, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(jLabel187, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(txtEfectivo9, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(jLabel188, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(900, 900, 900))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(jScrollPane20, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addGap(23, 23, 23)
                                .addComponent(btnRegistrardetalle9))
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addGap(18, 18, 18)
                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(jLabel186, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(Totalfactura9, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(btnRegistrarTotal9, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(btnImprimirTicket9, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE))))
                        .addGap(917, 917, 917))))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, 671, javax.swing.GroupLayout.PREFERRED_SIZE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void listo9ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_listo9ActionPerformed
        // TODO add your handling code here:
        double suma;

        String opcionmayoreo = cbxCategoría9.getSelectedItem().toString();
        if (opcionmayoreo.equals("Mayoreo")) {
            double precio = Double.parseDouble(PrecioMayoreoSeleccionado9.getText());
            int cant = Integer.parseInt(txtCantidad9.getText());
            suma = (precio * cant);
            TotalDetalle9.setText(String.valueOf(suma));
        }

        String opcionmenudeo = cbxCategoría9.getSelectedItem().toString();
        if (opcionmenudeo.equals("Menudeo")) {
            double precio = Double.parseDouble(Preciomenudeoseleccionado9.getText());
            int cant = Integer.parseInt(txtCantidad9.getText());
            suma = (precio * cant);
            TotalDetalle9.setText(String.valueOf(suma));
        }

        int restaexistencia;
        int cant = Integer.parseInt(txtCantidad9.getText());
        int exist = Integer.parseInt(ExistenciaSeleccionado9.getText());
        if (cant > exist) {
            JOptionPane.showMessageDialog(null, "Productos insuficientes");
        } else {
            restaexistencia = exist - cant;
            ExistenciaSeleccionado9.setText(String.valueOf(restaexistencia));
        }
    }//GEN-LAST:event_listo9ActionPerformed

    private void txtCantidad9KeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtCantidad9KeyReleased
        // TODO add your handling code here:
    }//GEN-LAST:event_txtCantidad9KeyReleased

    private void txtCantidad9ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtCantidad9ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtCantidad9ActionPerformed

    private void txtEfectivo9KeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtEfectivo9KeyReleased
        // TODO add your handling code here:

        double cambio;

        double efectivo = Double.parseDouble(txtEfectivo9.getText());
        double totalfactura = Double.parseDouble(Totalfactura9.getText());
        cambio = (efectivo - totalfactura);
        if (totalfactura > efectivo) {
            System.out.println("Dinero insuficiente");
        } else {
            Cambio9.setText(String.valueOf(cambio));
        }
    }//GEN-LAST:event_txtEfectivo9KeyReleased

    private void btnRegistrardetalle9ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnRegistrardetalle9ActionPerformed
        // TODO add your handling code here:
        TablaDetalle();
        Totalfactura9.setText(String.valueOf(sumandodetalle()));

        IDSeleccionado9.setText(null);
        NombreSeleccionado9.setText(null);
        MarcaSeleccionado9.setText(null);
        PrecioMayoreoSeleccionado9.setText(null);
        Preciomenudeoseleccionado9.setText(null);
        ExistenciaSeleccionado9.setText(null);
        txtCantidad9.setText(null);
        TotalDetalle9.setText(null);
        txtConsultarproducto9.setText(null);
    }//GEN-LAST:event_btnRegistrardetalle9ActionPerformed

    private void btnSeleccionar9ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSeleccionar9ActionPerformed
        // TODO add your handling code here:

        int fila = tabla9.getSelectedRow();
        if (fila >= 0) {
            IDSeleccionado9.setText(tabla9.getValueAt(fila, 0).toString());
            NombreSeleccionado9.setText(tabla9.getValueAt(fila, 1).toString());
            MarcaSeleccionado9.setText(tabla9.getValueAt(fila, 2).toString());
            ExistenciaSeleccionado9.setText(tabla9.getValueAt(fila, 3).toString());
            PrecioMayoreoSeleccionado9.setText(tabla9.getValueAt(fila, 5).toString());
            Preciomenudeoseleccionado9.setText(tabla9.getValueAt(fila, 6).toString());

        } else {
            JOptionPane.showMessageDialog(null, "Fila no seleccionada");
        }
    }//GEN-LAST:event_btnSeleccionar9ActionPerformed

    private void btnConsultar9ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnConsultar9ActionPerformed
        // TODO add your handling code here:
        mostrarTablaConsultarproductos("");
    }//GEN-LAST:event_btnConsultar9ActionPerformed

    private void txtConsultarproducto9KeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtConsultarproducto9KeyReleased
        // TODO add your handling code here:

        atributo = comboModoConsulta9.getSelectedItem().toString();
        mostrarTablaConsultarproductos(txtConsultarproducto9.getText());
    }//GEN-LAST:event_txtConsultarproducto9KeyReleased

    private void btnImprimirTicket9ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnImprimirTicket9ActionPerformed
        // TODO add your handling code here:
        
        try {
            // TODO add your handling code here:
            Conexion con = new Conexion();
            Connection conn = con.getConexion();
            
            JasperReport reporteAlumno = null;
            String path = "src\\Reportes\\factura.jasper";
            
            reporteAlumno = (JasperReport) JRLoader.loadObjectFromFile(path);
            
            JasperPrint jprint = JasperFillManager.fillReport(reporteAlumno, null, conn);
            
            JasperViewer view = new JasperViewer(jprint, false);
            
            view.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
            
            view.setVisible(true);
            
            bloquearparte1();
            btnRegistrarfactura9.setEnabled(true);
            
        } catch (JRException ex) {
            Logger.getLogger(frmRegistrarventa.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        

    }//GEN-LAST:event_btnImprimirTicket9ActionPerformed

    private void btnRegistrarTotal9ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnRegistrarTotal9ActionPerformed
        try {
            String Fecha = (((JTextField) lbFecha.getDateEditor().getUiComponent()).getText());
            System.out.println(Fecha);
            PreparedStatement pp = cn.prepareStatement("insert into venta(Precioventa_total, Efectivo,Cambio,Id_usuario) values("
                    + Totalfactura9.getText() + ", " + txtEfectivo9.getText() + ", "
                    + Cambio9.getText() + ", " + lbIDusuario9.getText() + ")");
            pp.executeUpdate();
        } catch (Exception ex) {
            Logger.getLogger(frmRegistrarventa.class.getName()).log(Level.SEVERE, null, ex);
        }

        if (jTable9.getRowCount() > 0) {
            for (int i = 0; i < jTable9.getRowCount(); i++) {
                try {
                    PreparedStatement pps = cn.prepareStatement("insert into detalle_venta(Id_venta, Id_producto, Cantidad, Precio_detalle) values("
                            + jTable9.getValueAt(i, 0) + ", " + jTable9.getValueAt(i, 1) + ", " + jTable9.getValueAt(i, 8) + ", "
                            + jTable9.getValueAt(i, 9) + ")");
                    pps.executeUpdate();

                    pps = cn.prepareStatement("update Producto set Existencia='" + jTable9.getValueAt(i, 2)
                            + "' where Id_producto='" + jTable9.getValueAt(i, 1) + "' ");
                    pps.executeUpdate();
                } catch (Exception ex) {
                    Logger.getLogger(frmRegistrarventa.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
            JOptionPane.showMessageDialog(this, "Datos guardados correctamente");

            txtConsultarproducto9.setEnabled(false);
            btnConsultar9.setEnabled(false);
            comboModoConsulta9.setEnabled(false);
            btnRegistrarfactura9.setEnabled(false);
            btnRegistrardetalle9.setEnabled(false);
            btnRegistrarTotal9.setEnabled(false);
            btnSeleccionar9.setEnabled(false);
            txtEfectivo9.setEnabled(false);
            listo9.setEnabled(false);
            cbxCategoría9.setEnabled(false);
            lbFecha.setEnabled(false);
            lbIDusuario9.setEnabled(false);
            lbIDVenta9.setEnabled(false);
        } else {
            JOptionPane.showMessageDialog(this, "La tabla está vacía");
        }
    }//GEN-LAST:event_btnRegistrarTotal9ActionPerformed

    private void btnCancelarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCancelarActionPerformed
        // TODO add your handling code here:
        bloquearparte1();
        btnRegistrarfactura9.setEnabled(true);
    }//GEN-LAST:event_btnCancelarActionPerformed

    private void btnRegistrarfactura9ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnRegistrarfactura9ActionPerformed
        // TODO add your handling code here:
        limpiartabla();
        consultaIdVenta();
        mostrarTablaConsultarproductos("");
        desbloquearparte1();
        consultausuario();
        mostraretiquetasusuario();
        btnRegistrarfactura9.setEnabled(false);
    }//GEN-LAST:event_btnRegistrarfactura9ActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel Cambio9;
    private javax.swing.JLabel ExistenciaSeleccionado9;
    private javax.swing.JLabel IDSeleccionado9;
    private javax.swing.JLabel MarcaSeleccionado9;
    private javax.swing.JLabel NombreSeleccionado9;
    private javax.swing.JLabel PrecioMayoreoSeleccionado9;
    private javax.swing.JLabel Preciomenudeoseleccionado9;
    private javax.swing.JLabel TotalDetalle9;
    private javax.swing.JLabel Totalfactura9;
    private javax.swing.JButton btnCancelar;
    public javax.swing.JButton btnConsultar9;
    private javax.swing.JButton btnImprimirTicket9;
    private javax.swing.JButton btnRegistrarTotal9;
    private javax.swing.JButton btnRegistrardetalle9;
    public javax.swing.JButton btnRegistrarfactura9;
    public javax.swing.JButton btnSeleccionar9;
    private javax.swing.JComboBox cbxCategoría9;
    public javax.swing.JComboBox comboModoConsulta9;
    private javax.swing.JLabel jLabel170;
    private javax.swing.JLabel jLabel171;
    private javax.swing.JLabel jLabel172;
    private javax.swing.JLabel jLabel177;
    private javax.swing.JLabel jLabel178;
    private javax.swing.JLabel jLabel179;
    private javax.swing.JLabel jLabel180;
    private javax.swing.JLabel jLabel181;
    private javax.swing.JLabel jLabel182;
    private javax.swing.JLabel jLabel183;
    private javax.swing.JLabel jLabel184;
    private javax.swing.JLabel jLabel185;
    private javax.swing.JLabel jLabel186;
    private javax.swing.JLabel jLabel187;
    private javax.swing.JLabel jLabel188;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JPanel jPanel19;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel20;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JScrollPane jScrollPane19;
    private javax.swing.JScrollPane jScrollPane20;
    private javax.swing.JTable jTable9;
    public javax.swing.JLabel lbApellidoUsuario9;
    private com.toedter.calendar.JDateChooser lbFecha;
    public javax.swing.JLabel lbIDVenta9;
    public javax.swing.JLabel lbIDusuario9;
    public javax.swing.JLabel lbNombreusuario9;
    public javax.swing.JLabel lblAmaternoUsuario9;
    private javax.swing.JButton listo9;
    private javax.swing.JTable tabla9;
    private javax.swing.JTextField txtCantidad9;
    public javax.swing.JTextField txtConsultarproducto9;
    private javax.swing.JTextField txtEfectivo9;
    // End of variables declaration//GEN-END:variables
}
