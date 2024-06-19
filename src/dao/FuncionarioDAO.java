package dao;

import models.Funcionario;
import controllers.Conectar;
import controllers.IDao;
import java.awt.HeadlessException;
import java.math.BigDecimal;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.util.ArrayList;
import javax.swing.JOptionPane;
import java.util.List;
import java.sql.ResultSet;
import java.sql.SQLException;

public class FuncionarioDAO implements IDao {

    private final Connection con;
    private final Funcionario funcionario;

    public FuncionarioDAO(Funcionario funcionarioModel) {
        this.funcionario = funcionarioModel;
        this.con = Conectar.getConectar();
    }

    @Override
    public boolean insertDaoObject() {
        String sql = " INSERT INTO funcionario (nome,bi,data_contratacao,cargo,salario) VALUES (?, ?, ?, ?, ?, ?)";
        try (PreparedStatement smt = con.prepareStatement(sql)) {
            smt.setString(1, funcionario.getNome_funcionario());
            smt.setString(2, funcionario.getBi_funcionario());
            smt.setString(3, funcionario.getData_Contratacao());
            smt.setString(4, funcionario.getCargo());
            smt.setString(5, funcionario.getSalario().toString());
            smt.executeUpdate();
            smt.close();
            JOptionPane.showMessageDialog(null, "Funcionario Cadastrado com sucesso!");
        } catch (HeadlessException | SQLException ex) {
            JOptionPane.showMessageDialog(null, "Erro ao cadastrar Funcionario: " + ex.getMessage());
            throw new RuntimeException(ex.getMessage());
        }
        return true;
    }

    @Override
    public Object listDaoObject() {
        List<Funcionario> listaFuncionarios = new ArrayList<>();
        String sql = "SELECT * FROM funcionario ORDER BY nome";
        try (PreparedStatement smt = con.prepareStatement(sql)) {
            ResultSet resultado = smt.executeQuery();
            while (resultado.next()) {
                int id = resultado.getInt("id");
                String nome = resultado.getString("nome");
                String bi =resultado.getString("bi");
                String dataContrato = resultado.getString("data_contratacao");
                String cargo = resultado.getString("cargo");
                BigDecimal salario = resultado.getBigDecimal("salario");
                char genero = resultado.getString("genero").charAt(0);
                Funcionario funcionarioModel = new Funcionario(nome, bi, dataContrato, cargo, salario, genero);
                funcionarioModel.setId_funcionario(id);
                listaFuncionarios.add(funcionarioModel);
            }
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(null, "Erro ao buscar Registro: " + ex.getMessage());
            throw new RuntimeException(ex.getMessage());
        }
        return listaFuncionarios;
    }

    @Override
    public boolean updateDaoObject() {
        String sql = "UPDATE funcionario SET nome = ?, bi = ?,data_contratacao = ?,cargo = ?,salario = ? WHERE id = ? ";
        try (PreparedStatement smt = con.prepareStatement(sql)) {
            smt.setString(1, funcionario.getNome_funcionario());
            smt.setString(2, funcionario.getBi_funcionario());
            smt.setString(3, funcionario.getData_Contratacao());
            smt.setString(4, funcionario.getCargo());
            smt.setString(5, funcionario.getSalario().toString());
            smt.setInt(6, funcionario.getId_funcionario());
            smt.executeUpdate();
            smt.close();
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(null, "Erro ao Cadastrar: " + ex.getMessage());
            throw new RuntimeException(ex.getMessage());
        }
        return true;
    }

    @Override
    public boolean deleteDaoObject() {
        String sql = "DELETE FROM funcionario WHERE id = ?";
        String nome = funcionario.getNome_funcionario();
        int id = funcionario.getId_funcionario();
        int opcao = JOptionPane.showConfirmDialog(null, "Deseja excluir o Funcionario " + nome, "Exclusao", JOptionPane.YES_NO_OPTION);
        if (opcao == JOptionPane.YES_OPTION) {
            try (PreparedStatement smt = con.prepareStatement(sql)) {
                smt.setInt(1, id);
                smt.executeUpdate();
                smt.close();
                JOptionPane.showMessageDialog(null, "Excluido Com Sucesso");
            } catch (Exception ex) {
                JOptionPane.showMessageDialog(null, "Erro ao excluir o Funcionario: " + ex.getMessage());
                throw new RuntimeException(ex.getMessage());
            }
        }
        return true;
    }

}
