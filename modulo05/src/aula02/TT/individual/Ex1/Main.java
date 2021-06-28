package aula02.TT.individual.Ex1;

public class Main {
    public static void main(String[] args) {
        Funcionario tecnico = new Tecnico(3200, 40);
        Funcionario analista = new Analista(4000, 40);
        Funcionario gerente = new Gerente(6000, 36);
        Funcionario diretor = new Diretor(15000, 40);

        System.out.println(tecnico.pagarSalario());
        System.out.println(analista.pagarSalario());
        System.out.println(gerente.pagarSalario());
        System.out.println(diretor.pagarSalario());
    }
}
