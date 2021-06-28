package aula02.TM.grupo;

import java.util.Arrays;

public class Turma {
    private String codigo;
    private int turma;
    private Disciplina[] disciplinas;
    private Estudante[] alunos;

    public Turma(String codigo, int turma, Disciplina[] disciplinas) {
        this.codigo = codigo;
        this.turma = turma;
        this.disciplinas = disciplinas;
    }

    public String getCodigo() {
        return codigo;
    }

    public int getTurma() {
        return turma;
    }

    public Disciplina[] getDisciplinas() {
        return disciplinas;
    }

    public void setDisciplinas(Disciplina[] disciplinas) {
        this.disciplinas = disciplinas;
    }

    public Estudante[] getAlunos() {
        return alunos;
    }

    public void setAlunos(Estudante[] alunos) {
        this.alunos = alunos;
    }

    @Override
    public String toString() {
        return "Turma{" +
                "codigo='" + codigo + '\'' +
                ", turma=" + turma +
                ", disciplinas=" + Arrays.toString(disciplinas) +
                ", alunos=" + Arrays.toString(alunos) +
                '}';
    }
}
