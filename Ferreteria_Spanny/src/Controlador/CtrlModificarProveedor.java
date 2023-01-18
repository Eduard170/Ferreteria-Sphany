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
public class CtrlModificarProveedor implements ActionListener, KeyListener {

    private Proveedor pv;
    private ConsultasProveedor conpv;
    private frmAdministrarproveedores intpv;
    private frmPrincipal principal;

    public CtrlModificarProveedor(Proveedor pv, ConsultasProveedor conpv, frmAdministrarproveedores intpv) {
        this.pv = pv;
        this.conpv = conpv;
        this.intpv = intpv;
        this.intpv.btnConsultar.addActionListener(this);
        this.intpv.btnMostrarproveedor.addActionListener(this);
        this.intpv.btnModificarProveedor.addActionListener(this);
        this.intpv.btnGuardarcambios.addActionListener(this);
        this.intpv.btnActualizarTabla.addActionListener(this);
        this.intpv.btnLimpiar3.addActionListener(this);
        this.intpv.txtConsultarproveedor.addKeyListener(this);
    }

    public void iniciar() {
        mostrartabla("");
        bloquear();
    }

    Conexion con = new Conexion();
    Connection cn = con.getConexion();
    String atributo = "Id_proveedor";

    void bloquear() {
        intpv.txtIdProveedor1.setEnabled(false);
        intpv.txtNombreProveedor.setEnabled(false);
        intpv.txtApellidoMaterno1.setEnabled(false);
        intpv.txtApellidoPaterno1.setEnabled(false);
        intpv.txtCiudad1.setEnabled(false);
        intpv.txtNumero1.setEnabled(false);
        intpv.txtCiudad1.setEnabled(false);
        intpv.txtCalle1.setEnabled(false);
        intpv.txtColonia1.setEnabled(false);
        intpv.txtTelefono1.setEnabled(false);
    }

    void limpiar() {
        intpv.txtIdProveedor1.setText(null);
        intpv.txtNombreProveedor.setText(null);
        intpv.txtApellidoMaterno1.setText(null);
        intpv.txtApellidoPaterno1.setText(null);
        intpv.txtCiudad1.setText(null);
        intpv.txtNumero1.setText(null);
        intpv.txtCiudad1.setText(null);
        intpv.txtCalle1.setText(null);
        intpv.txtColonia1.setText(null);
        intpv.txtTelefono1.setText(null);
    }

    void desbloquear() {
        intpv.txtNombreProveedor.setEnabled(true);
        intpv.txtApellidoMaterno1.setEnabled(true);
        intpv.txtApellidoPaterno1.setEnabled(true);
        intpv.txtCiudad1.setEnabled(true);
        intpv.txtIdProveedor1.setEnabled(false);
        intpv.txtNumero1.setEnabled(true);
        intpv.txtCiudad1.setEnabled(true);
        intpv.txtCalle1.setEnabled(true);
        intpv.txtColonia1.setEnabled(true);
        intpv.txtTelefono1.setEnabled(true);

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

        intpv.Tablaproveedor.setModel(modelo);

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
            intpv.Tablaproveedor.setModel(modelo);
        } catch (SQLException ex) {
            System.out.println("Error");
        }
    }

    public void actionPerformed(ActionEvent e) {

        if (e.getSource() == intpv.btnConsultar) {
            atributo = intpv.comboModoConsulta.getSelectedItem().toString();
            mostrartabla(intpv.txtConsultarproveedor.getText());
        }

        if (e.getSource() == intpv.btnMostrarproveedor) {
            mostrartabla("");
        }

        if (e.getSource() == intpv.btnModificarProveedor) {
            int fila = intpv.Tablaproveedor.getSelectedRow();
            if (fila >= 0) {
                intpv.txtIdProveedor1.setText(intpv.Tablaproveedor.getValueAt(fila, 0).toString());
                intpv.txtNombreProveedor.setText(intpv.Tablaproveedor.getValueAt(fila, 1).toString());
                intpv.txtApellidoPaterno1.setText(intpv.Tablaproveedor.getValueAt(fila, 2).toString());
                intpv.txtApellidoMaterno1.setText(intpv.Tablaproveedor.getValueAt(fila, 3).toString());
                intpv.txtNumero1.setText(intpv.Tablaproveedor.getValueAt(fila, 4).toString());
                intpv.txtCalle1.setText(intpv.Tablaproveedor.getValueAt(fila, 5).toString());
                intpv.txtColonia1.setText(intpv.Tablaproveedor.getValueAt(fila, 6).toString());
                intpv.txtCiudad1.setText(intpv.Tablaproveedor.getValueAt(fila, 7).toString());
                intpv.txtTelefono1.setText(intpv.Tablaproveedor.getValueAt(fila, 8).toString());
                desbloquear();

            } else {
                JOptionPane.showMessageDialog(null, "Fila no seleccionada");
            }
        }

        if (e.getSource() == intpv.btnGuardarcambios) {
            try {
                PreparedStatement pps = cn.prepareStatement("update Proveedor set Nombre='" + intpv.txtNombreProveedor.getText() + "', A_paterno='"
                        + intpv.txtApellidoPaterno1.getText() + "', A_materno='"
                        + intpv.txtApellidoMaterno1.getText() + "', Numero='"
                        + intpv.txtNumero1.getText() + "', Calle='" + intpv.txtCalle1.getText()
                        + "', Colonia='" + intpv.txtColonia1.getText() + "', Ciudad='"
                        + intpv.txtCiudad1.getText()
                        + "' where Id_proveedor='" + intpv.txtIdProveedor1.getText() + "' ");
                pps.executeUpdate();
                
                pps = cn.prepareStatement("update num_telefono set telefono='" + intpv.txtTelefono1.getText() 
                        + "' where Id_proveedor='" + intpv.txtIdProveedor1.getText() + "' ");
                pps.executeUpdate();
                JOptionPane.showMessageDialog(null, "Datos actualizados");
                mostrartabla("");
            } catch (SQLException ex) {
                Logger.getLogger(frmPrincipal.class.getName()).log(Level.SEVERE, null, ex);
            }

        }

        if (e.getSource() == intpv.btnLimpiar3) {
            limpiar();
            bloquear();
        }

        if (e.getSource() == intpv.btnActualizarTabla) {
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
        if (e.getSource() == intpv.txtConsultarproveedor) {
            atributo = intpv.comboModoConsulta.getSelectedItem().toString();
            mostrartabla(intpv.txtConsultarproveedor.getText());
        }
    }

}
