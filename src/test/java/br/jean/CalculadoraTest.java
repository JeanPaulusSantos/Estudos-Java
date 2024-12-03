package br.jean;


import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.function.Executable;

import java.security.InvalidParameterException;

public class CalculadoraTest {
    private final Calculadora calculadora = new Calculadora();

    @Test
    void somar() {
        int expected = 2;
        int calculated = calculadora.somar(1, 1);

        Assertions.assertEquals(expected, calculated);
    }

    @Test
    void subtrair() {
        Assertions.assertThrowsExactly(InvalidParameterException.class, () ->  calculadora.subtrair(0,0));
        Assertions.assertEquals(1, calculadora.subtrair(2, 1));
        Assertions.assertEquals(1, calculadora.subtrair(1, 2));

    }
}