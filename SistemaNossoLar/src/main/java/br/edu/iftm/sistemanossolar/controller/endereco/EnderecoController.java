package br.edu.iftm.sistemanossolar.controller.endereco;

import br.edu.iftm.sistemanossolar.dao.endereco.EnderecoDAO;
import br.edu.iftm.sistemanossolar.model.endereco.Cidade;
import br.edu.iftm.sistemanossolar.model.endereco.Endereco;

public class EnderecoController {
    private EnderecoDAO enderecoDAO = new EnderecoDAO();

    public boolean cadastrarEndereco(Endereco novoEndereco, Cidade cidadeTemp) {
        return enderecoDAO.cadastrarEndereco(novoEndereco, cidadeTemp);
    }

}