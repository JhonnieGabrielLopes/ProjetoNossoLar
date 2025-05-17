package br.edu.iftm.sistemanossolar.dao.endereco;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import br.edu.iftm.sistemanossolar.dao.ConexaoBanco;
import br.edu.iftm.sistemanossolar.model.endereco.Cidade;

public class CidadeDAO {

    public boolean cadastrarCidade(Cidade cidade) {
            String sql = "INSERT INTO cidade (nome, uf) VALUES (?, ?)";

            try (Connection conexao = ConexaoBanco.getConnection()) {
                PreparedStatement stmt = conexao.prepareStatement(sql);
                stmt.setString(1, cidade.getNome());
                stmt.setString(2, cidade.getEstado());
                stmt.executeUpdate();
                
                System.out.println("Cidade cadastrada com sucesso.");
                return true;

            } catch (Exception e) {
                System.out.println("Erro ao cadastrar cidade");
                e.printStackTrace();
                return false;
            }
    }

    
    public Integer buscarIdCidade(Cidade cidade) {
        String sql = "SELECT id FROM cidade WHERE nome = ?";

        try (Connection conexao = ConexaoBanco.getConnection()) {
            PreparedStatement stmt = conexao.prepareStatement(sql);
            stmt.setString(1, cidade.getNome());
            ResultSet rs = stmt.executeQuery();

            if (rs.next()) {
                return rs.getInt("id");
            } else {
                System.out.println("Cidade não encontrada.");
                return 0;
            }

        } catch (Exception e) {
            e.printStackTrace();
            System.out.println("Erro ao buscar ID da cidade");
            return 0;
        }
    }

    public boolean existeCidade(Cidade cidade) {
        String sql = "SELECT id FROM cidade WHERE nome = ? AND uf = ?";
        try (Connection conexao = ConexaoBanco.getConnection()) {
            PreparedStatement stmt = conexao.prepareStatement(sql);
            stmt.setString(1, cidade.getNome());
            stmt.setString(2, cidade.getEstado());
            ResultSet rs = stmt.executeQuery();

            if (rs.next()) {
                System.out.println("Cidade já cadastrada.");
                return true;
            } else {
                System.out.println("Cidade não cadastrada.");
                return false;
            }

        } catch (Exception e) {
            e.printStackTrace();
            System.out.println("Erro ao verificar se a cidade existe");
            return false;
        }

    }

}