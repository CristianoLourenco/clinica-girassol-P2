package dao;

import java.sql.*;
import javax.swing.JOptionPane;
import models.Consulta;
import controllers.Conectar;
import java.sql.Connection;
import controllers.IDao;
import java.time.LocalDate;
import java.util.ArrayList;


    public class ConsultaDAO implements IDao {

    private final Connection con;
    private final Consulta consulta;

    public ConsultaDAO(Consulta consultaModel) {
        con = Conectar.getConectar();
        this.consulta = consultaModel;
    }

    @Override
    public boolean insertDaoObject() {
        String sql = "INSERT INTO consulta (paciente_id,especialidade_id,medico_id,data_consulta,status)";
        try {
            PreparedStatement smt = con.prepareStatement(sql);
            smt.setString(1, consulta.getPaciente_id());
            smt.setString(2, consulta.getEspecialidade());
            smt.setString(3, consulta.getMedico_id());
            smt.setString(4, consulta.getDataConsulta().toString());
            smt.setBoolean(5, consulta.getStatus());
            smt.executeUpdate();
            JOptionPane.showMessageDialog(null, "Consulta agendada com sucesso");
            smt.close();
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(null, "Falha na Operação: " + ex.getMessage());
            throw new RuntimeException(ex.getMessage());
        }
        return true;
    }

    @Override
    public boolean updateDaoObject() {
        String sql = "UPDATE consulta SET (id = ? , paciente_id = ? ,medico_id = ? ,dataConsulta = ? ,status = ? ,especialidade = ?";
        try{
            PreparedStatement smt = con.prepareStatement(sql);
            smt.setString(1, consulta.getPaciente_id());
            smt.setString(2,consulta.getEspecialidade());
            smt.setString(3, consulta.getMedico_id());
            smt.setString(4, consulta.getDataConsulta().toString());
            smt.setBoolean(5, consulta.getStatus());
            smt.executeUpdate();
            JOptionPane.showMessageDialog(null, "Consulta actualizada com sucesso!");
            smt.close();
            con.close(); 
            
        }catch(Exception ex){
            JOptionPane.showMessageDialog(null, "Erro au actualizar a consulta!" + ex.getMessage());
            throw new RuntimeException("Erro ao actualizar a consulta" + ex.getMessage());
        }
        return true;
    }

    @Override
    public boolean deleteDaoObject() {
        String sql = "DELETE FROM consulta WHERE id = ?";
        int opcao = JOptionPane.showConfirmDialog(null, "Deseja excluir a consulta " + consulta.getId() + " ? " , "Excluir",JOptionPane.YES_NO_OPTION);
        if (opcao == JOptionPane.YES_OPTION) {
            try{
                PreparedStatement smt = con.prepareStatement(sql);
                smt.setInt(1, consulta.getId());
                smt.executeUpdate();
                smt.close();
                con.close();
            }catch(Exception ex){
                JOptionPane.showMessageDialog(null, "Erro ao deletar a consulta" + ex.getMessage());
                throw new RuntimeException("Erro ao Deletar"+ ex.getMessage());
            }
        }
        return true;
    }

    @Override
    public List<Consulta> listDaoObject() {
        List<Consulta> lista = new ArrayList<>();
        String sql = "SELECT * FROM consulta ORDER BY paciente_id";
        try {
            PreparedStatement smt = con.prepareStatement(sql);
            ResultSet resultado = smt.executeQuery();
            while (resultado.next()){
                
                int id = (resultado.getInt("id"));
                String paciente = (resultado.getString("paciente_id"));
                String medico = (resultado.getString("medico_id"));
                
                Consulta cons = new Consulta(paciente, medico, LocalDate.MIN, true, paciente);
                cons.setId(id);
                lista.add(cons);
            }
        } catch (Exception ex) {
            throw new RuntimeException("Erro ao listar consultas" + ex.getMessage());
        }
        return lista;
    }
}
