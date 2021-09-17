package week2;

public class StringExamples {
    public static void main(String[] args) {
        String s1 = "This is a String Literal";
        String s2 = "This is a String Literal";
        String s3 = new String("This is a String Literal");     // it is not a String Literal nut a String object


        System.out.println(s1.length());    // .lenght tells you how many characters are in a string/the length

        System.out.println(s1.equals(s2));  // will tell you if s1 and s2 are the same

        System.out.println(s1.indexOf("in"));   // tells you where to find the first occurance
        // returns -1 if its not there

        String s4 = "0123456789";
        String s5 = "ABCDEFGHI";       // starts counting indexes at 0, 1, 2, 3, 4, 5, 6, 7, 8, 9
        System.out.println(s4.substring(3));       // starts printing at index 3 (3)
        System.out.println(s4.substring(3,7));  // starts at index 3 (3) and ends at index 7 (7)
        System.out.println(s5.substring(3,7));  // starts at index 3 (D) and ends at index 7 (G)
        

    }

}
