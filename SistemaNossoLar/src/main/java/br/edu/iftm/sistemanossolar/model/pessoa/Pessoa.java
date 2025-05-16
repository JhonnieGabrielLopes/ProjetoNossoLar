package br.edu.iftm.sistemanossolar.model.pessoa;

import br.edu.iftm.sistemanossolar.model.endereco.Endereco;

public abstract class Pessoa {
    private String nome;
    private String telefone;
    private Tipo tipo;
    private String email;
    private String identificacao;
    private Endereco endereco;

    public Pessoa(String nome, String telefone, Tipo tipo) {
        this.nome = nome;
        this.telefone = telefone;
        this.tipo = tipo;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getTelefone() {
        return telefone;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getIdentificacao() {
        return identificacao;
    }

    public void setIdentificacao(String identificacao) {
        this.identificacao = identificacao;
    }

    public Tipo getTipo() {
        return tipo;
    }

    public void setTipo(Tipo tipo) {
        this.tipo = tipo;
    }
    
    public Endereco getEndereco() {
        return endereco;
    }

    public void setEndereco(Endereco endereco) {
        this.endereco = endereco;
    }

}
