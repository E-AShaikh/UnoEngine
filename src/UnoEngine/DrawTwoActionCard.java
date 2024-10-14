package UnoEngine;

public class DrawTwoActionCard extends OrdinaryCard {

    public DrawTwoActionCard(Color color) {
        super(color, Value.DRAW);
    }
//    adds 2 cards to the penalty that will be inflicted upon the next player
    @Override
    public void performAction(UnoGameManager gameState) {
        gameState.addExtraCardDraw(2);
    }
}
