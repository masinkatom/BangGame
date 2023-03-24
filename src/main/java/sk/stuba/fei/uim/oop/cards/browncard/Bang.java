package sk.stuba.fei.uim.oop.cards.browncard;

import java.util.ArrayList;
import java.util.LinkedList;

import sk.stuba.fei.uim.oop.Card;
import sk.stuba.fei.uim.oop.Player;
import sk.stuba.fei.uim.oop.cards.BrownCard;
import sk.stuba.fei.uim.oop.cards.bluecard.Barrel;

public class Bang extends BrownCard {

    public Bang() {
        super("BANG");
    }

    @Override
    public void play(Player currPlayer, ArrayList<Player> targetPlayers, LinkedList<Card> deck) {
        targetPlayers = this.findTarget(currPlayer, targetPlayers);
        for (Player player : targetPlayers) {
            boolean saved  = false;
            Barrel barrel = this.checkForBarrel(player);
            
            if (barrel != null) {
                saved = barrel.play(player);    
            }

            if(!saved){
                Missed missed = this.checkForMissed(player);
                if (missed != null) {
                    missed.throwCard(player, deck);
                }
                else player.changeLives(false, 1);
            }
            
        }
        super.play(currPlayer, targetPlayers, deck);
    }

    private Barrel checkForBarrel(Player targetPlayer) {
        for (Card card : targetPlayer.getCards()) {
            if (card instanceof Barrel) {
                if (((Barrel) card).isOnTable()) {
                    return (Barrel) card;
                }
            }
        }

        return null;
    }

    private Missed checkForMissed(Player targetPlayer) {
        for (Card card : targetPlayer.getCards()) {
            if (card instanceof Missed) {
                return (Missed) card;
            }
        }

        return null;
    }

    

}
