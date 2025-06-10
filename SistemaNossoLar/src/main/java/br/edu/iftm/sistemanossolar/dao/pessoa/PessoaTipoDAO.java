package br.edu.iftm.sistemanossolar.dao.pessoa;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import br.edu.iftm.sistemanossolar.view.RegistrosLog;

public class PessoaTipoDAO {
    private final Connection conexaoBanco;

    RegistrosLog log = new RegistrosLog();

    public PessoaTipoDAO(Connection conexao) {
        this.conexaoBanco = conexao;
    }

    public boolean cadastrarRelacao(int idUsuario, int idTipo) {
        log.registrarLog(1, "PessoaTipoDAO", "cadastrarRelacao", "usuariotipo", "Cadastrando a relação do Tipo/Pessoa");
        String sql = "INSERT INTO usuariotipo (usuario, tipoUsuario) VALUES (?, ?)";
        try (PreparedStatement stmtUserTipo = conexaoBanco.prepareStatement(sql)) {
            stmtUserTipo.setInt(1, idUsuario);
            stmtUserTipo.setInt(2, idTipo);
            stmtUserTipo.executeUpdate();
            log.registrarLog(2, "PessoaTipoDAO", "cadastrarRelacao", "usuariotipo", "Relação do Tipo/Pessoa cadastrada");
            return true;
        } catch (SQLException e) {
            e.printStackTrace();
            log.registrarLog(4, "PessoaTipoDAO", "cadastrarRelacao", "usuariotipo", "Erro ao cadastrar relação do Tipo/Pessoa");
            return false;
        }
    }
}
