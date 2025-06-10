package br.edu.iftm.sistemanossolar.controller.endereco;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

import br.edu.iftm.sistemanossolar.dao.endereco.CidadeDAO;
import br.edu.iftm.sistemanossolar.model.endereco.Cidade;
import br.edu.iftm.sistemanossolar.view.RegistrosLog;

public class CidadeController {
    private CidadeDAO cidadeDAO;

    RegistrosLog log = new RegistrosLog();
    
    public CidadeController(Connection conexao) {
        this.cidadeDAO = new CidadeDAO(conexao);
    }

    public boolean existeCidade(Cidade cidade) throws SQLException {
        log.registrarLog(1, "CidadeController", "existeCidade", "cidade", "Verificando se a cidade "+ cidade.getNome() +"/"+ cidade.getEstado() +" existe");
        return cidadeDAO.existeCidade(cidade);
    }

    public boolean cadastrarCidade(Cidade novaCidade) throws SQLException {
        log.registrarLog(1, "CidadeController", "cadastrarCidade", "cidade", "Cadastrando a cidade "+ novaCidade.getNome() +"/"+ novaCidade.getEstado());
        return cidadeDAO.cadastrarCidade(novaCidade);
    }

    public Integer buscarIdCidade(Cidade cidade) throws SQLException {
        log.registrarLog(1, "CidadeController", "buscarIdCidade", "cidade", "Buscando o ID da cidade "+ cidade.getNome() +"/"+ cidade.getEstado());
        return cidadeDAO.buscarIdCidade(cidade);
    }
    
    public List<Cidade> listarCidade() throws SQLException {
        log.registrarLog(1, "CidadeController", "listarCidade", "cidade", "Consultando cidades");
        return cidadeDAO.listarCidade();
    }
}