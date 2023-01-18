package Controlador;

import Modelo.Conexion;
import Modelo.ConsultasProveedor;
import Modelo.Proveedor;
import Vista.frmAdministrarproveedores;
import Vista.frmPrincipal;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

public class CtrlRegistrarproveedor implements ActionListener {

    private Proveedor pv;
    private ConsultasProveedor conpv;
    private frmAdministrarproveedores intpv;
    private frmPrincipal principal;

    public CtrlRegistrarproveedor(Proveedor pv, ConsultasProveedor conpv, frmAdministrarproveedores intpv) {
        this.pv = pv;
        this.conpv = conpv;
        this.intpv = intpv;
        this.intpv.btnRegistrar.addActionListener(this);
        this.intpv.btnAgregarproveedor.addActionListener(this);
        this.intpv.btnLimpiar.addActionListener(this);
        this.intpv.btnActualizar.addActionListener(this);
    }

    Conexion con = new Conexion();
    Connection cn = con.getConexion();
    String atributo = "Id_proveedor";

    public void iniciar() {
        mostrartabla("");
        bloquear();
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

        intpv.Tablaregistrarproductos.setModel(modelo);

        String sql = "";
        if (valor.equals("")) {
            sql = "select c.Id_proveedor, c.Nombre, c.A_paterno, c.A_materno, c.Numero, c.Calle, c.Colonia, c.Ciudad, d.Telefono from Proveedor c, num_telefono d where d.id_proveedor=c.id_proveedor";
        } else {
            sql = "select * from proveedor where " + atributo + "='" + valor + "'";
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
            intpv.Tablaregistrarproductos.setModel(modelo);
        } catch (SQLException ex) {
            System.out.println("Error");
        }
    }

    void bloquear() {
        intpv.txtIdProveedor.setEnabled(false);
        intpv.txtNombreUsuario.setEnabled(false);
        intpv.txtApellidoMaterno.setEnabled(false);
        intpv.txtApellidoPaterno.setEnabled(false);
        intpv.txtCiudad.setEnabled(false);
        intpv.txtNumero.setEnabled(false);
        intpv.txtCiudad.setEnabled(false);
        intpv.txtCalle.setEnabled(false);
        intpv.txtColonia.setEnabled(false);
        intpv.txtTelefono.setEnabled(false);
    }

    void limpiar() {
        intpv.txtIdProveedor.setText(null);
        intpv.txtNombreUsuario.setText(null);
        intpv.txtApellidoMaterno.setText(null);
        intpv.txtApellidoPaterno.setText(null);
        intpv.txtCiudad.setText(null);
        intpv.txtNumero.setText(null);
        intpv.txtCiudad.setText(null);
        intpv.txtCalle.setText(null);
        intpv.txtColonia.setText(null);
        intpv.txtTelefono.setText(null);
    }

    void desbloquear() {
        intpv.txtNombreUsuario.setEnabled(true);
        intpv.txtApellidoMaterno.setEnabled(true);
        intpv.txtApellidoPaterno.setEnabled(true);
        intpv.txtCiudad.setEnabled(true);
        intpv.txtIdProveedor.setEnabled(false);
        intpv.txtNumero.setEnabled(true);
        intpv.txtCiudad.setEnabled(true);
        intpv.txtCalle.setEnabled(true);
        intpv.txtColonia.setEnabled(true);
        intpv.txtTelefono.setEnabled(true);

    }

    public void actionPerformed(ActionEvent e) {

        if (e.getSource() == intpv.btnAgregarproveedor) {
            if (conpv.buscarId(pv)) {
                intpv.txtIdProveedor.setText(String.valueOf(pv.getId_proveedor()));
                desbloquear();
            }
        }

        if (e.getSource() == intpv.btnRegistrar) {
            pv.setNombre(intpv.txtNombreUsuario.getText());
            pv.setA_paterno(intpv.txtApellidoPaterno.getText());
            pv.setA_materno(intpv.txtApellidoMaterno.getText());
            pv.setNumero(Integer.parseInt(intpv.txtNumero.getText()));
            pv.setCalle(intpv.txtCalle.getText());
            pv.setColonia(intpv.txtColonia.getText());
            pv.setCiudad(intpv.txtCiudad.getText());
            pv.setTelefono(Integer.parseInt(intpv.txtTelefono.getText()));

            if (conpv.registrarproveedor(pv)) {
                JOptionPane.showMessageDialog(null, "Registro guardado");
                mostrartabla("");
            } else {
                JOptionPane.showMessageDialog(null, "Error al guardar");

            }

        }

        if (e.getSource() == intpv.btnActualizar) {
            mostrartabla("");
        }

        if (e.getSource() == intpv.btnLimpiar) {
            limpiar();
            bloquear();
        }

    }
}
