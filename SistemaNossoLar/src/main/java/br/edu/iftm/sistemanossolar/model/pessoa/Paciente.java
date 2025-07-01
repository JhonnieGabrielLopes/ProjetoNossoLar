package br.edu.iftm.sistemanossolar.model.pessoa;

public class Paciente {
    private Integer id;
    private String nome;
    private Integer previsaoDias;

    // Contrutor vazio
    public Paciente() {
    }

    // Construtor mínimo para cadastrar Paciente
    public Paciente(String nome, Integer previsaoDias) {
        this.nome = nome;
        this.previsaoDias = previsaoDias;
    }

    // Construtor completo de Paciente
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
    if (outro == null) return false;
    
    if (this.id != null ? !this.id.equals(outro.getId()) : outro.getId() != null) return false;
    if (this.nome != null ? !this.nome.equals(outro.getNome()) : outro.getNome() != null) return false;
    return !(this.previsaoDias != null ? !this.previsaoDias.equals(outro.getPrevisaoDias()) : outro.getPrevisaoDias() != null);
}
}
