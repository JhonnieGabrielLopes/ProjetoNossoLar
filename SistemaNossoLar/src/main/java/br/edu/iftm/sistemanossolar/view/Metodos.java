package br.edu.iftm.sistemanossolar.view;

import java.io.IOException;

import java.sql.Connection;
import java.sql.SQLException;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import br.edu.iftm.sistemanossolar.controller.PedidoController;
import br.edu.iftm.sistemanossolar.controller.RelatorioController;
import br.edu.iftm.sistemanossolar.controller.doacao.DoacaoController;
import br.edu.iftm.sistemanossolar.controller.doacao.ProdutoController;
import br.edu.iftm.sistemanossolar.controller.pessoa.PessoaController;
import br.edu.iftm.sistemanossolar.model.doacao.Doacao;
import br.edu.iftm.sistemanossolar.model.doacao.Produto;
import br.edu.iftm.sistemanossolar.model.doacao.Doacao.TipoDoa;
import br.edu.iftm.sistemanossolar.model.doacao.Produto.TipoProd;
import br.edu.iftm.sistemanossolar.model.pedido.Pedido;
import br.edu.iftm.sistemanossolar.model.pedido.Pedido.StatusPedido;
import br.edu.iftm.sistemanossolar.model.pessoa.Pessoa;

public class Metodos {
    private static PessoaController pessoaController;
    private static ProdutoController produtoController;
    private static DoacaoController doacaoController;
    private static PedidoController pedidoController;
    private static RelatorioController relatorioController;

    RegistrosLog log = new RegistrosLog();

    public Metodos(Connection conexao) {
        pessoaController = new PessoaController(conexao);
        produtoController = new ProdutoController(conexao);
        doacaoController = new DoacaoController(conexao);
        pedidoController = new PedidoController(conexao);
        relatorioController = new RelatorioController(conexao);
    }

    public void menuPrincipal() {
        System.out.println("Selecione uma opção:");
        System.out.println("1 - Cadastrar Usuário");
        System.out.println("2 - Cadastrar Endereço");
        System.out.println("3 - Cadastrar Cidade");
        System.out.println("4 - Cadastrar Doação");
        System.out.println("5 - Cadastrar Pedido");
        System.out.println("6 - Cadastrar Produto");
        System.out.println("7 - Listar Pessoas");
        System.out.println("8 - Exibir Endereço");
        System.out.println("9 - Exibir Cidade");
        System.out.println("10 - Listar Doações");
        System.out.println("11 - Listar Pedidos");
        System.out.println("12 - Listar Produtos");
        System.out.println("13 - Alterar Usuário");
        System.out.println("14 - Alterar Endereço");
        System.out.println("15 - Alterar Pedido");
        System.out.println("16 - Alterar Produto");
        System.out.println("17 - Deletar Usuário");
        System.out.println("18 - Deletar Endereço");
        System.out.println("19 - Deletar Cidade");
        System.out.println("20 - Relatorio de Doações");
        System.out.println("21 - Sair");
        System.out.println("Escolha uma opção: ");
    }

    public boolean cadastrarUsuario(Scanner scan) throws SQLException {
        System.out.println("Utilize a tela!");
        return false;
    }

    public boolean cadastrarEndereco(Scanner scan) throws SQLException {
        System.out.println("Utilize a tela!");
        return false;
    }

    public boolean cadastrarCidade(Scanner scan) throws SQLException {
        System.out.println("Utilize a tela!");
        return false;
    }

    public boolean cadastrarProduto(Scanner scan, Produto novoProduto) throws SQLException {
        //METODO PARA TESTES NO TERMINAL
        String tipoProduto = null;
        String nomeProduto = null;

        System.out.println("Digite o Tipo do produto:");
        tipoProduto = scan.nextLine();

        System.out.println("Digite o nome do Produto:");
        nomeProduto = scan.nextLine();

        novoProduto.setTipo(TipoProd.fromString(tipoProduto));
        novoProduto.setNome(nomeProduto);

        if (produtoController.cadastrarProduto(novoProduto)) {
            return true;
        } else {
            return false;
        }
    }

    public boolean cadastrarDoacao(Scanner scan) throws SQLException, IOException {
        //METODO PARA TESTES NO TERMINAL
        System.out.println("Selecione o Doador (código):");
        listarPessoas2("Doador");
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
            Produto produto = new Produto();
            System.out.println("Inserir o produto nº " + numProduto + "? 1-Sim / 2-Não");
            opc = scan.nextInt();
            scan.nextLine();
            if (opc == 2) {
                controle = true;
            } else if (cadastrarProduto(scan, produto)) {
                System.out.println("Digite a quantidade do Produto:");
                produto.setQuantidade(scan.nextInt());
                scan.nextLine();
                produtos.add(produto);
                numProduto++;
                controle = false;
            }
        }

        System.out.println("Digite a data da doação (ex. 22/05/2025):");
        String data = scan.nextLine();

        DateTimeFormatter dataFormat = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        LocalDate dataDoacao = LocalDate.parse(data, dataFormat);

        Pessoa doador = pessoaController.buscarPessoaPorId(idDoador);

        Doacao doacao = new Doacao(doador, TipoDoa.fromString(tipoDoacao), dataDoacao);
        doacao.setValor(valor);
        doacao.setProduto(produtos);

