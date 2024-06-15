package models;

public class Especialidade {
        private String especialidade_id;
        private String nomeEspecialidade;
        private String descricao;
        
        public boolean cadastrarEspecialidade (Especialidade especialidade){
            return true;
        }

        
     
    public String getEspecialidade_id() {
        return especialidade_id;
    }
 
    public void setEspecialidade_id(String especialidade_id) {
        this.especialidade_id = especialidade_id;
    }
 
    public String getNomeEspecialidade() {
        return nomeEspecialidade;
    }
 
    public void setNomeEspecialidade(String nomeEspecialidade) {
        this.nomeEspecialidade = nomeEspecialidade;
    }

    
    public String getDescricao() {
        return descricao;
    }

     
    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }
        
        
        
}
