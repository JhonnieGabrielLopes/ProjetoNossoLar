package br.edu.iftm.sistemanossolar.model.pedido;

import java.time.LocalDate;
import java.util.Objects;

import br.edu.iftm.sistemanossolar.model.pessoa.Pessoa;

public class Pedido {
    private Integer id;
    private Pessoa cliente;
    private Integer quantMarmita;
    private StatusPedido status;
    private String observacao;
    private LocalDate dataPedido;
    private LocalDate dataEntrega;

    public Pedido() {
    }

    public Pedido(Pessoa cliente, Integer quantMarmita, StatusPedido status, LocalDate dataPedido) {
        this.cliente = cliente;
        this.quantMarmita = quantMarmita;
        this.status = status;
        this.dataPedido = dataPedido;
    }

    public enum StatusPedido {
        PENDENTE,
        ENTREGUE,
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

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
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

    public boolean camposIguais(Pedido outro) {
        if (outro == null) {
            return false;
        }
        if (!objetosIguais(this.id, outro.getId())) {
            //System.out.println("0 - Objeto comparado é null");
            return false;
        }
        if (!objetosIguais(this.quantMarmita, outro.getQuantMarmita())) {
            //System.out.println("1 - Quantidade de marmitas é diferente");
            return false;
        }
        if (!objetosIguais(this.status, outro.getStatus())) {
            //System.out.println("2 - Status do pedido é diferente");
            return false;
        }
        if (!iguais(this.observacao, outro.getObservacao())) {
            //System.out.println("3 - Observação é diferente");
            return false;
        }
        if (!objetosIguais(this.dataPedido, outro.getDataPedido())) {
            //System.out.println("4 - Data do pedido é diferente");
            return false;
        }
        if (!objetosIguais(this.dataEntrega, outro.getDataEntrega())) {
            //System.out.println("5 - Data de entrega é diferente");
            return false;
        }
        //System.out.println("6 - Campos são iguais");
        return true;
    }

    private boolean iguais(String a, String b) {
        if (a == null && b == null) return true;
        if (a == null || b == null) return false;
        return a.trim().equalsIgnoreCase(b.trim());
    }

    private boolean objetosIguais(Object a, Object b) {
        return Objects.equals(a, b);
    }
}
