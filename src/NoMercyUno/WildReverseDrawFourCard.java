package NoMercyUno;

import UnoEngine.OrdinaryCard;
import UnoEngine.UnoGameManager;
import UnoEngine.Value;
import UnoEngine.WildUnoCard;

public class WildReverseDrawFourCard extends WildUnoCard {

    public WildReverseDrawFourCard() {
        color = null;
        value = Value.WILD_REVERSE_DRAW_FOUR;
    }
//    choose color, reverse order, and inflict penalty on the next player
    @Override
    public void performAction(UnoGameManager gameManager) {
        super.performAction(gameManager);
        gameManager.addExtraCardDraw(4);
        gameManager.reverseOrder();
    }

    @Override
    public String toString() {
        if (color == null)
            return "Wild Reverse Draw 4";
        else
            return color + " Wild Reverse Draw 4";
    }
}
