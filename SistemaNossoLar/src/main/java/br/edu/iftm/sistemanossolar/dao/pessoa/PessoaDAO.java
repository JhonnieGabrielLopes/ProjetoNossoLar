package br.edu.iftm.sistemanossolar.dao.pessoa;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Types;
import java.util.ArrayList;
import java.util.List;

import br.edu.iftm.sistemanossolar.controller.pessoa.PacienteController;
import br.edu.iftm.sistemanossolar.model.pessoa.Paciente;
import br.edu.iftm.sistemanossolar.model.pessoa.Pessoa;
import br.edu.iftm.sistemanossolar.model.pessoa.Pessoa.Local;
import br.edu.iftm.sistemanossolar.model.pessoa.Pessoa.TipoCad;
import br.edu.iftm.sistemanossolar.model.pessoa.Pessoa.TipoPessoa;

import br.edu.iftm.sistemanossolar.view.RegistrosLog;

public class PessoaDAO {
    private final Connection conexaoBanco;
    private static PacienteController pacienteController;
    private static PessoaTipoDAO pessoaTipoDAO;

    RegistrosLog log = new RegistrosLog();

    public PessoaDAO(Connection conexao) {
        this.conexaoBanco = conexao;
        pacienteController = new PacienteController(conexao);
        pessoaTipoDAO = new PessoaTipoDAO(conexao);
    }

    public Integer cadastrarPessoa(Pessoa pessoa, Paciente paciente, Integer cidade, Integer endereco, Integer idTipo) {
        String sql = "INSERT INTO usuario (nome, telefone, endereco, tipoPessoa, email, identificacao, observacao, local) VALUES (?, ?, ?, ?, ?, ?, ?, ?)";
        try (PreparedStatement stmt = conexaoBanco.prepareStatement(sql, PreparedStatement.RETURN_GENERATED_KEYS)) {
            stmt.setString(1, pessoa.getNome());
            stmt.setString(2, pessoa.getTelefone());
            stmt.setInt(3, endereco);

            if (pessoa.getTipoPessoa() != null) {
                stmt.setString(4, pessoa.getTipoPessoa().name());
            } else {
                stmt.setNull(4, Types.VARCHAR);
            }

            if (pessoa.getEmail() != null && !pessoa.getEmail().isEmpty()) {
                stmt.setString(5, pessoa.getEmail());
            } else {
                stmt.setNull(5, Types.VARCHAR);
            }

            if (pessoa.getIdentificacao() != null && !pessoa.getIdentificacao().isEmpty()) {
                stmt.setString(6, pessoa.getIdentificacao());
            } else {
                stmt.setNull(6, Types.VARCHAR);
            }

            if (pessoa.getObservacao() != null && !pessoa.getObservacao().isEmpty()) {
                stmt.setString(7, pessoa.getObservacao());
            } else {
                stmt.setNull(7, Types.VARCHAR);
            }
            
            if (pessoa.getLocal() != null) {
                stmt.setString(8, pessoa.getLocal().toString());
            } else {
                stmt.setNull(8, Types.VARCHAR);
            }

            stmt.executeUpdate();
            log.registrarLog(2, "PessoaDAO", "cadastrarPessoa", "usuario", pessoa.getTipoUsuario() +" cadastrado");

            log.registrarLog(1, "PessoaDAO", "cadastrarPessoa", "usuario", "Obtendo o ID do "+ pessoa.getTipoUsuario());
            Integer idUsu = null;
            try (ResultSet rs = stmt.getGeneratedKeys()) {
                if (rs.next()) {
                    log.registrarLog(2, "PessoaDAO", "cadastrarPessoa", "usuario", "ID do "+ pessoa.getTipoUsuario() +" obtido");
                    idUsu = rs.getInt(1);
                    log.registrarLog(1, "PessoaDAO", "cadastrarRelacao", "usuariotipo", "Cadastrando a relação do Tipo/Pessoa");
                    pessoaTipoDAO.cadastrarRelacao(idUsu, idTipo);
                    return idUsu;
                } else {
                    log.registrarLog(4, "PessoaDAO", "cadastrarPessoa", "usuario", "ID do "+ pessoa.getTipoUsuario() +" não obtido");
                    return 0;
                }
            } catch (SQLException e) {
                e.printStackTrace();
                log.registrarLog(4, "PessoaDAO", "cadastrarPessoa", "usuario", "Erro ao obter ID do "+ pessoa.getTipoUsuario());
                return 0;
            }
        } catch (SQLException e) {
            e.printStackTrace();
            log.registrarLog(4, "PessoaDAO", "cadastrarPessoa", "usuario", "Erro ao cadastrar a Pessoa");
            return 0;
        }
    }

