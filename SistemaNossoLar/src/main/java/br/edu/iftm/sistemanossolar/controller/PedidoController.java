package br.edu.iftm.sistemanossolar.controller;

import java.sql.Connection;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import br.edu.iftm.sistemanossolar.dao.PedidoDAO;
import br.edu.iftm.sistemanossolar.model.pedido.Pedido;
import br.edu.iftm.sistemanossolar.model.pessoa.Pessoa;
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
        log.registrarLog(1, "PedidoController", "cadastrarPedido", "pedido", "Cadastrando o Pedido do Usuário " + pedido.getCliente().getNome());
        return pedidoDAO.cadastrarPedido(pedido);
    }

    public List<Pedido> listarPedidos(String nomePessoa, String status, LocalDate dataInicio, LocalDate dataFim) throws SQLException {
        log.registrarLog(1, "PedidoController", "buscarPedidos", "pedido, usuario, tipousuario, usuariotipo", "Listando pedidos para seleção");
        StringBuilder sqlFiltro = new StringBuilder();
        List<Object> filtros = new ArrayList<>();

        if (nomePessoa != null && !nomePessoa.trim().isEmpty()) {
            sqlFiltro.append("AND u.nome LIKE ? ");
            filtros.add("%" + nomePessoa + "%");
        }

        if (!status.isEmpty() && !status.equals("Todos")) {
            sqlFiltro.append("AND p.status = ? ");
            filtros.add(status);
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

    public RetornoPedidos filtrarRelatorio(LocalDate dataPedidoInicio, LocalDate dataPedidoFim, LocalDate dataEntregaInicio, LocalDate dataEntregaFim, String status, Integer idCliente, String local, String cidade, String ordem, String sentido) throws SQLException {
        log.registrarLog(1, "PedidoController", "filtrarRelatorio", "pedido, usuario", "Filtrando dados do relatório"); 
        StringBuilder sqlFiltro = new StringBuilder();
        List<Object> filtros = new ArrayList<>();
        String localSemEspaco = local.replaceAll("\\s+", "");

        if (dataPedidoInicio != null && dataPedidoFim != null) {
            sqlFiltro.append("AND p.dataPedido BETWEEN ? AND ? ");
            filtros.add(dataPedidoInicio);
            filtros.add(dataPedidoFim);
        } else {
            if (dataPedidoInicio != null) {
                sqlFiltro.append("AND p.dataPedido >= ? ");
                filtros.add(dataPedidoInicio);
            }
        
            if (dataPedidoFim != null) {
                sqlFiltro.append("AND p.dataPedido <= ? ");
                filtros.add(dataPedidoFim);
            }
        }

        if (dataEntregaInicio != null && dataEntregaFim != null) {
            sqlFiltro.append("AND p.dataEntrega BETWEEN ? AND ? ");
            filtros.add(dataEntregaInicio);
            filtros.add(dataEntregaFim);
        } else {
            if (dataEntregaInicio != null) {
                sqlFiltro.append("AND p.dataEntrega >= ? ");
                filtros.add(dataEntregaInicio);
            }
        
            if (dataEntregaFim != null) {
                sqlFiltro.append("AND p.dataEntrega <= ? ");
                filtros.add(dataEntregaFim);
            }
        }

        if (status != null && !status.equals("Todos")) {
            sqlFiltro.append("AND p.status = ? ");
            filtros.add(status);
        }

        if (localSemEspaco != null && !localSemEspaco.isEmpty() && !localSemEspaco.equals("Todos")) {
            try {
                Pessoa.Local localEnum = Pessoa.Local.fromString(localSemEspaco);
                sqlFiltro.append("AND u.local = ? ");
                filtros.add(localEnum.name()); 
            } catch (IllegalArgumentException e) {
                log.registrarLog(3, "PedidoController", "filtrarRelatorio", "pedido, usuario", "Local inválido: " + localSemEspaco);
                throw new SQLException("Local inválido: " + localSemEspaco);
            }
        }

        if (idCliente != null) {
            sqlFiltro.append("AND p.pessoa = ? ");
            filtros.add(idCliente);
        }

        if (cidade != null && !cidade.isEmpty() && !cidade.equals("Todas")) {
            sqlFiltro.append("AND c.nome LIKE ? ");
            filtros.add("%" + cidade + "%");
        }

        List<Object> filtrosRelatorio = new ArrayList<>();
        filtrosRelatorio.add(dataPedidoInicio);
        filtrosRelatorio.add(dataPedidoFim);
        filtrosRelatorio.add(dataEntregaInicio);
        filtrosRelatorio.add(dataEntregaFim);
        filtrosRelatorio.add(status);
        filtrosRelatorio.add(idCliente);
        filtrosRelatorio.add(local);
        filtrosRelatorio.add(cidade);
        filtrosRelatorio.add(ordem);
        filtrosRelatorio.add(sentido);

        StringBuilder sqlFinal = new StringBuilder();
        sqlFinal.append(sqlFiltro);

        if (ordem != null && !ordem.isEmpty()) {
            sqlFinal.append("ORDER BY ");
            switch (ordem) {
                case "Código":
                    sqlFinal.append("p.id ");
                    break;
                case "Status":
                    sqlFinal.append("p.status ");
                    break;
                case "Marmitas":
                    sqlFinal.append("p.quantidade ");
                    break;
                case "Data do Pedido":
                    sqlFinal.append("p.dataPedido ");
                    break;
                case "Data da Entrega":
                    sqlFinal.append("p.dataEntrega ");
                    break;
                case "Cliente":
                    sqlFinal.append("u.nome ");
                    break;
            }
            sqlFinal.append(sentido.equals("Crescente") ? "ASC" : "DESC");
        }

        List<RelPedido> pedidos;
        pedidos = pedidoDAO.filtrarRegistrosRelatorio(sqlFinal.toString(), filtros);

        RelPedido totalizacao;
        totalizacao = filtrarTotalRelatorio(new RelPedido(), sqlFiltro.toString(), filtros);

        return new RetornoPedidos(pedidos, totalizacao, filtrosRelatorio);
    }

    public RelPedido filtrarTotalRelatorio(RelPedido totalizacao, String filtro, List<Object> filtros) throws SQLException {
        log.registrarLog(1, "PedidoController", "filtrarTotalRelatorio", "pedido, usuario", "Totalizando o relatório");
        return pedidoDAO.filtrarTotalRelatorio(totalizacao, filtro, filtros);
    }

    public Pedido buscarPedidoPorId(int id) throws SQLException {
        log.registrarLog(1, "PedidoController", "buscarPedidoPorId", "pedido, usuario, usuarioTipo, tipoUsuario", "Buscando pedido por id");
        return pedidoDAO.buscarPedidoPorId(id);
    }
    
    public boolean alterarPedido(Pedido pedido) throws SQLException {
        log.registrarLog(1, "PedidoController", "alterarPessoa", "pedido", "Alterando pedido");
        return pedidoDAO.alterarPedido(pedido);
    }
}
