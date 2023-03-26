package sk.stuba.fei.uim.oop.cards.browncard;

import java.util.ArrayList;
import java.util.LinkedList;

import sk.stuba.fei.uim.oop.Card;
import sk.stuba.fei.uim.oop.Player;
import sk.stuba.fei.uim.oop.cards.BrownCard;

public class Indians extends BrownCard{

    public Indians() {
        super("Indiani");
    }

    @Override
    public void play(Player currPlayer, ArrayList<Player> targetPlayers, LinkedList<Card> deck) {
        super.play(currPlayer, targetPlayers, deck);

        targetPlayers = findTargets(currPlayer, targetPlayers);
        for (Player player : targetPlayers) {

            Bang banger = this.checkForBang(player);
            if (banger != null) {
                banger.throwCard(player, deck);
            }
            else {
                boolean dead = player.changeLives(false, 1);
                if(dead){
                    kickPLayer(player, targetPlayers, deck);
                }
            }
            
        }
        
    }

    public ArrayList<Player> findTargets(Player currPlayer, ArrayList<Player> targetPlayers) {
        ArrayList <Player> cpyTargetPlayers = new ArrayList<>();
        cpyTargetPlayers.addAll(targetPlayers);
        cpyTargetPlayers.remove(currPlayer);
        return cpyTargetPlayers;
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
