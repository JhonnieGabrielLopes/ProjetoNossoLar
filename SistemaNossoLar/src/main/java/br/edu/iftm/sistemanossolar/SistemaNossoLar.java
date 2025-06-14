package br.edu.iftm.sistemanossolar;

import java.sql.Connection;
import java.util.Scanner;

import br.edu.iftm.sistemanossolar.dao.ConexaoDAO;
import br.edu.iftm.sistemanossolar.model.doacao.Produto;
import br.edu.iftm.sistemanossolar.view.Metodos;
import br.edu.iftm.sistemanossolar.view.RegistrosLog;
import br.edu.iftm.sistemanossolar.view.Telas;

public class SistemaNossoLar {

    static RegistrosLog log = new RegistrosLog();

    public static void main(String[] args) {
        log.registrarLog(1, "SistemaNossoLar", "main", "", "Iniciando o sistema");
        try (Connection conexao = ConexaoDAO.getConnection()) {
            log.registrarLog(2, "SistemaNossoLar", "main", "", "Conexão estabelecida com o Banco de Dados");
            Telas tela = new Telas(conexao);
            tela.setVisible(true);
            Metodos metodos = new Metodos(conexao);
            boolean controle = true;
            Scanner scan = new Scanner(System.in);

            do {
                metodos.menuPrincipal();
                int opcao = scan.nextInt();
                scan.nextLine();

                switch (opcao) {
                    case 1:
                        metodos.cadastrarUsuario(scan);
                        //ERRO 1:
                        //AO SELECIONE O LOCAL PRONTO SOCORRO ESTA SENDO SEMPRE GRAVADO COMO HOSPITAL NO BANCO
                        controle = false;
                        break;

                    case 2:
                        metodos.cadastrarEndereco(scan);
                        controle = false;
                        break;

                    case 3:
                        metodos.cadastrarCidade(scan);
                        controle = false;
                        break;
                    
                    case 4:
                        metodos.cadastrarDoacao(scan);
                        controle = false;
                        break;

                    case 5:
                        metodos.cadastrarPedido(scan);
                        //ERRO 2:
                        //AO CADASTRAR O PEDIDO NAO ESTA SENDO CRIADA A PASTA PEDIDO DENTRO DO DIRETORIO RECIBO, QUANDO O MESMO NÃO EXISTE
                        controle = false;
                        break;

                    case 6:
                        metodos.cadastrarProduto(scan, new Produto());
                        controle = false;
                        break;

                    case 20:
                        metodos.relatorioDoacao();
                        controle = false;
                        break;

                    case 21:
                        metodos.buscarDoacoes();
                        controle = false;
                        break;

                    case 22:
                        log.registrarLog(1, "SistemaNossoLar", "main", "", "Encerrando o sistema");
                        controle = true;
                        break;

                    default:
                        log.registrarLog(3, "SistemaNossoLar", "main", "", "Opção inválida");
                        controle = false;
                        break;
                }
            } while (!controle);

        } catch (Exception e) {
            e.printStackTrace();
            log.registrarLog(4, "SistemaNossoLar", "main", "", "Erro ao conectar com o Banco de Dados");
        }
    }

}