package UnoEngine;

import java.util.Scanner;

public abstract class Game {
     protected UnoDeck deck;
     protected UnoGameManager gameManager;
     public Game() {
          gameManager = new UnoGameManager();
          deck = createDeck();
     }
//     returns true once one of the player wins the game
     protected abstract boolean isGameOver();
//     used to create the suitable deck for each game variation
     protected abstract UnoDeck createDeck();
//     implements the high level flow of the game
     public abstract void play();
     /*
    Responsible for managing a player's turn,
    this method involves prompting the player to select a card,
    validating the choice, and executing the corresponding action.
*/
     protected abstract void performPlayerTurn(Player player);
     protected void dealCards(int startingHandSize) {
          for (Player player: gameManager.getPlayers()) {
               for (int i = 0; i < startingHandSize; i++)
                    player.addCardToHand(deck.pullACard());
          }
     }
//    Prompt the players to type their names
     protected void startGame() {
          Scanner sc = new Scanner(System.in);

          System.out.println("Enter The number of Players:");
          int numberOfPlayers = Integer.parseInt(sc.nextLine());


          for (int i = 0; i < numberOfPlayers; i++) {
               System.out.println("Enter player's name:");
               String playerName = sc.nextLine();
               gameManager.addPlayer(new HumanConsolePlayer(playerName));
          }

     }
//     deal penalty cards that are inflicted by previous players
     protected void dealPenaltyCards(Player currentPlayer) {
          while (gameManager.getNumExtraCardDraw() > 0) {
               currentPlayer.addCardToHand(deck.pullACard());
               gameManager.setNumExtraCardDraw(gameManager.getNumExtraCardDraw() - 1);
          }
     }

}
