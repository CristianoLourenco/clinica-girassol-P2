package mapeamento;

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

        
        
    /**
     * @return the id_funcionario
     */
    public int getId_funcionario() {
        return id_funcionario;
    }

    /**
     * @param id_funcionario the id_funcionario to set
     */
    public void setId_funcionario(int id_funcionario) {
        this.id_funcionario = id_funcionario;
    }

    /**
     * @return the nome_funcionario
     */
    public String getNome_funcionario() {
        return nome_funcionario;
    }

    /**
     * @param nome_funcionario the nome_funcionario to set
     */
    public void setNome_funcionario(String nome_funcionario) {
        this.nome_funcionario = nome_funcionario;
    }

    /**
     * @return the bi_funcionario
     */
    public String getBi_funcionario() {
        return bi_funcionario;
    }

    /**
     * @param bi_funcionario the bi_funcionario to set
     */
    public void setBi_funcionario(String bi_funcionario) {
        this.bi_funcionario = bi_funcionario;
    }

    /**
     * @return the data_Contratacao
     */
    public String getData_Contratacao() {
        return data_Contratacao;
    }

    /**
     * @param data_Contratacao the data_Contratacao to set
     */
    public void setData_Contratacao(String data_Contratacao) {
        this.data_Contratacao = data_Contratacao;
    }

    /**
     * @return the cargo
     */
    public String getCargo() {
        return cargo;
    }

    /**
     * @param cargo the cargo to set
     */
    public void setCargo(String cargo) {
        this.cargo = cargo;
    }

    /**
     * @return the salario
     */
    public BigDecimal getSalario() {
        return salario;
    }

    /**
     * @param salario the salario to set
     */
    public void setSalario(BigDecimal salario) {
        this.salario = salario;
    }
}


