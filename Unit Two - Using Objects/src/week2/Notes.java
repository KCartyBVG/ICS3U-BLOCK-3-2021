/**
 * constructor:

public Student(String nm, int ag, boolean ad) {

name = nm;
age = ag;
isAdult = ad;

}

to creat a new object with the three variables:

Student personOne = new Student("Name", "12334", 12)

to fill in variables if not given when creating new object:

everything would be null



public Student()  {

name = null;
empId = null;
pay = 0;

}

to creat new object with only 2 variables:



 
public Employee(String nm, String id) {
name = nm;
empId = id;
pay = 20;

}

*/

// next vid

/**
 * Methods define the behaviors for all objects of class and consist of a set of instructions for executing the behavior.
 * 
 * Dog example:
 * 
 * public class Dog {
 * 
 * private string name;
 * private String breed;
 * private int age;
 * 
 * public Dog(String nm, String br, int ag) {
 * 
 * name - nm;
 * breed = br;
 * age = ag;
 * }
 * 
 * public void bark() {
 * System.out.print("Woof!");
 * 
 * }
 * }
 * 
 * then you make the dog:
 * 
 * public class DogTester {
 *      public static void main(String[] args) {
 * 
 *      Dog graceDog = new Dog("Grace", "lab", 1);
 *  graceDog.bark(); // this would make the dog do the bark command and would display Woof! onto the screen
 *  
 * }
 * }
 * 
 */


 /**
  * to write a letter
  * 
  * public class Letter()   {
  *     greeting();
  *     specialMessage();
  *     specialMessage();   // this would print the special message twice
  *     closing();
  * }
  * 
  * public void greeting () {
  *     System.out.println("Hi, friend!");
  * }
  * 
  * public void specialMessage ()  {
  *     System.out.println("Computer science is awesome!");
  * }
  * 
  * public void closing ()  {
  *     System.out.println("See you soon!");
  * }
  *
  * public static void main(String[]  args) {
  * Letter friendLetter = new Letter (); // this would make the new letter object
  * friendLetter.writeLetter();     // this would do the command writeLetter with the new object just created
  * }
  * }
  * 
  */


  /**
   * next vid: making a Lamp constructor and making attributes and behaviors 
   * 
   * public clas Lamp {
   * 
   *    private boolean isOn;
   * 
   * public void turnOn()  {
   *    isOn = true;
   *    System.out.println("The lamp is on.");
   * }
   * 
   * public void turnOff()  {
   *    isOn = false;
   *    System.out.println("The lamp is off."); 
   * }
   * 
   * public static void main(String[]  args)  {
   *    Lamp lamp1 = new Lamp();    //making the lamp object
   *    lamp1. turnOn();
   *    Lamp lamp2 = new Lamp();
   *    lamp2.turnOn ();
   *    lamp1.turnOff();
   *    Lamp lamp3; //haven't initialized anything 
   *    lamp3.turnOn(); // won't work because haven't declared the lamps as a Lamp
   *    //NullPointerExeption error
   * 
   * }
   * }
   */


   /**
    * next vid: calculator example
    * 
    * public class Calculator {
    * 
    * public void calcAverage(int num1, double num2) {
    *   double average = (num1 + num2) / 2;
    *   System.out.println("The average is " + average);
    * }
    * 
    * public static void main(String[]  args)  {
    * Calculator newAverage = new Calculator();
    * newAverage.calcAverage(20, 15.4);
    * }
    * }
    * 
    * 
    * 
    * same vid: grade print example
    * 
    * public class GradePrinter {
    * 
    * public void printInfo(String name, double grade)  {
    *   System.out.println(name + " has grade of " + grade);
    * }
    * 
    * public static void main(String[]  args)  {
    *   GradePrinter student1 = new GradePrinter();
    * 
    *   student1.printInfo("Jamila", 82.4);
    * }
    * 
    * }
    */

    /**
     * next vid: frog hops example
     * 
     * public class Frog {
     * 
     * public void move() {
     *      System.out.println("The frog moved forward 3 hops.");
     * }
     * 
     * public void move(int numHops)  {
     *  System.out.println("The frog moved forward " + numHops + " hops.");
     * }
     * 
     * public void move (String direction, int hops) {
     *      System.out.print("The frog moved to the " + direction);
     *      System.out.println(" " + hops + " hops.");
     * }
     * 
     * public static void main(String[]  args)  {
     *      Frog frog1 = new Frog();
     *      frog1.move();
     *      Frog frog2 = new Frog();
     *      frog2.move("left", 6);
     *      frog1.move(2);
     * }
     * }
     */

     