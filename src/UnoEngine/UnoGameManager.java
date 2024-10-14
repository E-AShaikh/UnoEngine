package UnoEngine;

import java.util.ArrayList;

public class UnoGameManager {
    protected int nextPlayerOrder;
    protected boolean isReversed;
    protected ArrayList<Player> players;
    protected int numExtraCardDraw = 0;
    protected UnoCard topCardInPile;

    public UnoGameManager() {
        this.nextPlayerOrder = 0;
        this.isReversed = false;
        this.numExtraCardDraw = 0;
        this.players = new ArrayList<Player>();
    }
//    add one to the player order if it's not reversed and -1 otherwise
    public void updateNextPlayer() {
        if (!isReversed) {
            nextPlayerOrder++;
        }
        else {
            nextPlayerOrder--;
        }

        while (nextPlayerOrder < 0) {
            nextPlayerOrder += players.size();
        }
    }
//     reverse the order of play
    public void reverseOrder() {
        isReversed = !isReversed;
    }
//     add to card penalty that will be inflicted on the next player.
    public void addExtraCardDraw(int numExtraCard) {
        this.numExtraCardDraw += numExtraCard;
    }
//   return a list of players
    public ArrayList<Player> getPlayers() {
        return players;
    }
//    return the next player
    public Player getNextPlayer() {
        return players.get(nextPlayerOrder % players.size());
    }

//    return the number of cards that the next player will be penalised of
    public int getNumExtraCardDraw() {
        return numExtraCardDraw;
    }
//    set the number of cards that the next player will be penalised of
    public void setNumExtraCardDraw(int numExtraCardDraw) {
        this.numExtraCardDraw = numExtraCardDraw;
    }
//    return the top card in discarded Pile
    public UnoCard getTopCardInPile() {
        return topCardInPile;
    }
    public void setTopCardInPile(UnoCard topCardInPile) {
        this.topCardInPile = topCardInPile;
    }
//    remove player from the game
    public void removePlayer(Player player){
        players.remove(player);
    }
//    add player to the game
    public void addPlayer(Player player){
        players.add(player);
    }

}

