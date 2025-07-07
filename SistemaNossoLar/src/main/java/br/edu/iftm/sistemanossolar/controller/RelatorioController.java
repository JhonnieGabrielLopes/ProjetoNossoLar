package br.edu.iftm.sistemanossolar.controller;

import java.awt.Desktop;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

import java.nio.charset.StandardCharsets;
import java.sql.Connection;
import java.sql.SQLException;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

import java.util.List;
import java.util.concurrent.atomic.AtomicReference;

import org.xhtmlrenderer.pdf.ITextRenderer;

import br.edu.iftm.sistemanossolar.controller.doacao.DoacaoController;
import br.edu.iftm.sistemanossolar.model.doacao.Doacao;
import br.edu.iftm.sistemanossolar.model.doacao.Produto;
import br.edu.iftm.sistemanossolar.model.pedido.Pedido;
import br.edu.iftm.sistemanossolar.model.pessoa.Pessoa.Local;
import br.edu.iftm.sistemanossolar.model.pessoa.Pessoa.TipoCad;
import br.edu.iftm.sistemanossolar.model.relatorio.RelDoacao;
import br.edu.iftm.sistemanossolar.model.relatorio.RelPedido;
import br.edu.iftm.sistemanossolar.model.relatorio.RetornoDoacoes;
import br.edu.iftm.sistemanossolar.view.RegistrosLog;

public class RelatorioController {
    private DoacaoController doacaoController;

    public RelatorioController(Connection conexao) {
        this.doacaoController = new DoacaoController(conexao);
    }

    RegistrosLog log = new RegistrosLog();

    public static String preencherTemplate(String caminho) throws IOException {
        try (InputStream inputStream = RelatorioController.class.getClassLoader().getResourceAsStream(caminho)) {
            if (inputStream == null) {
                throw new IOException("Template não encontrado no diretório "+ caminho);
            }
            return new String(inputStream.readAllBytes(), StandardCharsets.UTF_8);
        }
    }

    public static String templateDoacaoDinheiro() throws IOException {
        return preencherTemplate("relatorio/doacao/reciboDinheiro.html");
    }

    public static String templateDoacaoProduto() throws IOException {
        return preencherTemplate("relatorio/doacao/reciboProduto.html");
    }

    public static String templateAberturaPedido() throws IOException {
        return preencherTemplate("relatorio/pedido/reciboAbertura.html");
    }

    public static String templateRelatorioDoacoes() throws IOException {
        return preencherTemplate("relatorio/doacao/relatorioDoacoes.html");
    }

    public static String templateRelatorioPedidos() throws IOException {
        return preencherTemplate("relatorio/pedido/relatorioPedidos.html");
    }

    public void criarArquivo(String diretorio, String caminho, String templatePreenchido) {
        log.registrarLog(1, "RelatorioController", "criarArquivo", "", "Criando o arquivo '.pdf'");
        try {
            new File(diretorio).mkdirs();
            montarArquivo(templatePreenchido, caminho);
            log.registrarLog(2, "RelatorioController", "criarArquivo", "", "Arquivo '.pdf' gerado em: "+ caminho);
        } catch (IOException e) {
            e.printStackTrace();
            log.registrarLog(4, "RelatorioController", "criarArquivo", "", "Arquivo '.pdf' não foi gerado");
        }
    }

    private void montarArquivo(String templatePreenchido, String arquivo) throws IOException {
        log.registrarLog(1, "RelatorioController", "montarArquivo", "", "Montando arquivo '.pdf' no template");
        try (OutputStream os = new FileOutputStream(arquivo)) {
            ITextRenderer renderer = new ITextRenderer();
            renderer.getSharedContext().setBaseURL("file:///C:/SistemaNossoLar/SistemaNossoLar/src/main/resources/relatorio/");
            renderer.setDocumentFromString(templatePreenchido);
            renderer.layout();
            renderer.createPDF(os);
            log.registrarLog(2, "RelatorioController", "montarArquivo", "", "Arquivo '.pdf' montado");
        } catch (Exception e) {
            e.printStackTrace();
            log.registrarLog(4, "RelatorioController", "montarArquivo", "", "Arquivo '.pdf' não foi montado");
            throw new IOException();
        }
    }

