package NoMercyUno;

import UnoEngine.UnoGameManager;
import UnoEngine.Value;
import UnoEngine.WildUnoCard;

public class WildDrawCard extends WildUnoCard {

    private int numDrawCards;
    public WildDrawCard(int numCards) {
        value = Value.WILD_DRAW;
        numDrawCards = numCards;
    }
//    allows player to choose the color of the card and to inflict penalty cards on the next player
    @Override
    public void performAction(UnoGameManager gameManager) {
        super.performAction(gameManager);
        gameManager.addExtraCardDraw(numDrawCards);
    }

    @Override
    public String toString() {
        if (color == null)
            return "Wild Draw " + numDrawCards;
        else
            return color + " Wild Draw " + numDrawCards;
    }
}
