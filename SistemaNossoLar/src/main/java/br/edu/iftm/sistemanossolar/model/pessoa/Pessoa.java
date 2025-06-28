package br.edu.iftm.sistemanossolar.model.pessoa;

import br.edu.iftm.sistemanossolar.model.endereco.Endereco;

public class Pessoa {
    private Integer id;
    private TipoCad tipoCadastro;
    private String nome;
    private Paciente paciente;
    private Local local;
    private TipoPessoa tipoPessoa;
    private String identificacao;
    private String telefone;
    private Integer enderecoId;
    private Endereco endereco;
    private String email;
    private String observacao;
    private String cidadeCompleta;

    public enum TipoCad {
        ASSISTENTE,
        BENEFICIARIO,
        DOADOR;
        public static TipoCad fromString(String opcao) {
            if (opcao==null) 
                return null;
            try {
                return TipoCad.valueOf(opcao.toUpperCase());
            } catch (IllegalArgumentException e) {
                return null;
            }
        }
    }

    public enum Local {
        HOSPITAL,
        PRONTOSOCORRO,;
        public static Local fromString(String opcao) {
            if (opcao==null) 
                return null;
            try {
                return Local.valueOf(opcao.toUpperCase());
            } catch (IllegalArgumentException e) {
                return null;
            }
        }
    }

    public enum TipoPessoa {
        FISICA,
        JURIDICA;
        public static TipoPessoa fromString(String opcao) {
            if (opcao==null) 
                return null;
            try {
                return TipoPessoa.valueOf(opcao.toUpperCase());
            } catch (IllegalArgumentException e) {
                return null;
            }
        }
    }
    
    //Contrutor vazio
    public Pessoa(){    
    }

    //Construtor mínimo para cadastrar Beneficiario e Doador
    public Pessoa(String nome, String telefone, Endereco endereco) { 
        this.nome = nome;
        this.telefone = telefone;
        this.endereco = endereco;
    }

    //Contrutor completo da Pessoa
    public Pessoa(Integer id, String nome, TipoPessoa tipoPessoa, String identificacao, String telefone, Integer enderecoId, String email,  String observacao) {
        this.id = id;
        this.nome = nome;
        this.tipoPessoa = tipoPessoa;
        this.identificacao = identificacao;
        this.telefone = telefone;
        this.enderecoId = enderecoId;
        this.email = email;
        this.observacao = observacao;
    }
    
    //Construtor para listar os Beneficiarios ou Doadores no Pedido/Doação
    public Pessoa(Integer id, String nome, String telefone) { 
        this.id = id;
        this.nome = nome;
        this.telefone = telefone;
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

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Paciente getPaciente() {
        return paciente;
    }

    public void setPaciente(Paciente paciente) {
        this.paciente = paciente;
    }

    public Integer getEnderecoId() {
        return enderecoId;
    }

    public void setEnderecoId(Integer enderecoId) {
        this.enderecoId = enderecoId;
    }

    public TipoCad getTipoUsuario() {
        return tipoCadastro;
    }

    public void setTipoUsuario(TipoCad tipoCadastro) {
        this.tipoCadastro = tipoCadastro;
    }

    public Local getLocal() {
        return local;
    }

    public void setLocal(Local local) {
        this.local = local;
    }

    public String getCidadeCompleta() {
        return cidadeCompleta;
    }

    public void setCidadeCompleta(String cidadeCompleta) {
        this.cidadeCompleta = cidadeCompleta;
    }
}