    public void abrirPDF(String caminhoArquivo) {
        try {
            File arquivo = new File(caminhoArquivo);
            if (!arquivo.exists()) {
                log.registrarLog(3, "RelatorioController", "abrirPDF", "", "O arquivo não existe: " + caminhoArquivo);
                return;
            } else {
                log.registrarLog(2, "RelatorioController", "abrirPDF", "", "Abrindo o arquivo: " + caminhoArquivo);
                Desktop desktop = Desktop.getDesktop();
                desktop.open(arquivo);
            }

        } catch (IOException e) {
            log.registrarLog(4, "RelatorioController", "abrirPDF", "", "Erro ao tentar abrir o arquivo: " + e.getMessage());
        }
    }

    public boolean gerarReciboDoacao(Doacao doacao, AtomicReference<String> diretorioArquivoDoa) throws IOException {
        log.registrarLog(1, "RelatorioController", "gerarReciboDoacao", "", "Gerando recibo da Doação");
        DateTimeFormatter formatador = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        if (doacao.getProduto().isEmpty()) {
            String template = RelatorioController.templateDoacaoDinheiro();
            String templatePreenchido = template
                .replace("{{codigo}}", doacao.getId().toString())
                .replace("{{nome}}", doacao.getDoador().getNome())
                .replace("{{valor}}", String.format("R$ %.2f", doacao.getValor()))
                .replace("{{data}}", doacao.getDataDoacao().format(formatador));

            String diretorio = "C:\\SistemaNossoLar\\Recibos\\Doacao";
            String arquivo = diretorio+ "\\Doacao " +doacao.getId().toString()+ ".pdf";
            try {
                criarArquivo(diretorio, arquivo, templatePreenchido);
                diretorioArquivoDoa.set(arquivo);
                return true;
            } catch (Exception e) {
                e.getStackTrace();
                return false;
            }
            
        } else {
            String template = RelatorioController.templateDoacaoProduto();

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

            String diretorio = "C:\\SistemaNossoLar\\Recibos\\Doacao";
            String arquivo = diretorio+ "\\Doacao " +doacao.getId().toString()+ ".pdf";
            try {
                criarArquivo(diretorio, arquivo, templatePreenchido);
                diretorioArquivoDoa.set(arquivo);
                return true;
            } catch (Exception e) {
                e.getStackTrace();
                return false;
            }
        }
    }

    public void relatorioDoacao() throws SQLException, IOException {
        //METODO PARA TESTES NO TERMINAL
        String data1 = "2023-01-01";
        LocalDate dataTeste1 = LocalDate.parse(data1);
        String data2 = "2023-12-30"; 
        LocalDate dataTeste2 = LocalDate.parse(data2);
        RetornoDoacoes relatorio = doacaoController.filtrarRelatorio(null, null, "Todos", "Todos", null, null, "data", "asc");
        //Situação: quando preenchido o codigo do produto, o resultado não retorna todos os produtos da doação.
        gerarRelatorioDoacoes(relatorio.getDoacoes(), relatorio.getTotalizacao(), relatorio.getFiltros());
    }

