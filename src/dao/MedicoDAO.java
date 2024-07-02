package dao;

import java.awt.HeadlessException;
import models.Medico;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.util.ArrayList;
import javax.swing.JOptionPane;
import controllers.Conectar;
import controllers.IDao;
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
        String sql = "INSERT INTO medico  (funcionario_id,medico_especialidade,horario_trabalho) VALUES (?,?,?)";
        try {
            PreparedStatement smt = con.prepareStatement(sql);
            smt.setInt(1, model.getId_funcionario());
            smt.setString(2, model.getMedico_especialidade());
            smt.setString(3, model.getHorarioTrabalho());
            smt.executeUpdate();
            JOptionPane.showMessageDialog(null, "Cadastrado com  sucesso");
            smt.close();
        } catch (HeadlessException | SQLException ex) {
            JOptionPane.showMessageDialog(null, "Erro ao cadastrar medico");
            throw new RuntimeException(ex.getMessage());
        }
        return true;
    }

    @Override
    public Object listDaoObject() {
        List<Medico> listaMedicos = new ArrayList<>();
        /*  String sql = "SELECT * FROM medico ORDER BY  numeroOrdem";
        try{
            PreparedStatement smt = con.prepareStatement(sql);
            ResultSet resultado = smt.executeQuery();
            while (resultado.next()){
                Medico m = new Medico();
                m.setNumeroOrdem(resultado.getInt("numeroOrdem"));
                m.setMedico_especialidade(resultado.getString("medico_especialidade"));
                m.setHorarioTrabalho(resultado.getString("horario_trabalho"));
                listaMedicos.add(m);
            }
        }catch(SQLException ex){
            JOptionPane.showMessageDialog(null, "Erro ao buscar os Medicos");
        }
         */
        return listaMedicos;
    }

    @Override
    public boolean updateDaoObject() {
        String sql = "UPDATE funcionario SET crm = ?,medico_especialidade = ?,horarioTrabalho";
        try {
            PreparedStatement smt = con.prepareStatement(sql);
            smt.setInt(1, model.getNumeroOrdem());
            smt.setString(2, model.getNome_funcionario());
            smt.setString(3, model.getHorarioTrabalho());
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
            try {
                PreparedStatement smt = con.prepareStatement(sql);
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
