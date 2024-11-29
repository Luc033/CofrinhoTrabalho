package edu.luc.service;

import java.util.Map;


/**
 * Representa a resposta recebida de uma API de câmbio de moedas.
 * Contém informações sobre a taxa de conversão, dados de atualização e outros detalhes da API.
 */

public class CurrencyApiResponse {

    // Atributos da classe
    private String result; // Resultado da solicitação da API.
    private String documentation; // URL da documentação da API.
    private String terms_of_use; // Termos de uso da API.
    private long time_last_update_unix; // Tempo da última atualização em formato Unix.
    private String time_last_update_utc; // Tempo da última atualização no formato UTC.
    private long time_next_update_unix; // Tempo da próxima atualização em formato Unix.
    private String time_next_update_utc; // Tempo da próxima atualização no formato UTC.
    private String base_code; // Código da moeda base usada na conversão.
    private Map<String, Double> conversion_rates; // Taxas de conversão de várias moedas.

    // Métodos Getters e Setters

    /**
     * Obtém o resultado da solicitação à API.
     *
     * @return O resultado da resposta.
     */
    public String getResult() {
        return result;
    }

    /**
     * Define o resultado da solicitação à API.
     *
     * @param result O resultado da resposta.
     */
    public void setResult(String result) {
        this.result = result;
    }

    /**
     * Obtém a documentação da API.
     *
     * @return A URL da documentação da API.
     */
    public String getDocumentation() {
        return documentation;
    }

    /**
     * Define a documentação da API.
     *
     * @param documentation A URL da documentação da API.
     */
    public void setDocumentation(String documentation) {
        this.documentation = documentation;
    }

    /**
     * Obtém os termos de uso da API.
     *
     * @return Os termos de uso da API.
     */
    public String getTerms_of_use() {
        return terms_of_use;
    }

    /**
     * Define os termos de uso da API.
     *
     * @param terms_of_use Os termos de uso da API.
     */
    public void setTerms_of_use(String terms_of_use) {
        this.terms_of_use = terms_of_use;
    }

    /**
     * Obtém o tempo da última atualização da API em formato Unix.
     *
     * @return O tempo da última atualização (Unix).
     */
    public long getTime_last_update_unix() {
        return time_last_update_unix;
    }

    /**
     * Define o tempo da última atualização da API em formato Unix.
     *
     * @param time_last_update_unix O tempo da última atualização (Unix).
     */
    public void setTime_last_update_unix(long time_last_update_unix) {
        this.time_last_update_unix = time_last_update_unix;
    }

    /**
     * Obtém o tempo da última atualização da API em formato UTC.
     *
     * @return O tempo da última atualização (UTC).
     */
    public String getTime_last_update_utc() {
        return time_last_update_utc;
    }

    /**
     * Define o tempo da última atualização da API em formato UTC.
     *
     * @param time_last_update_utc O tempo da última atualização (UTC).
     */
    public void setTime_last_update_utc(String time_last_update_utc) {
        this.time_last_update_utc = time_last_update_utc;
    }

    /**
     * Obtém o tempo da próxima atualização da API em formato Unix.
     *
     * @return O tempo da próxima atualização (Unix).
     */
    public long getTime_next_update_unix() {
        return time_next_update_unix;
    }

    /**
     * Define o tempo da próxima atualização da API em formato Unix.
     *
     * @param time_next_update_unix O tempo da próxima atualização (Unix).
     */
    public void setTime_next_update_unix(long time_next_update_unix) {
        this.time_next_update_unix = time_next_update_unix;
    }

    /**
     * Obtém o tempo da próxima atualização da API em formato UTC.
     *
     * @return O tempo da próxima atualização (UTC).
     */
    public String getTime_next_update_utc() {
        return time_next_update_utc;
    }

    /**
     * Define o tempo da próxima atualização da API em formato UTC.
     *
     * @param time_next_update_utc O tempo da próxima atualização (UTC).
     */
    public void setTime_next_update_utc(String time_next_update_utc) {
        this.time_next_update_utc = time_next_update_utc;
    }

    /**
     * Obtém o código da moeda base usada para conversão.
     *
     * @return O código da moeda base.
     */
    public String getBase_code() {
        return base_code;
    }

    /**
     * Define o código da moeda base usada para conversão.
     *
     * @param base_code O código da moeda base.
     */
    public void setBase_code(String base_code) {
        this.base_code = base_code;
    }

    /**
     * Obtém o mapa de taxas de conversão de moedas.
     *
     * @return Um mapa com as taxas de conversão (moeda -> taxa).
     */
    public Map<String, Double> getConversion_rates() {
        return conversion_rates;
    }

    /**
     * Define o mapa de taxas de conversão de moedas.
     *
     * @param conversion_rates O mapa com as taxas de conversão (moeda -> taxa).
     */
    public void setConversion_rates(Map<String, Double> conversion_rates) {
        this.conversion_rates = conversion_rates;
    }

    /**
     * Representação em string do objeto CurrencyApiResponse.
     *
     * @return A string com todas as informações contidas no objeto.
     */
    @Override
    public String toString() {
        return "CurrencyApiResponse{" +
                "result='" + result + '\'' +
                ", documentation='" + documentation + '\'' +
                ", terms_of_use='" + terms_of_use + '\'' +
                ", time_last_update_unix=" + time_last_update_unix +
                ", time_last_update_utc='" + time_last_update_utc + '\'' +
                ", time_next_update_unix=" + time_next_update_unix +
                ", time_next_update_utc='" + time_next_update_utc + '\'' +
                ", base_code='" + base_code + '\'' +
                ", conversion_rates=" + conversion_rates +
                '}';
    }
}