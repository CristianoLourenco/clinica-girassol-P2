package models;

import java.time.LocalTime;

 

public class Medico extends Funcionario {
        private int numeroOrdem;
        private String medico_especialidade;
        private String horarioTrabalho;

    
    public boolean cadastrarMedico(int crm,String especialidade,LocalTime horario_trabalho){
        return true;
    }
 
    public int getNumeroOrdem() {
        return numeroOrdem;
    }
 
    public void setNumeroOrdem(int numeroOrdem) {
        this.numeroOrdem = numeroOrdem;
    }

    /**
     * @return the especialidade
     */
    public String getMedico_especialidade() {
        return medico_especialidade;
    }

   
    public void setMedico_especialidade(String medico_especialidade) {
        this.medico_especialidade = medico_especialidade;
    }

    /**
     * @return the horarioTrabalho
     */
    public String getHorarioTrabalho() {
        return horarioTrabalho;
    }

    /**
     * @param horarioTrabalho the horarioTrabalho to set
     */
    public void setHorarioTrabalho(String horarioTrabalho) {
        this.horarioTrabalho = horarioTrabalho;
    }
    
    
}