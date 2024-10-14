package UnoEngine;

public class SkipActionCard extends OrdinaryCard {

    public SkipActionCard(Color color) {
        super(color, Value.SKIP);
    }
//    skip the next player
    @Override
    public void performAction(UnoGameManager gameState) {
        System.out.println("Next player has been skipped!");
        gameState.updateNextPlayer();
    }
}
