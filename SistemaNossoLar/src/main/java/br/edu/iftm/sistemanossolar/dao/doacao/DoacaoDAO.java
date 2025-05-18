package br.edu.iftm.sistemanossolar.dao.doacao;

import java.sql.Connection;

public class DoacaoDAO {
    private final Connection conexaoBanco;

    public DoacaoDAO(Connection conexao) {
        this.conexaoBanco = conexao;
    }

}