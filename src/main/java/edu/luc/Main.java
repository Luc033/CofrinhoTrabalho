package edu.luc;

import edu.luc.model.*;
import edu.luc.service.*;

/**
 * Classe principal do projeto Cofrinho.
 * Responsável por inicializar e executar o menu principal da aplicação.
 */
public class Main {
    /**
     * Método principal da aplicação.
     * Instancia o objeto {@link Menu}, iniciando a interação com o usuário.
     *
     * @param args Argumentos de linha de comando (não utilizados).
     */
    public static void main(String[] args) {
        // Inicializa o menu da aplicação
        Menu menu1 = new Menu();

        // Exibe mensagem de encerramento ao sair do menu
        System.out.println("Encerrando programa...");
    }
}