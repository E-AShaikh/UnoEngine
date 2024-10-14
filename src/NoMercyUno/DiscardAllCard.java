package NoMercyUno;

import UnoEngine.*;

public class DiscardAllCard extends OrdinaryCard {

    public DiscardAllCard(Color color) {
        super(color, Value.DISCARD_ALL);
    }
//    force all players to discard the cards in their hand that have the same color
    @Override
    public void performAction(UnoGameManager gameManager) {
        UnoCard playedCard = gameManager.getTopCardInPile();
        if (playedCard == null) return;
        for (Player player: gameManager.getPlayers()) {
            for (int i = 0; i < player.getHandSize(); i++) {
                UnoCard card = player.getPlayerHand().get(i);
                if (card.getColor() == playedCard.getColor()) {
                    player.getPlayerHand().remove(i);
                    System.out.println(player.getPlayerName() + " disacrds " + card);
                }
            }
        }
    }

    @Override
    public String toString() {
        return color + " Discard All";

    }
}
