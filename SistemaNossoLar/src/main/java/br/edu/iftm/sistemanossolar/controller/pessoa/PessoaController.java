package br.edu.iftm.sistemanossolar.controller.pessoa;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

import br.edu.iftm.sistemanossolar.dao.pessoa.PessoaDAO;
import br.edu.iftm.sistemanossolar.model.pessoa.Pessoa;
import br.edu.iftm.sistemanossolar.model.pessoa.Tipo;

public class PessoaController {
    private PessoaDAO pessoaDAO;

    public PessoaController(Connection conexao) {
        this.pessoaDAO = new PessoaDAO(conexao);
    }

    public boolean cadastrarPessoa(Pessoa pessoa, Tipo tipo) throws SQLException {
        return pessoaDAO.cadastrarPessoa(pessoa, tipo);
    }

    public Pessoa buscarPessoaPorId(int id) throws SQLException {
        return pessoaDAO.buscarPessoaPorId(id);
    }

    public List<Pessoa> listarPessoas(String tipo) throws SQLException {
        return pessoaDAO.listarPessoas(tipo);
    }

}