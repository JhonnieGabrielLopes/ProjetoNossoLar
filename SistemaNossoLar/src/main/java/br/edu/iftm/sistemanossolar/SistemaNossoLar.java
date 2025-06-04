package br.edu.iftm.sistemanossolar;

import java.sql.Connection;
import java.util.Scanner;

import br.edu.iftm.sistemanossolar.dao.ConexaoDAO;
import br.edu.iftm.sistemanossolar.model.doacao.Produto;
import br.edu.iftm.sistemanossolar.view.Metodos;
import br.edu.iftm.sistemanossolar.view.RegistrosLog;

public class SistemaNossoLar {

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
                    
                    case 4:
                        log.registrarLog(1, "SistemaNossoLar", "main", "", "Cadastro de Doação");

                        if (metodos.cadastrarDoacao(scan)) {
                            log.registrarLog(2, "SistemaNossoLar", "main", "", "Doação cadastrada");
                        } else {
                            log.registrarLog(3, "SistemaNossoLar", "main", "", "Doação não cadastrada");
                        }
                        break;

                    case 5:
                        log.registrarLog(1, "SistemaNossoLar", "main", "", "Cadastro de Pedido");

                        if (metodos.cadastrarPedido(scan)) {
                            log.registrarLog(2, "SistemaNossoLar", "main", "", "Pedido cadastrado");
                        } else {
                            log.registrarLog(3, "SistemaNossoLar", "main", "", "Pedido não cadastrado");
                        }
                        break;

                    case 6:
                        log.registrarLog(1, "SistemaNossoLar", "main", "", "Cadastro de Produto");

                        if (metodos.cadastrarProduto(scan, new Produto())) {
                            log.registrarLog(2, "SistemaNossoLar", "main", "", "Produto cadastrado");
                        } else {
                            log.registrarLog(3, "SistemaNossoLar", "main", "", "Produto não cadastrado");
                        }
                        break;

                    case 7:
                        log.registrarLog(1, "SistemaNossoLar", "main", "", "Cadastro de Tipo Usuário");

                        if (metodos.cadastrarTipo(scan, 1)) {
                            log.registrarLog(2, "SistemaNossoLar", "main", "", "Tipo Usuário cadastrado");
                        } else {
                            log.registrarLog(3, "SistemaNossoLar", "main", "", "Tipo Usuário não cadastrado");
                        }
                        break;

                    case 8:
                        log.registrarLog(1, "SistemaNossoLar", "main", "", "Cadastro de Tipo Doação");

                        if (metodos.cadastrarTipo(scan, 3)) {
                            log.registrarLog(2, "SistemaNossoLar", "main", "", "Tipo Doação cadastrado");
                        } else {
                            log.registrarLog(3, "SistemaNossoLar", "main", "", "Tipo Doação não cadastrado");
                        }
                        break;

                    case 9:
                        log.registrarLog(1, "SistemaNossoLar", "main", "", "Cadastro de Tipo Produto");

                        if (metodos.cadastrarTipo(scan, 2)) {
                            log.registrarLog(2, "SistemaNossoLar", "main", "", "Tipo Produto cadastrado");
                        } else {
                            log.registrarLog(3, "SistemaNossoLar", "main", "", "Tipo Produto não cadastrado");
                        }
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
            e.printStackTrace();
        }
    }

}