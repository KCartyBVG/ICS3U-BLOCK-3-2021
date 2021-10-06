package week5;

import java.util.Scanner;


public class idea {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        Avengers(in);
        in.close();
    }

    private static void Avengers(Scanner in) {
       String name, favAvenger;
        
        System.out.print("Please insert your name: ");
        name = in.nextLine();

        System.out.println("Welcome, " + name + ", to the Avengers assesment. Please answer the following questions.");

        System.out.print("Please type \"Ready\" when you're ready. ");
       
        if (in.nextLine().equals("Ready")){
        System.out.println("Who Is your favorite member of the Avengers?");
        favAvenger = in.nextLine();

            if (favAvenger.equals("Spiderman")) {
                System.out.println("Why?");
                String reason = in.nextLine();

                System.out.println("Interesting.");
            }else if (favAvenger.equals("Thor")) {
                System.out.println("Why?");
                String reason = in.nextLine();

                System.out.println("Interesting.");
            }else if (favAvenger.equals("Scarlet Witch")) {
                System.out.println("Why?");
                String reason = in.nextLine();

                System.out.println("Interesting.");
            }else if (favAvenger.equals("Captain America")) {
                System.out.println("Why?");
                String reason = in.nextLine();

                System.out.println("Interesting.");
            }else {
                System.out.println("Sorry, the devoloper of this super cool and awesome Avengers assesment didn't have enough patience to make if scenarios for more characters. please forgive her.");
            }

            

        }



    }
}
