package Codigo;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class conexion extends registro {

    public Connection conectar() {
        Connection conn = null;
        String url;
        Statement s;
        try {
            Class.forName("org.apache.derby.jdbc.ClientDriver");

            url = "jdbc:derby:Edson;create=true;user=edson;password=edson";
            conn = DriverManager.getConnection(url);
            if (conn != null) {
                System.out.println("Se ha conectado correctamente :) ");
                s = conn.createStatement();
                return conn;
            }
        } catch (SQLException | ClassNotFoundException ex) {
            System.out.println(ex);
        }
        return null;
    }
}
