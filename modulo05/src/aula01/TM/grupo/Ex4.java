package aula01.TM.grupo;

import java.util.Scanner;

public class Ex4 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Digite um número ");
        int numero = scanner.nextInt();
        int contador = 0;
        int primo = 0;

        for (int i = 0; numero > contador; i++) {
            for (int j = 1; j <= i; j++) {
                if(i % j == 0) {
                    primo++;
                }
            }

            if(primo == 2) {
                System.out.println(i);
                contador++;
            }

            primo = 0;
        }
    }
}
