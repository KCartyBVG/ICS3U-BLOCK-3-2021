package week4;

public class ifStatementsANDbooleanPractive {
    public static void main(String[] args) {
        int myAge = 14;
        System.out.println("Current Age: " + myAge);
        if (myAge >= 16) {
            System.out.println("You can learn to drive a car.");
            myAge++;
        } else {
            System.out.println("You are not old enough for a drivers license.");
        }
        System.out.println("On your next birthday, you will be " + myAge + ".");

        System.out.println("question one:");

        int a = 10;
        int b = 5*2;
        System.out.println(a == b);


        double myAverage = 89;
        System.out.println("Current average: " + myAverage);
        if (myAverage >= 89.45){
            System.out.println("You have an \"A\" average.");
        }else if (myAverage >= 79.45) {
            System.out.println("You have a \"B\" average.");
        }else if (myAverage >= 69.45) {
            System.out.println("You have a \"C\" average.");
        }
    }
    
}
