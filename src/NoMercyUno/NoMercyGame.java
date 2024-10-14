package NoMercyUno;

import UnoEngine.*;

public class NoMercyGame extends Game {
    @Override
    protected boolean isGameOver() {
//        if all players are excluded but one, the game is over and he/she is the winner
        if (gameManager.getPlayers().size() == 1) {
            Player player = gameManager.getPlayers().get(0);
            System.out.println();
            System.out.println("The game is over " + player.getPlayerName() + " won!");
            return true;
        }
//        if a player discard all of his/her cards, he/she wins and the game is over
        for (Player player: gameManager.getPlayers()) {
            if (player.getPlayerHand().size() == 0) {
                System.out.println();
                System.out.println("The game is over " + player.getPlayerName() + " won!");
                return true;
            }
        }
//        return false if there is no winner yet
        return false;
    }
//        return the deck that accompany the No Mercy Varaiation
    @Override
    protected UnoDeck createDeck() {
        return new NoMercyDeck();
    }
    @Override
    public void play() {
        startGame();

        dealCards(7);

        Player currentPlayer;

        while (!isGameOver()) {
            currentPlayer = gameManager.getNextPlayer();

            performPlayerTurn(currentPlayer);
//            the player is excluded once he has a 25 cards or more
            if (currentPlayer.getHandSize() >= 25) {
                gameManager.removePlayer(currentPlayer);
                System.out.println(currentPlayer.getPlayerName() + " is out of the game!");
            }

            gameManager.updateNextPlayer();
        }
    }

    @Override
    protected void performPlayerTurn(Player player) {
        UnoCard chosenCard;
        int numTrails = 5;

        for (int i = 0; i < numTrails; i++) {

//       Stacking Rule: combine and stack draw penalties of the same type
            if (isDrawCard(gameManager.getTopCardInPile())) {
                System.out.println();
                System.out.println("Select a Draw card to accumulate penalty!");
                chosenCard = player.chooseACard(gameManager.getTopCardInPile());
                if (!chosenCard.isPlaceableOnTop(gameManager.getTopCardInPile())) {
                    player.notifyNotAcceptableCard(chosenCard);
                    continue;
                }
                if (!isDrawCard(chosenCard)) dealPenaltyCards(player);
            } else {
                dealPenaltyCards(player);
                chosenCard = player.chooseACard(gameManager.getTopCardInPile());
            }
//       verifying a proper card choose
            if (chosenCard == null) {
                player.addCardToHand(deck.pullACard());
                return;
            } else if (chosenCard.isPlaceableOnTop(gameManager.getTopCardInPile())) {
                player.removeCardFromHand(chosenCard);
                deck.addCardToPile(chosenCard);
                chosenCard.performAction(gameManager);
                gameManager.setTopCardInPile(chosenCard);
                return;
            } else {
                player.notifyNotAcceptableCard(chosenCard);
            }
        }
    }
//     return true if card inflict draw penalty upon the next player
    private boolean isDrawCard(UnoCard card) {
        if (card instanceof DrawCard | card instanceof WildDrawCard | card instanceof WildReverseDrawFourCard)
            return true;
        else
            return false;
    }
}
