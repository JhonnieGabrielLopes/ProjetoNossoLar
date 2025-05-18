package br.edu.iftm.sistemanossolar.controller;

import java.sql.Connection;

import br.edu.iftm.sistemanossolar.dao.PedidoDAO;
import br.edu.iftm.sistemanossolar.model.pedido.Pedido;

public class PedidoController {
    private PedidoDAO pedidoDAO;

    public PedidoController(Connection conexao) {
        this.pedidoDAO = new PedidoDAO(conexao);
    }

    public boolean cadastrarPedido(Pedido pedido) {
        return pedidoDAO.cadastrarPedido(pedido);
    }
}
