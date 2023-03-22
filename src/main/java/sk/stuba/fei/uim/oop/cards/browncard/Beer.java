package sk.stuba.fei.uim.oop.cards.browncard;

import java.util.ArrayList;
import java.util.LinkedList;

import sk.stuba.fei.uim.oop.Card;
import sk.stuba.fei.uim.oop.Player;
import sk.stuba.fei.uim.oop.cards.BrownCard;

public class Beer extends BrownCard {

    public Beer() {
        super("Pivo");
    }

    @Override
    public void play(Player currPlayer, ArrayList<Player> targetPlayers, LinkedList<Card> deck) {
        currPlayer.changeLives(true, 1);
        super.play(currPlayer, targetPlayers, deck);
    }

    

    
    
    
}
