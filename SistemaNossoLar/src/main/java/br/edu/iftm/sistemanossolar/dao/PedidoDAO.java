package br.edu.iftm.sistemanossolar.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;

import br.edu.iftm.sistemanossolar.model.pedido.Pedido;

public class PedidoDAO {
    private final Connection conexaoBanco;

    public PedidoDAO(Connection conexao) {
        this.conexaoBanco = conexao;
    }

    public boolean cadastrarPedido(Pedido pedido) {
        System.out.println("[ALR] PedidoDAO | cadastrarPedido - Cadastrando pedido");
        String sql = "INSERT INTO pedido (pessoa, quantidade, status, observacao, dataPedido, dataEntrega) VALUES (?, ?, ?, ?, ?, ?)";
        
        try (PreparedStatement stmt = conexaoBanco.prepareStatement(sql)) {
            stmt.setInt(1, pedido.getCliente().getId());
            stmt.setInt(2, pedido.getQuantMarmita());
            stmt.setString(3, pedido.getStatus().name());
            stmt.setString(4, pedido.getObservacao());
            stmt.setDate(5, java.sql.Date.valueOf(pedido.getDataPedido()));
            stmt.setDate(6, java.sql.Date.valueOf(pedido.getDataEntrega()));
            stmt.executeUpdate();
            System.out.println("[ALR] PedidoDAO | cadastrarPedido - Pedido cadastrado");
            return true;

        } catch (Exception e) {
            System.out.println("[ERR] PedidoDAO | cadastrarPedido - Pedido não cadastrado");
            e.printStackTrace();
            return false;
        }
    }

}