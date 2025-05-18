package br.edu.iftm.sistemanossolar.model.pessoa;

import br.edu.iftm.sistemanossolar.model.endereco.Endereco;

public class Doador extends Pessoa {
    private int id;

    public Doador(String nome, String telefone, Endereco endereco) {
        super(nome, telefone, endereco);
    }
    public Doador(int id, String nome, String telefone) {
        super(nome, telefone);
        this.id = id;
    }
    public int getId() {
        return id;
    }
}