package aula02.TT.individual.Ex1;

public abstract class Funcionario {
    private double salario = 0;
    private int jornadaTrabalho = 0;
    protected double bonus = 0;

    public Funcionario(double salario, int jornadaTrabalho, double bonus) {
        this.salario = salario;
        this.jornadaTrabalho = jornadaTrabalho;
        this.bonus = bonus;
    }

    public abstract double pagarSalario();

    public double getSalario() {
        return salario;
    }
}
