package aula02.TM.grupo;

import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        Disciplina[] disciplinas = new Disciplina[2];
        disciplinas[0] = new Disciplina("Java", 20);
        disciplinas[1] = new Disciplina("Fury", 20);

        Estudante[] estudantes = new Estudante[2];
        estudantes[0] = new Estudante("Jobsclei", 24, "23692", 3);
        estudantes[1] = new Estudante("Cleberson", 24, "23692", 3);

        Turma turma1 = new Turma("A", 2, disciplinas);

        turma1.setAlunos(estudantes);
        System.out.println(turma1);
        List<String> array = new ArrayList<String>();
    }
}
