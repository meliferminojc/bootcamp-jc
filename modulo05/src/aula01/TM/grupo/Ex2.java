package aula01.TM.grupo;

import java.util.Scanner;

public class Ex2 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Digite quantos números você deseja ver: ");
        int n1 = scanner.nextInt();
        System.out.println("Pelo multiplo de qual número? ");
        int n2 = scanner.nextInt();
        int contador = 0;
        int iterator = 1;

        while (contador < n1) {
            if (iterator % n2 == 0) {
                System.out.println(iterator);
                contador++;
            }
            iterator++;
        }
    }
}
