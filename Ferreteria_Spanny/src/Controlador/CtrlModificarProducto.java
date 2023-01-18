package Controlador;

import Modelo.Conexion;
import Modelo.ConsultasProducto;
import Modelo.Producto;
import Vista.frmAAdministrarproductos;
import Vista.frmPrincipal;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
public class CtrlModificarProducto implements ActionListener,  KeyListener {

    private Producto pto;
    private ConsultasProducto conpto;
    private frmAAdministrarproductos intmto;
    private frmPrincipal principal;

    public CtrlModificarProducto(Producto pto, ConsultasProducto conpto, frmAAdministrarproductos intmto) {
        this.pto = pto;
        this.conpto = conpto;
        this.intmto = intmto;
        this.intmto.btnConsultar1.addActionListener(this);
        this.intmto.btnMostrarproductos1.addActionListener(this);
        this.intmto.btnModificarProducto.addActionListener(this);
        this.intmto.btnGuardarcambios.addActionListener(this);
        this.intmto.btnActualizarTabla.addActionListener(this);
        this.intmto.btnLimpiar1.addActionListener(this);
        this.intmto.txtConsultarproducto1.addKeyListener(this);
    }

    Conexion con = new Conexion();
    Connection cn = con.getConexion();
    String atributo = "Id_producto";

    void desbloquear() {
        intmto.txtIdProducto4.setEnabled(false);
        intmto.txtNombreProducto4.setEnabled(true);
        intmto.txtContenidoProducto4.setEnabled(true);
        intmto.txtExistenciaProducto4.setEnabled(true);
        intmto.txtMarcaProducto4.setEnabled(true);
        intmto.txtPrecioMayoreoProducto4.setEnabled(true);
        intmto.txtPreciomenudeoProducto4.setEnabled(true);
        intmto.btnActualizarTabla.setEnabled(true);
        intmto.btnGuardarcambios.setEnabled(true);
        intmto.btnLimpiar.setEnabled(true);
    }
    
    void bloquear() {
        intmto.txtIdProducto4.setEnabled(false);
        intmto.txtNombreProducto4.setEnabled(false);
        intmto.txtContenidoProducto4.setEnabled(false);
        intmto.txtExistenciaProducto4.setEnabled(false);
        intmto.txtMarcaProducto4.setEnabled(false);
        intmto.txtPrecioMayoreoProducto4.setEnabled(false);
        intmto.txtPreciomenudeoProducto4.setEnabled(false);
        intmto.btnActualizarTabla.setEnabled(false);
        intmto.btnGuardarcambios.setEnabled(false);
        intmto.btnLimpiar.setEnabled(false);
    }
    
     public void iniciar(){
        mostrarTablaConsultarproductos("");   
    }

    public void mostrarTablaConsultarproductos(String valor) {
        DefaultTableModel modelo = new DefaultTableModel();
        modelo.addColumn("ID");
        modelo.addColumn("Nombre");
        modelo.addColumn("Marca");
        modelo.addColumn("Existencia");
        modelo.addColumn("Contenido");
        modelo.addColumn("Precio mayoreo");
        modelo.addColumn("Precio menudeo");

        intmto.TablaregistrarproductosConsultar1.setModel(modelo);

        String sql = "";
        if (valor.equals("")) {
            sql = "select c.Id_producto, c.Nombre, c.Marca, c.Existencia, d.Contenido, d.Precio_mayoreo, d.Precio_menudeo from Producto c, Detalle_de_producto d where d.id_producto=c.id_producto";
        } else {

            sql = "select c.Id_producto, c.Nombre, c.Marca, c.Existencia, d.Contenido, d.Precio_mayoreo, d.Precio_menudeo from Producto c, Detalle_de_producto d where d.id_producto=c.id_producto and c." +atributo + " like '" + valor + "%'";
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
            intmto.TablaregistrarproductosConsultar1.setModel(modelo);
        } catch (SQLException ex) {
            System.out.println("Error");
        }
    }

