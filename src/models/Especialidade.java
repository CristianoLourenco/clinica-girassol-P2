package mapeamento;

public class Especialidade {
        private String especialidade_id;
        private String nomeEspecialidade;
        private String descricao;
        
        public boolean cadastrarEspecialidade (Especialidade especialidade){
            return true;
        }

        
        
    /**
     * @return the especialidade_id
     */
    public String getEspecialidade_id() {
        return especialidade_id;
    }

    /**
     * @param especialidade_id the especialidade_id to set
     */
    public void setEspecialidade_id(String especialidade_id) {
        this.especialidade_id = especialidade_id;
    }

    /**
     * @return the nomeEspecialidade
     */
    public String getNomeEspecialidade() {
        return nomeEspecialidade;
    }

    /**
     * @param nomeEspecialidade the nomeEspecialidade to set
     */
    public void setNomeEspecialidade(String nomeEspecialidade) {
        this.nomeEspecialidade = nomeEspecialidade;
    }

    /**
     * @return the descricao
     */
    public String getDescricao() {
        return descricao;
    }

    /**
     * @param descricao the descricao to set
     */
    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }
        
        
        
}
