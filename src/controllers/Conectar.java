package controllers;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import javax.swing.JOptionPane;

public class Conectar {

    private static final String USER = "root";
    private static final String PASSWORD = "";
    private static Connection con = null;
    private static final String URL = "jdbc:mysql://localhost:3306/clinicagirassol";

    public static Connection getConectar() {
        if (con != null) {
            return con;
        }
        try{
            con = DriverManager.getConnection(URL, USER, PASSWORD);
        }catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Erro ao conectar ao banco  de dados" + ex.getMessage());
            throw new RuntimeException(ex.getMessage());
        }
        return con;
    }
}
