package edu.luc;

import edu.luc.model.*;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
        Moeda real = new Real(1);
        Moeda dolar = new Dolar(1);
        Moeda euro = new Euro(1);
        Cofrinho cofrinho = new Cofrinho();
        cofrinho.adicionar(real);
        cofrinho.adicionar(dolar);
        cofrinho.adicionar(euro);

        cofrinho.listagemMoedas();
        cofrinho.totalConvertido();
        cofrinho.remover(real);
        cofrinho.listagemMoedas();
    }
}