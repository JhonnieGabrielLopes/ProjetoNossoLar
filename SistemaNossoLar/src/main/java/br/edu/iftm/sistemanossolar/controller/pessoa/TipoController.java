package br.edu.iftm.sistemanossolar.controller.pessoa;

import java.sql.Connection;
import java.sql.SQLException;

import br.edu.iftm.sistemanossolar.dao.pessoa.TipoDAO;
import br.edu.iftm.sistemanossolar.view.RegistrosLog;

public class TipoController {
    private TipoDAO tipoDAO;

    RegistrosLog log = new RegistrosLog();

    public TipoController(Connection conexao) {
        this.tipoDAO = new TipoDAO(conexao);
    }

    public Integer buscarIdTipo(String tipo, String tabela)  throws SQLException {
        tipo = tipo.substring(0, 1).toUpperCase() + tipo.substring(1).toLowerCase();
        log.registrarLog(1, "TipoDAO", "buscarIdTipo", tabela, "Buscando o ID do Tipo "+tipo);
        return tipoDAO.buscarIdTipo(tipo, tabela);
    }
    
}