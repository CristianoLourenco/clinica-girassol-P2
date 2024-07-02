package models;

import dao.MedicoDAO;
import java.math.BigDecimal;
import java.time.LocalTime;

public class Medico extends Funcionario {

    private int numeroOrdem;
    // private String medico_especialidade;
    private String horarioTrabalho;
    private int especialidade_id;

    public Medico(
            int numeroOrdem,
            String nome_funcionario,
            String bi_funcionario,
            String data_contrato,
            String data_nascimento,
            String cargo,
            BigDecimal salario,
            String genero,
            FuncaoEnum funcao,
            String telefone,
            String morada,
            int especialidade
    ) {
        this.nome_funcionario = nome_funcionario;
        this.bi_funcionario = bi_funcionario;
        this.data_Contratacao = data_contrato;
        this.data_nascimento = data_nascimento;
        this.cargo = cargo;
        this.salario = salario;
        this.genero = genero;
        this.funcao = funcao;
        this.telefone = telefone;
        this.morada = morada;
        this.especialidade_id = especialidade;
        this.numeroOrdem = numeroOrdem;
        //TODO: configurar o horario do medico
        //  this.horarioTrabalho = horarioTrabalho;
    }

    public Medico() {

    }

    @Override
    public boolean cadastrarFuncionario() {
        super.cadastrarFuncionario();
        int id = super.getId_funcionario(nome_funcionario);
        setId_funcionario(id);
        System.out.println(id);
        MedicoDAO dao = new MedicoDAO(this);
        return dao.insertDaoObject();
    }

    public int getNumeroOrdem() {
        return numeroOrdem;
    }

    public void setNumeroOrdem(int numeroOrdem) {
        this.numeroOrdem = numeroOrdem;
    }

    public void setEpecialidadeId(int id) {
        this.especialidade_id = id;
    }

    public int getEspecialidadeId() {
        return this.especialidade_id;
    }

    public String getHorarioTrabalho() {
        return horarioTrabalho;
    }

    public void setHorarioTrabalho(String horarioTrabalho) {
        this.horarioTrabalho = horarioTrabalho;
    }

}
