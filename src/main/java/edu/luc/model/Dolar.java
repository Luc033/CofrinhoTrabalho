package edu.luc.model;

public class Dolar extends Moeda {

    public Dolar(double valor) {
        super(valor);
    }

    @Override
    public void info() {
        System.out.println("Dólares: $" + getValor());
    }

    @Override
    public double converter() {
        double total = getValor() * CAMBIO_DOLAR;
        return total;
    }
    @Override
    public String toString() {
        return "{Dolar $" +
                getValor() +
                '}';
    }
}