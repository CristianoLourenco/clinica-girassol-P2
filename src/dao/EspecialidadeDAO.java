package dao;

import java.sql.*;
import javax.swing.JOptionPane;
import models.Especialidade;
import controllers.Conectar;
import controllers.IDao;
import java.sql.Connection;
import java.util.List;
import java.util.ArrayList;

public class EspecialidadeDAO implements IDao {

    private final Connection con;
    private final Especialidade especialidade;

    public EspecialidadeDAO(Especialidade especialidadeModel) {
        this.con = Conectar.getConectar();
        this.especialidade = especialidadeModel;
    }

    @Override
    public boolean insertDaoObject() {
        String sql = "INSERT INTO especialidade (nome,descricao) VALUES (?,?)";
        try (PreparedStatement smt = con.prepareStatement(sql);) {
            smt.setString(1, especialidade.getNomeEspecialidade());
            smt.setString(2, especialidade.getDescricao());
            smt.executeUpdate();
            JOptionPane.showMessageDialog(null, "Especialidade cadastrada com sucesso");
            smt.close();
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(null, "Erro ao cadastrar especialidade: " + ex.getMessage());
            throw new RuntimeException(ex.getMessage());
        }
        return true;
    }

    @Override
    public List<Especialidade> listDaoObject() {
        List<Especialidade> lista = new ArrayList<>();
        String sql = "SELECT * FROM especialidade ORDER BY nomeEspecialidade";
        try (PreparedStatement smt = con.prepareStatement(sql);) {
            ResultSet resultado = smt.executeQuery();
            while (resultado.next()) {

                int id = (resultado.getInt("especialidade_id"));
                String nome = (resultado.getString("nomeEspecialidade"));
                String descricao = (resultado.getString("descricao"));

                Especialidade esp = new Especialidade(nome, descricao);
                esp.setEspecialidade_id(id);
                lista.add(esp);
            }
        } catch (Exception ex) {
            throw new RuntimeException("Erro ao buscar Registro" + ex.getMessage());
        }
        return lista;
    }

    @Override
    public boolean updateDaoObject() {
        String sql = "UPDATE especialidade SET  nomeEspecialidade = ? , descricao = ? WHERE id = ?";
        try (PreparedStatement smt = con.prepareStatement(sql);) {
            smt.setString(1, especialidade.getNomeEspecialidade());
            smt.setString(2, especialidade.getDescricao());
            smt.executeUpdate();
            JOptionPane.showMessageDialog(null, "Actualizado com sucesso");
            smt.close();
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(null, "Erro ao actualizar especialidade: " + ex.getMessage());
            throw new RuntimeException("Erro ao actualizar especialidade" + ex.getMessage());
        }
        return true;
    }

    @Override
    public boolean deleteDaoObject() {
        String sql = "DELETE FROM especialidade WHERE id = ?";
        int opcao = JOptionPane.showConfirmDialog(null, "Deseja excluir a especialidade " + especialidade.getNomeEspecialidade() + " ? ", "Excluir", JOptionPane.YES_NO_OPTION);
        if (opcao == JOptionPane.YES_OPTION) {
            try (PreparedStatement smt = con.prepareStatement(sql);) {
                smt.setInt(1, especialidade.getEspecialidade_id());
                smt.executeUpdate();
                smt.close();
            } catch (Exception ex) {
                JOptionPane.showMessageDialog(null, "Erro ao deletar especialidade: " + ex.getMessage());
                throw new RuntimeException("Erro ao Deletar" + ex.getMessage());
            }
        }
        return true;
    }
}
