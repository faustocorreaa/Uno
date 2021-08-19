/**
 * SYST 17796 Project Winter 2019 Base code.
 * Students can modify and extend to implement their game.
 * Add your name as a modifier and the date!
 */
package ca.sheridancollege.project;

import java.util.ArrayList;

/**
 * A class that models each Player in the game. Players have an identifier,
 * which should be unique.
 * @author dancye, 2018
 */


/*
 *In this class security for the code is achieved through abstraction
 *@modifiers: Fausto Correa, Kamaksh Dave, Ruchita Soni, Alpa Gandhi
 *Date: 19 August 2021 
 */


public abstract class Player {

    private String playerID; //the unique ID for this player
    private String userName; //the userName for this player
    private String password; //the password for this player
    private ArrayList<Card> cards = new ArrayList();
    int playerNumber, numberOfCards;

    /**
     * A constructor that allows you to set the player's unique ID
     *
     * @param name the unique ID to assign to this player.
     */
    public Player(String name) {
        playerID = name;
    }
 //Method for adding card to deck
    public void addCardToDeck(Card c) {
        cards.add(c);
    }
 
 //Method for removing card from deck
    public Card removeCardFromDeck(int index) {
        return cards.remove(index);
    }
  //Method helps to display player Deck
    public void displayPlayerDeck() {

        System.out.println(playerID + "'s cards:");
        int i = 1;
        for (Card c : cards) {
            System.out.println(i+" "+c);
            i++;
        }
    }

    /**
     * @return the playerID
     */
    //Getter and Setter method for playerID
    public String getPlayerID() {
        return playerID;
    }

    /**
     * Ensure that the playerID is unique
     *
     * @param givenID the playerID to set
     */
    public void setPlayerID(String givenID) {
        playerID = givenID;
    }

    /**
     * The method to be instantiated when you subclass the Player class with
     * your specific type of Player and filled in with logic to play your game.
     */
    public abstract void play();

    /**
     *
     * @param userName
     * @param password
     * @return
     */
     //This method helps to login the player
    public String login(String userName, String password) {
     // TODO - implement Player.login
        throw new UnsupportedOperationException();
    }
    //Method returns the card
    public ArrayList<Card> getCards() {
        return cards;
    }

    /**
     *
     * @param playerID
     */
    //This method helps to logout the player
    public void logout(String playerID) {
    // TODO - implement Player.logout
        throw new UnsupportedOperationException();
    }
   //Getter and Setter method starts for username and password
    public String getUserName() {
        return this.userName;
    }

    /**
     *
     * @param userName
     */
    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPassword() {
        return this.password;
    }

    /**
     *
     * @param password
     */
    public void setPassword(String password) {
        this.password = password;
    }

}
