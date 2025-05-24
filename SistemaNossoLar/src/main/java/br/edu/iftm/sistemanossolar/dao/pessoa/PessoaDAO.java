package br.edu.iftm.sistemanossolar.dao.pessoa;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Types;
import java.util.ArrayList;
import java.util.List;

import br.edu.iftm.sistemanossolar.controller.endereco.CidadeController;
import br.edu.iftm.sistemanossolar.controller.endereco.EnderecoController;
import br.edu.iftm.sistemanossolar.controller.pessoa.TipoController;

import br.edu.iftm.sistemanossolar.model.endereco.Cidade;
import br.edu.iftm.sistemanossolar.model.pessoa.Cliente;
import br.edu.iftm.sistemanossolar.model.pessoa.Doador;
import br.edu.iftm.sistemanossolar.model.pessoa.Pessoa;
import br.edu.iftm.sistemanossolar.model.pessoa.Tipo;

import br.edu.iftm.sistemanossolar.view.RegistrosLog;

public class PessoaDAO {

    private final Connection conexaoBanco;
    private static CidadeController cidadeController;
    private static EnderecoController enderecoController;
    private static TipoController tipoController;

    RegistrosLog log = new RegistrosLog();

    public PessoaDAO(Connection conexao) {
        this.conexaoBanco = conexao;
        cidadeController = new CidadeController(conexao);
        enderecoController = new EnderecoController(conexao);
        tipoController = new TipoController(conexao);
    }

    public boolean cadastrarPessoa(Pessoa pessoa, Tipo tipo) throws SQLException {
        log.registrarLog(1, "PessoaDAO", "cadastrarPessoa", "usuario", "Cadastrando o "+ tipo.getDescricao() +" "+ pessoa.getNome());

        Cidade cidadeTemp = pessoa.getEndereco().getCidade();

        if (!cidadeController.existeCidade(cidadeTemp)) {
            cidadeController.cadastrarCidade(cidadeTemp);    
        }

        Integer idCidade = cidadeController.buscarIdCidade(cidadeTemp);
        Integer idEndereco = enderecoController.buscarIdEndereco(idCidade);

        Integer idTipo = null;
        if (!tipoController.existeTipo(tipo.getDescricao(), "tipousuario")) {
            tipoController.cadastrarTipo(tipo, "tipousuario");
            idTipo = tipoController.buscarIdTipo(tipo.getDescricao(), "tipousuario");
        } else {
            idTipo = tipoController.buscarIdTipo(tipo.getDescricao(), "tipousuario");
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
            log.registrarLog(2, "PessoaDAO", "cadastrarPessoa", "usuario", tipo.getDescricao() +" cadastrado");

            log.registrarLog(1, "PessoaDAO", "cadastrarPessoa", "usuario", "Obtendo o ID do "+tipo.getDescricao());
            Integer idUsu = null;
            try (ResultSet rs = stmt.getGeneratedKeys()) {

                if (rs.next()) {
                    log.registrarLog(2, "PessoaDAO", "cadastrarPessoa", "usuario", "ID do "+ tipo.getDescricao() +" obtido");
                    idUsu = rs.getInt(1);
                } else {
                    log.registrarLog(3, "PessoaDAO", "cadastrarPessoa", "usuario", "ID do "+ tipo.getDescricao() +" não obtido");
                }
            } catch (SQLException e) {
                log.registrarLog(4, "PessoaDAO", "cadastrarPessoa", "usuario", "Erro ao obter ID do "+ tipo.getDescricao());
                e.getMessage();
            }

            if (idUsu != null) {
                log.registrarLog(1, "PessoaDAO", "cadastrarPessoa", "usuariotipo", "Cadastrando a relação do Tipo/Usuario");

                sql = "INSERT INTO usuariotipo (usuario, tipoUsuario) VALUES (?, ?)";
                try (PreparedStatement stmtUserTipo = conexaoBanco.prepareStatement(sql)) {
                    stmtUserTipo.setInt(1, idUsu);
                    stmtUserTipo.setInt(2, idTipo);
                    stmtUserTipo.executeUpdate();
                    log.registrarLog(2, "PessoaDAO", "cadastrarPessoa", "usuariotipo", "Relação do Tipo/Usuario cadastrada");
                } catch (SQLException e) {
                    log.registrarLog(4, "PessoaDAO", "cadastrarPessoa", "usuariotipo", "Erro ao cadastrar relação do Tipo/Usuario");
                    e.getMessage();
                }
            }

            return true;

        } catch (Exception e) {
            log.registrarLog(4, "PessoaDAO", "cadastrarPessoa", "usuario/usuariotipo", "Usuário ou Relação do Tipo/Usuario não cadastrada");
            e.printStackTrace();
            return false;
        }
    }

    public Pessoa buscarPessoaPorId(int id) throws SQLException {
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

    public List<Pessoa> listarPessoas(String tipo) throws SQLException {
        log.registrarLog(1, "PessoaDAO", "listarPessoas", "usuario/tipoUsuario", "Consultando Usuários do tipo "+ tipo);
        List<Pessoa> pessoas = new ArrayList<>();
        int id = tipoController.buscarIdTipo(tipo, "tipousuario");

        String sql = "SELECT us.id, us.nome, us.telefone FROM usuario us JOIN usuariotipo ut WHERE us.id = ut.usuario AND ut.tipoUsuario = ?";
        try (PreparedStatement stmt = conexaoBanco.prepareStatement(sql)) {
            stmt.setInt(1, id);
            ResultSet rs = stmt.executeQuery();

            int i= 0;
            while (rs.next()) {
                if (tipo.equals("Doador")) {
                    Doador doador = new Doador(
                        rs.getInt("id"), 
                        rs.getString("nome"), 
                        rs.getString("telefone"));
                    pessoas.add(doador);
                } else {
                    Cliente cliente = new Cliente(
                        rs.getInt("id"), 
                        rs.getString("nome"), 
                        rs.getString("telefone"));
                    pessoas.add(cliente);
                }
            i++;
            log.registrarLog(2, "PessoaDAO", "listarPessoas", "usuario/tipoUsuario", "Usuário "+ rs.getString("nome") +" encontrado");
            }

            if (i > 0) {
                log.registrarLog(2, "PessoaDAO", "listarPessoas", "usuario/tipoUsuario", "Foram encontrados "+ i +" usuários");
            } else {
                log.registrarLog(3, "PessoaDAO", "listarPessoas", "usuario/tipoUsuario", "Nenhum usuário encontrado");   
            }
            
        } catch (SQLException e) {
            log.registrarLog(4, "PessoaDAO", "listarPessoas", "usuario/tipoUsuario", "Erro ao consultar os Usuários");
            e.printStackTrace();
        }
        return pessoas;
    }

}