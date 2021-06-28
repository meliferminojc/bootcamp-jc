package aula02.TT.individual.Ex1;

public class Gerente extends Funcionario {


    public Gerente(double salario, int jornadaTrabalho) {
        super(salario, jornadaTrabalho, 1.125);
    }

    @Override
    public double pagarSalario() {
        return getSalario() * bonus;
    }
}
