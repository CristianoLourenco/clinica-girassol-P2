package models;

import java.math.BigDecimal;
import dao.FuncionarioDAO;
import java.util.ArrayList;

public class Funcionario {

    protected int id_funcionario;
    protected String nome_funcionario;
    protected String bi_funcionario;
    protected String data_Contratacao;
    protected String data_nascimento;
    protected String cargo;
    protected String morada;
    protected String genero;
    protected FuncaoEnum funcao;
    protected String telefone;
    protected BigDecimal salario;

    public Funcionario(int id_funcionario, String nome_funcionario, String bi_funcionario, String data_Contratacao, String data_nascimento, String cargo, String morada, String genero, FuncaoEnum funcao, String telefone, BigDecimal salario) {
        this.id_funcionario = id_funcionario;
        this.nome_funcionario = nome_funcionario;
        this.bi_funcionario = bi_funcionario;
        this.data_Contratacao = data_Contratacao;
        this.data_nascimento = data_nascimento;
        this.cargo = cargo;
        this.morada = morada;
        this.genero = genero;
        this.funcao = funcao;
        this.telefone = telefone;
        this.salario = salario;
    }

    /*  public Funcionario(
            String nome_funcionario,
            String bi_funcionario,
            String data_contrato,
            String data_nascimento,
            String cargo,
            BigDecimal salario,
            String genero,
            FuncaoEnum funcao,
            String telefone,
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
    }*/
    public Funcionario() {
    }

    public String getMorada() {
        return morada;
    }

    public FuncaoEnum getFuncao() {
        return funcao;
    }

    public String getTelefone() {
        return telefone;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
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

    public int getId_funcionario() {
        return id_funcionario;
    }

    protected int getId_funcionario(String name) {
        FuncionarioDAO dao = new FuncionarioDAO(this);
        ArrayList<Funcionario> lista = (ArrayList<Funcionario>) dao.listDaoObject();
        for (Funcionario model : lista) {
            if (model.nome_funcionario.matches(name)) {
                return model.id_funcionario;
            }
        }
        return -1;
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

    public void setGenero(String genero) {
        this.genero = genero;
    }

    public void setSalario(BigDecimal salario) {
        this.salario = salario;
    }

    public void setData_nascimento(String data_nascimento) {
        this.data_nascimento = data_nascimento;
    }

    public void setFuncao(FuncaoEnum funcao) {
        this.funcao = funcao;
    }
}
