package models;

import dao.PacienteDAO;
import java.sql.SQLException;  
import javax.swing.JOptionPane;

public class Paciente {
        private int id;
        private String nome;
        private String bi;
        private String dataNascimento;
        private String morada;
        private String telefone;
        private String genero;

    public Paciente(String nome, String bi, String morada, String telefone, String genero, String dataNascimento) { 
        this.nome = nome;
        this.bi = bi;
        this.dataNascimento = dataNascimento;
        this.morada = morada;
        this.telefone = telefone;
        this.genero = genero;
    }
        
        
        
      public boolean cadastrarPaciente () {
            boolean resultado = false; 
            try {
                resultado = PacienteDAO.cadastrarPaciente(this);
            } catch (SQLException ex) {
                JOptionPane.showConfirmDialog(null, "Falha na Operação: "+ ex.getMessage());
                throw new RuntimeException(ex.getMessage());
            }
            return resultado ;
      }  
 
    public String getNome() {
        return nome;
    }
 
    public void setNome(String nome) {
        this.nome = nome;
    }

 
    public String getBi() {
        return bi;
    }
 
    public void setBi(String bi) {
        this.bi = bi;
    }

  
    public String getDataNascimento() {
        return dataNascimento;
    }

    
    public void setDataNascimento(String dataNascimento) {
        this.dataNascimento = dataNascimento;
    }

     
    public String getMorada() {
        return morada;
    }
 
    public void setMorada(String morada) {
        this.morada = morada;
    }

   
    public String getTelefone() {
        return telefone;
    }
 
    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }
 
    public String getGenero() {
        return genero;
    }

    
    public void setGenero(String genero) {
        this.genero = genero;
    }

     
    public int getPaciente_id() {
        return id;
    }
 
    public void setPaciente_id(int paciente_id) {
        this.id = paciente_id;
    }
}
