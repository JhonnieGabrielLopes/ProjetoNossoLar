package br.edu.iftm.sistemanossolar.controller.doacao;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import br.edu.iftm.sistemanossolar.dao.doacao.ProdutoDAO;
import br.edu.iftm.sistemanossolar.model.doacao.Produto;
import br.edu.iftm.sistemanossolar.view.RegistrosLog;

public class ProdutoController {
    private ProdutoDAO produtoDAO;

    RegistrosLog log = new RegistrosLog();
    
    public ProdutoController (Connection conexao) {
        this.produtoDAO = new ProdutoDAO (conexao);
    }

    public boolean cadastrarProduto(Produto produto) throws SQLException {
        return produtoDAO.cadastrarProduto(produto);
    }

    public List<Produto> listarProdutos(String nomeProduto, String tipoProduto) throws SQLException {
        log.registrarLog(1, "ProdutoController", "buscarProdutos", "usuario, endereco, cidade", "Listando pessoas para seleção");
        StringBuilder sqlFiltro = new StringBuilder();
        List<Object> filtros = new ArrayList<>();

        if (!nomeProduto.isEmpty() || !nomeProduto.equals("")) {
            sqlFiltro.append("AND descricao LIKE ? ");
            filtros.add("%"+ nomeProduto +"%");
        }

        if (!tipoProduto.isEmpty() && !tipoProduto.equals("Todos")) {
            sqlFiltro.append("AND tipoproduto LIKE ? ");
            filtros.add("%"+ tipoProduto +"%");
        }

        return produtoDAO.listarProdutos(sqlFiltro.toString(), filtros);
    }

    public String capturarNomeProduto(Integer idProduto) throws SQLException {
        log.registrarLog(1, "ProdutoController", "capturarNomeProduto", "produto", "Obtendo nome do produto");
        return produtoDAO.capturarNomeProduto(idProduto);
    }

}