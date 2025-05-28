package br.edu.iftm.sistemanossolar.dao.doacao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import br.edu.iftm.sistemanossolar.controller.pessoa.TipoController;
import br.edu.iftm.sistemanossolar.model.doacao.Doacao;
import br.edu.iftm.sistemanossolar.model.doacao.Produto;
import br.edu.iftm.sistemanossolar.view.RegistrosLog;

public class DoacaoDAO {
    private final Connection conexaoBanco;
    private static TipoController tipoController;

    RegistrosLog log = new RegistrosLog();

    public DoacaoDAO(Connection conexao) {
        this.conexaoBanco = conexao;
        tipoController = new TipoController(conexao);
    }

    public boolean cadastrarDoacao(Doacao doacao) throws SQLException {
        log.registrarLog(1, "DoacaoDAO", "cadastrarDoacao", "doacao", "Cadastrando Doação");

        Integer idTipo = null;
        if (!tipoController.existeTipo(doacao.getTipo().getDescricao(), "tipodoacao")) {
            tipoController.cadastrarTipo(doacao.getTipo().getDescricao(), "tipodoacao");
            idTipo = tipoController.buscarIdTipo(doacao.getTipo().getDescricao(), "tipodoacao");
        } else {
            idTipo = tipoController.buscarIdTipo(doacao.getTipo().getDescricao(), "tipodoacao");
        }

        String sql = "INSERT INTO doacao (tipoDoacao, pessoa, valor, data) VALUES (?, ?, ?, ?)";
        try (PreparedStatement stmt = conexaoBanco.prepareStatement(sql, PreparedStatement.RETURN_GENERATED_KEYS)) {
            stmt.setInt(1, idTipo);
            stmt.setInt(2, doacao.getDoador().getId());
            stmt.setDouble(3, doacao.getValor());
            java.sql.Date data = java.sql.Date.valueOf(doacao.getDataDoacao());
            stmt.setDate(4, data);
            stmt.executeUpdate();
            log.registrarLog(2, "DoacaoDAO", "cadastrarDoacao", "doacao", "Doação cadastrada");

            if (doacao.getProduto() != null) {
                log.registrarLog(1, "DoacaoDAO", "cadastrarDoacao", "doacao", "Obtendo o ID da Doação");
                Integer idDoa = null;

                try (ResultSet rs = stmt.getGeneratedKeys()) {
                    if (rs.next()) {
                        log.registrarLog(2, "DoacaoDAO", "cadastrarDoacao", "doacao", "ID da Doação obtido");
                        idDoa = rs.getInt(1);
                    } else {
                        log.registrarLog(3, "DoacaoDAO", "cadastrarDoacao", "doacao", "ID da Doação não obtido");
                    }
                } catch (SQLException e) {
                    log.registrarLog(4, "DoacaoDAO", "cadastrarDoacao", "doacao", "Erro ao obter o ID da Doação");
                    e.getMessage();
                }
                
                if (idDoa != null) {
                    for (Produto produto : doacao.getProduto()) {
                        log.registrarLog(1, "DoacaoDAO", "cadastrarDoacao", "produtodoacao", "Cadastrando a relação do Produto/Doação");

                        sql = "INSERT INTO produtodoacao (doacao, produto, quantidade) VALUES (?, ?, ?)";
                        try (PreparedStatement stmtUserTipo = conexaoBanco.prepareStatement(sql)) {
                            stmtUserTipo.setInt(1, idDoa);
                            stmtUserTipo.setInt(2, produto.getId());
                            stmtUserTipo.setInt(3, produto.getQuantidade());
                            stmtUserTipo.executeUpdate();
                            log.registrarLog(2, "DoacaoDAO", "cadastrarDoacao", "produtodoacao", "Relação do Produto/Doação cadastrada");
                        } catch (SQLException e) {
                            log.registrarLog(4, "DoacaoDAO", "cadastrarDoacao", "produtodoacao", "Erro ao cadastrar relação do Produto/Doação");
                            e.getMessage();
                        }
                    }
                }
            }

            return true;

        } catch (Exception e) {
            log.registrarLog(4, "PessoaDAO", "cadastrarPessoa", "usuario/usuariotipo", "Usuário ou Relação do Tipo/Usuario não cadastrada");
            e.printStackTrace();
            return false;
        }
    }
    
}