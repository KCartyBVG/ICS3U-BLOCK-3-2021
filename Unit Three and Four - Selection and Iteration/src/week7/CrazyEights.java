package week7;

import java.util.Scanner;

public class CrazyEights {
    private static final int NUM_SUITS = 4;
    private static final String HEARTS = "H";
    private static final String DIAMONDS = "D";
    private static final String CLUBS = "C";
    private static final String SPADES = "S";
    private static final double CARDS_PER_SUIT = 13;
    private static final String ACE = "A";
    private static final String JACK = "J";
    private static final String QUEEN = "Q";
    private static final String KING = "K";
    public static void main(String[] args) {
        
        boolean gameOver = false;
        Scanner in = new Scanner(System.in);

        int p1Points = 0, c1Points = 0, c2Points = 0; //(player points after each round)
            // playRound: return "0-34-23". seperate the points between dashes
        
        while (!gameOver(p1Points, c1Points, c2Points)) { // (gameOver is method that retuns true/false)
            String result = playRound(in); //return "37-0-12"
            int firstDash = result.indexOf("-");
            int secondDash = result.indexOf("-", firstDash + 1);
            p1Points += Integer.parseInt(result.substring(0,firstDash));
            c1Points += Integer.parseInt(result.substring(firstDash+1,secondDash));
            c2Points += Integer.parseInt(result.substring(secondDash+1));
             
            System.out.println("Current Score: "+ p1Points + " " + c1Points + " " + c2Points);
            

            

                        
       }
      
    }

    private static boolean gameOver(int p1Points, int c1Points, int c2Points) {
        return p1Points >= 100 || c1Points >=100 || c2Points >=100;
    }

    private static String playRound(Scanner in) {
        String userHand = "";
        String c1Hand = "";
        String c2Hand = "";

        // for loop (5 times) - hand each player one card
        
        for (int i =0; i <5; i++) {
            userHand += getCard() + " ";
            c1Hand += getCard() + " ";
            c2Hand += getCard() + " ";
        }
        
        System.out.println(userHand);
        System.out.println(c1Hand);
        System.out.println(c2Hand);

        
        String topCard = getCard();
        boolean eight = true;
        
         while (eight){
              if (topCard.indexOf("8") > 0) {
                topCard = getCard();
            }else 
                eight = false;
        }
        
        
        boolean keepPlaying = true;

        while (keepPlaying) {
            String temp = processPlayer(userHand, topCard, in);//returns string
            userHand = temp.substring(0, temp.indexOf("-"));
            topCard = temp.substring(temp.indexOf("-") + 1);
            temp = processComputer(c1Hand, topCard);// return "7H 8C 3D-6D" (after dash is the new playedCard) 
            c1Hand = temp.substring(0, temp.indexOf("-"));
            topCard = temp.substring(temp.indexOf("-") + 1);
            temp = processComputer(c2Hand, topCard);
            c2Hand = temp.substring(0, temp.indexOf("-"));
            topCard = temp.substring(temp.indexOf("-") + 1);
            if (userHand.equals("") || c1Hand.equals("") || c2Hand.equals("")){
                keepPlaying = false;
            }
        }

        // at the end of the round count all points
        // make method to caluclate points for each player's hand, return int - ex. count amount of times "K" is found (playpoints += 10 points)
    }

    