    public Pessoa buscarPessoaPorId(int id) throws SQLException {
        Pessoa pessoa = new Pessoa();
        String sql = "SELECT nome, local, tipoPessoa, telefone, endereco, email, observacao FROM usuario WHERE id = ?";
        try (PreparedStatement stmt = conexaoBanco.prepareStatement(sql)) {
            stmt.setInt(1, id);
            ResultSet rs = stmt.executeQuery();
            if (rs.next()) {
                pessoa.setNome(rs.getString("nome"));
                pessoa.setLocal(Local.fromString(rs.getString("local")));

                String tipoPessoa = rs.getString("tipoPessoa");
                if (tipoPessoa == null || tipoPessoa.isEmpty()) {
                    pessoa.setTipoPessoa(null);
                } else {
                    pessoa.setTipoPessoa(TipoPessoa.valueOf(tipoPessoa));
                }
                
                pessoa.setTelefone(rs.getString("telefone"));
                pessoa.setEnderecoId(rs.getInt("endereco"));
                pessoa.setEmail(rs.getString("email"));
                pessoa.setObservacao(rs.getString("observacao"));

                log.registrarLog(2, "PessoaDAO", "buscarPessoaPorId", "usuario", "Dados básicos da Pessoa obtidos");
            }
        } catch (SQLException e) {
            e.printStackTrace();
            log.registrarLog(4, "PessoaDAO", "buscarPessoaPorId", "usuario", "Dados básicos da Pessoa não obtidos");
            return new Pessoa();
        }

        log.registrarLog(1, "PessoaDAO", "buscarPessoaPorId", "tipousuario/usuariotipo", "Buscando Tipo de Usuário da Pessoa");

        sql = "SELECT t.tipo FROM tipoUsuario t JOIN usuarioTipo u WHERE t.id = u.tipoUsuario AND u.usuario = ?";
        try (PreparedStatement stmt = conexaoBanco.prepareStatement(sql)) {
            stmt.setInt(1, id);
            ResultSet rs = stmt.executeQuery();
            if (rs.next()) {
                pessoa.setTipoUsuario(TipoCad.fromString(rs.getString("tipo")));
                log.registrarLog(2, "PessoaDAO", "buscarPessoaPorId", "tipousuario/usuariotipo", "Tipo de Usuário da Pessoa obtido");
            }
        } catch (SQLException e) {
            e.printStackTrace();
            log.registrarLog(4, "PessoaDAO", "buscarPessoaPorId", "tipousuario/usuariotipo", "Tipo de Usuário da Pessoa não obtido");
            return new Pessoa();
        }

        if (pessoa.getTipoUsuario() == TipoCad.BENEFICIARIO) {
            pessoa.setPaciente(pacienteController.buscarPacienteDoBeneficiario(id));
        }

        pessoa.setId(id);
        return pessoa;
    }

    public List<Pessoa> listarPessoas2(String tipo, Integer idTipo) {
        //METODO PARA TESTES NO TERMINAL
        List<Pessoa> pessoas = new ArrayList<>();
        String sql = "SELECT us.id, us.nome, us.telefone FROM usuario us JOIN usuariotipo ut WHERE us.id = ut.usuario AND ut.tipoUsuario = ?";
        try (PreparedStatement stmt = conexaoBanco.prepareStatement(sql)) {
            stmt.setInt(1, idTipo);
            ResultSet rs = stmt.executeQuery();
            int i= 0;
            while (rs.next()) {
                Pessoa pessoa = new Pessoa(
                    rs.getInt("id"), 
                    rs.getString("nome"), 
                    rs.getString("telefone"));
                pessoas.add(pessoa);
                i++;
                log.registrarLog(2, "PessoaDAO", "listarPessoas", "usuario/tipoUsuario", "Usuário "+ rs.getString("nome") +" encontrado");
            }
            if (i > 0) {
                log.registrarLog(2, "PessoaDAO", "listarPessoas", "usuario/tipoUsuario", "Foram encontrados "+ i +" usuários");
            } else {
                log.registrarLog(3, "PessoaDAO", "listarPessoas", "usuario/tipoUsuario", "Nenhum usuário encontrado");   
            }
        } catch (SQLException e) {
            e.printStackTrace();
            log.registrarLog(4, "PessoaDAO", "listarPessoas", "usuario/tipoUsuario", "Erro ao consultar os Usuários");
        }
        return pessoas;
    }

