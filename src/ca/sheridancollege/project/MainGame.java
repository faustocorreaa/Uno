/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ca.sheridancollege.project;

import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;
import scannerutils.ScannerUtils;

/**
 *
 * @author fausto.correa
 */
public class MainGame {

    static int totalNumberOfCards = 108;
    static int numberOfCardsPerPlayer = 7;
    static ArrayList<Player> players = new ArrayList();// the players of the game
    static Scanner myScanner = new Scanner(System.in);
    static ScannerUtils myScannerUtils = new ScannerUtils();
    static int numberOfPlayers;
    static Card playingCard;
    static int topExtraDeck = -1;
    static int bottomExtraDeck = -1;
    static GroupOfCards totalDeck = new GroupOfCards(108);
    static int gameDirection = 0; //0 means up, 1 means down
    static int playerPos = 0;

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        String givenName = "NewGame";
        String prompt = "How many player are going to play?";
        numberOfPlayers = myScannerUtils.getIntegerInput(prompt, myScanner); //Number of players to create

        //prompt = "Enter number of initial cards per player:";
        //numberOfCardsPerPlayer = myScannerUtils.getIntegerInput(prompt, myScanner); //Number of cards per players to create
        Game game = new Game(givenName) {
            @Override
            public void play(Player player, int choice) {
                displayPlayingCard();
                System.out.println(player.getPlayerID() + "'s turn! Choose your option");
                player.displayPlayerDeck();
                //System.out.println("99. Draw card from extra deck.");
                {
                    if (choice == 99) {
                        System.out.println("100. Skip");
                    }
                    String prompt = "99. Draw card from extra deck.";
                    choice = myScannerUtils.getIntegerInput(prompt, myScanner); //Number of players to create

                    if (choice == 99) {
                        //player.addCardToDeck(popExtraDeck());  		//player chooses to draw card from extra deck
                        player.addCardToDeck(totalDeck.removeCard(totalDeck.getSize() - 1));
                        play(player, 99);
                    } else if (choice == 100) {
                        if (gameDirection == 0) {
                            play(players.get(playerPos++), 0);
                        } else if (gameDirection == 1) {
                            if (playerPos == 0) {
                                play(players.get(players.size() - 1), 0);

                            } else {
                                play(players.get(playerPos--), 0);

                            }
                        }
                    } else if (choice <= player.getCards().size()) {
                        if (checkCardPlayable(player.getCards().get(choice - 1), playingCard)) {
                            totalDeck.addCard(playingCard);
                            //pushExtraDeck(playingCard);
                            playingCard = player.getCards().get(choice - 1);
                            player.removeCardFromDeck(choice - 1);
                            //Special Card processing
                            if (playingCard.getCardValue() == CardValue.SKIP) { //Playing card is Skip
                                System.out.println("Skipped!");
                                if (gameDirection == 0) {
                                    player = players.get(playerPos++);
                                    System.out.println(player.getPlayerID() + " Skipped!");
                                    play(player, 0);
                                } else if (gameDirection == 1) {

                                    if (playerPos == 0) {
                                        play(players.get(players.size() - 1), 0);

                                    } else {
                                        play(players.get(playerPos--), 0);

                                    }

                                    //player = player.previousPlayer;
                                    //playerTurn(player.previousPlayer, 0);
                                }
                            } else if (playingCard.getCardValue() == CardValue.REVERSE) { //Playing card is reverse
                                System.out.println("Reversed!");
                                if (gameDirection == 0) {
                                    gameDirection = 1;
                                } else if (gameDirection == 1) {
                                    gameDirection = 0;
                                }

                                if (gameDirection == 0) {
                                    //playerTurn(player.nextPlayer, 0);
                                    play(players.get(playerPos++), 0);
                                } else if (gameDirection == 1) {
                                    //playerTurn(player.previousPlayer, 0);
                                    if (playerPos == 0) {
                                        play(players.get(players.size() - 1), 0);

                                    } else {
                                        play(players.get(playerPos--), 0);

                                    }
                                }
                            } else if (playingCard.getCardValue() == CardValue.DRAWTWO) { //Playing card is draw 2
                                nextPlayerDrawsCards(player, 2, gameDirection, playerPos, totalDeck);
                                if (gameDirection == 0) {
                                    play(players.get(playerPos++), 0);
                                    //playerTurn(player.nextPlayer, 0);
                                } else if (gameDirection == 1) {
                                    //playerTurn(player.previousPlayer, 0);
                                    if (playerPos == 0) {
                                        play(players.get(players.size() - 1), 0);

                                    } else {
                                        play(players.get(playerPos--), 0);

                                    }
                                }
                            } else if (playingCard.getCardValue() == CardValue.WILD) {

                                System.out.println("Choose your colour:");

                                prompt = "\"1.Red\\t2.Yellow\\t3.Green\\t4.Blue\"";
                                choice = myScannerUtils.getIntegerInput(prompt, myScanner); //Number of players to create

                                playingCard.setColorNumber(choice - 1);
                                System.out.println("The colour has changed to " + playingCard);
                                play(player, 0);

                            } else if (playingCard.getCardValue() == CardValue.WILDFOURDRAW) {
                                nextPlayerDrawsCards(player, 2, gameDirection, playerPos, totalDeck);
                                System.out.println("Choose your colour:");

                                prompt = "\"1.Red\\t2.Yellow\\t3.Green\\t4.Blue\"";
                                choice = myScannerUtils.getIntegerInput(prompt, myScanner); //Number of players to create

                                playingCard.setColorNumber(choice - 1);
                                System.out.println("The colour has changed to " + playingCard);
                                play(player, 0);

                            } else {

                                if (gameDirection == 0) {
                                    play(players.get(playerPos++), 0);
                                } else if (gameDirection == 1) {
                                    if (playerPos == 0) {
                                        play(players.get(players.size() - 1), 0);

                                    } else {
                                        play(players.get(playerPos--), 0);

                                    }
                                }
                            }
                        } else {
                            System.out.println("Uh oh! You cannot play that card! Try again.");
                            play(player, 0);
                        }
                    } else {
                        System.out.println("That's not even an option! Try again.");
                        play(player, 0);
                    }
                }

            }
        };

