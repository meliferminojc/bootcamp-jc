package aula02.TT.individual.Ex1;

public class Tecnico extends Funcionario {


    public Tecnico(double salario, int jornadaTrabalho) {
        super(salario, jornadaTrabalho, 1.05);
    }

    @Override
    public double pagarSalario() {
        return getSalario() * bonus;
    }
}
