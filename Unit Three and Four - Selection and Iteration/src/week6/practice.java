package week6;

public class practice {
    public static void main(String[] args) {
        //System.out.println(within("TSCATPOCAT", "CAT"));
        // three("television");

        System.out.println(convertToSeconds("5:34.78"));

        System.out.println(rollerCoaster(true, true));

        System.out.print(backwards("FLOWER"));
    }

    private static String backwards(String str) {
        String word = "";
        for (int i= str.length()-1; i>=0;i--) {
            String letter = str.substring(i, i+1);
            word += letter;
        } 
        return word;
    }


    private static int rollerCoaster(boolean funnelCake, boolean slushie) {
       int throwUp = 0;
        if (funnelCake == false && slushie == false){
            throwUp = 0;
        } else if (funnelCake == true && slushie == false) {
            throwUp = 4;
        } else if (slushie == true && funnelCake == false) {
            throwUp = 2;
        } else 
            throwUp = 8;
        return throwUp;
    }

    private static double convertToSeconds(String str) {
        int colon = str.indexOf(":");
        String minutes = str.substring(0,colon);
        String seconds = str.substring(colon + 1);

        double mins = Double.valueOf(minutes);
        double secs = Double.valueOf(seconds);

        double totalSeconds = mins*60 + secs;

        return totalSeconds;

    }

    private static void three(String str) {
        System.out.println(str.substring(0, 3));
    }

    private static int within(String str, String word) {
        int count = 0;
        int i = 0;

        /* for (int i=0; i<=str.length()-word.length(); i++) {
            String nextThree = str.substring(i, i+word.length());

            if (nextThree.equals(word)){
                count++;
            }
        }
        */

        while (i<=str.length()-word.length()) {

            String nextChar = str.substring(i, i+word.length());
            if (nextChar.equals(word)) {
                count++;
            }
            i++;
        }
        return count;
    }
}
