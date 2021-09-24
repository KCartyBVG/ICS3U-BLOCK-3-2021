package week3;

public class ExtraPractice {
    public static void main(String[] args) {
        questionOne();
        questionTwo();
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

}
