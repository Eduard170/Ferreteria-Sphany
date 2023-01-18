package Controlador;

import Modelo.Conexion;
import Modelo.ConsultasUsuario;
import Modelo.Usuario;
import Vista.frmAdministrarusuarios;
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
public class CtrlConsultarUsuario implements ActionListener, KeyListener {

    private Usuario usu;
    private ConsultasUsuario conusu;
    private frmAdministrarusuarios intusu;
    private frmPrincipal principal;

    public CtrlConsultarUsuario(Usuario usu, ConsultasUsuario conusu, frmAdministrarusuarios intusu) {
        this.usu = usu;
        this.conusu = conusu;
        this.intusu = intusu;
        this.intusu.btnConsultar1.addActionListener(this);
        this.intusu.btnMostrarproductos.addActionListener(this);
        this.intusu.txtConsultarusuario.addKeyListener(this);

    }

    Conexion con = new Conexion();
    Connection cn = con.getConexion();
    String atributo = "Id_usuario";

    public void iniciar() {
        mostrartabla("");
    }

    void mostrartabla(String valor) {
        DefaultTableModel modelo = new DefaultTableModel();
        modelo.addColumn("ID");
        modelo.addColumn("Nombre");
        modelo.addColumn("A. paterno");
        modelo.addColumn("A. materno");
        modelo.addColumn("Correo electrónico");
        modelo.addColumn("Sexo");
        modelo.addColumn("Numero");
        modelo.addColumn("Calle");
        modelo.addColumn("Colonia");
        modelo.addColumn("Ciudad");
        modelo.addColumn("Rol");

        intusu.TablaregistrarproductosConsultar.setModel(modelo);

        String sql = "";
        if (valor.equals("")) {
            sql = "select c.Id_usuario, c.Nombre, c.A_paterno, c.A_materno,  c.correo_electronico, c.Sexo, c.Numero, c.Calle, c.Colonia, c.Ciudad, d.Rol from Usuario c, Rol_usuario d where d.id_usuario=c.id_usuario";
        } else {
            sql = "select c.Id_usuario, c.Nombre, c.A_paterno, c.A_materno,  c.correo_electronico, c.Sexo, c.Numero, c.Calle, c.Colonia, c.Ciudad, d.Rol from Usuario c, Rol_usuario d where d.id_usuario=c.id_usuario  and c." + atributo + " like '" + valor + "%'";
        }
        String datos[] = new String[11];
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
                datos[9] = rs.getString(10);
                datos[10] = rs.getString(11);
                modelo.addRow(datos);
            }
            intusu.TablaregistrarproductosConsultar.setModel(modelo);
        } catch (SQLException ex) {
            System.out.println("Error");
        }
    }

    public void actionPerformed(ActionEvent e) {

        if (e.getSource() == intusu.btnConsultar1) {
            atributo = intusu.comboModoConsulta1.getSelectedItem().toString();
            mostrartabla(intusu.txtConsultarusuario.getText());
        }

        if (e.getSource() == intusu.btnMostrarproductos) {
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
        if (e.getSource() == intusu.txtConsultarusuario) {
            atributo = intusu.comboModoConsulta1.getSelectedItem().toString();
            mostrartabla(intusu.txtConsultarusuario.getText());
        }
    }
}
