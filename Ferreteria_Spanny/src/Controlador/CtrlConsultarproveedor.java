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
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import javax.swing.table.DefaultTableModel;
public class CtrlConsultarproveedor implements ActionListener, KeyListener{
    private Proveedor pv;
    private ConsultasProveedor conpv;
    private frmAdministrarproveedores intcpv;
    private frmPrincipal principal;

    public CtrlConsultarproveedor(Proveedor pv, ConsultasProveedor conpv, frmAdministrarproveedores intcpv) {
        this.pv = pv;
        this.conpv = conpv;
        this.intcpv = intcpv;
        this.intcpv.btnConsultar3.addActionListener(this);
        this.intcpv.btnMostrarproveedores.addActionListener(this);
        this.intcpv.txtConsultarproveedor1.addKeyListener(this);
    
    }

    Conexion con = new Conexion();
    Connection cn = con.getConexion();
    String atributo = "Id_proveedor";

     public void iniciar() {
        mostrartabla("");
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

        intcpv.Tablaproveedor1.setModel(modelo);

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
            intcpv.Tablaproveedor1.setModel(modelo);
        } catch (SQLException ex) {
            System.out.println("Error");
        }
    }


    public void actionPerformed(ActionEvent e) {

        if (e.getSource() == intcpv.btnConsultar3) {
            atributo = intcpv.comboModoConsulta3.getSelectedItem().toString();
            mostrartabla(intcpv.txtConsultarproveedor1.getText());
        }

        if (e.getSource() == intcpv.btnMostrarproveedores) {
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
        if (e.getSource() == intcpv.txtConsultarproveedor1) {
            atributo = intcpv.comboModoConsulta3.getSelectedItem().toString();
            mostrartabla(intcpv.txtConsultarproveedor1.getText());
        }
    }
}
