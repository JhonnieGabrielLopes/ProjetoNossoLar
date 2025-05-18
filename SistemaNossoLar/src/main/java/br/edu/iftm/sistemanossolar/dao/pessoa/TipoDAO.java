package br.edu.iftm.sistemanossolar.dao.pessoa;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class TipoDAO {
    public static final String RESET = "\u001B[0m";
    public static final String VERMELHO = "\u001B[31m";
    public static final String AMARELO = "\u001B[33m";

    private final Connection conexaoBanco;

    public TipoDAO(Connection conexao) {
        this.conexaoBanco = conexao;
    }

    public boolean cadastrarTipo(String tipo) {
        System.out.println("[" + AMARELO + "ALR" + RESET + "] TipoDAO | cadastrarTipo - Iniciando cadastro do Tipo do Usuario");

        String sql = "INSERT INTO tipousuario (tipo) VALUES (?)";
        try (PreparedStatement stmt = conexaoBanco.prepareStatement(sql)) {
            stmt.setString(1, tipo);
            stmt.executeUpdate();
            System.out.println("[" + AMARELO + "ALR" + RESET + "] TipoDAO | cadastrarTipo - Tipo do Usuario cadastrado");
            return true;

        } catch (Exception e) {
            System.out.println("[" + VERMELHO + "ERR" + RESET + "] TipoDAO | cadastrarTipo - Tipo do Usuario não cadastrado");
            e.printStackTrace();
            return false;
        }
    }

    public boolean existeTipo(String tipo) {
        System.out.println("[" + AMARELO + "ALR" + RESET + "] TipoDAO | existeTipo - Iniciando verificação se o Tipo do Usuario existe");

        String sql = "SELECT * FROM tipousuario WHERE tipo = ?";
        try (PreparedStatement stmt = conexaoBanco.prepareStatement(sql)) {
            stmt.setString(1, tipo);
            ResultSet rs = stmt.executeQuery();
            if (rs.next()) {
                System.out.println("[" + AMARELO + "ALR" + RESET + "] TipoDAO | existeTipo - Tipo do Usuario existe");
                return true;
            } else {
                System.out.println("[" + AMARELO + "ALR" + RESET + "] TipoDAO | existeTipo - Tipo do Usuario não existe");
                return false;
            }

        } catch (Exception e) {
            System.out.println("[" + VERMELHO + "ERR" + RESET + "] TipoDAO | existeTipo - Erro ao verificar se o Tipo do Usuario existe");
            e.printStackTrace();
            return false;
        }
    }

    public Integer buscarIdTipo(String tipo) {
        System.out.println("[" + AMARELO + "ALR" + RESET + "] TipoDAO | buscarIdTipo - Iniciando busca do ID do Tipo do Usuario");

        String sql = "SELECT id FROM tipousuario WHERE tipo = ?";
        try (PreparedStatement stmt = conexaoBanco.prepareStatement(sql)) {
            stmt.setString(1, tipo);
            ResultSet rs = stmt.executeQuery();

            if (rs.next()) {
                System.out.println("[" + AMARELO + "ALR" + RESET + "] TipoDAO | buscarIdTipo - ID do Tipo do Usuario encontrado");
                return rs.getInt("id");
            } else {
                System.out.println("[" + AMARELO + "ALR" + RESET + "] TipoDAO | buscarIdTipo - ID do Tipo do Usuario não encontrado");
                return null;
            }

        } catch (Exception e) {
            System.out.println("[" + VERMELHO + "ERR" + RESET + "] TipoDAO | buscarIdTipo - Erro ao buscar o ID do Tipo do Usuario");
            e.printStackTrace();
            return null;
        }
    }

}