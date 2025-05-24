package br.edu.iftm.sistemanossolar.dao.doacao;

import java.sql.Connection;
import java.sql.PreparedStatement;

import br.edu.iftm.sistemanossolar.model.doacao.Produto;
import br.edu.iftm.sistemanossolar.view.RegistrosLog;

public class ProdutoDAO {
    public static final String RESET = "\u001B[0m";
    public static final String VERMELHO = "\u001B[31m";
    public static final String AMARELO = "\u001B[33m";
    
    private final Connection conexaoBanco;

    RegistrosLog log = new RegistrosLog();

    public ProdutoDAO(Connection conexao) {
        this.conexaoBanco = conexao;
    }

    public boolean cadastrarProduto(Produto produto) {
        log.registrarLog(1, "ProdutoDAO", "cadastrarProduto", "produto", "Cadastrando o Produto "+ produto.getNome());

        String sql = "INSERT INTO produto tipo VALUES (?)";
        try (PreparedStatement stmt = conexaoBanco.prepareStatement(sql)) {
            stmt.setString(1, produto.getTipo().getDescricao());
            stmt.executeUpdate();
            log.registrarLog(2, "ProdutoDAO", "cadastrarProduto", "produto", "Produto cadastrado");
            return true;

        } catch (Exception e) {
            log.registrarLog(4, "ProdutoDAO", "cadastrarProduto", "produto", "Produto não cadastrado");
            e.printStackTrace();
            return false;
        }
    }

}