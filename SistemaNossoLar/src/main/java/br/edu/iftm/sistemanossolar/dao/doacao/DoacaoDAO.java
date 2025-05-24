package br.edu.iftm.sistemanossolar.dao.doacao;

import java.sql.Connection;

public class DoacaoDAO {
    public static final String RESET = "\u001B[0m";
    public static final String VERMELHO = "\u001B[31m";
    public static final String AMARELO = "\u001B[33m";

    private final Connection conexaoBanco;

    public DoacaoDAO(Connection conexao) {
        this.conexaoBanco = conexao;
    }

    
}