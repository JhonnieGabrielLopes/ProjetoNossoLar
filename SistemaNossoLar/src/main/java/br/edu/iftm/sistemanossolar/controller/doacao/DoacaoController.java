package br.edu.iftm.sistemanossolar.controller.doacao;

import java.sql.Connection;

import br.edu.iftm.sistemanossolar.dao.doacao.DoacaoDAO;

public class DoacaoController {
    private DoacaoDAO doacaoDAO;
    
    public DoacaoController (Connection conexao) {
        this.doacaoDAO = new DoacaoDAO (conexao);
    }

}