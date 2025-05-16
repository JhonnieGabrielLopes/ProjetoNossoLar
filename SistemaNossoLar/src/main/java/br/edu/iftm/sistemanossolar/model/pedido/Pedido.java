package br.edu.iftm.sistemanossolar.model.pedido;

import java.time.LocalDate;

import br.edu.iftm.sistemanossolar.model.pessoa.cliente.Cliente;

public class Pedido {
    private Cliente cliente;
    private Integer quantMarmita;
    private boolean status;
    private String observacao;
    private LocalDate dataEntrega;

    public Pedido(Cliente cliente, Integer quantMarmita, boolean status) {
        this.cliente = cliente;
        this.quantMarmita = quantMarmita;
        this.status = false;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    public Integer getQuantMarmita() {
        return quantMarmita;
    }

    public void setQuantMarmita(Integer quantMarmita) {
        this.quantMarmita = quantMarmita;
    }

    public boolean isStatus() {
        return status;
    }

    public void setStatus(boolean status) {
        this.status = status;
    }

    public String getObservacao() {
        return observacao;
    }

    public void setObservacao(String observacao) {
        this.observacao = observacao;
    }

    public LocalDate getDataEntrega() {
        return dataEntrega;
    }

    public void setDataEntrega(LocalDate dataEntrega) {
        this.dataEntrega = dataEntrega;
    }

}