package br.edu.iftm.sistemanossolar.model.doacao;

import br.edu.iftm.sistemanossolar.model.pessoa.Tipo;

public class Produto {
    private Integer id;
    private String nome;
    private Integer quantidade;
    private Tipo tipo;

    public Produto(Integer id, String nome, Integer quantidade, Tipo tipo) {
        this.id = id;
        this.nome = nome;
        this.quantidade = quantidade;
        this.tipo = tipo;
    }

    public Produto() {
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public Integer getQuantidade() {
        return quantidade;
    }

    public void setQuantidade(Integer quantidade) {
        this.quantidade = quantidade;
    }

    public Tipo getTipo() {
        return tipo;
    }

    public void setTipo(Tipo tipo) {
        this.tipo = tipo;
    }

}