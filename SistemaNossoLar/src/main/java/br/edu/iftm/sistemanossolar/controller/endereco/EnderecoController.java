package br.edu.iftm.sistemanossolar.controller.endereco;

import java.sql.Connection;
import java.sql.SQLException;

import br.edu.iftm.sistemanossolar.dao.endereco.EnderecoDAO;
import br.edu.iftm.sistemanossolar.model.endereco.Cidade;
import br.edu.iftm.sistemanossolar.model.endereco.Endereco;
import br.edu.iftm.sistemanossolar.view.RegistrosLog;

public class EnderecoController {
    private EnderecoDAO enderecoDAO;
    private CidadeController cidadeController;

    RegistrosLog log = new RegistrosLog();

    public EnderecoController(Connection conexao) {
        this.enderecoDAO = new EnderecoDAO(conexao);
        this.cidadeController = new CidadeController(conexao);
    }

    public boolean cadastrarEndereco(Endereco novoEndereco, Cidade cidadeTemp) throws SQLException {
        log.registrarLog(1, "EnderecoController", "cadastrarEndereco", "endereco", "Cadastrando o Endereço da Pessoa");
        int controle = 0;
        if (novoEndereco.getLogradouro() == null) {
            controle = 1;
        }
        return enderecoDAO.cadastrarEndereco(controle, novoEndereco, cidadeTemp, cidadeController.buscarIdCidade(cidadeTemp));
    }

    public Integer buscarIdEndereco(Endereco endereco, int idCidade) throws SQLException {
        log.registrarLog(1, "EnderecoController", "buscarIdEndereco", "endereco", "Buscando o ID do Endereço");
        if (endereco.getLogradouro() == null) {
            return enderecoDAO.buscarIdEndereco("SELECT * FROM endereco WHERE cidade = ? ORDER BY id ASC LIMIT 1", idCidade);
        } else {
            return enderecoDAO.buscarIdEndereco("SELECT * FROM endereco WHERE cidade = ? ORDER BY id DESC LIMIT 1", idCidade);
        }
    }

}