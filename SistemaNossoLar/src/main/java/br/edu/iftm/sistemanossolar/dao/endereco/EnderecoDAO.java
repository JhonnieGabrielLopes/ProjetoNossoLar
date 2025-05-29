package br.edu.iftm.sistemanossolar.dao.endereco;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import br.edu.iftm.sistemanossolar.model.endereco.Cidade;
import br.edu.iftm.sistemanossolar.model.endereco.Endereco;

public class EnderecoDAO {
    public static final String RESET = "\u001B[0m";
    public static final String VERMELHO = "\u001B[31m";
    public static final String AMARELO = "\u001B[33m";
    
    private final Connection conexaoBanco;
    private CidadeDAO cidadeDAO;

    public EnderecoDAO(Connection conexao) {
        this.conexaoBanco = conexao;
        this.cidadeDAO = new CidadeDAO(conexao);
    }

    public boolean cadastrarEndereco(Endereco endereco, Cidade cidadeTemp) throws SQLException {
        System.out.println("[" + AMARELO + "ALR" + RESET + "] EnderecoDAO | cadastrarEndereco - Iniciando cadastro do endereço");

        if (!cidadeDAO.existeCidade(cidadeTemp)) {
            cidadeDAO.cadastrarCidade(cidadeTemp);
        }

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
            System.out.println("[" + AMARELO + "ALR" + RESET + "] EnderecoDAO | cadastrarEndereco - Endereço cadastrado");
            return true;

        } catch (Exception e) {
            System.out.println("[" + VERMELHO + "ERR" + RESET + "] EnderecoDAO | cadastrarEndereco - Endereço não cadastrado");
            e.printStackTrace();
            return false;
        }
    }

    public Integer buscarIdEndereco(int idCidade) throws SQLException  {
        System.out.println("[" + AMARELO + "ALR" + RESET + "] EnderecoDAO | buscarIdEndereco - Iniciando busca do ID do endereço");

        String sql = "SELECT id FROM endereco WHERE cidade = ?";
        try (PreparedStatement stmt = conexaoBanco.prepareStatement(sql)) {
            stmt.setInt(1, idCidade);
            ResultSet rs = stmt.executeQuery();
            
            if (rs.next()) {
                System.out.println("[" + AMARELO + "ALR" + RESET + "] EnderecoDAO | buscarIdEndereco - ID do endereço encontrado");
                return rs.getInt("id");
            } else {
                System.out.println("[" + AMARELO + "ALR" + RESET + "] EnderecoDAO | buscarIdEndereco - ID do endereço não encontrado");
                return null;
            }

        } catch (Exception e) {
            System.out.println("[" + VERMELHO + "ERR" + RESET + "] EnderecoDAO | buscarIdEndereco - Erro ao buscar o ID do endereço");
            e.printStackTrace();
            return null;
        }
    }

    public Endereco buscarEnderecoPorId(int id) throws SQLException {
        System.out.println("[" + AMARELO + "ALR" + RESET + "] EnderecoDAO | buscarEnderecoPorId - Iniciando busca do endereço por ID");

        String sql = "SELECT * FROM endereco WHERE id = ?";
        try (PreparedStatement stmt = conexaoBanco.prepareStatement(sql)) {
            stmt.setInt(1, id);
            ResultSet rs = stmt.executeQuery();
            
            if (rs.next()) {
                System.out.println("[" + AMARELO + "ALR" + RESET + "] EnderecoDAO | buscarEnderecoPorId - Endereço encontrado");
                return new Endereco(
                    rs.getString("logradouro"),
                    rs.getInt("numero"),
                    rs.getString("bairro"),
                    rs.getString("cep"),
                    rs.getString("complemento"),
                    cidadeDAO.buscarCidadePorId(rs.getInt("cidade"))
                );
            } else {
                System.out.println("[" + AMARELO + "ALR" + RESET + "] EnderecoDAO | buscarEnderecoPorId - Endereço não encontrado");
                return null;
            }

        } catch (Exception e) {
            System.out.println("[" + VERMELHO + "ERR" + RESET + "] EnderecoDAO | buscarEnderecoPorId - Erro ao buscar o endereço por ID");
            e.printStackTrace();
            return null;
        }
    }
}