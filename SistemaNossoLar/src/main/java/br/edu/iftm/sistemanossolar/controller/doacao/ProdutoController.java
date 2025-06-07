package br.edu.iftm.sistemanossolar.controller.doacao;

import java.sql.Connection;
import java.sql.SQLException;

import br.edu.iftm.sistemanossolar.dao.doacao.ProdutoDAO;
import br.edu.iftm.sistemanossolar.model.doacao.Produto;

public class ProdutoController {
    private ProdutoDAO produtoDAO;
    
    public ProdutoController (Connection conexao) {
        this.produtoDAO = new ProdutoDAO (conexao);
    }

    public boolean cadastrarProduto(Produto produto) throws SQLException {
        return produtoDAO.cadastrarProduto(produto);
    }

}