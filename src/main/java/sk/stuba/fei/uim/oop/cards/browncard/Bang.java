package sk.stuba.fei.uim.oop.cards.browncard;

import java.util.LinkedList;

import sk.stuba.fei.uim.oop.Card;
import sk.stuba.fei.uim.oop.Player;
import sk.stuba.fei.uim.oop.cards.BrownCard;
import sk.stuba.fei.uim.oop.cards.bluecard.Barrel;

public class Bang extends BrownCard{

    public Bang() {
        super("BANG");
    }

    @Override
    public void play(Player currPlayer, Player targetPlayer, LinkedList<Card> deck) {
        if(checkForDefense(targetPlayer)){
            // pridaj logiku
            System.out.println("SUPER");
        }

        
        super.play(currPlayer, targetPlayer, deck);
    }

    private boolean checkForDefense(Player targetPlayer){
        for (Card card : targetPlayer.getCards()) {
            if (card instanceof Barrel){
                if(((Barrel)card).isOnTable()){
                    return true;
                }
            }
        }
        return false;
    }

    

    

    
}
