package models;

import dao.EspecialidadeDAO;

public class Especialidade {

    private int especialidade_id;
    private String nomeEspecialidade;
    private String descricao;

    public Especialidade(String nomeEspecilidade, String descricao) {
        this.nomeEspecialidade = nomeEspecilidade;
        this.descricao = descricao;
    }

    public Especialidade() {
    }

    public boolean cadastrarEspecialidade() {
        EspecialidadeDAO dao = new EspecialidadeDAO(this);
        return dao.insertDaoObject();
    }

 
    public int getEspecialidade_id() {
        return especialidade_id;
    } 
    
    public void setEspecialidade_id(int especialidade_id) {
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
    
     public String[] toList(){
        String[] list = new String[3];
        list[0] = String.valueOf(especialidade_id) ;
        list[1] = this.nomeEspecialidade;
        list[2] = this.descricao;
        return list;
    }

}
