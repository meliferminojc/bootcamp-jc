package aula01.TM.individual;

public class Ex8 {
    public static void main(String[] args) {
        double valorTotal = 0;
        Produto produto1 = new Produto("Arroz", 10.99, 2);
        Produto produto2 = new Produto("Feijão", 14.49, 1);
        Produto produto3 = new Produto("Tomate", 9.99, 5);

        valorTotal = produto1.getTotal() + produto2.getTotal() + produto3.getTotal();
        System.out.printf("Valor Total: R$%2.2f", valorTotal);
    }
}
