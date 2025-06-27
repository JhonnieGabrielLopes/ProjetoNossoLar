package br.edu.iftm.sistemanossolar.model.relatorio;

import java.util.List;

public class RetornoPedidos {
    private List<RelPedido> pedidos;
    private RelPedido totalizacao;
    private List<Object> filtros;

    public RetornoPedidos(List<RelPedido> pedidos, RelPedido totalizacao, List<Object> filtros) {
        this.pedidos = pedidos;
        this.totalizacao = totalizacao;
        this.filtros = filtros;
    }

    public List<RelPedido> getPedidos() {
        return pedidos;
    }
    public void setPedidos(List<RelPedido> pedidos) {
        this.pedidos = pedidos;
    }
    public RelPedido getTotalizacao() {
        return totalizacao;
    }
    public void setTotalizacao(RelPedido totalizacao) {
        this.totalizacao = totalizacao;
    }
    public List<Object> getFiltros() {
        return filtros;
    }
    public void setFiltros(List<Object> filtros) {
        this.filtros = filtros;
    }
    
}