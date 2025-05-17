package br.edu.iftm.sistemanossolar.dao.endereco;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import br.edu.iftm.sistemanossolar.dao.ConexaoBanco;
import br.edu.iftm.sistemanossolar.model.endereco.Cidade;
import br.edu.iftm.sistemanossolar.model.endereco.Endereco;

public class EnderecoDAO {
    CidadeDAO cidadeDAO = new CidadeDAO();

    public boolean cadastrarEndereco(Endereco endereco, Cidade cidadeTemp) {
        
        if (!cidadeDAO.existeCidade(cidadeTemp)) {
            System.out.println("Cidade não cadastrada. Cadastrando...");
            cidadeDAO.cadastrarCidade(endereco.getCidade());
        }

        Integer idCidade = cidadeDAO.buscarIdCidade(cidadeTemp);
    
        String sql = "INSERT INTO endereco (cidade, cep, logradouro, numero, bairro, complemento) VALUES (?, ?, ?, ?, ?, ?)";
        try (Connection conexao = ConexaoBanco.getConnection()) {
            PreparedStatement stmt = conexao.prepareStatement(sql);
            stmt.setInt(1, idCidade);
            stmt.setString(2, endereco.getCep());
            stmt.setString(3, endereco.getLogradouro());
            stmt.setInt(4, endereco.getNumero());
            stmt.setString(5, endereco.getBairro());
            stmt.setString(6, endereco.getComplemento());
            stmt.executeUpdate();
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
        
    }

    public Integer buscarIdEndereco(int idCidade) {
        String sql = "SELECT id FROM endereco WHERE cidade = ?";
        try (Connection conexao = ConexaoBanco.getConnection()) {
            PreparedStatement stmt = conexao.prepareStatement(sql);
            stmt.setInt(1, idCidade);
            ResultSet rs = stmt.executeQuery();
            if (rs.next()) {
                return rs.getInt("id");
            }else {
                System.out.println("ID do endereço não encontrado.");
                return null;
            }
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println("Erro ao buscar ID do endereço");
            return null;
        }
    }
}
