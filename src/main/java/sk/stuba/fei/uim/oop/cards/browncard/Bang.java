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
        super.play(currPlayer, targetPlayers, deck);
        
        Player target = findTarget(currPlayer, targetPlayers);
        int saved = 0;
        Barrel barrel = this.checkForBarrel(target);
        
        if (barrel != null) {
            saved = barrel.play(target, deck, targetPlayers);
        }

        if(saved == 0){
            Missed missed = this.checkForMissed(target);
            if (missed != null) {
                missed.throwCard(target, deck);
            }
            else target.changeLives(false, 1);
        }
        
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
