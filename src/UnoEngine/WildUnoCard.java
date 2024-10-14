package UnoEngine;

import java.util.Scanner;

public class WildUnoCard extends OrdinaryCard {
    public WildUnoCard() {
        super(null, Value.WILD);
    }

    @Override
    public boolean isPlaceableOnTop(UnoCard card) {
        return true;
    }
//     prompt player to choose the color of this wild card
    @Override
    public void performAction(UnoGameManager gameState) {
        System.out.println("1) Red");
        System.out.println("2) Blue");
        System.out.println("3) Green");
        System.out.println("4) Yellow");
        System.out.println("Type the index of the chosen color:");

        Scanner sc = new Scanner(System.in);
        while(true) {
            int input = sc.nextInt();
            try {
                if (input == 1) {
                    color = Color.Red;
                    break;
                }
                else if (input == 2) {
                    color = Color.Blue;
                    break;
                } else if (input == 3) {
                    color = Color.Green;
                    break;
                } else if (input == 4) {
                    color = Color.Yellow;
                    break;
                } else {
                    throw new IllegalArgumentException();
                }
            } catch (Exception e) {
                System.out.println("Sorry, your response is invalid, try again!");
            }
        }
    }

    @Override
    public String toString() {
        if (color == null)
            return "Wild";
        else
            return value + " " + color;
    }
}
