package edu.luc.model;

public class Real extends Moeda {

    public Real(double valor) {
        super(valor);
    }

    @Override
    public void info() {
        System.out.println("Reais: R$" + getValor());
    }

    @Override
    public double converter() {
        return getValor();
    }
    @Override
    public String toString() {
        return "{Real R$" +
                getValor() +
                '}';
    }
}
