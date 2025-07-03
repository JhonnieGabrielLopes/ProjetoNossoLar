package br.edu.iftm.sistemanossolar.model.pessoa;

import br.edu.iftm.sistemanossolar.model.endereco.Endereco;
import java.util.Objects;

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
            if (opcao == null) {
                return null;
            }
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
            if (opcao == null) {
                return null;
            }
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
            if (opcao == null) {
                return null;
            }
            try {
                return TipoPessoa.valueOf(opcao.toUpperCase());
            } catch (IllegalArgumentException e) {
                return null;
            }
        }
    }

    //Contrutor vazio
    public Pessoa() {
    }

    //Construtor mínimo para cadastrar Beneficiario e Doador
    public Pessoa(String nome, String telefone, Endereco endereco) {
        this.nome = nome;
        this.telefone = telefone;
        this.endereco = endereco;
    }

    //Contrutor completo da Pessoa
    public Pessoa(Integer id, String nome, TipoPessoa tipoPessoa, String identificacao, String telefone, Integer enderecoId, String email, String observacao) {
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

    public boolean camposIguais(Pessoa outro) {
        if (outro == null) {
            System.out.println("0 - Objeto comparado é null");
            return false;
        }

        if (this.id != null ? !this.id.equals(outro.getId()) : outro.getId() != null) {
            System.out.println("1 - id diferente");
            return false;
        }

        if (this.tipoCadastro != null ? !this.tipoCadastro.equals(outro.getTipoUsuario()) : outro.getTipoUsuario() != null) {
            System.out.println("2 - tipoCadastro diferente");
            return false;
        }

        if (this.nome != null
                ? (this.nome.trim().isEmpty() || !this.nome.equals(outro.getNome()))
                : (outro.getNome() != null && !outro.getNome().trim().isEmpty())) {
            System.out.println("3 - nome diferente ou vazio");
            return false;
        }

        if (this.paciente.igual(outro.getPaciente())) {
            System.out.println("4 - paciente diferente ou vazio");
            return false;
        }

        if (this.local != null ? !this.local.equals(outro.getLocal()) : outro.getLocal() != null) {
            System.out.println("5 - local diferente");
            return false;
        }

        if (this.tipoPessoa != null ? !this.tipoPessoa.equals(outro.getTipoPessoa()) : outro.getTipoPessoa() != null) {
            System.out.println("6 - tipoPessoa diferente");
            return false;
        }

        if (this.identificacao != null
                ? (this.identificacao.trim().isEmpty() || !this.identificacao.equals(outro.getIdentificacao()))
                : (outro.getIdentificacao() != null && !outro.getIdentificacao().trim().isEmpty())) {
            System.out.println("7 - identificacao diferente ou vazia");
            return false;
        }

        if (this.telefone != null
                ? (this.telefone.trim().isEmpty() || !this.telefone.equals(outro.getTelefone()))
                : (outro.getTelefone() != null && !outro.getTelefone().trim().isEmpty())) {
            System.out.println("8 - telefone diferente ou vazio");
            return false;
        }

        if (this.enderecoId != null ? !this.enderecoId.equals(outro.getEnderecoId()) : outro.getEnderecoId() != null) {
            System.out.println("9 - enderecoId diferente");
            return false;
        }

        if (!this.endereco.igual(outro.getEndereco())) {
            System.out.println("10 - endereco diferente");
            return false;
        }

        if (this.email != null
                ? (this.email.trim().isEmpty() || !this.email.equals(outro.getEmail()))
                : (outro.getEmail() != null && !outro.getEmail().trim().isEmpty())) {
            System.out.println("11 - email diferente ou vazio");
            return false;
        }

        if (!(this.observacao == null && outro.getObservacao() == null)
                && !Objects.equals(this.observacao, outro.getObservacao())) {
            System.out.println("observação diferente");
            return false;
        }

        if (this.cidadeCompleta != null
                ? (this.cidadeCompleta.trim().isEmpty() || !this.cidadeCompleta.equals(outro.getCidadeCompleta()))
                : (outro.getCidadeCompleta() != null && !outro.getCidadeCompleta().trim().isEmpty())) {
            System.out.println("13 - cidadeCompleta diferente ou vazia");
            return false;
        }

        System.out.println("Todos os campos são iguais.");
        return true;
    }
}
