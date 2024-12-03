package br.jean;

import br.jean.util.DateUtils;

import java.util.Date;

public class Pessoa {
    public int calcularIdade(Date dataNascimento) {
        return DateUtils.diferencaEmAnos(new Date(), dataNascimento);
    }
}
