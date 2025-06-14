package br.edu.iftm.sistemanossolar.view;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;

import java.sql.Connection;
import java.sql.SQLException;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import org.xhtmlrenderer.pdf.ITextRenderer;

import br.edu.iftm.sistemanossolar.controller.PedidoController;
import br.edu.iftm.sistemanossolar.controller.Relatorio;
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
import br.edu.iftm.sistemanossolar.model.pessoa.Pessoa.Local;
import br.edu.iftm.sistemanossolar.model.pessoa.Pessoa.TipoCad;
import br.edu.iftm.sistemanossolar.model.relatorio.RelDoacao;
import br.edu.iftm.sistemanossolar.model.relatorio.RetornoDoacoes;

public class Metodos {
    private static PessoaController pessoaController;
    private static ProdutoController produtoController;
    private static DoacaoController doacaoController;
    private static PedidoController pedidoController;

    RegistrosLog log = new RegistrosLog();

    public Metodos(Connection conexao) {
        pessoaController = new PessoaController(conexao);
        produtoController = new ProdutoController(conexao);
        doacaoController = new DoacaoController(conexao);
        pedidoController = new PedidoController(conexao);
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
                gerarReciboDoacao(doacao);
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
                gerarReciboPedido(pedido);
            }
            return true;
        } else {
            return false;
        }

    }

    public void gerarReciboDoacao(Doacao doacao) throws IOException {
        log.registrarLog(1, "Metodos", "gerarReciboDoacao", "", "Gerando recibo da Doação");

        DateTimeFormatter formatador = DateTimeFormatter.ofPattern("dd/MM/yyyy");

        if (doacao.getProduto().isEmpty()) {
            String template = Relatorio.templateDoacaoDinheiro();
            String templatePreenchido = template
                .replace("{{codigo}}", doacao.getId().toString())
                .replace("{{nome}}", doacao.getDoador().getNome())
                .replace("{{valor}}", String.format("R$ %.2f", doacao.getValor()))
                .replace("{{data}}", doacao.getDataDoacao().format(formatador));
            try {
                new File("Recibos/Doacao").mkdirs();
                String arquivo = "Recibos/Doacao/Doacao " + doacao.getId().toString() + " " + doacao.getDoador().getNome()+ ".pdf";
                gerarPDF(templatePreenchido, arquivo);
                log.registrarLog(2, "Metodos", "gerarReciboDoacao", "", "Recibo gerado em: " + arquivo);
            } catch (IOException e) {
                e.printStackTrace();
                log.registrarLog(4, "Metodos", "gerarReciboDoacao", "", "Recibo não foi gerado");
            }
        } else {
            String template = Relatorio.templateDoacaoProduto();

            StringBuilder produtosHtml = new StringBuilder();
            int qtdProd = 1;
            for (Produto produto : doacao.getProduto()) {
                produtosHtml.append("<div class='item'>")
                            .append("<span class='item-tipo'> Item "+ qtdProd +" - ").append(produto.getTipo().toString()).append(" - </span>")
                            .append("<span class='item-descricao'>").append(produto.getNome()).append(" - </span>")
                            .append("<span class='item-quantidade'>").append(produto.getQuantidade()).append(" un</span>")
                            .append("</div>");
                qtdProd++;
            }

            String templatePreenchido = template
                .replace("{{codigo}}", doacao.getId().toString())
                .replace("{{nome}}", doacao.getDoador().getNome())
                .replace("{{produtos}}", produtosHtml.toString())
                .replace("{{data}}", doacao.getDataDoacao().format(formatador));

            try {
                new File("Recibos").mkdirs();
                String arquivo = "Recibos/Doacao/Doacao " + doacao.getId().toString() + " " + doacao.getDoador().getNome()+ ".pdf";
                gerarPDF(templatePreenchido, arquivo);
                log.registrarLog(2, "Metodos", "gerarReciboDoacao", "", "Recibo gerado em: " + arquivo);
            } catch (IOException e) {
                e.printStackTrace();
                log.registrarLog(4, "Metodos", "gerarReciboDoacao", "", "Recibo não foi gerado");
            }
        }
    }

    public void gerarRelatorioDoacoes(Doacao doacao) throws IOException {
        log.registrarLog(1, "Metodos", "gerarRelatorioDoacoes", "", "Gerando recibo da Doação");

        DateTimeFormatter formatador = DateTimeFormatter.ofPattern("dd/MM/yyyy");

        if (doacao.getProduto().isEmpty()) {
            String template = Relatorio.templateDoacaoDinheiro();
            String templatePreenchido = template
                .replace("{{codigo}}", doacao.getId().toString())
                .replace("{{nome}}", doacao.getDoador().getNome())
                .replace("{{valor}}", String.format("R$ %.2f", doacao.getValor()))
                .replace("{{data}}", doacao.getDataDoacao().format(formatador));
            try {
                new File("Recibos/Doacao").mkdirs();
                String arquivo = "Recibos/Doacao/Doacao " + doacao.getId().toString() + " " + doacao.getDoador().getNome()+ ".pdf";
                gerarPDF(templatePreenchido, arquivo);
                log.registrarLog(2, "Metodos", "gerarRelatorioDoacao", "", "Recibo gerado em: " + arquivo);
            } catch (IOException e) {
                e.printStackTrace();
                log.registrarLog(4, "Metodos", "gerarRelatorioDoacao", "", "Recibo não foi gerado");
            }
        } else {
            String template = Relatorio.templateDoacaoProduto();

            StringBuilder produtosHtml = new StringBuilder();
            int qtdProd = 1;
            for (Produto produto : doacao.getProduto()) {
                produtosHtml.append("<div class='item'>")
                            .append("<span class='item-tipo'> Item "+ qtdProd +" - ").append(produto.getTipo().toString()).append(" - </span>")
                            .append("<span class='item-descricao'>").append(produto.getNome()).append(" - </span>")
                            .append("<span class='item-quantidade'>").append(produto.getQuantidade()).append(" un</span>")
                            .append("</div>");
                qtdProd++;
            }

            String templatePreenchido = template
                .replace("{{codigo}}", doacao.getId().toString())
                .replace("{{nome}}", doacao.getDoador().getNome())
                .replace("{{produtos}}", produtosHtml.toString())
                .replace("{{data}}", doacao.getDataDoacao().format(formatador));

            try {
                new File("Recibos").mkdirs();
                String arquivo = "Recibos/Doacao/Doacao " + doacao.getId().toString() + " " + doacao.getDoador().getNome()+ ".pdf";
                gerarPDF(templatePreenchido, arquivo);
                log.registrarLog(2, "Metodos", "gerarRelatorioDoacao", "", "Recibo gerado em: " + arquivo);
            } catch (IOException e) {
                e.printStackTrace();
                log.registrarLog(4, "Metodos", "gerarRelatorioDoacao", "", "Recibo não foi gerado");
            }
        }
        
    }

    public void gerarReciboPedido(Pedido pedido) throws IOException {
        log.registrarLog(1, "Metodos", "gerarReciboPedido", "", "Gerando recibo da Abertura do Pedido");

        DateTimeFormatter formatador = DateTimeFormatter.ofPattern("dd/MM/yyyy");

        String template = Relatorio.templateAberturaPedido();
        
        String tipo = "";
        if (pedido.getCliente().getTipoUsuario() == TipoCad.BENEFICIARIO) {
            tipo = "Beneficiário";
        } else if (pedido.getCliente().getTipoUsuario() == TipoCad.ASSISTENTE) {
            tipo = "Assistente";
        }

        String local = "";
        if (pedido.getCliente().getLocal() == Local.HOSPITAL) {
            local = "Hospital São José";
        } else if (pedido.getCliente().getLocal() == Local.PRONTOSOCORRO) {
            local = "Pronto Socorro Municipal";
        }

        String paciente = "";
        if (pedido.getCliente().getPaciente() != null) {
            paciente = pedido.getCliente().getPaciente().getNome();
        }

        String observacao = "";
        if (pedido.getObservacao() != null && !pedido.getObservacao().isEmpty()) {
            observacao = pedido.getObservacao();
        }

        String templatePreenchido = template
            .replace("{{codigo}}", pedido.getId().toString())
            .replace("{{local}}", local)
            .replace("{{dataPedido}}", pedido.getDataPedido().format(formatador))
            .replace("{{tipo}}", tipo)
            .replace("{{nome}}", pedido.getCliente().getNome())
            .replace("{{paciente}}", paciente)
            .replace("{{quantidades}}", pedido.getQuantMarmita().toString())
            .replace("{{observacao}}", observacao);

        try {
            new File("Recibos").mkdirs();
            String arquivo = "Recibos/Pedido/Pedido " + pedido.getId().toString() + " " + pedido.getCliente().getNome()+ ".pdf";
            gerarPDF(templatePreenchido, arquivo);
            log.registrarLog(2, "Metodos", "gerarReciboPedido", "", "Recibo gerado em: " + arquivo);
        } catch (IOException e) {
            e.printStackTrace();
            log.registrarLog(4, "Metodos", "gerarReciboPedido", "", "Recibo não foi gerado");
        }
    }

    private void gerarPDF(String templatePreenchido, String arquivo) throws IOException {
        log.registrarLog(1, "Metodos", "gerarPDF", "", "Gerando arquivo PDF");

        try (OutputStream os = new FileOutputStream(arquivo)) {
            ITextRenderer renderer = new ITextRenderer();
            renderer.setDocumentFromString(templatePreenchido);
            renderer.layout();
            renderer.createPDF(os);
            log.registrarLog(2, "Metodos", "gerarPDF", "", "Arquivo PDF gerado");
        } catch (Exception e) {
            e.printStackTrace();
            log.registrarLog(4, "Metodos", "gerarPDF", "", "Arquivo PDF não foi gerado");
            throw new IOException();
        }
    }

    public void relatorioDoacao() throws SQLException {
        String data1 = "2023-06-01";
        LocalDate dataTeste1 = LocalDate.parse(data1);
        String data2 = "2023-06-30"; 
        LocalDate dataTeste2 = LocalDate.parse(data2);
        RetornoDoacoes relatorio = doacaoController.filtrarRelatorio(null, null, "Todos", "Todos", null, null, "data", "desc");
        System.out.println("Relatório de Doações:");
        for (RelDoacao rel : relatorio.getDoacoes()) {
            System.out.println("ID: " + rel.getIdDoacao() + 
                               "\nDoador: " + rel.getIdDoador() +" "+ rel.getNomeDoador() +", Tipo: " + rel.getTipo() + ", Valor: " + rel.getValor() + ", Produtos: " + rel.getProdutos() + ", Observação: "+ rel.getObservacao() +", Data: " + rel.getData());
        }
        RelDoacao totalizacao = relatorio.getTotalizacao();
        System.out.println("Totalização:"+ 
                           "\nValor total: "+ totalizacao.getTotalValor() +", Produtos total: "+ totalizacao.getTotalProdutos() +", Itens total: "+ totalizacao.getTotalItens());
    }

    public void listarDoacoes() throws SQLException {
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
        List<Pessoa> listagemPessoas = pessoaController.listarPessoas("", "Todos", "Todas");
        System.out.println("Lista de Pessoas:");
        for (Pessoa pessoa : listagemPessoas) {
            System.out.println("ID: " + pessoa.getId() + 
                               "\nPessoa: " + pessoa.getNome() + ", Cidade: " + pessoa.getCidadeCompleta() +", Observação: " + pessoa.getObservacao());
        }
    }

    public void listarProdutos() throws SQLException {
        List<Produto> listagemProdutos = produtoController.listarProdutos("", "Todos");
        System.out.println("Lista de Produtos:");
        for (Produto produto : listagemProdutos) {
            System.out.println("ID: " + produto.getId() + 
                               "\nProduto: " + produto.getNome());
        }
    }
}