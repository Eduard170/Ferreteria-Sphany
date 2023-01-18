/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
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

/**
 *
 * @author Judith
 */
public class CtrlModificarContraseña implements ActionListener, KeyListener{
     private Usuario usu;
    private ConsultasUsuario conusu;
    private frmAdministrarusuarios intusu;
    private frmPrincipal principal;
    
    public CtrlModificarContraseña(Usuario usu, ConsultasUsuario conusu, frmAdministrarusuarios intusu) {
        this.usu = usu;
        this.conusu = conusu;
        this.intusu = intusu;
        this.intusu.btnConsultar8.addActionListener(this);
        this.intusu.btnMostrarusuarios8.addActionListener(this);
        this.intusu.btnModificarcontraseña8.addActionListener(this);
        this.intusu.btnGuardarcambios18.addActionListener(this);
        this.intusu.btnActualizarTabla18.addActionListener(this);
        this.intusu.btnLimpiar18.addActionListener(this);
        this.intusu.txtConsultarusuario8.addKeyListener(this);
    }
    
     public void iniciar(){
        mostrartabla("");   
        bloquear();
    }
    
    Conexion con = new Conexion();
    Connection cn = con.getConexion();
    String atributo = "Id_usuario";

    void bloquear() {
        intusu.txtIdUsuario8.setEnabled(false);
        intusu.txtNombreUsuario8.setEnabled(false);
        intusu.txtApellidoMaterno8.setEnabled(false);
        intusu.txtApellidoPaterno8.setEnabled(false);
        intusu.txtRol8.setEnabled(false);
        intusu.txtContraseñaActual8.setEnabled(false);
        intusu.txtContraseñanueva8.setEnabled(false);
    }

    void limpiar() {
        intusu.txtIdUsuario8.setText(null);
        intusu.txtNombreUsuario8.setText(null);
        intusu.txtApellidoMaterno8.setText(null);
        intusu.txtApellidoPaterno8.setText(null);
        intusu.txtRol8.setText(null);
        intusu.txtContraseñaActual8.setText(null);
        intusu.txtContraseñanueva8.setText(null);
    }

    void desbloquear() {
        intusu.txtIdUsuario8.setEnabled(false);
        intusu.txtNombreUsuario8.setEnabled(false);
        intusu.txtApellidoMaterno8.setEnabled(false);
        intusu.txtApellidoPaterno8.setEnabled(false);
        intusu.txtRol8.setEnabled(false);
        intusu.txtContraseñaActual8.setEnabled(true);
        intusu.txtContraseñanueva8.setEnabled(true);
        

    }
    
     void mostrartabla(String valor) {
        DefaultTableModel modelo = new DefaultTableModel();
        modelo.addColumn("ID");
        modelo.addColumn("Nombre");
        modelo.addColumn("A. paterno");
        modelo.addColumn("A. materno");
        modelo.addColumn("Rol");

        intusu.Tablausuarios8.setModel(modelo);

        String sql = "";
        if (valor.equals("")) {
            sql = "select c.Id_usuario, c.Nombre, c.A_paterno, c.A_materno, d.Rol from Usuario c, Rol_usuario d where d.id_usuario=c.id_usuario";
        } else {
            sql = "select c.Id_usuario, c.Nombre, c.A_paterno, c.A_materno, d.Rol from Usuario c, Rol_usuario d where d.id_usuario=c.id_usuario  and c." +atributo + " like '" + valor + "%'";
        }
        String datos[] = new String[5];
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
                modelo.addRow(datos);
            }
            intusu.Tablausuarios8.setModel(modelo);
        } catch (SQLException ex) {
            System.out.println("Error");
        }
    }
    
    public void actionPerformed(ActionEvent e) {

        if (e.getSource() == intusu.btnConsultar8) {
            atributo = intusu.comboModoConsulta8.getSelectedItem().toString();
            mostrartabla(intusu.txtConsultarusuario8.getText());
        }

        if (e.getSource() == intusu.btnMostrarusuarios8) {
            mostrartabla("");
        }

        if (e.getSource() == intusu.btnModificarcontraseña8) {
            int fila = intusu.Tablausuarios8.getSelectedRow();
            if (fila >= 0) {
                intusu.txtIdUsuario8.setText(intusu.Tablausuarios8.getValueAt(fila, 0).toString());
                intusu.txtNombreUsuario8.setText(intusu.Tablausuarios8.getValueAt(fila, 1).toString());
                intusu.txtApellidoPaterno8.setText(intusu.Tablausuarios8.getValueAt(fila, 2).toString());
                intusu.txtApellidoMaterno8.setText(intusu.Tablausuarios8.getValueAt(fila, 3).toString());
                intusu.txtRol8.setText(intusu.Tablausuarios8.getValueAt(fila, 4).toString());
                desbloquear();

            } else {
                JOptionPane.showMessageDialog(null, "Fila no seleccionada");
            }
        }

        if (e.getSource() == intusu.btnGuardarcambios18) {
            try {
                PreparedStatement pps = cn.prepareStatement("update Rol_usuario set Contrasenia='" +intusu.txtContraseñanueva8.getText() + "' where Id_usuario='" + intusu.txtIdUsuario8.getText() + "' ");
                pps.executeUpdate();
                JOptionPane.showMessageDialog(null, "Contraseña modificada");
                mostrartabla("");
            } catch (SQLException ex) {
                Logger.getLogger(frmPrincipal.class.getName()).log(Level.SEVERE, null, ex);
            }

        }

        if (e.getSource() == intusu.btnLimpiar18) {
            limpiar();
            bloquear();
        }

        if (e.getSource() == intusu.btnActualizarTabla18) {
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
        if (e.getSource() == intusu.txtConsultarusuario8) {
            atributo = intusu.comboModoConsulta8.getSelectedItem().toString();
            mostrartabla(intusu.txtConsultarusuario8.getText());
        }
    }
}
