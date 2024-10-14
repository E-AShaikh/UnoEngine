package NoMercyUno;

import UnoEngine.*;

public class SkipEveryoneCard extends OrdinaryCard {
    public SkipEveryoneCard(Color color) {
        super(color, Value.SKIP_EVERYONE);
    }
//   allows player to skip all players and choose again
    @Override
    public void performAction(UnoGameManager gameManager) {
        int numPlayers = gameManager.getPlayers().size();
        for (int i = 0; i < numPlayers - 1; i++) {
            gameManager.updateNextPlayer();
        }

    }

    @Override
    public String toString() {
         return color + " Skip Everyone";
    }
}