    void limpiar() {
        intmto.txtIdProducto4.setText(null);
        intmto.txtContenidoProducto4.setText(null);
        intmto.txtConsultarproducto1.setText(null);
        intmto.txtMarcaProducto4.setText(null);
        intmto.txtNombreProducto4.setText(null);
        intmto.txtPrecioMayoreoProducto4.setText(null);
        intmto.txtPreciomenudeoProducto4.setText(null);
        intmto.txtExistenciaProducto4.setText(null);
       
    }

    public void actionPerformed(ActionEvent e) {

        if (e.getSource() == intmto.btnConsultar1) {
            atributo = intmto.comboModoConsulta1.getSelectedItem().toString();
            mostrarTablaConsultarproductos(intmto.txtConsultarproducto1.getText());
        }

        if (e.getSource() == intmto.btnMostrarproductos1) {
            mostrarTablaConsultarproductos("");
        }

        if (e.getSource() == intmto.btnModificarProducto) {
            int fila = intmto.TablaregistrarproductosConsultar1.getSelectedRow();
            if (fila >= 0) {
                intmto.txtIdProducto4.setText(intmto.TablaregistrarproductosConsultar1.getValueAt(fila, 0).toString());
                intmto.txtNombreProducto4.setText(intmto.TablaregistrarproductosConsultar1.getValueAt(fila, 1).toString());
                intmto.txtMarcaProducto4.setText(intmto.TablaregistrarproductosConsultar1.getValueAt(fila, 2).toString());
                intmto.txtExistenciaProducto4.setText(intmto.TablaregistrarproductosConsultar1.getValueAt(fila, 3).toString());
                intmto.txtContenidoProducto4.setText(intmto.TablaregistrarproductosConsultar1.getValueAt(fila, 4).toString());
                intmto.txtPrecioMayoreoProducto4.setText(intmto.TablaregistrarproductosConsultar1.getValueAt(fila, 5).toString());
                intmto.txtPreciomenudeoProducto4.setText(intmto.TablaregistrarproductosConsultar1.getValueAt(fila, 6).toString());
                desbloquear();

            } else {
                JOptionPane.showMessageDialog(null, "Fila no seleccionada");
            }
        }

        if (e.getSource() == intmto.btnGuardarcambios) {
            try {
                PreparedStatement pps = cn.prepareStatement("update producto set Nombre='" + intmto.txtNombreProducto4.getText() + "', marca='" + intmto.txtMarcaProducto4.getText() + "', existencia='" + intmto.txtExistenciaProducto4.getText() + "' where Id_producto='" + intmto.txtIdProducto4.getText() + "' ");
                pps.executeUpdate();

                pps = cn.prepareStatement("update Detalle_de_producto set contenido='" + intmto.txtContenidoProducto4.getText() + "', precio_mayoreo='" + intmto.txtPrecioMayoreoProducto4.getText() + "', precio_menudeo='" + intmto.txtPreciomenudeoProducto4.getText() + "' where Id_producto='" + intmto.txtIdProducto4.getText() + "' ");
                pps.executeUpdate();
                JOptionPane.showMessageDialog(null, "Datos actualizados");
                mostrarTablaConsultarproductos("");
            } catch (SQLException ex) {
                Logger.getLogger(frmPrincipal.class.getName()).log(Level.SEVERE, null, ex);
            }

        }

        if (e.getSource() == intmto.btnLimpiar1) {
            limpiar();
        }

        if (e.getSource() == intmto.btnActualizarTabla) {
            mostrarTablaConsultarproductos("");
        }
    }

    @Override
    public void keyTyped(KeyEvent e) {
    }

    @Override
    public void keyPressed(KeyEvent e) {
    }

    @Override
    public void keyReleased(KeyEvent e) {
        if(e.getSource() == intmto.txtConsultarproducto1) {
            atributo = intmto.comboModoConsulta1.getSelectedItem().toString();
            mostrarTablaConsultarproductos(intmto.txtConsultarproducto1.getText());
        }
    }

}
