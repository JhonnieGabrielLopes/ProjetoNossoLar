package br.edu.iftm.sistemanossolar.model.pessoa;

public class Cliente extends Pessoa {
    private String paciente;
    private int previsaoQtdDias;

    public Cliente(String nome, String telefone, Tipo tipo, String paciente, int previsaoQtdDias) {
        super(nome, telefone, tipo);
        this.paciente = paciente;
        this.previsaoQtdDias = previsaoQtdDias;
    }
    public String getPaciente() {
        return paciente;
    }
    public void setPaciente(String paciente) {
        this.paciente = paciente;
    }
    public int getPrevisaoQtdDias() {
        return previsaoQtdDias;
    }
    public void setPrevisaoQtdDias(int previsaoQtdDias) {
        this.previsaoQtdDias = previsaoQtdDias;
    }
}
