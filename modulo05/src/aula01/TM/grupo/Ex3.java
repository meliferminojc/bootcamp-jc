package aula01.TM.grupo;

import java.util.Scanner;

public class Ex3 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Digite um número ");
        int numero = scanner.nextInt();
        int contador = 0;

        for(int i = 1; i <= numero; i++) {
            if(numero % i == 0) {
                contador++;
            }
        }

        if (contador == 2) {
            System.out.println("O número é primo");
        } else {
            System.out.println("O não número é primo");
        }
    }
}
