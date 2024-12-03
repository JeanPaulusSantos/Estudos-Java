package org.example;

import br.jean.Pessoa;
import br.jean.util.DateUtils;

import java.io.*;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )throws IOException
    {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        System.out.println("Digite a data de nascimento no formato dd/mm/aaaa: ");
        String s = br.readLine();
        Pessoa p = new Pessoa();
        System.out.printf("Data de nascimento é: %s%n", p.calcularIdade(DateUtils.stringToDate(s)));
    }
}
