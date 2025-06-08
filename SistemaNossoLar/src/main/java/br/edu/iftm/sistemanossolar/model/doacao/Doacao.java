package br.edu.iftm.sistemanossolar.model.doacao;

import java.time.LocalDate;
import java.util.List;

import br.edu.iftm.sistemanossolar.model.pessoa.Pessoa;

public class Doacao {
    private Integer id;
    private Pessoa doador;
    private List<Produto> produto;
    private TipoDoa tipo;
    private LocalDate dataDoacao;
    private String observacao;
    private Double valor;
    private byte[] anexo;

    public enum TipoDoa {
        DINHEIRO,
        PRODUTO,;
        public static TipoDoa fromString(String opcao) {
            if (opcao==null) 
                return null;
            try {
                return TipoDoa.valueOf(opcao.toUpperCase());
            } catch (IllegalArgumentException e) {
                return null;
            }
        }
    }

    public Doacao() {
    }

    public Doacao(Pessoa doador, TipoDoa tipo, LocalDate dataDoacao) {
        this.doador = doador;
        this.tipo = tipo;
        this.dataDoacao = dataDoacao;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Pessoa getDoador() {
        return doador;
    }

    public void setDoador(Pessoa doador) {
        this.doador = doador;
    }

    public List<Produto> getProduto() {
        return produto;
    }

    public void setProduto(List<Produto> produto) {
        this.produto = produto;
    }

    public TipoDoa getTipo() {
        return tipo;
    }

    public void setTipo(TipoDoa tipo) {
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