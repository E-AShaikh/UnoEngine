package NoMercyUno;

import UnoEngine.UnoGameManager;
import UnoEngine.WildUnoCard;
import java.util.Random;
import UnoEngine.Color;

public class WildColorRouletteCard extends WildUnoCard {
//    chooses the color of the Wild card randomly
    @Override
    public void performAction(UnoGameManager gameState) {
        int rnd = new Random().nextInt(Color.values().length);
        color = Color.values()[rnd];
    }

    @Override
    public String toString() {
        if (color == null)
            return "Wild Color Roulette";
        else
            return color + " Wild Color Roulette";
    }
}
