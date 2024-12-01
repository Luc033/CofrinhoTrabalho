package edu.luc.model;

import edu.luc.service.ApiConsumo;

import java.io.IOException;
import java.net.URISyntaxException;

/**
 * Classe abstrata Moeda.
 *
 * Serve como base para a representação de diferentes moedas (como Dólar, Euro e Real), definindo atributos e comportamentos comuns,
 * além de fornecer métodos abstratos para implementação específica nas subclasses.
 *
 * Funcionalidades principais:
 * - Armazenar o valor associado a uma moeda.
 * - Permitir operações de soma e remoção de valores monetários.
 * - Obter taxas de câmbio atualizadas através de uma API externa.
 * - Oferecer métodos abstratos que as subclasses devem implementar para exibir informações e realizar conversões.
 */
public abstract class Moeda {

    // Instância da classe ApiConsumo para obter taxas de câmbio em tempo real
    static ApiConsumo apiConsumo;

    // Bloco estático responsável por inicializar a instância de ApiConsumo e lidar com possíveis exceções
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

    // Constantes estáticas para as taxas de câmbio da API externa
    static final double CAMBIO_DOLAR = apiConsumo.getCAMBIO_DOLAR();  // Taxa de câmbio do Dólar
    static final double CAMBIO_EURO = apiConsumo.getCAMBIO_EURO();    // Taxa de câmbio do Euro

    // Atributo que armazena o valor monetário associado à moeda
    private double valor;

    /**
     * Construtor padrão da classe `Moeda`.
     * Pode ser usado por classes filhas para criar uma instância sem definir um valor inicial.
     */
    public Moeda() {
    }

    /**
     * Construtor que inicializa a moeda com um valor específico.
     *
     * @param valor O valor inicial da moeda.
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
     * Adiciona um valor ao valor atual da moeda.
     *
     * @param valor O valor a ser somado ao valor atual.
     */
    public void somarValor(double valor){
        this.valor += valor;
    }

    /**
     * Subtrai um valor do valor atual da moeda.
     *
     * @param valor O valor a ser subtraído do valor atual.
     */
    public void removerValor(double valor){
        this.valor -= valor;
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