    public void gerarRelatorioDoacoes(List<RelDoacao> dados, RelDoacao totalizacao, List<Object> filtros) throws IOException {
        log.registrarLog(1, "RelatorioController", "gerarRelatorioDoacoes", "", "Gerando relatorio de Doações");

        DateTimeFormatter formatador = DateTimeFormatter.ofPattern("dd/MM/yyyy");

        String template = RelatorioController.templateRelatorioDoacoes();

        StringBuilder resultado = new StringBuilder();
        int qtdRegistros = 0;
        String nomeDoador = "";
        for (RelDoacao doacao : dados) {
            boolean temProduto = doacao.getProdutos() != null && !doacao.getProdutos().isEmpty();
                
            resultado.append("<tr>");
                
            resultado.append("<td style='border-bottom:")
                     .append(temProduto ? "none" : "1px solid #000")
                     .append("; text-align: center;'>")
                     .append("<span>")
                     .append(doacao.getIdDoacao())
                     .append("</span></td>");
                
            nomeDoador = doacao.getNomeDoador();
            resultado.append("<td style='border-bottom:")
                     .append(temProduto ? "none" : "1px solid #000").append("'><span>")
                     .append(nomeDoador).append("</span></td>");
                
            resultado.append("<td style='border-bottom:")
                     .append(temProduto ? "none" : "1px solid #000").append("'><span>")
                     .append(doacao.getTipo()).append("</span></td>");
                
            resultado.append("<td style='border-bottom:")
                     .append(temProduto ? "none" : "1px solid #000").append("'><span>");
            if (doacao.getValor() != 0) {
                resultado.append("R$ ").append(String.format("%.2f", doacao.getValor()));
            }
            resultado.append("</span></td>");
        
            resultado.append("<td style='border-bottom:")
                     .append(temProduto ? "none" : "1px solid #000").append("'><span>")
                     .append(doacao.getObservacao()).append("</span></td>");
        
            resultado.append("<td style='border-bottom:")
                     .append(temProduto ? "none" : "1px solid #000").append("'><span>")
                     .append(formatador.format(doacao.getData())).append("</span></td>");
        
            resultado.append("</tr>");
        
            if (temProduto) {
                resultado.append("<tr class='detalhes-produto'>")
                         .append("<td colspan='6' style='border-bottom: 1px solid #000; padding-left: 37px;'>")
                         .append("<strong>Produtos:</strong> <span>")
                         .append(doacao.getProdutos())
                         .append("</span></td>")
                         .append("</tr>");
            }
            qtdRegistros++;
        }

        LocalDate dataInicio = (LocalDate) filtros.get(0);
        LocalDate dataFim = (LocalDate) filtros.get(1);

        if (filtros.get(0) != null) {
            template = template.replace("{{dataInicio}}", formatador.format(dataInicio).toString());
        } else {
            template = template.replace("{{dataInicio}}", "");
        }

        if (filtros.get(1) != null) {
            template = template.replace("{{dataFim}}", formatador.format(dataFim).toString());
        } else {
            template = template.replace("{{dataFim}}", "");
        }

        template = template.replace("{{tipoDoacao}}", filtros.get(2).toString());
        template = template.replace("{{tipoProduto}}", filtros.get(3).toString());

        if (filtros.get(4) != null) {
            template = template.replace("{{filtroDoador}}", nomeDoador);
        } else {
            template = template.replace("{{filtroDoador}}", "");
        }

        if (filtros.get(5) != null) {
            template = template.replace("{{filtroProduto}}", filtros.get(5).toString());
        } else {
            template = template.replace("{{filtroProduto}}", "");
        }

        StringBuilder ordem = new StringBuilder();
        if (filtros.get(6) != null) {
            switch (filtros.get(6).toString()) {
                case "data": ordem.append("Data"); break;
                case "codigo": ordem.append("Código"); break;
                case "nome": ordem.append("Nome do Doador"); break;
                case "valor": ordem.append("Valor"); break;
                case "quantidade": ordem.append("Quantidade de Produtos"); break;
            }
            template = template.replace("{{ordenacao}}", ordem);
        }

        if (filtros.get(7) != null) {
            StringBuilder sentido = new StringBuilder();
            sentido.append(filtros.get(7).equals("asc") ? "Crescente" : "Decrescente");
            template = template.replace("{{sentido}}", sentido);
        }

        LocalDateTime agora = LocalDateTime.now();
        template = template.replace("{{resultados}}", resultado.toString())
                           .replace("{{qtdDoacoes}}", String.valueOf(qtdRegistros))
                           .replace("{{vlrTotal}}", "R$ "+ String.format("%.2f", totalizacao.getTotalValor()))
                           .replace("{{qtdProdutos}}", String.valueOf(totalizacao.getTotalProdutos()))
                           .replace("{{qtdItens}}", String.valueOf(totalizacao.getTotalItens()))
                           .replace("{{dataEmissao}}", formatador.format(agora));
        String templatePreenchido = template;

        String diretorio = "C:\\SistemaNossoLar\\Relatorios\\Doacao";
        formatador = DateTimeFormatter.ofPattern("ddMMyyyyHHmm");
        String dataHoraAgora = agora.format(formatador);
        String arquivo = diretorio + "\\Doacoes " +dataHoraAgora+ ".pdf";
        criarArquivo(diretorio, arquivo, templatePreenchido);
    }

