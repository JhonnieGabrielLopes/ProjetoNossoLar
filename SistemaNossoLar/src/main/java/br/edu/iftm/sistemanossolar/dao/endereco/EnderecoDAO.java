package br.edu.iftm.sistemanossolar.dao.endereco;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import br.edu.iftm.sistemanossolar.model.endereco.Cidade;
import br.edu.iftm.sistemanossolar.model.endereco.Endereco;

public class EnderecoDAO {
    private final Connection conexaoBanco;
    private CidadeDAO cidadeDAO;

    public EnderecoDAO(Connection conexao) {
        this.conexaoBanco = conexao;
        this.cidadeDAO = new CidadeDAO(conexao);
    }

    public boolean cadastrarEndereco(Endereco endereco, Cidade cidadeTemp) throws SQLException {
        System.out.println("[ALR] EnderecoDAO | cadastrarEndereco - Iniciando cadastro do endereço");

        cidadeDAO.cadastrarCidade(cidadeTemp);
        Integer idCidade = cidadeDAO.buscarIdCidade(cidadeTemp);
    
        String sql = "INSERT INTO endereco (cidade, cep, logradouro, numero, bairro, complemento) VALUES (?, ?, ?, ?, ?, ?)";

        try (PreparedStatement stmt = conexaoBanco.prepareStatement(sql)) {
            stmt.setInt(1, idCidade);
            stmt.setString(2, endereco.getCep());
            stmt.setString(3, endereco.getLogradouro());
            stmt.setInt(4, endereco.getNumero());
            stmt.setString(5, endereco.getBairro());
            stmt.setString(6, endereco.getComplemento());
            stmt.executeUpdate();
            System.out.println("[ALR] EnderecoDAO | cadastrarEndereco - Endereço cadastrado");
            return true;

        } catch (Exception e) {
            System.out.println("[ERR] EnderecoDAO | cadastrarEndereco - Endereço não cadastrado");
            e.printStackTrace();
            return false;
        }
    }

    public Integer buscarIdEndereco(int idCidade) throws SQLException  {
        System.out.println("[ALR] EnderecoDAO | buscarIdEndereco - Iniciando busca do ID do endereço");

        String sql = "SELECT id FROM endereco WHERE cidade = ?";
        try (PreparedStatement stmt = conexaoBanco.prepareStatement(sql)) {
            stmt.setInt(1, idCidade);
            ResultSet rs = stmt.executeQuery();
            
            if (rs.next()) {
                System.out.println("[ALR] EnderecoDAO | buscarIdEndereco - ID do endereço encontrado.");
                return rs.getInt("id");
            } else {
                System.out.println("[ALR] EnderecoDAO | buscarIdEndereco - ID do endereço não encontrado.");
                return null;
            }

        } catch (Exception e) {
            System.out.println("[ERR] EnderecoDAO | buscarIdEndereco - Erro ao buscar o ID do endereço.");
            e.printStackTrace();
            return null;
        }
    }

}