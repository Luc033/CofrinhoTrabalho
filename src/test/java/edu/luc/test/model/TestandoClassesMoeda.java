package edu.luc.test.model;

import edu.luc.model.*;
import org.junit.jupiter.api.*;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import static org.junit.jupiter.api.Assertions.*;

@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
public class TestandoClassesMoeda {
    private final ByteArrayOutputStream outContent = new ByteArrayOutputStream();
    private final PrintStream originalOut = System.out;

    @BeforeEach
    public void setUpStreams() {
        // Redireciona a saída padrão (System.out) para o ByteArrayOutputStream
        System.setOut(new PrintStream(outContent));
    }

    @AfterEach
    public void restoreStreams() {
        // Restaura a saída padrão original
        System.setOut(originalOut);
    }
    @Order(1)
    @Test
    public void verificaInstanciacaoEuro(){
        Moeda euro = new Euro(1);
        assertEquals(6.13,euro.converter());
        euro.info();
        assertFalse(outContent.toString().isEmpty(), "Nenhuma mensagem foi impressa no console.");
    }
    @Order(2)
    @Test
    public void verificaInstanciacaoDolar(){
        Moeda dolar = new Dolar(1);
        assertEquals(5.69, dolar.converter());
        dolar.info();
        assertFalse(outContent.toString().isEmpty(), "Nenhuma mensagem foi impressa no console.");
    }
    @Order(3)
    @Test
    public void verificaInstanciacaoReal(){
        Moeda real = new Real(1);
        assertEquals(1, real.converter());
        real.info();
        assertFalse(outContent.toString().isEmpty(), "Nenhuma mensagem foi impressa no console.");
    }
    @DisplayName("Removendo cofrinho")
    @Order(4)
    @Test
    public void verificaRemoveListaCofrinho(){
        Moeda real = new Real(1);
        Cofrinho cofrinho = new Cofrinho();
        cofrinho.adicionar(real);
        cofrinho.remover(real);
        assertNull(cofrinho);
    }

    @DisplayName("Listando moedas")
    @Order(5)
    @Test
    public void verificaRetornoListagemCofrinho(){
        Moeda real = new Real(1);
        Moeda dolar = new Dolar(1);
        Moeda euro = new Euro(1);
        Cofrinho cofrinho = new Cofrinho();
        cofrinho.adicionar(real);
        cofrinho.adicionar(dolar);
        cofrinho.adicionar(euro);
        cofrinho.listagemMoedas();
        assertFalse(outContent.toString().isEmpty(), "Nenhuma mensagem foi impressa no console.");
    }
    @DisplayName("Todas moedas convertidas")
    @Order(6)
    @Test
    public void verificaRetornoMoedasConvertidasCofrinho(){
        Moeda real = new Real(1);
        Moeda dolar = new Dolar(1);
        Moeda euro = new Euro(1);
        Cofrinho cofrinho = new Cofrinho();
        cofrinho.adicionar(real);
        cofrinho.adicionar(dolar);
        cofrinho.adicionar(euro);
        cofrinho.totalConvertido();
        assertFalse(outContent.toString().isEmpty(), "Nenhuma mensagem foi impressa no console.");
    }







}
