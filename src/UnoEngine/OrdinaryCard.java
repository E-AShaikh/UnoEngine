package UnoEngine;

import java.util.Objects;

public class OrdinaryCard implements UnoCard {

    protected Color color;
    protected Value value;

    public OrdinaryCard(Color color, Value value) {
        this.color = color;
        this.value = value;
    }
    @Override
    public Color getColor() {
        return color;
    }
    @Override
    public Value getValue() {
        return value;
    }

    @Override
    public String toString() {
        return color + " " + value;
    }

//    returns true if the colors of the types of the cards match
    public boolean isPlaceableOnTop(UnoCard card) {
        if (card == null)
            return true;
        else if (value.equals(card.getValue()) | color.equals(card.getColor()))
            return true;
        else
            return false;

    }
//    no action inflicted by ordinary card
    public void performAction(UnoGameManager gameState) {

    }
}



