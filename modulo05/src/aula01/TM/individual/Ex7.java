package aula01.TM.individual;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class Ex7 {
    public static void main(String[] args) {
        LocalDate data = LocalDate.now();
        String formatedDate = data.format(DateTimeFormatter.ofPattern("dd/MM/yyyy"));

        double valorpresaX = 1.13; //1,13m
        double crescmpresaX = 1.48; //148%

        double valorpresaY = 18.4; //18,4m
        double crescmpresaY = 0.32; //32%

        System.out.printf("Empresa X - %s - Valor da Empresa %5.2fm\n", formatedDate, valorpresaX);
        System.out.printf("Empresa Y - %s - Valor da Empresa %5.2fm\n\n", formatedDate, valorpresaY);

        while (valorpresaX < valorpresaY) {
            data = data.plusYears(1);
            formatedDate = data.format(DateTimeFormatter.ofPattern("dd/MM/yyyy"));

            valorpresaX *= (1 + crescmpresaX);
            valorpresaY *= (1 + crescmpresaY);

            System.out.printf("Empresa X - %s - Valor da Empresa %5.2fm\n", formatedDate, valorpresaX);
            System.out.printf("Empresa Y - %s - Valor da Empresa %5.2fm\n\n", formatedDate, valorpresaY);

        }
    }
}
