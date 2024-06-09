package utilitarios;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import javax.swing.JOptionPane;

public class Conectar {
    private static final String user = "root";
    private static final String password = "";
    private static final String url = "jdbc:mysql://localhost:3306/clinicagirassol";
    
    
    public static  Connection getConectar (){
        Connection con = null;
        if (con != null) {
            return  con;
        }
        try{
               // Class.forName("com.mysql.jdbc.Driver");
                con = DriverManager.getConnection(url, user, password);
        }catch(SQLException ex){
                JOptionPane.showMessageDialog(null,"Erro ao conectar ao banco  de dados"+ex.getMessage());
        }
        return con;
    } 
}
