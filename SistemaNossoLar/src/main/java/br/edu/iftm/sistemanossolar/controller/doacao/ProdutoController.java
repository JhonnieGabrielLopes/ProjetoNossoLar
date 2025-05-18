package br.edu.iftm.sistemanossolar.controller.doacao;

import java.sql.Connection;

import br.edu.iftm.sistemanossolar.dao.doacao.ProdutoDAO;

public class ProdutoController {
    private ProdutoDAO produtoDAO;
    
    public ProdutoController (Connection conexao) {
        this.produtoDAO = new ProdutoDAO (conexao);
    }

}