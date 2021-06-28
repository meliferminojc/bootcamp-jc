package aula02.TT.grupo.Ex1;

public class Main {
    public static void main(String[] args) {
        SenhaFraca senhaFraca = new SenhaFraca("[0-9]{3,}");
        SenhaMedia senhaMedia = new SenhaMedia("[0-9]{5,}");
        SenhaForte senhaForte = new SenhaForte("[0-9]{10,}");

        // Passando
        senhaFraca.setSenha("1234");
        senhaMedia.setSenha("123456");
        senhaForte.setSenha("012345678911");

    }
}
