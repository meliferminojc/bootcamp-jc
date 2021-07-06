package br.com.meli.calculadorametrosquadrados.entities;

public class Comodo {
    private String nome;
    private Double largura;
    private Double comprimento;
    private Double metrosQuadrados;

    public Comodo(String nome, Double largura, Double comprimento) {
        this.nome = nome;
        this.largura = largura;
        this.comprimento = comprimento;
        this.metrosQuadrados = largura * comprimento;
    }

    public Double getMetrosQuadrados() {
        return metrosQuadrados;
    }

    public String getNome() {
        return nome;
    }

    @Override
    public String toString() {
        return "Comodo{" +
                "nome='" + nome + '\'' +
                ", largura=" + largura +
                ", comprimento=" + comprimento +
                ", metrosQuadrados=" + metrosQuadrados +
                '}';
    }
}
