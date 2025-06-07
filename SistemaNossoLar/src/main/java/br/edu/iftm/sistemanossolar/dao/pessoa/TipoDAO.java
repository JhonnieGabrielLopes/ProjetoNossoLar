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

    public boolean cadastrarTipo(String tipo, String tabela) {
        log.registrarLog(1, "TipoDAO", "cadastrarTipo", tabela, "Cadastrando o Tipo "+ tipo);

        String sql = "INSERT INTO "+ tabela +" (tipo) VALUES (?)";
        try (PreparedStatement stmt = conexaoBanco.prepareStatement(sql)) {
            stmt.setString(1, tipo);
            stmt.executeUpdate();
            log.registrarLog(2, "TipoDAO", "cadastrarTipo", tabela, "Tipo cadastrado");
            return true;

        } catch (Exception e) {
            log.registrarLog(4, "TipoDAO", "cadastrarTipo", tabela, "Tipo não cadastrado");
            e.printStackTrace();
            return false;
        }
    }

    public boolean existeTipo(String tipo, String tabela) {
        log.registrarLog(1, "TipoDAO", "existeTipo", tabela, "Verificando se o Tipo "+ tipo +" existe");

        String sql = "SELECT * FROM "+ tabela +" WHERE tipo = (?)";
        try (PreparedStatement stmt = conexaoBanco.prepareStatement(sql)) {
            stmt.setString(1, tipo);
            ResultSet rs = stmt.executeQuery();
            if (rs.next()) {
                log.registrarLog(2, "TipoDAO", "existeTipo", tabela, "Tipo existe");
                return true;
            } else {
                log.registrarLog(3, "TipoDAO", "existeTipo", tabela, "Tipo não existe");
                return false;
            }

        } catch (Exception e) {
            log.registrarLog(4, "TipoDAO", "existeTipo", tabela, "Erro ao verificar se o Tipo existe");
            e.printStackTrace();
            return false;
        }
    }

    public Integer buscarIdTipo(String tipo, String tabela) {
        log.registrarLog(1, "TipoDAO", "buscarIdTipo", tabela, "Buscando o ID do Tipo "+tipo);

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
            log.registrarLog(4, "TipoDAO", "buscarIdTipo", tabela, "Erro ao buscar o ID do Tipo");
            e.printStackTrace();
            return null;
        }
    }

}