package aula01.TM.individual;

public class Ex6 {
    public static void main(String[] args) {
        Integer[] array = {52, 10, 85, 1324, 01, 13, 62, 30, 12, 127};

        // Crescente
        System.out.println("Crescente \n");
//        Arrays.sort(array);
//        Arrays.stream(array).forEach(i -> System.out.println(i));
        for (int i = 0; i < array.length; i++) {
            for (int j = i + 1; j < array.length; j++) {
                int tmp = 0;
                if (array[i] > array[j]) {
                    tmp = array[i];
                    array[i] = array[j];
                    array[j] = tmp;
                }
            }
            System.out.println(array[i]);
        }

        // Decrescente
        System.out.println("Decrescente");
//        Arrays.sort(array, Collections.reverseOrder());
//        Arrays.stream(array).forEach(i -> System.out.println(i));
        for (int i = 0; i < array.length; i++) {
            for (int j = i + 1; j < array.length; j++) {
                int tmp = 0;
                if (array[i] < array[j]) {
                    tmp = array[i];
                    array[i] = array[j];
                    array[j] = tmp;
                }
            }
            System.out.println(array[i]);
        }
    }
}
