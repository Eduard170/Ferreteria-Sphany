package Modelo;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
public class ConsultasProveedor extends Conexion {
     public boolean registrarproveedor(Proveedor pv) {
        PreparedStatement ps = null;
        Connection con = getConexion();

        try {
            String sql = "INSERT INTO Proveedor (Nombre, A_paterno, A_materno, Numero, Calle, Colonia, Ciudad) VALUES(?,?,?,?,?,?,?)";
            ps = con.prepareStatement(sql);
            ps.setString(1, pv.getNombre());
            ps.setString(2, pv.getA_paterno());
            ps.setString(3, pv.getA_materno());
            ps.setInt(4, pv.getNumero());
            ps.setString(5, pv.getCalle());
            ps.setString(6, pv.getColonia());
            ps.setString(7, pv.getCiudad());
            int res = ps.executeUpdate();

            if (res > 0) {

            } else {

            }

            sql = "INSERT INTO num_telefono (Id_proveedor, telefono) VALUES((select MAX(Id_proveedor)from Proveedor),?)";
            ps = con.prepareStatement(sql);
            ps.setInt(1, pv.getTelefono());
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
    
    public boolean buscarId(Proveedor pv) {
        Connection cn = getConexion();
        int contenidoId;
        
        try {
            
            
            String sql = "SELECT MAX(id_proveedor) AS Id_proveedor FROM Proveedor";
            Statement st=cn.createStatement();
            ResultSet rs=st.executeQuery(sql);
            
            if (rs.next()) {
            contenidoId=rs.getInt("Id_proveedor");
            int contenidototal=contenidoId+1;
            pv.setId_proveedor(contenidototal);
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
