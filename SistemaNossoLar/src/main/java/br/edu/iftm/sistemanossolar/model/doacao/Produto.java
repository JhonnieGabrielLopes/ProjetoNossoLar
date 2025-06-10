package br.edu.iftm.sistemanossolar.model.doacao;

public class Produto {
    private Integer id;
    private String nome;
    private Integer quantidade;
    private TipoProd tipo;

    public enum TipoProd {
        ALIMENTO,
        LIMPEZA,
        OUTRO,;
        public static TipoProd fromString(String opcao) {
            if (opcao==null) 
                return null;
            try {
                return TipoProd.valueOf(opcao.toUpperCase());
            } catch (IllegalArgumentException e) {
                return null;
            }
        }
    }

    public Produto(Integer id, String nome, Integer quantidade, TipoProd tipo) {
        this.id = id;
        this.nome = nome;
        this.quantidade = quantidade;
        this.tipo = tipo;
    }

    public Produto() {
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public Integer getQuantidade() {
        return quantidade;
    }

    public void setQuantidade(Integer quantidade) {
        this.quantidade = quantidade;
    }

    public TipoProd getTipo() {
        return tipo;
    }

    public void setTipo(TipoProd tipo) {
        this.tipo = tipo;
    }

}