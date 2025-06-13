package br.edu.iftm.sistemanossolar.dao.doacao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import br.edu.iftm.sistemanossolar.model.doacao.Doacao;
import br.edu.iftm.sistemanossolar.model.doacao.Produto;
import br.edu.iftm.sistemanossolar.model.relatorio.RelDoacao;
import br.edu.iftm.sistemanossolar.view.RegistrosLog;

public class DoacaoDAO {
    private final Connection conexaoBanco;

    RegistrosLog log = new RegistrosLog();

    public DoacaoDAO(Connection conexao) {
        this.conexaoBanco = conexao;
    }

    public boolean cadastrarDoacao(Doacao doacao) throws SQLException {
        String sql = "INSERT INTO doacao (tipoDoacao, pessoa, valor, data) VALUES (?, ?, ?, ?)";
        try (PreparedStatement stmt = conexaoBanco.prepareStatement(sql, PreparedStatement.RETURN_GENERATED_KEYS)) {
            stmt.setString(1, doacao.getTipo().toString());
            stmt.setInt(2, doacao.getDoador().getId());
            stmt.setDouble(3, doacao.getValor());
            java.sql.Date data = java.sql.Date.valueOf(doacao.getDataDoacao());
            stmt.setDate(4, data);
            stmt.executeUpdate();
            log.registrarLog(2, "DoacaoDAO", "cadastrarDoacao", "doacao", "Doação cadastrada");

            if (doacao.getProduto() != null) {
                log.registrarLog(1, "DoacaoDAO", "cadastrarDoacao", "doacao", "Obtendo o ID da Doação");
                Integer idDoa = null;

                try (ResultSet rs = stmt.getGeneratedKeys()) {
                    if (rs.next()) {
                        log.registrarLog(2, "DoacaoDAO", "cadastrarDoacao", "doacao", "ID da Doação obtido");
                        idDoa = rs.getInt(1);
                        doacao.setId(idDoa);
                    } else {
                        log.registrarLog(3, "DoacaoDAO", "cadastrarDoacao", "doacao", "ID da Doação não obtido");
                    }
                } catch (SQLException e) {
                    log.registrarLog(4, "DoacaoDAO", "cadastrarDoacao", "doacao", "Erro ao obter o ID da Doação");
                    e.printStackTrace();
                }
                
                if (idDoa != null) {
                    List<Produto> temp = doacao.getProduto();
                    Iterator<Produto> iter = temp.iterator();
                    while (iter.hasNext()) {
                        Produto prodTemp = iter.next();
                        log.registrarLog(1, "DoacaoDAO", "cadastrarDoacao", "produtodoacao", "Cadastrando a relação do Produto/Doação");

                        sql = "INSERT INTO produtodoacao (doacao, produto, quantidade) VALUES (?, ?, ?)";
                        try (PreparedStatement stmtUserTipo = conexaoBanco.prepareStatement(sql)) {
                            stmtUserTipo.setInt(1, idDoa);
                            stmtUserTipo.setInt(2, prodTemp.getId());
                            stmtUserTipo.setInt(3, prodTemp.getQuantidade());
                            stmtUserTipo.executeUpdate();
                            log.registrarLog(2, "DoacaoDAO", "cadastrarDoacao", "produtodoacao", "Relação do Produto/Doação cadastrada");
                        } catch (SQLException e) {
                            log.registrarLog(4, "DoacaoDAO", "cadastrarDoacao", "produtodoacao", "Erro ao cadastrar relação do Produto/Doação");
                            e.printStackTrace();
                        }
                    }
                }
            }
            return true;
        } catch (Exception e) {
            log.registrarLog(4, "DoacaoDAO", "cadastrarDoacao", "doacao", "Doação não cadastrada");
            e.printStackTrace();
            return false;
        }
    }

