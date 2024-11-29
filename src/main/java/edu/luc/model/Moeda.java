package edu.luc.model;

import edu.luc.service.ApiConsumo;

import java.io.IOException;
import java.net.URISyntaxException;

/**
 * Classe abstrata Moeda, que serve como base para outras classes de moedas como Dólar, Euro e Real.
 * Esta classe contém a lógica para armazenar o valor da moeda e calcular sua conversão com base nas taxas obtidas da API.
 *
 * A classe é responsável por:
 * 1. Definir constantes estáticas para as taxas de câmbio (Dólar e Euro).
 * 2. Armazenar o valor da moeda.
 * 3. Inicializar o valor da moeda através de um construtor.
 * 4. Fornecer métodos getters e setters para manipular o valor.
 * 5. Definir métodos abstratos `info` e `converter`, que serão implementados pelas classes filhas.
 *
 * A classe também realiza a instância da classe `ApiConsumo` para obter as taxas de câmbio.
 */
public abstract class Moeda {

    // Instância da classe ApiConsumo para buscar as taxas de câmbio
    static ApiConsumo apiConsumo;

    // Bloco estático que inicializa a instância de ApiConsumo e lida com exceções
    static {
        try {
            apiConsumo = new ApiConsumo();  // Inicializa a instância de ApiConsumo
        } catch (URISyntaxException e) {
            throw new RuntimeException(e);  // Exceção de erro na URI
        } catch (IOException e) {
            throw new RuntimeException(e);  // Exceção de erro de entrada/saída
        } catch (InterruptedException e) {
            throw new RuntimeException(e);  // Exceção de erro de interrupção
        }
    }

    // Constantes estáticas para as taxas de câmbio
    static final double CAMBIO_DOLAR = apiConsumo.getCAMBIO_DOLAR();  // Taxa de câmbio do Dólar
    static final double CAMBIO_EURO = apiConsumo.getCAMBIO_EURO();    // Taxa de câmbio do Euro

    // Atributo para armazenar o valor da moeda
    private double valor;

    /**
     * Construtor que inicializa o valor da moeda.
     *
     * @param valor O valor da moeda a ser instanciado.
     */
    public Moeda(double valor) {
        this.valor = valor;
    }

    /**
     * Método getter que retorna o valor da moeda.
     *
     * @return O valor atual da moeda.
     */
    public double getValor() {
        return valor;
    }

    /**
     * Método setter que define um novo valor para a moeda.
     *
     * @param valor O novo valor da moeda.
     */
    public void setValor(double valor) {
        this.valor = valor;
    }

    /**
     * Método abstrato para exibir informações sobre a moeda.
     * Cada classe filha (Dólar, Euro, Real) deve fornecer a implementação específica.
     */
    public abstract void info();

    /**
     * Método abstrato para converter o valor da moeda para outra unidade monetária.
     * Cada classe filha (Dólar, Euro, Real) deve fornecer a implementação específica.
     *
     * @return O valor convertido.
     */
    public abstract double converter();
}
