package br.edu.iftm.sistemanossolar.view;

import java.sql.Connection;
import java.sql.SQLException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import br.edu.iftm.sistemanossolar.controller.doacao.ProdutoController;
import br.edu.iftm.sistemanossolar.controller.endereco.CidadeController;
import br.edu.iftm.sistemanossolar.controller.endereco.EnderecoController;
import br.edu.iftm.sistemanossolar.controller.pessoa.PessoaController;
import br.edu.iftm.sistemanossolar.model.doacao.Doacao;
import br.edu.iftm.sistemanossolar.model.doacao.Produto;
import br.edu.iftm.sistemanossolar.model.endereco.Cidade;
import br.edu.iftm.sistemanossolar.model.endereco.Endereco;
import br.edu.iftm.sistemanossolar.model.pessoa.Cliente;
import br.edu.iftm.sistemanossolar.model.pessoa.Doador;
import br.edu.iftm.sistemanossolar.model.pessoa.Tipo;
import br.edu.iftm.sistemanossolar.model.pessoa.Pessoa.TipoPessoa;

public class Metodos {
    private static EnderecoController enderecoController;
    private static CidadeController cidadeController;
    private static PessoaController pessoaController;
    private static ProdutoController produtoController;

    RegistrosLog registrarLog = new RegistrosLog();

    public Metodos(Connection conexao) {
        enderecoController = new EnderecoController(conexao);
        cidadeController = new CidadeController(conexao);
        pessoaController = new PessoaController(conexao);
    }

    public void menuPrincipal() {
        System.out.println("\nSistema Nosso Lar");
        System.out.println("Selecione uma opção:");
        System.out.println("1 - Cadastrar Usuário");
        System.out.println("2 - Cadastrar Endereço");
        System.out.println("3 - Cadastrar Cidade");
        System.out.println("4 - Cadastrar Doação");
        System.out.println("5 - Cadastrar Pedido");
        System.out.println("6 - Cadastrar Produto");
        System.out.println("7 - Cadastrar Tipo Usuario");
        System.out.println("8 - Cadastrar Tipo Doação");
        System.out.println("9 - Cadastrar Tipo Produto");
        System.out.println("10 - Alterar Usuário");
        System.out.println("11 - Alterar Endereço");
        System.out.println("12 - Alterar Pedido");
        System.out.println("13 - Alterar Produto");
        System.out.println("14 - Deletar Usuário");
        System.out.println("15 - Deletar Endereço");
        System.out.println("16 - Deletar Cidade");
        System.out.println("17 - Deletar Tipo Usuario");
        System.out.println("18 - Deletar Tipo Doação");
        System.out.println("19 - Deletar Tipo Produto");
        System.out.println("20 - Exibir Usuário");
        System.out.println("21 - Exibir Endereço");
        System.out.println("22 - Exibir Cidade");
        System.out.println("23 - Exibir Doação");
        System.out.println("24 - Exibir Pedido");
        System.out.println("25 - Exibir Produto");
        System.out.println("26 - Sair");
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

    public Produto cadastrarProduto(Scanner scan) throws SQLException {
        int qtdProd = 0;
        String tipoProduto = null;
        String nomeProduto = null;
        Produto novoProduto = new Produto();

        System.out.println("Digite o Tipo do produto:");
        tipoProduto = scan.nextLine();
        Tipo tipoProd = new Tipo(tipoProduto);

        System.out.println("Digite o nome do Produto:");
        nomeProduto = scan.nextLine();

        System.out.println("Digite a quantidade do Produto:");
        qtdProd = scan.nextInt();
        scan.nextLine();
        
        novoProduto.setTipo(tipoProd);
        novoProduto.setNome(nomeProduto);
        novoProduto.setQuantidade(qtdProd);

        produtoController.cadastrarProduto(novoProduto);

        return novoProduto;
    }

    public boolean cadastrarDoacao(Scanner scan) throws SQLException {
        System.out.println("Selecione o Doador (código):");
        pessoaController.listarPessoas();
        int idDoador = scan.nextInt();
        scan.nextLine();

        System.out.println("Digite o tipo da doação:");
        String tipoDoacao = scan.nextLine();

        System.out.println("Digite o valor doado:");
        double valor = scan.nextDouble();
        
        List<Produto> produtos = new ArrayList<Produto>();

        boolean controle = false;
        int numProduto = 1;
        int opc = 0;
        while (!controle) {
            System.out.println("Deseja inserir o produto nº " + numProduto + "? 1-Sim / 2-Não");
            opc = scan.nextInt();
            scan.nextLine();

            if (opc == 2) {
                controle = true;
            } else {
                produtos.add(cadastrarProduto(scan));

                numProduto++;
                controle = false;
            }
        }      

        System.out.println("Digite a data da doação (ex. 22/05/2025):");
        String data = scan.nextLine();

        DateTimeFormatter dataFormat = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        LocalDate dataDoacao = LocalDate.parse(data, dataFormat);

        Tipo tipoDoa = new Tipo(tipoDoacao);

        Doador doador = (Doador)pessoaController.buscarPessoaPorId(idDoador);

        Doacao doacao = new Doacao(doador, tipoDoa, dataDoacao);
        doacao.setValor(valor);
        doacao.setProduto(produtos);

        return false;
    }
    
}