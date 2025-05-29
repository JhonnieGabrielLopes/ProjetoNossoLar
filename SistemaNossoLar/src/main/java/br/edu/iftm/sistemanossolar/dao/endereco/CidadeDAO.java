package br.edu.iftm.sistemanossolar.dao.endereco;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import br.edu.iftm.sistemanossolar.model.endereco.Cidade;

public class CidadeDAO {
    public static final String RESET = "\u001B[0m";
    public static final String VERMELHO = "\u001B[31m";
    public static final String AMARELO = "\u001B[33m";
    
    private final Connection conexaoBanco;

    public CidadeDAO(Connection conexao) {
        this.conexaoBanco = conexao;
    }

    public boolean cadastrarCidade(Cidade cidade) throws SQLException {
        System.out.println("[" + AMARELO + "ALR" + RESET + "] CidadeDAO | cadastrarCidade - Iniciando cadastro da cidade");
        
        String sql = "INSERT INTO cidade (nome, uf) VALUES (?, ?)";
        try (PreparedStatement stmt = conexaoBanco.prepareStatement(sql)) {
            stmt.setString(1, cidade.getNome());
            stmt.setString(2, cidade.getEstado());
            stmt.executeUpdate();
            System.out.println("[" + AMARELO + "ALR" + RESET + "] CidadeDAO | cadastrarCidade - Cidade cadastrada");
            return true;
        
        } catch (Exception e) {
            System.out.println("[" + VERMELHO + "ALR" + RESET + "] CidadeDAO | cadastrarCidade - Cidade não cadastrada");
            e.printStackTrace();
            return false;
        }
    }
    
    public Integer buscarIdCidade(Cidade cidade) throws SQLException {
        System.out.println("[" + AMARELO + "ALR" + RESET + "] CidadeDAO | buscarIdCidade - Iniciando busca do ID da cidade");

        String sql = "SELECT id FROM cidade WHERE nome = ? AND uf = ?";
        try (PreparedStatement stmt = conexaoBanco.prepareStatement(sql)) {
            stmt.setString(1, cidade.getNome());
            stmt.setString(2, cidade.getEstado());
            ResultSet rs = stmt.executeQuery();

            if (rs.next()) {
                System.out.println("[" + AMARELO + "ALR" + RESET + "] CidadeDAO | buscarIdCidade - ID da cidade encontrado");
                return rs.getInt("id");
            } else {
                System.out.println("[" + AMARELO + "ALR" + RESET + "] CidadeDAO | buscarIdCidade - ID da cidade não encontrado");
                return null;
            }

        } catch (Exception e) {
            System.out.println("[" + VERMELHO + "ERR" + RESET + "] CidadeDAO | buscarIdCidade - Erro ao buscar ID da cidade");
            e.printStackTrace();
            return null;
        }
    }

    public boolean existeCidade(Cidade cidade) throws SQLException {
        System.out.println("[" + AMARELO + "ALR" + RESET + "] CidadeDAO | existeCidade - Iniciando verificação se a cidade existe");

        String sql = "SELECT id FROM cidade WHERE nome = ? AND uf = ?";
        try (PreparedStatement stmt = conexaoBanco.prepareStatement(sql)) {
            stmt.setString(1, cidade.getNome());
            stmt.setString(2, cidade.getEstado());
            ResultSet rs = stmt.executeQuery();

            if (rs.next()) {
                System.out.println("[" + AMARELO + "ALR" + RESET + "] CidadeDAO | existeCidade - Cidade existe");
                return true;
            } else {
                System.out.println("[" + AMARELO + "ALR" + RESET + "] CidadeDAO | existeCidade - Cidade não existe");
                return false;
            }

        } catch (Exception e) {
            System.out.println("[" + VERMELHO + "ERR" + RESET + "] CidadeDAO | existeCidade - Erro ao verificar se a cidade existe.");
            e.printStackTrace();
            return false;
        }

    }

    public Cidade buscarCidadePorId(int id){
        String sql = "SELECT * FROM cidade WHERE id = ?";
        try (PreparedStatement stmt = conexaoBanco.prepareStatement(sql)) {
            stmt.setInt(1, id);
            ResultSet rs = stmt.executeQuery();

            if (rs.next()) {
                System.out.println("[" + AMARELO + "ALR" + RESET + "] CidadeDAO | buscarCidadePorId - Cidade encontrada");
                return new Cidade(
                    rs.getString("nome"),
                    rs.getString("uf")
                );
            } else {
                System.out.println("[" + AMARELO + "ALR" + RESET + "] CidadeDAO | buscarCidadePorId - Cidade não encontrada");
                return null;
            }

        } catch (Exception e) {
            System.out.println("[" + VERMELHO + "ERR" + RESET + "] CidadeDAO | buscarCidadePorId - Erro ao buscar cidade por ID");
            e.printStackTrace();
            return null;
        }
    }
}