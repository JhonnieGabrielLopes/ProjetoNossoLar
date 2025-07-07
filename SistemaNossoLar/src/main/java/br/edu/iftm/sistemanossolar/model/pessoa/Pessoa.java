package br.edu.iftm.sistemanossolar.model.pessoa;

import br.edu.iftm.sistemanossolar.model.endereco.Endereco;

import java.lang.reflect.Method;
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
        PRONTOSOCORRO;

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
            //System.out.println("0 - Objeto comparado é null");
            return false;
        }

        if (!objetosIguais(this.id, outro.getId())) {
            //System.out.println("1 - id diferente");
            return false;
        }

        if (!objetosIguais(this.tipoCadastro, outro.getTipoUsuario())) {
            //System.out.println("2 - tipoCadastro diferente");
            return false;
        }

        if (!iguais(this.nome, outro.getNome())) {
            //System.out.println("3 - nome diferente");
            return false;
        }

        if (!objetosComMetodoIgual(this.paciente, outro.getPaciente())) {
            //System.out.println("4 - paciente diferente");
            return false;
        }

        if (!objetosIguais(this.local, outro.getLocal())) {
            //System.out.println("5 - local diferente");
            return false;
        }

        if (!objetosIguais(this.tipoPessoa, outro.getTipoPessoa())) {
            //System.out.println("6 - tipoPessoa diferente");
            return false;
        }

        if (!iguais(this.identificacao, outro.getIdentificacao())) {
            //System.out.println("7 - identificacao diferente");
            return false;
        }

        if (!iguais(this.telefone, outro.getTelefone())) {
           //System.out.println("8 - telefone diferente");
            return false;
        }

        if (!objetosIguais(this.enderecoId, outro.getEnderecoId())) {
            //System.out.println("9 - enderecoId diferente");
            return false;
        }

        if (!objetosComMetodoIgual(this.endereco, outro.getEndereco())) {
            //System.out.println("10 - endereco diferente");
            return false;
        }

        if (!iguais(this.email, outro.getEmail())) {
            //System.out.println("11 - email diferente");
            return false;
        }

        if (!iguais(this.observacao, outro.getObservacao())) {
            //System.out.println("12 - observação diferente");
            return false;
        }

        if (!iguais(this.cidadeCompleta, outro.getCidadeCompleta())) {
            //System.out.println("13 - cidadeCompleta diferente");
            return false;
        }

        //System.out.println("Todos os campos são iguais.");
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

    private boolean objetosComMetodoIgual(Object a, Object b) {
        if (a == null && b == null) return true;
        if (a == null || b == null) return false;
        try {
            Method m = a.getClass().getMethod("igual", b.getClass());
            return (boolean) m.invoke(a, b);
        } catch (Exception e) {
            return false;
        }
    }
}
