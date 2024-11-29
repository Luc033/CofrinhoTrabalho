package edu.luc.model;

import java.util.ArrayList;
import java.util.List;

/**
 * A classe Cofrinho representa um cofrinho virtual que armazena diferentes moedas.
 * Possui funcionalidades para adicionar, remover, listar moedas e calcular o valor total convertido em Reais.
 */
public class Cofrinho {
    List<Moeda> moedaList; // Lista de moedas armazenadas no cofrinho

    /**
     * Construtor da classe Cofrinho.
     * Inicializa a lista de moedas como uma lista vazia.
     */
    public Cofrinho() {
        this.moedaList = new ArrayList<>();
    }

    /**
     * Obtém a lista de moedas armazenadas no cofrinho.
     *
     * @return Lista de moedas.
     */
    public List<Moeda> getMoedaList() {
        return moedaList;
    }

    /**
     * Adiciona uma moeda ao cofrinho.
     *
     * @param moeda A moeda a ser adicionada.
     */
    public void adicionar(Moeda moeda) {
        moedaList.add(moeda);
    }

    /**
     * Remove uma moeda específica do cofrinho, se ela existir.
     *
     * @param moeda A moeda a ser removida.
     */
    public void remover(Moeda moeda) {
        if (!moedaList.isEmpty()) {
            if (moedaList.contains(moeda)) {
                System.out.println("Removendo: " + moeda);
                moedaList.remove(moeda);
            } else {
                System.out.println("Não exite na lista. Tente novamente.");

            }
        } else {
            System.out.println("Lista vazia. Tente novamente.");
        }
    }

    /**
     * Lista todas as moedas atualmente armazenadas no cofrinho.
     * Exibe uma mensagem se o cofrinho estiver vazio.
     */
    public void listagemMoedas() {
        if (!moedaList.isEmpty()) {
            System.out.println("Todas as moedas do cofrinho: \n" + moedaList);
        } else {
            System.out.println("Cofrinho vazio. Tente novamente.");

        }
    }

    /**
     * Calcula e exibe o valor total de todas as moedas convertidas em Reais.
     * Também exibe os totais de cada tipo de moeda antes da conversão.
     */
    public void totalConvertido() {
        if (!moedaList.isEmpty()) {
            double tDolarCovertido = new Dolar(getDolares()).converter();
            double tDolar = getDolares();
            double tEuroConvertido = new Euro(getEuros()).converter();
            double tEuro = getEuros();
            double tRealConvertido = new Real(getReais()).converter();
            double tReal = getReais();
            double total = tDolarCovertido + tRealConvertido + tEuroConvertido;
            System.out.println(String.format("Dolares totais: $%.2f | Euros totais: €%.2f | Reais totais: R$%.2f", tDolar, tEuro, tReal));
            System.out.println(String.format("Valor total convertido em reais do cofrinho: R$%.2f", total));
        } else {
            System.out.println("Cofrinho vazio. Tente novamente.");
        }
    }

    /**
     * Calcula o total em dólares armazenado no cofrinho.
     *
     * @return O total em dólares.
     */
    public double getDolares() {
        double dolTotal = moedaList.stream()
                .filter(moeda -> moeda instanceof Dolar)
                .mapToDouble(moeda -> ((Dolar) moeda).getValor()).sum();
        return dolTotal;
    }

    /**
     * Calcula o total em euros armazenado no cofrinho.
     *
     * @return O total em euros.
     */
    public double getEuros() {
        double euTotal = moedaList.stream()
                .filter(moeda -> moeda instanceof Euro)
                .mapToDouble(moeda -> ((Euro) moeda).getValor()).sum();
        return euTotal;
    }

    /**
     * Calcula o total em reais armazenado no cofrinho.
     *
     * @return O total em reais.
     */
    public double getReais() {
        double reTotal = moedaList.stream()
                .filter(moeda -> moeda instanceof Real)
                .mapToDouble(moeda -> ((Real) moeda).getValor()).sum();
        return reTotal;
    }

}