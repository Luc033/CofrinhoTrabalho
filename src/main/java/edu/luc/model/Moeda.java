package edu.luc.model;

import edu.luc.service.ApiConsumo;

import java.io.IOException;
import java.net.URISyntaxException;

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
    static ApiConsumo apiConsumo;
    static {
        try {
            apiConsumo = new ApiConsumo();
        } catch (URISyntaxException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }

    static final double CAMBIO_DOLAR = apiConsumo.getCAMBIO_DOLAR();
    static final double CAMBIO_EURO = apiConsumo.getCAMBIO_EURO();
    private double valor;
    public Moeda(double valor){
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
