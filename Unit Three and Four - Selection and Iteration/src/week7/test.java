package week7;

import java.util.Scanner;

public class test {
    public static void main(String[] args) {
       String cHand = "6D 3D";
       String card = "6D";
       Scanner in = new Scanner(System.in);
       
        //Hand = Hand.substring(0, Hand.indexOf(playedCard)) + Hand.substring(Hand.indexOf(playedCard) + playedCard.length());
        //System.out.println(Hand);

        String topCard = "6D";
        String suit = topCard.substring(topCard.length() - 1);

        //System.out.println(suit);

        

        cHand = cHand.substring(0, cHand.indexOf(card)).trim() + " " + cHand.substring(cHand.indexOf(card) + card.length()).trim();

        //System.out.println(cHand.trim());

        String more = "ABCDEFG";
        String alpha = more.substring(0,2);
        //System.out.println(alpha);



        //String playedCard = "10H";
       // hand = hand.substring(0, hand.indexOf(playedCard)).trim() + " " + hand.substring(hand.indexOf(playedCard) + playedCard.length()).trim();
      /* if (hand.indexOf(playedCard) == (hand.length()- 2) || hand.indexOf(playedCard) == (hand.length()- 1)) {
            hand = hand.substring(0, hand.indexOf(playedCard)).trim();
        } else {
            hand = hand.substring(0, hand.indexOf(playedCard)).trim() + " " + hand.substring(hand.indexOf(playedCard) + playedCard.length()).trim();
            hand = hand.trim();
        }*/

        //System.out.println(hand);


        //System.out.println(countPoints(hand));

        String hand = "9C 5D AH KS 8D 10H";


        String result = "";
       
            //if (hand.indexOf(playedCard) == (hand.length()- 2) || hand.indexOf(playedCard) == (hand.length()- 1)) {
                hand = hand.substring(0, 1);
            /*} else {
                hand = hand.substring(0, index).trim() + " " + hand.substring(index + playedCard.length()).trim();
                hand = hand.trim();
            }*/

         String temp = playCard(in, hand);
          if (temp.indexOf("8") >= 0) {
            int dash = temp.indexOf("-");
            String newCard = temp.substring(dash);
            String playedCard = temp.substring(0,dash);
              if (hand.indexOf(playedCard) == (hand.length()- 2) || hand.indexOf(playedCard) == (hand.length()- 1)) {
                        hand = hand.substring(0, hand.indexOf(playedCard)).trim();
                    } else {
                        hand = hand.substring(0, hand.indexOf(playedCard)).trim() + " " + hand.substring(hand.indexOf(playedCard) + playedCard.length()).trim();
                        hand = hand.trim();
                    }
                    result = hand.trim() + "-" + newCard;
                } else {
                    if (hand.indexOf(temp) == (hand.length()- 2) || hand.indexOf(temp) == (hand.length()- 1)) {
                        hand = hand.substring(0, hand.indexOf(temp)).trim();
                    } else {
                        hand = hand.substring(0, hand.indexOf(temp)).trim() + " " + hand.substring(hand.indexOf(temp) + temp.length()).trim();
                        hand = hand.trim();
                    }
                    result = hand.trim() + "-" + temp;
                }
        System.out.println(result);
        
    }
    private static int countPoints(String hand) {

        // 7H 8C 3D KS
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

    private static String playCard(Scanner in, String playerHand) {
        final String VALID_CARDS = "AS2S3S4S5S6S7S8S9S10SJSQSKSAC2C3C4C5C6C7C8C9C10CJCQCKCAD2D3D4D5D6D7D8D9D10DJDQDKDAH2H3H4H5H6H7H8H9H10HJHQHKH";
        boolean validInput = false;
        String card = "";
        String result = "";
        while (!validInput) {
            System.out.print("What would you like to play? (ex. KD): ");
            card = in.nextLine().toUpperCase();
            // if " " is found "you can only play 1 card"
            if (VALID_CARDS.indexOf(card) < 0)
                System.out.println("Not a valid card: " + card);
            else if (playerHand.indexOf(card) < 0)
                System.out.println("You don't have a " + card);
            else if ((playerHand.indexOf(card) >= 0)) {
                validInput = true;
                result = card;
            }
            if (card.indexOf("8") >= 0) {
                // CHANGE SUIT - ask what suit to change it too, change the suit of the card
                // (replace suit with newSuit)
                boolean valid = false;
                while (!valid) {
                    System.out.print("What would you like to change the suit to? (Ex. D, S, C, H): ");
                    String newSuit = in.nextLine().toUpperCase();
                    if (!(newSuit.equals("D") || newSuit.equals("S") || newSuit.equals("C") || newSuit.equals("H"))) {
                        System.out.print("Not a valid suit. Please chose D, S, C or H. ");
                    } else {
                        String oldSuit = card.substring(1);
                        String newCard = card.replace(oldSuit, newSuit);
                        valid = true;
                        result = card + "-" + newCard; //8D-8C
                    }
                }

            }
        }
        return result;

    }


}
