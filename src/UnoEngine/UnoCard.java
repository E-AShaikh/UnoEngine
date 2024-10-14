package UnoEngine;

public interface UnoCard {

//   return true if the calling card can be placed on top of the passed card
    public boolean isPlaceableOnTop(UnoCard card);
//    perform the action the card cause
    public void performAction(UnoGameManager gameState);

    public String toString();

    public Color getColor();

    public Value getValue();

}
