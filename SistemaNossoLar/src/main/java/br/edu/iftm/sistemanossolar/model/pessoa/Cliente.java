package br.edu.iftm.sistemanossolar.model.pessoa;

import br.edu.iftm.sistemanossolar.model.endereco.Endereco;

public class Cliente extends Pessoa {
    private String paciente;
    private int previsaoQtdDias;
    private int id;

    public Cliente(String nome, String telefone, Endereco endereco, String paciente, int previsaoQtdDias) {
        super(nome, telefone, endereco);
        this.paciente = paciente;
        this.previsaoQtdDias = previsaoQtdDias;
    }

    public Cliente(int id, String nome, String telefone){
        super(nome, telefone);
        this.id = id;
    }
    
    public Cliente(int id, String nome, String telefone, TipoPessoa tipoPessoa, String email, String identificacao, Endereco endereco, String observacao, String paciente, int previsaoQtdDias) {
        super(nome, telefone, tipoPessoa, email, identificacao, endereco, observacao);
        this.id = id;
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
    
    public int getId() {
        return id;
    }
}
