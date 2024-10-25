package edu.luc.model;

import java.util.ArrayList;
import java.util.List;

public class Cofrinho {
    List<Moeda> moedaList;

    public Cofrinho() {
        this.moedaList = new ArrayList<>();
    }

    public List<Moeda> getMoedaList() {
        return moedaList;
    }

    public void adicionar(Moeda moeda) {
        moedaList.add(moeda);
    }

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

    public void listagemMoedas() {
        if (!moedaList.isEmpty()) {
            System.out.println("Todas as moedas do cofrinho: \n" + moedaList);
        } else {
            System.out.println("Cofrinho vazio. Tente novamente.");

        }
    }

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

    // DÓLAR
    public double getDolares() {
        double dolTotal = moedaList.stream()
                .filter(moeda -> moeda instanceof Dolar)
                .mapToDouble(moeda -> ((Dolar) moeda).getValor()).sum();
        return dolTotal;
    }

    // EURO
    public double getEuros() {
        double euTotal = moedaList.stream()
                .filter(moeda -> moeda instanceof Euro)
                .mapToDouble(moeda -> ((Euro) moeda).getValor()).sum();
        return euTotal;
    }

    // REAL
    public double getReais() {
        double reTotal = moedaList.stream()
                .filter(moeda -> moeda instanceof Real)
                .mapToDouble(moeda -> ((Real) moeda).getValor()).sum();
        return reTotal;
    }

}
