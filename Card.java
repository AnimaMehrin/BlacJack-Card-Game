/**
 * Card class represents a playing card from a deck. A card has a color and a
 * value
 */

public class Card {

    private final int color; // Card's color
    private final int value; // Card's value (1 - 13, with 1 representing ACE).

    /***
     * Codes for the colors and non-numeric cards. Cards 2 through 10 have their
     * numerical values for their codes.
     */

    public final static int CLUBS = 0;
    public final static int DIAMONDS = 1;
    public final static int HEARTS = 2;
    public final static int SPADES = 3;

    public final static int ACE = 1;
    public final static int JACK = 11;
    public final static int QUEEN = 12;
    public final static int KING = 13;

    /**
     * Constrcutor, that creates a card with a specified color and value.
     * 
     * @throws IllegalArgumentException if the parameter values are not in the
     *                                  ranges
     */
    public Card(int value, int color) {
        if (color < 0 || color > 3) {
            throw new IllegalArgumentException("Illegal playing card color");
        }
        if (value < 1 || value > 13) {
            throw new IllegalArgumentException("Illegal playing card value");
        }
        this.value = value;
        this.color = color;
    }

    /**
     * Returns the color of this card.
     */
    public int getColor() {
        return color;
    }

    /**
     * Returns the value of this card.
     * 
     * @return the value, which is one of the numbers 1 through 13, inclusive for
     *         a regular card.
     */
    public int getValue() {
        return value;
    }

    /**
     * Returns a String representation of the card's color.
     * 
     * @return one of the strings "Spades", "Hearts", "Diamonds", or "Clubs"
     */
    public String ColorToString() {
        return switch (color) {
            case 0 -> "Clubs";
            case 1 -> "Diamonds";
            case 2 -> "Hearts";
            case 3 -> "Spades";
            default -> "Invalid color";
        };
    }

    /**
     * Returns a String representation of the card's value.
     * 
     * @return for a regular card, one of the strings "Ace", "2",
     *         "3", ..., "10", "Jack", "Queen", or "King".
     */
    public String ValueToString() {

        return switch (value) {
            case 1 -> "Ace";
            case 2 -> "2";
            case 3 -> "3";
            case 4 -> "4";
            case 5 -> "5";
            case 6 -> "6";
            case 7 -> "7";
            case 8 -> "8";
            case 9 -> "9";
            case 10 -> "10";
            case 11 -> "Jack";
            case 12 -> "Queen";
            case 13 -> "King";
            default -> "Invalid value";
        };
    }

    /**
     * Returns a string representation of this card, including both
     * its color and its value. Sample return values is: "Ace of Diamonds",
     */
    public String toString() {
        return ValueToString() + " of " + ColorToString();
    }

} // end class Card
