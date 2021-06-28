package aula02.TT.grupo.Ex2;

public class Circulo extends GeometricFigure {
    private double raio;

    public Circulo(double raio) {
        this.raio = raio;
    }

    @Override
    public double area() {
        return 2 * Math.PI * raio;
    }
}
