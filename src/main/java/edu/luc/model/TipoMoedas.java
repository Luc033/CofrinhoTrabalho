package edu.luc.model;

/**
 * Enumeração `TipoMoedas`.
 *
 * Representa os tipos de moedas disponíveis no sistema: Real, Dólar e Euro.
 * Cada tipo de moeda é associado a um identificador numérico.
 */
public enum TipoMoedas {
    REAL(0),   // Representa a moeda Real com identificador 0
    DOLAR(1),  // Representa a moeda Dólar com identificador 1
    EURO(2);   // Representa a moeda Euro com identificador 2

    // Identificador numérico associado a cada tipo de moeda
    private final int getId;

    /**
     * Construtor do enum `TipoMoedas`.
     *
     * @param i O identificador numérico associado ao tipo de moeda.
     */
    TipoMoedas(int i) {
        this.getId = i;
    }

    /**
     * Retorna o identificador numérico do tipo de moeda.
     *
     * @return O identificador associado ao tipo de moeda.
     */
    public int getId() {
        return getId;
    }
}
