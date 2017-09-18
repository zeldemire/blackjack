package edu.miami.cse.agents.blackjack;

import java.util.ArrayList;


/**
 * A hand (the cards) of a Blackjack player or dealer 
 */

public class Hand {
    private ArrayList<Card> cards;

    /**
     * Creates a new empty card list.
     */
    public Hand() {
        cards = new ArrayList<Card>();
    }

    /**
     * Add a card to the card list.
     */

    public void add(Card card) {
        cards.add(card);
    }

    /**
     * Get top card
     */

    public int getTop() {
        int value = 0;
        switch (cards.get(0).getRank()) {
            case ACE:
                value = 11;
                break;
            case TWO:
                value = 2;
                break;
            case THREE:
                value = 3;
                break;
            case FOUR:
                value = 4;
                break;
            case FIVE:
                value = 5;
                break;
            case SIX:
                value = 6;
                break;
            case SEVEN:
                value = 7;
                break;
            case EIGHT:
                value = 8;
                break;
            case NINE:
                value = 9;
                break;
            case TEN:
                value = 10;
                break;
            case JACK:
                value = 10;
                break;
            case QUEEN:
                value = 10;
                break;
            case KING:
                value = 10;
                break;
        }

        return value;
    }

    /**
     * Calculates and returns the hand value (sum of the hand cards values)
     *
     * @return The hand value
     */

    public int getValue() {
        int value = 0;
        for (Card card : cards) {
            switch (card.getRank()) {
                case ACE:
                    if (value + 11 > 21) value += 1;
                    else value += 11;
                    break;
                case TWO:
                    value += 2;
                    break;
                case THREE:
                    value += 3;
                    break;
                case FOUR:
                    value += 4;
                    break;
                case FIVE:
                    value += 5;
                    break;
                case SIX:
                    value += 6;
                    break;
                case SEVEN:
                    value += 7;
                    break;
                case EIGHT:
                    value += 8;
                    break;
                case NINE:
                    value += 9;
                    break;
                case TEN:
                    value += 10;
                    break;
                case JACK:
                    value += 10;
                    break;
                case QUEEN:
                    value += 10;
                    break;
                case KING:
                    value += 10;
                    break;
            }
        }
        return value;
    }

    /**
     * override toString in class java.lang.Object
     */

    public String toString() {
        StringBuilder out = new StringBuilder();

        for (Card c : cards) {
            out.append(c.toString()).append(" ");
        }
        return new String(out);
    }


}
