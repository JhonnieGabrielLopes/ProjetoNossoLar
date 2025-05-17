package br.edu.iftm.sistemanossolar;

import java.sql.Connection;
import java.util.Scanner;

import br.edu.iftm.sistemanossolar.controller.endereco.EnderecoController;
import br.edu.iftm.sistemanossolar.controller.endereco.CidadeController;
import br.edu.iftm.sistemanossolar.controller.pessoa.PessoaController;
import br.edu.iftm.sistemanossolar.dao.ConexaoBanco;
import br.edu.iftm.sistemanossolar.model.endereco.Cidade;
import br.edu.iftm.sistemanossolar.model.endereco.Endereco;
import br.edu.iftm.sistemanossolar.model.pessoa.Cliente;
import br.edu.iftm.sistemanossolar.model.pessoa.Tipo;

public class SistemaNossoLar {
    private static PessoaController pessoaController = new PessoaController();
    private static EnderecoController enderecoController = new EnderecoController();
    private static CidadeController cidadeController = new CidadeController();

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        System.out.println("Hello World!");
        Connection conn = ConexaoBanco.getConnection();
        if (conn != null) {
            System.out.println("Conexão estabelecida com sucesso!");
        } else {
            System.out.println("Falha ao estabelecer conexão.");
        }

        System.out.println("Selecione uma opção:");
        System.out.println("1 - Cadastrar cliente");
        System.out.println("2 - Cadastrar endereço");
        System.out.println("3 - Cadastrar cidade");

        int opcao = in.nextInt();
        in.nextLine();

        switch (opcao) {
            case 1:
                System.out.println("Cadastrar cliente");
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
                
                if (pessoaController.cadastrarPessoa(cliente, tipo)) {
                    System.out.println("Cliente cadastrado com sucesso!");
                }else {
                    System.out.println("Erro ao cadastrar cliente.");
                }

                break;
            case 2:
                System.out.println("Cadastrar endereço");
                System.out.println("Digite o CEP:");
                String cep = in.nextLine();

                System.out.println("Digite o nome da cidade:");
                String nomeCidade = in.nextLine();

                System.out.println("Digite o estado da cidade:");
                String estado = in.nextLine();

                Cidade cidadeTemp = new Cidade(nomeCidade, estado);

                System.out.println("Digite o nome da rua:");
                String rua = in.nextLine();

                System.out.println("Digite o número:");
                int numero = in.nextInt();
                in.nextLine();

                System.out.println("Digite o bairro:");
                String bairro = in.nextLine();

                System.out.println("Digite o complemento:");
                String complemento = in.nextLine();

                Endereco novoEndereco = new Endereco(rua, numero, bairro, cep, complemento, cidadeTemp);

                if (enderecoController.cadastrarEndereco(novoEndereco, cidadeTemp)) {
                    System.out.println("Endereço cadastrado com sucesso!");
                } else {
                    System.out.println("Erro ao cadastrar endereço.");
                }

                break;
            case 3:
                System.out.println("Cadastrar cidade");
                System.out.println("Digite o nome da cidade:");
                String nomeCidadeCadastro = in.nextLine();

                System.out.println("Digite o estado da cidade:");
                String estadoCadastro = in.nextLine();

                Cidade novaCidade = new Cidade(nomeCidadeCadastro, estadoCadastro);
                
                if (cidadeController.existeCidade(novaCidade)) {
                    System.out.println("Cidade já cadastrada.");
                    break;
                } else {
                    cidadeController.cadastrarCidade(novaCidade);
                }

                break;
            default:
                System.out.println("Opção inválida.");
                break;
        }

        in.close();
        try {
            conn.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}