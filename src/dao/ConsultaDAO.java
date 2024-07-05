package dao;

import java.sql.*;
import javax.swing.JOptionPane;
import models.Consulta;
import controllers.Conectar;
import java.sql.Connection;
import controllers.IDao;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

public class ConsultaDAO implements IDao {

    private final Connection con;
    private final Consulta consulta;

    public ConsultaDAO(Consulta consultaModel) {
        con = Conectar.getConectar();
        this.consulta = consultaModel;
    }

    @Override
    public boolean insertDaoObject() {
        String sql = "INSERT INTO `consulta` ( `id_paciente`, `dataConsulta`, `id_especialidade`, `status`) VALUES (?,?,?,?)";
        try (PreparedStatement smt = con.prepareStatement(sql)) {
            smt.setString(1, consulta.getPaciente_id());
            smt.setObject(2,consulta.getDataConsulta());
            smt.setObject(3, consulta.getEspecialidade_id());
            smt.setObject(4, consulta.getStatus().toString());
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
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public boolean deleteDaoObject() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public Object listDaoObject() {
     List<Consulta> lista = new ArrayList<>();
        String sql = "SELECT * FROM `consulta_view`";
        try (PreparedStatement smt = con.prepareStatement(sql)) {
            ResultSet resultado = smt.executeQuery();
            while (resultado.next()) {

                int id = (resultado.getInt("id"));
                LocalDateTime dataConsulta = LocalDateTime.of(resultado.getDate("Data marcada").toLocalDate(),resultado.getTime("Data marcada").toLocalTime());
                String id_paciente = ( (resultado.getString("Paciente")));
                String id_medico = ((resultado.getString("Medico")));
                Consulta.Status status = Consulta.Status.valueOf(resultado.getString("status"));
                String especialidade_id = (resultado.getString("Especialidade"));
                //String hora = (resultado.getTime("Hora")).toString(); 

                Consulta c = new  Consulta(id_paciente, id_medico, dataConsulta, status, especialidade_id);
                c.setId(id);
                lista.add(c);
            }
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(null, "Erro ao buscar Registro");
            throw new RuntimeException(ex.getMessage());
        }
        return lista;
    }
}
