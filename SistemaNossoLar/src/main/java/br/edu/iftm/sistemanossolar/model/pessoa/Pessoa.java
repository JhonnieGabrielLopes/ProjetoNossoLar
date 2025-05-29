package br.edu.iftm.sistemanossolar.model.pessoa;

import br.edu.iftm.sistemanossolar.model.endereco.Endereco;

public abstract class Pessoa {
    private int id;
    private String nome;
    private String telefone;
    private TipoPessoa tipoPessoa;
    private String email;
    private String identificacao;
    private Endereco endereco;
    private String observacao;

    public Pessoa(String nome, String telefone, Endereco endereco) { // construtor usado para cadastrar cliente e doador
        this.nome = nome;
        this.telefone = telefone;
        this.endereco = endereco;
    }
    
    public Pessoa(String nome, String telefone) { // construtor usado para listar e selecionar clientes e doadores em registro de pedido e doação
        this.nome = nome;
        this.telefone = telefone;
    }
    // construtor usado para pegar o registro completo de usuário para jogar na tela de alterar usuário
    public Pessoa(String nome, String telefone, TipoPessoa tipoPessoa, String email, String identificacao, Endereco endereco, String observacao) {
        this.nome = nome;
        this.telefone = telefone;
        this.tipoPessoa = tipoPessoa;
        this.email = email;
        this.identificacao = identificacao;
        this.endereco = endereco;
        this.observacao = observacao;
    } 

    public Pessoa(int id, String nome, String telefone) {
        this.id = id;
        this.nome = nome;
        this.telefone = telefone;
    }

    public enum TipoPessoa {
        FISICA,
        JURIDICA;
        public static TipoPessoa fromString(String opcao) {

            if (opcao==null) return null;

            try {
                return TipoPessoa.valueOf(opcao.toUpperCase());

            } catch (IllegalArgumentException e) {
                return null;
            }

        }
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getTelefone() {
        return telefone;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getIdentificacao() {
        return identificacao;
    }

    public void setIdentificacao(String identificacao) {
        this.identificacao = identificacao;
    }
    
    public Endereco getEndereco() {
        return endereco;
    }

    public void setEndereco(Endereco endereco) {
        this.endereco = endereco;
    }

    public TipoPessoa getTipoPessoa() {
        return tipoPessoa;
    }

    public void setTipoPessoa(TipoPessoa tipoPessoa) {
        this.tipoPessoa = tipoPessoa;
    }

    public String getObservacao() {
        return observacao;
    }

    public void setObservacao(String observacao) {
        this.observacao = observacao;
    }

    public int getId() {
        return id;
    }
}
