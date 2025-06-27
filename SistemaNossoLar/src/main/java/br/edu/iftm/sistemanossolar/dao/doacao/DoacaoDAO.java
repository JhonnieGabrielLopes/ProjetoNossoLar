package br.edu.iftm.sistemanossolar.dao.doacao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import br.edu.iftm.sistemanossolar.model.doacao.Doacao;
import br.edu.iftm.sistemanossolar.model.doacao.Produto;
import br.edu.iftm.sistemanossolar.model.pessoa.Pessoa;
import br.edu.iftm.sistemanossolar.model.doacao.Doacao.TipoDoa;
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
            stmt.setObject(4, doacao.getDataDoacao());
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
                    e.printStackTrace();
                    log.registrarLog(4, "DoacaoDAO", "cadastrarDoacao", "doacao", "Erro ao obter o ID da Doação");
                }
                
                if (idDoa != null) {
                    List<Produto> temp = doacao.getProduto();
                    Iterator<Produto> iter = temp.iterator();
                    while (iter.hasNext()) {
                        Produto prodTemp = iter.next();
                        log.registrarLog(1, "DoacaoDAO", "cadastrarDoacao", "produtodoacao", "Cadastrando a relação de Produto/Doação");

                        sql = "INSERT INTO produtodoacao (doacao, produto, quantidade) VALUES (?, ?, ?)";
                        try (PreparedStatement stmtUserTipo = conexaoBanco.prepareStatement(sql)) {
                            stmtUserTipo.setInt(1, idDoa);
                            stmtUserTipo.setInt(2, prodTemp.getId());
                            stmtUserTipo.setInt(3, prodTemp.getQuantidade());
                            stmtUserTipo.executeUpdate();
                            log.registrarLog(2, "DoacaoDAO", "cadastrarDoacao", "produtodoacao", "Relação de Produto/Doação cadastrada");
                        } catch (SQLException e) {
                            e.printStackTrace();
                            log.registrarLog(4, "DoacaoDAO", "cadastrarDoacao", "produtodoacao", "Erro ao cadastrar relação de Produto/Doação");
                        }
                    }
                }
            }
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            log.registrarLog(4, "DoacaoDAO", "cadastrarDoacao", "doacao", "Doação não cadastrada");
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

        System.out.println(sql.toString());
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
                if (doacao.getObservacao() == null) {
                    doacao.setObservacao("");
                }
                LocalDate data = rs.getObject("data_doacao", LocalDate.class);
                doacao.setData(data);
                doacoes.add(doacao);
            }
            log.registrarLog(2, "DoacaoDAO", "filtrarRegistrosRelatorio", "doacao, usuario, tipousuario, usuariotipo, produto, produtocoacao", "Filtragem dos dados finalizada");
            return doacoes;

        } catch (SQLException e) {
            e.printStackTrace();
            log.registrarLog(4, "DoacaoDAO", "filtrarRegistrosRelatorio", "doacao, usuario, tipousuario, usuariotipo, produto, produtocoacao", "Erro ao filtrar os dados do relatório");
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
                Double totalProd = rs.getDouble("total_produtos");
                totalizacao.setTotalProdutos(totalProd.intValue());
                Double totalItens = rs.getDouble("total_itens");
                totalizacao.setTotalItens(totalItens.intValue());
            }
            log.registrarLog(2, "DoacaoDAO", "filtrarTotalRelatorio", "doacao, usuario, tipousuario, usuariotipo, produto, produtocoacao", "Totalização finalizada");
            return totalizacao;

        } catch (SQLException e) {
            e.printStackTrace();
            log.registrarLog(4, "DoacaoDAO", "filtrarTotalRelatorio", "doacao, usuario, usuariotipo, tipousuario, produto, produtodoacao", "Erro ao totalizar o relatório");
            return null;
        }
    }

    public List<Doacao> listarDoacoes(String sqlFiltro, List<Object> filtros) throws SQLException {
        StringBuilder sql = new StringBuilder();
        sql.append("SELECT d.id AS codigo_doacao, d.tipoDoacao AS tipo_doacao, d.pessoa AS codigo_doador, u.nome AS nome_doador, d.data AS data_doacao, d.valor, d.observacao ");
        sql.append("FROM doacao d ");
        sql.append("JOIN usuario u ON d.pessoa = u.id ");
        sql.append("JOIN usuarioTipo ut ON u.id = ut.usuario ");
        sql.append("JOIN tipoUsuario tu ON ut.tipoUsuario = tu.id AND tu.tipo = 'DOADOR' ");
        sql.append("WHERE 1=1 ");
        sql.append(sqlFiltro);
        sql.append("ORDER BY d.data DESC");

        try (PreparedStatement stmt = conexaoBanco.prepareStatement(sql.toString())) {
            for (int i = 0; i < filtros.size(); i++) {
                stmt.setObject(i + 1, filtros.get(i));
            }

            ResultSet rs = stmt.executeQuery();
            List<Doacao> doacoes = new ArrayList<>();
            int qtdDoacoes = 0;

            while (rs.next()) {
                Doacao doacao = new Doacao();
                Pessoa doador = new Pessoa();
                doacao.setId(rs.getInt("codigo_doacao"));
                if (rs.getString("tipo_doacao").equals("DINHEIRO")) {
                    doacao.setTipo(TipoDoa.DINHEIRO);
                } else {
                    doacao.setTipo(TipoDoa.PRODUTO);
                }
                doador.setNome(rs.getString("nome_doador"));
                doador.setId(rs.getInt("codigo_doador"));
                doacao.setDoador(doador);
                LocalDate data = rs.getObject("data_doacao", LocalDate.class);
                doacao.setDataDoacao(data);
                doacao.setValor(rs.getDouble("valor"));
                doacao.setObservacao(rs.getString("observacao"));
                doacoes.add(doacao);
                qtdDoacoes ++;
            }
            if (!doacoes.isEmpty()) {
                log.registrarLog(2, "DoacaoDAO", "filtrarRegistrosRelatorio", "doacao, usuario, tipousuario, usuariotipo", "Doações listados - foram encontrados "+ qtdDoacoes +" registros");    
            } else {
                log.registrarLog(3, "DoacaoDAO", "filtrarRegistrosRelatorio", "doacao, usuario, tipousuario, usuariotipo", "Não foram encontrados registros");
            }
            return doacoes;

        } catch (SQLException e) {
            e.printStackTrace();
            log.registrarLog(4, "DoacaoDAO", "filtrarRegistrosRelatorio", "doacao, usuario, tipousuario, usuariotipo", "Erro ao consultar as doações");
            return null;
        }
    }
    public List<Produto> listagemDeProduto(Doacao doacao){
        String sql = "select p.tipoProduto, p.descricao, pd.quantidade from produto p join produtodoacao pd on p.id = pd.produto where pd.doacao = (?)";
        try(PreparedStatement stmt = conexaoBanco.prepareStatement(sql)){
            stmt.setInt(1, doacao.getId());
            ResultSet rs = stmt.executeQuery();
            List<Produto> produtos = new ArrayList<>();
            while(rs.next()){
                Produto produto = new Produto();
                switch(rs.getString("tipoProduto")){
                    case "OUTRO": produto.setTipo(Produto.TipoProd.OUTRO);break;
                    case "ALIMENTO": produto.setTipo(Produto.TipoProd.ALIMENTO);break;
                    case "LIMPEZA": produto.setTipo(Produto.TipoProd.LIMPEZA);break;
                }
                produto.setNome(rs.getString("descricao"));
                produto.setQuantidade(rs.getInt("quantidade"));
                produtos.add(produto);
            }
            return produtos;
        }catch(SQLException e){
            
        }
        return null;
    }
    public boolean removeDocao(int id){
        removeDependenciaDoacao(id);
        String sql = "DELETE FROM doacao WHERE id = (?)";
        try(PreparedStatement stmt = conexaoBanco.prepareStatement(sql)){
            stmt.setInt(1, id);
            stmt.executeUpdate();
            return true;
        }catch(SQLException e){
            return false;
        }
    }
    public boolean removeDependenciaDoacao(int id){
        String sql = "DELETE FROM produtodoacao WHERE doacao = (?)";
        try(PreparedStatement stmt = conexaoBanco.prepareStatement(sql)){
            stmt.setInt(1, id);
            stmt.executeUpdate();
            return true;
        }catch(SQLException e){
            return false;
        }
    }
}