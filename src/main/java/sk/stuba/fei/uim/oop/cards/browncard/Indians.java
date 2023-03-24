package sk.stuba.fei.uim.oop.cards.browncard;

import java.util.ArrayList;
import java.util.LinkedList;

import sk.stuba.fei.uim.oop.Card;
import sk.stuba.fei.uim.oop.Player;
import sk.stuba.fei.uim.oop.cards.BrownCard;
import sk.stuba.fei.uim.oop.cards.bluecard.Barrel;

public class Indians extends BrownCard{

    public Indians() {
        super("Indiani");
    }

    @Override
    public void play(Player currPlayer, ArrayList<Player> targetPlayers, LinkedList<Card> deck) {
        targetPlayers = findTarget(currPlayer, targetPlayers);
        for (Player player : targetPlayers) {

            Bang banger = this.checkForBang(player);
            if (banger != null) {
                banger.throwCard(player, deck);
            }
            else player.changeLives(false, 1);
            
            
        }
        super.play(currPlayer, targetPlayers, deck);
    }

    @Override
    public ArrayList<Player> findTarget(Player currPlayer, ArrayList<Player> targetPlayers) {
        targetPlayers.remove(currPlayer);
        return targetPlayers;
    }

    private Bang checkForBang(Player targetPlayer) {
        for (Card card : targetPlayer.getCards()) {
            if (card instanceof Bang) {
                return (Bang) card;
            }
        }

        return null;
    }

    
    
}
