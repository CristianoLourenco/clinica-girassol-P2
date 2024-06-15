package models;

import java.math.BigDecimal;
import java.time.LocalDate;

public  class Funcionario {
        private int id_funcionario;
        private String nome_funcionario;
        private String bi_funcionario;
        private String data_Contratacao;
        private String cargo;
        private BigDecimal salario;
       
        
    public  boolean cadastrarFuncionario (String funcionario_id, String funcNome, String cargo, BigDecimal salario, LocalDate dataContratacao){
        return true;
    };

        
         
    public int getId_funcionario() {
        return id_funcionario;
    }

   
    public void setId_funcionario(int id_funcionario) {
        this.id_funcionario = id_funcionario;
    }
 
    public String getNome_funcionario() {
        return nome_funcionario;
    }

  
    public void setNome_funcionario(String nome_funcionario) {
        this.nome_funcionario = nome_funcionario;
    }

    
    public String getBi_funcionario() {
        return bi_funcionario;
    }

     
    public void setBi_funcionario(String bi_funcionario) {
        this.bi_funcionario = bi_funcionario;
    }
 
    public String getData_Contratacao() {
        return data_Contratacao;
    }

     
    public void setData_Contratacao(String data_Contratacao) {
        this.data_Contratacao = data_Contratacao;
    }

   
    public String getCargo() {
        return cargo;
    }

     
    public void setCargo(String cargo) {
        this.cargo = cargo;
    }

     
    public BigDecimal getSalario() {
        return salario;
    }

    
    public void setSalario(BigDecimal salario) {
        this.salario = salario;
    }
}


