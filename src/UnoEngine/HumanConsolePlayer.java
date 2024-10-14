package UnoEngine;

import java.util.Scanner;

public class HumanConsolePlayer extends Player {
    protected HumanConsolePlayer(String name) {
        super(name);
    }
//   prompt the player to choose a card to play through console
    public UnoCard chooseACard(UnoCard topCardInPile) {

        System.out.println();
        if (topCardInPile == null) {
            System.out.println("The pile is currently empty. You may play any card.");
        } else {
            System.out.println("The top card in pile is currently the " + topCardInPile + ".");
        }

//        prints the hand of th player
        System.out.println(playerName + "'s hand is:");
        for (int i = 1; i <= playerHand.size(); i++) {
            System.out.println("\t" + i + ") " + playerHand.get(i - 1));
        }
//        prompt player to chose a card to play
        Scanner sc = new Scanner(System.in);

        System.out.println("Type the index of the card to select, 'd' " +
                "to draw a card, or 'q' to quit the game: ");

        String input = sc.nextLine();

//        handles unsuitable inputs
        while(true) {
            try {
                if (input.equals("d")) {
                    return null;
                } else if (input.equals("q")) {
                    System.out.println("You quit the game.");
                    System.exit(0);
                } else {
                    return playerHand.get(Integer.valueOf(input) - 1);
                }
            } catch (Exception e) {
                System.out.println("Sorry, your response is invalid, try again!");
            }
        }

    }
}
