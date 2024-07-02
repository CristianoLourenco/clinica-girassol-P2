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

    public boolean cadastrarEspecialidade() {
        EspecialidadeDAO dao = new EspecialidadeDAO(this);
        return dao.insertDaoObject();
    }

    /**
     * @return the especialidade_id
     */
    public int getEspecialidade_id() {
        return especialidade_id;
    }

    /**
     * @param especialidade_id the especialidade_id to set
     */
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

}
