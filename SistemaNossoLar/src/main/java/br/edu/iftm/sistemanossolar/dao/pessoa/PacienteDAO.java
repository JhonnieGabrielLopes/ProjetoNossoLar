package br.edu.iftm.sistemanossolar.dao.pessoa;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import br.edu.iftm.sistemanossolar.model.pessoa.Paciente;
import br.edu.iftm.sistemanossolar.view.RegistrosLog;

public class PacienteDAO {
    private final Connection conexaoBanco;

    RegistrosLog log = new RegistrosLog();

    public PacienteDAO(Connection conexao) {
        this.conexaoBanco = conexao;
    }

    public boolean cadastrarPaciente(Paciente paciente, int idUsu) {
        String sql = "INSERT INTO paciente (usuario, nome, previsaodias) VALUES (?, ?, ?)";
        try (PreparedStatement stmt = conexaoBanco.prepareStatement(sql, PreparedStatement.RETURN_GENERATED_KEYS)) {
            stmt.setInt(1, idUsu);
            if (paciente.getNome() == null || paciente.getNome().equals("")) {
                stmt.setNull(2, java.sql.Types.VARCHAR);
            } else {
                stmt.setString(2, paciente.getNome());
            }
            if (paciente.getPrevisaoDias() == null || paciente.getPrevisaoDias() == 0) {
                stmt.setNull(3, java.sql.Types.INTEGER);
            } else {
                stmt.setInt(3, paciente.getPrevisaoDias());
            }
            stmt.executeUpdate();
            log.registrarLog(2, "PacienteDAO", "cadastrarPaciente", "paciente", "Paciente cadastrado");
            return true;
        } catch (SQLException e) {
            e.printStackTrace();
            log.registrarLog(4, "PacienteDAO", "cadastrarPaciente", "paciente", "Paciente não cadastrado");            
            return false;
        }
    }

    public Paciente buscarPacienteDoBeneficiario(int idUsuario) {
        String sql = "SELECT id, nome, previsaoDias FROM paciente WHERE usuario = ?";
        try (PreparedStatement stmt = conexaoBanco.prepareStatement(sql)) {
            stmt.setInt(1, idUsuario);
            ResultSet rs = stmt.executeQuery();
            if (rs.next()) {
                log.registrarLog(2, "PessoaDAO", "buscarPessoaPorId", "paciente", "Dados do Paciente obtidos");
                return new Paciente(
                    rs.getInt("id"),
                    rs.getString("nome"),
                    rs.getInt("previsaoDias"));
            } else {
                log.registrarLog(3, "PessoaDAO", "buscarPessoaPorId", "paciente", "Dados do Paciente não encontrados");
                return new Paciente();
            }
        } catch (SQLException e) {
            e.printStackTrace();
            log.registrarLog(4, "PessoaDAO", "buscarPessoaPorId", "paciente", "Dados do Paciente não obtidos");
            return new Paciente();
        }
    }
}