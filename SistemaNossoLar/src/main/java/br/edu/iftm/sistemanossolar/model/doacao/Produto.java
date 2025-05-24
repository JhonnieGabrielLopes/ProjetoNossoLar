package br.edu.iftm.sistemanossolar.model.doacao;

import br.edu.iftm.sistemanossolar.model.pessoa.Tipo;

public class Produto {
    private String nome;
    private Integer quantidade;
    private Tipo tipo;

    public Produto(String nome, Integer quantidade, Tipo tipo) {
        this.nome = nome;
        this.quantidade = quantidade;
        this.tipo = tipo;
    }

    public Produto() {
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