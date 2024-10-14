package UnoEngine;

public class ReverseActionCard  extends OrdinaryCard {

    public ReverseActionCard(Color color) {
        super(color, Value.REVERSE);
    }
//    reverses the order of play
    @Override
    public void performAction(UnoGameManager gameState) {
        System.out.println("Play order has been reversed!");
        gameState.reverseOrder();
    }
}
