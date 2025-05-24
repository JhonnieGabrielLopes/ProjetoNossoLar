package br.edu.iftm.sistemanossolar.dao.endereco;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import br.edu.iftm.sistemanossolar.controller.endereco.CidadeController;
import br.edu.iftm.sistemanossolar.model.endereco.Cidade;
import br.edu.iftm.sistemanossolar.model.endereco.Endereco;
import br.edu.iftm.sistemanossolar.view.RegistrosLog;

public class EnderecoDAO {
    public static final String RESET = "\u001B[0m";
    public static final String VERMELHO = "\u001B[31m";
    public static final String AMARELO = "\u001B[33m";
    
    private final Connection conexaoBanco;

    private CidadeController cidadeController;

    RegistrosLog log = new RegistrosLog();

    public EnderecoDAO(Connection conexao) {
        this.conexaoBanco = conexao;
        this.cidadeController = new CidadeController(conexao);
    }

    public boolean cadastrarEndereco(Endereco endereco, Cidade cidadeTemp) throws SQLException {
        log.registrarLog(1, "EnderecoDAO", "cadastrarEndereco", "endereco", "Cadastrando o Endereço do Usuario");

        if (!cidadeController.existeCidade(cidadeTemp)) {
            cidadeController.cadastrarCidade(cidadeTemp);
        }

        Integer idCidade = cidadeController.buscarIdCidade(cidadeTemp);
    
        String sql = "INSERT INTO endereco (cidade, cep, logradouro, numero, bairro, complemento) VALUES (?, ?, ?, ?, ?, ?)";
        try (PreparedStatement stmt = conexaoBanco.prepareStatement(sql)) {
            stmt.setInt(1, idCidade);
            stmt.setString(2, endereco.getCep());
            stmt.setString(3, endereco.getLogradouro());
            stmt.setInt(4, endereco.getNumero());
            stmt.setString(5, endereco.getBairro());
            stmt.setString(6, endereco.getComplemento());
            stmt.executeUpdate();

            log.registrarLog(2, "EnderecoDAO", "cadastrarEndereco", "endereco", "Endereço cadastrado");
            return true;

        } catch (Exception e) {
            log.registrarLog(4, "EnderecoDAO", "cadastrarEndereco", "endereco", "Endereço não cadastrado");
            e.printStackTrace();
            return false;
        }
    }

    public Integer buscarIdEndereco(int idCidade) throws SQLException  {
        log.registrarLog(1, "EnderecoDAO", "buscarIdEndereco", "endereco", "Buscando o ID do Endereço");

        String sql = "SELECT id FROM endereco WHERE cidade = ?";
        try (PreparedStatement stmt = conexaoBanco.prepareStatement(sql)) {
            stmt.setInt(1, idCidade);
            ResultSet rs = stmt.executeQuery();
            
            if (rs.next()) {
                log.registrarLog(2, "EnderecoDAO", "buscarIdEndereco", "endereco", "ID do Endereço encontrado");
                return rs.getInt("id");
            } else {
                log.registrarLog(3, "EnderecoDAO", "buscarIdEndereco", "endereco", "ID do Endereço não encontrado");
                return null;
            }

        } catch (Exception e) {
            log.registrarLog(4, "EnderecoDAO", "buscarIdEndereco", "endereco", "Erro ao buscar ID do Endereço");
            e.printStackTrace();
            return null;
        }
    }

}