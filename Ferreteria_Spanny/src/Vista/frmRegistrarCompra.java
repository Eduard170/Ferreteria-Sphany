package Vista;

import Controlador.CtrlCombo;
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

public class frmRegistrarCompra extends javax.swing.JInternalFrame {

    Conexion con = new Conexion();
    Connection cn = con.getConexion();
    CtrlCombo cb = new CtrlCombo();
    String atributo = "Id_proveedor";

    public frmRegistrarCompra() {
        initComponents();
        llenarComboProveedor();
        consultaIdCompra();
        jLabel12.setVisible(false);
        jLabel13.setVisible(false);
        jLabel14.setVisible(false);
        lbNombreproveedor.setVisible(false);
        lbApellidoProveedor.setVisible(false);
        lblAmaternoProveedor.setVisible(false);
    }
    
    void limpiar(){
        txtConsultarproducto.setText(null);
        txtCantidad9.setText(null);
        txtNombreProducto.setText(null);
        txtMarcaproducto.setText(null);
        txtConsultarproducto1.setText(null);
        txtExistenciaProducto.setText(null);
        Totalcompra.setText(null);
        txtPreciomayoreoproducto.setText(null);
        txtPreciomenudeoproducto.setText(null);
        txtContenido.setText(null);
        lbIDCompra.setText(null);
        lbFechacompra.setDate(null);
        comboidproveedor.setSelectedItem(0);
        lbNombreproveedor.setText(null);
        lbApellidoProveedor.setText(null);
        lblAmaternoProveedor.setText(null);
        txtIdProducto.setText(null);
        
        
    }

    void mostraretiquetaproveedor() {
        jLabel12.setVisible(true);
        jLabel13.setVisible(true);
        jLabel14.setVisible(true);
        lbNombreproveedor.setVisible(true);
        lbApellidoProveedor.setVisible(true);
        lblAmaternoProveedor.setVisible(true);
    }

    void consultaProveedor() {
        String sql = "";
        String atributo = comboidproveedor.getSelectedItem().toString();
        sql = "select nombre, A_paterno, A_materno from proveedor where id_proveedor" + "='" + atributo + "'";
        Statement st;
        try {
            st = cn.createStatement();
            ResultSet rs = st.executeQuery(sql);
            while (rs.next()) {
                lbNombreproveedor.setText(rs.getString(1));
                lbApellidoProveedor.setText(rs.getString(2));
                lblAmaternoProveedor.setText(rs.getString(3));
            }
        } catch (SQLException ex) {
            System.out.println("Error");
        }
    }

    void consultaIdCompra() {
        int contenidoID;
        String sql = "";
        sql = "SELECT MAX(Id_compra) AS Id_compra FROM Compra";
        Statement st;
        try {
            st = cn.createStatement();
            ResultSet rs = st.executeQuery(sql);
            while (rs.next()) {
                contenidoID = rs.getInt("Id_compra");
                int contenidototal = contenidoID + 1;

                lbIDCompra.setText(String.valueOf(contenidototal));
            }
        } catch (SQLException ex) {
            System.out.println("Error");
        }
    }

