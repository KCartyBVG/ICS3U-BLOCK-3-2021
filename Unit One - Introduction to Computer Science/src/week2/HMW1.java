package week2;

/**
 * Write a program that takes a decimal number then displays the number and the square to the console in a presentable way.
 */

public class HMW1 {
    public static void main(String[] args) {
        double number = 7.7;

        double numSqrd = number * number;

        System.out.println(number + " x " + number + " = " + numSqrd);

    /**
     * Create a program that obtains two integers, one for the amount a test is out of and another indicating what a student received. Display what percentage the student received on the test.
     */ 
        int testTotal = 60;

        int testScore = 57;

        double testPercentage = ((double)testScore/testTotal);

        testPercentage = testPercentage * 100;

        System.out.println("The student received " + testPercentage + "%");


        /**
         * Write a program that uses a five digit number and calculates the product of the 2nd and 4th digit. Use the modulus and division operators.
         */

        int num = 36785;

        int num1 = num / 1000 % 10;

        int num2 = num / 10 % 10;

        /**
         * Create a program that can be used to calculate the final velocity of a car given the initial velocity, the acceleration of the car and the time that has elapsed using the following equation:
         * vf= vi+at
         */
        
         int vi = 7;
         int acc = 10;
         int t = 6;

         int vf = vi + acc * t;

        /**
         * Write program that can calculate the area of circle. You will need to create variables for the radius and the area.
         * a = pi*r^2
         */

        int radius = 3;
        
        final double pi = 3.1415;

        double area = pi * (radius * radius);

        /**
         * Write a program that can calculate the volume of a sphere.
         * V = 4/3 * pi *r^3
         */

        double volume = 4 / 3 * pi * (radius * radius * radius);

        /**
         * Create a program that can solve the equation y = ax^2+bx+c given a, b, c and x.
         */

        int a = 4;
        int b = 5;
        int c = 6;
        int x = 7;

        int y = a*x*x+b*x+c; 

        /**
         * Write a program to calculate the slope of a line give (x1, y1) and (x2,y2).
         */

         int x1 = 7;
         int y1 = 4;
         int x2 = 6;
         int y2 = 5;

         int slope = (y2 - y1) / (x2 - x1);

         /**
          * Write a program that given the number of pennies, nickles, dimes, quarters, loonies and toonies calculates how much money the user has.
          */

          double pennies = 3;
          double nickels = 4;
          double dimes = 5;
          double quarters = 5;
          int loonies = 3;
          int toonies = 7;

         pennies *= 0.01;
          nickels *= 0.05;
          dimes *= 0.10;
          quarters *= 0.25;
         toonies *= 2;

         double totalMoney = pennies + nickels + dimes + quarters + loonies + toonies;
        
         /**
          * Math.sqrt(x), where x is a value can be used to calculate the square root. Given an equation in the format from question 7.  Obtain the two roots. Given a, b, and c.
          */

        a = 1;
        b = 4;
        c = 2;
        double firstRoot = (b*b)-(4*a*c);
        firstRoot = Math.sqrt(firstRoot);
        firstRoot = -b+firstRoot;
        double secondRoot = b+firstRoot/2*a;
        firstRoot = firstRoot/2*a;//Everytime I try to do this equation in different ways it comes out as NaN
                                    // I had just picked bad numbers 
        System.out.println(firstRoot);

        System.out.println(secondRoot);


        
        //  = (-1*b+ Math.sqrt(b*b-4*a*c)) /2*a;
        //  = (-1 * b - Math.sqrt(b*b - 4*a*c)) /2*a;

       

    }
}
