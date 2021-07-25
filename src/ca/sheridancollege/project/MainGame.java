/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ca.sheridancollege.project;

import java.util.ArrayList;

/**
 *
 * @author fausto.correa
 */
public class MainGame {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        String givenName="NewGame";
        ArrayList <Player> players = null;// the players of the game
        int numPlayer = 3;
        
        for(int i =0; i < numPlayer; i++) {
            players.set(i, new Player("Player "+i) {
                @Override
                public void play() {
                    throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
                }
            });
        }
        Game game = new Game(givenName) {
            @Override
            public void play() {
                throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
            }

            @Override
            public void declareWinner() {
                throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
            }
        }; 
        game.setPlayers(players);
    }
    
}