    public void llenarComboProveedor() {
        String consulta = "SELECT Id_proveedor FROM Proveedor";
        cb.llenarCombo(comboidproveedor, consulta, 1);
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

        TablaregistrarproductosConsultar.setModel(modelo);

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
            TablaregistrarproductosConsultar.setModel(modelo);
        } catch (SQLException ex) {
            System.out.println("Error");
        }
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel2 = new javax.swing.JPanel();
        jPanel20 = new javax.swing.JPanel();
        lbIDusuario9 = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        lbIDCompra = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();
        jLabel13 = new javax.swing.JLabel();
        lbApellidoProveedor = new javax.swing.JLabel();
        lbNombreproveedor = new javax.swing.JLabel();
        lblAmaternoProveedor = new javax.swing.JLabel();
        jLabel14 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        comboidproveedor = new javax.swing.JComboBox();
        lbFechacompra = new com.toedter.calendar.JDateChooser();
        Cambio9 = new javax.swing.JLabel();
        jPanel19 = new javax.swing.JPanel();
        jLabel170 = new javax.swing.JLabel();
        jPanel4 = new javax.swing.JPanel();
        jLabel177 = new javax.swing.JLabel();
        txtIdProducto = new javax.swing.JLabel();
        jLabel178 = new javax.swing.JLabel();
        txtPreciomenudeoproducto = new javax.swing.JLabel();
        jLabel180 = new javax.swing.JLabel();
        txtNombreProducto = new javax.swing.JLabel();
        jLabel179 = new javax.swing.JLabel();
        txtExistenciaProducto = new javax.swing.JLabel();
        jLabel181 = new javax.swing.JLabel();
        txtMarcaproducto = new javax.swing.JLabel();
        jLabel183 = new javax.swing.JLabel();
        txtPreciomayoreoproducto = new javax.swing.JLabel();
        jLabel182 = new javax.swing.JLabel();
        txtContenido = new javax.swing.JLabel();
        comboModoConsulta = new javax.swing.JComboBox();
        txtConsultarproducto = new javax.swing.JTextField();
        comboModoConsulta1 = new javax.swing.JComboBox();
        btnMostrarproductos = new javax.swing.JButton();
        btnMostrarproductos1 = new javax.swing.JButton();
        btnEliminarProducto = new javax.swing.JButton();
        jLabel184 = new javax.swing.JLabel();
        txtCantidad9 = new javax.swing.JTextField();
        listo9 = new javax.swing.JButton();
        jLabel18 = new javax.swing.JLabel();
        jLabel19 = new javax.swing.JLabel();
        Totalcompra = new javax.swing.JLabel();
        btnRegistrarCompra = new javax.swing.JButton();
        jScrollPane2 = new javax.swing.JScrollPane();
        TablaregistrarproductosConsultar = new javax.swing.JTable();
        txtConsultarproducto1 = new javax.swing.JTextField();
        jButton1 = new javax.swing.JButton();

        jPanel2.setBackground(new java.awt.Color(0, 153, 153));

        jPanel20.setBackground(new java.awt.Color(0, 204, 204));
        jPanel20.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        lbIDusuario9.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N

        jLabel1.setText("ID Compra:");

        lbIDCompra.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        lbIDCompra.setPreferredSize(new java.awt.Dimension(0, 23));

        jLabel11.setText("Fecha:");

        jLabel12.setText("Nombre del proveedor:");

        jLabel13.setText("A. Paterno:");

        lbApellidoProveedor.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N

        lbNombreproveedor.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N

        lblAmaternoProveedor.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N

        jLabel14.setText("A. Materno:");

        jLabel3.setText("Proveedor:");

