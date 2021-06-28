package aula02.TT.individual.Ex1;

public class Diretor extends Funcionario {

    public Diretor(double salario, int jornadaTrabalho) {
        super(salario, jornadaTrabalho, 1.03);
    }

    @Override
    public double pagarSalario() {
        return getSalario() * bonus;
    }
}
