package UnoEngine;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public abstract class UnoDeck {
    private List<UnoCard> deckPile;
    private List<UnoCard> discardPile = new ArrayList<UnoCard>();;
    public UnoDeck() {
        deckPile = initializeDeck();
        Collections.shuffle(deckPile);
    }

    protected abstract List<UnoCard> initializeDeck();

//    Used to draw a card during the game, typically with each player turn
    public UnoCard pullACard() {
        if (deckPile.isEmpty()) refillDeck();

        UnoCard pulledCard =  deckPile.get(deckPile.size() - 1);
        deckPile.remove(deckPile.size() - 1);
        return pulledCard;
    }
//    add Cards to the discarded pile whenever they are drawn by a player
    public void addCardToPile(UnoCard card) {
        discardPile.add(card);
    }
//    refill the deck by appending the discard pile to the deck once the later is emptied
    private void refillDeck() {
        deckPile.addAll(discardPile);
        discardPile = new ArrayList<UnoCard>();
    }
}
