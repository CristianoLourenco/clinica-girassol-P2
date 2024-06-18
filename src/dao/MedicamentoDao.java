package dao;

import java.sql.*;
import javax.swing.JOptionPane;

import models.Especialidade;
import models.Funcionario;
import models.Medicamento;
import controllers.Conectar;
import java.time.LocalDate;
import java.util.List;
import java.util.ArrayList;

public class MedicamentoDao {

    private static final Connection con = Conectar.getConectar();

    private static boolean cadastrarMedicamento(Medicamento med){
        String sql = "INSERT INTO medicamento(nomeMedicamento,dataFabrico,dataExpiracao,instrucao) values (?,?,?,?)";

        try{
            PreparedStatement smt = con.prepareStatement(sql);
            smt.setString(1,med.getNomeMedicamento());
            smt.setString(2,med.getDataFabrico());
            smt.setString(3,med.getDataExpiracao());
            smt.setString(4,med.getInstrucao());
            smt.executeUpdate();
            JOptionPane.showMessageDialog(null, "Cadastro feito com sucesso");
            smt.close();
            con.close();
        }catch(Exception ex){
            JOptionPane.showMessageDialog(null,"Erro ao cadastrar medicamento");;
        }

        
        return true;
    }

    private static boolean actualizarMedicamento(Medicamento med){ 
        String sql = "UPDATE medicamento SET nomeMedicamento = ?, dataFabrico = ?,dataExpiracao = ?,instrucao = ?";

        try{
            PreparedStatement smt = con.prepareStatement(sql);
            smt.setString(1,med.getNomeMedicamento());
            smt.setString(2,med.getDataFabrico());
            smt.setString(3,med.getDataExpiracao());
            smt.setString(4,med.getInstrucao());
            smt.executeUpdate();
            JOptionPane.showMessageDialog(null,"Actualizacao feita com sucesso");
            smt.close();
            con.close();
        }catch(Exception ex){
            JOptionPane.showMessageDialog(null,"Erro ao actualizar medicamento");
        }

        return true;
    }

    private static boolean excluirMedicamento(Medicamento med){
        String sql = "DELETE FROM medicamento WHERE id = ?";
        int opcao = JOptionPane.showConfirmDialog(null,"Deseja excluir o medicamento "+med.getNomeMedicamento()+" ? ","Excluir",JOptionPane.YES_NO_OPTION);
        if(opcao == JOptionPane.YES_OPTION){
            try {
                PreparedStatement smt = con.prepareStatement(sql);
                smt.setInt(1,med.getMedicamentoId());
                smt.setString(2,med.getNomeMedicamento());
                smt.setString(3, med.getDataFabrico().toString());
                smt.setString(4,med.getDataExpiracao().toString());
                smt.setString(5,med.getInstrucao());
                smt.executeUpdate();
                JOptionPane.showMessageDialog(null,"Medicamento excluido com sucesso");
                smt.close();
                con.close();
            } catch (Exception ex) {
                JOptionPane.showMessageDialog(null,"Erro ao excluir medicamento");
            }
        }

        return true;
    }

    private static List<Medicamento> listarMedicamentos(){
        List<Medicamento> listaMedicamentos = new ArrayList<>();
        String sql = "SELECT * FROM medicamento ORDER BY nomeMedicamento";
        try {
            PreparedStatement smt = con.prepareStatement(sql);
            ResultSet resultado = smt.executeQuery();
            while (resultado.next()) {
                     Medicamento med = new  Medicamento();
                             med.setMedicamentoId(resultado.getInt("medicamentoId"));
                             med.setNomeMedicamento(resultado.getString("nomeMedicamento"));
                             med.setDataFabrico(resultado.getString("dataFabrico"));
                             med.setDataExpiracao(resultado.getString("dataExpiracao"));
                             med.setInstrucao(resultado.getString("instrucao"));
                             listaMedicamentos.add(med);
            }
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(null,"Erro ao buscar Registro");
        }

        return listaMedicamentos;
    }
}
