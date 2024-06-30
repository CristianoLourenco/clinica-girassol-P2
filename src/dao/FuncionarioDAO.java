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
import java.sql.Date;
import models.FuncaoEnum;

public class FuncionarioDAO implements IDao {

    private final Connection con;
    private final Funcionario model;

    public FuncionarioDAO(Funcionario funcionarioModel) {
        this.model = funcionarioModel;
        this.con = Conectar.getConectar();
    }

    @Override
    public boolean insertDaoObject() {
        
        String sql = "INSERT INTO `funcionario` (`id`,`nome`,`bi`,`morada`,`cargo`,`genero`,`funcao`,`telefone`,`salario`,`data_nascimento`,`data_contrato`) VALUES (NULL,?,?,?,?,?,?,?,?,?,?)";
        Date data_nascimento = Date.valueOf(model.getDataNascimento());
        Date data_contratato = Date.valueOf(model.getData_Contratacao()); 

        try (PreparedStatement smt = con.prepareStatement(sql)) {
            smt.setString(1, model.getNome_funcionario());
            smt.setString(2, model.getBi_funcionario());
            smt.setString(3, model.getMorada());
            smt.setString(4, model.getCargo());
            smt.setString(5, model.getGenero());
            smt.setString(6, model.getFuncao().name());
            smt.setString(7, model.getTelefone());
            smt.setObject(8, model.getSalario());
            smt.setDate(9, data_nascimento);
            smt.setDate(10, data_contratato);
            smt.executeUpdate();
            smt.close();
            JOptionPane.showMessageDialog(null, "Funcionario Cadastrado com sucesso!");
        } catch (HeadlessException | SQLException ex) {
            JOptionPane.showMessageDialog(null, "Erro ao cadastrar Funcionario");
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
                String bi = resultado.getString("bi");
                String morada = resultado.getString("morada");
                String cargo = resultado.getString("cargo");
                String genero = resultado.getString("genero");
                BigDecimal salario = resultado.getBigDecimal("salario");
                String telefone = resultado.getString("telefone");
                FuncaoEnum funcao = FuncaoEnum.valueOf(resultado.getString("funcao"));
                String data_contrato = resultado.getString("data_contrato");
                String data_nascimento = resultado.getString("data_nascimento");
                Funcionario funcionarioModel = new Funcionario(
                        nome, 
                        bi,
                        data_contrato, 
                        data_nascimento, 
                        cargo, 
                        salario, 
                        genero, 
                        funcao,
                        telefone, 
                        morada
                );
                funcionarioModel.setId_funcionario(id);
                listaFuncionarios.add(funcionarioModel);
            }
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(null, "Erro ao buscar Registro" );
            throw new RuntimeException(ex.getMessage());
        }
        return listaFuncionarios;
    }

    @Override
    public boolean updateDaoObject() {
        String sql = "UPDATE funcionario SET nome = ?, bi = ?,data_contratacao = ?,cargo = ?,salario = ? WHERE id = ? ";
        try (PreparedStatement smt = con.prepareStatement(sql)) {
            smt.setString(1, model.getNome_funcionario());
            smt.setString(2, model.getBi_funcionario());
            smt.setString(3, model.getData_Contratacao());
            smt.setString(4, model.getCargo());
            smt.setString(5, model.getSalario().toString());
            smt.setInt(6, model.getId_funcionario());
            smt.executeUpdate();
            smt.close();
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(null, "Erro ao Cadastrar " );
            throw new RuntimeException(ex.getMessage());
        }
        return true;
    }

    @Override
    public boolean deleteDaoObject() {
        String sql = "DELETE FROM funcionario WHERE id = ?";
        String nome = model.getNome_funcionario();
        int id = model.getId_funcionario();
        int opcao = JOptionPane.showConfirmDialog(null, "Deseja excluir o Funcionario " + nome, "Exclusao", JOptionPane.YES_NO_OPTION);
        if (opcao == JOptionPane.YES_OPTION) {
            try (PreparedStatement smt = con.prepareStatement(sql)) {
                smt.setInt(1, id);
                smt.executeUpdate();
                smt.close();
                JOptionPane.showMessageDialog(null, "Excluido Com Sucesso");
            } catch (Exception ex) {
                JOptionPane.showMessageDialog(null, "Erro ao excluir o Funcionario" );
                throw new RuntimeException(ex.getMessage());
            }
        }
        return true;
    }

}
