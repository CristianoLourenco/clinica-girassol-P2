package mapeamento;

import dao.PacienteDAO;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Paciente {
        private int paciente_id;
        private String nome;
        private String bi;
        private String dataNascimento;
        private String morada;
        private String telefone;
        private String genero;

    public Paciente(String nome, String bi, String morada, String telefone, String genero) { 
        this.nome = nome;
        this.bi = bi;
        //this.dataNascimento = dataNascimento;
        this.morada = morada;
        this.telefone = telefone;
        this.genero = genero;
    }
        
        
        
      public boolean cadastrarPaciente (){
            boolean pacienteDao = false; 
            try {
                pacienteDao = PacienteDAO.cadastrarPaciente(this);
            } catch (SQLException ex) {
                Logger.getLogger(Paciente.class.getName()).log(Level.SEVERE, null, ex);
            }
            return pacienteDao ;
      }  
//      public boolean 

      
    /**
     * @return the nome
     */
    public String getNome() {
        return nome;
    }

    /**
     * @param nome the nome to set
     */
    public void setNome(String nome) {
        this.nome = nome;
    }

    /**
     * @return the bi
     */
    public String getBi() {
        return bi;
    }

    /**
     * @param bi the bi to set
     */
    public void setBi(String bi) {
        this.bi = bi;
    }

    /**
     * @return the dataNascimento
     */
    public String getDataNascimento() {
        return dataNascimento;
    }

    /**
     * @param dataNascimento the dataNascimento to set
     */
    public void setDataNascimento(String dataNascimento) {
        this.dataNascimento = dataNascimento;
    }

    /**
     * @return the morada
     */
    public String getMorada() {
        return morada;
    }

    /**
     * @param morada the morada to set
     */
    public void setMorada(String morada) {
        this.morada = morada;
    }

    /**
     * @return the telefone
     */
    public String getTelefone() {
        return telefone;
    }

    /**
     * @param telefone the telefone to set
     */
    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }

    /**
     * @return the genero
     */
    public String getGenero() {
        return genero;
    }

    /**
     * @param genero the genero to set
     */
    public void setGenero(String genero) {
        this.genero = genero;
    }

    /**
     * @return the paciente_id
     */
    public int getPaciente_id() {
        return paciente_id;
    }

    /**
     * @param paciente_id the paciente_id to set
     */
    public void setPaciente_id(int paciente_id) {
        this.paciente_id = paciente_id;
    }

    
      
}
