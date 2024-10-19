package edu.luc.model;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

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
            System.out.println("Removendo: "+ moeda);
            moedaList.remove(moeda);
        } else {
            System.out.println("Lista vazia. Tente novamente.");
        }
    }

    public void listagemMoedas() {
        System.out.println("Todas as moedas do cofrinho: \n" + moedaList);
    }

    public void totalConvertido() {
        if(!moedaList.isEmpty()) {
            double tDolar = 0;
            for (Dolar d : getDolares()) {
                tDolar = d.converter();
            }
            double tEuro = 0;
            for (Euro e : getEuros()) {
                tEuro = e.converter();
            }
            double tReal = 0;
            for (Real r : getReais()) {
                tDolar = r.converter();
            }
            double total = tDolar + tReal + tEuro;
            //System.out.println(String.format("Dolares totais: $%.2f | Euros totais: €%.2f | Reais totais: R$%.2f", getDolares(), getEuros(), getReais()));
            System.out.println("Valor total convertido em reais do cofrinho: R$" + total);
        }else {
            System.out.println("Cofrinho vazio. Tente novamente.");
        }
    }

    public List<Dolar> getDolares() {
        return moedaList.stream()
                .filter(moeda -> moeda instanceof Dolar)
                .map(moeda -> (Dolar) moeda)
                .collect(Collectors.toList());
    }

    public List<Euro> getEuros() {
        return moedaList.stream()
                .filter(moeda -> moeda instanceof Euro)
                .map(moeda -> (Euro) moeda)
                .collect(Collectors.toList());
    }

    public List<Real> getReais() {
        return moedaList.stream()
                .filter(moeda -> moeda instanceof Real)
                .map(moeda -> (Real) moeda)
                .collect(Collectors.toList());
    }
}
