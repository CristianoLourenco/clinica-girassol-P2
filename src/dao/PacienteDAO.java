package dao;

import java.sql.*;
import javax.swing.JOptionPane;
import models.Paciente;
import controllers.Conectar;
import controllers.IDao;
import java.sql.Connection;
import java.util.List;
import java.util.ArrayList;

public class PacienteDAO implements IDao {

    private final Connection con;
    private final Paciente model;

    public PacienteDAO(Paciente pacienteModel) {
        this.con = Conectar.getConectar();
        this.model = pacienteModel;
    }

    @Override
    public boolean insertDaoObject() {
        String sql = "INSERT INTO paciente (nome, bi, data_nascimento, endereco, telefone, genero) VALUES(?, ?, ?, ?, ?, ?) ";
        Date data = Date.valueOf(this.model.getDataNascimento());
        try (PreparedStatement smt = con.prepareStatement(sql)) {
            smt.setString(1, this.model.getNome());
            smt.setString(2, this.model.getBi());
            smt.setDate(3, data);
            smt.setString(4, this.model.getMorada());
            smt.setString(5, this.model.getTelefone());
            smt.setString(6, this.model.getGenero());
            smt.execute();
            smt.close();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, ex.getMessage());
            throw new RuntimeException(ex.getMessage());
        }
        return true;
    }

    @Override
    public Object listDaoObject() {
        List<Paciente> lista = new ArrayList<>();
        String sql = "SELECT * FROM paciente ORDER BY nome";
        try (PreparedStatement smt = con.prepareStatement(sql)) {
            ResultSet resultado = smt.executeQuery();
            while (resultado.next()) {

                int id = (resultado.getInt("id"));
                String nome = (resultado.getString("nome"));
                String bilhete = (resultado.getString("bi"));
                String nascimento = (resultado.getString("nascimento"));
                String morada = (resultado.getString("morada"));
                String phone = (resultado.getString("telefone"));
                String genero = (resultado.getString("genero"));

                Paciente p = new Paciente(nome, bilhete, morada, phone, genero, nascimento);
                p.setPaciente_id(id);
                lista.add(p);
            }
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(null, "Erro ao buscar Registro");
            throw new RuntimeException(ex.getMessage());
        }
        return lista;
    }

    @Override
    public boolean updateDaoObject() {
        String sql = "UPDATE paciente SET nome = ? , bi = ? , data_nascimento = ? , endereco  = ? , telefone = ? , genero = ?  WHERE id = ?";
        try (PreparedStatement smt = con.prepareStatement(sql)) {
            smt.setString(1, this.model.getNome());
            smt.setString(2, this.model.getBi());
            smt.setString(3, this.model.getDataNascimento());
            smt.setString(4, this.model.getMorada());
            smt.setString(5, this.model.getTelefone());
            smt.setString(6, this.model.getGenero());
            smt.setInt(7, this.model.getPaciente_id());
            smt.executeUpdate();
            smt.close();
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(null, "Erro ao actualizar o registro!");
            throw new RuntimeException(ex.getMessage());
        }
        return true;
    }

    @Override
    public boolean deleteDaoObject() {
        String sql = "DELETE FROM paciente WHERE  id = ? ";
        String nome = model.getNome();
        int opcao = JOptionPane.showConfirmDialog(null, "Deseja excluir o Paciente " + nome + " ? ", "Excluir", JOptionPane.YES_NO_OPTION);
        if (opcao == JOptionPane.YES_OPTION) {
            try (PreparedStatement smt = con.prepareStatement(sql)) {
                smt.setInt(1, model.getPaciente_id());
                smt.executeUpdate();
                smt.close();
                con.close();
            } catch (Exception ex) {
                JOptionPane.showMessageDialog(null, "Erro ao  Deletar");
                throw new RuntimeException(ex.getMessage());
            }
        }
        return true;
    }
}
