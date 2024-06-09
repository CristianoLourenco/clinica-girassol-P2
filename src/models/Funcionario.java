package mapeamento;

import java.math.BigDecimal;
import java.time.LocalDate;

public abstract class Funcionario {
        private String funcionario_id;
        private String funcNome;
        private String cargo;
        private BigDecimal salario;
        private LocalDate dataContratacao;
        
        public abstract boolean cadastrarFuncionario (String funcionario_id, String funcNome, String cargo, BigDecimal salario, LocalDate dataContratacao);
}
