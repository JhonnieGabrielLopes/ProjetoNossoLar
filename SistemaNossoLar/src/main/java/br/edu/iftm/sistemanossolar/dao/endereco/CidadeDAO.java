package br.edu.iftm.sistemanossolar.dao.endereco;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import br.edu.iftm.sistemanossolar.model.endereco.Cidade;

public class CidadeDAO {
    private final Connection conexaoBanco;

    public CidadeDAO(Connection conexao) {
        this.conexaoBanco = conexao;
    }

    public boolean cadastrarCidade(Cidade cidade) throws SQLException {
        System.out.println("[ALR] CidadeDAO | cadastrarCidade - Iniciando cadastro da cidade");
        
        if (!existeCidade(cidade)) {
            String sql = "INSERT INTO cidade (nome, uf) VALUES (?, ?)";
            try (PreparedStatement stmt = conexaoBanco.prepareStatement(sql)) {
                stmt.setString(1, cidade.getNome());
                stmt.setString(2, cidade.getEstado());
                stmt.executeUpdate();
                System.out.println("[ALR] CidadeDAO | cadastrarCidade - Cidade cadastrada");
                return true;

            } catch (Exception e) {
                System.out.println("[ERR] CidadeDAO | cadastrarCidade - Cidade não cadastrada");
                e.printStackTrace();
                return false;
            }

        } else {
            System.out.println("[ALR] CidadeDAO | cadastrarCidade - Cidade já cadastrada.");
            return false;
        }

    }
    
    public Integer buscarIdCidade(Cidade cidade) throws SQLException {
        System.out.println("[ALR] CidadeDAO | buscarIdCidade - Iniciando busca do ID da cidade");

        String sql = "SELECT id FROM cidade WHERE nome = ? AND uf = ?";
        try (PreparedStatement stmt = conexaoBanco.prepareStatement(sql)) {
            stmt.setString(1, cidade.getNome());
            stmt.setString(2, cidade.getEstado());
            ResultSet rs = stmt.executeQuery();

            if (rs.next()) {
                System.out.println("[ALR] CidadeDAO | buscarIdCidade - ID da cidade encontrado");
                return rs.getInt("id");
            } else {
                System.out.println("[ALR] CidadeDAO | buscarIdCidade - ID da cidade não encontrado");
                return null;
            }

        } catch (Exception e) {
            System.out.println("[ERR] CidadeDAO | buscarIdCidade - Erro ao buscar ID da cidade");
            e.printStackTrace();
            return null;
        }
    }

    public boolean existeCidade(Cidade cidade) throws SQLException {
        System.out.println("[ALR] CidadeDAO | existeCidade - Iniciando verificação se a cidade existe");

        String sql = "SELECT id FROM cidade WHERE nome = ? AND uf = ?";
        try (PreparedStatement stmt = conexaoBanco.prepareStatement(sql)) {
            stmt.setString(1, cidade.getNome());
            stmt.setString(2, cidade.getEstado());
            ResultSet rs = stmt.executeQuery();

            if (rs.next()) {
                System.out.println("[ALR] CidadeDAO | existeCidade - Cidade existe");
                return true;
            } else {
                System.out.println("[ALR] CidadeDAO | existeCidade - Cidade não existe");
                return false;
            }

        } catch (Exception e) {
            System.out.println("[ERR] CidadeDAO | existeCidade - Erro ao verificar se a cidade existe.");
            e.printStackTrace();
            return false;
        }

    }

}