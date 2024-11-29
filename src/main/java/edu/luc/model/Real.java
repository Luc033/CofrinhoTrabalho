package edu.luc.model;

/**
 * Representa a moeda Real, uma subclasse de Moeda.
 * Contém métodos específicos para exibição e conversão de valores em reais.
 */
public class Real extends Moeda {

    /**
     * Construtor da classe Real.
     *
     * @param valor O valor em reais.
     */
    public Real(double valor) {
        super(valor);
    }

    /**
     * Exibe informações sobre a moeda no console.
     * Mostra o valor armazenado no formato "Reais: R$valor".
     */
    @Override
    public void info() {
        System.out.println("Reais: R$" + getValor());
    }

    /**
     * Converte o valor armazenado em reais para reais (sem alterações, pois já está em reais).
     *
     * @return O valor em reais.
     */
    @Override
    public double converter() {
        return getValor();
    }

    /**
     * Retorna uma representação em texto do objeto Real.
     *
     * @return Uma string no formato "{Real R$valor}".
     */
    @Override
    public String toString() {
        return "{Real R$" +
                getValor() +
                '}';
    }
}