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
    private Cofrinho cofrinho = new Cofrinho(); // Instância do cofrinho a ser manipulado


    /**
     * Construtor da classe Menu.
     * Inicia a execução do menu principal com o cofrinho associado.
     */
    public Menu() {
        executarMenu(this.cofrinho);
    }

    /**
     * Exibe o menu principal e processa as escolhas do usuário.
     *
     * @param cofrinho Instância do Cofrinho a ser manipulada.
     */
    public void executarMenu(Cofrinho cofrinho) {
        Scanner ler = new Scanner(System.in);

        while (continuar) {
            System.out.println("""
                    \n<===================M=E=N=U===================>
                     |                                           |
                     |  1 -- Adicionar moedas no cofrinho        | 
                     |  2 -- Remover moedas do cofrinho          | 
                     |  3 -- Listar todas as moedas do cofrinho  |
                     |  4 -- Converter todas as moedas para real |
                     |                                           |
                     |  0 -- Sair                                |
                    <=============================================>
                    """);

            try {
                int opcao = ler.nextInt();
                verificarOpcao(opcao, cofrinho);
            } catch (InputMismatchException e) {
                System.out.println("Opção inválida.");
                ler.nextLine(); // Limpa o buffer do scanner
            }
        }
    }

    /**
     * Verifica a opção escolhida pelo usuário e executa a ação correspondente.
     *
     * @param opcao Opção escolhida pelo usuário.
     * @param cofrinho Instância do Cofrinho a ser manipulada.
     */
    public void verificarOpcao(int opcao, Cofrinho cofrinho) {

        switch (opcao) {
            case 0:
                continuar = false; // Encerra o loop do menu
                break;
            case 1:
                criandoMoedaNoMenu(cofrinho); // Adiciona uma moeda
                break;
            case 2:
                removerUmaMoeda(cofrinho); // Remove uma moeda
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
     *
     * @param cofrinho Instância do Cofrinho onde a moeda será adicionada.
     */
    public void criandoMoedaNoMenu(Cofrinho cofrinho) {
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
            if (opcao == 0){
                executarMenu(cofrinho); // Retorna ao menu principal
            }
            System.out.println("Quanto irá depositar?");
            Scanner leitura = new Scanner(System.in);
            leitura.useLocale(Locale.US);
            double valor = leitura.nextDouble();

            switch (opcao) {

                case 1:
                    Real real = new Real(valor);
                    cofrinho.adicionar(real);
                    break;
                case 2:
                    Dolar dolar = new Dolar(valor);
                    cofrinho.adicionar(dolar);
                    break;
                case 3:
                    Euro euro = new Euro(valor);
                    cofrinho.adicionar(euro);
                    break;
                default:
                    System.out.println("Valor inválido");
            }
        } catch (InputMismatchException e) {
            System.out.println("Opção inválida.");
        }

    }

    /**
     * Permite ao usuário remover uma moeda específica do cofrinho.
     * Exibe as moedas presentes no cofrinho e solicita a escolha do usuário.
     *
     * @param cofrinho Instância do Cofrinho onde a moeda será removida.
     */
    public void removerUmaMoeda(Cofrinho cofrinho) {
        if (!cofrinho.getMoedaList().isEmpty()) { // Verifica se o cofrinho não está vazio
            System.out.println("Moedas do cofrinho:");
            AtomicInteger counter = new AtomicInteger(1);
            cofrinho.moedaList.forEach(m -> System.out.println(counter.getAndIncrement() + " - " + m));
            System.out.println("Qual irá remover?");
            Scanner ler = new Scanner(System.in);
            try {
                int opcao = ler.nextInt();
                cofrinho.remover(cofrinho.moedaList.get(opcao - 1)); // Remove a moeda selecionada
            } catch (IndexOutOfBoundsException | InputMismatchException e) {
                System.out.println("Valor incorreto.");
            }
        } else {
            System.out.println("Cofrinho vazio.Tente novamente");
        }

    }

}