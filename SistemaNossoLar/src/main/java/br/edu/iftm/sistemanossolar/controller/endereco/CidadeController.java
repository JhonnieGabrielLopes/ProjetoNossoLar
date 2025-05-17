package br.edu.iftm.sistemanossolar.controller.endereco;

import br.edu.iftm.sistemanossolar.dao.endereco.CidadeDAO;
import br.edu.iftm.sistemanossolar.model.endereco.Cidade;

public class CidadeController {
    private CidadeDAO cidadeDAO = new CidadeDAO();

    public boolean existeCidade(Cidade cidade) {
        return cidadeDAO.existeCidade(cidade);
    }

    public boolean cadastrarCidade(Cidade novaCidade) {
        return cidadeDAO.cadastrarCidade(novaCidade);
    }
    
}