package br.edu.iftm.sistemanossolar.controller;

import java.sql.Connection;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import br.edu.iftm.sistemanossolar.dao.PedidoDAO;
import br.edu.iftm.sistemanossolar.model.pedido.Pedido;
import br.edu.iftm.sistemanossolar.model.relatorio.RelPedido;
import br.edu.iftm.sistemanossolar.model.relatorio.RetornoPedidos;
import br.edu.iftm.sistemanossolar.view.RegistrosLog;

public class PedidoController {
    private PedidoDAO pedidoDAO;

    RegistrosLog log = new RegistrosLog();

    public PedidoController(Connection conexao) {
        this.pedidoDAO = new PedidoDAO(conexao);
    }

    public boolean cadastrarPedido(Pedido pedido) {
        log.registrarLog(1, "PedidoController", "cadastrarPedido", "pedido", "Cadastrando o Pedido do Usuário "+ pedido.getCliente().getNome());
        return pedidoDAO.cadastrarPedido(pedido);
    }

    public List<Pedido> listarPedidos(String nomePessoa, String tipoUsuario, LocalDate dataInicio, LocalDate dataFim) throws SQLException {
        log.registrarLog(1, "PedidoController", "buscarPedidos", "pedido, usuario, tipousuario, usuariotipo", "Listando pedidos para seleção");
        StringBuilder sqlFiltro = new StringBuilder();
        List<Object> filtros = new ArrayList<>();

        if (!nomePessoa.isEmpty() || !nomePessoa.equals("")) {
            sqlFiltro.append("AND u.nome LIKE ? ");
            filtros.add("%"+ nomePessoa +"%");
        }

        if (!tipoUsuario.isEmpty() && tipoUsuario.equals("Todos")) {
            sqlFiltro.append("AND tu.tipo = 'ASSISTENTE' OR tu.tipo = 'BENEFICIARIO' ");
        } else if (!tipoUsuario.isEmpty() && !tipoUsuario.equals("Todos")) {
            sqlFiltro.append("AND tu.tipo = ? ");
            filtros.add(tipoUsuario);
        }

        if (dataInicio != null && dataFim == null) {
            sqlFiltro.append("AND p.datapedido >= ? ");
            filtros.add(dataInicio);
        }

        if (dataFim != null && dataInicio == null) {
            sqlFiltro.append("AND p.datapedido <= ? ");
            filtros.add(dataFim);
        }

        if (dataInicio != null && dataFim != null) {
            sqlFiltro.append("AND p.datapedido BETWEEN ? AND ? ");
            filtros.add(dataInicio);
            filtros.add(dataFim);
        }

        return pedidoDAO.listarPedidos(sqlFiltro.toString(), filtros);
    }

    public RetornoPedidos filtrarRelatorio(LocalDate dataPedido, LocalDate dataEntrega, String status, String tipoCliente, Integer idCliente, String local, String cidade, String ordem, String sentido) throws SQLException {
        log.registrarLog(1, "PedidoController", "filtrarRelatorio", "pedido, usuario", "Filtrando dados do relatório");
        StringBuilder sqlFiltro = new StringBuilder();
        List<Object> filtros = new ArrayList<>();

        if (dataPedido != null && dataEntrega == null) {
            sqlFiltro.append("AND p.dataPedido >= ? ");
            filtros.add(dataPedido);
        }

        if (dataEntrega != null && dataPedido == null) {
            sqlFiltro.append("AND p.dataEntrega <= ? ");
            filtros.add(dataEntrega);
        }

        if (dataPedido != null && dataEntrega != null) {
            sqlFiltro.append("AND p.dataPedido = ? AND p.dataEntrega = ? ");
            filtros.add(dataPedido);
            filtros.add(dataEntrega);
        }

        if (status != null) {
            sqlFiltro.append("AND p.status = ? ");
            filtros.add(status);
        }

        if (!tipoCliente.isEmpty() && !tipoCliente.equals("Todos")) {
            sqlFiltro.append("AND tu.tipo = ? ");
            filtros.add(tipoCliente);
        }

        if (idCliente != null) {
            sqlFiltro.append("AND p.pessoa = ? ");
            filtros.add(idCliente);
        }

        if (local != null && !local.isEmpty() && !local.equals("Todos")) {
            sqlFiltro.append("AND u.local LIKE ? ");
            filtros.add("%" + local + "%");
        }

        if (cidade != null && !cidade.isEmpty() && !cidade.equals("Todos")) {
            sqlFiltro.append("AND c.nome LIKE ? ");
            filtros.add("%" + cidade + "%");
        }

        List<Object> filtrosRelatorio = new ArrayList<>();
        filtrosRelatorio.add(dataPedido);
        filtrosRelatorio.add(dataEntrega);
        filtrosRelatorio.add(status);
        filtrosRelatorio.add(tipoCliente);
        filtrosRelatorio.add(idCliente);
        filtrosRelatorio.add(local);
        filtrosRelatorio.add(cidade);
        filtrosRelatorio.add(ordem);
        filtrosRelatorio.add(sentido);

        StringBuilder sqlFinal = new StringBuilder();
        sqlFinal.append(sqlFiltro);
        
        sqlFinal.append("GROUP BY d.id ");
        if (ordem != null && !ordem.isEmpty()) {
            sqlFinal.append("ORDER BY ");
            switch (ordem) {
                case "codigo": sqlFinal.append("p.id "); break;
                case "status": sqlFinal.append("p.status "); break;
                case "quantidade": sqlFinal.append("p.quantidade "); break;
                case "dataPedido": sqlFinal.append("p.dataPedido "); break;
                case "dataEntrega": sqlFinal.append("p.dataEntrega "); break;
                case "nome": sqlFinal.append("u.nome "); break;
            }
            sqlFinal.append(sentido.equals("asc") ? "ASC" : "DESC");
        }

        List<RelPedido> pedidos = new ArrayList<>();
        pedidos = pedidoDAO.filtrarRegistrosRelatorio(sqlFinal.toString(), filtros);

        RelPedido totalizacao = new RelPedido();
        totalizacao = filtrarTotalRelatorio(new RelPedido(), sqlFiltro.toString(), filtros);

        return new RetornoPedidos(pedidos, totalizacao, filtrosRelatorio);
    }

    public RelPedido filtrarTotalRelatorio(RelPedido totalizacao, String filtro, List<Object> filtros) throws SQLException {
        log.registrarLog(1, "PedidoController", "filtrarTotalRelatorio", "pedido, usuario", "Totalizando o relatório");
        return pedidoDAO.filtrarTotalRelatorio(totalizacao, filtro, filtros);
    }
}
