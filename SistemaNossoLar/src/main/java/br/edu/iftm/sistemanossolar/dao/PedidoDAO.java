package br.edu.iftm.sistemanossolar.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;

import br.edu.iftm.sistemanossolar.model.pedido.Pedido;

public class PedidoDAO {

    public boolean cadastrarPedido(Pedido pedido) {
        String sqlCadastrarPedido = "INSERT INTO pedido (pessoa, quantidade, status, observacao, dataPedido, dataEntrega) VALUES (?, ?, ?, ?, ?, ?)";
        try (Connection conn = ConexaoBanco.getConnection()){
            PreparedStatement stmt = conn.prepareStatement(sqlCadastrarPedido);
            stmt.setInt(1, pedido.getCliente().getId());
            stmt.setInt(2, pedido.getQuantMarmita());
            stmt.setString(3, pedido.getStatus().name());
            stmt.setString(4, pedido.getObservacao());
            stmt.setDate(5, java.sql.Date.valueOf(pedido.getDataPedido()));
            stmt.setDate(6, java.sql.Date.valueOf(pedido.getDataEntrega()));
            stmt.executeUpdate();
            return true;
        }catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }
}
