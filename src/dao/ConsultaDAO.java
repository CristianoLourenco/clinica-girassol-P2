package dao;

import java.sql.*;
import javax.swing.JOptionPane;
import models.Consulta;
import controllers.Conectar;
import java.sql.Connection;
import java.time.LocalDate;
import java.util.List;
import java.util.ArrayList;

public class ConsultaDAO {
   
   private static final Connection con = Conectar.getConectar();
   
   public static boolean cadastrarConsulta(Consulta c){
       String sql = "INSERT INTO consulta (paciente_id,especialidade_id,medico_id,data_consulta,status)";
       
       try{
           PreparedStatement smt = con.prepareStatement(sql);
           smt.setString(1, c.getPaciente_id());
           smt.setString(2, c.getEspecialidade());
           smt.setString(3,c.getMedico_id());
           smt.setString(4, c.getDataConsulta().toString());
           smt.setBoolean(5,c.getStatus());
           smt.executeUpdate();
           JOptionPane.showMessageDialog(null,"Consulta agendada com sucesso");
           smt.close();
           con.close();
       }catch(Exception ex){
           JOptionPane.showMessageDialog(null,"Erro ao agendar consultar");
       }
       return true;
   }
   
   public static boolean actualizarConsulta(Consulta c){
       String sql = "UPDATE consulta SET (medico_id,data_consulta,status)";
       return  false;
               //Por terminar...
   }
}
