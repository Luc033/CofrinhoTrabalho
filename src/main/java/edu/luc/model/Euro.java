package edu.luc.model;

public class Euro extends Moeda {
    public Euro(double valor) {
        super(valor);
    }


    @Override
    public void info() {
        System.out.println("Euros: €" + getValor());

    }

    @Override
    public double converter() {
        double total = getValor() * CAMBIO_EURO;
        return total;
    }
    @Override
    public String toString() {
        return "{Euro €" +
                getValor() +
                '}';
    }


}
