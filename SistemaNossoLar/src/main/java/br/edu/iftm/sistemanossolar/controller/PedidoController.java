package br.edu.iftm.sistemanossolar.controller;

import java.sql.Connection;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import br.edu.iftm.sistemanossolar.dao.PedidoDAO;
import br.edu.iftm.sistemanossolar.model.pedido.Pedido;
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

    public List<Pedido> buscarPedidos(String nomePessoa, String tipoUsuario, LocalDate dataInicio, LocalDate dataFim) throws SQLException {
        log.registrarLog(1, "PedidoController", "buscarPedidos", "varias", "Listando pedidos para seleção");
        StringBuilder sqlFiltro = new StringBuilder();
        List<Object> filtros = new ArrayList<>();

        if (!nomePessoa.isEmpty() || !nomePessoa.equals("")) {
            sqlFiltro.append("AND u.nome LIKE ? ");
            filtros.add("'%"+ nomePessoa +"%'");
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

        return pedidoDAO.consultarPedidos(sqlFiltro.toString(), filtros);
    }
}
