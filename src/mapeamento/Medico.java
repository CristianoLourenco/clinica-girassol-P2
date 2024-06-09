package mapeamento;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.LocalTime;

public class Medico extends Funcionario {
        private String numeroDaOrdem;
        private String especialidade;
        private LocalTime horarioTrabalho;

    @Override
    public boolean cadastrarFuncionario(String funcionario_id, String funcNome, String cargo, BigDecimal salario, LocalDate dataContratacao) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
    

    

    /**
     * @return the numeroDaOrdem
     */
    public String getNumeroDaOrdem() {
        return numeroDaOrdem;
    }

    /**
     * @param numeroDaOrdem the numeroDaOrdem to set
     */
    public void setNumeroDaOrdem(String numeroDaOrdem) {
        this.numeroDaOrdem = numeroDaOrdem;
    }

    /**
     * @return the especialidade
     */
    public String getEspecialidade() {
        return especialidade;
    }

    /**
     * @param especialidade the especialidade to set
     */
    public void setEspecialidade(String especialidade) {
        this.especialidade = especialidade;
    }

    /**
     * @return the horarioTrabalho
     */
    public LocalTime getHorarioTrabalho() {
        return horarioTrabalho;
    }

    /**
     * @param horarioTrabalho the horarioTrabalho to set
     */
    public void setHorarioTrabalho(LocalTime horarioTrabalho) {
        this.horarioTrabalho = horarioTrabalho;
    }

    
}
