package br.edu.iftm.sistemanossolar.view;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.Scanner;

import br.edu.iftm.sistemanossolar.controller.endereco.CidadeController;
import br.edu.iftm.sistemanossolar.controller.endereco.EnderecoController;
import br.edu.iftm.sistemanossolar.controller.pessoa.PessoaController;

import br.edu.iftm.sistemanossolar.model.endereco.Cidade;
import br.edu.iftm.sistemanossolar.model.endereco.Endereco;
import br.edu.iftm.sistemanossolar.model.pessoa.Cliente;
import br.edu.iftm.sistemanossolar.model.pessoa.Tipo;
import br.edu.iftm.sistemanossolar.model.pessoa.Pessoa.TipoPessoa;

public class Metodos {
    private static EnderecoController enderecoController;
    private static CidadeController cidadeController;
    private static PessoaController pessoaController;

    public Metodos(Connection conexao) {
        enderecoController = new EnderecoController(conexao);
        cidadeController = new CidadeController(conexao);
        pessoaController = new PessoaController(conexao);
    }

    public void menuPrincipal() {
        System.out.println("\nSistema Nosso Lar");
        System.out.println("Selecione uma opção:");
        System.out.println("1 - Cadastrar cliente");
        System.out.println("2 - Cadastrar endereço");
        System.out.println("3 - Cadastrar cidade");
        System.out.println("4 - Sair");
        System.out.print("Escolha uma opção: ");
    }

    public boolean cadastrarUsuario(Scanner scan) throws SQLException {
        System.out.println("Digite o nome do usuario:");
        String nomeCliente = scan.nextLine();

        System.out.println("Digite o Tipo do usuario:");
        String tipoUsu = scan.nextLine();

        System.out.println("Digite o tipo de pessoa (FISICA ou JURIDICA):");
        String tipoPess = scan.nextLine();

        System.out.println("Digite o CPF do usuario:");
        String cpf = scan.nextLine();

        System.out.println("Digite o telefone do usuario:");
        String telefone = scan.nextLine();

        System.out.println("Digite o email do usuario:");
        String email = scan.nextLine();

        System.out.println("Digite o nome do paciente:");
        String nomePaciente = scan.nextLine();

        System.out.println("Digite a previsão de dias:");
        int qtdDias = scan.nextInt();
        scan.nextLine();

        System.out.println("Digite o nome da cidade:");
        String cidade = scan.nextLine();

        System.out.println("Digite o estado da cidade:");
        String uf = scan.nextLine();

        System.out.println("Observação:");
        String observacao = scan.nextLine();

        Cidade cidadeObj = new Cidade(cidade, uf);

        Endereco endereco = new Endereco(cidadeObj);

        Tipo tipo = new Tipo(tipoUsu);

        Cliente cliente = new Cliente(nomeCliente, telefone, endereco, nomePaciente, qtdDias);
        cliente.setTipoPessoa(TipoPessoa.fromString(tipoPess));
        cliente.setIdentificacao(cpf);
        cliente.setEmail(email);
        cliente.setObservacao(observacao);

        if (pessoaController.cadastrarPessoa(cliente, tipo)) {
            return true;
        }else {
            return false;
        }
    }

    public boolean cadastrarEndereco(Scanner scan) throws SQLException {
        System.out.println("Digite o CEP:");
        String cep = scan.nextLine();

        System.out.println("Digite o nome da cidade:");
        String nomeCidade = scan.nextLine();

        System.out.println("Digite o estado da cidade:");
        String estado = scan.nextLine();

        Cidade cidadeTemp = new Cidade(nomeCidade, estado);
        System.out.println("Digite o nome da rua:");
        String rua = scan.nextLine();

        System.out.println("Digite o número:");
        int numero = scan.nextInt();
        scan.nextLine();

        System.out.println("Digite o bairro:");
        String bairro = scan.nextLine();

        System.out.println("Digite o complemento:");
        String complemento = scan.nextLine();

        Endereco novoEndereco = new Endereco(rua, numero, bairro, cep, complemento, cidadeTemp);

        if (enderecoController.cadastrarEndereco(novoEndereco, cidadeTemp)) {
            return true;
        } else {
            return false;
        }
    }

    public boolean cadastrarCidade(Scanner scan) throws SQLException {
        System.out.println("Digite o nome da cidade:");
        String nomeCidade = scan.nextLine();

        System.out.println("Digite o estado da cidade:");
        String estado = scan.nextLine();

        Cidade novaCidade = new Cidade(nomeCidade, estado);
        
        if (!cidadeController.existeCidade(novaCidade)) {
            if (cidadeController.cadastrarCidade(novaCidade)) {
                return true;
            } else {
                return false;
            }
        }
        
        return false;
    }
    
}