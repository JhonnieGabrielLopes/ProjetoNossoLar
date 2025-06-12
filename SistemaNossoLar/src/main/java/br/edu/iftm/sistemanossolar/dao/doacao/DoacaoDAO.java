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
        log.registrarLog(1, "DoacaoDAO", "cadastrarDoacao", "doacao", "Cadastrando Doação");

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

    public List<RelDoacao> filtrarRelatorio(Date dataInicio, Date dataFim, String tipoDoacao, Integer doadorId, String ordenacao) {
        StringBuilder sql = new StringBuilder();
        List<Object> params = new ArrayList<>();
        
        sql.append("SELECT d.id AS codigo_doacao, d.data AS data_doacao, d.tipoDoacao, ");
        sql.append("d.valor, u.id AS id_doador, u.nome AS nome_doador, ");
        sql.append("GROUP_CONCAT(CASE WHEN p.id IS NOT NULL THEN CONCAT(p.descricao, ' (', pd.quantidade, ')') ELSE NULL END SEPARATOR ', ') AS produtos ");
        sql.append("FROM doacao d ");
        sql.append("JOIN usuario u ON d.pessoa = u.id ");
        sql.append("JOIN usuarioTipo ut ON u.id = ut.usuario ");
        sql.append("JOIN tipoUsuario tu ON ut.tipoUsuario = tu.id AND tu.tipo = 'DOADOR' ");
        sql.append("LEFT JOIN produtoDoacao pd ON d.id = pd.doacao AND d.tipoDoacao = 'PRODUTO' ");
        sql.append("LEFT JOIN produto p ON pd.produto = p.id ");
        sql.append("WHERE 1=1 ");
        
        //Filtros básicos
        if (dataInicio != null) {
            sql.append("AND d.data >= ? ");
            params.add(new java.sql.Date(dataInicio.getTime()));
        }

        if (dataFim != null) {
            sql.append("AND d.data <= ? ");
            params.add(new java.sql.Date(dataFim.getTime()));
        }

        if (tipoDoacao != null && !tipoDoacao.isEmpty()) {
            sql.append("AND d.tipoDoacao = ? ");
            params.add(tipoDoacao);
        }

        if (doadorId != null) {
            sql.append("AND u.id = ? ");
            params.add(doadorId);
        }

        //Filtro específico para doação de produto
        if (tipoProduto != null && !tipoProduto.isEmpty()) {
            sql.append("AND (d.tipoDoacao = 'DINHEIRO' OR p.tipoProduto = ?) ");
            params.add(tipoProduto);
        }

        sql.append("GROUP BY d.id, d.data, d.tipoDoacao, d.valor, u.id, u.nome ");

        //Ordenação
        if (ordenacao != null && !ordenacao.isEmpty()) {
            switch (ordenacao) {
                case "data": sql.append("ORDER BY d.data "); break;
                case "codigo": sql.append("ORDER BY d.id "); break;
                case "nome": sql.append("ORDER BY u.nome "); break;
                case "valor": sql.append("ORDER BY d.valor "); break;
                default: sql.append("ORDER BY d.data DESC ");
            }
        } else {
            sql.append("ORDER BY d.data DESC ");
        }

        try (Connection conn = dataSource.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql.toString())) {
            
            for (int i = 0; i < params.size(); i++) {
                stmt.setObject(i + 1, params.get(i));
            }

            ResultSet rs = stmt.executeQuery();
            List<DoacaoRelatorio> resultados = new ArrayList<>();

            while (rs.next()) {
                RelDoacao dr = new RelDoacao();
                dr.setCodigoDoacao(rs.getInt("codigo_doacao"));
                dr.setDataDoacao(rs.getDate("data_doacao"));
                dr.setTipoDoacao(rs.getString("tipoDoacao"));
                dr.setValor(rs.getDouble("valor"));
                dr.setIdDoador(rs.getInt("id_doador"));
                dr.setNomeDoador(rs.getString("nome_doador"));
                dr.setProdutos(rs.getString("produtos"));
                resultados.add(dr);
            }

            return resultados;
        } catch (SQLException e) {
            throw new RuntimeException("Erro ao gerar relatório", e);
        }
    }
}