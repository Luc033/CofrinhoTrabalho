package edu.luc.model;

import java.util.InputMismatchException;
import java.util.Locale;
import java.util.Scanner;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * A classe Menu gerencia as interações com o usuário para manipular um cofrinho virtual.
 * Permite adicionar, remover, listar moedas e converter todas as moedas para o valor em Real.
 */

public class Menu {
    private boolean continuar = true; // Controla o loop do menu principal
    private static Cofrinho cofrinho = new Cofrinho(); // Instância do cofrinho a ser manipulado


    /**
     * Construtor da classe Menu.
     * Inicia a execução do menu principal com o cofrinho associado.
     */
    public Menu() {
        executarMenu();
    }

    /**
     * Exibe o menu principal e processa as escolhas do usuário.
     * O menu apresenta opções para adicionar, remover, listar moedas e converter todas para Real.
     * A entrada é tratada para evitar erros causados por valores inválidos.
     */
    public void executarMenu() {
        Scanner ler = new Scanner(System.in);

        while (continuar) {
            System.out.println("""
                    \n<===================M=E=N=U===================>
                     |                                           |
                     |  1 -- Adicionar moedas no cofrinho        | 
                     |  2 -- Retirar moedas do cofrinho          | 
                     |  3 -- Listar todas as moedas do cofrinho  |
                     |  4 -- Converter todas as moedas para real |
                     |                                           |
                     |  0 -- Sair                                |
                    <=============================================>
                    """);

            try {
                int opcao = ler.nextInt();
                verificarOpcao(opcao);
            } catch (InputMismatchException e) {
                System.out.println("Opção inválida.");
                ler.nextLine(); // Limpa o buffer do scanner
            }
        }
    }

    /**
     * Verifica a opção escolhida pelo usuário no menu principal.
     * Realiza a ação correspondente, como adicionar ou remover moedas, listar ou converter.
     *
     * @param opcao Opção escolhida pelo usuário.
     */
    public void verificarOpcao(int opcao) {

        switch (opcao) {
            case 0:
                continuar = false; // Encerra o loop do menu
                break;
            case 1:
                guardarMoeda(); // Adiciona uma moeda
                break;
            case 2:
                retirarUmaMoeda(); // Remove uma moeda
                break;
            case 3:
                cofrinho.listagemMoedas(); // Lista todas as moedas
                break;
            case 4:
                cofrinho.totalConvertido(); // Converte todas as moedas para Real
                break;
            default:
                System.out.println("Valor inválido");
                break;
        }
    }


    /**
     * Permite ao usuário adicionar uma nova moeda ao cofrinho.
     * Solicita o tipo de moeda e o valor a ser depositado.
     */
    public void guardarMoeda() {
        System.out.println("""
                0-----------------(0)-----------------0
                |  Digite o número da moeda desejada: |
                |                                     |
                |  1 -- Real                          |
                |  2 -- Dolar                         |
                |  3 -- Euro                          |
                |                                     |
                |  0 -- Voltar                        | 
                0-----------------(0)-----------------0
                """);
        Scanner ler = new Scanner(System.in);
        try {
            int opcao = ler.nextInt();
            if (opcao == 0) {
                executarMenu(); // Retorna ao menu principal
            }
            System.out.println("Quanto irá depositar?");
            Scanner leitura = new Scanner(System.in);
            leitura.useLocale(Locale.US);
            double valor = leitura.nextDouble();
            leitura.nextLine();
            cofrinho.adicionar(opcao, valor);

        } catch (InputMismatchException e) {
            System.out.println("Opção inválida.");
        }

    }

    /**
     * Permite ao usuário remover uma moeda específica do cofrinho.
     * Exibe as moedas presentes no cofrinho e solicita a escolha do usuário.
     * Verifica se o cofrinho contém moedas antes de tentar a remoção.
     */
    public void retirarUmaMoeda() {
        if (!cofrinho.getMoedaList().isEmpty()) { // Verifica se o cofrinho não está vazio
            System.out.println("Moedas do cofrinho:");
            AtomicInteger counter = new AtomicInteger(1);
            cofrinho.moedaList.entrySet()
                    .forEach(m ->
                            System.out.println(counter.getAndIncrement() + " - " + m.getKey() + " - " + m.getValue().getValor()));
            System.out.println("Qual moeda você quer retirar?");
            Scanner ler = new Scanner(System.in);
            try {
                int opcao = ler.nextInt();
                ler.nextLine();
                System.out.println("Insira o valor:");
                double valorRetirar = ler.nextDouble();
                ler.nextLine();
                cofrinho.remover(opcao, valorRetirar); // Remove a moeda selecionada
            } catch (IndexOutOfBoundsException | InputMismatchException e) {
                System.out.println("Valor incorreto.");
            }
        } else {
            System.out.println("Cofrinho vazio.Tente novamente");
        }
    }
}