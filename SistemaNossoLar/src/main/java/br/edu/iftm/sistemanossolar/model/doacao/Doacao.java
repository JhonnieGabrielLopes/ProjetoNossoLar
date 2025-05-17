package br.edu.iftm.sistemanossolar.model.doacao;

import java.time.LocalDate;

import br.edu.iftm.sistemanossolar.model.pessoa.Doador;
import br.edu.iftm.sistemanossolar.model.pessoa.Tipo;

public class Doacao {
    private Doador doador;
    private Produto produto;
    private Tipo tipo;
    private LocalDate dataDoacao;
    private String observacao;
    private Double valor;
    private byte[] anexo;

    public Doacao(Doador doador, Tipo tipo, LocalDate dataDoacao) {
        this.doador = doador;
        this.tipo = tipo;
        this.dataDoacao = dataDoacao;
    }

    public Doador getDoador() {
        return doador;
    }

    public void setDoador(Doador doador) {
        this.doador = doador;
    }

    public Produto getProduto() {
        return produto;
    }

    public void setProduto(Produto produto) {
        this.produto = produto;
    }

    public Tipo getTipo() {
        return tipo;
    }

    public void setTipo(Tipo tipo) {
        this.tipo = tipo;
    }

    public LocalDate getDataDoacao() {
        return dataDoacao;
    }

    public void setDataDoacao(LocalDate dataDoacao) {
        this.dataDoacao = dataDoacao;
    }

    public String getObservacao() {
        return observacao;
    }

    public void setObservacao(String observacao) {
        this.observacao = observacao;
    }

    public byte[] getAnexo() {
        return anexo;
    }

    public void setAnexo(byte[] anexo) {
        this.anexo = anexo;
    }

    public Double getValor() {
        return valor;
    }

    public void setValor(Double valor) {
        this.valor = valor;
    }

}