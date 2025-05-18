package br.edu.iftm.sistemanossolar.dao.doacao;

import java.sql.Connection;

public class ProdutoDAO {
    private final Connection conexaoBanco;

    public ProdutoDAO(Connection conexao) {
        this.conexaoBanco = conexao;
    }

}