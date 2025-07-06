package br.edu.iftm.sistemanossolar.model.pessoa;

import java.util.Objects;

public class Paciente {
    private Integer id;
    private String nome;
    private Integer previsaoDias;

    public Paciente() {
    }

    public Paciente(String nome, Integer previsaoDias) {
        this.nome = nome;
        this.previsaoDias = previsaoDias;
    }

    public Paciente (Integer id, String nome, Integer previsaoDias) {
        this.id = id;
        this.nome = nome;
        this.previsaoDias = previsaoDias;
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

    public Integer getPrevisaoDias() {
        return previsaoDias;
    }

    public void setPrevisaoDias(Integer previsaoDias) {
        this.previsaoDias = previsaoDias;
    }

    public boolean igual(Paciente outro) {
        if (outro == null) {
            return false;
        }
    
        if (!iguais(this.nome, outro.getNome())) {
            return false;
        }
    
        if (!Objects.equals(this.previsaoDias, outro.getPrevisaoDias())) {
            return false;
        }
    
        return true;
    }

    private boolean iguais(String a, String b) {
        if (a == null && b == null) return true;
        if (a == null || b == null) return false;
        return a.trim().equalsIgnoreCase(b.trim());
    }
}
