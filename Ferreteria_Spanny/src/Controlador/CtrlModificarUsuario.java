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
public class CtrlModificarUsuario implements ActionListener, KeyListener {
     private Usuario usu;
    private ConsultasUsuario conusu;
    private frmAdministrarusuarios intusu;
    private frmPrincipal principal;
    
    
    public CtrlModificarUsuario(Usuario usu, ConsultasUsuario conusu, frmAdministrarusuarios intusu) {
        this.usu = usu;
        this.conusu = conusu;
        this.intusu = intusu;
        this.intusu.btnConsultar9.addActionListener(this);
        this.intusu.btnMostrarusuarios9.addActionListener(this);
        this.intusu.btnModificarUsuario9.addActionListener(this);
        this.intusu.btnGuardarcambios9.addActionListener(this);
        this.intusu.btnActualizarTabla9.addActionListener(this);
        this.intusu.btnLimpiar9.addActionListener(this);
        this.intusu.txtConsultarusuario9.addKeyListener(this);
    }
    
     public void iniciar(){
        mostrartabla("");   
        bloquear();
    }
    
    Conexion con = new Conexion();
    Connection cn = con.getConexion();
    String atributo = "Id_usuario";

    void bloquear() {
        intusu.txtIdUsuario9.setEnabled(false);
        intusu.txtNombreUsuario.setEnabled(false);
        intusu.txtApellidoMaterno9.setEnabled(false);
        intusu.txtApellidoPaterno.setEnabled(false);
        intusu.txtCiudad9.setEnabled(false);
        intusu.txtContrasenia9.setEnabled(false);
        intusu.txtNumero9.setEnabled(false);
        intusu.txtCiudad9.setEnabled(false);
        intusu.txtCalle9.setEnabled(false);
        intusu.txtColonia9.setEnabled(false);
        intusu.txtEmail9.setEnabled(false);
        intusu.txtRol9.setEnabled(false);
    }

    void limpiar() {
        intusu.txtIdUsuario9.setText(null);
        intusu.txtNombreUsuario9.setText(null);
        intusu.txtApellidoMaterno9.setText(null);
        intusu.txtApellidoPaterno9.setText(null);
        intusu.txtCiudad9.setText(null);
        intusu.txtContrasenia9.setText(null);
        intusu.txtNumero9.setText(null);
        intusu.txtCiudad9.setText(null);
        intusu.txtCalle9.setText(null);
        intusu.txtColonia9.setText(null);
        intusu.txtEmail9.setText(null);
        intusu.txtRol9.setText(null);
        intusu.txtContrasenia9.setText(null);
    }

    void desbloquear() {
        intusu.txtIdUsuario9.setEnabled(false);
        intusu.txtNombreUsuario.setEnabled(true);
        intusu.txtApellidoMaterno9.setEnabled(true);
        intusu.txtApellidoPaterno.setEnabled(true);
        intusu.txtCiudad9.setEnabled(true);
        intusu.txtContrasenia9.setEnabled(false);
        intusu.txtNumero9.setEnabled(true);
        intusu.txtCiudad9.setEnabled(true);
        intusu.txtCalle9.setEnabled(true);
        intusu.txtColonia9.setEnabled(true);
        intusu.txtEmail9.setEnabled(true);
        intusu.txtRol9.setEnabled(false);
        

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

        intusu.Tablausuarios9.setModel(modelo);

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
            intusu.Tablausuarios9.setModel(modelo);
        } catch (SQLException ex) {
            System.out.println("Error");
        }
    }
    
    public void actionPerformed(ActionEvent e) {

        if (e.getSource() == intusu.btnConsultar9) {
            atributo = intusu.comboModoConsulta9.getSelectedItem().toString();
            mostrartabla(intusu.txtConsultarusuario9.getText());
        }

        if (e.getSource() == intusu.btnMostrarusuarios9) {
            mostrartabla("");
        }

        if (e.getSource() == intusu.btnModificarUsuario9) {
            int fila = intusu.Tablausuarios9.getSelectedRow();
            if (fila >= 0) {
                intusu.txtIdUsuario9.setText(intusu.Tablausuarios9.getValueAt(fila, 0).toString());
                intusu.txtNombreUsuario9.setText(intusu.Tablausuarios9.getValueAt(fila, 1).toString());
                intusu.txtApellidoPaterno9.setText(intusu.Tablausuarios9.getValueAt(fila, 2).toString());
                intusu.txtApellidoMaterno9.setText(intusu.Tablausuarios9.getValueAt(fila, 3).toString());
                intusu.txtEmail9.setText(intusu.Tablausuarios9.getValueAt(fila, 4).toString());
                intusu.sexo.setSelectedItem(intusu.Tablausuarios9.getValueAt(fila, 5).toString());
                intusu.txtNumero9.setText(intusu.Tablausuarios9.getValueAt(fila, 6).toString());
                intusu.txtCalle9.setText(intusu.Tablausuarios9.getValueAt(fila, 7).toString());
                intusu.txtColonia9.setText(intusu.Tablausuarios9.getValueAt(fila, 8).toString());
                intusu.txtCiudad9.setText(intusu.Tablausuarios9.getValueAt(fila, 9).toString());
                intusu.txtRol9.setText(intusu.Tablausuarios9.getValueAt(fila, 10).toString());
                intusu.txtContrasenia9.setText("********");
                desbloquear();

            } else {
                JOptionPane.showMessageDialog(null, "Fila no seleccionada");
            }
        }

        if (e.getSource() == intusu.btnGuardarcambios9) {
            try {
                PreparedStatement pps = cn.prepareStatement("update Usuario set Nombre='" + intusu.txtNombreUsuario9.getText() + "', A_paterno='" 
                        + intusu.txtApellidoPaterno9.getText() + "', A_materno='" 
                        + intusu.txtApellidoMaterno9.getText()+ "', correo_electronico='" 
                        + intusu.txtEmail9.getText()+ "', Sexo='" 
                        + intusu.sexo9.getSelectedItem().toString()+ "', Numero='" 
                        + intusu.txtNumero9.getText()+ "', Calle='" + intusu.txtCalle9.getText()
                        + "', Colonia='"  + intusu.txtColonia9.getText()+ "', Ciudad='" 
                        + intusu.txtCiudad9.getText()
                        + "' where Id_usuario='" + intusu.txtIdUsuario9.getText() + "' ");
                pps.executeUpdate();
                JOptionPane.showMessageDialog(null, "Datos actualizados");
                mostrartabla("");
            } catch (SQLException ex) {
                Logger.getLogger(frmPrincipal.class.getName()).log(Level.SEVERE, null, ex);
            }

        }

        if (e.getSource() == intusu.btnLimpiar9) {
            limpiar();
            bloquear();
        }

        if (e.getSource() == intusu.btnActualizarTabla9) {
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
        if (e.getSource() == intusu.txtConsultarusuario9) {
            atributo = intusu.comboModoConsulta9.getSelectedItem().toString();
            mostrartabla(intusu.txtConsultarusuario9.getText());
        }
    }

}
