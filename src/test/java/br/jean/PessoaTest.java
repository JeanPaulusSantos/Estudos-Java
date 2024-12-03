package br.jean;

import org.junit.jupiter.api.Test;

import java.util.Date;

import static org.junit.jupiter.api.Assertions.*;

class PessoaTest {

    @Test
    void calcularIdade() {

        Date data1 = new Date(973266509L * 1000);
        Date data2 = new Date(978277709L * 1000);

        Pessoa p = new Pessoa();

        assertEquals(24, p.calcularIdade(data1));
        assertEquals(23, p.calcularIdade(data2));

    }
}