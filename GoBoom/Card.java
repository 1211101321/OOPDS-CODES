import java.util.Objects;
import java.io.Serializable;

public class Card implements Serializable{
    private CardValue suit; //data field
    private CardValue value;

    public Card(CardValue suit, CardValue value) { //constructor
        this.suit = suit;
        this.value = value;
    }

    // Getters, setters, and other methods for the Card class
    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        Card other = (Card) obj;
        return value == other.value;
    } //make sure no repeated cards in the shuffled deck

    @Override
    public int hashCode() {
        return Objects.hash(value);
    }

    @Override
    public String toString() { //to String Method
        return value.toString();
    }

    public CardValue getValue(){ //get card value
        return value;
    }

    public CardValue getSuit(){ //get card suit
        return suit;
    }
}