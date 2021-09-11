/**
 * Purpose: Demonstrate declaring and using variables   
 */

 package week1;

 public class Video2 {
 
     public static void main(String[] args) {
        String name = "Mark Dean";      // declaring and initializing a String variable

        double avgGrade;    // declaring a double variable

        avgGrade = 92.6;    // initializing the avgGrade variable

        final int NUMCLASSES = 4;   // defining a constat. this means that the rest of the program cannot change this number other then that specific line

        boolean isEnrolled = true;  // declaring and initializing a Boolean variable 

        System.out.println(name + " has " + NUMCLASSES + " classes, ");
        System.out.println("and average grade is " + avgGrade);
        System.out.println(name + " is currently ");
        System.out.println("enrolled at school: " + isEnrolled);


        /**
         * Next video:
         */

         int firstValue;
         firstValue = 13;

         double secondValue;
         secondValue = 18.5;

         double sumOfValues;

        sumOfValues = firstValue + secondValue;

        System.out.print(sumOfValues);




     }
 }
     
 
     
 