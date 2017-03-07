
import java.awt.*;
import java.util.ArrayList;

/**
 * TurnOverCardsCmd.java
 * Command class to perform a turn over cards command.
 * 
 * @author Shinell Manwaring
 * @see Command
 */

public class TurnOverCardsCmd extends Command {
	private ArrayList<Card> pair = new ArrayList<Card>(); // the index of the two cards selected

	/**
	 * When the "TurnOverCards" button is clicked, if the selected pair of cards are not a proper match
	 * return the cards to the face down position. 
	 * 
	 * @param dwg the drawing 
	 */
	public void executeClick(Drawing dwg) {
		pair = dwg.getSelectedCards(); //Get the Cards that were selected
		if (dwg.isAMatch(pair)) { //Do the selected cards match?
			//display a prompt telling the user to remove the selected cards
		}
		else {
			for (int j = 0; j < 2; j++) {
				dwg.addToSelectArray(pair.get(j), j);
				pair.get(j).setFaceUp(false); //Turn the selected cards so they are faced down
				pair.unsetHighlighted(); //unhighlight the selected card
			}
		}
		pair.clear(); //clear the array of cards selected
	}
}