    public List<Pessoa> listarTodasPessoas() throws SQLException {
        List<Pessoa> pessoas = new ArrayList<>();
        String sql = "SELECT us.id, us.nome, us.telefone FROM usuario us";
        try (PreparedStatement stmt = conexaoBanco.prepareStatement(sql)) {
            ResultSet rs = stmt.executeQuery();
            int i= 0;
            while (rs.next()) {
                Pessoa pessoa = new Pessoa(
                    rs.getInt("id"), 
                    rs.getString("nome"), 
                    rs.getString("telefone"));
                pessoas.add(pessoa);
                i++;
                log.registrarLog(2, "PessoaDAO", "listarTodasPessoas", "usuario", "Usuário "+ rs.getString("nome") +" encontrado");
            }
            if (i > 0) {
                log.registrarLog(2, "PessoaDAO", "listarTodasPessoas", "usuario", "Foram encontrados "+ i +" usuários");
            } else {
                log.registrarLog(3, "PessoaDAO", "listarTodasPessoas", "usuario", "Nenhum usuário encontrado");   
            }
        } catch (SQLException e) {
            e.printStackTrace();
            log.registrarLog(4, "PessoaDAO", "listarTodasPessoas", "usuario", "Erro ao consultar os Usuários");
        }
        return pessoas;
    }
    
    public boolean alterarPessoa(Pessoa pessoa) throws SQLException {
        String sql = "UPDATE usuario SET nome = ?, local = ?, tipoPessoa = ?, identificacao = ?, telefone = ?, endereco = ?, email = ?, observacao = ? WHERE id = ?;";
        try (PreparedStatement stmt = conexaoBanco.prepareStatement(sql)) {
            stmt.setString(1, pessoa.getNome());
            if (pessoa.getLocal() != null) {
                stmt.setString(2, pessoa.getLocal().toString());
            } else {
                stmt.setString(2, null);
            }
            if (pessoa.getTipoPessoa()!= null) {
                stmt.setString(3, pessoa.getTipoPessoa().toString());
            } else {
                stmt.setString(3, null);
            }
            stmt.setString(4, pessoa.getIdentificacao());
            stmt.setString(5, pessoa.getTelefone());
            stmt.setInt(6, pessoa.getEnderecoId());
            stmt.setString(7, pessoa.getEmail());
            stmt.setString(8, pessoa.getObservacao());
            stmt.setInt(9, pessoa.getId());
            boolean sucesso = stmt.executeUpdate() == 1;
            if (sucesso) {
                log.registrarLog(2, "PessoaDAO", "alterarPessoa", "usuario", "Sucesso ao alterar usuário");
            } else {
                log.registrarLog(3, "PessoaDAO", "alterarPessoa", "usuario", "Usuário não encontrado");   
            }
        } catch (SQLException e) {
            e.printStackTrace();
            log.registrarLog(4, "PessoaDAO", "alterarPessoa", "usuario", "Erro ao alterar os dados do usuário");
        }
        return false;
    }
    
    public List<Pessoa> listarPessoas(String sqlFiltro, List<Object> filtros) throws SQLException {
        StringBuilder sql = new StringBuilder();
        sql.append("SELECT u.id AS codigo_pessoa, u.nome AS nome_pessoa, CONCAT(c.nome, '/', c.uf) AS cidade, u.observacao ");
        sql.append("FROM usuario u ");
        sql.append("JOIN endereco e ON u.endereco = e.id ");
        sql.append("JOIN cidade c ON e.cidade = c.id ");
        sql.append("JOIN usuarioTipo ut ON ut.usuario = u.id ");
        sql.append("JOIN tipoUsuario tu ON ut.tipoUsuario = tu.id ");
        sql.append("WHERE 1=1 ");
        sql.append(sqlFiltro);
        sql.append("ORDER BY u.nome ASC ");

        try (PreparedStatement stmt = conexaoBanco.prepareStatement(sql.toString())) {
            for (int i = 0; i < filtros.size(); i++) {
                stmt.setObject(i + 1, filtros.get(i));
            }

            ResultSet rs = stmt.executeQuery();
            List<Pessoa> pessoas = new ArrayList<>();
            int qtdPessoas= 0;

            while (rs.next()) {
                Pessoa pessoa = new Pessoa();
                pessoa.setId(rs.getInt("codigo_pessoa"));
                pessoa.setNome(rs.getString("nome_pessoa"));
                pessoa.setCidadeCompleta(rs.getString("cidade"));
                pessoa.setObservacao(rs.getString("observacao"));
                qtdPessoas ++;
                pessoas.add(pessoa);
            }
            if (!pessoas.isEmpty()) {
                log.registrarLog(2, "PessoaDAO", "consultarPessoas", "usuario, endereco, cidade", "Pessoas listadas - foram encontrados "+ qtdPessoas +" registros");    
            } else {
                log.registrarLog(3, "PessoaDAO", "consultarPessoas", "usuario, endereco, cidade", "Não foram encontrados registros");
            }
            return pessoas;

        } catch (SQLException e) {
            e.printStackTrace();
            log.registrarLog(4, "PessoaDAO", "consultarPessoas", "usuario, endereco, cidade", "Erro ao consultar as pessoas");
            return null;
        }
    }
}