package dao;

import mapeamento.Funcionario;
import utilitarios.Conectar;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.util.ArrayList;
import javax.swing.JOptionPane;
import java.util.List;
import java.sql.ResultSet;
import java.time.LocalDate;

public class FuncionarioDAO {
    
        public void cadastrarFuncionario (Funcionario f){
                  Connection con = Conectar.getConectar();
                  
                  String sql = " INSERT INTO funcionario (nome,bi,data_contratacao,cargo,salario) VALUES (?, ?, ?, ?, ?, ?)";
                  try {
                          PreparedStatement smt = con.prepareStatement(sql) ;
                          smt.setString(1,f.getNome_funcionario());
                          smt.setString(2,f.getBi_funcionario());
                          smt.setString(3,f.getData_Contratacao().toString());
                          smt.setString(4,f.getCargo());
                          smt.setString(5,f.getSalario().toString());
                          smt.executeUpdate();
                          smt.close();
                          smt.close();
                          JOptionPane.showMessageDialog(null, "Funcionario Cadastrado com sucesso!");
                  }catch (Exception ex){
                      JOptionPane.showMessageDialog(null, "Erro ao cadastrar Funcionario");
                  }
        }
        
        public void actualizarFuncionario (Funcionario f){
            Connection con = Conectar.getConectar();
            
            String sql = "UPDATE funcionario SET nome = ?, bi = ?,data_contratacao = ?,cargo = ?,salario = ? WHERE id = ? ";
            try{
                PreparedStatement smt = con.prepareStatement(sql);
                 smt.setString(1,f.getNome_funcionario());
                 smt.setString(2,f.getBi_funcionario());
                 smt.setString(3,f.getData_Contratacao());
                 smt.setString(4,f.getCargo());
                 smt.setString(5,f.getSalario().toString());
                 smt.setInt(6, f.getId_funcionario());
                 smt.executeUpdate(); 
                 smt.close();
                 con.close();
            }catch(Exception ex){
                 JOptionPane.showMessageDialog(null, "Erro ao Cadastrar");
            }
        }
        
        public void excluirFuncionario (Funcionario f){
                Connection con = Conectar.getConectar();
                
                String sql = "DELETE FROM funcionario WHERE id = ?";
                int opcao = JOptionPane.showConfirmDialog(null, "Deseja excluir o Funcionario "+f.getNome_funcionario(),"Exclusao",JOptionPane.YES_NO_OPTION);
                if (opcao == JOptionPane.YES_OPTION){
                try{
                    PreparedStatement smt = con.prepareStatement(sql);
                        smt.setInt(1, f.getId_funcionario());
                        smt.executeUpdate();
                        smt.close();
                        con.close();
                        JOptionPane.showMessageDialog(null, "Excluido Com Sucesso");
                }catch(Exception ex){
                         JOptionPane.showMessageDialog(null, "Erro ao excluir o Funcionario");
                          }
                }
        }
                
        public List<Funcionario> listarTodos(){
                    Connection con = Conectar.getConectar();
                   List<Funcionario> listaFuncionarios = new ArrayList<>();
                   String sql = "SELECT * FROM funcionario ORDER BY nome"; 
                   try{
                       PreparedStatement smt = con.prepareStatement(sql);
                         ResultSet resultado = smt.executeQuery();
                         while (resultado.next()){
                             Funcionario f = new  Funcionario();
                             f.setId_funcionario(resultado.getInt("id"));
                             f.setNome_funcionario(resultado.getString("nome"));
                             f.setBi_funcionario(resultado.getString("bi"));
                             f.setData_Contratacao(resultado.getString("data_contratacao"));
                             f.setCargo(resultado.getString("cargo"));
                             f.setSalario(resultado.getBigDecimal("salario"));
                             listaFuncionarios.add(f);
                         }
                   }catch(Exception exc){
                       JOptionPane.showMessageDialog(null,"Erro ao buscar os funcionarios");
                   }
                   
                   return listaFuncionarios;
                }
        
        }

