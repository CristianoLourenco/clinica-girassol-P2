package models;

import java.math.BigDecimal;
import dao.FuncionarioDAO;

public  class Funcionario {
        private int id_funcionario;
        private String nome_funcionario;
        private String bi_funcionario;
        private String data_Contratacao;
        private String cargo;
        private char genero;
        private BigDecimal salario;

    public Funcionario(String nome_funcionario, String bi_funcionario, String data_Contratacao, String cargo, BigDecimal salario,char genero) {
        this.nome_funcionario = nome_funcionario;
        this.bi_funcionario = bi_funcionario;
        this.data_Contratacao = data_Contratacao;
        this.cargo = cargo;
        this.salario = salario;
        this.genero = genero;
    }


       
        
    public  boolean cadastrarFuncionario (){
        FuncionarioDAO dao = new FuncionarioDAO(this);
        return dao.insertDaoObject();
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

    public char getGenero (){
        return this.genero;
    }
    
    public void setSalario(BigDecimal salario) {
        this.salario = salario;
    }
}


