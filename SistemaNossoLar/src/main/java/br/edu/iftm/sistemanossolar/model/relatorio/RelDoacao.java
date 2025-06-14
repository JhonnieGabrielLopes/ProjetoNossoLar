package br.edu.iftm.sistemanossolar.model.relatorio;

import java.time.LocalDate;

public class RelDoacao {
    private Integer idDoacao;
    private Integer idDoador;
    private String nomeDoador;
    private String tipo;
    private Double valor;
    private String produtos;
    private String observacao;
    private LocalDate data;
    private Double totalValor;
    private Double totalProdutos;
    private Double totalItens;

    public RelDoacao() {
    }

    public Integer getIdDoacao() {
        return idDoacao;
    }

    public void setIdDoacao(Integer idDoacao) {
        this.idDoacao = idDoacao;
    }

    public Integer getIdDoador() {
        return idDoador;
    }

    public void setIdDoador(Integer idDoador) {
        this.idDoador = idDoador;
    }

    public String getNomeDoador() {
        return nomeDoador;
    }

    public void setNomeDoador(String nomeDoador) {
        this.nomeDoador = nomeDoador;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public Double getValor() {
        return valor;
    }

    public void setValor(Double valor) {
        this.valor = valor;
    }

    public String getProdutos() {
        return produtos;
    }

    public void setProdutos(String produtos) {
        this.produtos = produtos;
    }

    public String getObservacao() {
        return observacao;
    }

    public void setObservacao(String observacao) {
        this.observacao = observacao;
    }

    public LocalDate getData() {
        return data;
    }

    public void setData(LocalDate data) {
        this.data = data;
    }

    public Double getTotalValor() {
        return totalValor;
    }

    public void setTotalValor(Double totalValor) {
        this.totalValor = totalValor;
    }

    public Double getTotalProdutos() {
        return totalProdutos;
    }

    public void setTotalProdutos(Double totalProdutos) {
        this.totalProdutos = totalProdutos;
    }

    public Double getTotalItens() {
        return totalItens;
    }

    public void setTotalItens(Double totalItens) {
        this.totalItens = totalItens;
    }

    

}
