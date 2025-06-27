package br.edu.iftm.sistemanossolar.model.relatorio;

import java.time.LocalDate;

public class RelPedido {
    private Integer idPedido;
    private Integer idCliente;
    private String status;
    private String nomeCliente;
    private String cidadeCliente;
    private Integer qtdMarmitas;
    private String local;
    private String observacao;
    private LocalDate dataPedido;
    private LocalDate dataEntrega;
    private Integer totalMarmitas;
    private Integer totalPendente;
    private Integer totalFechado;
    private Integer totalCancelado;

    public RelPedido() {
    }

    public Integer getIdPedido() {
        return idPedido;
    }

    public void setIdPedido(Integer idPedido) {
        this.idPedido = idPedido;
    }

    public Integer getIdCliente() {
        return idCliente;
    }

    public void setIdCliente(Integer idCliente) {
        this.idCliente = idCliente;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getNomeCliente() {
        return nomeCliente;
    }

    public void setNomeCliente(String nomeCliente) {
        this.nomeCliente = nomeCliente;
    }

    public String getCidadeCliente() {
        return cidadeCliente;
    }

    public void setCidadeCliente(String cidadeCliente) {
        this.cidadeCliente = cidadeCliente;
    }

    public Integer getQtdMarmitas() {
        return qtdMarmitas;
    }

    public void setQtdMarmitas(Integer qtdMarmitas) {
        this.qtdMarmitas = qtdMarmitas;
    }

    public String getLocal() {
        return local;
    }

    public void setLocal(String local) {
        this.local = local;
    }

    public String getObservacao() {
        return observacao;
    }

    public void setObservacao(String observacao) {
        this.observacao = observacao;
    }

    public LocalDate getDataPedido() {
        return dataPedido;
    }

    public void setDataPedido(LocalDate dataPedido) {
        this.dataPedido = dataPedido;
    }

    public LocalDate getDataEntrega() {
        return dataEntrega;
    }

    public void setDataEntrega(LocalDate dataEntrega) {
        this.dataEntrega = dataEntrega;
    }

    public Integer getTotalMarmitas() {
        return totalMarmitas;
    }

    public void setTotalMarmitas(Integer totalMarmitas) {
        this.totalMarmitas = totalMarmitas;
    }

    public Integer getTotalPendente() {
        return totalPendente;
    }

    public void setTotalPendente(Integer totalPendente) {
        this.totalPendente = totalPendente;
    }

    public Integer getTotalFechado() {
        return totalFechado;
    }

    public void setTotalFechado(Integer totalFechado) {
        this.totalFechado = totalFechado;
    }

    public Integer getTotalCancelado() {
        return totalCancelado;
    }

    public void setTotalCancelado(Integer totalCancelado) {
        this.totalCancelado = totalCancelado;
    }

}