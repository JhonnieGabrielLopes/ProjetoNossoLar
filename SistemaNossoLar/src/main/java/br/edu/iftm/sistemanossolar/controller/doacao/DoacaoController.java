package br.edu.iftm.sistemanossolar.controller.doacao;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

import br.edu.iftm.sistemanossolar.dao.doacao.DoacaoDAO;
import br.edu.iftm.sistemanossolar.model.doacao.Doacao;
import br.edu.iftm.sistemanossolar.model.relatorio.RelDoacao;

public class DoacaoController {
    private DoacaoDAO doacaoDAO;
    
    public DoacaoController (Connection conexao) {
        this.doacaoDAO = new DoacaoDAO (conexao);
    }

    public boolean cadastrarDoacao(Doacao doacao) throws SQLException {
        return doacaoDAO.cadastrarDoacao(doacao);
    }

    public List<RelDoacao> filtrarRelatorio(Date dataInicio, Date dataFim, String tipoDoacao, Integer doadorId, String ordenacao) throws SQLException {
        return doacaoDAO.filtrarRelatorio(dataInicio, dataFim, tipoDoacao, doadorId, ordenacao);
    }

}