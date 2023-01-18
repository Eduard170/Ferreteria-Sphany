package Controlador;

import Modelo.Conexion;
import Modelo.ConsultasProveedor;
import Modelo.Proveedor;
import Vista.frmAdministrarproveedores;
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
public class CtrlEliminarProveedor implements ActionListener, KeyListener {
    private Proveedor pv;
    private ConsultasProveedor conpv;
    private frmAdministrarproveedores intpv;
    private frmPrincipal principal;
    
     public CtrlEliminarProveedor(Proveedor pv, ConsultasProveedor conpv, frmAdministrarproveedores intpv) {
        this.pv = pv;
        this.conpv = conpv;
        this.intpv = intpv;
        this.intpv.btnConsultar4.addActionListener(this);
        this.intpv.btnMostrarproveedor1.addActionListener(this);
        this.intpv.btnEliminarProveedor.addActionListener(this);
        this.intpv.btnGuardarcambios1.addActionListener(this);
        this.intpv.btnActualizarTabla.addActionListener(this);
        this.intpv.btnLimpiar4.addActionListener(this);
        this.intpv.txtConsultarproveedor2.addKeyListener(this);
    }
    
     public void iniciar(){
        mostrartabla("");   
        bloquear();
    }
    
    Conexion con = new Conexion();
    Connection cn = con.getConexion();
    String atributo = "Id_proveedor";

   void bloquear() {
        intpv.txtIdProveedor2.setEnabled(false);
        intpv.txtNombreProveedor1.setEnabled(false);
        intpv.txtApellidoMaterno2.setEnabled(false);
        intpv.txtApellidoPaterno2.setEnabled(false);
        intpv.txtCiudad2.setEnabled(false);
        intpv.txtNumero2.setEnabled(false);
        intpv.txtCiudad2.setEnabled(false);
        intpv.txtCalle2.setEnabled(false);
        intpv.txtColonia2.setEnabled(false);
        intpv.txtTelefono2.setEnabled(false);
    }

    void limpiar() {
        intpv.txtIdProveedor2.setText(null);
        intpv.txtNombreProveedor1.setText(null);
        intpv.txtApellidoMaterno2.setText(null);
        intpv.txtApellidoPaterno2.setText(null);
        intpv.txtCiudad2.setText(null);
        intpv.txtNumero2.setText(null);
        intpv.txtCiudad2.setText(null);
        intpv.txtCalle2.setText(null);
        intpv.txtColonia2.setText(null);
        intpv.txtTelefono2.setText(null);
    }

    void desbloquear() {
        intpv.txtNombreProveedor1.setEnabled(true);
        intpv.txtApellidoMaterno2.setEnabled(true);
        intpv.txtApellidoPaterno2.setEnabled(true);
        intpv.txtCiudad2.setEnabled(true);
        intpv.txtIdProveedor2.setEnabled(false);
        intpv.txtNumero2.setEnabled(true);
        intpv.txtCiudad2.setEnabled(true);
        intpv.txtCalle2.setEnabled(true);
        intpv.txtColonia2.setEnabled(true);
        intpv.txtTelefono2.setEnabled(true);

    }
    
      void mostrartabla(String valor) {
        DefaultTableModel modelo = new DefaultTableModel();
        modelo.addColumn("ID");
        modelo.addColumn("Nombre");
        modelo.addColumn("A. paterno");
        modelo.addColumn("A. materno");
        modelo.addColumn("Numero");
        modelo.addColumn("Calle");
        modelo.addColumn("Colonia");
        modelo.addColumn("Ciudad");
        modelo.addColumn("Telefono");

        intpv.Tablaproveedor2.setModel(modelo);

        String sql = "";
        if (valor.equals("")) {
            sql = "select c.Id_proveedor, c.Nombre, c.A_paterno, c.A_materno, c.Numero, c.Calle, c.Colonia, c.Ciudad, d.telefono from Proveedor c, num_telefono d where d.id_proveedor=c.id_proveedor";
        } else {
            sql = "select c.Id_proveedor, c.Nombre, c.A_paterno, c.A_materno, c.Numero, c.Calle, c.Colonia, c.Ciudad, d.telefono from Proveedor c, num_telefono d where d.id_proveedor=c.id_proveedor and c." +atributo + " like '" + valor + "%'";
        }
        String datos[] = new String[9];
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
                datos[7] = rs.getString(8);
                datos[8] = rs.getString(9);
                modelo.addRow(datos);
            }
            intpv.Tablaproveedor2.setModel(modelo);
        } catch (SQLException ex) {
            System.out.println("Error");
        }
    }
     
      public void actionPerformed(ActionEvent e) {

        if (e.getSource() == intpv.btnConsultar4) {
            atributo = intpv.comboModoConsulta4.getSelectedItem().toString();
            mostrartabla(intpv.txtConsultarproveedor2.getText());
        }

        if (e.getSource() == intpv.btnMostrarproveedor1) {
            mostrartabla("");
        }

        if (e.getSource() == intpv.btnEliminarProveedor) {
            int fila = intpv.Tablaproveedor2.getSelectedRow();
            if (fila >= 0) {
                intpv.txtIdProveedor2.setText(intpv.Tablaproveedor2.getValueAt(fila, 0).toString());
                intpv.txtNombreProveedor1.setText(intpv.Tablaproveedor2.getValueAt(fila, 1).toString());
                intpv.txtApellidoPaterno2.setText(intpv.Tablaproveedor2.getValueAt(fila, 2).toString());
                intpv.txtApellidoMaterno2.setText(intpv.Tablaproveedor2.getValueAt(fila, 3).toString());
                intpv.txtNumero2.setText(intpv.Tablaproveedor2.getValueAt(fila, 4).toString());
                intpv.txtCalle2.setText(intpv.Tablaproveedor2.getValueAt(fila, 5).toString());
                intpv.txtColonia2.setText(intpv.Tablaproveedor2.getValueAt(fila, 6).toString());
                intpv.txtCiudad2.setText(intpv.Tablaproveedor2.getValueAt(fila, 7).toString());
                intpv.txtTelefono2.setText(intpv.Tablaproveedor2.getValueAt(fila, 8).toString());
                desbloquear();

            } else {
                JOptionPane.showMessageDialog(null, "Fila no seleccionada");
            }
        }

        if (e.getSource() == intpv.btnGuardarcambios1) {
            try {
                PreparedStatement pps = cn.prepareStatement("delete from Proveedor where Id_proveedor=" + intpv.txtIdProveedor2.getText() + " ");
                pps.executeUpdate();

                pps = cn.prepareStatement("delete from num_telefono where Id_proveedor=" + intpv.txtIdProveedor2.getText() + " ");
                pps.executeUpdate();
                JOptionPane.showMessageDialog(null, "Datos eliminados");
                mostrartabla("");
            } catch (SQLException ex) {
                Logger.getLogger(frmPrincipal.class.getName()).log(Level.SEVERE, null, ex);
            }

        }

        if (e.getSource() == intpv.btnLimpiar4) {
            limpiar();
            bloquear();
        }

        if (e.getSource() == intpv.btnActualizarTabla2) {
            mostrartabla("");
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
        if (e.getSource() == intpv.txtConsultarproveedor2) {
            atributo = intpv.comboModoConsulta4.getSelectedItem().toString();
            mostrartabla(intpv.txtConsultarproveedor2.getText());
        }
    }

}
