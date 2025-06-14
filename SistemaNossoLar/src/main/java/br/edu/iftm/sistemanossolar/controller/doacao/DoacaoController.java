package br.edu.iftm.sistemanossolar.controller.doacao;

import java.sql.Connection;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import br.edu.iftm.sistemanossolar.dao.doacao.DoacaoDAO;
import br.edu.iftm.sistemanossolar.model.doacao.Doacao;
import br.edu.iftm.sistemanossolar.model.relatorio.RelDoacao;
import br.edu.iftm.sistemanossolar.model.relatorio.RetornoDoacoes;
import br.edu.iftm.sistemanossolar.view.RegistrosLog;

public class DoacaoController {
    private DoacaoDAO doacaoDAO;

    RegistrosLog log = new RegistrosLog();
    
    public DoacaoController (Connection conexao) {
        this.doacaoDAO = new DoacaoDAO (conexao);
    }

    public boolean cadastrarDoacao(Doacao doacao) throws SQLException {
        log.registrarLog(1, "DoacaoController", "cadastrarDoacao", "doacao", "Cadastrando Doação");
        return doacaoDAO.cadastrarDoacao(doacao);
    }

    public RetornoDoacoes filtrarRelatorio(LocalDate dataInicio, LocalDate dataFim, String tipoDoacao, String tipoProduto, Integer idDoador, Integer idProduto, String ordem, String sentido) throws SQLException {
        log.registrarLog(1, "DoacaoController", "filtrarRegistrosRelatorio", "doacao, usuario, tipousuario, usuariotipo, produto, produtocoacao", "Filtrando dados do relatório");
        StringBuilder sqlFiltro = new StringBuilder();
        List<Object> filtros = new ArrayList<>();

        if (dataInicio != null && dataFim == null) {
            sqlFiltro.append("AND d.data >= ? ");
            filtros.add(dataInicio);
        }

        if (dataFim != null && dataInicio == null) {
            sqlFiltro.append("AND d.data <= ? ");
            filtros.add(dataFim);
        }

        if (dataInicio != null && dataFim != null) {
            sqlFiltro.append("AND d.data BETWEEN ? AND ? ");
            filtros.add(dataInicio);
            filtros.add(dataFim);
        }

        if (!tipoDoacao.isEmpty() && !tipoDoacao.equals("Todos")) {
            sqlFiltro.append("AND d.tipoDoacao = ? ");
            filtros.add(tipoDoacao);
        }

        if (!tipoProduto.isEmpty() && !tipoProduto.equals("Todos")) {
            sqlFiltro.append("AND p.tipoProduto = ? ");
            filtros.add(tipoProduto);
        }

        if (idDoador != null) {
            sqlFiltro.append("AND u.id = ? ");
            filtros.add(idDoador);
        }

        if (idProduto != null) {
            sqlFiltro.append("AND pd.produto = ? ");
            filtros.add(idProduto);
        }

        StringBuilder sqlFinal = new StringBuilder();
        sqlFinal.append(sqlFiltro);
        
        sqlFinal.append("GROUP BY d.id ");
        if (ordem != null && !ordem.isEmpty()) {
            sqlFinal.append("ORDER BY ");
            switch (ordem) {
                case "data": sqlFinal.append("d.data "); break;
                case "codigo": sqlFinal.append("d.id "); break;
                case "nome": sqlFinal.append("u.nome "); break;
                case "valor": sqlFinal.append("d.valor "); break;
                case "quantidade": sqlFinal.append("pd.quantidade "); break;
            }
            sqlFinal.append(sentido.equals("asc") ? "ASC" : "DESC");
        }

        List<RelDoacao> doacoes = new ArrayList<>();
        doacoes = doacaoDAO.filtrarRegistrosRelatorio(sqlFinal.toString(), filtros);

        RelDoacao totalizacao = new RelDoacao();
        totalizacao = filtrarTotalRelatorio(new RelDoacao(), sqlFiltro.toString(), filtros);

        return new RetornoDoacoes(doacoes, totalizacao);
    }

    public RelDoacao filtrarTotalRelatorio(RelDoacao totalizacao, String filtro, List<Object> filtros) throws SQLException {
        log.registrarLog(1, "DoacaoController", "filtrarTotalRelatorio", "doacao, usuario, tipousuario, usuariotipo, produto, produtocoacao", "Totalizando o relatório");
        return doacaoDAO.filtrarTotalRelatorio(totalizacao, filtro, filtros);
    }

    public List<Doacao> buscarDoacoes(String nomeDoador, String tipoDoacao, LocalDate dataInicio, LocalDate dataFim) throws SQLException {
        log.registrarLog(1, "DoacaoController", "buscarDoacao", "doacao, usuario, tipousuario, usuariotipo", "Listando doações para seleção");
        StringBuilder sqlFiltro = new StringBuilder();
        List<Object> filtros = new ArrayList<>();

        if (!nomeDoador.isEmpty() || !nomeDoador.equals("")) {
            sqlFiltro.append("AND u.nome LIKE ? ");
            filtros.add("%"+ nomeDoador +"%");
        }

        if (!tipoDoacao.isEmpty() && !tipoDoacao.equals("Todos")) {
            sqlFiltro.append("AND d.tipoDoacao = ? ");
            filtros.add(tipoDoacao);
        }

        if (dataInicio != null && dataFim == null) {
            sqlFiltro.append("AND d.data >= ? ");
            filtros.add(dataInicio);
        }

        if (dataFim != null && dataInicio == null) {
            sqlFiltro.append("AND d.data <= ? ");
            filtros.add(dataFim);
        }

        if (dataInicio != null && dataFim != null) {
            sqlFiltro.append("AND d.data BETWEEN ? AND ? ");
            filtros.add(dataInicio);
            filtros.add(dataFim);
        }

        return doacaoDAO.consultarDoacoes(sqlFiltro.toString(), filtros);
    }

}