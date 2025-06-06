package br.edu.iftm.sistemanossolar.model.pedido;

import java.time.LocalDate;

import br.edu.iftm.sistemanossolar.model.pessoa.Pessoa;

public class Pedido {
    private Integer id;
    private Pessoa cliente;
    private Integer quantMarmita;
    private StatusPedido status;
    private String observacao;
    private LocalDate dataPedido;
    private LocalDate dataEntrega;

    public Pedido(Pessoa cliente, Integer quantMarmita, StatusPedido status, LocalDate dataPedido) {
        this.cliente = cliente;
        this.quantMarmita = quantMarmita;
        this.status = status;
        this.dataPedido = dataPedido;
    }

    public enum StatusPedido {
        PENDENTE, 
        FINALIZADO, 
        CANCELADO;
        public static StatusPedido fromString(String status) {
            for (StatusPedido s : StatusPedido.values()) {
                if (s.name().equalsIgnoreCase(status)) {
                    return s;
                }
            }
            throw new IllegalArgumentException("Status inválido: " + status);
        }
    }

    public Pessoa getCliente() {
        return cliente;
    }

    public void setCliente(Pessoa cliente) {
        this.cliente = cliente;
    }

    public Integer getQuantMarmita() {
        return quantMarmita;
    }

    public void setQuantMarmita(Integer quantMarmita) {
        this.quantMarmita = quantMarmita;
    }

    public StatusPedido getStatus() {
        return status;
    }

    public void setStatus(StatusPedido status) {
        this.status = status;
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

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

}