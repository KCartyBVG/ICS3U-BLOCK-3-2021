package week4;

public class factorial {
    public static void main(String[] args) {
        int n=6;
       System.out.println(factorial(n)); 
       System.out.println(fib(6));
    }

    // 7! = 7 x 6 x 5 x 4 x 3 x 2 x 1
    // 7! = 7x 6!

    // factorial (7) = 7 x factorial(6)
    private static int factorial(int n) {
        if (n == 1){
            return 1;
        } else 
            return n*factorial(n-1);
    }
/**
 * m returns the nth number in the sequence
 * 
 * 1, 1, 2, 3, 5, 8, 13
 */
    private static int fib(int n) {
        if (n == 1 || n ==2)
            return 1;
        else 
            return fib(n-1) + fib(n-2);
    }
}
