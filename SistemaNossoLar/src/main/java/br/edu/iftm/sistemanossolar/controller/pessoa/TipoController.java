package br.edu.iftm.sistemanossolar.controller.pessoa;

import java.sql.Connection;
import java.sql.SQLException;

import br.edu.iftm.sistemanossolar.dao.pessoa.TipoDAO;
import br.edu.iftm.sistemanossolar.model.pessoa.Tipo;

public class TipoController {
    private TipoDAO tipoDAO;

    public TipoController(Connection conexao) {
        this.tipoDAO = new TipoDAO(conexao);
    }

    public boolean cadastrarTipo(Tipo tipo)  throws SQLException {
        String tipoConvert = tipo.getDescricao();
        tipoConvert= tipoConvert.substring(0, 1).toUpperCase() + tipoConvert.substring(1).toLowerCase();
        return tipoDAO.cadastrarTipo(tipoConvert);
    }

    public boolean existeTipo(String tipo)  throws SQLException {
        String tipoConvert = tipo.substring(0, 1).toUpperCase() + tipo.substring(1).toLowerCase();
        return tipoDAO.existeTipo(tipoConvert);
    }

    public Integer buscarIdTipo(String tipo)  throws SQLException {
        String tipoConvert = tipo.substring(0, 1).toUpperCase() + tipo.substring(1).toLowerCase();
        return tipoDAO.buscarIdTipo(tipoConvert);
    }
    
}