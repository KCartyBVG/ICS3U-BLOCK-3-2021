package week9;

import javax.lang.model.util.ElementScanner6;

public class HiddenWord {
    private String hiddenWord;
    public HiddenWord(String word) {
        hiddenWord = word;
    }

    public String getHint(String guess) {
       String result = "";

       for (int i = 0; i < guess.length(); i++) {
        String a = guess.substring(i, i+1);
        String b = hiddenWord.substring(i, i+1);
        if (a.equals(b)) {
            result += a;
        } else if (hiddenWord.indexOf(a) >= 0) {
            result += "+";
        } else
            result += "*";
        }
        return result;
    }
}
