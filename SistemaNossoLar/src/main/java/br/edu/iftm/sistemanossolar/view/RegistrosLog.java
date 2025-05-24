package br.edu.iftm.sistemanossolar.view;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class RegistrosLog {
    public static final String RESET = "\u001B[0m";
    public static final String VERMELHO = "\u001B[31m";
    public static final String AMARELO = "\u001B[33m";
    public static final String AZUL = "\u001B[34m";
    public static final String VERDE = "\u001B[32m";
    public static final String CINZA = "\u001B[30m";
    
    LocalDateTime dataHora = LocalDateTime.now();
    DateTimeFormatter dataHoraFormat = DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm:ss");
    String momento = CINZA+dataHora.format(dataHoraFormat)+RESET;

    public String registrarLog(int tipo, String arquivo, String metodo, String tabela, String mensagem) {
        String tipoMensagem = null;
        switch (tipo) {
            case 1:
                tipoMensagem = AZUL+"INF"+RESET;
                break;
            case 2:
                tipoMensagem = VERDE+"INF"+RESET;
                break;
            case 3:
                tipoMensagem = AMARELO+"ALR"+RESET;
                break;
            case 4:
                tipoMensagem = VERMELHO+"ERR"+RESET;
            default:
                break;
        }

        System.out.println("[" + momento + "]" +" [" + tipoMensagem + "] " + arquivo + " | " + tabela + " | " + metodo + " - " + mensagem);
        return null;
    }
}
