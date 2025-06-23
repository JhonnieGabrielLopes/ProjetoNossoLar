package br.edu.iftm.sistemanossolar.dao.endereco;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import br.edu.iftm.sistemanossolar.model.endereco.Cidade;
import br.edu.iftm.sistemanossolar.model.endereco.Endereco;
import br.edu.iftm.sistemanossolar.view.RegistrosLog;

public class EnderecoDAO {

    private final Connection conexaoBanco;

    RegistrosLog log = new RegistrosLog();

    public EnderecoDAO(Connection conexao) {
        this.conexaoBanco = conexao;
    }

    public boolean cadastrarEndereco(int controle, Endereco endereco, Cidade cidadeTemp, int idCidade) throws SQLException {
        if (controle == 0) {
            String sql = "INSERT INTO endereco (cidade, cep, logradouro, numero, bairro, complemento) VALUES (?, ?, ?, ?, ?, ?)";
            try (PreparedStatement stmt = conexaoBanco.prepareStatement(sql)) {
                stmt.setInt(1, idCidade);

                if (endereco.getCep() == null || endereco.getCep().isEmpty()) {
                    stmt.setNull(2, java.sql.Types.VARCHAR);
                } else {
                    stmt.setString(2, endereco.getCep());
                }

                if (endereco.getLogradouro() == null || endereco.getLogradouro().isEmpty()) {
                    stmt.setNull(3, java.sql.Types.VARCHAR);
                } else {
                    stmt.setString(3, endereco.getLogradouro());
                }

                if (endereco.getNumero() == 0) {
                    stmt.setNull(4, java.sql.Types.INTEGER);
                } else {
                    stmt.setInt(4, endereco.getNumero());
                }

                if (endereco.getBairro() == null || endereco.getBairro().isEmpty()) {
                    stmt.setNull(5, java.sql.Types.VARCHAR);
                } else {
                    stmt.setString(5, endereco.getBairro());
                }

                if (endereco.getComplemento() == null || endereco.getComplemento().isEmpty()) {
                    stmt.setNull(6, java.sql.Types.VARCHAR);
                } else {
                    stmt.setString(6, endereco.getComplemento());
                }

                stmt.executeUpdate();
                log.registrarLog(2, "EnderecoDAO", "cadastrarEndereco", "endereco", "Endereço cadastrado");
                return true;
            } catch (Exception e) {
                e.printStackTrace();
                log.registrarLog(4, "EnderecoDAO", "cadastrarEndereco", "endereco", "Endereço não cadastrado");
                return false;
            }
        } else {
            log.registrarLog(3, "EnderecoDAO", "cadastrarEndereco", "endereco", "Atribuido o Endereço da Cidade");
            return true;
        }

    }

    public Integer buscarIdEndereco(String sql, int idCidade) throws SQLException {
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
            e.printStackTrace();
            log.registrarLog(4, "EnderecoDAO", "buscarIdEndereco", "endereco", "Erro ao buscar ID do Endereço");
            return null;
        }
    }

    public Endereco buscarEndereco(int idEndereco) throws SQLException {
        String sql = "SELECT e.id, cep, logradouro, numero, bairro, complemento, nome, uf FROM endereco e LEFT JOIN cidade c on c.id = e.cidade where e.id = ?;";
        try (PreparedStatement stmt = conexaoBanco.prepareStatement(sql)) {
            stmt.setInt(1, idEndereco);
            ResultSet rs = stmt.executeQuery();
            if (rs.next()) {
                log.registrarLog(2, "EnderecoDAO", "buscarIdEndereco", "endereco", "ID do Endereço encontrado");
                return new Endereco(rs.getString("logradouro"), rs.getInt("numero"), rs.getString("bairro"), rs.getString("cep"), rs.getString("complemento"), new Cidade(rs.getString("nome"), rs.getString("uf")));
            } else {
                log.registrarLog(3, "EnderecoDAO", "buscarIdEndereco", "endereco", "ID do Endereço não encontrado");
                return null;
            }
        } catch (Exception e) {
            e.printStackTrace();
            log.registrarLog(4, "EnderecoDAO", "buscarIdEndereco", "endereco", "Erro ao buscar ID do Endereço");
            return null;
        }
    }

    public boolean alterarEndereco(Endereco endereco, Integer idEndereco, int idCidade) throws SQLException {
        String sql = "UPDATE endereco SET cidade = ?, cep = ?, logradouro = ?, numero = ?, bairro = ?, complemento = ? WHERE id = ?;";
        try (PreparedStatement stmt = conexaoBanco.prepareStatement(sql)) {
            stmt.setInt(1, idCidade);

            if (endereco.getCep() != null) {
                stmt.setString(2, endereco.getCep());
            } else {
                stmt.setNull(2, java.sql.Types.VARCHAR);
            }

            if (endereco.getLogradouro() != null) {
                stmt.setString(3, endereco.getLogradouro());
            } else {
                stmt.setNull(3, java.sql.Types.VARCHAR);
            }

            if (endereco.getNumero() != 0) {
                stmt.setInt(4, endereco.getNumero());
            } else {
                stmt.setNull(4, java.sql.Types.VARCHAR);
            }

            if (endereco.getBairro() != null) {
                stmt.setString(5, endereco.getBairro());
            } else {
                stmt.setNull(5, java.sql.Types.VARCHAR);
            }

            if (endereco.getComplemento() != null) {
                stmt.setString(6, endereco.getComplemento());
            } else {
                stmt.setNull(6, java.sql.Types.VARCHAR);
            }

            stmt.setInt(7, idEndereco);

            int linhasAfetadas = stmt.executeUpdate();
            return linhasAfetadas == 1;
            
        } catch (SQLException e) {
            e.printStackTrace();
            log.registrarLog(4, "PessoaDAO", "alterarPessoa", "usuario", "Erro ao alterar os dados do usuário");
            return false;
        }
    }
}
