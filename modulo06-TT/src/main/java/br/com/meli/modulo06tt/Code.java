package br.com.meli.modulo06tt;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Code {
    private String morseCode;

    List<String> letter = Arrays.asList( "a", "b", "c", "d", "e", "f", "g", "h", "i", "j", "k", "l",
            "m", "n", "o", "p", "q", "r", "s", "t", "u", "v", "w", "x",
            "y", "z", "1", "2", "3", "4", "5", "6", "7", "8", "9", "0",
            ",", ".", "?");

    List<String> morse = Arrays.asList(".-", "-...", "-.-.", "-..", ".", "..-.", "--.", "....", "..",
            ".---", "-.-", ".-..", "--", "-.", "---", ".--.", "--.-", ".-.",
            "...", "-", "..-", "...-", ".--", "-..-", "-.--", "--..", ".----",
            "..---", "...--", "....-", ".....", "-....", "--...", "---..", "----.",
            "-----", "--..--", ".-.-.-", "..--.." );

    public String getMorseCode() {
        return morseCode;
    }

    public String convertCodeToWord() {
        StringBuilder translated = new StringBuilder();
        String[] words = this.morseCode.split("   ");
        List<String[]> letters = new ArrayList<>();



        for (int i = 0; i < words.length; i++) {
            letters.add(words[i].split(" "));
        }

        for (int i = 0; i < letters.size(); i++) {
            for (int j = 0; j < letters.get(i).length; j++) {
                int index = morse.indexOf(letters.get(i)[j]);
                translated.append(letter.get(index));
            }
            translated.append(" ");
        }

        return translated.toString();
    }
}
