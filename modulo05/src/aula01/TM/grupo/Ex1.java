package aula01.TM.grupo;

import java.util.Scanner;

public class Ex1 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Quantos números pares você quer ver? ");
        int qtdNumeros = scanner.nextInt();
        int contador = 0;
        int iterator = 1;

        while (contador < qtdNumeros) {
            if (iterator % 2 == 0) {
                System.out.println(iterator);
                contador++;
            }
            iterator++;
        }
    }
}
