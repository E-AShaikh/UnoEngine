package NoMercyUno;

import UnoEngine.Color;
import UnoEngine.OrdinaryCard;
import UnoEngine.UnoGameManager;
import UnoEngine.Value;

public class DrawCard extends OrdinaryCard {
    private int numDrawCards;
    public DrawCard(Color color, int numCards) {
        super(color, Value.DRAW);
        numDrawCards = numCards;
    }
//   increase penalty inflicted upon the next player by numCards
    @Override
    public void performAction(UnoGameManager gameState) {
        gameState.addExtraCardDraw(numDrawCards);
    }

    @Override
    public String toString() {
        return color + " Draw " + numDrawCards;
    }
}
