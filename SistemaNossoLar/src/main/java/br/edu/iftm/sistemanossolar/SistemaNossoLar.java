package br.edu.iftm.sistemanossolar;

import java.sql.Connection;

import br.edu.iftm.sistemanossolar.dao.ConexaoBanco;

public class SistemaNossoLar {

    public static void main(String[] args) {
        System.out.println("Hello World!");
        Connection conn = ConexaoBanco.getConnection();
    }
}
