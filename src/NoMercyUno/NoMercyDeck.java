package NoMercyUno;

import UnoEngine.*;

import java.util.ArrayList;
import java.util.List;

public class NoMercyDeck extends UnoDeck {
    @Override
    public List<UnoCard> initializeDeck() {
        ArrayList<UnoCard> cards = new ArrayList<UnoCard>();

        for (Color color : Color.values()) {
            for (Value value: Value.values()) {
                switch (value) {
//                    the deck has 12 Skip cards
                    case SKIP: {
                        cards.add(new SkipActionCard(color));
                        cards.add(new SkipActionCard(color));
                        cards.add(new SkipActionCard(color));
                    }
//                    the deck has 12 Reverse cards
                    case REVERSE: {
                        cards.add(new ReverseActionCard(color));
                        cards.add(new ReverseActionCard(color));
                        cards.add(new ReverseActionCard(color));
                    }
//                    the deck has 12 Discard All cards
                    case DISCARD_ALL: {
                        cards.add(new DiscardAllCard(color));
                        cards.add(new DiscardAllCard(color));
                        cards.add(new DiscardAllCard(color));
                    }
//                   the deck has 8 Wild cards
                    case WILD: {
                        cards.add(new WildUnoCard());
                        cards.add(new WildUnoCard());
                    }
//                    the deck has 8 Draw 2 cards and 8 Draw 4 cards
                    case DRAW: {
                        cards.add(new DrawCard(color, 2));
                        cards.add(new DrawCard(color, 2));
                        cards.add(new DrawCard(color, 4));
                        cards.add(new DrawCard(color, 4));
                    }
//                    the deck has 4 Wild Draw 6 cards and 4 Wild Draw 10 cards
                    case WILD_DRAW: {
                        cards.add(new WildDrawCard(6));
                        cards.add(new WildDrawCard(10));
                    }
//                    the deck has 8 Skip Everyone cards
                    case SKIP_EVERYONE: {
                        cards.add(new SkipEveryoneCard(color));
                        cards.add(new SkipEveryoneCard(color));
                    }
//                    the deck has 8 Wild Reverse Draw 4 cards
                    case WILD_REVERSE_DRAW_FOUR: {
                        cards.add(new WildReverseDrawFourCard());
                        cards.add(new WildReverseDrawFourCard());
                    }
//                    the deck has 8 Wild Roulette cards
                    case WILD_ROULETTE: {
                        cards.add(new WildColorRouletteCard());
                        cards.add(new WildColorRouletteCard());
                    }
//                    adding the numbered carded
                    default: {
                        cards.add(new NoMercyOrdinaryCard(color, value));
                        cards.add(new NoMercyOrdinaryCard(color, value));
                    }
                }
            }
        }

        return cards;
    }


}
