package com.example.metrosquadrados.entities;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class Casa {
    private static long id = 0;
    private String nome;
    private String endereco;
    private double metros;
    private final double VALOR_POR_METRO = 800;
    private List<Comodo> comodos = new ArrayList<>();

    public Casa(String nome, String endereco, double metros, List<Comodo> comodos) {
        this.nome = nome;
        this.metros = metros;
        this.endereco = endereco;
        this.comodos = comodos;
        this.id++;
    }

    public double valorCasa() {
        return this.metros * VALOR_POR_METRO;
    }

    public Comodo maiorComodo() {
        comodos.sort(Comparator.comparingDouble(Comodo::getMetrosQuadrados));
        Comodo comodo = comodos.get(comodos.size() - 1);
        return comodo;
    }

    public void calculaMetrosDosComodos() {
        this.comodos.forEach(comodo -> comodo.calculaMetrosQuadrados());
    }

}