        ArrayList<Card> cards = new ArrayList();
        //Generate :
        /*
        19 Blue cards - 0 to 9
        19 Green cards - 0 to 9
        19 Red cards - 0 to 9
        19 Yellow cards - 0 to 9
         */

        for (int i = 0; i < 4; i++) {
            for (int j = 0; j < 15; j++) {
                Card c = new Card() {
                    @Override
                    public String toString() {
                        return getColor() + " " + getCardValue();
                    }
                };

                switch (j) {
                    case 0:
                        c.setColorNumber(i);
                        c.setCardValueNumber(j);
                        cards.add(c);
                        break;
                    case 1:
                    case 2:
                    case 3:
                    case 4:
                    case 5:
                    case 6:
                    case 7:
                    case 8:
                    case 9:
                        c.setColorNumber(i);
                        c.setCardValueNumber(j);
                        cards.add(c);
                        c.setColorNumber(i);
                        c.setCardValueNumber(j);
                        cards.add(c);
                        break;
                    case 10:
                    case 11:
                    case 12:
                        c.setColorNumber(i);
                        c.setCardValueNumber(j);
                        cards.add(c);
                        c.setColorNumber(i);
                        c.setCardValueNumber(j);
                        cards.add(c);
                        break;
                    case 13:
                    case 14:
                        c.setCardValueNumber(j);
                        cards.add(c);
                        break;
                }
            }
        }

        totalDeck.setCards(cards);
        totalDeck.shuffle();
        //System.out.println(cards.size());

        /*
        for (Card c : totalDeck.showCards()) {
            System.out.println(c);
        }
         */
        for (int i = 0; i < numberOfPlayers; i++) {
            players.add(new PlayerImp("Player " + i) {
                @Override
                public void play() {

                }
            });
            addCardsForPlayer(players.get(i));
        }

        //System.out.println(players);
        //System.out.println(players.get(0).getCards());
        //System.out.println(totalDeck.showCards().size());
        game.setPlayers(players);
        getFirstCard();
        game.play(game.getPlayers().get(0), 0);

    }

    public static void getFirstCard() {
        boolean isItOkay = false;
        do {
            playingCard = totalDeck.removeCard(totalDeck.showCards().size() - 1);

            if (playingCard.getCardValue() == CardValue.WILD || playingCard.getCardValue() == CardValue.WILDFOURDRAW) {
                totalDeck.addCard(playingCard);
                isItOkay = false;
            } else {
                isItOkay = true;
            }
        } while (!isItOkay);
    }

    public static void displayPlayingCard() {
        System.out.println("The Playing Card is:  " + playingCard);
    }

    public static void addCardsForPlayer(Player p) {
        for (int i = 0; i < numberOfCardsPerPlayer; i++) {
            Random rand = new Random();
            p.addCardToDeck(totalDeck.removeCard(rand.nextInt(totalDeck.getSize())));
        }
    }

    private static void nextPlayerDrawsCards(Player player, int cards, int gameDirection, int playerPos, GroupOfCards totalDeck) {
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
            player.addCardToDeck(totalDeck.removeCard(totalDeck.getSize() - 1));
        }
    }

}
