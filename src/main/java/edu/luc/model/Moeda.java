package edu.luc.model;

/**
 * Classe abstrata Moeda possui
 * Declarando constantes estáticas para referência em cáculos de conversão.
 *
 * Declarando atributo que armazenará o valor da referida moeda.
 *
 * Declarando construtor já instanciando valor do atributo valor.
 *
 * Metodo Get responsável em retornar o valor do atributo valor.
 *
 * Metodo Set responsável em inserir o valor no atributo valor.
 *
 * Métodos abstratos que serão implementados nas classes filhas: Dolar, Euro e Real.
 */
public abstract class Moeda {
    static final double CAMBIO_DOLAR = 5.69;
    static final double CAMBIO_EURO = 6.13;
    private double valor;
    public Moeda(double valor) {
        this.valor = valor;
    }
    public double getValor() {
        return valor;
    }
    public void setValor(double valor) {
        this.valor = valor;
    }
    public abstract void info();
    public abstract double converter();


}
