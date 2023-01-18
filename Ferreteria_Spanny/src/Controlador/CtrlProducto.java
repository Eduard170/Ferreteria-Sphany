package Controlador;

import Modelo.Conexion;
import Modelo.ConsultasProducto;
import Modelo.Producto;
import Vista.frmAAdministrarproductos;
import Vista.frmPrincipal;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
public class CtrlProducto implements ActionListener {

    private Producto pto;
    private ConsultasProducto conpto;
    private frmAAdministrarproductos intpto;
    private frmPrincipal principal;

    public CtrlProducto(Producto pto, ConsultasProducto conpto, frmAAdministrarproductos intpto) {
        this.pto = pto;
        this.conpto = conpto;
        this.intpto = intpto;
        this.intpto.btnRegistrar.addActionListener(this);
        this.intpto.btnAgregarproducto.addActionListener(this);
    }

    Conexion con = new Conexion();
    Connection cn = con.getConexion();
    String atributo = "Id_producto";
    
    
    public void iniciar(){
        mostrartabla("");   
    }
    
     void mostrartabla(String valor) {
        DefaultTableModel modelo = new DefaultTableModel();
        modelo.addColumn("ID");
        modelo.addColumn("Nombre");
        modelo.addColumn("Marca");
        modelo.addColumn("Existencia");
        modelo.addColumn("Contenido");
        modelo.addColumn("Precio mayoreo");
        modelo.addColumn("Precio menudeo");
        
        intpto.Tablaregistrarproductos.setModel(modelo);

        String sql = "";
        if (valor.equals("")) {
            sql = "select c.Id_producto, c.Nombre, c.Marca, c.Existencia, d.Contenido, d.Precio_mayoreo, d.Precio_menudeo from Producto c, Detalle_de_producto d where d.id_producto=c.id_producto";
        } else {
            sql = "select * from producto where " + atributo + "='" + valor + "'";
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
            intpto.Tablaregistrarproductos.setModel(modelo);
        } catch (SQLException ex) {
            System.out.println("Error");
        }
    }
     
      void desbloquear(){
        intpto.txtNombreProducto.setEnabled(true);
        intpto.txtContenidoProducto.setEnabled(true);
        intpto.txtExistenciaProducto.setEnabled(true);
        intpto.txtMarcaProducto.setEnabled(true);
        intpto.txtPrecioMayoreoProducto.setEnabled(true);
        intpto.txtPreciomenudeoProducto.setEnabled(true);
    }
    
    public void actionPerformed(ActionEvent e) {
        
        if (e.getSource() == intpto.btnAgregarproducto) {                          
            if(conpto.buscarId(pto)){
                intpto.txtIdProducto.setText(String.valueOf(pto.getId()));
                desbloquear();
            }
        }

        if (e.getSource() == intpto.btnRegistrar) {
            pto.setNombre(intpto.txtNombreProducto.getText());
            pto.setMarca(intpto.txtMarcaProducto.getText());
            pto.setExistencia(Integer.parseInt(intpto.txtExistenciaProducto.getText()));
            pto.setContenido(intpto.txtContenidoProducto.getText());
            pto.setPrecio_mayoreo(Double.parseDouble(intpto.txtPrecioMayoreoProducto.getText()));
            pto.setPrecio_menudeo(Double.parseDouble(intpto.txtPreciomenudeoProducto.getText()));

            if (conpto.registrartablaproducto(pto)) {
                JOptionPane.showMessageDialog(null, "Registro guardado");
                mostrartabla("");
            } else {
                JOptionPane.showMessageDialog(null, "Error al guardar");

            }
            
        }
        
        if(e.getSource()==intpto.btnActualizar){
            mostrartabla("");
        }
        
        

    }

}
