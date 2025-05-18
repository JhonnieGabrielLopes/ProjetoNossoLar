package br.edu.iftm.sistemanossolar.dao.pessoa;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Types;
import java.util.ArrayList;
import java.util.List;

import br.edu.iftm.sistemanossolar.dao.endereco.CidadeDAO;
import br.edu.iftm.sistemanossolar.dao.endereco.EnderecoDAO;

import br.edu.iftm.sistemanossolar.model.endereco.Cidade;
import br.edu.iftm.sistemanossolar.model.pessoa.Cliente;
import br.edu.iftm.sistemanossolar.model.pessoa.Doador;
import br.edu.iftm.sistemanossolar.model.pessoa.Pessoa;
import br.edu.iftm.sistemanossolar.model.pessoa.Tipo;

public class PessoaDAO {
    public static final String RESET = "\u001B[0m";
    public static final String VERMELHO = "\u001B[31m";
    public static final String AMARELO = "\u001B[33m";

    private final Connection conexaoBanco;
    private static CidadeDAO cidadeDAO;
    private static EnderecoDAO enderecoDAO;
    private static TipoDAO tipoDAO;

    public PessoaDAO(Connection conexao) {
        this.conexaoBanco = conexao;
        cidadeDAO = new CidadeDAO(conexao);
        enderecoDAO = new EnderecoDAO(conexao);
        tipoDAO = new TipoDAO(conexao);
    }

    public boolean cadastrarPessoa(Pessoa pessoa, Tipo tipo) throws SQLException {
        System.out.println("[" + AMARELO + "ALR" + RESET + "] PessoaDAO | cadastrarPessoa - Iniciando cadastro do Usuario");

        Cidade cidadeTemp = pessoa.getEndereco().getCidade();

        if (!cidadeDAO.existeCidade(cidadeTemp)) {
            cidadeDAO.cadastrarCidade(cidadeTemp);    
        }

        Integer idCidade = cidadeDAO.buscarIdCidade(cidadeTemp);
        Integer idEndereco = enderecoDAO.buscarIdEndereco(idCidade);

        Integer idTipo = null;
        if (!tipoDAO.existeTipo(tipo.getDescricao())) {
            tipoDAO.cadastrarTipo(
                    tipo.getDescricao().substring(0, 1).toUpperCase() + tipo.getDescricao().substring(1).toLowerCase());
            idTipo = tipoDAO.buscarIdTipo(tipo.getDescricao());
        } else {
            idTipo = tipoDAO.buscarIdTipo(tipo.getDescricao());
        }

        String sql = "INSERT INTO usuario (nome, telefone, endereco, assistido, previsaoQtdDias, tipoPessoa, email, identificacao, observacao) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?)";
        try (PreparedStatement stmt = conexaoBanco.prepareStatement(sql, PreparedStatement.RETURN_GENERATED_KEYS)) {
            stmt.setString(1, pessoa.getNome());
            stmt.setString(2, pessoa.getTelefone());
            stmt.setInt(3, idEndereco);

            if (pessoa instanceof Cliente) {
                Cliente cliente = (Cliente) pessoa;
                stmt.setString(4, cliente.getPaciente());
                stmt.setInt(5, cliente.getPrevisaoQtdDias());
            } else {
                stmt.setNull(4, Types.VARCHAR);
                stmt.setNull(5, Types.INTEGER);
            }

            if (pessoa.getTipoPessoa() != null) {
                stmt.setString(6, pessoa.getTipoPessoa().name());
            } else {
                stmt.setNull(6, Types.VARCHAR);
            }

            if (pessoa.getEmail() != null && !pessoa.getEmail().isEmpty()) {
                stmt.setString(7, pessoa.getEmail());
            } else {
                stmt.setNull(7, Types.VARCHAR);
            }

            if (pessoa.getIdentificacao() != null && !pessoa.getIdentificacao().isEmpty()) {
                stmt.setString(8, pessoa.getIdentificacao());
            } else {
                stmt.setNull(8, Types.VARCHAR);
            }

            if (pessoa.getObservacao() != null && !pessoa.getObservacao().isEmpty()) {
                stmt.setString(9, pessoa.getObservacao());
            } else {
                stmt.setNull(9, Types.VARCHAR);
            }
            stmt.executeUpdate();
            System.out.println("[" + AMARELO + "ALR" + RESET + "] PessoaDAO | cadastrarPessoa - Usuario cadastrado");

            System.out.println("[" + AMARELO + "ALR" + RESET + "] PessoaDAO | cadastrarPessoa - Obtendo ID do Usuario");
            Integer idUsu = null;
            try (ResultSet rs = stmt.getGeneratedKeys()) {

                if (rs.next()) {
                    System.out.println("[" + AMARELO + "ALR" + RESET + "] PessoaDAO | cadastrarPessoa - ID do usuário obtido");
                    idUsu = rs.getInt(1);
                } else {
                    System.out.println("[" + AMARELO + "ALR" + RESET + "] PessoaDAO | cadastrarPessoa - ID do usuário não obtido");
                }
            } catch (SQLException e) {
                System.out.println("[" + VERMELHO + "ERR" + RESET + "] PessoaDAO | cadastrarPessoa - Erro ao obter ID do usuário");
                e.getMessage();
            }

            System.out.println("[" + AMARELO + "ALR" + RESET + "] PessoaDAO | cadastrarPessoa - Cadastrando relação Tipo/Usuario");
            if (idUsu != null) {

                sql = "INSERT INTO usuariotipo (usuario, tipoUsuario) VALUES (?, ?)";
                try (PreparedStatement stmtUserTipo = conexaoBanco.prepareStatement(sql)) {
                    stmtUserTipo.setInt(1, idUsu);
                    stmtUserTipo.setInt(2, idTipo);
                    stmtUserTipo.executeUpdate();
                    System.out.println("[" + AMARELO + "ALR" + RESET + "] PessoaDAO | cadastrarPessoa - Relação Tipo/Usuario cadastrada");
                } catch (SQLException e) {
                    System.out.println("[" + VERMELHO + "ERR" + RESET + "] PessoaDAO | cadastrarPessoa - Erro ao cadastrar relação Tipo/Usuario");
                    e.getMessage();
                }
            }

            return true;

        } catch (Exception e) {
            System.out.println("[" + VERMELHO + "ERR" + RESET + "] PessoaDAO | cadastrarPessoa - Usuario ou Relação Tipo/Usuario não cadastrada");
            e.printStackTrace();
            return false;
        }
    }

