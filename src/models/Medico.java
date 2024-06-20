package models;

import java.math.BigDecimal;
import java.time.LocalTime;

 

public class Medico extends Funcionario {
        private int numeroOrdem;
        private String medico_especialidade;
        private String horarioTrabalho;

    public Medico(
            String nome_funcionario, 
            String bi_funcionario, 
            String data_Contratacao, 
            String data_nascimento, 
            String cargo, 
            BigDecimal salario, 
            String genero, 
            String funcao, 
            String telefone, 
            String morada
    ) {
        super(nome_funcionario, bi_funcionario, data_Contratacao, data_nascimento, cargo, salario, genero, funcao, telefone, morada);
    }

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
