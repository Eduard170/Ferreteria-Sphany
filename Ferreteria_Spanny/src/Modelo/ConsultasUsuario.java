package Modelo;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
public class ConsultasUsuario extends Conexion{
    public boolean registrarusuario(Usuario us) {
        PreparedStatement ps = null;
        Connection con = getConexion();

        try {
            String sql = "INSERT INTO Usuario(Nombre, A_paterno, A_materno, correo_electronico, Sexo, Numero, Calle, Colonia, Ciudad) VALUES(?,?,?,?,?,?,?,?,?)";
            ps = con.prepareStatement(sql);
            ps.setString(1, us.getNombre());
            ps.setString(2, us.getA_paterno());
            ps.setString(3, us.getA_materno());
            ps.setString(4, us.getEmail());
            ps.setString(5, us.getSexo());
            ps.setInt(6, us.getNumeroexterior());
            ps.setString(7, us.getCalle());
            ps.setString(8, us.getColonia());
            ps.setString(9, us.getCiudad());
            int res = ps.executeUpdate();

            if (res > 0) {

            } else {

            }

            sql = "INSERT INTO Rol_usuario(Id_usuario, Rol, Contrasenia) VALUES((select MAX(Id_usuario)from Usuario),?,?)";
            ps = con.prepareStatement(sql);
            ps.setString(1, us.getRol());
            ps.setString(2, us.getContraseña());
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
    
    public boolean buscarId(Usuario us) {
        Connection cn = getConexion();
        int contenidoId;
        
        try {
            
            
            String sql = "SELECT MAX(id_usuario) AS Id_usuario FROM Usuario";
            Statement st=cn.createStatement();
            ResultSet rs=st.executeQuery(sql);
            
            if (rs.next()) {
            contenidoId=rs.getInt("Id_usuario");
            int contenidototal=contenidoId+1;
            us.setIdUsuario(contenidototal);
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
