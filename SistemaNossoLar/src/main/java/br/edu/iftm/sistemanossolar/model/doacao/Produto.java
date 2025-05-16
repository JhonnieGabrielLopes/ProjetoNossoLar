package br.edu.iftm.sistemanossolar.model.doacao;

import java.util.List;

public class Produto {
    private String nome;
    private Integer quantidade;
    private List<String> tipo;

    public Produto(String nome, Integer quantidade, List<String> tipo) {
        this.nome = nome;
        this.quantidade = quantidade;
        this.tipo = tipo;
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

    public List<String> getTipo() {
        return tipo;
    }

    public void setTipo(List<String> tipo) {
        this.tipo = tipo;
    }

}