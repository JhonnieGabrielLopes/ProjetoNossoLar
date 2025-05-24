package br.edu.iftm.sistemanossolar;

import java.sql.Connection;
import java.util.Scanner;

import br.edu.iftm.sistemanossolar.dao.ConexaoDAO;

import br.edu.iftm.sistemanossolar.view.Metodos;
import br.edu.iftm.sistemanossolar.view.RegistrosLog;

public class SistemaNossoLar {
    public static final String RESET = "\u001B[0m";
    public static final String VERMELHO = "\u001B[31m";
    public static final String VERDE = "\u001B[32m";
    public static final String AMARELO = "\u001B[33m";
    public static final String AZUL = "\u001B[34m";

    static RegistrosLog log = new RegistrosLog();

    public static void main(String[] args) {
        log.registrarLog(1, "SistemaNossoLar", "main", "", "Iniciando o sistema");
        try (Connection conexao = ConexaoDAO.getConnection()) {
            log.registrarLog(2, "SistemaNossoLar", "main", "", "Conexão estabelecida com o Banco de Dados");
            Metodos metodos = new Metodos(conexao);
            boolean controle = true;
            Scanner scan = new Scanner(System.in);

            do {
                metodos.menuPrincipal();
                int opcao = scan.nextInt();
                scan.nextLine();

                switch (opcao) {
                    case 1:
                        log.registrarLog(1, "SistemaNossoLar", "main", "", "Cadastro de Usuário");

                        if (metodos.cadastrarUsuario(scan)) {
                            log.registrarLog(2, "SistemaNossoLar", "main", "", "Usuário cadastrado");
                        } else {
                            log.registrarLog(3, "SistemaNossoLar", "main", "", "Usuário não cadastrado");
                        }

                        controle = false;
                        break;

                    case 2:
                        log.registrarLog(1, "SistemaNossoLar", "main", "", "Cadastro de Endereço");

                        if (metodos.cadastrarEndereco(scan)) {
                            log.registrarLog(2, "SistemaNossoLar", "main", "", "Endereço cadastrado");
                        } else {
                            log.registrarLog(3, "SistemaNossoLar", "main", "", "Endereço não cadastrado");
                        }

                        controle = false;
                        break;

                    case 3:
                        log.registrarLog(1, "SistemaNossoLar", "main", "", "Cadastro de Cidade");

                        if (metodos.cadastrarCidade(scan)) {
                            log.registrarLog(2, "SistemaNossoLar", "main", "", "Cidade cadastrada");
                        } else {
                            log.registrarLog(3, "SistemaNossoLar", "main", "", "Cidade não cadastrada");
                        }

                        controle = false;
                        break;

                    case 26:
                        log.registrarLog(1, "SistemaNossoLar", "main", "", "Encerrando o sistema");
                        controle = true;
                        break;

                    default:
                        controle = false;
                        log.registrarLog(3, "SistemaNossoLar", "main", "", "Opção inválida");
                        break;
                }
            } while (!controle);

        } catch (Exception e) {
            log.registrarLog(4, "SistemaNossoLar", "main", "", "Erro ao conectar com o Banco de Dados");
            System.err.println("[" + VERMELHO + "ERR" + RESET + "] SistemaNossoLar | main - Erro na conexão com o Banco de Dados.");
            e.printStackTrace();
        }
    }

}