    public boolean gerarReciboPedido(Pedido pedido, AtomicReference<String> diretorioArquivo) throws IOException {
        log.registrarLog(1, "Metodos", "gerarReciboPedido", "", "Gerando recibo da Abertura do Pedido");

        DateTimeFormatter formatador = DateTimeFormatter.ofPattern("dd/MM/yyyy");

        String template = RelatorioController.templateAberturaPedido();
        
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
        if (pedido.getCliente() != null &&
            pedido.getCliente().getPaciente() != null &&
            pedido.getCliente().getPaciente().getNome() != null &&
            !pedido.getCliente().getPaciente().getNome().trim().isEmpty()) {
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

        String diretorio = "C:\\SistemaNossoLar\\Recibos\\Pedidos";
        String arquivo = diretorio + "\\Pedido " +pedido.getId().toString()+ ".pdf";
        try {
            criarArquivo(diretorio, arquivo, templatePreenchido);
            diretorioArquivo.set(arquivo);
            return true;
        } catch (Exception e) {
            return false;
        }
    }

    public boolean gerarRelatorioPedidos(List<RelPedido> dados, RelPedido totalizacao, List<Object> filtros, AtomicReference<String> diretorioArquivo) throws IOException {
        log.registrarLog(1, "RelatorioController", "gerarRelatorioPedidos", "", "Gerando relatorio de Pedidos");

        DateTimeFormatter formatador = DateTimeFormatter.ofPattern("dd/MM/yyyy");

        String template = RelatorioController.templateRelatorioPedidos();

        StringBuilder resultado = new StringBuilder();
        int qtdRegistros = 0;
        String nomeCliente = "";
        for (RelPedido pedido : dados) {
            boolean temObservacao = pedido.getObservacao() != null && !pedido.getObservacao().isEmpty();
                
            resultado.append("<tr>");
            resultado.append("<td style='border-bottom:")
                     .append(temObservacao ? "none" : "1px solid #000")
                     .append("; text-align: center;'>")
                     .append("<span>")
                     .append(pedido.getIdPedido())
                     .append("</span></td>");
            resultado.append("<td style='border-bottom:")
                     .append(temObservacao ? "none" : "1px solid #000")
                     .append("; '>")
                     .append("<span>")
                     .append(pedido.getStatus())
                     .append("</span></td>");
            nomeCliente = pedido.getNomeCliente();
            resultado.append("<td style='border-bottom:")
                     .append(temObservacao ? "none" : "1px solid #000").append("'><span>")
                     .append(nomeCliente).append("</span></td>");
            resultado.append("<td style='border-bottom:")
                     .append(temObservacao ? "none" : "1px solid #000").append("'><span>")
                     .append(pedido.getLocal()).append("</span></td>");
            resultado.append("<td style='border-bottom:")
                     .append(temObservacao ? "none" : "1px solid #000")
                     .append("; text-align: center;'>")
                     .append("<span>")
                     .append(pedido.getQtdMarmitas()).append("</span></td>");
            resultado.append("<td style='border-bottom:")
                     .append(temObservacao ? "none" : "1px solid #000")
                     .append("; text-align: center;'>")
                     .append("<span>")
                     .append(formatador.format(pedido.getDataPedido())).append("</span></td>");

            if (pedido.getDataEntrega() != null) {
                resultado.append("<td style='border-bottom:")
                     .append(temObservacao ? "none" : "1px solid #000")
                     .append("; text-align: center;'>")
                     .append("<span>")
                     .append(formatador.format(pedido.getDataEntrega())).append("</span></td>");
            } else {
                resultado.append("<td style='border-bottom:")
                     .append(temObservacao ? "none" : "1px solid #000").append("'><span>")
                     .append("").append("</span></td>");
            }

            resultado.append("</tr>");
            if (temObservacao) {
                resultado.append("<tr class='detalhes-produto'>")
                         .append("<td colspan='7' style='border-bottom: 1px solid #000; padding-left: 41px;'>")
                         .append("<strong>Observação:</strong> <span>")
                         .append(pedido.getObservacao())
                         .append("</span></td>")
                         .append("</tr>");
            }
            qtdRegistros++;
        }

        LocalDate dataPedidoInicio = (LocalDate) filtros.get(0);
        LocalDate dataPedidoFim = (LocalDate) filtros.get(1);
        LocalDate dataEntregaInicio = (LocalDate) filtros.get(2);
        LocalDate dataEntregaFim = (LocalDate) filtros.get(3);

        if (filtros.get(0) != null) {
            template = template.replace("{{dataPedidoInicio}}", formatador.format(dataPedidoInicio).toString());
        } else {
            template = template.replace("{{dataPedidoInicio}}", "");
        }

        if (filtros.get(1) != null) {
            template = template.replace("{{dataPedidoFim}}", formatador.format(dataPedidoFim).toString());
        } else {
            template = template.replace("{{dataPedidoFim}}", "");
        }

        if (filtros.get(2) != null) {
            template = template.replace("{{dataEntregaInicio}}", formatador.format(dataEntregaInicio).toString());
        } else {
            template = template.replace("{{dataEntregaInicio}}", "");
        }

        if (filtros.get(3) != null) {
            template = template.replace("{{dataEntregaFim}}", formatador.format(dataEntregaFim).toString());
        } else {
            template = template.replace("{{dataEntregaFim}}", "");
        }

        template = template.replace("{{filtroStatus}}", filtros.get(4).toString());

        if (filtros.get(5) != null) {
            template = template.replace("{{filtroCliente}}", nomeCliente);
        } else {
            template = template.replace("{{filtroCliente}}", "");
        }

        template = template.replace("{{filtroLocal}}", filtros.get(6).toString());
        template = template.replace("{{filtroCidade}}", filtros.get(7).toString());

        StringBuilder ordem = new StringBuilder();
        if (filtros.get(8) != null) {
            switch (filtros.get(8).toString()) {
                case "codigo": ordem.append("Código"); break;
                case "status": ordem.append("Status"); break;
                case "quantidade": ordem.append("Marmitas"); break;
                case "dataPedido": ordem.append("Data do Pedido"); break;
                case "dataEntrega": ordem.append("Data da Entrega"); break;
                case "nome": ordem.append("Cliente"); break;
            }
            template = template.replace("{{ordenacao}}", ordem);
        }

        if (filtros.get(9) != null) {
            StringBuilder sentido = new StringBuilder();
            sentido.append(filtros.get(9).equals("asc") ? "Crescente" : "Decrescente");
            template = template.replace("{{sentido}}", sentido);
        }

        formatador = DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm:ss");
        LocalDateTime agora = LocalDateTime.now();
        template = template.replace("{{resultados}}", resultado.toString())
                           .replace("{{qtdPedidos}}", String.valueOf(qtdRegistros))
                           .replace("{{totalMarmitas}}", String.valueOf(totalizacao.getTotalMarmitas()))
                           .replace("{{totalAbertos}}", String.valueOf(totalizacao.getTotalPendente()))
                           .replace("{{totalFechados}}", String.valueOf(totalizacao.getTotalFechado()))
                           .replace("{{totalCancelados}}", String.valueOf(totalizacao.getTotalCancelado()))
                           .replace("{{dataEmissao}}", formatador.format(agora));
        String templatePreenchido = template;

        String diretorio = "C:\\SistemaNossoLar\\Relatorios\\Pedido";
        formatador = DateTimeFormatter.ofPattern("ddMMyyyyHHmm");
        String dataHoraAgora = agora.format(formatador);
        String arquivo = diretorio + "\\Pedidos " +dataHoraAgora+ ".pdf";
        try {
            criarArquivo(diretorio, arquivo, templatePreenchido);
            diretorioArquivo.set(arquivo);
            return true;
        } catch (Exception e) {
            return false;
        }
        
    }
}