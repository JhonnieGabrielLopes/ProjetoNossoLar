package br.edu.iftm.sistemanossolar.model.endereco;

public class Endereco {

    private String logradouro;
    private int numero;
    private String bairro;
    private String cep;
    private String complemento;
    private Cidade cidade;

    public Endereco(String logradouro, int numero, String bairro, String cep, String complemento, Cidade cidade) {
        this.logradouro = logradouro;
        this.numero = numero;
        this.bairro = bairro;
        this.cep = cep;
        this.complemento = complemento;
        this.cidade = cidade;
    }

    public Endereco(Cidade cidade) {
        this.cidade = cidade;
    }

    public String getLogradouro() {
        return logradouro;
    }

    public void setLogradouro(String logradouro) {
        this.logradouro = logradouro;
    }

    public int getNumero() {
        return numero;
    }

    public void setNumero(int numero) {
        this.numero = numero;
    }

    public String getBairro() {
        return bairro;
    }

    public void setBairro(String bairro) {
        this.bairro = bairro;
    }

    public String getCep() {
        return cep;
    }

    public void setCep(String cep) {
        this.cep = cep;
    }

    public String getComplemento() {
        return complemento;
    }

    public void setComplemento(String complemento) {
        this.complemento = complemento;
    }

    public Cidade getCidade() {
        return cidade;
    }

    public void setCidade(Cidade cidade) {
        this.cidade = cidade;
    }

    public boolean igual(Endereco outro) {
        if (this.logradouro != null
                ? (this.logradouro.trim().isEmpty() || !this.logradouro.equals(outro.getLogradouro()))
                : (outro.getLogradouro() != null && !outro.getLogradouro().trim().isEmpty())) {
            System.out.println("14 - logradouro diferente ou vazio");
            return false;
        }

        if (this.numero != outro.getNumero()) {
            System.out.println("15 - numero diferente");
            return false;
        }

        if (this.bairro != null
                ? (this.bairro.trim().isEmpty() || !this.bairro.equals(outro.getBairro()))
                : (outro.getBairro() != null && !outro.getBairro().trim().isEmpty())) {
            System.out.println("16 - bairro diferente ou vazio");
            return false;
        }

        if (this.cep != null
                ? (this.cep.trim().isEmpty() || !this.cep.equals(outro.getCep()))
                : (outro.getCep() != null && !outro.getCep().trim().isEmpty())) {
            System.out.println("17 - cep diferente ou vazio");
            return false;
        }

        if (this.complemento != null
                ? (this.complemento.trim().isEmpty() || !this.complemento.equals(outro.getComplemento()))
                : (outro.getComplemento() != null && !outro.getComplemento().trim().isEmpty())) {
            System.out.println("18 - complemento diferente ou vazio");
            return false;
        }

        if (!this.cidade.igual(outro.getCidade())) {
            System.out.println("19 - cidade diferente");
            return false;
        }
        return true;
    }

}
