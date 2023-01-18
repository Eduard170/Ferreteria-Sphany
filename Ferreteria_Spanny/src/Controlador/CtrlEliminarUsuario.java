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
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
public class CtrlEliminarUsuario implements ActionListener, KeyListener {

    private Usuario usu;
    private ConsultasUsuario conusu;
    private frmAdministrarusuarios intusu;
    private frmPrincipal principal;

    public CtrlEliminarUsuario(Usuario usu, ConsultasUsuario conusu, frmAdministrarusuarios intusu) {
        this.usu = usu;
        this.conusu = conusu;
        this.intusu = intusu;
        this.intusu.btnConsultar5.addActionListener(this);
        this.intusu.btnMostrarusuarios5.addActionListener(this);
        this.intusu.btnEliminarUsuario5.addActionListener(this);
        this.intusu.btnGuardarcambios5.addActionListener(this);
        this.intusu.btnActualizarTabla5.addActionListener(this);
        this.intusu.btnLimpiar5.addActionListener(this);
        this.intusu.txtConsultarusuario5.addKeyListener(this);
    }

    public void iniciar() {
        mostrartabla("");
        bloquear();
    }

    Conexion con = new Conexion();
    Connection cn = con.getConexion();
    String atributo = "Id_usuario";

    void bloquear() {
        intusu.txtIdUsuario5.setEnabled(false);
        intusu.txtNombreUsuario5.setEnabled(false);
        intusu.txtApellidoMaterno5.setEnabled(false);
        intusu.txtApellidoPaterno5.setEnabled(false);
        intusu.txtCiudad5.setEnabled(false);
        intusu.txtContrasenia5.setEnabled(false);
        intusu.txtNumero5.setEnabled(false);
        intusu.txtCiudad5.setEnabled(false);
        intusu.txtCalle5.setEnabled(false);
        intusu.txtColonia5.setEnabled(false);
        intusu.txtEmail5.setEnabled(false);
        intusu.txtRol5.setEnabled(false);
    }

    void limpiar() {
        intusu.txtIdUsuario5.setText(null);
        intusu.txtNombreUsuario5.setText(null);
        intusu.txtApellidoMaterno5.setText(null);
        intusu.txtApellidoPaterno5.setText(null);
        intusu.txtCiudad5.setText(null);
        intusu.txtContrasenia5.setText(null);
        intusu.txtNumero5.setText(null);
        intusu.txtCiudad5.setText(null);
        intusu.txtCalle5.setText(null);
        intusu.txtColonia5.setText(null);
        intusu.txtEmail5.setText(null);
        intusu.txtRol5.setText(null);
        intusu.txtContrasenia5.setText(null);
    }

    void desbloquear() {
        intusu.txtIdUsuario5.setEnabled(false);
        intusu.txtNombreUsuario5.setEnabled(true);
        intusu.txtApellidoMaterno5.setEnabled(true);
        intusu.txtApellidoPaterno5.setEnabled(true);
        intusu.txtCiudad5.setEnabled(true);
        intusu.txtContrasenia5.setEnabled(false);
        intusu.txtNumero5.setEnabled(true);
        intusu.txtCiudad5.setEnabled(true);
        intusu.txtCalle5.setEnabled(true);
        intusu.txtColonia5.setEnabled(true);
        intusu.txtEmail5.setEnabled(true);
        intusu.txtRol5.setEnabled(false);

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

        intusu.Tablausuarios5.setModel(modelo);

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
            intusu.Tablausuarios5.setModel(modelo);
        } catch (SQLException ex) {
            System.out.println("Error");
        }
    }
    

    public void actionPerformed(ActionEvent e) {

        if (e.getSource() == intusu.btnConsultar5) {
            atributo = intusu.comboModoConsulta5.getSelectedItem().toString();
            mostrartabla(intusu.txtConsultarusuario5.getText());
        }

        if (e.getSource() == intusu.btnMostrarusuarios5) {
            mostrartabla("");
        }

        if (e.getSource() == intusu.btnEliminarUsuario5) {
            int fila = intusu.Tablausuarios5.getSelectedRow();
            if (fila >= 0) {
                intusu.txtIdUsuario5.setText(intusu.Tablausuarios5.getValueAt(fila, 0).toString());
                intusu.txtNombreUsuario5.setText(intusu.Tablausuarios5.getValueAt(fila, 1).toString());
                intusu.txtApellidoPaterno5.setText(intusu.Tablausuarios5.getValueAt(fila, 2).toString());
                intusu.txtApellidoMaterno5.setText(intusu.Tablausuarios5.getValueAt(fila, 3).toString());
                intusu.txtEmail5.setText(intusu.Tablausuarios5.getValueAt(fila, 4).toString());
                intusu.sexo5.setSelectedItem(intusu.Tablausuarios5.getValueAt(fila, 5).toString());
                intusu.txtNumero5.setText(intusu.Tablausuarios5.getValueAt(fila, 6).toString());
                intusu.txtCalle5.setText(intusu.Tablausuarios5.getValueAt(fila, 7).toString());
                intusu.txtColonia5.setText(intusu.Tablausuarios5.getValueAt(fila, 8).toString());
                intusu.txtCiudad5.setText(intusu.Tablausuarios5.getValueAt(fila, 9).toString());
                intusu.txtRol5.setText(intusu.Tablausuarios5.getValueAt(fila, 10).toString());
                intusu.txtContrasenia5.setText("********");
                desbloquear();

            } else {
                JOptionPane.showMessageDialog(null, "Fila no seleccionada");
            }
        }

        if (e.getSource() == intusu.btnGuardarcambios5) {
            try {
                PreparedStatement pps = cn.prepareStatement("delete from usuario where Id_usuario=" + intusu.txtIdUsuario5.getText() + " ");
                pps.executeUpdate();

                pps = cn.prepareStatement("delete from rol_usuario where Id_usuario=" + intusu.txtIdUsuario5.getText() + " ");
                pps.executeUpdate();
                JOptionPane.showMessageDialog(null, "Datos eliminados");
                mostrartabla("");
            } catch (SQLException ex) {
                Logger.getLogger(frmPrincipal.class.getName()).log(Level.SEVERE, null, ex);
            }

        }

        if (e.getSource() == intusu.btnLimpiar5) {
            limpiar();
        }

        if (e.getSource() == intusu.btnActualizarTabla5) {
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
        if (e.getSource() == intusu.txtConsultarusuario5) {
            atributo = intusu.comboModoConsulta5.getSelectedItem().toString();
            mostrartabla(intusu.txtConsultarusuario5.getText());
        }
    }
}
