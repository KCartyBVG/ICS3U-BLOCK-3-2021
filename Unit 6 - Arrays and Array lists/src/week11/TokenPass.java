package week11;

public class TokenPass {
    private int [] tokens;
    private int currentPlayer;

    public TokenPass(int playerCount){
        tokens = new int[playerCount];
        currentPlayer = (int) (Math.random()*playerCount);

        for (int i = 0; i < tokens.length; i++) {
            tokens[i] = (int) (Math.random() * 10) +1;
        }
    }

    public void distributeCurrentPlayerTokens() {
        int tokensLeft = tokens[currentPlayer]; // store amount of tokens to distribute
        tokens[currentPlayer] = 0; //take tokens away
        int nextPlayer = currentPlayer+1; // distribute to next player

        while (tokensLeft > 0){ // while theres more tokens to distribute
            if (nextPlayer == tokens.length){ // check if the next player is outside of the board(outside the array)
                nextPlayer = 0;
            }

            tokens[nextPlayer]++;
            tokensLeft--; // take token away from distributing
            nextPlayer++; // go to next player
        }
        

    }
}
