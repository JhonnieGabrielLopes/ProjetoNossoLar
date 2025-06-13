package br.edu.iftm.sistemanossolar.model.relatorio;


import java.util.List;

public class RetornoDoacoes {
    private List<RelDoacao> doacoes;
    private RelDoacao totalizacao;

    public RetornoDoacoes(List<RelDoacao> doacaos, RelDoacao totalizacao) {
        this.doacoes = doacaos;
        this.totalizacao = totalizacao;
    }

    public List<RelDoacao> getDoacoes() {
        return doacoes;
    }

    public void setDoacoes(List<RelDoacao> doacoes) {
        this.doacoes = doacoes;
    }

    public RelDoacao getTotalizacao() {
        return totalizacao;
    }

    public void setTotalizacao(RelDoacao totalizacao) {
        this.totalizacao = totalizacao;
    }

}