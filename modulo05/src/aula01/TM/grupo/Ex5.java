package aula01.TM.grupo;

import java.util.Arrays;
import java.util.Scanner;

public class Ex5 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Digite um número ");
        int n1 = scanner.nextInt();
        System.out.println("Digite outro número ");
        int n2 = scanner.nextInt();
        System.out.println("Digite mais um número ");
        int n3 = scanner.nextInt();

        int contador = 0;
        int[] numerosEncontados = new int[n1];
        int aux = 0;
        int iterator = 0;


        while (contador < n1) {
            String numero = Integer.toString((iterator));

            for (int j = 0; j < numero.length(); j++) {
                if(Character.getNumericValue(numero.charAt(j)) == n3) {
                    aux++;
                    if (aux >= n2) {
                        numerosEncontados[contador] = iterator;
                        contador++;
                    }
                }
            }
            aux = 0;
            iterator++;
        }

        Arrays.stream(numerosEncontados).forEach(i -> System.out.println(i));

    }
}