        comboidproveedor.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Seleccione ID" }));
        comboidproveedor.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                comboidproveedorItemStateChanged(evt);
            }
        });
        comboidproveedor.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                comboidproveedorActionPerformed(evt);
            }
        });

        lbFechacompra.setDateFormatString("yyyy/MM/dd HH:mm:ss");

        javax.swing.GroupLayout jPanel20Layout = new javax.swing.GroupLayout(jPanel20);
        jPanel20.setLayout(jPanel20Layout);
        jPanel20Layout.setHorizontalGroup(
            jPanel20Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel20Layout.createSequentialGroup()
                .addGap(19, 19, 19)
                .addGroup(jPanel20Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel20Layout.createSequentialGroup()
                        .addGroup(jPanel20Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel3)
                            .addComponent(jLabel1))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel20Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(lbIDCompra, javax.swing.GroupLayout.PREFERRED_SIZE, 149, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(comboidproveedor, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 149, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(jPanel20Layout.createSequentialGroup()
                        .addComponent(jLabel11)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(lbFechacompra, javax.swing.GroupLayout.PREFERRED_SIZE, 149, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(43, 43, 43)
                .addGroup(jPanel20Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel20Layout.createSequentialGroup()
                        .addComponent(jLabel14)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(lblAmaternoProveedor, javax.swing.GroupLayout.PREFERRED_SIZE, 231, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel20Layout.createSequentialGroup()
                        .addComponent(jLabel12)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(lbNombreproveedor, javax.swing.GroupLayout.PREFERRED_SIZE, 231, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel20Layout.createSequentialGroup()
                        .addComponent(jLabel13)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(lbApellidoProveedor, javax.swing.GroupLayout.PREFERRED_SIZE, 231, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(lbIDusuario9, javax.swing.GroupLayout.PREFERRED_SIZE, 231, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(43, Short.MAX_VALUE))
        );
        jPanel20Layout.setVerticalGroup(
            jPanel20Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel20Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(lbIDusuario9, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(58, 58, 58))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel20Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel20Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel20Layout.createSequentialGroup()
                        .addGroup(jPanel20Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(lbIDCompra, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 13, Short.MAX_VALUE)
                        .addGroup(jPanel20Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel11, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(lbFechacompra, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanel20Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jLabel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(comboidproveedor, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(jPanel20Layout.createSequentialGroup()
                        .addGroup(jPanel20Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(lbNombreproveedor, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jLabel12, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel20Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(lbApellidoProveedor, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel13, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel20Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(lblAmaternoProveedor, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel14, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addGap(19, 19, 19))
        );

        Cambio9.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N

        jPanel19.setBackground(new java.awt.Color(0, 102, 102));
        jPanel19.setBorder(new javax.swing.border.MatteBorder(null));

        jLabel170.setFont(new java.awt.Font("Algerian", 1, 24)); // NOI18N
        jLabel170.setForeground(new java.awt.Color(255, 255, 255));
        jLabel170.setText("Registrar compra");

        javax.swing.GroupLayout jPanel19Layout = new javax.swing.GroupLayout(jPanel19);
        jPanel19.setLayout(jPanel19Layout);
        jPanel19Layout.setHorizontalGroup(
            jPanel19Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel19Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel170)
                .addGap(414, 414, 414))
        );
        jPanel19Layout.setVerticalGroup(
            jPanel19Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel19Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel170, javax.swing.GroupLayout.PREFERRED_SIZE, 48, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanel4.setBackground(new java.awt.Color(255, 255, 255));
        jPanel4.setBorder(new javax.swing.border.MatteBorder(null));

        jLabel177.setText("ID:");

        txtIdProducto.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N

        jLabel178.setText("Precio Menudeo:");

        txtPreciomenudeoproducto.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N

        jLabel180.setText("Nombre:");

        txtNombreProducto.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N

        jLabel179.setText("Existencia:");

        txtExistenciaProducto.setFont(new java.awt.Font("Tahoma", 3, 11)); // NOI18N

        jLabel181.setText("Marca:");

        txtMarcaproducto.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N

        jLabel183.setText("Precio Mayoreo:");

        txtPreciomayoreoproducto.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N

        jLabel182.setText("Contenido:");

        txtContenido.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addComponent(jLabel179)
                        .addGap(18, 18, 18)
                        .addComponent(txtExistenciaProducto, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addComponent(jLabel182)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txtContenido, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                        .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel4Layout.createSequentialGroup()
                            .addComponent(jLabel177)
                            .addGap(18, 18, 18)
                            .addComponent(txtIdProducto, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel4Layout.createSequentialGroup()
                            .addComponent(jLabel180)
                            .addGap(18, 18, 18)
                            .addComponent(txtNombreProducto, javax.swing.GroupLayout.DEFAULT_SIZE, 98, Short.MAX_VALUE)))
                    .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                        .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel4Layout.createSequentialGroup()
                            .addComponent(jLabel178)
                            .addGap(18, 18, 18)
                            .addComponent(txtPreciomenudeoproducto, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addGroup(jPanel4Layout.createSequentialGroup()
                            .addComponent(jLabel183)
                            .addGap(18, 18, 18)
                            .addComponent(txtPreciomayoreoproducto, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addGroup(jPanel4Layout.createSequentialGroup()
                            .addComponent(jLabel181)
                            .addGap(18, 18, 18)
                            .addComponent(txtMarcaproducto, javax.swing.GroupLayout.PREFERRED_SIZE, 110, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addGap(118, 118, 118))
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jLabel177, javax.swing.GroupLayout.DEFAULT_SIZE, 21, Short.MAX_VALUE)
                    .addComponent(txtIdProducto, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jLabel180, javax.swing.GroupLayout.DEFAULT_SIZE, 21, Short.MAX_VALUE)
                    .addComponent(txtNombreProducto, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel179)
                    .addComponent(txtExistenciaProducto, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jLabel181, javax.swing.GroupLayout.DEFAULT_SIZE, 21, Short.MAX_VALUE)
                    .addComponent(txtMarcaproducto, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel183, javax.swing.GroupLayout.PREFERRED_SIZE, 21, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtPreciomayoreoproducto, javax.swing.GroupLayout.PREFERRED_SIZE, 21, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jLabel178, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(txtPreciomenudeoproducto, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel182)
                    .addComponent(txtContenido, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(40, Short.MAX_VALUE))
        );

        comboModoConsulta.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Consultar por:", "Id_producto", "Nombre", "Marca" }));

        txtConsultarproducto.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtConsultarproductoKeyReleased(evt);
            }
        });

        comboModoConsulta1.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Consultar por:", "Id_producto", "Nombre", "Marca" }));

        btnMostrarproductos.setText("Mostrar todos los productos");
        btnMostrarproductos.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnMostrarproductosActionPerformed(evt);
            }
        });

        btnMostrarproductos1.setText("Listar productos");
        btnMostrarproductos1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnMostrarproductos1ActionPerformed(evt);
            }
        });

        btnEliminarProducto.setText("Seleccionar producto");
        btnEliminarProducto.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEliminarProductoActionPerformed(evt);
            }
        });

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

        listo9.setText("Precio");
        listo9.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                listo9ActionPerformed(evt);
            }
        });

        jLabel18.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel18.setText("Total factura:");

        jLabel19.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel19.setText("Total :");

        Totalcompra.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N

        btnRegistrarCompra.setText("Registrar Compra");
        btnRegistrarCompra.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnRegistrarCompraActionPerformed(evt);
            }
        });

        TablaregistrarproductosConsultar.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        TablaregistrarproductosConsultar.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {

            }
        ));
        jScrollPane2.setViewportView(TablaregistrarproductosConsultar);

        txtConsultarproducto1.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtConsultarproducto1KeyReleased(evt);
            }
        });

        jButton1.setText("Limpiar");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel19, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel20, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addComponent(comboModoConsulta1, javax.swing.GroupLayout.PREFERRED_SIZE, 151, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(txtConsultarproducto1, javax.swing.GroupLayout.PREFERRED_SIZE, 127, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(179, 179, 179)
                                .addComponent(btnMostrarproductos1)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(btnEliminarProducto, javax.swing.GroupLayout.PREFERRED_SIZE, 145, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 168, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGroup(jPanel2Layout.createSequentialGroup()
                                    .addComponent(jLabel184)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                    .addComponent(txtCantidad9, javax.swing.GroupLayout.PREFERRED_SIZE, 126, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                    .addComponent(listo9, javax.swing.GroupLayout.PREFERRED_SIZE, 77, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                    .addComponent(Cambio9, javax.swing.GroupLayout.PREFERRED_SIZE, 98, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGap(30, 30, 30)
                                    .addComponent(jLabel19)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                    .addComponent(Totalcompra, javax.swing.GroupLayout.PREFERRED_SIZE, 156, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                    .addComponent(btnRegistrarCompra, javax.swing.GroupLayout.PREFERRED_SIZE, 168, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addComponent(jScrollPane2, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 697, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addContainerGap(89, Short.MAX_VALUE))
            .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(jPanel2Layout.createSequentialGroup()
                    .addGap(504, 504, 504)
                    .addComponent(comboModoConsulta, javax.swing.GroupLayout.PREFERRED_SIZE, 151, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                    .addComponent(txtConsultarproducto, javax.swing.GroupLayout.PREFERRED_SIZE, 123, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addContainerGap(361, Short.MAX_VALUE)))
            .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(jPanel2Layout.createSequentialGroup()
                    .addGap(560, 560, 560)
                    .addComponent(btnMostrarproductos)
                    .addContainerGap(418, Short.MAX_VALUE)))
            .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(jPanel2Layout.createSequentialGroup()
                    .addGap(597, 597, 597)
                    .addComponent(jLabel18)
                    .addContainerGap(455, Short.MAX_VALUE)))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addComponent(jPanel19, javax.swing.GroupLayout.PREFERRED_SIZE, 71, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jPanel20, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(comboModoConsulta1, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnMostrarproductos1, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnEliminarProducto)
                    .addComponent(txtConsultarproducto1, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jPanel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE))
                .addGap(0, 0, Short.MAX_VALUE)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(Cambio9, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(25, 25, 25)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(Totalcompra, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(jLabel184, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(txtCantidad9, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(listo9, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(jLabel19, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(btnRegistrarCompra, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(843, 843, 843))
            .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(jPanel2Layout.createSequentialGroup()
                    .addGap(713, 713, 713)
                    .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(comboModoConsulta, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(txtConsultarproducto, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addContainerGap(714, Short.MAX_VALUE)))
            .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(jPanel2Layout.createSequentialGroup()
                    .addGap(713, 713, 713)
                    .addComponent(btnMostrarproductos, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addContainerGap(714, Short.MAX_VALUE)))
            .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(jPanel2Layout.createSequentialGroup()
                    .addGap(715, 715, 715)
                    .addComponent(jLabel18, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addContainerGap(715, Short.MAX_VALUE)))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, 671, javax.swing.GroupLayout.PREFERRED_SIZE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void listo9ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_listo9ActionPerformed
        // TODO add your handling code here:
        int sumaexistencia;
        int cant = Integer.parseInt(txtCantidad9.getText());
        int exist = Integer.parseInt(txtExistenciaProducto.getText());
        sumaexistencia = cant + exist;
        txtExistenciaProducto.setText(String.valueOf(sumaexistencia));

        double totalpresio;
        double presiomay = Double.parseDouble(txtPreciomayoreoproducto.getText());
        totalpresio = cant * presiomay;
        Totalcompra.setText(String.valueOf(totalpresio));
    }//GEN-LAST:event_listo9ActionPerformed

    private void txtCantidad9KeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtCantidad9KeyReleased
        // TODO add your handling code here:
    }//GEN-LAST:event_txtCantidad9KeyReleased

    private void txtCantidad9ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtCantidad9ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtCantidad9ActionPerformed

    private void comboidproveedorItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_comboidproveedorItemStateChanged
        // TODO add your handling code here:
    }//GEN-LAST:event_comboidproveedorItemStateChanged

    private void comboidproveedorActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_comboidproveedorActionPerformed
        // TODO add your handling code here:
        if (comboidproveedor.getSelectedItem() != null) {
            consultaProveedor();
            mostraretiquetaproveedor();
        }
    }//GEN-LAST:event_comboidproveedorActionPerformed

    private void txtConsultarproductoKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtConsultarproductoKeyReleased
        // TODO add your handling code here:

    }//GEN-LAST:event_txtConsultarproductoKeyReleased

    private void btnMostrarproductosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnMostrarproductosActionPerformed
        // TODO add your handling code here:
        mostrarTablaConsultarproductos("");
    }//GEN-LAST:event_btnMostrarproductosActionPerformed

    private void btnMostrarproductos1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnMostrarproductos1ActionPerformed
        // TODO add your handling code here:
        mostrarTablaConsultarproductos("");
    }//GEN-LAST:event_btnMostrarproductos1ActionPerformed

    private void btnEliminarProductoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEliminarProductoActionPerformed
        int fila = TablaregistrarproductosConsultar.getSelectedRow();
        if (fila >= 0) {
            txtIdProducto.setText(TablaregistrarproductosConsultar.getValueAt(fila, 0).toString());
            txtNombreProducto.setText(TablaregistrarproductosConsultar.getValueAt(fila, 1).toString());
            txtMarcaproducto.setText(TablaregistrarproductosConsultar.getValueAt(fila, 2).toString());
            txtExistenciaProducto.setText(TablaregistrarproductosConsultar.getValueAt(fila, 3).toString());
            txtContenido.setText(TablaregistrarproductosConsultar.getValueAt(fila, 4).toString());
            txtPreciomayoreoproducto.setText(TablaregistrarproductosConsultar.getValueAt(fila, 5).toString());
            txtPreciomenudeoproducto.setText(TablaregistrarproductosConsultar.getValueAt(fila, 6).toString());
        } else {
            JOptionPane.showMessageDialog(null, "Fila no seleccionada");
        }

    }//GEN-LAST:event_btnEliminarProductoActionPerformed

    private void btnRegistrarCompraActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnRegistrarCompraActionPerformed
        // TODO add your handling code here:
        try {
            PreparedStatement pp = cn.prepareStatement("insert into Compra(Precio_total, Cantidad_producto, Id_producto,Id_proveedor) values("
                    + Totalcompra.getText() + ", " + txtCantidad9.getText() + ", "
                    + txtIdProducto.getText() + ", " + comboidproveedor.getSelectedItem().toString() + ")");
            JOptionPane.showMessageDialog(null, "Compra registrada");
            pp.executeUpdate();

            pp = cn.prepareStatement("update Producto set Existencia='" + txtExistenciaProducto.getText()
                    + "' where Id_producto='" + txtIdProducto.getText() + "' ");
            pp.executeUpdate();
            mostrarTablaConsultarproductos("");
        } catch (Exception ex) {
            Logger.getLogger(frmRegistrarCompra.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_btnRegistrarCompraActionPerformed

    private void txtConsultarproducto1KeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtConsultarproducto1KeyReleased
        // TODO add your handling code here:
        atributo = comboModoConsulta1.getSelectedItem().toString();
        mostrarTablaConsultarproductos(txtConsultarproducto1.getText());
    }//GEN-LAST:event_txtConsultarproducto1KeyReleased

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        // TODO add your handling code here:
        limpiar();
    }//GEN-LAST:event_jButton1ActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel Cambio9;
    public javax.swing.JTable TablaregistrarproductosConsultar;
    private javax.swing.JLabel Totalcompra;
    public javax.swing.JButton btnEliminarProducto;
    public javax.swing.JButton btnMostrarproductos;
    public javax.swing.JButton btnMostrarproductos1;
    private javax.swing.JButton btnRegistrarCompra;
    public javax.swing.JComboBox comboModoConsulta;
    public javax.swing.JComboBox comboModoConsulta1;
    public javax.swing.JComboBox comboidproveedor;
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel170;
    private javax.swing.JLabel jLabel177;
    private javax.swing.JLabel jLabel178;
    private javax.swing.JLabel jLabel179;
    private javax.swing.JLabel jLabel18;
    private javax.swing.JLabel jLabel180;
    private javax.swing.JLabel jLabel181;
    private javax.swing.JLabel jLabel182;
    private javax.swing.JLabel jLabel183;
    private javax.swing.JLabel jLabel184;
    private javax.swing.JLabel jLabel19;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JPanel jPanel19;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel20;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JScrollPane jScrollPane2;
    public javax.swing.JLabel lbApellidoProveedor;
    private com.toedter.calendar.JDateChooser lbFechacompra;
    public javax.swing.JLabel lbIDCompra;
    public javax.swing.JLabel lbIDusuario9;
    public javax.swing.JLabel lbNombreproveedor;
    public javax.swing.JLabel lblAmaternoProveedor;
    private javax.swing.JButton listo9;
    private javax.swing.JTextField txtCantidad9;
    public javax.swing.JTextField txtConsultarproducto;
    public javax.swing.JTextField txtConsultarproducto1;
    private javax.swing.JLabel txtContenido;
    private javax.swing.JLabel txtExistenciaProducto;
    private javax.swing.JLabel txtIdProducto;
    private javax.swing.JLabel txtMarcaproducto;
    private javax.swing.JLabel txtNombreProducto;
    private javax.swing.JLabel txtPreciomayoreoproducto;
    private javax.swing.JLabel txtPreciomenudeoproducto;
    // End of variables declaration//GEN-END:variables
}
