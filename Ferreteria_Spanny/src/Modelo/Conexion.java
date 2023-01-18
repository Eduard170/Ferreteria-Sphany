package Modelo;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Conexion {

    private final String base = "ferreteria"; // nombre de la base de datos
    private final String user = "root";
    private final String password = "";// contraseña para ingresar ala base de datos en consola
    private final String url = "jdbc:mysql://localhost:3308/" + base;
    private Connection con = null;

    public Connection getConexion() {
        try {
            Class.forName("com.mysql.jdbc.Driver");
            con = (Connection) DriverManager.getConnection(this.url, this.user, this.password);

        } catch (SQLException e) {
            System.err.println(e);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(Conexion.class.getName()).log(Level.SEVERE, null, ex);
        }
        return con;
    }
    static public Connection cnx = null;
    static public Statement st = null;
    static public ResultSet rs = null;
    static public PreparedStatement pst = null;

}
