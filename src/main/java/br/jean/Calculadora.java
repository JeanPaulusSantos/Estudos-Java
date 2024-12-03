package br.jean;

import java.security.InvalidParameterException;

public class Calculadora {

    public int somar(int a, int b) {
        return a + b;
    }

    public int subtrair(int a, int b) {
        if (a > b)
            return a - b;
        else if (a < b )
            return b - a;
        else
            throw new InvalidParameterException();
    }
}
