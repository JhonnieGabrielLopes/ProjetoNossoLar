package br.edu.iftm.sistemanossolar.dao.pessoa;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import br.edu.iftm.sistemanossolar.model.pessoa.Paciente;
import br.edu.iftm.sistemanossolar.view.RegistrosLog;

public class PacienteDAO {
    private final Connection conexaoBanco;

    RegistrosLog log = new RegistrosLog();

    public PacienteDAO(Connection conexao) {
        this.conexaoBanco = conexao;
    }

        public boolean cadastrarPaciente(Paciente paciente, int idUsu) throws SQLException {
        log.registrarLog(1, "PacienteDAO", "cadastrarPaciente", "paciente", "Cadastrando o Paciente "+ paciente.getNome());

        String sql = "INSERT INTO paciente (usuario, local, nome, previsaodias) VALUES (?, ?, ?, ?)";
        try (PreparedStatement stmt = conexaoBanco.prepareStatement(sql, PreparedStatement.RETURN_GENERATED_KEYS)) {
            stmt.setInt(1, idUsu);
            stmt.setString(2, paciente.getLocal().name());
            stmt.setString(3, paciente.getNome());
            stmt.setInt(4, paciente.getPrevisaoDias());
            stmt.executeUpdate();
            log.registrarLog(2, "PacienteDAO", "cadastrarPaciente", "paciente", "Paciente cadastrado");
            return true;

        } catch (Exception e) {
            log.registrarLog(4, "PacienteDAO", "cadastrarPaciente", "paciente", "Paciente não cadastrado");
            e.printStackTrace();
            return false;
        }
    }

}