import java.util.ArrayList;
import java.util.Collections;
import java.io.Serializable;

public class Deck implements Serializable { // implements save and load into all java classes
    private static Deck instance; // Singleton instance
    private ArrayList<Card> deck;

    public Deck() { // add cards
        this.deck = new ArrayList<>();
        for (CardValue value : CardValue.values()) {
            for (int j = 0; j < 4; j++) {
                Card card = new Card(value, value);
                if (!deck.contains(card)) {
                    this.deck.add(card);
                }
            }
        }
        Collections.shuffle(deck);
    }

    public static Deck getInstance() { // its for save and load
        if (instance == null) {
            instance = new Deck();
        }
        return instance;
    }

    public String toString() {
        return "Deck    : " + deck;
    }

    public Card getCard(int i) {
        return deck.get(i);
    }

    public void removeCard(int i) {
        deck.remove(i);
    }

    public int getDeckSize() {
        return deck.size();
    }

    public static void setInstance(Deck deckInstance) {
        instance = deckInstance;
    }
}