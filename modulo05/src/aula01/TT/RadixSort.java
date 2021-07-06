package aula01.TT;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class RadixSort {
    static final int BASE_CONVERSAO = 10;

    public static void radixSort(int iArr[]) {
        String maiorString = getMaiorNumero(iArr);
        String sArr[] = new String[iArr.length];
        String s[] = new String[iArr.length];

        for(int i = 0; i < iArr.length; i++) {
            String number = String.valueOf(iArr[i]);
            sArr[i] = new String();

            for (int j = number.length(); j < maiorString.length(); j++) {
                sArr[i] += "0";
            }
            sArr[i] += number;
        }
        List<String> L0 = new ArrayList<>();
        List<String> L1 = new ArrayList<>();
        List<String> L2 = new ArrayList<>();
        List<String> L3 = new ArrayList<>();
        List<String> L4 = new ArrayList<>();
        List<String> L5 = new ArrayList<>();
        List<String> L6 = new ArrayList<>();
        List<String> L7 = new ArrayList<>();
        List<String> L8 = new ArrayList<>();
        List<String> L9 = new ArrayList<>();
        List<String> orderedList = new ArrayList<>();
        int contador = 0;
        for (int i = 1; i <= maiorString.length(); i++) {
            L0 = filtraLista(sArr, i,  Character.forDigit(contador++, BASE_CONVERSAO));
            L1 = filtraLista(sArr, i,  Character.forDigit(contador++, BASE_CONVERSAO));
            L2 = filtraLista(sArr, i,  Character.forDigit(contador++, BASE_CONVERSAO));
            L3 = filtraLista(sArr, i,  Character.forDigit(contador++, BASE_CONVERSAO));
            L4 = filtraLista(sArr, i,  Character.forDigit(contador++, BASE_CONVERSAO));
            L5 = filtraLista(sArr, i,  Character.forDigit(contador++, BASE_CONVERSAO));
            L6 = filtraLista(sArr, i,  Character.forDigit(contador++, BASE_CONVERSAO));
            L7 = filtraLista(sArr, i,  Character.forDigit(contador++, BASE_CONVERSAO));
            L8 = filtraLista(sArr, i,  Character.forDigit(contador++, BASE_CONVERSAO));
            L9 = filtraLista(sArr, i,  Character.forDigit(contador, BASE_CONVERSAO));
            contador = 0;
        }
//        L1.forEach(System.out::println);

//        orderedList.forEach(x -> System.out.println(x));
        System.out.println(s);
    }


    public static void main(String[] args) {
        int iArr[] = { 16223, 898, 13, 906, 235, 23, 9, 1532, 6388, 2511, 8, 990, 99};

        radixSort(iArr);

    }

    public static String getMaiorNumero(int arr[]) {
        Integer maior = Integer.MIN_VALUE;
        for (int i : arr) {
            if (i > maior) {
                maior = i;
            }
        }

        return maior.toString();
    }

    public static List<String> filtraLista(String[] arr, int index, char comparator) {
        return Arrays.stream(arr).filter(x -> x.charAt(x.length() - index) == comparator).collect(Collectors.toList());
    }
}
