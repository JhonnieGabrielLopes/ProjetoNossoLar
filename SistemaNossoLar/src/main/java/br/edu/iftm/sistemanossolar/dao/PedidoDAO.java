package br.edu.iftm.sistemanossolar.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import br.edu.iftm.sistemanossolar.model.doacao.Doacao;
import br.edu.iftm.sistemanossolar.model.doacao.Doacao.TipoDoa;
import br.edu.iftm.sistemanossolar.model.pedido.Pedido;
import br.edu.iftm.sistemanossolar.model.pessoa.Pessoa;
import br.edu.iftm.sistemanossolar.model.pessoa.Pessoa.TipoCad;
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

    public List<Pedido> consultarPedidos(String sqlFiltro, List<Object> filtros) throws SQLException {
        StringBuilder sql = new StringBuilder();
        sql.append("SELECT p.id AS codigo_pedido, u.nome AS pessoa, tu.tipo AS tipo_pessoa, p.datapedido AS data_pedido ");
        sql.append("FROM pedido p ");
        sql.append("JOIN usuario u ON p.pessoa = u.id ");
        sql.append("JOIN usuarioTipo ut ON u.id = ut.usuario ");
        sql.append("JOIN tipoUsuario tu ON ut.tipoUsuario = tu.id ");
        sql.append("WHERE 1=1 ");
        sql.append(sqlFiltro);
        sql.append("ORDER BY p.datapedido DESC");

        try (PreparedStatement stmt = conexaoBanco.prepareStatement(sql.toString())) {
            for (int i = 0; i < filtros.size(); i++) {
                stmt.setObject(i + 1, filtros.get(i));
            }

            ResultSet rs = stmt.executeQuery();
            List<Pedido> pedidos = new ArrayList<>();
            int qtdPedidos= 0;

            while (rs.next()) {
                Pedido pedido = new Pedido();
                Pessoa cliente = new Pessoa();
                pedido.setId(rs.getInt("codigo_pedido"));
                cliente.setNome(rs.getString("pessoa"));
                if (rs.getString("tipo_pessoa").equals("ASSISTENTE")) {
                    cliente.setTipoUsuario(TipoCad.ASSISTENTE);
                } else {
                    cliente.setTipoUsuario(TipoCad.BENEFICIARIO);
                }
                pedido.setCliente(cliente);
                LocalDate data = rs.getObject("data_pedido", LocalDate.class);
                pedido.setDataPedido(data);
                pedidos.add(pedido);
                qtdPedidos ++;
            }
            if (!pedidos.isEmpty()) {
                log.registrarLog(2, "PedidoDAO", "consultarPedidos", "varias", "Pedidos listados - foram encontrados "+ qtdPedidos +" registros");    
            } else {
                log.registrarLog(3, "PedidoDAO", "consultarPedidos", "varias", "Não foram encontrados registros");
            }
            return pedidos;

        } catch (SQLException e) {
            e.printStackTrace();
            log.registrarLog(4, "PedidoDAO", "consultarPedidos", "varias", "Erro ao consultar os pedidos");
            return null;
        }
    }
}