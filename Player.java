
/**
 *The Player class should be able to represent the set of cards a player has in hand.
 * The player class must allow to take a card from the deck and put it in the hand, 
 * count the points of the cards in hand...
 **/
import java.util.ArrayList;

public class Player {
    private ArrayList<Card> hand; // The cards in the plyaer's hand.

    /* Constructor */
    Player() {
        this.hand = new ArrayList<Card>();
    }

    /* Accessor */
    public ArrayList<Card> getHand() {
        return this.hand;
    }

    /**
     * Remove all cards from the hand, leaving it empty.
     */
    public void clear() {
        for (int i = 0; i < hand.size(); i++) {
            hand.remove(i);
        }
    }

    /**
     * Add a card to the hand. It is added at the end of the current hand.
     * 
     * @param card the non-null card to be added.
     * @throws NullPointerException if the parameter card is null.
     */
    public void add(Card card) {
        if (card == null) {
            throw new NullPointerException("Can't add a null card to a hand.");
        }
        hand.add(card);
    }

    /**
     * Remove a card from the hand, if present.
     * 
     * @param card the card to be removed. If card is null or if the card is not in
     *             the hand, then nothing is done.
     */
    public void remove(Card card) {
        hand.remove(card);
    }

    /**
     * Remove the card in a specified position from the hand.
     * 
     * @param position the position of the card that is to be removed, where
     *                 positions are numbered starting from zero.
     * @throws IllegalArgumentException if the position does not exist in
     *                                  the hand, that is if the position is less
     *                                  than 0 or greater than
     *                                  or equal to the number of cards in the hand.
     */
    public void remove(int position) {
        if (position < 0 || position >= hand.size()) {
            throw new IllegalArgumentException("Position does not exist in hand: " + position);
        }
        hand.remove(position);
    }

    /**
     * Returns the number of cards in the hand.
     */
    public int totalCards() {
        return hand.size();
    }

    /**
     * Gets the card in a specified position in the hand. (Note that this card
     * is not removed from the hand!)
     * 
     * @param position the position of the card that is to be returned
     * @throws IllegalArgumentException if position does not exist in the hand
     */
    public Card getCard(int position) {
        if (position < 0 || position >= hand.size()) {
            throw new IllegalArgumentException("Position does not exist in hand: " + position);
        }
        return hand.get(position);
    }

    /**
     * Computes and returns the total value of this hand in the game
     */
    public int getHandTotal() {

        int totalValue = 0; // The total value of the hand.
        int aces = 0; // The number of aces in the hand.

        // Add up the value of the cards, treating each ace as 1.
        for (int i = 0; i < hand.size(); i++) {
            Card card; // The card being examined.
            int value; // The value of the current card.
            card = hand.get(i);
            value = card.getValue(); // The value of the current card.
            if (value > 10) {
                value = 10; // For a Jack, Queen, or King.
            }
            if (value == 1) {
                aces++; // Add to the number of aces.
            }
            totalValue = totalValue + value;
        }

        // Add an extra 10 points for each ace if there is at least one ace
        // and if this won't cause the total value to go over 21.
        while (aces > 0 && totalValue + 10 <= 21) {
            totalValue = totalValue + 10;
            aces--;
        }

        return totalValue;

    }

    /**
     * Sorts the cards in the hand so that cards of the same color are
     * grouped together, and within a color the cards are sorted by value.
     * Note that aces are considered to have the lowest value, 1.
     */
    public void sortByColor() {
        for (int i = 0; i < hand.size(); i++) {
            int minIndex = i; // Index of smallest card in remaining part of hand.
            for (int j = i + 1; j < hand.size(); j++) {
                Card card1 = hand.get(j);
                Card card2 = hand.get(minIndex);
                if (card1.getColor() < card2.getColor()
                        || (card1.getColor() == card2.getColor() && card1.getValue() < card2.getValue())) {
                    minIndex = j;
                }
            }
            Card temp = hand.get(i);
            hand.set(i, hand.get(minIndex));
            hand.set(minIndex, temp);
        }
    }

    /**
     * Sorts the cards in the hand so that cards of the same value are
     * grouped together. Cards with the same value are sorted by color.
     * Note that aces are considered to have the lowest value, 1.
     */
    public void sortByValue() {
        for (int i = 0; i < hand.size(); i++) {
            int minIndex = i; // Index of smallest card in remaining part of hand.
            for (int j = i + 1; j < hand.size(); j++) {
                Card card1 = hand.get(j);
                Card card2 = hand.get(minIndex);
                if (card1.getValue() < card2.getValue()
                        || (card1.getValue() == card2.getValue() && card1.getColor() < card2.getColor())) {
                    minIndex = j;
                }
            }
            Card temp = hand.get(i);
            hand.set(i, hand.get(minIndex));
            hand.set(minIndex, temp);
        }
    }
}