    public List<RelDoacao> filtrarRegistrosRelatorio(String filtro, List<Object> filtros) throws SQLException {
        StringBuilder sql = new StringBuilder();
        sql.append("SELECT d.id AS codigo_doacao, u.id AS id_doador, u.nome AS nome_doador, d.tipoDoacao, d.valor, ");
        sql.append("GROUP_CONCAT(CASE WHEN p.id IS NOT NULL THEN CONCAT(p.descricao, ' (', pd.quantidade, ' un)') ELSE NULL END SEPARATOR ', ') AS produtos, ");
        sql.append("d.observacao, d.data AS data_doacao ");
        sql.append("FROM doacao d ");
        sql.append("JOIN usuario u ON d.pessoa = u.id ");
        sql.append("JOIN usuarioTipo ut ON u.id = ut.usuario ");
        sql.append("JOIN tipoUsuario tu ON ut.tipoUsuario = tu.id AND tu.tipo = 'DOADOR' ");
        sql.append("LEFT JOIN produtoDoacao pd ON d.id = pd.doacao AND d.tipoDoacao = 'PRODUTO' ");
        sql.append("LEFT JOIN produto p ON pd.produto = p.id ");
        sql.append("WHERE 1=1 ");
        sql.append(filtro);

        try (PreparedStatement stmt = conexaoBanco.prepareStatement(sql.toString())) {
            for (int i = 0; i < filtros.size(); i++) {
                stmt.setObject(i + 1, filtros.get(i));
            }

            ResultSet rs = stmt.executeQuery();
            List<RelDoacao> doacoes = new ArrayList<>();

            while (rs.next()) {
                RelDoacao doacao = new RelDoacao();
                doacao.setIdDoacao(rs.getInt("codigo_doacao"));
                doacao.setIdDoador(rs.getInt("id_doador"));
                doacao.setNomeDoador(rs.getString("nome_doador"));
                doacao.setTipo(rs.getString("tipoDoacao"));
                doacao.setValor(rs.getDouble("valor"));
                doacao.setProdutos(rs.getString("produtos"));
                doacao.setObservacao(rs.getString("observacao"));
                doacao.setData(rs.getDate("data_doacao"));
                doacoes.add(doacao);
            }
            log.registrarLog(2, "DoacaoDAO", "filtrarRegistrosRelatorio", "varias", "Filtragem dos dados finalizada");
            return doacoes;

        } catch (SQLException e) {
            e.printStackTrace();
            log.registrarLog(4, "DoacaoDAO", "filtrarRegistrosRelatorio", "varias", "Erro ao filtrar os dados do relatório");
            return null;
        }
    }

    public RelDoacao filtrarTotalRelatorio(RelDoacao totalizacao, String filtro, List<Object> filtros) throws SQLException {
        StringBuilder sql = new StringBuilder();
        sql.append("SELECT ");
        sql.append("COALESCE(SUM(d.valor), 0) AS total_valor, ");
        sql.append("COALESCE(COUNT(DISTINCT p.id), 0) AS total_produtos, ");
        sql.append("COALESCE(SUM(pd.quantidade), 0) AS total_itens ");
        sql.append("FROM doacao d ");
        sql.append("JOIN usuario u ON d.pessoa = u.id ");
        sql.append("JOIN usuarioTipo ut ON u.id = ut.usuario ");
        sql.append("JOIN tipoUsuario tu ON ut.tipoUsuario = tu.id AND tu.tipo = 'DOADOR' ");
        sql.append("LEFT JOIN produtoDoacao pd ON d.id = pd.doacao AND d.tipoDoacao = 'PRODUTO' ");
        sql.append("LEFT JOIN produto p ON pd.produto = p.id ");
        sql.append("WHERE 1=1 ");
        sql.append(filtro);

        try (PreparedStatement stmt = conexaoBanco.prepareStatement(sql.toString())) {
            for (int i = 0; i < filtros.size(); i++) {
                stmt.setObject(i + 1, filtros.get(i));
            }

            ResultSet rs = stmt.executeQuery();
            while (rs.next()) {
                totalizacao.setTotalValor(rs.getDouble("total_valor"));
                totalizacao.setTotalProdutos(rs.getDouble("total_produtos"));
                totalizacao.setTotalItens(rs.getDouble("total_itens"));
            }
            log.registrarLog(2, "DoacaoDAO", "filtrarTotalRelatorio", "varias", "Totalização finalizada");
            return totalizacao;

        } catch (SQLException e) {
            e.printStackTrace();
            log.registrarLog(4, "DoacaoDAO", "filtrarTotalRelatorio", "varias", "Erro ao totalizar o relatório");
            return null;
        }
    }
}