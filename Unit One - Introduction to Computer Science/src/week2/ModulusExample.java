package week2;

public class ModulusExample {
    public static void main(String[] args) {
        int num = 4689;

        int num1 = num / 1000;     // 4

        int num4 = num % 10;     //9

        int num2 = num / 100 % 10; // 6

        int num3 = num / 10 % 10; //8
        // does the same thing as above^: num3 = num % 100 / 10;


    }


}
