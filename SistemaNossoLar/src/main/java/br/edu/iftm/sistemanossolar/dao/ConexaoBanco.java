package br.edu.iftm.sistemanossolar.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;
import java.io.InputStream;

public class ConexaoBanco {
    public static final String RESET = "\u001B[0m";
    public static final String VERMELHO = "\u001B[31m";
    public static final String AMARELO = "\u001B[33m";

    private static String URL;
    private static String USER;
    private static String PASSWORD;
    private static Connection conexao;

    static {
        try (InputStream dados = ConexaoBanco.class
                .getClassLoader()
                .getResourceAsStream("config.properties")) {

            Properties login = new Properties();
            login.load(dados);
            URL = login.getProperty("db.url");
            USER = login.getProperty("db.user");
            PASSWORD = login.getProperty("db.password");

        } catch (Exception e) {
            throw new RuntimeException("[" + VERMELHO + "ERR" + RESET + "] ConexaoBanco | getConnection - Não foi possivel obter os dados para conectar no Banco de Dados\n", e);
        }
    }

    public static synchronized Connection getConnection() throws SQLException {
        if (conexao == null || conexao.isClosed()) {
            System.out.println("[" + AMARELO + "ALR" + RESET + "] ConexaoBanco | getConnection - Conectando ao Banco de Dados...");
            conexao = DriverManager.getConnection(URL, USER, PASSWORD);
        }
        return conexao;
    }

}