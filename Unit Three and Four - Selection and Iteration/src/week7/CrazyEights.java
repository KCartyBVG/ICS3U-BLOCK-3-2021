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

        while (!gameOver(userPoints, c1Points, c2Points)) { // (gameOver is method that retuns true/false)
            String result = playRound(in); // return "37-0-12"
            int firstDash = result.indexOf("-");
            int secondDash = result.indexOf("-", firstDash + 1);
            userPoints += Integer.parseInt(result.substring(0, firstDash));
            c1Points += Integer.parseInt(result.substring(firstDash + 1, secondDash));
            c2Points += Integer.parseInt(result.substring(secondDash + 1));

            // calculate points for each player
        }

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
            System.out.println("Computer ");
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

        System.out.println("Current Score: " + userPoints + " " + c1Points + " " + c2Points);
    }

    private static boolean gameOver(int p1Points, int c1Points, int c2Points) {
        return p1Points >= 100 || c1Points >= 100 || c2Points >= 100;
    }

    private static String playRound(Scanner in) {
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

        System.out.println("c1 hand: " + c1Hand);   // CAN DELETE AFTER TESTING
        System.out.println("c2 hand: " + c2Hand);

        String topCard = getCard();
        boolean eight = true;

        while (eight) {
            if (topCard.indexOf("8") > 0) {
                topCard = getCard();
            } else
                eight = false;
        }

       
            boolean keepPlaying = true;

            while (keepPlaying) {
                String temp = processPlayer(userHand, topCard, in);
                userHand = temp.substring(0, temp.indexOf("-"));
                topCard = temp.substring(temp.indexOf("-") + 1);
                System.out.println("Your new hand: " + userHand);
                System.out.println("Top card: " + topCard);
                temp = processComputer(c1Hand, topCard);
                c1Hand = temp.substring(0, temp.indexOf("-"));      // FIND NUMBER OF CARDS IN HAND, PRINT x NUMBER OF Xs
                topCard = temp.substring(temp.indexOf("-") + 1);
                System.out.println("c1 new hand: " + c1Hand);   // CHANGE TO XXXX AFTER TESTING 
                System.out.println("Top card: " + topCard); 
                temp = processComputer(c2Hand, topCard);
                c2Hand = temp.substring(0, temp.indexOf("-"));
                topCard = temp.substring(temp.indexOf("-") + 1);
                System.out.println("c2 new hand: " + c2Hand);   // CHANGE TO XXXX AFTER TESTING 
                if (userHand.equals("") || c1Hand.equals("") || c2Hand.equals("")) {
                    keepPlaying = false;
                }
            }

            // calculate points for each player
            int userPoints = countPoints(userHand);
            int c1Points = countPoints(c1Hand);
            int c2Points = countPoints(c2Hand);

            System.out.println("Current Scores: ");
            System.out.println("Player points:" + userPoints);
            System.out.println("Computer 1 points: " + c1Points);
            System.out.println("Computer 2 points:" + c2Points);
            String result = userPoints + "-" + c1Points + "-" + c2Points;
            
        

        return result;

    }

    private static int countPoints(String hand) {
        // 7H 8C 3D KS
        int points = 0;
        for (int i = 0; i <= hand.length(); i++) {
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
        String topSuit = topCard.substring(topCard.length() - 1);
        String topNumber = topCard.substring(0, topCard.length() - 1);
        boolean play = true;
        // 7H 8C 3D-6D
        String result = "";
        String suitCard = "";
        String numCard = "";

        // if suit is found in string, make substring for that card, check that its not
        // eight, take out of hand
        if (cHand.indexOf(topSuit) >= 0) {
        suitCard = cHand.substring(cHand.indexOf(topSuit) - 1, cHand.indexOf(topSuit) + 1); // MIGHT NOT WORK IF THERE IS NO SUIT IN THE HAND
        }
        if (cHand.indexOf(topNumber) >= 0) {
        numCard = cHand.substring(cHand.indexOf(topNumber), cHand.indexOf(topNumber) + 2);
        }
        int pickedUp = 0;

        while (play) {
            if (cHand.indexOf(topSuit) >= 0 && suitCard.indexOf("8") < 0) {
                cHand = cHand.substring(0, cHand.indexOf(suitCard)).trim() + " "
                        + cHand.substring(cHand.indexOf(suitCard) + suitCard.length()).trim();
                result = cHand.trim() + "-" + suitCard;
                play = false;
            } else if (cHand.indexOf(topNumber) >= 0 && numCard.indexOf("8") < 0) { // IF NOT SUIT -> if number is found in string, make substring for that card, check its not an  eight, take out of hand
                cHand = cHand.substring(0, cHand.indexOf(numCard)).trim() + " " + cHand.substring(cHand.indexOf(numCard) + numCard.length()).trim();
                result = cHand.trim() + "-" + numCard;
                play = false;
            } else if (cHand.indexOf(topSuit) >= 0) { // if rule 1 and 2 is false BUT they have an eight, they can play it and change to a suit they have
                cHand = cHand.substring(0, cHand.indexOf(suitCard)).trim() + " " + cHand.substring(cHand.indexOf(suitCard) + suitCard.length()).trim();
                String suit = suitCard.substring(suitCard.length() - 2);
                if (cHand.indexOf(suit) >= 0) {
                    result = cHand.trim() + "-" + suitCard;
                } else if (cHand.length() > 3) { // find first card in hand (seperate by " "), seperate the number and the suit
                    int space = cHand.indexOf(" ");
                    String firstCard = cHand.substring(0, space);
                    String firstSuit = firstCard.substring(firstCard.length() - 2);
                    String firstNum = suitCard.substring(0, suitCard.length() - 2);
                    result = cHand.trim() + "-" + firstNum + suit;
                } else { // if they have an eight, and its the last card left
                    result = "-" + suitCard;
                }
                play = false;
            } else if (cHand.indexOf(numCard) >= 0 && numCard.indexOf("8") >= 0) {
                cHand = cHand.substring(0, cHand.indexOf(numCard)).trim() + " " + cHand.substring(cHand.indexOf(numCard) + numCard.length()).trim();
                String suit = numCard.substring(numCard.length() - 2);
                if (cHand.indexOf(suit) >= 0) {
                    result = cHand.trim() + "-" + numCard;
                } else if (cHand.length() > 3) { // find first card in hand (seperate by " "), seperate the number and the suit
                    int space = cHand.indexOf(" ");
                    String firstCard = cHand.substring(0, space);
                    String firstSuit = firstCard.substring(firstCard.length() - 2);
                    String firstNum = numCard.substring(0, numCard.length() - 2);
                    result = cHand.trim() + "-" + firstNum + suit;
                } else { // if they have an eight, and its the last card left
                    result = "-" + numCard;
                }
                play = false;
            } else { // IF SUIT AND NUMBER ISNT FOUND -> pick up a card and repeat
                cHand += getCard() + " ";
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
        System.out.println("Top Card: " + topCard);
        System.out.println("Your Hand: " + hand);
        String result = "";
        int pickedUp = 0;
        boolean caPlay = false;
        //canPlay(topCard, hand);

        while (!caPlay) {
            
            if (canPlay(topCard, hand)) {

                String playedCard = playCard(in, hand);

                hand = hand.substring(0, hand.indexOf(playedCard)).trim() + " " + hand.substring(hand.indexOf(playedCard) + playedCard.length()).trim();

                result = hand.trim() + "-" + playedCard;
                caPlay = true;
            } else if (!canPlay(topCard, hand)) { // IF NO PICK UP CARDS
                System.out.println("You can't play. Pick up a card.");
                hand += " " + getCard();// give player a new card and display their new hand
                System.out.println("Your new hand: " + hand);
                pickedUp++;
                if (pickedUp >= 5) {
                    System.out.println("You can't pick up anymore cards.");
                    caPlay = true;
                    result = hand + "-" + topCard;
                }
            } else {
                System.out.println("Invalid Input: [Y]es or [N]o only!");
            }
        }

        return result;
    }

    private static boolean canPlay(String topCard, String hand) {
        String suit = topCard.substring(topCard.length() - 2);
        String face = topCard.substring(0, topCard.length() - 1);

        boolean play = false;
        if (hand.indexOf("8") >= 0 || hand.indexOf(suit) >= 0 || hand.indexOf(face) >= 0) {
            play = true;
        }
        return play;
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
