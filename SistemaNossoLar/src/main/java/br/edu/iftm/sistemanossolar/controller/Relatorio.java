package br.edu.iftm.sistemanossolar.controller;

import java.io.IOException;
import java.io.InputStream;
import java.nio.charset.StandardCharsets;

public class Relatorio {

    public static String templateDoacaoDinheiro() throws IOException {
        String caminho = "relatorio/doacao/reciboDinheiro.html";
        
        try (InputStream inputStream = Relatorio.class.getClassLoader().getResourceAsStream(caminho)) {
            if (inputStream == null) {
                throw new IOException("TemplateArquivo não encontrado: " + caminho);
            }
            return new String(inputStream.readAllBytes(), StandardCharsets.UTF_8);
        }
    }

    public static String templateDoacaoProduto() throws IOException {
        String caminho = "relatorio/doacao/reciboProduto.html";
        
        try (InputStream inputStream = Relatorio.class.getClassLoader().getResourceAsStream(caminho)) {
            if (inputStream == null) {
                throw new IOException("TemplateArquivo não encontrado: " + caminho);
            }
            return new String(inputStream.readAllBytes(), StandardCharsets.UTF_8);
        }
    }

    public static String templateAberturaPedido() throws IOException {
        String caminho = "relatorio/pedido/reciboAbertura.html";
        
        try (InputStream inputStream = Relatorio.class.getClassLoader().getResourceAsStream(caminho)) {
            if (inputStream == null) {
                throw new IOException("TemplateArquivo não encontrado: " + caminho);
            }
            return new String(inputStream.readAllBytes(), StandardCharsets.UTF_8);
        }
    }

}