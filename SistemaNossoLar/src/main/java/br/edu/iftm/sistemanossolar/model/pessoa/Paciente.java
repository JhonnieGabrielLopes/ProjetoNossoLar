package br.edu.iftm.sistemanossolar.model.pessoa;

public class Paciente {
    private int id;
    private String nome;
    private Local local;
    private int previsaoDias;

    public Paciente() {
    }

    public Paciente(String nome, Local local, int previsaoDias) {
        this.nome = nome;
        this.local = local;
        this.previsaoDias = previsaoDias;
    }

    public enum Local {
        HOSPITAL,
        PRONTOSOCORRO,;
        public static Local fromString(String opcao) {

            if (opcao==null) return null;

            try {
                return Local.valueOf(opcao.toUpperCase());

            } catch (IllegalArgumentException e) {
                return null;
            }

        }
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public Local getLocal() {
        return local;
    }

    public void setLocal(Local local) {
        this.local = local;
    }

    public int getPrevisaoDias() {
        return previsaoDias;
    }

    public void setPrevisaoDias(int previsaoDias) {
        this.previsaoDias = previsaoDias;
    }

}
