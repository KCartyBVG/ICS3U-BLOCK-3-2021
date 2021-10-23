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
        
        //loop for each turn?
        // method to call turns?
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
        //7H 8C 3D-6D
        String result = "";
        
        //if suit is found in string, make substring for that card, check that its not eight, take out of hand
        String suitCard = cHand.substring(cHand.indexOf(topSuit)-1, cHand.indexOf(topSuit)+1); // MIGHT NOT WORK IF THERE IS NO SUIT IN THE HAND
        String numCard = cHand.substring(cHand.indexOf(topNumber), cHand.indexOf(topNumber)+2);

        if (cHand.indexOf(topSuit) >= 0 && suitCard.indexOf("8") < 0){
            cHand = cHand.substring(0, cHand.indexOf(suitCard)).trim() + " " + cHand.substring(cHand.indexOf(suitCard) + suitCard.length()).trim();
            result = cHand.trim() + "-" + suitCard;
        }else if (cHand.indexOf(topNumber) >= 0 && numCard.indexOf("8") <0 ){        //IF NOT SUIT -> if number is found in string, make substring for that card, check its not an eight, take out of hand
            cHand = cHand.substring(0, cHand.indexOf(numCard)).trim() + " " + cHand.substring(cHand.indexOf(numCard) + numCard.length()).trim();
            result = cHand.trim() + "-" + numCard;
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
        } else {         // IF SUIT AND NUMBER ISNT FOUND -> pick up a card and repeat
            cHand += getCard() + " ";

        }


        // IF SUIT AND NUMBER ISNT FOUND -> pick up a card and repeat
        //add picked up cards to hand, int cards picked up (if cardsPickedUp <= 5, the loop will repeat)
        // IF PICKED UP FIVE CARDS -> end of turn 


        // return remaining hand, "-", playedCard
        return result;
    }

    private static String processPlayer(String hand, String topCard, Scanner in) {
        System.out.println("Top Card: " + topCard);
        System.out.println("Your Hand: " + hand);
        System.out.println("Can you play?");
        
        //IF NO PICK UP CARDS (look at processComputer for instructions)
        // make boolean for (canPlay) - ask if they can play
        // if answer is yes - canPlay = true, etc. 

        //if yes ADD THE FOLLOWING TO AN IF STATEMENT (below comments)
        //IF NO PICK UP CARDS (look at processComputer for instructions)


        // after everytime they picked up a card change boolean

        // make playedCard same as topCard before the if statment - if player picked up 5 cards and didnt put down a new card, playedCard is the same

        // if user enters invalid options : check other games and copy 
        System.out.println("What would you like to play? ");
        String playedCard = in.nextLine();
        // "7H 8C 6D 3D"
        hand = hand.substring(0, hand.indexOf(playedCard)).trim() + " " + hand.substring(hand.indexOf(playedCard) + playedCard.length()).trim();
        
        return hand.trim() + "-" + playedCard;
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

   