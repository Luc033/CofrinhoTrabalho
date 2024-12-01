package edu.luc.model;

/**
 * Representa a moeda Dólar, uma subclasse de Moeda.
 * Contém informações específicas para exibição e conversão do valor em dólares para reais.
 */
public class Dolar extends Moeda {

    /**
     * Construtor da classe Dolar.
     *
     * @param valor O valor em euros.
     */
    public Dolar(double valor) {
        super(valor);
    }
    /**
     * Exibe informações sobre a moeda no console.
     * Mostra o valor armazenado no formato "Dólares: $valor".
     */
    @Override
    public void info() {
        System.out.println("Dólares: $" + getValor());
    }

    /**
     * Converte o valor armazenado em dólares para reais utilizando a taxa de câmbio definida.
     *
     * @return O valor convertido em reais.
     */
    @Override
    public double converter() {
        double total = getValor() * CAMBIO_DOLAR;
        return total;
    }

    /**
     * Retorna uma representação em texto do objeto Dolar.
     *
     * @return Uma string no formato "{Dolar $valor}".
     */
    @Override
    public String toString() {
        return "{Dolar $" +
                getValor() +
                '}';
    }
}