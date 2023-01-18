package Modelo;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
public class ConsultasProducto extends Conexion {
    public boolean registrartablaproducto(Producto pd) {
        PreparedStatement ps = null;
        Connection con = getConexion();

        try {
            String sql = "INSERT INTO Producto(Nombre, Marca, Existencia) VALUES(?,?,?)";
            ps = con.prepareStatement(sql);
            ps.setString(1, pd.getNombre());
            ps.setString(2, pd.getMarca());
            ps.setInt(3, pd.getExistencia());
            int res = ps.executeUpdate();

            if (res > 0) {

            } else {

            }

            sql = "INSERT INTO Detalle_de_producto(Id_producto, Contenido, Precio_mayoreo, Precio_menudeo) VALUES((select MAX(Id_producto)from Producto),?,?,?)";
            ps = con.prepareStatement(sql);
            ps.setString(1, pd.getContenido());
            ps.setDouble(2, pd.getPrecio_mayoreo());
            ps.setDouble(3, pd.getPrecio_menudeo());
            res = ps.executeUpdate();

            if (res > 0) {

            } else {

            }          

        } catch (SQLException e) {
            System.out.println(e);
            return false;
        } finally {
            try {
                con.close();
            } catch (SQLException e) {
                System.out.println(e);
            }
        }
        return true;
    }
    
    public boolean buscarId(Producto pd) {
        Connection cn = getConexion();
        int contenidoId;
        
        try {
            
            
            String sql = "SELECT MAX(id_producto) AS Id_producto FROM Producto";
            Statement st=cn.createStatement();
            ResultSet rs=st.executeQuery(sql);
            
            if (rs.next()) {
            contenidoId=rs.getInt("Id_producto");
            int contenidototal=contenidoId+1;
            pd.setId(contenidototal);
            }

        } catch (SQLException e) {
            System.out.println(e);
            return false;
        } finally {
            try {
                cn.close();
            } catch (SQLException e) {
                System.out.println(e);
            }
        }
        return true;
    }
    
    
       
}