        if (doacaoController.cadastrarDoacao(doacao)) {
            System.out.println("Deseja imprimir o relatorio? 1-Sim / 2-Não");
            opc = scan.nextInt();
            scan.nextLine();

            if (opc == 1) {
                relatorioController.gerarReciboDoacao(doacao);
            }
            return true;
        } else {
            return false;
        }
    }

    public void listarPessoas2(String tipo) throws SQLException, IOException {
        //METODO PARA TESTES NO TERMINAL
        List<Pessoa> pessoas = new ArrayList<>();
        if (tipo.equalsIgnoreCase("Beneficiario")) {
            pessoas = pessoaController.listarPessoas2("Beneficiario");
        } else if (tipo.equalsIgnoreCase("Assistente")) {
            pessoas = pessoaController.listarPessoas2("Assistente");
        } else if (tipo.equalsIgnoreCase("Doador")) {
            pessoas = pessoaController.listarPessoas2("Doador");
        }
        for (int i = 0; i < pessoas.size(); i++) {
            System.out.println((pessoas.get(i).getId()) + " - " + pessoas.get(i).getNome());
        }
    }

    public boolean cadastrarPedido(Scanner scan) throws SQLException, IOException {
        //METODO PARA TESTES NO TERMINAL
        System.out.println("Selecione a Pessoa: ");
        listarPessoas2("Beneficiario");
        listarPessoas2("Assistente");
        int idCliente = scan.nextInt();
        scan.nextLine();

        System.out.println("Digite a quantidade de marmitas: ");
        int qtdMarmitas = scan.nextInt();
        scan.nextLine();

        System.out.println("Digite a data do pedido (ex. 22/05/2025):");
        String data = scan.nextLine();

        DateTimeFormatter dataFormat = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        LocalDate dataPedido = LocalDate.parse(data, dataFormat);

        System.out.println("Observação: ");
        String observacao = scan.nextLine();

        Pessoa beneficiario = pessoaController.buscarPessoaPorId(idCliente);

        Pedido pedido = new Pedido(beneficiario, qtdMarmitas, StatusPedido.PENDENTE, dataPedido);
        pedido.setObservacao(observacao);

        if (pedidoController.cadastrarPedido(pedido)) {
            System.out.println("Deseja imprimir o relatorio? 1-Sim / 2-Não");
            int opc = scan.nextInt();
            scan.nextLine();

            if (opc == 1) {
                relatorioController.gerarReciboPedido(pedido);
            }
            return true;
        } else {
            return false;
        }

    }

    public void relatorioDoacao() throws SQLException, IOException {
        //METODO PARA TESTES NO TERMINAL
        relatorioController.relatorioDoacao();
    }

    public void listarDoacoes() throws SQLException {
        //METODO PARA TESTES NO TERMINAL
        String data1 = "2023-06-01";
        LocalDate dataTeste1 = LocalDate.parse(data1);
        String data2 = "2023-06-30"; 
        LocalDate dataTeste2 = LocalDate.parse(data2);
        List<Doacao> listagemDoacoes = doacaoController.listarDoacoes("", "Todos", null, null);
        System.out.println("Lista de Doações:");
        for (Doacao doacao : listagemDoacoes) {
            System.out.println("ID: " + doacao.getId() + 
                               "\nTipo: " + doacao.getTipo()+ ", Doador: " + doacao.getDoador().getNome() +", Data: " + doacao.getDataDoacao());
        }
    }

    public void listarPedidos() throws SQLException {
        //METODO PARA TESTES NO TERMINAL
        String data1 = "2023-06-01";
        LocalDate dataTeste1 = LocalDate.parse(data1);
        String data2 = "2023-06-30"; 
        LocalDate dataTeste2 = LocalDate.parse(data2);
        List<Pedido> listagemPedidos = pedidoController.listarPedidos("", "Todos", null, null);
        System.out.println("Lista de Pedidos:");
        for (Pedido pedido : listagemPedidos) {
            System.out.println("ID: " + pedido.getId() + 
                               "\nPessoa: " + pedido.getCliente().getNome() + ", Tipo: " + pedido.getCliente().getTipoUsuario() +", Data: " + pedido.getDataPedido());
        }
    }

    public void listarPessoas() throws SQLException {
        //METODO PARA TESTES NO TERMINAL
        List<Pessoa> listagemPessoas = pessoaController.listarPessoas("", "Todos", "Todas");
        System.out.println("Lista de Pessoas:");
        for (Pessoa pessoa : listagemPessoas) {
            System.out.println("ID: " + pessoa.getId() + 
                               "\nPessoa: " + pessoa.getNome() + ", Cidade: " + pessoa.getCidadeCompleta() +", Observação: " + pessoa.getObservacao());
        }
    }

    public void listarProdutos() throws SQLException {
        //METODO PARA TESTES NO TERMINAL
        List<Produto> listagemProdutos = produtoController.listarProdutos("", "Todos");
        System.out.println("Lista de Produtos:");
        for (Produto produto : listagemProdutos) {
            System.out.println("ID: " + produto.getId() + 
                               "\nProduto: " + produto.getNome());
        }
    }
}