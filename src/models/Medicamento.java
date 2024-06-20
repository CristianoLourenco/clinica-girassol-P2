package models;

public class Medicamento {
        private int medicamentoId;
        private String nomeMedicamento;
        private String dataFabrico;
        private String dataExpiracao;
        private String instrucao;

    public Medicamento(String nomeMedicamento, String dataFabrico, String dataExpiracao, String instrucao) {
        this.nomeMedicamento = nomeMedicamento;
        this.dataFabrico = dataFabrico;
        this.dataExpiracao = dataExpiracao;
        this.instrucao = instrucao;
    }

        public boolean cadastrarMedicamento (Medicamento medicamento){
            return true;
        }
        
        public boolean expirado (Medicamento medicamento){
            return true;
        }

        //Getters
        public int getMedicamentoId(){
            return this.medicamentoId;
        }

        public String getNomeMedicamento(){
            return this.nomeMedicamento;
        }

        public String getDataFabrico(){
            return this.dataFabrico;
        }

        public String getDataExpiracao(){
            return this.dataExpiracao;
        }

        public String getInstrucao(){
            return this.instrucao;
        }

        //Setters
        public void setMedicamentoId(int medicamentoId){
            this.medicamentoId = medicamentoId;
        }
        
        public void setNomeMedicamento(String nomeMedicamento){
            this.nomeMedicamento = nomeMedicamento;
        }

        public void setDataFabrico(String dataFabrico){
            this.dataFabrico = dataFabrico;
        }

        public void setDataExpiracao(String dataExpiracao){
            this.dataExpiracao = dataExpiracao;
        }

        public void setInstrucao(String instrucao){
            this.instrucao = instrucao;
        }
}
