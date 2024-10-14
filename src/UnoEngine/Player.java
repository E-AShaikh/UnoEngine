package UnoEngine;

import java.util.ArrayList;

public abstract class Player {
    protected ArrayList<UnoCard> playerHand;
    protected String playerName;
    protected Player(String name) {
        this.playerName = name;
        this.playerHand = new ArrayList<UnoCard>();
    }
//   the central methods that should implement the logic of choosing card each turn
    public abstract UnoCard chooseACard(UnoCard topCardInPile);
//    return player name
    public String getPlayerName() {
        return playerName;
    }
//    return player hand during the game
    public ArrayList<UnoCard> getPlayerHand() {
        return playerHand;
    }
//    add a card to the player's hand
    public void addCardToHand(UnoCard card) {
        playerHand.add(card);
        System.out.println(playerName + " drew a card and now has " + playerHand.size() + " card(s).");
    }
//    remove a card from the player's hand
    public void removeCardFromHand(UnoCard card) {
        playerHand.remove(card);
        if (playerHand.size() == 1)
            System.out.println("UNO!");
    }

//    called when the player choose not suitable card
    public void notifyNotAcceptableCard(UnoCard suggestedCard) {
        System.out.println("Your last card, " + suggestedCard + ", was invalid and " +
                "not playable.  It must match either the color or the value or be a " +
                "wild card.");
    }
//      return true if the player has a playable card, false otherwise
    public boolean hasPlayableCard(UnoCard topCardInPile) {
        for (UnoCard card: playerHand)
            if(card.isPlaceableOnTop(topCardInPile)) return true;

        return false;
    }

    public void setPlayerHand(ArrayList<UnoCard> playerHand) {
        this.playerHand = playerHand;
    }

    public int getHandSize() {
        return playerHand.size();
    }
}


