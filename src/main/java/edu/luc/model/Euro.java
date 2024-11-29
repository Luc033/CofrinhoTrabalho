package edu.luc.model;

/**
 * Representa a moeda Euro, uma subclasse de Moeda.
 * Contém métodos específicos para exibição e conversão do valor em euros para reais.
 */
public class Euro extends Moeda {

    /**
     * Construtor da classe Euro.
     *
     * @param valor O valor em euros.
     */
    public Euro(double valor) {
        super(valor);
    }


    /**
     * Exibe informações sobre a moeda no console.
     * Mostra o valor armazenado no formato "Euros: €valor".
     */
    @Override
    public void info() {
        System.out.println("Euros: €" + getValor());

    }

    /**
     * Converte o valor armazenado em euros para reais utilizando a taxa de câmbio definida.
     *
     * @return O valor convertido em reais.
     */
    @Override
    public double converter() {
        double total = getValor() * CAMBIO_EURO;
        return total;
    }

    /**
     * Retorna uma representação em texto do objeto Euro.
     *
     * @return Uma string no formato "{Euro €valor}".
     */
    @Override
    public String toString() {
        return "{Euro €" +
                getValor() +
                '}';
    }
}