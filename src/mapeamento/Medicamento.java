package mapeamento;

import java.time.LocalDate;

public class Medicamento {
        private String medicamentoId;
        private String nomeMedicamento;
        private LocalDate dataFabrico;
        private LocalDate dataExpiracao;
        private String instrucao;
        
        public boolean cadastrarMedicamento (Medicamento medicamento){
            return true;
        }
        
        public boolean expirado (Medicamento medicamento){
            return true;
        }
}
