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
        super(
                nome_funcionario, 
                bi_funcionario, 
                data_contrato, 
                data_nascimento, 
                cargo, 
                salario,
                genero, 
                funcao, 
                telefone, 
                morada
        );
        this.especialidade_id = especialidade;
        this.numeroOrdem = numeroOrdem;
      //  this.medico_especialidade = medico_especialidade;
        this.horarioTrabalho = horarioTrabalho;
    }

    @Override
    public boolean cadastrarFuncionario() {
        super.cadastrarFuncionario();
        int id = super.getId_funcionario(nome_funcionario);
        setId_funcionario(id);
        MedicoDAO dao = new MedicoDAO(this);
        return dao.insertDaoObject();
    }

    public int getNumeroOrdem() {
        return numeroOrdem;
    }

    public void setNumeroOrdem(int numeroOrdem) {
        this.numeroOrdem = numeroOrdem;
    }
    public void setEpecialidadeId(int id){
        this.especialidade_id = id;
    }
    public int getEspecialidadeId(){
        return this.especialidade_id;
    }
/*    public String getMedico_especialidade() {
        return medico_especialidade;
    }

    public void setMedico_especialidade(String medico_especialidade) {
        this.medico_especialidade = medico_especialidade;
    }
*/
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
