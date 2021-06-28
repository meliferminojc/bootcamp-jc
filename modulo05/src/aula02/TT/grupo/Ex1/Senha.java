package aula02.TT.grupo.Ex1;

public class Senha {
    private String regex;

    public Senha(String regex) {
        this.regex = regex;
    }

    public void setSenha(String senha) {
        boolean matchPwd = senha.matches(this.regex);
        if (matchPwd) {
            System.out.println("aula02.TT.grupo.Ex1.Senha OK");
        } else {
            throw new IllegalArgumentException("aula02.TT.grupo.Ex1.Senha não bate com o exigido");
        }

    }
}
