package br.edu.iftm.sistemanossolar;

import java.sql.Connection;
import java.util.Scanner;

import br.edu.iftm.sistemanossolar.dao.ConexaoBanco;

import br.edu.iftm.sistemanossolar.view.Metodos;

public class SistemaNossoLar {
    public static final String RESET = "\u001B[0m";
    public static final String VERMELHO = "\u001B[31m";
    public static final String VERDE = "\u001B[32m";
    public static final String AMARELO = "\u001B[33m";
    public static final String AZUL = "\u001B[34m";

    public static void main(String[] args) {
        System.out.println("\n[" + AZUL + "INF" + RESET + "] SistemaNossoLar | main - Iniciando sistema...");
        try (Connection conexao = ConexaoBanco.getConnection()) {
            System.out.println("[" + VERDE + "INF" + RESET + "] SistemaNossoLar | main - Conexão estabelecida com o Banco de Dados");
            Metodos metodos = new Metodos(conexao);
            boolean controle = true;
            Scanner scan = new Scanner(System.in);

            do {
                metodos.menuPrincipal();
                int opcao = scan.nextInt();
                scan.nextLine();

                switch (opcao) {
                    case 1:
                        System.out.println("[" + AZUL + "INF" + RESET + "] SistemaNossoLar | main - Cadastro de usuario");

                        if (metodos.cadastrarUsuario(scan)) {
                            System.out.println("[" + VERDE + "INF" + RESET + "] SistemaNossoLar | main - Usuário cadastrado");
                        } else {
                            System.out.println("[" + AMARELO + "ALR" + RESET + "] SistemaNossoLar | main - Usuário não cadastrado");
                        }

                        controle = false;
                        break;

                    case 2:
                        System.out.println("[" + AZUL + "INF" + RESET + "] SistemaNossoLar | main - Cadastro de endereço");

                        if (metodos.cadastrarEndereco(scan)) {
                            System.out.println("[" + VERDE + "INF" + RESET + "] SistemaNossoLar | main - Endereço cadastrado");
                        } else {
                            System.out.println("[" + AMARELO + "ALR" + RESET + "] SistemaNossoLar | main - Endereço não cadastrado");

                        }

                        controle = false;
                        break;

                    case 3:
                        System.out.println("[" + AZUL + "INF" + RESET + "] SistemaNossoLar | main - Cadastro de cidade");

                        if (metodos.cadastrarCidade(scan)) {
                            System.out.println("[" + VERDE + "INF" + RESET + "] SistemaNossoLar | main - Cidade cadastrada");
                        } else {
                            System.out.println("[" + AMARELO + "ALR" + RESET + "] SistemaNossoLar | main - Cidade não cadastrada");
                        }

                        controle = false;
                        break;

                    case 4:
                        System.out.println("[" + AMARELO + "ALR" + RESET + "] SistemaNossoLar | main - Fechando sistema");
                        controle = true;
                        break;

                    default:
                        controle = false;
                        System.out.println("[" + AMARELO + "ALR" + RESET + "] SistemaNossoLar | main - Opção inválida.");
                        break;
                }
            } while (!controle);

        } catch (Exception e) {
            System.err.println("[" + VERMELHO + "ERR" + RESET + "] SistemaNossoLar | main - Erro na conexão com o Banco de Dados.");
            e.printStackTrace();
        }
    }

}