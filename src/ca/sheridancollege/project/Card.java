
package ca.sheridancollege.project;

import java.util.Random;

/**
 * @author Fausto correa , Kamaksh Dave, Ruchita soni, Alpa Gandhi
 * date : 19 August 2021
 * Description: A Card containing the values and colours 
 */
public abstract class Card {
    //default modifier for child classes

    /**
     * @return a String representation of a card. Could be an UNO card, a
     * regular playing card etc.
     */
    @Override
    public abstract String toString();//abstract class 
            //getter method for colour card
    public Color getColor() {
        return this.color;
    }
      //RandomCard switch case
    public void setRandomCard() {
        Random rand = new Random();
        int colour = rand.nextInt(4);
        int cardType = rand.nextInt(15);
       //colour of the cards 
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
           // Cards with number value 
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
                cardValue = CardValue.SKIP; //Skip card
                break;
            case 11:
                cardValue = CardValue.REVERSE; //Reverse Card
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
              // Card Value Number 
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
                //setting the colour number value 
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
    //setting colour method
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
