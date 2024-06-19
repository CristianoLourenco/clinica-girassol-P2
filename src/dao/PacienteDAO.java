package dao;

import java.sql.*;
import javax.swing.JOptionPane;
import models.Paciente;
import controllers.Conectar;
import java.sql.Connection;
import java.time.LocalDate;
import java.util.List;
import java.util.ArrayList;

public class PacienteDAO {

    private static Connection con = null;

    public static boolean cadastrarPaciente(Paciente p) throws SQLException {
        con = Conectar.getConectar();
        String sql = "INSERT INTO paciente (nome, bi, data_nascimento, endereco, telefone, genero) VALUES(?, ?, ?, ?, ?, ?) ";
        Date data = Date.valueOf(p.getDataNascimento());
        
        System.out.println(p.getDataNascimento());
        try (PreparedStatement smt = con.prepareStatement(sql)){
            smt.setString(1, p.getNome());
            smt.setString(2, p.getBi());
            smt.setDate(3,data);
            smt.setString(4, p.getMorada());
            smt.setString(5, p.getTelefone());
            smt.setString(6, p.getGenero());
            smt.execute();
            smt.close();
            con.close();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, ex.getMessage());
            throw new RuntimeException(ex.getMessage());
        }
        return true;
    }

    public static boolean actualizarPaciente(Paciente p) {
         con = Conectar.getConectar();
        String sql = "UPDATE paciente SET nome = ? , bi = ? , data_nascimento = ? , endereco  = ? , telefone = ? , genero = ?  WHERE id = ?";
        try {
            PreparedStatement smt = con.prepareStatement(sql);
            smt.setString(1, p.getNome());
            smt.setString(2, p.getBi());
            smt.setString(3, p.getDataNascimento());
            smt.setString(4, p.getMorada());
            smt.setString(5, p.getTelefone());
            smt.setString(6, p.getGenero());
            smt.setInt(7, p.getPaciente_id());
            smt.executeUpdate();
            smt.close();
            con.close();
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(null, "Erro ao actualizar o registro!");
        }
        return true;
    }

    public static boolean excluirPaciente(Paciente p) {
         con = Conectar.getConectar();
        String sql = "DELETE FROM paciente WHERE  id = ? ";
        int opcao = JOptionPane.showConfirmDialog(null, "Deseja excluir o Paciente " + p.getNome() + " ? ", "Excluir", JOptionPane.YES_NO_OPTION);
        if (opcao == JOptionPane.YES_OPTION) {
            try{
                PreparedStatement smt = con.prepareStatement(sql);
                smt.setInt(1, p.getPaciente_id());
                smt.executeUpdate();
                smt.close();
                con.close();
            } catch (Exception ex) {
                JOptionPane.showMessageDialog(null, "Erro ao  Deletar");
            }
        }
        return true;
    }

    public static List<Paciente> listarPacientes() {
        List<Paciente> lista = new ArrayList<>();
        String sql = "SELECT * FROM paciente ORDER BY nome";
        try{
            PreparedStatement smt = con.prepareStatement(sql);
            ResultSet resultado = smt.executeQuery();
            while (resultado.next()) {

                int id = (resultado.getInt("id"));
                String nome = (resultado.getString("nome"));
                String bilhete = (resultado.getString("bi"));
                String nascimento = (resultado.getString("nascimento"));
                String morada = (resultado.getString("morada"));
                String phone = (resultado.getString("telefone"));
                String genero = (resultado.getString("genero"));
                
                Paciente p = new Paciente(nome, bilhete, morada, phone, genero,nascimento); 
                p.setPaciente_id(id);
                lista.add(p);
            }
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(null, "Erro ao buscar Registro");
        }
        return lista;
    }
}
