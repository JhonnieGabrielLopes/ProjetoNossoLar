package br.edu.iftm.sistemanossolar.dao.doacao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import br.edu.iftm.sistemanossolar.controller.pessoa.TipoController;
import br.edu.iftm.sistemanossolar.model.doacao.Produto;
import br.edu.iftm.sistemanossolar.view.RegistrosLog;

public class ProdutoDAO {
    private final TipoController tipoController;
    
    private final Connection conexaoBanco;

    RegistrosLog log = new RegistrosLog();

    public ProdutoDAO(Connection conexao) {
        this.conexaoBanco = conexao;
        tipoController = new TipoController(conexao);
    }

    public boolean cadastrarProduto(Produto produto) throws SQLException {
        log.registrarLog(1, "ProdutoDAO", "cadastrarProduto", "produto", "Cadastrando o Produto "+ produto.getNome());
        Integer idTipo = null;
        if (!tipoController.existeTipo(produto.getTipo().getDescricao(), "tipoproduto")) {
            tipoController.cadastrarTipo(produto.getTipo().getDescricao(), "tipoproduto");
            idTipo = tipoController.buscarIdTipo(produto.getTipo().getDescricao(), "tipoproduto");
        } else {
            idTipo = tipoController.buscarIdTipo(produto.getTipo().getDescricao(), "tipoproduto");
        }

        String sql = "INSERT INTO produto (tipoproduto, descricao) VALUES (?, ?)";
        try (PreparedStatement stmt = conexaoBanco.prepareStatement(sql, PreparedStatement.RETURN_GENERATED_KEYS)) {
            stmt.setInt(1, idTipo);
            stmt.setString(2, produto.getNome());
            stmt.executeUpdate();
            log.registrarLog(2, "ProdutoDAO", "cadastrarProduto", "produto", "Produto cadastrado");
            

            try (ResultSet rs = stmt.getGeneratedKeys()) {
                if (rs.next()) {
                    log.registrarLog(2, "ProdutoDAO", "cadastrarProduto", "produto", "ID do Produto obtido");
                    produto.setId(rs.getInt(1));
                } else {
                    log.registrarLog(3, "ProdutoDAO", "cadastrarProduto", "produto", "ID do Produto não obtido");
                }
            } catch (SQLException e) {
                log.registrarLog(4, "ProdutoDAO", "cadastrarProduto", "produto", "Erro ao obter ID do Produto");
                e.printStackTrace();
            }

            return true;

        } catch (Exception e) {
            log.registrarLog(4, "ProdutoDAO", "cadastrarProduto", "produto", "Produto não cadastrado");
            e.printStackTrace();
            return false;
        }
    }

    public boolean buscarProduto() {
        return false;
    }

}