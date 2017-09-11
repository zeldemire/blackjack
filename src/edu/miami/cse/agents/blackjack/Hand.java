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
	public Hand(){
		cards = new ArrayList<Card>();
	}
	
	/**
	   * Add a card to the card list.
	*/
	
	public void add(Card card){
		cards.add(card);
	}
	
	/**
	   * Calculates and returns the hand value (sum of the hand cards values)
	   * @return The hand value
	*/
	
	public int getValue(){
		// dummy code update it as explained in the homework	
		return (int)(Math.random() * 50);
	}
	
	/**
	 * override toString in class java.lang.Object
	 */
	
	public String toString(){
		StringBuilder out = new StringBuilder();
		
		for(Card c : cards){
			out.append(c.toString() + " ");
		}
		return new String(out);
	}
	
	
}
