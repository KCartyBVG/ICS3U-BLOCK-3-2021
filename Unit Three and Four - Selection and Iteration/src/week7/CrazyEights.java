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

        int userPoints = 0, c1Points = 0, c2Points = 0; // (player points after each round)
        // playRound: return "0-34-23". seperate the points between dashes

        while (!gameOver(userPoints, c1Points, c2Points)) { // seperating the points for each player
            String result = playRound(in, userPoints, c1Points, c2Points); 
            int firstDash = result.indexOf("-");
            int secondDash = result.indexOf("-", firstDash + 1);
            userPoints += Integer.parseInt(result.substring(0, firstDash));
            c1Points += Integer.parseInt(result.substring(firstDash + 1, secondDash));
            c2Points += Integer.parseInt(result.substring(secondDash + 1));

            
        }
        System.out.println("---------------------------------");
        if (userPoints < c1Points && userPoints < c2Points) {
            System.out.println("Player wins with " + userPoints + " points!!!");
            System.out.println("Computer 1 points: " + c1Points);
            System.out.println("Computer 2 points: " + c2Points);
        } else if (c1Points < userPoints && c1Points < c2Points) {
            System.out.println("Computer 1 wins with " + c1Points + " points!!!");
            System.out.println("Player points: " + userPoints);
            System.out.println("Computer 2 points:" + c2Points);
        } else if (c2Points < userPoints && c2Points < c1Points) {
            System.out.println("Computer 2 wins with " + c2Points + " points!!!");
            System.out.println("Player points: " + userPoints);
            System.out.println("Computer 1 points: " + c1Points);
        } else if (c2Points == userPoints && c2Points < c1Points) {
            System.out.println("Player and Computer 2 are tied with " + c2Points + "points!!!");
            System.out.println("Computer 1 points: " + c1Points);
        } else if (c1Points == userPoints && c1Points < c2Points) {
            System.out.println("Player and Computer 1 are tied with " + c1Points + "points!!!");
            System.out.println("Computer 2 points: " + c2Points);
        } else if (c2Points == c1Points && c2Points < userPoints) {
            System.out.println("Computer 1 and Computer 2 are tied with " + c2Points + "points!!!");
            System.out.println("Player points: " + userPoints);
        } else if (c2Points == c1Points && c2Points == userPoints) {
            System.out.println("All players tie with " + userPoints + "points!!!");
        }
        System.out.println("---------------------------------");


    }

    private static boolean gameOver(int p1Points, int c1Points, int c2Points) { // rounds continue until one player reaches 100 points
        return p1Points >= 100 || c1Points >= 100 || c2Points >= 100;
    }

    private static String playRound(Scanner in, int userPoints, int c1Points, int c2Points) { //playRound(in, userPoints, c1Points, c2Points
        String userHand = "";
        String c1Hand = "";
        String c2Hand = "";

        // for loop (5 times) - hand each player one card

        for (int i = 0; i < 5; i++) {
            userHand += getCard() + " ";
            c1Hand += getCard() + " ";
            c2Hand += getCard() + " ";
        }
        userHand = userHand.trim();
        c1Hand = c1Hand.trim();
        c2Hand = c2Hand.trim();


        String topCard = getCard();
        boolean eight = true;

        while (eight) { // making sure the first top card in a round isn't an 8
            if (topCard.indexOf("8") > 0) {
                topCard = getCard();
            } else
                eight = false;
        }

        boolean keepPlaying = true;

        while (keepPlaying) {
            System.out.println("---------------------------------");
            String temp = processPlayer(userHand, topCard, in);
            userHand = temp.substring(0, temp.indexOf("-"));
            topCard = temp.substring(temp.indexOf("-") + 1);
            
            temp = processComputer(c1Hand, topCard);
            c1Hand = temp.substring(0, temp.indexOf("-"));
            System.out.println("c1 hand: " + c1Hand); 

            topCard = temp.substring(temp.indexOf("-") + 1);
            temp = processComputer(c2Hand, topCard);
            c2Hand = temp.substring(0, temp.indexOf("-"));
            System.out.println("c2 hand: " + c2Hand); 

            topCard = temp.substring(temp.indexOf("-") + 1);
            if (userHand.equals("") || c1Hand.equals("") || c2Hand.equals("")) {
                keepPlaying = false;
            }
        }

        // calculate points for each player

        userPoints += countPoints(userHand);
        c1Points += countPoints(c1Hand);
        c2Points += countPoints(c2Hand);
        

        System.out.println("---------------------------------");
        System.out.println("Current Scores: ");
        System.out.println("Player points: " + userPoints);
        System.out.println("Computer 1 points: " + c1Points);
        System.out.println("Computer 2 points: " + c2Points);
        String result = userPoints + "-" + c1Points + "-" + c2Points;

        return result;

    }

    private static int countPoints(String hand) {
        int points = 0;
        for (int i = 0; i <= hand.length() - 1; i++) {
            String letter = hand.substring(i, i + 1);
            if (letter.equals("A")) {
                points += 1;
            } else if (letter.equals("8")) {
                points += 50;
            } else if (letter.equals("J")) {
                points += 10;
            } else if (letter.equals("Q")) {
                points += 10;
            } else if (letter.equals("K")) {
                points += 10;
            } else if (letter.equals("2")) {
                points += 2;
            } else if (letter.equals("3")) {
                points += 3;
            } else if (letter.equals("4")) {
                points += 4;
            } else if (letter.equals("5")) {
                points += 5;
            } else if (letter.equals("6")) {
                points += 6;
            } else if (letter.equals("7")) {
                points += 7;
            } else if (letter.equals("9")) {
                points += 9;
            } else if (letter.equals("1")) {
                points += 10;
            }
        }

        return points;
    }

    private static String processComputer(String cHand, String topCard) {
        boolean play = true;
        String result = "";
        String topSuit = topCard.substring(topCard.length() - 1); // 6H
        String topNumber = topCard.substring(0, topCard.length() - 1);

        while (play) {

            String suitCard = "";
            String numCard = "";
            if (cHand.indexOf(topSuit) >= 0) {  // if suit is found in string, make substring for that card, check that its not
                if (cHand.length() ==2 || !((cHand.substring(cHand.indexOf(topSuit)-1, cHand.indexOf(topSuit)).equals("0")))){ // NOT 10- OR its the last card and the lenght of the card is 2
                    suitCard = cHand.substring(cHand.indexOf(topSuit) - 1, cHand.indexOf(topSuit) + 1);
                }else{
                    suitCard = cHand.substring(cHand.indexOf(topSuit) - 2, cHand.indexOf(topSuit) + 1);
                    suitCard = suitCard.trim();
                }
            }
            if (cHand.indexOf(topNumber) >= 0) { // if top number is found in hand
                numCard = cHand.substring(cHand.indexOf(topNumber), cHand.indexOf(topNumber) + 2);
            }
            int pickedUp = 0;
            if (canPlay(topCard, cHand)) {
                if (cHand.indexOf(topSuit) >= 0 && suitCard.indexOf("8") < 0) { // if top suit is found and its not an 8
                    cHand = cHand.substring(0, cHand.indexOf(suitCard)).trim() + " " + cHand.substring(cHand.indexOf(suitCard) + suitCard.length()).trim();
                    result = cHand.trim() + "-" + suitCard;
                    play = false;
                } else if (cHand.indexOf(topNumber) >= 0 && numCard.indexOf("8") < 0) { // if no top suit, chack for top number (still not 8)
                    cHand = cHand.substring(0, cHand.indexOf(numCard)).trim() + " "
                            + cHand.substring(cHand.indexOf(numCard) + numCard.length()).trim();
                    result = cHand.trim() + "-" + numCard;
                    play = false;
                } else if (cHand.indexOf("8") >= 0) { // if rule 1 and 2 is false BUT they have an eight, they can play it and change to a suit they have
                    String eightCard = cHand.substring(cHand.indexOf("8"), cHand.indexOf("8") + 2);
                    
                    cHand = cHand.substring(0, cHand.indexOf(eightCard)).trim() + " " + cHand.substring(cHand.indexOf(eightCard) + 2).trim();
                    String suit = eightCard.substring(1);
                    if (cHand.indexOf(suit) >= 0) {
                        result = cHand.trim() + "-" + eightCard;
                    } else if (cHand.length() > 3) { // find first card in hand (seperate by " "), seperate the number and the suit (use the first suit for new suit)
                        int space = cHand.indexOf(" ");
                        String firstCard = cHand.substring(0, space);
                        String firstSuit = firstCard.substring(firstCard.length() - 1); 
                        result = cHand.trim() + "-" + firstCard.replace(firstSuit, suit);
                    } else { // if they have an eight, and its the last card left
                        result = "-" + eightCard;
                    }
                    play = false;
                } 
            }

            // IF SUIT AND NUMBER ISNT FOUND -> pick up a card and repeat
            if (!canPlay(topCard, cHand)) {
                cHand += " " + getCard();
                pickedUp++;
                if (pickedUp >= 5) {
                    result = cHand.trim() + "-" + topCard;
                    play = false;
                }
            }

        }
        return result;
    }

    private static String processPlayer(String hand, String topCard, Scanner in) {
        System.out.println("Your Hand: " + hand);
        System.out.println("Top Card: " + topCard);
        System.out.println("---------------------------------");

        String result = "";
        int pickedUp = 0;
        boolean caPlay = false;
     

        while (!caPlay) {

            if (canPlay(topCard, hand)) { 

                String temp = playCard(in, hand);
                if (temp.indexOf("8") >= 0) { // if the new card has an eight in it
                int dash = temp.indexOf("-"); 
                String newCard = temp.substring(dash+1);
                String playedCard = temp.substring(0,dash);

                    if (hand.indexOf(playedCard) == (hand.length()- 2) || hand.indexOf(playedCard) == (hand.length()- 1)) {
                        hand = hand.substring(0, hand.indexOf(playedCard)).trim();
                    } else {
                        hand = hand.substring(0, hand.indexOf(playedCard)).trim() + " " + hand.substring(hand.indexOf(playedCard) + playedCard.length()).trim();
                        hand = hand.trim();
                    }
                    result = hand.trim() + "-" + newCard;
                } else { // if the card has anything but an 8
                    if (hand.indexOf(temp) == (hand.length()- 2) || hand.indexOf(temp) == (hand.length()- 1)) {
                        hand = hand.substring(0, hand.indexOf(temp)).trim();
                    } else {
                        hand = hand.substring(0, hand.indexOf(temp)).trim() + " " + hand.substring(hand.indexOf(temp) + temp.length()).trim();
                        hand = hand.trim();
                    }
                    result = hand.trim() + "-" + temp;
                }

                
                caPlay = true;
            } else if (!canPlay(topCard, hand)) { // IF CANT PLAY AT ALL PICK UP CARDS
                
                System.out.println("You can't play. Pick up a card.");
                hand += " " + getCard();// give player a new card and display their new hand
                System.out.println("Your new hand: " + hand);
                System.out.println("---------------------------------");
                pickedUp++;
                if (pickedUp >= 5) { // if they've picked up 5 cards
                    System.out.println("You can't pick up anymore cards.");
                    caPlay = true;
                    result = hand + "-" + topCard;
                }
            } 
        }

        return result;
    }

    private static boolean canPlay(String topCard, String hand) {
        String suit = topCard.substring(topCard.length() - 1);
        String face = topCard.substring(0, topCard.length() - 1);

        boolean play = false;
        if (hand.indexOf("8") >= 0 || hand.indexOf(suit) >= 0 || hand.indexOf(face) >= 0) { // if suit/face/8 is found in hand
            play = true;
        }
        return play;
    }

    private static String playCard(Scanner in, String playerHand) {
        final String VALID_CARDS = "AS2S3S4S5S6S7S8S9S10SJSQSKSAC2C3C4C5C6C7C8C9C10CJCQCKCAD2D3D4D5D6D7D8D9D10DJDQDKDAH2H3H4H5H6H7H8H9H10HJHQHKH";
        boolean validInput = false;
        String card = "";
        String result = "";
        while (!validInput) {
            System.out.print("What would you like to play? (ex. KD): ");
            card = in.nextLine().toUpperCase();
            if (VALID_CARDS.indexOf(card) < 0) // if card isn't a valid card
                System.out.println("Not a valid card: " + card);
            else if (playerHand.indexOf(card) < 0) // if card isnt found in the player's hand
                System.out.println("You don't have a " + card);
            else if (card.indexOf(" ") >= 0)     // if " " is found "you can only play 1 card"
                System.out.println("You can only choose 1 card.");
            else if ((playerHand.indexOf(card) >= 0)) {
                validInput = true;
                result = card;
            }
            if (card.indexOf("8") >= 0) {
                // CHANGE SUIT - ask what suit to change it too, change the suit of the card
                boolean valid = false;
                while (!valid) {
                    System.out.print("What would you like to change the suit to? (Ex. D, S, C, H): ");
                    String newSuit = in.nextLine().toUpperCase();
                    if (!(newSuit.equals("D") || newSuit.equals("S") || newSuit.equals("C") || newSuit.equals("H"))) {
                        System.out.print("Not a valid suit. Please chose D, S, C or H. ");
                    } else {
                        String oldSuit = card.substring(1);
                        String newCard = card.replace(oldSuit, newSuit);  // (replace suit with newSuit)
                        valid = true;
                        result = card + "-" + newCard; //8D-8C
                    }
                }

            }
        }
        return result;

    }

    private static String getCard() { // picking up a card + adding it to hand
        String card = getFace() + getSuit();
        return card;
    }

    private static String getSuit() {
        int suit = (int) (Math.random() * NUM_SUITS);

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

        if (suit >= 2 && suit <= 10) {
            return suit + "";
        } else if (suit == 1)
            return ACE;
        else if (suit == 11)
            return JACK;
        else if (suit == 12)
            return QUEEN;
        else
            return KING;
    }
}
