/**
 * SYST 17796 Project Winter 2019 Base code.
 * Students can modify and extend to implement their game.
 * Add your name as a modifier and the date!
 */
package ca.sheridancollege.project;

import static ca.sheridancollege.project.MainGame.players;
import java.util.ArrayList;

/**
 * The class that models your game. You should create a more specific child of
 * this class and instantiate the methods given.
 *
 * @author dancye, 2018
 */
public abstract class Game {

    private final String gameName;//the title of the game
    private ArrayList<Player> players;// the players of the game

    public Game(String givenName) {
        gameName = givenName;
        players = new ArrayList();
    }

    /**
     * @return the gameName
     */
    public String getGameName() {
        return gameName;
    }

    /**
     * @return the players of this game
     */
    public ArrayList<Player> getPlayers() {
        return players;
    }

    /**
     * @param players the players of this game
     */
    public void setPlayers(ArrayList<Player> players) {
        this.players = players;
    }

    public static boolean checkCardPlayable(Card c, Card playingCard) {
        // TODO Auto-generated method stub
        if (c.getCardValue() == CardValue.WILD || c.getCardValue() == CardValue.WILDFOURDRAW || c.getColor() == playingCard.getColor() || c.getCardValue() == playingCard.getCardValue()) {
            return true;
        } else {
            return false;
        }
    }

    /**
     * Play the game. This might be one method or many method calls depending on
     * your game.
     */
    public abstract void play(Player player, int choice);

    /**
     * When the game is over, use this method to declare and display a winning
     * player.
     */
    //public abstract void declareWinner();
    public String RegisterPlayers() {
        // TODO - implement Game.RegisterPlayers
        throw new UnsupportedOperationException();
    }

    private void nextPlayerDrawsCards(Player player, int cards, int gameDirection, int playerPos, GroupOfCards totalDeck) {
        // TODO Auto-generated method stub
        if (gameDirection == 0) {
            player = players.get(playerPos++);
            //player = player.nextPlayer;
        } else if (gameDirection == 1) {
            //player = player.previousPlayer;

            if (playerPos == 0) {
                player = players.get(players.size() - 1);

            } else {
                player = players.get(playerPos--);

            }

        }
        System.out.println(player.getPlayerID() + " draws " + cards + " cards. Cards are added to deck!");
        for (int i = 0; i < cards; i++) {
            //player.addCardToDeck(popExtraDeck());
            player.addCardToDeck(totalDeck.removeCard(totalDeck.getSize()));
        }
    }

    /**
     *
     * @param Players
     */
    public void PointPerPlayer(ArrayList<Player> Players) {
        // TODO - implement Game.PointPerPlayer
        throw new UnsupportedOperationException();
    }

    /**
     *
     * @param players
     * @param cards
     */
    public void Scoring(ArrayList<Player> players, ArrayList<Card> cards) {
        // TODO - implement Game.Scoring
        throw new UnsupportedOperationException();
    }

}//end class
