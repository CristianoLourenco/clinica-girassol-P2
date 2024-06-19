package dao;

import java.sql.*;
import javax.swing.JOptionPane;
import models.Consulta;
import controllers.Conectar;
import controllers.IDaoC;
import java.sql.Connection;

public class ConsultaDAO implements IDaoC{
   private final Connection con;
   private final Consulta consulta;

    public ConsultaDAO(Consulta consultaModel) {
        con = Conectar.getConectar();
        this.consulta = consultaModel;
    }
   

    @Override
    public boolean insertDaoObject() {
       String sql = "INSERT INTO consulta (paciente_id,especialidade_id,medico_id,data_consulta,status)";
       try(PreparedStatement smt = con.prepareStatement(sql)){
           smt.setString(1, consulta.getPaciente_id());
           smt.setString(2, consulta.getEspecialidade());
           smt.setString(3,consulta.getMedico_id());
           smt.setString(4, consulta.getDataConsulta().toString());
           smt.setBoolean(5,consulta.getStatus());
           smt.executeUpdate();
           JOptionPane.showMessageDialog(null,"Consulta agendada com sucesso");
           smt.close();
       }catch(Exception ex){
           JOptionPane.showMessageDialog(null,"Falha na Operação: "+ex.getMessage());
           throw new RuntimeException(ex.getMessage());

       }
       return true;
    }

    @Override
    public boolean listDaoObject() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public boolean updateDaoObject() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public boolean deleteDaoObject() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
}
