package week5;

public class formatting {
    public static void main(String[] args) {
        //5:3.272       => 5 : 3.272
        // 5:03.272

        int minutes = 5;
        double seconds = 3.2728745;

        // i want this: 5:03.272


        // placeholders
        //%d ->ints
        // %f -> floating point numbers (double)
        //%06.3f -> pad the left side with 0 width of 6 and 3 decimal places

        //System.out.printf("blah%dtest %f", minutes, seconds);
        System.out.printf("%d:%06.3f", minutes, seconds); // (.3 mean s decimal places)(6 means 6 total spaces)(0 means it fills the extra spaces with 0s)
        System.out.printf("%d:%06.3f", minutes, seconds); // (.3 mean s decimal places)(6 means 6 total spaces)(0 means it fills the extra spaces with 0s)

        }

}
