package br.edu.iftm.sistemanossolar.controller;

import br.edu.iftm.sistemanossolar.dao.PedidoDAO;
import br.edu.iftm.sistemanossolar.model.pedido.Pedido;

public class PedidoController {
    private PedidoDAO pedidoDAO = new PedidoDAO();

    public boolean cadastrarPedido(Pedido pedido) {
        return pedidoDAO.cadastrarPedido(pedido);
    }
}
