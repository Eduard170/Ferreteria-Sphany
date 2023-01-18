package Controlador;

import Modelo.Conexion;
import Modelo.ConsultasUsuario;
import Modelo.Usuario;
import Vista.frmAdministrarusuarios;
import Vista.frmPrincipal;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
public class CtrlRegistrarUsuario implements ActionListener {

    private Usuario usu;
    private ConsultasUsuario conusu;
    private frmAdministrarusuarios intusu;
    private frmPrincipal principal;

    public CtrlRegistrarUsuario(Usuario usu, ConsultasUsuario conusu, frmAdministrarusuarios intusu) {
        this.usu = usu;
        this.conusu = conusu;
        this.intusu = intusu;
        this.intusu.btnRegistrar.addActionListener(this);
        this.intusu.btnAgregarusuario.addActionListener(this);
        this.intusu.btnLimpiar.addActionListener(this);
        this.intusu.btnActualizar.addActionListener(this);
    }

    Conexion con = new Conexion();
    Connection cn = con.getConexion();
    String atributo = "Id_usuario";

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
        modelo.addColumn("Correo electrónico");
        modelo.addColumn("Sexo");
        modelo.addColumn("Numero");
        modelo.addColumn("Calle");
        modelo.addColumn("Colonia");
        modelo.addColumn("Ciudad");
        modelo.addColumn("Rol");

        intusu.Tablaregistrarproductos.setModel(modelo);

        String sql = "";
        if (valor.equals("")) {
            sql = "select c.Id_usuario, c.Nombre, c.A_paterno, c.A_materno, c.correo_electronico, c.Sexo, c.Numero, c.Calle, c.Colonia, c.Ciudad, d.Rol from Usuario c, Rol_usuario d where d.id_usuario=c.id_usuario";
        } else {
            sql = "select * from usuario where " + atributo + "='" + valor + "'";
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
            intusu.Tablaregistrarproductos.setModel(modelo);
        } catch (SQLException ex) {
            System.out.println("Error");
        }
    }

    void bloquear() {
        intusu.txtIdUsuario.setEnabled(false);
        intusu.txtNombreUsuario.setEnabled(false);
        intusu.txtApellidoMaterno.setEnabled(false);
        intusu.txtApellidoPaterno.setEnabled(false);
        intusu.txtCiudad.setEnabled(false);
        intusu.sexo.setEnabled(false);
        intusu.txtContrasenia.setEnabled(false);
        intusu.txtNumero.setEnabled(false);
        intusu.txtCiudad.setEnabled(false);
        intusu.txtCalle.setEnabled(false);
        intusu.txtColonia.setEnabled(false);
        intusu.txtEmail.setEnabled(false);
        intusu.txtRol.setEnabled(false);
    }

    void limpiar() {
        intusu.txtIdUsuario.setText(null);
        intusu.txtNombreUsuario.setText(null);
        intusu.txtApellidoMaterno.setText(null);
        intusu.txtApellidoPaterno.setText(null);
        intusu.txtCiudad.setText(null);
        intusu.txtContrasenia.setText(null);
        intusu.txtNumero.setText(null);
        intusu.txtCiudad.setText(null);
        intusu.txtCalle.setText(null);
        intusu.txtColonia.setText(null);
        intusu.txtEmail.setText(null);
        intusu.txtRol.setText(null);
        intusu.txtContrasenia.setText(null);
    }

    void desbloquear() {
        intusu.txtNombreUsuario.setEnabled(true);
        intusu.txtApellidoMaterno.setEnabled(true);
        intusu.txtApellidoPaterno.setEnabled(true);
        intusu.txtCiudad.setEnabled(true);
        intusu.txtContrasenia.setEnabled(true);
        intusu.txtNumero.setEnabled(true);
        intusu.sexo.setEnabled(true);
        intusu.txtCiudad.setEnabled(true);
        intusu.txtCalle.setEnabled(true);
        intusu.txtColonia.setEnabled(true);
        intusu.txtEmail.setEnabled(true);
        intusu.txtRol.setText("Vendedor");
        intusu.txtRol.setEnabled(false);

    }

    public void actionPerformed(ActionEvent e) {

        if (e.getSource() == intusu.btnAgregarusuario) {
            if (conusu.buscarId(usu)) {
                intusu.txtIdUsuario.setText(String.valueOf(usu.getIdUsuario()));
                desbloquear();
            }
        }

        if (e.getSource() == intusu.btnRegistrar) {
            usu.setNombre(intusu.txtNombreUsuario.getText());
            usu.setA_paterno(intusu.txtApellidoPaterno.getText());
            usu.setA_materno(intusu.txtApellidoMaterno.getText());
            usu.setEmail(intusu.txtEmail.getText());
            usu.setSexo(intusu.sexo.getSelectedItem().toString());
            usu.setNumeroexterior(Integer.parseInt(intusu.txtNumero.getText()));
            usu.setCalle(intusu.txtCalle.getText());
            usu.setColonia(intusu.txtColonia.getText());
            usu.setCiudad(intusu.txtCiudad.getText());
            usu.setRol(intusu.txtRol.getText());
            usu.setContraseña(intusu.txtContrasenia.getText());

            if (conusu.registrarusuario(usu)) {
                JOptionPane.showMessageDialog(null, "Registro guardado");
                mostrartabla("");
            } else {
                JOptionPane.showMessageDialog(null, "Error al guardar");

            }

        }

        if (e.getSource() == intusu.btnActualizar) {
            mostrartabla("");
        }

        if (e.getSource() == intusu.btnLimpiar) {
            limpiar();
        }

    }

}
