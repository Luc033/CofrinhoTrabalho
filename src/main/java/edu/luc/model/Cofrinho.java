package edu.luc.model;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;

/**
 * A classe Cofrinho representa um cofrinho virtual que armazena diferentes tipos de moedas.
 * Oferece funcionalidades para adicionar, remover, listar moedas e calcular o valor total
 * convertido em Reais, considerando taxas de câmbio.
 */
public class Cofrinho {
    // Lista de moedas armazenadas no cofrinho, mapeadas por seus tipos
    Map<TipoMoedas, Moeda> moedaList;

    /**
     * Construtor da classe Cofrinho.
     * Inicializa o cofrinho com três tipos de moedas: Real, Dólar e Euro,
     * todos com valores iniciais definidos como zero.
     */
    public Cofrinho() {
        this.moedaList = new LinkedHashMap<>();
        moedaList.put(TipoMoedas.REAL, new Real(0.0));
        moedaList.put(TipoMoedas.DOLAR, new Dolar(0.0));
        moedaList.put(TipoMoedas.EURO, new Euro(0.0));
    }

    /**
     * Obtém a lista de moedas atualmente armazenadas no cofrinho.
     *
     * @return Um mapa contendo os tipos de moedas e suas respectivas instâncias.
     */
    public Map<TipoMoedas, Moeda> getMoedaList() {
        return moedaList;
    }

    /**
     * Adiciona um valor a uma moeda específica no cofrinho.
     *
     * @param i     O identificador da moeda (1 para Real, 2 para Dólar, 3 para Euro).
     * @param valor O valor a ser adicionado.
     * @throws IllegalArgumentException Se o identificador da moeda for inválido.
     */
    public void adicionar(int i, double valor) {
        TipoMoedas tipoMoedas;
        if (i == 1) {
            tipoMoedas = TipoMoedas.REAL;
        } else if (i == 2) {
            tipoMoedas = TipoMoedas.DOLAR;
        } else if (i == 3) {
            tipoMoedas = TipoMoedas.EURO;
        } else {
            throw new IllegalArgumentException("Opção de moeda não encontrada.");
        }

        // Verifica se a chave existe no mapa
        if (moedaList.containsKey(tipoMoedas)) {
            // Verifica se é do tipo REAL
            if (tipoMoedas == TipoMoedas.REAL) {
                // Obtém a moeda e adiciona o valor
                Moeda moedaAtual = moedaList.get(tipoMoedas);
                if (moedaAtual != null) {
                    moedaAtual.somarValor(valor);
                } else {
                    System.err.println("Erro: Não há uma moeda associada à chave " + tipoMoedas);
                }
                // Verifica se é do tipo DOLAR
            } else if (tipoMoedas == TipoMoedas.DOLAR) {
                // Obtém a moeda e adiciona o valor
                Moeda moedaAtual = moedaList.get(tipoMoedas);
                if (moedaAtual != null) {
                    moedaAtual.somarValor(valor);
                } else {
                    System.err.println("Erro: Não há uma moeda associada à chave " + tipoMoedas);
                }
                // Verifica se é do tipo EURO
            } else if (tipoMoedas == TipoMoedas.EURO) {
                // Obtém a moeda e adiciona o valor
                Moeda moedaAtual = moedaList.get(tipoMoedas);
                if (moedaAtual != null) {
                    moedaAtual.somarValor(valor);
                } else {
                    System.err.println("Erro: Não há uma moeda associada à chave " + tipoMoedas);
                }
            } else {
                System.err.println("Erro: A chave " + tipoMoedas + " não está no mapa.");
            }
        }
    }

