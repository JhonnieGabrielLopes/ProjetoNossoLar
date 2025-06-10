package br.edu.iftm.sistemanossolar.controller;

import java.sql.Connection;

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
}
