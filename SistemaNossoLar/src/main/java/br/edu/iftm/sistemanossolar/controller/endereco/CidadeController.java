package br.edu.iftm.sistemanossolar.controller.endereco;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

import br.edu.iftm.sistemanossolar.dao.endereco.CidadeDAO;
import br.edu.iftm.sistemanossolar.model.endereco.Cidade;

public class CidadeController {
    private CidadeDAO cidadeDAO;
    
    public CidadeController(Connection conexao) {
        this.cidadeDAO = new CidadeDAO(conexao);
    }

    public boolean existeCidade(Cidade cidade) throws SQLException {
        return cidadeDAO.existeCidade(cidade);
    }

    public boolean cadastrarCidade(Cidade novaCidade) throws SQLException {
        return cidadeDAO.cadastrarCidade(novaCidade);
    }

    public Integer buscarIdCidade(Cidade cidade) throws SQLException {
        return cidadeDAO.buscarIdCidade(cidade);
    }
    
    public List<Cidade> listarCidade() throws SQLException {
        return cidadeDAO.listarCidade();
    }
}