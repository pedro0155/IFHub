
package model;

public class Projeto {
    private int id;
    private String nomeProjeto;
    private String descricaoProjeto;
    private double rateProjeto;
    private String categoria;

    public Projeto(int id, String nomeProjeto, String descricaoProjeto, double rateProjeto, String categoria) {
        this.id = id;
        this.nomeProjeto = nomeProjeto;
        this.descricaoProjeto = descricaoProjeto;
        this.rateProjeto = rateProjeto;
        this.categoria = categoria;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNomeProjeto() {
        return nomeProjeto;
    }

    public void setNomeProjeto(String nomeProjeto) {
        this.nomeProjeto = nomeProjeto;
    }

    public String getDescricaoProjeto() {
        return descricaoProjeto;
    }

    public void setDescricaoProjeto(String descricaoProjeto) {
        this.descricaoProjeto = descricaoProjeto;
    }

    public double getRateProjeto() {
        return rateProjeto;
    }

    public void setRateProjeto(double rateProjeto) {
        this.rateProjeto = rateProjeto;
    }

    public String getCategoria() {
        return categoria;
    }

    public void setCategoria(String categoria) {
        this.categoria = categoria;
    }
    
    
    
    
}
