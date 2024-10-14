package NoMercyUno;

import UnoEngine.*;

import java.util.ArrayList;
import java.util.Scanner;

public class NoMercyOrdinaryCard extends UnoEngine.OrdinaryCard {
    public NoMercyOrdinaryCard(Color color, Value value) {
        super(color, value);
    }

    public void performAction(UnoGameManager gameManager) {
        if (value == Value.ZERO) {
            int numPlayers = gameManager.getPlayers().size();
            Player firatPlayer = gameManager.getPlayers().get(0);
            ArrayList<UnoCard> firstPlayerHand = firatPlayer.getPlayerHand();
            for (int i = 0; i < numPlayers - 2; i++) {
                Player player = gameManager.getPlayers().get(i);
                Player nextPlayer = gameManager.getPlayers().get(i + 1);
                player.setPlayerHand(nextPlayer.getPlayerHand());
            }

            Player lastPlayer = gameManager.getPlayers().get(numPlayers - 1);
            lastPlayer.setPlayerHand(firstPlayerHand);

            System.out.println("Each player has passed his hand to the next player!");
        }

        if (value == Value.SEVEN) {
            int i = 1;
            for (Player player: gameManager.getPlayers()) {
                System.out.println(i + ") " + player.getPlayerName());
                i++;
            }
            System.out.println("Type the index of the player to select:");

            Player currentPlayer = gameManager.getNextPlayer();
            ArrayList<UnoCard> currentPlayerHand = currentPlayer.getPlayerHand();

            Scanner sc = new Scanner(System.in);

            Player chosenPlayer;
            while (true) {
                int index = sc.nextInt() - 1;
                try {
                    chosenPlayer = gameManager.getPlayers().get(index);
                    break;
                } catch (Exception e) {
                    System.out.println("Sorry, your response is invalid, try again!");
                }
            }

            ArrayList<UnoCard> chosenPlayerHand = chosenPlayer.getPlayerHand();

            currentPlayer.setPlayerHand(chosenPlayerHand);
            chosenPlayer.setPlayerHand(currentPlayerHand);


            System.out.println(currentPlayer.getPlayerName() + " has swapped hand with " + chosenPlayer.getPlayerName());
        }
    }
}
