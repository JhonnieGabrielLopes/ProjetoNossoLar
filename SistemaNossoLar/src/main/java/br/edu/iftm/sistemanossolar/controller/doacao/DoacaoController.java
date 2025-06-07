package br.edu.iftm.sistemanossolar.controller.doacao;

import java.sql.Connection;
import java.sql.SQLException;

import br.edu.iftm.sistemanossolar.dao.doacao.DoacaoDAO;
import br.edu.iftm.sistemanossolar.model.doacao.Doacao;

public class DoacaoController {
    private DoacaoDAO doacaoDAO;
    
    public DoacaoController (Connection conexao) {
        this.doacaoDAO = new DoacaoDAO (conexao);
    }

    public boolean cadastrarDoacao(Doacao doacao) throws SQLException {
        return doacaoDAO.cadastrarDoacao(doacao);
    }

}