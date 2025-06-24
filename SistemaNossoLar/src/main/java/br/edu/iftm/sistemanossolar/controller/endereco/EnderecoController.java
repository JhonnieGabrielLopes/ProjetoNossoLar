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
        if (novoEndereco.getLogradouro() == null || novoEndereco.getNumero() == 0 || novoEndereco.getCep() == null || novoEndereco.getComplemento() == null || novoEndereco.getBairro() == null) {
            controle = 1;
        }
        return enderecoDAO.cadastrarEndereco(controle, novoEndereco, cidadeTemp, cidadeController.buscarIdCidade(cidadeTemp));
    }

    public Integer buscarIdEndereco(Endereco endereco, int idCidade) throws SQLException {
        log.registrarLog(1, "EnderecoController", "buscarIdEndereco", "endereco", "Buscando o ID do Endereço");
        if (endereco.getLogradouro() == null || endereco.getNumero() == 0 || endereco.getCep() == null || endereco.getComplemento() == null || endereco.getBairro() == null) {
            return enderecoDAO.buscarIdEndereco("SELECT * FROM endereco WHERE cidade = ? ORDER BY id ASC LIMIT 1", idCidade);
        } else {
            return enderecoDAO.buscarIdEndereco("SELECT * FROM endereco WHERE cidade = ? ORDER BY id DESC LIMIT 1", idCidade);
        }
    }
    
    public Endereco buscarEndereco(int idEndereco) throws SQLException {
        log.registrarLog(1, "EnderecoController", "buscarEndereco", "endereco", "Buscando o endereco");
        return enderecoDAO.buscarEndereco(idEndereco);
    }
    
    public boolean alterarEndereco(Endereco novoEndereco, int idEnderecoAntigo) throws SQLException {
        log.registrarLog(1, "EnderecoController", "alterarEndereco", "endereco", "Alterando endereço.");
        int idCidade = cidadeController.buscarIdCidade(novoEndereco.getCidade());
        if (novoEndereco.getLogradouro() == null || novoEndereco.getNumero() == 0 || novoEndereco.getCep() == null || novoEndereco.getComplemento() == null || novoEndereco.getBairro() == null) {
            return true;
        }
        Endereco enderecoVelho = buscarEndereco(idEnderecoAntigo);
        if (enderecoVelho.getLogradouro() == null || enderecoVelho.getNumero() == 0 || enderecoVelho.getCep() == null || enderecoVelho.getComplemento() == null || enderecoVelho.getBairro() == null) {
            return cadastrarEndereco(novoEndereco, novoEndereco.getCidade());
        }
        return enderecoDAO.alterarEndereco(novoEndereco, idEnderecoAntigo, idCidade);
    }

}