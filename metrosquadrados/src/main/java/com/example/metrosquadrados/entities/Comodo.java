package com.example.metrosquadrados.entities;

public class Comodo {
    private String nome;
    private double largura;
    private double comprimento;
    private Double metrosQuadrados;

    public Comodo(String nome, double largura, double comprimento) {
        this.nome = nome;
        this.largura = largura;
        this.comprimento = comprimento;
    }

    public double calculaMetrosQuadrados() {
        return this.metrosQuadrados = this.largura * this.comprimento;
    }

    public double getMetrosQuadrados() {
        return metrosQuadrados;
    }
}
