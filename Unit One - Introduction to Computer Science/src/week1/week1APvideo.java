/* 
 * Programmer: Kathryn Carty
 * Date: 9/9/2021
 * Purpose: Demonstrate the System class methods/ PRACTICE 
 */
// BLOCK COMMENTS - The compiler will ignore any text between the /* and */ characters.

package week1; // PACKAGE? - the folder that the file is in.

class week1APvideo { //CLASS DECLARATION - Identifies the name, the start, and the end of the class. The class MUST match the file name. (ie.week1APvideo.java)
public static void main(String[] args) {//MAIN METHOD - controls all of the actions in the program.
    System.out.print("AP "); // System.out - object that generates output to the console.
   // System.out.print - display whatever is in the () on the screen, but wait at the end of the line for more info to display(doesn't automatically go to next line/hit enter).
   System.out.println("S"); //System.out.println - display whatever is in the () on the screen, then moves to the next line.
 System.out.print("this is a string literal");
 System.out.println("!");
 System.out.print("ABC$%&");
}
    
}

/*MAKE SURE TO PUT SEMI COLEN AFTER EACH SYSTEM.OUT LINE
 *hit "Run" to compile and run
 *A string literal in java is an exact sequence of characters (letters, number or symbols) which are enclosed between two quotation marks. 
 *"this is a string literal" 
 */

