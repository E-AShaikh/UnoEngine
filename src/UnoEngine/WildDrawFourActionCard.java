package UnoEngine;

public class WildDrawFourActionCard extends WildUnoCard {

    public WildDrawFourActionCard() {
        color = null;
        value = Value.WILD_DRAW;
    }
//      returns true always. Wild card can be played on top on any card.
    @Override
    public boolean isPlaceableOnTop(UnoCard card) {
        return true;
    }
//     increase the penalty cards by 4
    @Override
    public void performAction(UnoGameManager gameState) {
        super.performAction(gameState);
        gameState.addExtraCardDraw(4);
    }

    @Override
    public String toString() {
        if (color == null)
            return "Wild Draw Four";
        else
            return "Wild Draw Four" + " " + color;

    }
}
