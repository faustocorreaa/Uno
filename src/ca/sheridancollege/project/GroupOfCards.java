
package ca.sheridancollege.project;

import java.util.ArrayList;
import java.util.Collections;

/**
 * A concrete class that represents any grouping of cards for a Game.
 * HINT, you might want to subclass this more than once.
 * The group of cards has a maximum size attribute which is flexible for reuse.
 * @author Fausto correa , Kamaksh Dave, Ruchita soni, Alpa Gandhi
 * date : 19 August 2021
 * Description: A class containing group of cards
 */
 */
public class GroupOfCards 
{
   
    //The group of cards, stored in an ArrayList
    private ArrayList <Card> cards;
    private int size;//the size of the grouping
    
    public GroupOfCards(int givenSize)
    {
        size = givenSize;
    }
    
    /**
     * A method that will get the group of cards as an ArrayList
     * @return the group of cards.
     */
    public ArrayList<Card> showCards()
    {
        return cards;
    }
    
    public void setCards (ArrayList<Card> cards){
        this.cards = cards;
    }
    
    public void shuffle()
    {
        Collections.shuffle(cards);
    }

    /**
     * @return the size of the group of cards
     */
    public int getSize() {
        return size;
    }

    public Card removeCard(int i) {
        Card c = cards.remove(i);
        size = cards.size();
        return c;
    }
    
    public void addCard(Card card) {
        cards.add(card);
    }
    /**
     * @param givenSize the max size for the group of cards
     */
    public void setSize(int givenSize) {
        size = givenSize;
    }

	/**
	 * 
	 * @param card
	 */
	public Card Draw2(Card card) {
		// TODO - implement GroupOfCards.Draw2
		throw new UnsupportedOperationException();
	}

	/**
	 * 
	 * @param card
	 */
	public Card Reverse(Card card) {
		// TODO - implement GroupOfCards.Reverse
		throw new UnsupportedOperationException();
	}

	/**
	 * 
	 * @param card
	 */
	public Card Skip(Card card) {
		// TODO - implement GroupOfCards.Skip
		throw new UnsupportedOperationException();
	}

	/**
	 * 
	 * @param card
	 */
	public Card Wild(Card card) {
		// TODO - implement GroupOfCards.Wild
		throw new UnsupportedOperationException();
	}

	/**
	 * 
	 * @param card
	 */
	public Card WildDraw(Card card) {
		// TODO - implement GroupOfCards.WildDraw
		throw new UnsupportedOperationException();
	}

	/**
	 * 
	 * @param card
	 */
	public Card Blank(Card card) {
		// TODO - implement GroupOfCards.Blank
		throw new UnsupportedOperationException();
	}
    
}//end class
