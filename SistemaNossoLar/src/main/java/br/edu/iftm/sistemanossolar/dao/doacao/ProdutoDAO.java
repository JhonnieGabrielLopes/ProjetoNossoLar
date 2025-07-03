package br.edu.iftm.sistemanossolar.dao.doacao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import br.edu.iftm.sistemanossolar.model.doacao.Produto;
import br.edu.iftm.sistemanossolar.model.doacao.Produto.TipoProd;
import br.edu.iftm.sistemanossolar.view.RegistrosLog;

public class ProdutoDAO {
    
    private final Connection conexaoBanco;

    RegistrosLog log = new RegistrosLog();

    public ProdutoDAO(Connection conexao) {
        this.conexaoBanco = conexao;
    }

    public boolean cadastrarProduto(Produto produto) throws SQLException {
        log.registrarLog(1, "ProdutoDAO", "cadastrarProduto", "produto", "Cadastrando o Produto "+ produto.getNome());

        String sql = "INSERT INTO produto (tipoproduto, descricao) VALUES (?, ?)";
        try (PreparedStatement stmt = conexaoBanco.prepareStatement(sql, PreparedStatement.RETURN_GENERATED_KEYS)) {
            stmt.setString(1, produto.getTipo().toString());
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

    public List<Produto> listarProdutos(String sqlFiltro, List<Object> filtros) throws SQLException {
        StringBuilder sql = new StringBuilder();
        sql.append("SELECT id AS codigo_produto, descricao AS produto, tipoProduto ");
        sql.append("FROM produto ");
        sql.append("WHERE 1=1 ");
        sql.append(sqlFiltro);
        sql.append("ORDER BY descricao ASC");

        try (PreparedStatement stmt = conexaoBanco.prepareStatement(sql.toString())) {
            for (int i = 0; i < filtros.size(); i++) {
                stmt.setObject(i + 1, filtros.get(i));
            }

            ResultSet rs = stmt.executeQuery();
            List<Produto> produtos = new ArrayList<>();
            int qtdProdutos = 0;

            while (rs.next()) {
                Produto produto = new Produto();
                produto.setId(rs.getInt("codigo_produto"));
                produto.setNome(rs.getString("produto"));
                if(rs.getString("tipoProduto").equals("ALIMENTO")){
                    produto.setTipo(TipoProd.ALIMENTO);
                }else if(rs.getString("tipoProduto").equals("LIMPEZA")){
                    produto.setTipo(TipoProd.LIMPEZA);
                }else if(rs.getString("tipoProduto").equals("OUTRO")){
                    produto.setTipo(TipoProd.OUTRO);
                }
                produtos.add(produto);
                qtdProdutos ++;
            }
            if (!produtos.isEmpty()) {
                log.registrarLog(2, "ProdutoDAO", "consultarProdutos", "doacao, usuario, tipousuario, usuariotipo", "Produtos listados - foram encontrados "+ qtdProdutos +" registros");    
            } else {
                log.registrarLog(3, "ProdutoDAO", "consultarProdutos", "doacao, usuario, tipousuario, usuariotipo", "Não foram encontrados registros");
            }
            return produtos;

        } catch (SQLException e) {
            e.printStackTrace();
            log.registrarLog(4, "ProdutoDAO", "consultarProdutos", "doacao, usuario, tipousuario, usuariotipo", "Erro ao consultar os produtos");
            return null;
        }
    }

    public String capturarNomeProduto(int idProduto) {
        String nome = null;
        String sql = "SELECT descricao FROM produto WHERE id = ?";
        try (PreparedStatement stmt = conexaoBanco.prepareStatement(sql)) {
            stmt.setInt(1, idProduto);
            ResultSet rs = stmt.executeQuery();
            if (rs.next()) {
                nome = rs.getString("descricao");
                log.registrarLog(2, "ProdutoDAO", "capturarNomeProduto", "produto", "Nome do produto obtido");
            }
        } catch (SQLException e) {
            e.printStackTrace();
            log.registrarLog(4, "ProdutoDAO", "capturarNomeProduto", "produto", "Nome do produto não obtido");
        }
        return nome;
    }
}