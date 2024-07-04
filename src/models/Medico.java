package models;

import dao.MedicoDAO;
import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.LocalTime;

public class Medico extends Funcionario {

    private int numeroOrdem; 
    private String especialidade_id;
    private String hora_disponivel;
    private LocalDate dia_disponivel;

    public Medico(
            int id,
            int numeroOrdem,
            String especialidade,
            String nome,
            String bi,
            String genero,
            String cargo,
            BigDecimal salario,
            String morada,
            String telefone,
            String data_nascimento,
            String data_contrato,
            String hora,
            LocalDate dia
    ) {
        this.id_funcionario = id;
        this.numeroOrdem = numeroOrdem;
        this.nome_funcionario = nome;
        this.especialidade_id = especialidade;
        this.bi_funcionario = bi;
        this.genero = genero;
        this.cargo = cargo;
        this.data_Contratacao = data_contrato;
        this.data_nascimento = data_nascimento;
        this.salario = salario;
        this.morada = morada;
        this.telefone = telefone;
        this.dia_disponivel = dia;
        this.hora_disponivel = hora; 
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

    public String getEspecialidade_id() {
        return especialidade_id;
    }

    public void setEspecialidade_id(String especialidade_id) {
        this.especialidade_id = especialidade_id;
    }

    public String getHora_disponivel() {
        return hora_disponivel;
    }

    public void setHora_disponivel(String hora_disponivel) {
        this.hora_disponivel = hora_disponivel;
    }

    public LocalDate getDia_disponivel() {
        return dia_disponivel;
    }

    public void setDia_disponivel(LocalDate dia_disponivel) {
        this.dia_disponivel = dia_disponivel;
    }
    
    public int getNumeroOrdem() {
        return numeroOrdem;
    }

    public void setNumeroOrdem(int numeroOrdem) {
        this.numeroOrdem = numeroOrdem;
    }

  

  
}
