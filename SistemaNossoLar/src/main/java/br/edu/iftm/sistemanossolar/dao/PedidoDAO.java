package br.edu.iftm.sistemanossolar.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import br.edu.iftm.sistemanossolar.model.pedido.Pedido;
import br.edu.iftm.sistemanossolar.view.RegistrosLog;

public class PedidoDAO {
    private final Connection conexaoBanco;

    RegistrosLog log = new RegistrosLog();

    public PedidoDAO(Connection conexao) {
        this.conexaoBanco = conexao;
    }

    public boolean cadastrarPedido(Pedido pedido) {
        String sql = "INSERT INTO pedido (pessoa, quantidade, status, observacao, dataPedido) VALUES (?, ?, ?, ?, ?)";
        try (PreparedStatement stmt = conexaoBanco.prepareStatement(sql, PreparedStatement.RETURN_GENERATED_KEYS)) {
            stmt.setInt(1, pedido.getCliente().getId());
            stmt.setInt(2, pedido.getQuantMarmita());
            stmt.setString(3, pedido.getStatus().name());
            stmt.setString(4, pedido.getObservacao());
            stmt.setDate(5, java.sql.Date.valueOf(pedido.getDataPedido()));
            stmt.executeUpdate();
            log.registrarLog(2, "PedidoDAO", "cadastrarPedido", "pedido", "Pedido cadastrado");
            log.registrarLog(1, "PedidoDAO", "cadastrarPedido", "pedido", "Obtendo o ID do Pedido");
            try (ResultSet rs = stmt.getGeneratedKeys()) {
                if (rs.next()) {
                    log.registrarLog(2, "PedidoDAO", "cadastrarPedido", "pedido", "ID do Pedido obtido");
                    pedido.setId(rs.getInt(1));
                } else {
                    log.registrarLog(3, "PedidoDAO", "cadastrarPedido", "pedido", "ID do Pedido não obtido");
                }
            } catch (SQLException e) {
                e.printStackTrace();
                log.registrarLog(4, "PedidoDAO", "cadastrarPedido", "pedido", "Erro ao obter ID do Pedido");
            }
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            log.registrarLog(4, "PedidoDAO", "cadastrarPedido", "pedido", "Pedido não cadastrado");
            return false;
        }
    }
}