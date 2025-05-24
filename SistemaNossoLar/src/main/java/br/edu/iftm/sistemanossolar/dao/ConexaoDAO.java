package br.edu.iftm.sistemanossolar.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

import br.edu.iftm.sistemanossolar.view.RegistrosLog;

import java.io.InputStream;

public class ConexaoDAO {

    static RegistrosLog log = new RegistrosLog();

    private static String URL;
    private static String USER;
    private static String PASSWORD;
    private static Connection conexao;

    static {
        try (InputStream dados = ConexaoDAO.class
                .getClassLoader()
                .getResourceAsStream("config.properties")) {

            Properties login = new Properties();
            login.load(dados);
            URL = login.getProperty("db.url");
            USER = login.getProperty("db.user");
            PASSWORD = login.getProperty("db.password");

        } catch (Exception e) {
            log.registrarLog(4, "ConexaoDAO", "getConnection", "", "Não foi possivel obter os dados para conectar no Banco de Dados");
            throw new RuntimeException(e);
        }
    }

    public static synchronized Connection getConnection() throws SQLException {
        if (conexao == null || conexao.isClosed()) {
            log.registrarLog(1, "ConexaoDAO", "getConnection", "", "Conectando ao Banco de Dados");
            conexao = DriverManager.getConnection(URL, USER, PASSWORD);
        }
        return conexao;
    }

}