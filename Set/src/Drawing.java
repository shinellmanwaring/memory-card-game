/**
 * Drawing.java
 * Holds and draws all graphical objects
 * in the Applet
 */
import java.awt.*;
import java.util.ArrayList;

public class Drawing {
	private ArrayList<Card> onTable = new ArrayList<Card>;
	private final int MAX_ARR_LEN = 15;	//The most cards the ArrayList can hold
	private int num_cards;
	
	public Drawing () {
		num_cards = 0;
	}
	
	/**
	 * Adds a card at the index in the array, or the location
	 * on the "table."
	 * 
	 * @param: index the index in the array at which the card is to be inserted
	 * @param: card the Card to be inserted
	 */
	public void addCard(int index, Card card) {
		onTable.add(index, card);
		num_cards += 1;
		
	}
	
	/**
	 * Removes a card from the ArrayList at the specified index
	 * 
	 * @param: index the index in the ArrayList at which the 
	 * card-to-be-removed is located.
	 */
	public void removeCard(int index) {
		onTable.remove(index);
		num_shapes = num_shapes - 1;
	}
	
	/**
	 * Replaces the card at the specified index
	 */
	public void replaceCard(int index, Card card) {
		onTable.set(index, card);
	}
}

