package br.edu.iftm.sistemanossolar.model.pessoa.doador;

import br.edu.iftm.sistemanossolar.model.pessoa.Pessoa;
import br.edu.iftm.sistemanossolar.model.pessoa.Tipo;

public class Doador extends Pessoa {

    public Doador(String nome, String telefone, Tipo tipo) {
        super(nome, telefone, tipo);
    }

}