    public Pessoa buscarPessoaPorId(int id) {
        String sql = "SELECT * FROM usuario WHERE id = ?";
        try (PreparedStatement stmt = conexaoBanco.prepareStatement(sql)) {
            stmt.setInt(1, id);
            ResultSet rs = stmt.executeQuery();
            if (rs.next()) {
                if (rs.getString("assistido") != null) {
                    return new Cliente(
                        rs.getInt("id"),
                        rs.getString("nome"),
                        rs.getString("telefone")
                    );
                } else {
                    return new Doador(
                        rs.getInt("id"),
                        rs.getString("nome"),
                        rs.getString("telefone")
                    );
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    public List<Pessoa> listarPessoas() {
        List<Pessoa> pessoas = new ArrayList<>();
        String sql = "SELECT * FROM usuario";
        try (PreparedStatement stmt = conexaoBanco.prepareStatement(sql)) {
            ResultSet rs = stmt.executeQuery();
            while (rs.next()) {
                if (rs.getString("assistido") != null) {
                    Cliente cliente = new Cliente(
                        rs.getInt("id"),
                        rs.getString("nome"),
                        rs.getString("telefone")
                    );
                    pessoas.add(cliente);
                } else {
                    Doador doador = new Doador(
                        rs.getInt("id"),
                        rs.getString("nome"),
                        rs.getString("telefone")
                    );
                    pessoas.add(doador);
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return pessoas;
    }
}