    private static String processComputer(String cHand, String topCard) {
        String topSuit = topCard.substring(topCard.length() - 2);
        String topNumber = topCard.substring(0, topCard.length()-1);
        boolean play = true;
        //7H 8C 3D-6D
        String result = "";
        
        //if suit is found in string, make substring for that card, check that its not eight, take out of hand
        String suitCard = cHand.substring(cHand.indexOf(topSuit)-1, cHand.indexOf(topSuit)+1); // MIGHT NOT WORK IF THERE IS NO SUIT IN THE HAND
        String numCard = cHand.substring(cHand.indexOf(topNumber), cHand.indexOf(topNumber)+2);
        int pickedUp = 0;


        while (play){
            if (cHand.indexOf(topSuit) >= 0 && suitCard.indexOf("8") < 0){
                cHand = cHand.substring(0, cHand.indexOf(suitCard)).trim() + " " + cHand.substring(cHand.indexOf(suitCard) + suitCard.length()).trim();
                result = cHand.trim() + "-" + suitCard;
                play = false;
            }else if (cHand.indexOf(topNumber) >= 0 && numCard.indexOf("8") <0 ){        //IF NOT SUIT -> if number is found in string, make substring for that card, check its not an eight, take out of hand
                cHand = cHand.substring(0, cHand.indexOf(numCard)).trim() + " " + cHand.substring(cHand.indexOf(numCard) + numCard.length()).trim();
                result = cHand.trim() + "-" + numCard;
                play = false;
            } else if (cHand.indexOf(topSuit) >= 0) {         // if rule 1 and 2 is false BUT they have an eight, they can play it and change to a suit they have 
                cHand = cHand.substring(0, cHand.indexOf(suitCard)).trim() + " " + cHand.substring(cHand.indexOf(suitCard) + suitCard.length()).trim();
                String suit = suitCard.substring(suitCard.length()-2);
                if (cHand.indexOf(suit) >= 0) {
                    result = cHand.trim() + "-" + suitCard;
                } else if (cHand.length()>3){ // find first card in hand (seperate by " "), seperate the number and the suit
                    int space = cHand.indexOf(" ");
                    String firstCard = cHand.substring(0, space);
                    String firstSuit = firstCard.substring(firstCard.length()-2);
                    String firstNum = suitCard.substring(0, suitCard.length()-2);
                    result = cHand.trim() + "-" + firstNum + suit;
                }else {     //if they have an eight, and its the last card left
                    result = "-" + suitCard;
                }
                play = false;
            } else if (cHand.indexOf(numCard) >=0 && numCard.indexOf("8") >=0){
                cHand = cHand.substring(0, cHand.indexOf(numCard)).trim() + " " + cHand.substring(cHand.indexOf(numCard) + numCard.length()).trim();
                String suit = numCard.substring(numCard.length()-2);
                if (cHand.indexOf(suit) >= 0) {
                    result = cHand.trim() + "-" + numCard;
                } else if (cHand.length()>3){ // find first card in hand (seperate by " "), seperate the number and the suit
                    int space = cHand.indexOf(" ");
                    String firstCard = cHand.substring(0, space);
                    String firstSuit = firstCard.substring(firstCard.length()-2);
                    String firstNum = numCard.substring(0, numCard.length()-2);
                    result = cHand.trim() + "-" + firstNum + suit;
                }else {     //if they have an eight, and its the last card left
                    result = "-" + numCard;
                }
                play = false;
            } else {         // IF SUIT AND NUMBER ISNT FOUND -> pick up a card and repeat
                cHand += getCard() + " ";
                pickedUp++;
                if (pickedUp >= 5) { 
                    result = cHand + "-" + topCard;
                    play = false;
                }

            }
        }
        return result;
    }

    private static String processPlayer(String hand, String topCard, Scanner in) {
        System.out.println("Top Card: " + topCard);
        System.out.println("Your Hand: " + hand);
        String result = "";
        boolean canPlay = false;
        int pickedUp = 0;
        
        while (!canPlay){
            System.out.println("Can you play? ([Y]es or [N]o)");
            String answer = in.nextLine().toUpperCase();
            if (answer.equals("Yes") || answer.equals("Y")){

                String playedCard = playCard(in, hand);
                
                hand = hand.substring(0, hand.indexOf(playedCard)).trim() + " " + hand.substring(hand.indexOf(playedCard) + playedCard.length()).trim();
                
                result = hand.trim() + "-" + playedCard;
                canPlay = true;
            }else if (answer.equals("No") || answer.equals("N")) {
                hand += getCard();// give player a new card and display their new hand
                System.out.println("Your new hand: " + hand);
                pickedUp++;
                if (pickedUp >= 5) {
                    System.out.println("You can't pick up anymore cards.");
                    canPlay = true; 
                    result = hand + "-" + topCard;
                }
            } else {
                System.out.println("Invalid Input: [Y]es or [N]o only!");
            }
        }
        
        
        //IF NO PICK UP CARDS (look at processComputer for instructions)
        // make boolean for (canPlay) - ask if they can play
        // if answer is yes - canPlay = true, etc. 

        //if yes ADD THE FOLLOWING TO AN IF STATEMENT (below comments)
        //IF NO PICK UP CARDS (look at processComputer for instructions)
        
        return result;
    }

    private static String playCard(Scanner in, String playerHand) {
        final String VALID_CARDS = "AS2S3S4S5S6S7S8S9S10SJSQSKSAC2C3C4C5C6C7C8C9C10CJCQCKCAD2D3D4D5D6D7D8D9D10DJDQDKDAH2H3H4H5H6H7H8H9H10HJHQHKH";
        boolean validInput = false;
        String card = "";
        while (!validInput) {
           System.out.print("What would you like to play? (ex. KD): ");
           card = in.nextLine().toUpperCase();
           
           if (VALID_CARDS.indexOf(card) < 0) 
              System.out.println("Not a valid card: " + card);
           else if (playerHand.indexOf(card) < 0)
              System.out.println("You don't have a " + card);
           else if ((playerHand.indexOf(card) >= 0)) 
              validInput = true;
        }
        return card;
  
     }
    

    private static String getCard() {
        String card = getFace() + getSuit();
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
}

   