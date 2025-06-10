package br.edu.iftm.sistemanossolar.dao.pessoa;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import br.edu.iftm.sistemanossolar.view.RegistrosLog;

public class TipoDAO {

    RegistrosLog log = new RegistrosLog();

    private final Connection conexaoBanco;

    public TipoDAO(Connection conexao) {
        this.conexaoBanco = conexao;
    }

    public Integer buscarIdTipo(String tipo, String tabela) {
        String sql = "SELECT id FROM "+ tabela +" WHERE tipo = (?)";
        try (PreparedStatement stmt = conexaoBanco.prepareStatement(sql)) {
            stmt.setString(1, tipo);
            ResultSet rs = stmt.executeQuery();

            if (rs.next()) {
                log.registrarLog(2, "TipoDAO", "buscarIdTipo", tabela, "ID do Tipo encontrado");
                return rs.getInt("id");
            } else {
                log.registrarLog(3, "TipoDAO", "buscarIdTipo", tabela, "ID do Tipo não encontrado");
                return null;
            }

        } catch (Exception e) {
            e.printStackTrace();
            log.registrarLog(4, "TipoDAO", "buscarIdTipo", tabela, "Erro ao buscar o ID do Tipo");
            return null;
        }
    }

}