
/**
 * Deck represents a deck of playing cards and contains 52 regular cards.
 */
public class Deck {

    private Card[] deck; // an array of 52 cards.
    private int number; // the number of cards that have been dealt from the deck

    /**
     * Constructs a regular 52-card poker deck. Initially, the cards
     * are in a sorted order.
     */
    public Deck() {
        int[] colors = { Card.CLUBS, Card.DIAMONDS, Card.HEARTS, Card.SPADES };
        deck = new Card[52];
        number = 0;
        for (int i = 0; i < 4; i++) {
            for (int j = 1; j <= 13; j++) {
                deck[i * 13 + j - 1] = new Card(j, colors[i]);
            }
        }

    }

    /**
     * Put all the used cards back into the deck (if any), and
     * shuffle the deck into a random order.
     */
    public void shuffle() {
        for (int i = 51; i > 0; i--) {
            int rand = (int) (Math.random() * (i + 1));
            Card temp = deck[i];
            deck[i] = deck[rand];
            deck[rand] = temp;
        }
        number = 0;
    }

    /**
     * Returns the number of cards left in the deck.
     */
    public int numberLeft() {
        return 52 - number;
    }

    /**
     * Removes the next card from the deck and return it. It is illegal
     * to call this method if there are no more cards in the deck. You can
     * check the number of cards remaining by calling the numberLeft() function.
     * 
     * @return the card which is removed from the deck.
     * @throws IllegalStateException if there are no cards left in the deck
     */
    public Card take() {
        if (number == 52) {
            throw new IllegalStateException("No cards are left in the deck.");
        }
        number++;
        return deck[number - 1];
    }
} // end class Deck