    /**
     * Remove uma quantidade específica de uma moeda do cofrinho, se possível.
     *
     * @param i     O identificador da moeda (1 para Real, 2 para Dólar, 3 para Euro).
     * @param valor A quantidade a ser removida.
     * @throws IllegalArgumentException Se o identificador da moeda for inválido ou
     *                                  se o valor a ser removido exceder o valor disponível.
     */
    public void remover(int i, double valor) {
        TipoMoedas tipoMoedas;
        if (i == 1) {
            tipoMoedas = TipoMoedas.REAL;
        } else if (i == 2) {
            tipoMoedas = TipoMoedas.DOLAR;
        } else if (i == 3) {
            tipoMoedas = TipoMoedas.EURO;
        } else {
            throw new IllegalArgumentException("Opção de moeda não encontrada.");
        }

        if (!moedaList.isEmpty()) {
            if (moedaList.containsKey(tipoMoedas)) {
                Moeda moedaRemover = moedaList.get(tipoMoedas);
                if (tipoMoedas == TipoMoedas.REAL) {
                    if (!(valor > moedaRemover.getValor())) {
                        System.out.println(String.format("Removendo: R$ %.2f", valor));
                        moedaRemover.removerValor(valor);
                    } else {
                        System.err.println("Erro: Valor maior ao existente.");
                    }
                } else if (tipoMoedas == TipoMoedas.DOLAR) {
                    if (!(valor > moedaRemover.getValor())) {
                        System.out.println(String.format("Removendo: $ %.2f", valor));
                        moedaRemover.removerValor(valor);
                    } else {
                        System.err.println("Erro: Valor maior ao existente.");
                    }
                } else if (tipoMoedas == TipoMoedas.EURO) {
                    if (!(valor > moedaRemover.getValor())) {
                        System.out.println(String.format("Removendo: € %.2f", valor));
                        moedaRemover.removerValor(valor);
                    } else {
                        System.err.println("Erro: Valor maior ao existente.");
                    }
                } else {
                    System.out.println("Não exite na lista. Tente novamente.");

                }
            } else {
                System.out.println("Lista vazia. Tente novamente.");
            }
        }
    }

    /**
     * Lista todas as moedas atualmente armazenadas no cofrinho e seus valores.
     * Exibe uma mensagem se o cofrinho estiver vazio.
     */
    public void listagemMoedas() {
        if (!moedaList.isEmpty()) {
            System.out.println("Todas as moedas do cofrinho: \n" + moedaList);
        } else {
            System.out.println("Cofrinho vazio. Tente novamente.");

        }
    }

    /**
     * Calcula e exibe o valor total de todas as moedas convertidas para Reais.
     * Exibe também os valores totais individuais antes da conversão.
     */
    public void totalConvertido() {
        if (!moedaList.isEmpty()) {
            double tRealConvertido = new Real(getReais()).converter();
            double tReal = getReais();
            double tDolarCovertido = new Dolar(getDolares()).converter();
            double tDolar = getDolares();
            double tEuroConvertido = new Euro(getEuros()).converter();
            double tEuro = getEuros();
            double total = tDolarCovertido + tRealConvertido + tEuroConvertido;
            System.out.println(String.format("Reais totais: R$%.2f | Dolares totais: $%.2f | Euros totais: €%.2f", tReal, tDolar, tEuro));
            System.out.println(String.format("Valor total convertido em reais do cofrinho: R$%.2f", total));
        } else {
            System.out.println("Cofrinho vazio. Tente novamente.");
        }
    }

    /**
     * Obtém o valor total armazenado em Dólares.
     *
     * @return O valor total em Dólares.
     */
    public double getDolares() {
        double dolTotal = moedaList.get(TipoMoedas.DOLAR).getValor();
        return dolTotal;
    }

    /**
     * Obtém o valor total armazenado em Euros.
     *
     * @return O valor total em Euros.
     */
    public double getEuros() {
        double euTotal = moedaList.get(TipoMoedas.EURO).getValor();
        return euTotal;
    }

    /**
     * Calcula o total em reais armazenado no cofrinho.
     *
     * @return O total em reais.
     */
    public double getReais() {
        double reTotal = moedaList.get(TipoMoedas.REAL).getValor();
        return reTotal;
    }
}