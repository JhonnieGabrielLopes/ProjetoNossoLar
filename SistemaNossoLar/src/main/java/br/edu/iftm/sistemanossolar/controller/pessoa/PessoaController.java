package br.edu.iftm.sistemanossolar.controller.pessoa;

import br.edu.iftm.sistemanossolar.dao.pessoa.PessoaDAO;
import br.edu.iftm.sistemanossolar.model.pessoa.Pessoa;
import br.edu.iftm.sistemanossolar.model.pessoa.Tipo;

public class PessoaController {
    private PessoaDAO pessoaDAO = new PessoaDAO();

    public boolean cadastrarPessoa(Pessoa pessoa, Tipo tipo){
        return pessoaDAO.cadastrarPessoa(pessoa, tipo);
    }

}
