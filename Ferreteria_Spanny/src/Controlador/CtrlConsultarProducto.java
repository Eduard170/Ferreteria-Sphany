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
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import javax.swing.table.DefaultTableModel;
public class CtrlConsultarProducto implements ActionListener, KeyListener {

    private Producto pto;
    private ConsultasProducto conpto;
    private frmAAdministrarproductos intpto;
    private frmPrincipal principal;

    public CtrlConsultarProducto(Producto pto, ConsultasProducto conpto, frmAAdministrarproductos intpto) {
        this.pto = pto;
        this.conpto = conpto;
        this.intpto = intpto;
        this.intpto.btnConsultar.addActionListener(this);
        this.intpto.btnMostrarproductos.addActionListener(this);
        this.intpto.txtConsultarproducto.addKeyListener(this);
        
    }
    
         public void iniciar() {
        mostrarTablaConsultarproductos("");
    }

    Conexion con = new Conexion();
    Connection cn = con.getConexion();
    String atributo = "Id_producto";

    void mostrarTablaConsultarproductos(String valor) {
        DefaultTableModel modelo = new DefaultTableModel();
        modelo.addColumn("ID");
        modelo.addColumn("Nombre");
        modelo.addColumn("Marca");
        modelo.addColumn("Existencia");
        modelo.addColumn("Contenido");
        modelo.addColumn("Precio mayoreo");
        modelo.addColumn("Precio menudeo");

        intpto.TablaregistrarproductosConsultar.setModel(modelo);

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
            intpto.TablaregistrarproductosConsultar.setModel(modelo);
        } catch (SQLException ex) {
            System.out.println("Error");
        }
    }

    @Override
    public void actionPerformed(ActionEvent e) {

        if (e.getSource() == intpto.btnConsultar) {
            atributo = intpto.comboModoConsulta.getSelectedItem().toString();
            mostrarTablaConsultarproductos(intpto.txtConsultarproducto.getText());
        }

        if (e.getSource() == intpto.btnMostrarproductos) {
            mostrarTablaConsultarproductos("");
        }
        
        
    }
    
    @Override
    public void keyReleased(KeyEvent a){
        if (a.getSource() == intpto.txtConsultarproducto) {
            atributo = intpto.comboModoConsulta.getSelectedItem().toString();
            mostrarTablaConsultarproductos(intpto.txtConsultarproducto.getText());
        }
    }

    @Override
    public void keyTyped(KeyEvent e) {
        
    }

    @Override
    public void keyPressed(KeyEvent e) {
        
    }
    
    
    
}
