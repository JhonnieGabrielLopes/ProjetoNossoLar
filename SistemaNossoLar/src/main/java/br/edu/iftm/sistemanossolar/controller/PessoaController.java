package br.edu.iftm.sistemanossolar.controller;

import br.edu.iftm.sistemanossolar.dao.PessoaDAO;
import br.edu.iftm.sistemanossolar.model.pessoa.Pessoa;
import br.edu.iftm.sistemanossolar.model.pessoa.Tipo;

public class PessoaController {
    private PessoaDAO pessoaDAO = new PessoaDAO();

    public boolean cadastrarPessoa(Pessoa pessoa, Tipo tipo){
        return pessoaDAO.cadastrarPessoa(pessoa, tipo);
    }

}
