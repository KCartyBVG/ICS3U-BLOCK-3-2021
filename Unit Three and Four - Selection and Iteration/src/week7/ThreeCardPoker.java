package week7;

import java.util.Scanner;

public class ThreeCardPoker {
    private static final int NUM_SUITS = 4;
    private static final String HEARTS = "H";
    private static final String DIAMONDS = "D";
    private static final String CLUBS = "C";
    private static final String  SPADES = "S";
    private static final double CARDS_PER_SUIT = 13;
    private static final String ACE = "A";
    private static final String JACK = "J";
    private static final String QUEEN = "Q";
    private static final String KING = "K";

    public static void main(String[] args) {
        // 7H AC KD - seven of hearts, ace of clubs, king of diamonds

        int wallet = 500;
        Scanner in = new Scanner(System.in);
        int bet = getWager(in, 50, 100, wallet);


        String playerHand = " ";
        playerHand += getCard(playerHand) + " ";
        playerHand += getCard(playerHand) + " ";
        playerHand += getCard(playerHand);
        

        System.out.println(playerHand);
        

       playerHand = discard(in, playerHand);
        
        System.out.println(playerHand);
    }

    private static String discard(Scanner in, String playerHand) {
       //ex. playerHand = "6H 2D AH"
       
        // ask how many cards to discard

        System.out.print("How many cards would you like to discard? [0, 1, 2, 3]: ");
        int discard = Integer.parseInt(in.nextLine());

        // 0 - do nothing
        // 3 - get them three cards to replace their old cards
        // 1 and 2 => ask them the cards to replace

        if (discard == 0) {

        }else if (discard == 3) {
            playerHand = getCard(playerHand) + " " + getCard(playerHand) + " " + getCard(playerHand);
        } else if (discard == 1) {
            System.out.print("What card would you like to replace? [Ex. 2D or KS]: ");
            String replaceCard = in.nextLine();

            
            String newTwo = getCard(playerHand);
            playerHand = playerHand.replace(replaceCard, newTwo);
                
            
        }else if (discard == 2) {
            System.out.print("What cards would you like to replace? [Ex. 2D KS or 3S AC]: ");
            String replaceCards = in.nextLine();

            //index of cards, length of cards, new variable for substring in playerHand, replace like above            
            String cardOne = replaceCards.substring(0, 2);
            String cardTwo = replaceCards.substring(3, 5);

            int indexFirstCard = playerHand.indexOf(cardOne);
            int firstCardLength = cardOne.length();

            String firstCard = playerHand.substring(indexFirstCard, indexFirstCard + firstCardLength);

            playerHand = playerHand.replace(firstCard, getCard(playerHand));

            int indexSecondCard = playerHand.indexOf(cardTwo);
            int secondCardLength = cardTwo.length();

            String secondCard = playerHand.substring(indexSecondCard, indexSecondCard + secondCardLength);

            playerHand = playerHand.replace(secondCard, getCard(playerHand));
        }
        

        // ex. if 1 card then user will type 6H (if they dont have 6H it will let them know that its not good input)

        // ex if 2 cards then user will type 6H AD (seperate the two cards and replace them serparatly)

        //return their new hand
        return playerHand;
    }

    private static String getCard(String usedCards) {
        String card = getFace() + getSuit();

        while (usedCards.indexOf(card) >= 0) {
           card = getFace() + getSuit();
        }

        return card;
    }

    private static String getSuit() {
        int suit = (int) (Math.random()*NUM_SUITS);

        if (suit == 0)
            return HEARTS;
        else if (suit == 1)
            return DIAMONDS;
        else if (suit == 2)
            return CLUBS;
        else 
            return SPADES; 
    }

    private static String getFace() {
        int suit = (int) (Math.random() * CARDS_PER_SUIT);

        if (suit >= 2 && suit <=10) {
            return suit + "";
        }else if (suit == 1)
            return ACE;
        else if (suit == 11)
            return JACK;
        else if (suit == 12)
            return QUEEN;
        else
            return KING;
    }
    

    private static int getWager(Scanner in, int minBet, int maxBet, int wallet) {
        boolean validBet = false;
        int bet = 0;
        while (!validBet) {   
        System.out.print("Please enter your bet [$" + minBet + " - $" + maxBet + "]: ");

            try { 
                bet = Integer.parseInt(in.nextLine());

                if (bet > maxBet || bet < minBet) {
                    System.out.println("Your bet must be between [$" + minBet + " - $" + maxBet + "]");
                }else if (bet > wallet) {
                    System.out.println("You only have $" + wallet);
                } else 
                    validBet = true;
            } catch (Exception ex) {
                System.out.println("Invalid Input!");
            }
        }
        return bet;
    }
}
