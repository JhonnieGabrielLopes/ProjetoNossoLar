package br.edu.iftm.sistemanossolar.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import br.edu.iftm.sistemanossolar.model.pedido.Pedido;
import br.edu.iftm.sistemanossolar.model.pessoa.Pessoa;
import br.edu.iftm.sistemanossolar.model.pessoa.Pessoa.TipoCad;
import br.edu.iftm.sistemanossolar.model.relatorio.RelPedido;
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

    public List<Pedido> listarPedidos(String sqlFiltro, List<Object> filtros) throws SQLException {
        StringBuilder sql = new StringBuilder();
        sql.append(
                "SELECT p.id AS codigo_pedido, u.nome AS pessoa, tu.tipo AS tipo_pessoa, p.datapedido AS data_pedido ");
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
            int qtdPedidos = 0;

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
                qtdPedidos++;
            }
            if (!pedidos.isEmpty()) {
                log.registrarLog(2, "PedidoDAO", "consultarPedidos", "pedido, usuario, tipousuario, usuariotipo",
                        "Pedidos listados - foram encontrados " + qtdPedidos + " registros");
            } else {
                log.registrarLog(3, "PedidoDAO", "consultarPedidos", "pedido, usuario, tipousuario, usuariotipo",
                        "Não foram encontrados registros");
            }
            return pedidos;

        } catch (SQLException e) {
            e.printStackTrace();
            log.registrarLog(4, "PedidoDAO", "consultarPedidos", "pedido, usuario, tipousuario, usuariotipo",
                    "Erro ao consultar os pedidos");
            return null;
        }
    }

    public List<RelPedido> filtrarRegistrosRelatorio(String filtro, List<Object> filtros) throws SQLException {
        StringBuilder sql = new StringBuilder();
        sql.append(
                "SELECT p.id AS codigo_pedido, p.status, u.id AS codigo_cliente, u.nome AS nome_cliente, p.quantidade AS marmitas, u.local, p.observacao, p.dataPedido, p.dataEntrega, c.nome AS cidade ");
        sql.append("FROM pedido p ");
        sql.append("JOIN usuario u ON p.pessoa = u.id ");
        sql.append("JOIN usuarioTipo ut ON u.id = ut.usuario ");
        sql.append("JOIN tipoUsuario tu ON ut.tipoUsuario = tu.id ");
        sql.append("JOIN endereco e ON u.endereco = e.id ");
        sql.append("JOIN cidade c ON e.cidade = c.id ");
        sql.append("WHERE 1=1 ");
        sql.append(filtro);

        try (PreparedStatement stmt = conexaoBanco.prepareStatement(sql.toString())) {
            for (int i = 0; i < filtros.size(); i++) {
                stmt.setObject(i + 1, filtros.get(i));
            }

            ResultSet rs = stmt.executeQuery();
            List<RelPedido> pedidos = new ArrayList<>();

            while (rs.next()) {
                RelPedido pedido = new RelPedido();
                pedido.setIdPedido(rs.getInt("codigo_pedido"));
                pedido.setStatus(rs.getString("status"));
                pedido.setIdCliente(rs.getInt("codigo_cliente"));
                pedido.setNomeCliente(rs.getString("nome_cliente"));

                String local = rs.getString("local");
                if (local.equals("HOSPITAL")) {
                    pedido.setLocal("Hospital");
                } else if (local.equals("PRONTOSOCORRO")) {
                    pedido.setLocal("Pronto Socorro");
                } else {
                    pedido.setLocal("");
                }

                pedido.setQtdMarmitas(rs.getInt("marmitas"));
                LocalDate dataPedido = rs.getObject("dataPedido", LocalDate.class);
                pedido.setDataPedido(dataPedido);
                LocalDate dataEntrega = rs.getObject("dataEntrega", LocalDate.class);
                pedido.setDataEntrega(dataEntrega);
                pedido.setCidadeCliente(rs.getString("cidade"));
                pedido.setObservacao(rs.getString("observacao"));
                if (pedido.getObservacao() == null) {
                    pedido.setObservacao("");
                }
                pedidos.add(pedido);
            }
            log.registrarLog(2, "PedidoDAO", "filtrarRegistrosRelatorio",
                    "pedido, usuario, usuariotipo, tipousuario, endereco, cidade", "Filtragem dos dados finalizada");
            return pedidos;

        } catch (SQLException e) {
            e.printStackTrace();
            log.registrarLog(4, "PedidoDAO", "filtrarRegistrosRelatorio",
                    "pedido, usuario, usuariotipo, tipousuario, endereco, cidade",
                    "Erro ao filtrar os dados do relatório");
            return null;
        }
    }

    public RelPedido filtrarTotalRelatorio(RelPedido totalizacao, String filtro, List<Object> filtros)
            throws SQLException {
        StringBuilder sql = new StringBuilder();
        sql.append("SELECT ");
        sql.append("COALESCE(SUM(p.quantidade), 0) AS total_marmitas, ");
        sql.append("COALESCE(SUM(CASE WHEN p.status = 'PENDENTE' THEN 1 ELSE 0 END), 0) AS total_pendentes, ");
        sql.append("COALESCE(SUM(CASE WHEN p.status = 'ENTREGUE' THEN 1 ELSE 0 END), 0) AS total_entregues, ");
        sql.append("COALESCE(SUM(CASE WHEN p.status = 'CANCELADO' THEN 1 ELSE 0 END), 0) AS total_cancelados ");
        sql.append("FROM pedido p ");
        sql.append("JOIN usuario u ON p.pessoa = u.id ");
        sql.append("JOIN usuarioTipo ut ON u.id = ut.usuario ");
        sql.append("JOIN tipoUsuario tu ON ut.tipoUsuario = tu.id ");
        sql.append("JOIN endereco e ON u.endereco = e.id ");
        sql.append("JOIN cidade c ON e.cidade = c.id ");
        sql.append("WHERE 1=1 ");
        sql.append(filtro);

        try (PreparedStatement stmt = conexaoBanco.prepareStatement(sql.toString())) {
            for (int i = 0; i < filtros.size(); i++) {
                stmt.setObject(i + 1, filtros.get(i));
            }

            ResultSet rs = stmt.executeQuery();
            while (rs.next()) {
                totalizacao.setTotalMarmitas(rs.getInt("total_marmitas"));
                totalizacao.setTotalPendente(rs.getInt("total_pendentes"));
                totalizacao.setTotalFechado(rs.getInt("total_entregues"));
                totalizacao.setTotalCancelado(rs.getInt("total_cancelados"));
            }
            log.registrarLog(2, "PedidoDAO", "filtrarTotalRelatorio",
                    "pedido, usuario, usuariotipo, tipousuario, endereco, cidade", "Totalização finalizada");
            return totalizacao;

        } catch (SQLException e) {
            e.printStackTrace();
            log.registrarLog(4, "PedidoDAO", "filtrarTotalRelatorio",
                    "pedido, usuario, usuariotipo, tipousuario, endereco, cidade", "Erro ao totalizar o relatório");
            return null;
        }
    }

    public Pedido buscarPedidoPorId(int idPedido) {
        try {
            String sql = "select p.id, p.status, u.id as idCliente, u.nome, tu.tipo,p.quantidade, p.observacao, p.dataPedido, p.dataEntrega from pedido p left join usuario u on u.id = p.pessoa left join usuarioTipo ut on ut.usuario = u.id left join tipoUsuario tu on tu.id = ut.tipoUsuario where p.id = ?";
            PreparedStatement stmt = conexaoBanco.prepareStatement(sql);
            stmt.setInt(1, idPedido);
            ResultSet rs = stmt.executeQuery();
            if (rs.next()) {
                Pedido pedido = new Pedido();
                Pessoa cliente = new Pessoa();
                cliente.setId(rs.getInt("idCliente"));
                cliente.setNome(rs.getString("nome"));
                cliente.setTipoUsuario(TipoCad.fromString(rs.getString("tu.tipo")));
                pedido.setId(rs.getInt("id"));
                pedido.setStatus(Pedido.StatusPedido.fromString(rs.getString("status")));
                pedido.setCliente(cliente);
                pedido.setQuantMarmita(rs.getInt("quantidade"));
                pedido.setObservacao(rs.getString("observacao"));
                if (rs.getDate("dataPedido") != null) {
                    pedido.setDataPedido(rs.getDate("dataPedido").toLocalDate());
                }
                if (rs.getDate("dataEntrega") != null) {
                    pedido.setDataEntrega(rs.getDate("dataEntrega").toLocalDate());
                }
                return pedido;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }
}