package br.edu.iftm.sistemanossolar.controller.pessoa;

import java.sql.Connection;
import java.sql.SQLException;

import br.edu.iftm.sistemanossolar.dao.pessoa.PacienteDAO;
import br.edu.iftm.sistemanossolar.model.pessoa.Paciente;
import br.edu.iftm.sistemanossolar.view.RegistrosLog;

public class PacienteController {
    private PacienteDAO pacienteDAO;

    RegistrosLog log = new RegistrosLog();

    public PacienteController(Connection conexao) {
        this.pacienteDAO = new PacienteDAO(conexao);
    }

    public boolean cadastrarPaciente(Paciente paciente, int idUsu) throws SQLException {
        return pacienteDAO.cadastrarPaciente(paciente, idUsu);
    }

    public Paciente buscarPacienteDoBeneficiario(int idUsuario) throws SQLException {
        log.registrarLog(1, "PacienteController", "buscarPacienteDoBeneficiario", "paciente", "Buscando Dados do Paciente vinculado ao Beneficiário");
        return pacienteDAO.buscarPacienteDoBeneficiario(idUsuario);
    }

}
