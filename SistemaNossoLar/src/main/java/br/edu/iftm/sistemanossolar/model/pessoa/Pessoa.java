package br.edu.iftm.sistemanossolar.model.pessoa;

import br.edu.iftm.sistemanossolar.model.endereco.Endereco;

public class Pessoa {
    private int id;
    private String nome;
    private String telefone;
    private TipoPessoa tipoPessoa;
    private String paciente;
    private int previsaoDias;
    private String email;
    private String identificacao;
    private Endereco endereco;
    private int enderecoId;
    private String observacao;

    public Pessoa(){
        
    }

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

    //Doador

    //Cliente
    public Pessoa(String nome, String telefone, Endereco endereco, String paciente, int previsaoDias) {
        this.nome = nome;
        this.telefone = telefone;
        this.endereco = endereco;
        this.paciente = paciente;
        this.previsaoDias = previsaoDias;
    }

    public Pessoa(int id, String nome, String telefone){
        this.nome = nome;
        this.telefone = telefone;
        this.id = id;
    }
    
    //Completo
    public Pessoa(int id, String nome, TipoPessoa tipoPessoa, String identificacao, String paciente, int previsaoDias, String telefone, int enderecoId, String email,  String observacao) {
        this.id = id;
        this.nome = nome;
        this.tipoPessoa = tipoPessoa;
        this.identificacao = identificacao;
        this.paciente = paciente;
        this.previsaoDias = previsaoDias;
        this.telefone = telefone;
        this.enderecoId = enderecoId;
        this.email = email;
        this.observacao = observacao;
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

    public String getPaciente() {
        return paciente;
    }

    public void setPaciente(String paciente) {
        this.paciente = paciente;
    }

    public int getPrevisaoDias() {
        return previsaoDias;
    }

    public void setPrevisaoDias(int previsaoDias) {
        this.previsaoDias = previsaoDias;
    }

    public int getEnderecoId() {
        return enderecoId;
    }

    public void setEnderecoId(int enderecoId) {
        this.enderecoId = enderecoId;
    }
}
