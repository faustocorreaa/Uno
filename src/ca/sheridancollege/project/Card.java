/**
 * SYST 17796 Project Winter 2019 Base code.
 * Students can modify and extend to implement their game.
 * Add your name as a modifier and the date!
 */
package ca.sheridancollege.project;

import java.util.Random;

/**
 * A class to be used as the base Card class for the project. Must be general
 * enough to be instantiated for any Card game. Students wishing to add to the
 * code should remember to add themselves as a modifier.
 *
 * @author dancye, 2018
 */
public abstract class Card {
    //default modifier for child classes

    /**
     * Students should implement this method for their specific children classes
     *
     * @return a String representation of a card. Could be an UNO card, a
     * regular playing card etc.
     */
    @Override
    public abstract String toString();

    public Color getColor() {
        return this.color;
    }

    public void setRandomCard() {
        Random rand = new Random();
        int colour = rand.nextInt(4);
        int cardType = rand.nextInt(15);
        switch (colour) {
            case 0:
                color = Color.RED;
                break;
            case 1:
                color = Color.YELLOW;
                break;
            case 2:
                color = Color.GREEN;
                break;
            case 3:
                color = Color.BLUE;
                break;
            case 4:
                color = Color.NO_COLOR;
                break;
        }

        switch (cardType) {
            case 0:
                cardValue = CardValue.ZERO;
                break;
            case 1:
                cardValue = CardValue.ONE;
                break;
            case 2:
                cardValue = CardValue.TWO;
                break;
            case 3:
                cardValue = CardValue.THREE;
                break;
            case 4:
                cardValue = CardValue.FOUR;
                break;
            case 5:
                cardValue = CardValue.FIVE;
                break;
            case 6:
                cardValue = CardValue.SIX;
                break;
            case 7:
                cardValue = CardValue.SEVEN;
                break;
            case 8:
                cardValue = CardValue.EIGHT;
                break;
            case 9:
                cardValue = CardValue.NINE;
                break;
            case 10:
                cardValue = CardValue.SKIP;
                break;
            case 11:
                cardValue = CardValue.REVERSE;
                break;
            case 12:
                cardValue = CardValue.DRAWTWO;// "Draw Two (+2)"; 
                break;
            case 13:
                cardValue = CardValue.WILD; // "Wild Card"; 
                break;
            case 14:
                cardValue = CardValue.WILDFOURDRAW;// "Draw Four (+4) with Wild Card"; 
                break;

        }

    }

    public void setCardValueNumber(int cardType) {

        switch (cardType) {
            case 0:
                cardValue = CardValue.ZERO;
                break;
            case 1:
                cardValue = CardValue.ONE;
                break;
            case 2:
                cardValue = CardValue.TWO;
                break;
            case 3:
                cardValue = CardValue.THREE;
                break;
            case 4:
                cardValue = CardValue.FOUR;
                break;
            case 5:
                cardValue = CardValue.FIVE;
                break;
            case 6:
                cardValue = CardValue.SIX;
                break;
            case 7:
                cardValue = CardValue.SEVEN;
                break;
            case 8:
                cardValue = CardValue.EIGHT;
                break;
            case 9:
                cardValue = CardValue.NINE;
                break;
            case 10:
                cardValue = CardValue.SKIP;
                break;
            case 11:
                cardValue = CardValue.REVERSE;
                break;
            case 12:
                cardValue = CardValue.DRAWTWO;// "Draw Two (+2)"; 
                break;
            case 13:
                cardValue = CardValue.WILD; // "Wild Card"; 
                break;
            case 14:
                cardValue = CardValue.WILDFOURDRAW;// "Draw Four (+4) with Wild Card"; 
                break;

        }

    }

    public void setColorNumber(int colour) {
        switch (colour) {
            case 0:
                color = Color.RED;
                break;
            case 1:
                color = Color.YELLOW;
                break;
            case 2:
                color = Color.GREEN;
                break;
            case 3:
                color = Color.BLUE;
                break;
        }

    }

    /**
     *
     * @param color
     */
    public void setColor(Color color) {
        this.color = color;
    }

    public CardValue getCardValue() {
        return this.cardValue;
    }

    /**
     *
     * @param cardValue
     */
    public void setCardValue(CardValue cardValue) {
        this.cardValue = cardValue;
    }

    private Color color;
    private CardValue cardValue;

}
