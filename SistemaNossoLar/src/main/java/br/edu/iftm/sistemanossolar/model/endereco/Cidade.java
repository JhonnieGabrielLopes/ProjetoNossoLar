package br.edu.iftm.sistemanossolar.model.endereco;

public class Cidade {

    private String nome;
    private String estado;

    public Cidade(String nome, String estado) {
        this.nome = nome;
        this.estado = estado;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    @Override
    public String toString() {
        return nome;
    }

    public boolean igual(Cidade outro) {
        if (this.nome == null ? outro.getNome() != null : !this.nome.equals(outro.getNome())) {
            System.out.println("Nome cidade diferente");
            return false;
        }
        
        if (this.estado == null ? outro.getEstado() != null : !this.estado.equals(outro.getEstado())) {
            System.out.println("Estado cidade diferente");
            return false;
        }

        return true;
    }
}
