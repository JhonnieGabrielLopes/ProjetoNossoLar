package br.edu.iftm.sistemanossolar.controller.pessoa;

import java.sql.Connection;
import java.sql.SQLException;

import br.edu.iftm.sistemanossolar.dao.pessoa.TipoDAO;

public class TipoController {
    private TipoDAO tipoDAO;

    public TipoController(Connection conexao) {
        this.tipoDAO = new TipoDAO(conexao);
    }

    public boolean cadastrarTipo(String tipo, String tabela)  throws SQLException {
        tipo= tipo.substring(0, 1).toUpperCase() + tipo.substring(1).toLowerCase();
        return tipoDAO.cadastrarTipo(tipo, tabela);

    }

    public boolean existeTipo(String tipo, String tabela)  throws SQLException {
        String tipoConvert = tipo.substring(0, 1).toUpperCase() + tipo.substring(1).toLowerCase();
        return tipoDAO.existeTipo(tipoConvert, tabela);
    }

    public Integer buscarIdTipo(String tipo, String tabela)  throws SQLException {
        String tipoConvert = tipo.substring(0, 1).toUpperCase() + tipo.substring(1).toLowerCase();
        return tipoDAO.buscarIdTipo(tipoConvert, tabela);
    }
    
}