package br.edu.iftm.sistemanossolar;

import java.sql.Connection;
import java.util.Scanner;

import br.edu.iftm.sistemanossolar.dao.ConexaoBanco;

import br.edu.iftm.sistemanossolar.view.Metodos;

public class SistemaNossoLar {
    public static void main(String[] args) {
        try (Connection conexao = ConexaoBanco.getConnection()) {
            Metodos metodos = new Metodos(conexao);
            boolean controle = true;
            Scanner scan = new Scanner(System.in);

            do {
                metodos.menuPrincipal();
                int opcao = scan.nextInt();
                scan.nextLine();

                switch (opcao) {
                    case 1:
                        System.out.println("[ALR] SistemaNossoLar | main - Cadastro de usuario");

                        if (metodos.cadastrarUsuario(scan)) {
                            System.out.println("[ALR] SistemaNossoLar | main - Usuário cadastrado");
                        } else {
                            System.out.println("[ALR] SistemaNossoLar | main - Usuário não cadastrado");
                        }

                        controle = false;
                        break;

                    case 2:
                        System.out.println("[ALR] SistemaNossoLar | main - Cadastro de endereço");

                        if (metodos.cadastrarEndereco(scan)) {
                            System.out.println("[ALR] SistemaNossoLar | main - Endereço cadastrado");
                        } else {
                            System.out.println("[ALR] SistemaNossoLar | main - Endereço não cadastrado");

                        }

                        controle = false;
                        break;

                    case 3:
                        System.out.println("[ALR] SistemaNossoLar | main - Cadastro de cidade");

                        if (metodos.cadastrarCidade(scan)) {
                            System.out.println("[ALR] SistemaNossoLar | main - Cidade cadastrada");
                        } else {
                            System.out.println("[ALR] SistemaNossoLar | main - Cidade não cadastrada");
                        }

                        controle = false;
                        break;

                    case 4:
                        System.out.println("[ALR] SistemaNossoLar | main - Fechando sistema");
                        controle = true;
                        break;

                    default:
                        controle = false;
                        System.out.println("[ALR] SistemaNossoLar | main - Opção inválida.");
                        break;
                }
            } while (!controle);

        } catch (Exception e) {
            System.err.println("[ERR] SistemaNossoLar | main - Erro na conexão com o Banco de Dados.");
            e.printStackTrace();
        }
    }

}