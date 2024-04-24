import java.io.Serializable; //for save and load, to read output then save 
import java.util.ArrayList;

public class Player implements Serializable { // player class where we can create the instances of players
    private String playerName;
    private ArrayList<Card> handOfPlayer;
    private Card playedCard;
    private int score;

    public Player(String playerName) {
        this.playerName = playerName; ///
        this.handOfPlayer = new ArrayList<>(); /// //this will initialize players hand variable with an empty array
    } /// the players hand is now an array that is empty

    public void addCard(Card card) {
        handOfPlayer.add(card); /// this will add cards into the players hand array
    }

    // Other methods for the Player class
    @Override
    public String toString() {
        return playerName + ": " + handOfPlayer; // the toString method
    }

    public boolean hasCards() { //check player hand empty
        return !handOfPlayer.isEmpty();
    }

    public String getPlayerName() { //player name method
        return playerName;
    }

    public String drawCard(ArrayList<Card> centerArray, Deck deck) {  //draw Card from the deck and remove the same card from that deck
        if (deck.getDeckSize() > 0) {
            Card card = deck.getCard(0);
            deck.removeCard(0);
            handOfPlayer.add(card);
            return "success";
        } else {
            return "error";
        }
    }

    public boolean playCard(String userInput, ArrayList<Card> centerArray) { //make sure in the shuffled deck there is no repeating 
        if (!handOfPlayer.isEmpty()) {
            for (int i = 0; i < handOfPlayer.size(); i++) {
                Card card = handOfPlayer.get(i);
                if (card.toString().equals(userInput)) {
                    handOfPlayer.remove(i);
                    playedCard = card;
                    centerArray.add(card);
                    return true;
                }
            }
        }
        return false;
    }

    public void setScore(int score) { // constructor
        this.score = score;
    }

    public void addScore(Card card) { //add score method
        int currentPlayerScore = card.getValue().getCardValue();
        score += currentPlayerScore;
    }

    public Card getPlayedCard() { //get played card
        return playedCard;
    }

    public int getScore() { //get score
        return score;
    }
}