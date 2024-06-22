package models;

import java.math.BigDecimal;
import dao.FuncionarioDAO;

public class Funcionario {

    private int id_funcionario;
    private String nome_funcionario;
    private String bi_funcionario;
    private String data_Contratacao;
    private final String data_nascimento;
    private String cargo;
    private String morada;
    private final String genero;
    private final String funcao;
    private final String telefone;
    private BigDecimal salario;

    public Funcionario(
            String nome_funcionario,
            String bi_funcionario, 
            String data_contrato, 
            String data_nascimento, 
            String cargo, 
            BigDecimal salario, 
            String genero,
            String funcao,
            String telefone ,
            String morada
    ) {
        this.nome_funcionario = nome_funcionario;
        this.funcao = funcao;
        this.bi_funcionario = bi_funcionario;
        this.telefone = telefone;
        this.data_Contratacao = data_contrato;
        this.cargo = cargo;
        this.salario = salario;
        this.genero = genero;
        this.morada = morada;
        this.data_nascimento = data_nascimento;
    }

    public String getMorada() {
        return morada;
    }
    public String getFuncao() {
        return funcao;
    }
    public String getTelefone() {
        return telefone;
    }

    public String getDataNascimento() {
        return data_nascimento;
    }

    public void setMorada(String morada) {
        this.morada = morada;
    }

    public boolean cadastrarFuncionario() {
        FuncionarioDAO dao = new FuncionarioDAO(this);
        return dao.insertDaoObject();
    }

    ;
         
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

    public String getGenero() {
        return this.genero;
    }

    public void setSalario(BigDecimal salario) {
        this.salario = salario;
    }
}
