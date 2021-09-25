package week3;

public class ExtraPractice {
    public static void main(String[] args) {
        questionOne();
        questionTwo();
        
        System.out.println(questionThree());
        System.out.println(questionFour(3, 9));

        System.out.println(questionFive("Hello"));

        System.out.println(questionSix("Candle", "an"));

        System.out.println(questionSeven("Pizza", "Cheese"));

        System.out.println(questionEight(3, 4, 6, 7));

        System.out.println(questionNine(4, 8));

        System.out.println(questionTen("Canada"));

    }
// write methods outside of main method


/**
 * obtains and displays an interger between 1 and 100
 */
 public static void questionOne() { //void method because it doesn't return anything
    int num = (int) (Math.random()*100) + 1;
    // (int) (Math.random()* numPosibilities) + startNum
    System.out.println(num);
 } 

 /**
  * number 2: obtains and display an interger between -50 and 50
  */
public static void questionTwo() {
int num1 = (int) (Math.random()*101) -50;

System.out.println(num1);

}

/**
 * Simulate the roll of a die by obtaining and returning an integer from 1 to 6.
 */

 public static int questionThree() {
int num2 = (int) (Math.random()*6) +1;

 return num2;
 }

 /**
  * Create a function that accepts 2 ints (smaller and bigger) and return a random integer between those two numbers inclusive.
  */

  public static int questionFour(int smaller, int bigger) {
    int numPosibilities = bigger - smaller;

    int random = (int) (Math.random()*numPosibilities) + smaller;

    return random;
  }

  /**
   * Create a function that accepts a String and returns a substring with the first "e" removed.
   */

    public static String questionFive(String eWord) {
        int e = eWord.indexOf("e");
        String first = eWord.substring(0,e);
        String last = eWord.substring(e+1);

        return first+last;
      }
    /**
     * Create a function that accepts a String and a substring and then returns a String with the second string removed from the first String. 
     */

     public static String questionSix(String str, String subStr) {
        int firstLetter = str.indexOf(subStr);
        int subLength = subStr.length();
        String front = str.substring(0,firstLetter);
        String back = str.substring(firstLetter+subLength);

        return front + back;
     }

     /**
      *  Create a function that accepts two Strings and returns the length of the two strings added together.
      */
      public static int questionSeven(String first, String second) {
      int length = first.length() + second.length();

      return length;
      }

      /**
       * Create a function that takes 4 integers (x1,y1, x2,y2) and obtains the slope of the line connecting those two points.
       * 
       * (y2-y1)/(x2-x1)
       */
      public static int questionEight(int x1, int y1, int x2, int y2) {
        int slope = (y2-y1)/(x2-x1);

        return slope;

      }

      /**
       * Create a function that can be used to calculate the volume of a cylinder. Radius and Height are the parameters for the function.
       * v=pi * Math.pow(r, 2)*h
       */

       public static double questionNine(int r, int h) {
        double v = Math.PI * Math.pow(r,2) * h;

        return v;
       }
       /**
        * Create a function that removes a random characters from a String and returns the new string. Accept the String as an argument.
        */

        public static String questionTen(String str) {
            int numPosibilities = str.length();
            int random = (int) (Math.random()*numPosibilities) +1;
            String front = str.substring(0, random);
            String back = str.substring(random+1);

            return front + back;
        }

}
