package dao;
 
import java.sql.*;
import javax.swing.JOptionPane;
import models.Especialidade;
import controllers.Conectar;
import java.sql.Connection;
import java.util.List;
import java.util.ArrayList;

public abstract class EspecialidadeDAO {
    
    private static final Connection con = Conectar.getConectar();
       
        public static boolean cadastrarEspecialidade(Especialidade esp){
            String sql = "INSERT INTO paciente (nomeEspecialidade,descricao) VALUES (?,?)";
            
            try(PreparedStatement smt = con.prepareStatement(sql);){
                smt.setString(1, esp.getNomeEspecialidade());
                smt.setString(2,esp.getDescricao());
                smt.executeUpdate();
                JOptionPane.showMessageDialog(null,"Especialidade cadastrada com sucesso");
                smt.close();
                con.close();
            }catch(Exception ex){
                JOptionPane.showMessageDialog(null,"Erro ao cadastrar especialidade");
            }
            return true;
        }
        
        public static boolean actualizarEspecialidade(Especialidade esp){
            String sql = "UPDATE especialidade SET  nomeEspecialidade = ? , descricao = ? WHERE id = ?";
            try(PreparedStatement smt = con.prepareStatement(sql);){
                smt.setString(1,esp.getNomeEspecialidade());
                smt.setString(2, esp.getDescricao());
                smt.executeUpdate();
                JOptionPane.showMessageDialog(null,"Actualizado com sucesso");
                smt.close();
                con.close();
            }catch(Exception ex){
                JOptionPane.showMessageDialog(null,"Erro ao actualizar especialidade");
            }
            return true;
        }
        
        public static boolean excluirEspecialidade(Especialidade esp){
           String sql = "DELETE FROM especialidade WHERE id = ?";
           int opcao = JOptionPane.showConfirmDialog(null,"Deseja excluir a especialidade "+esp.getNomeEspecialidade()+" ? ","Excluir",JOptionPane.YES_NO_OPTION);
           if(opcao == JOptionPane.YES_OPTION){
               try(PreparedStatement smt = con.prepareStatement(sql);){
                   smt.setInt(1,esp.getEspecialidade_id());
                   smt.executeUpdate();
                   smt.close();
                   con.close();
               }catch(Exception ex){
                   JOptionPane.showMessageDialog(null,"Erro ao Deletar");
               }
           }
           return true;
        }
        
        public static List<Especialidade> listarEspecialidade(){
            List<Especialidade> lista = new ArrayList<>();
            String sql = "SELECT * FROM especialidade ORDER BY nomeEspecialidade";
            try(PreparedStatement smt = con.prepareStatement(sql);){
                ResultSet resultado = smt.executeQuery();
                while (resultado.next()){
                    
                    int id = (resultado.getInt("especialidade_id"));
                    String nome = (resultado.getString("nomeEspecialidade"));
                    String descricao = (resultado.getString("descricao"));
                    
                    Especialidade esp = new Especialidade(nome,descricao);
                    esp.setNomeEspecialidade(nome);
                    esp.setDescricao(descricao);
                    lista.add(esp);
                }
            }catch(Exception ex){
                JOptionPane.showMessageDialog(null,"Erro ao buscar Registro");
            }
            return lista;
        }
}
