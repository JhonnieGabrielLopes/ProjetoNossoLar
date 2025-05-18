package br.edu.iftm.sistemanossolar.controller.endereco;

import java.sql.Connection;
import java.sql.SQLException;

import br.edu.iftm.sistemanossolar.dao.endereco.EnderecoDAO;
import br.edu.iftm.sistemanossolar.model.endereco.Cidade;
import br.edu.iftm.sistemanossolar.model.endereco.Endereco;

public class EnderecoController {
    private EnderecoDAO enderecoDAO;

    public EnderecoController(Connection conexao) {
        this.enderecoDAO = new EnderecoDAO(conexao);
    }

    public boolean cadastrarEndereco(Endereco novoEndereco, Cidade cidadeTemp) throws SQLException {
        return enderecoDAO.cadastrarEndereco(novoEndereco, cidadeTemp);
    }

    public Integer buscarIdEndereco(int idCidade) throws SQLException {
        return enderecoDAO.buscarIdEndereco(idCidade);
    }

}