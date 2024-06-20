package dao;

import java.sql.*;
import javax.swing.JOptionPane;
import models.Medicamento;
import controllers.Conectar;
import controllers.IDao;
import java.util.List;
import java.util.ArrayList;

public class MedicamentoDao implements IDao {
    private final Connection con;
    private final Medicamento med;

    public MedicamentoDao(Medicamento model) {
        this.con = Conectar.getConectar();
        this.med = model;
    }

    @Override
    public boolean insertDaoObject() {
        String sql = "INSERT INTO medicamento(nomeMedicamento,dataFabrico,dataExpiracao,instrucao) values (?,?,?,?)";
        try (PreparedStatement smt = con.prepareStatement(sql)) {
            smt.setString(1, med.getNomeMedicamento());
            smt.setString(2, med.getDataFabrico());
            smt.setString(3, med.getDataExpiracao());
            smt.setString(4, med.getInstrucao());
            smt.executeUpdate();
            JOptionPane.showMessageDialog(null, "Cadastro feito com sucesso");
            smt.close();
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(null, "Erro ao cadastrar medicamento: " + ex.getMessage());
            throw new RuntimeException(ex.getMessage());
        }
        return true;
    }

    @Override
    public Object listDaoObject() {
        List<Medicamento> listaMedicamentos = new ArrayList<>();
        String sql = "SELECT * FROM medicamento ORDER BY nomeMedicamento";
        try (PreparedStatement smt = con.prepareStatement(sql)) {
            ResultSet resultado = smt.executeQuery();
            while (resultado.next()) {
                int id = (resultado.getInt("medicamentoId"));
                String nome = (resultado.getString("nomeMedicamento"));
                String dataFabrico = (resultado.getString("dataFabrico"));
                String dataExpiracao = (resultado.getString("dataExpiracao"));
                String instrucao = (resultado.getString("instrucao"));
                var model = new Medicamento(nome, dataFabrico, dataExpiracao, instrucao);
                model.setMedicamentoId(id);
                listaMedicamentos.add(model);
            }
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(null, "Erro ao buscar Registro");
            throw new RuntimeException(ex.getMessage());
        }
        return listaMedicamentos;
    }

    @Override
    public boolean updateDaoObject() {
        String sql = "UPDATE medicamento SET nomeMedicamento = ?, dataFabrico = ?,dataExpiracao = ?,instrucao = ?";
        try (PreparedStatement smt = con.prepareStatement(sql)) {
            smt.setString(1, med.getNomeMedicamento());
            smt.setString(2, med.getDataFabrico());
            smt.setString(3, med.getDataExpiracao());
            smt.setString(4, med.getInstrucao());
            smt.executeUpdate();
            JOptionPane.showMessageDialog(null, "Actualizacao feita com sucesso");
            smt.close();
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(null, "Erro ao actualizar medicamento");
            throw new RuntimeException(ex.getMessage());
        }
        return true;
    }

    @Override
    public boolean deleteDaoObject() {
        String sql = "DELETE FROM medicamento WHERE id = ?";
        int opcao = JOptionPane.showConfirmDialog(null, "Deseja excluir o medicamento " + med.getNomeMedicamento() + " ? ", "Excluir", JOptionPane.YES_NO_OPTION);
        if (opcao == JOptionPane.YES_OPTION) {
            try (PreparedStatement smt = con.prepareStatement(sql)) {
                smt.setInt(1, med.getMedicamentoId());
                smt.setString(2, med.getNomeMedicamento());
                smt.setString(3, med.getDataFabrico());
                smt.setString(4, med.getDataExpiracao());
                smt.setString(5, med.getInstrucao());
                smt.executeUpdate();
                JOptionPane.showMessageDialog(null, "Medicamento excluido com sucesso");
                smt.close();
            } catch (Exception ex) {
                JOptionPane.showMessageDialog(null, "Erro ao excluir medicamento");
                throw new RuntimeException(ex.getMessage());
            }
        }
        return true;
    }
}
