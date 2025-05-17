package br.edu.iftm.sistemanossolar.controller;

import br.edu.iftm.sistemanossolar.dao.PessoaDAO;
import br.edu.iftm.sistemanossolar.model.pessoa.Cliente;
import br.edu.iftm.sistemanossolar.model.pessoa.Tipo;

public class PessoaController {
    private PessoaDAO pessoaDAO = new PessoaDAO();

    public boolean cadastrarCliente(Cliente cliente, Tipo tipo){
        return pessoaDAO.cadastrarCliente(cliente, tipo);
    }
}
