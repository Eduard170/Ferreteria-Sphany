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
public class CtrlEliminarProducto implements ActionListener,  KeyListener{
    private Producto pto;
    private ConsultasProducto conpto;
    private frmAAdministrarproductos inteto;
    private frmPrincipal principal;
    
      public CtrlEliminarProducto(Producto pto, ConsultasProducto conpto, frmAAdministrarproductos inteto) {
        this.pto = pto;
        this.conpto = conpto;
        this.inteto = inteto;
        this.inteto.btnConsultar2.addActionListener(this);
        this.inteto.btnMostrarproductos2.addActionListener(this);
        this.inteto.btnEliminarProducto.addActionListener(this);
        this.inteto.btnConfirmarEliminacion.addActionListener(this);
        this.inteto.btnActualizarTabla1.addActionListener(this);
        this.inteto.btnLimpiar2.addActionListener(this);
        this.inteto.txtConsultarproducto.addKeyListener(this);
    }

    Conexion con = new Conexion();
    Connection cn = con.getConexion();
    String atributo = "Id_producto";

    void desbloquear() {
        inteto.txtIdProducto5.setEnabled(false);
        inteto.txtNombreProducto5.setEnabled(true);
        inteto.txtContenidoProducto5.setEnabled(true);
        inteto.txtExistenciaProducto5.setEnabled(true);
        inteto.txtMarcaProducto5.setEnabled(true);
        inteto.txtPrecioMayoreoProducto5.setEnabled(true);
        inteto.txtPreciomenudeoProducto5.setEnabled(true);
        inteto.btnActualizarTabla.setEnabled(true);
        inteto.btnConfirmarEliminacion.setEnabled(true);
        inteto.btnLimpiar.setEnabled(true);
    }
    
    void bloquear() {
        inteto.txtIdProducto5.setEnabled(false);
        inteto.txtNombreProducto5.setEnabled(false);
        inteto.txtContenidoProducto5.setEnabled(false);
        inteto.txtExistenciaProducto5.setEnabled(false);
        inteto.txtMarcaProducto5.setEnabled(false);
        inteto.txtPrecioMayoreoProducto5.setEnabled(false);
        inteto.txtPreciomenudeoProducto5.setEnabled(false);
        inteto.btnActualizarTabla.setEnabled(false);
        inteto.btnConfirmarEliminacion.setEnabled(false);
        inteto.btnLimpiar.setEnabled(false);
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

        inteto.TablaregistrarproductosConsultar2.setModel(modelo);

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
            inteto.TablaregistrarproductosConsultar2.setModel(modelo);
        } catch (SQLException ex) {
            System.out.println("Error");
        }
    }

    void limpiar() {
        inteto.txtIdProducto5.setText(null);
        inteto.txtContenidoProducto5.setText(null);
        inteto.txtConsultarproducto.setText(null);
        inteto.txtMarcaProducto5.setText(null);
        inteto.txtNombreProducto5.setText(null);
        inteto.txtPrecioMayoreoProducto5.setText(null);
        inteto.txtPreciomenudeoProducto5.setText(null);
        inteto.txtExistenciaProducto5.setText(null);
       
    }

    public void actionPerformed(ActionEvent e) {

        if (e.getSource() == inteto.btnConsultar2) {
            atributo = inteto.comboModoConsulta2.getSelectedItem().toString();
            mostrarTablaConsultarproductos(inteto.txtConsultarproducto2.getText());
        }

        if (e.getSource() == inteto.btnMostrarproductos2) {
            mostrarTablaConsultarproductos("");
        }

        if (e.getSource() == inteto.btnEliminarProducto) {
            int fila = inteto.TablaregistrarproductosConsultar2.getSelectedRow();
            if (fila >= 0) {
                inteto.txtIdProducto5.setText(inteto.TablaregistrarproductosConsultar2.getValueAt(fila, 0).toString());
                inteto.txtNombreProducto5.setText(inteto.TablaregistrarproductosConsultar2.getValueAt(fila, 1).toString());
                inteto.txtMarcaProducto5.setText(inteto.TablaregistrarproductosConsultar2.getValueAt(fila, 2).toString());
                inteto.txtExistenciaProducto5.setText(inteto.TablaregistrarproductosConsultar2.getValueAt(fila, 3).toString());
                inteto.txtContenidoProducto5.setText(inteto.TablaregistrarproductosConsultar2.getValueAt(fila, 4).toString());
                inteto.txtPrecioMayoreoProducto5.setText(inteto.TablaregistrarproductosConsultar2.getValueAt(fila, 5).toString());
                inteto.txtPreciomenudeoProducto5.setText(inteto.TablaregistrarproductosConsultar2.getValueAt(fila, 6).toString());
                desbloquear();

            } else {
                JOptionPane.showMessageDialog(null, "Fila no seleccionada");
            }
        }

        if (e.getSource() == inteto.btnConfirmarEliminacion) {
            try {
                PreparedStatement pps = cn.prepareStatement("delete from producto where Id_producto=" + inteto.txtIdProducto5.getText() + " ");
                pps.executeUpdate();

                pps = cn.prepareStatement("delete from Detalle_de_producto where Id_producto=" + inteto.txtIdProducto5.getText() + " ");
                pps.executeUpdate();
                JOptionPane.showMessageDialog(null, "Datos eliminados");
                mostrarTablaConsultarproductos("");
            } catch (SQLException ex) {
                Logger.getLogger(frmPrincipal.class.getName()).log(Level.SEVERE, null, ex);
            }

        }

        if (e.getSource() == inteto.btnLimpiar2) {
            limpiar();
        }

        if (e.getSource() == inteto.btnActualizarTabla1) {
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
        if(e.getSource() == inteto.txtConsultarproducto2) {
            atributo = inteto.comboModoConsulta2.getSelectedItem().toString();
            mostrarTablaConsultarproductos(inteto.txtConsultarproducto2.getText());
        }
    }

}
