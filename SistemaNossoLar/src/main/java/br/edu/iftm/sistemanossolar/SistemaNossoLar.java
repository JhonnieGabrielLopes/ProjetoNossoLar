package br.edu.iftm.sistemanossolar;

import java.sql.Connection;
import java.util.Scanner;

import br.edu.iftm.sistemanossolar.controller.pessoa.PessoaController;
import br.edu.iftm.sistemanossolar.dao.ConexaoBanco;
import br.edu.iftm.sistemanossolar.model.endereco.Cidade;
import br.edu.iftm.sistemanossolar.model.endereco.Endereco;
import br.edu.iftm.sistemanossolar.model.pessoa.Cliente;
import br.edu.iftm.sistemanossolar.model.pessoa.Tipo;

public class SistemaNossoLar {
    private static PessoaController pessoaController = new PessoaController();
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        System.out.println("Hello World!");
        Connection conn = ConexaoBanco.getConnection();
        if (conn != null) {
            System.out.println("Conexão estabelecida com sucesso!");
        } else {
            System.out.println("Falha ao estabelecer conexão.");
        }

        System.out.println("Digite o nome do cliente:");
        String nomeCliente = in.nextLine();
        System.out.println("Digite o telefone do cliente:");
        String telefone = in.nextLine();
        System.out.println("Digite o nome do paciente:");
        String nomePaciente = in.nextLine();
        System.out.println("Digite a previsão de dias:");
        int dias = in.nextInt();
        in.nextLine();
        System.out.println("Digite o nome da cidade:");
        String cidade = in.nextLine();
        System.out.println("Digite o estado da cidade:");
        String uf = in.nextLine();
        Cidade cidadeObj = new Cidade(cidade, uf);
        Endereco endereco = new Endereco(cidadeObj);
        Cliente cliente = new Cliente(nomeCliente, telefone, endereco, nomePaciente, dias);
        Tipo tipo = new Tipo("Cliente");
        if (pessoaController.cadastrarCliente(cliente, tipo)) {
            System.out.println("Cliente cadastrado com sucesso!");
        }else {
            System.out.println("Erro ao cadastrar cliente.");
        }
    }
}
