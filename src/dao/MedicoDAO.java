package dao;

import mapeamento.Medico;
import utilitarios.Conectar;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.util.ArrayList;
import javax.swing.JOptionPane;
import java.util.List;
import java.sql.ResultSet;
import java.time.LocalDate;

public class MedicoDAO {
    public void cadastrarMedico (Medico m){
        Connection con = Conectar.getConectar();
        String sql = "INSERT INTO medico  (funcionario_id,medico_especialidade,horario_trabalho) VALUES (?,?,?)";
        try{
            PreparedStatement smt = con.prepareStatement(sql);
            smt.setInt(1, m.getId_funcionario());
            smt.setString(2,m.getMedico_especialidade());
            smt.setString(3,m.getHorarioTrabalho()); 
            smt.executeUpdate();
            JOptionPane.showMessageDialog(null, "Cadastrado com  sucesso");
            smt.close();
            con.close();
        }catch(Exception ex){
            JOptionPane.showMessageDialog(null, "Erro ao cadastrar medico");
        }
    }
    
    public void actulizarMedico (Medico m){
    Connection con = Conectar.getConectar();
    
    String sql = "UPDATE funcionario SET crm = ?,medico_especialidade = ?,horarioTrabalho";
    try{
        PreparedStatement smt = con.prepareStatement(sql);
        smt.setInt(1, m.getNumeroOrdem());
        smt.setString(2, m.getNome_funcionario());
        smt.setString(3, m.getHorarioTrabalho().toString());
        smt.executeUpdate();
        JOptionPane.showMessageDialog(null,"Medico actualizado");
        smt.close();
        con.close();
    }catch(Exception ex){
        JOptionPane.showMessageDialog(null,"Erro ao cadastrar");
    }
    }
    
    public void esxcluirMedico (Medico m){
    Connection con = Conectar.getConectar();
    
    String sql = "DELETE FROM medico WHERE numeroOrdem = ?";
    int opcao = JOptionPane.showConfirmDialog(null, "Deseja excluir o Funcionario"+m.getNome_funcionario(),"Exclusao",JOptionPane.YES_NO_OPTION);
    if(opcao == JOptionPane.YES_OPTION){
    try{
        PreparedStatement smt = con.prepareStatement(sql);
        smt.setInt(1,m.getNumeroOrdem());
        smt.executeUpdate();
        JOptionPane.showMessageDialog(null, "Excluido com sucesso");
        smt.close();
        con.close();
    }catch(Exception ex){
        JOptionPane.showMessageDialog(null,"Erro ao excluir Medico");
    }
    }
    }
    
    public List<Medico> listarTodos(){
        Connection con = Conectar.getConectar();
        List<Medico> listaMedicos = new ArrayList<>();
        String sql = "SELECT * FROM medico ORDER BY  numeroOrdem";
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
        }catch(Exception ex){
            JOptionPane.showMessageDialog(null, "Erro ao buscar os Medicos");
        }
        
        return  listaMedicos;
    }
}
