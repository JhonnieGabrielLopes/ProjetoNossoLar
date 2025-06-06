package br.edu.iftm.sistemanossolar.controller.pessoa;

import java.sql.Connection;
import java.sql.SQLException;

import br.edu.iftm.sistemanossolar.dao.pessoa.PacienteDAO;
import br.edu.iftm.sistemanossolar.model.pessoa.Paciente;

public class PacienteController {
private PacienteDAO pacienteDAO;

    public PacienteController(Connection conexao) {
        this.pacienteDAO = new PacienteDAO(conexao);
    }

    public boolean cadastrarPaciente(Paciente paciente, int idUsu) throws SQLException {
        return pacienteDAO.cadastrarPaciente(paciente, idUsu);
    }

}
