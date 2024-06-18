package controllers;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Conectar {
    private static final String user = "root";
    private static final String password = "";
    private static Connection con = null;
    private static final String url = "jdbc:mysql://localhost:3306/clinicagirassol";
    
    
    public static  Connection getConectar (){
        
        if (con != null) {
            return  con;
        }
        try{
            con = DriverManager.getConnection(url, user, password);
        }catch(SQLException ex){
                //JOptionPane.showMessageDialog(null,"Erro ao conectar ao banco  de dados"+ex.getMessage());
                throw new RuntimeException(ex.getMessage());
        }
        return con;
    } 
}
