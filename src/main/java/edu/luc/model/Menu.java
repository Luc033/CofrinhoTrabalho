package edu.luc.model;

import java.util.InputMismatchException;
import java.util.Locale;
import java.util.Scanner;
import java.util.concurrent.atomic.AtomicInteger;

public class Menu {
    private boolean continuar = true;
    private Cofrinho cofrinho = new Cofrinho();

    public Menu() {
        executarMenu(this.cofrinho);
    }

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
            }
        }
    }

    public void verificarOpcao(int opcao, Cofrinho cofrinho) {
        switch (opcao) {
            case 0:
                continuar = false;
                break;
            case 1:
                criandoMoedaNoMenu(cofrinho);
                break;
            case 2:
                removerUmaMoeda(cofrinho);
                break;
            case 3:
                cofrinho.listagemMoedas();
                break;
            case 4:
                cofrinho.totalConvertido();
                break;
            default:
                System.out.println("Valor inválido");
        }
    }

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
                executarMenu(cofrinho);
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

    public void removerUmaMoeda(Cofrinho cofrinho) {
        if (!cofrinho.getMoedaList().isEmpty()) {
            System.out.println("Moedas do cofrinho:");
            AtomicInteger counter = new AtomicInteger(1);
            cofrinho.moedaList.forEach(m -> System.out.println(counter.getAndIncrement() + " - " + m));
            System.out.println("Qual irá remover?");
            Scanner ler = new Scanner(System.in);
            try {
                int opcao = ler.nextInt();
                cofrinho.remover(cofrinho.moedaList.get(opcao - 1));
            } catch (IndexOutOfBoundsException | InputMismatchException e) {
                System.out.println("Valor incorreto.");
            }
        } else {
            System.out.println("Cofrinho vazio.Tente novamente");
        }

    }

}
