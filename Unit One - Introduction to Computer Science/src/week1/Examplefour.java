package week1;


/**
 * Variables - used to store data
 * Primitive Data Types - (int / double / char / boolan)
 * Assignment / Assignment Operator - used to store values/data in variables 
 */
public class Examplefour {
    public static void main(String[] args) {
        int markOne, markTwo, markThree;    //declared 3 integer variables

        markOne = 75;       //mark one is assigned a 75. = means assigned 
        markTwo = 80;
        markThree = 87;

        int average = (markOne + markTwo + markThree) / 3;

        System.out.println(average);
        System.out.println("The average is:" + average); // string concatation - joined the string with something else


    }
}
