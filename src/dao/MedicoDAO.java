package dao;

import java.awt.HeadlessException;
import models.Medico;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.util.ArrayList;
import javax.swing.JOptionPane;
import controllers.Conectar;
import controllers.IDao;
import java.math.BigDecimal;
import java.util.List;
import java.sql.SQLException;

public class MedicoDAO implements IDao {

    private final Connection con;
    private final Medico model;

    public MedicoDAO(Medico medicoModel) {
        this.con = Conectar.getConectar();
        this.model = medicoModel;
    }

    @Override
    public boolean insertDaoObject() {
        String sql = "INSERT INTO `medico` (`numero_ordem`, `especialidade_id`, `funcionario_id`) VALUES (?,?,?)";

        try (PreparedStatement smt = con.prepareStatement(sql)) {
            smt.setInt(1, model.getNumeroOrdem());
            smt.setInt(2, Integer.valueOf(model.getEspecialidade_id()));
            smt.setInt(3, model.getId_funcionario());
            smt.executeUpdate();
            JOptionPane.showMessageDialog(null, "Cadastrado com  sucesso");
        } catch (HeadlessException | SQLException ex) {
            JOptionPane.showMessageDialog(null, "Erro ao cadastrar medico");
            System.err.print(ex);
            throw new RuntimeException(ex.getMessage());
        }
        return true;
    }

    @Override
    public List<Medico> listDaoObject() {
        List<Medico> listaMedicos = new ArrayList<>();
        String sql = "SELECT * FROM medico_view";
        try {
            PreparedStatement smt = con.prepareStatement(sql);
            var resultado = smt.executeQuery();
            while (resultado.next()) {
                
                BigDecimal salario = BigDecimal.valueOf(resultado.getLong("Ordem_id")) ;
                Medico m = new Medico();
                m.setId_funcionario(resultado.getInt("id"));
                m.setNumeroOrdem(resultado.getInt("Ordem_id"));
                m.setEspecialidade_id(resultado.getString("Especialidade"));
                m.setNome_funcionario(resultado.getString("nome"));
                m.setBi_funcionario(resultado.getString("bi"));
                m.setGenero(resultado.getString("genero"));
                m.setSalario(salario);
                m.setMorada(resultado.getString("morada"));
                m.setData_nascimento(resultado.getDate("data_nascimento").toString());
                m.setData_Contratacao(resultado.getDate("data_contrato").toString());
               // m.setDia_disponivel(resultado.getDate("Dia disponivel").toLocalDate());
               // m.setHora_disponivel(resultado.getTime("Hora disponivel").toString());
                listaMedicos.add(m);
            }
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Erro ao buscar os Medicos");
        }
        return listaMedicos;
    }

    @Override
    public boolean updateDaoObject() {
        String sql = "UPDATE funcionario SET crm = ?,medico_especialidade = ?,horarioTrabalho";
        try (PreparedStatement smt = con.prepareStatement(sql)) {
            smt.setInt(1, model.getNumeroOrdem());
            smt.setString(2, model.getNome_funcionario());
          //  smt.setString(3, model.getHorarioTrabalho());
            smt.executeUpdate();
            JOptionPane.showMessageDialog(null, "Medico actualizado");
            smt.close();
        } catch (HeadlessException | SQLException ex) {
            JOptionPane.showMessageDialog(null, "Erro ao cadastrar");
            throw new RuntimeException(ex.getMessage());
        }
        return true;
    }

    @Override
    public boolean deleteDaoObject() {
        String sql = "DELETE FROM medico WHERE numeroOrdem = ?";
        String nome = model.getNome_funcionario();
        int opcao = JOptionPane.showConfirmDialog(null, "Deseja excluir o Funcionario" + nome, "Exclusao", JOptionPane.YES_NO_OPTION);
        if (opcao == JOptionPane.YES_OPTION) {
            try (PreparedStatement smt = con.prepareStatement(sql)) {
                smt.setInt(1, model.getNumeroOrdem());
                smt.executeUpdate();
                JOptionPane.showMessageDialog(null, "Excluido com sucesso");
                smt.close();
            } catch (HeadlessException | SQLException ex) {
                JOptionPane.showMessageDialog(null, "Erro ao excluir Medico");
                throw new RuntimeException(ex.getMessage());
            }
            return true;
        }
        return false;
    }
}
