package aula02.TT.individual.Ex1;

public class Analista extends Funcionario {


    public Analista(double salario, int jornadaTrabalho) {
        super(salario, jornadaTrabalho, 1.08);
    }

    @Override
    public double pagarSalario() {
        return getSalario() * bonus;
    }
}