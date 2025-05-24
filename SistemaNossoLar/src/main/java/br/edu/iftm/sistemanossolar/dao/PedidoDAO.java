package br.edu.iftm.sistemanossolar.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;

import br.edu.iftm.sistemanossolar.model.pedido.Pedido;
import br.edu.iftm.sistemanossolar.view.RegistrosLog;

public class PedidoDAO {
    public static final String RESET = "\u001B[0m";
    public static final String VERMELHO = "\u001B[31m";
    public static final String AMARELO = "\u001B[33m";

    private final Connection conexaoBanco;

    RegistrosLog log = new RegistrosLog();

    public PedidoDAO(Connection conexao) {
        this.conexaoBanco = conexao;
    }

    public boolean cadastrarPedido(Pedido pedido) {
        log.registrarLog(1, "PedidoDAO", "cadastrarPedido", "pedido", "Cadastrando o Pedido do Usuário "+ pedido.getCliente().getNome());

        String sql = "INSERT INTO pedido (pessoa, quantidade, status, observacao, dataPedido, dataEntrega) VALUES (?, ?, ?, ?, ?, ?)";
        try (PreparedStatement stmt = conexaoBanco.prepareStatement(sql)) {
            stmt.setInt(1, pedido.getCliente().getId());
            stmt.setInt(2, pedido.getQuantMarmita());
            stmt.setString(3, pedido.getStatus().name());
            stmt.setString(4, pedido.getObservacao());
            stmt.setDate(5, java.sql.Date.valueOf(pedido.getDataPedido()));
            stmt.setDate(6, java.sql.Date.valueOf(pedido.getDataEntrega()));
            stmt.executeUpdate();

            log.registrarLog(2, "PedidoDAO", "cadastrarPedido", "pedido", "Pedido cadastrado");
            return true;

        } catch (Exception e) {
            log.registrarLog(4, "PedidoDAO", "cadastrarPedido", "pedido", "Pedido não cadastrado");
            e.printStackTrace();
            return false;
        }
    }

}