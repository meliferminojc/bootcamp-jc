package aula02.TM.grupo;

public class Estudante {

    private String nome;
    private int idade;
    private String numeroMatricula;
    private Integer serie;

    public Estudante(String nome, int idade, String numeroMatricula, Integer serie) {
        this.nome = nome;
        this.idade = idade;
        this.numeroMatricula = numeroMatricula;
        this.serie = serie;
    }

    @Override
    public String toString() {
        return "Estudante{" +
                "nome='" + nome + '\'' +
                ", idade=" + idade +
                ", numeroMatricula='" + numeroMatricula + '\'' +
                '}';
    }
}
