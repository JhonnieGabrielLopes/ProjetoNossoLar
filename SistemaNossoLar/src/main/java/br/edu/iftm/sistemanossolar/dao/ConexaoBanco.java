package br.edu.iftm.sistemanossolar.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;
import java.io.InputStream;

public class ConexaoBanco {
    private static String URL;
    private static String USER;
    private static String PASSWORD;

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
            throw new RuntimeException("Erro! Não foi possivel obter os dados para conexão ao Banco de Dados", e);
        }
    }

    public static Connection getConnection() {
        try {
            System.out.println("Conectando ao Banco de Dados...");
            return DriverManager.getConnection(URL, USER, PASSWORD);
        } catch (SQLException e) {
            throw new RuntimeException("Erro! Não foi possivel se conectar ao Banco de Dados", e);
        }
    } 

}