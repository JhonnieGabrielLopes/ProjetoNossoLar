package br.edu.iftm.sistemanossolar.view;

import java.io.IOException;

import java.sql.Connection;
import java.sql.SQLException;

import br.edu.iftm.sistemanossolar.controller.RelatorioController;

public class Metodos {

    private static RelatorioController relatorioController;

    RegistrosLog log = new RegistrosLog();

    public Metodos(Connection conexao) {
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
        System.out.println("21 - Relatorio de Pedidos");
        System.out.println("22 - Sair");
        System.out.println("Escolha uma opção: ");
    }

    public void relatorioDoacao() throws SQLException, IOException {
        //METODO PARA TESTES NO TERMINAL
        relatorioController.relatorioDoacao();
    }

}
