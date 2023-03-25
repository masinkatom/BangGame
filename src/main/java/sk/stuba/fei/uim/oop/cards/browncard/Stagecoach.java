package sk.stuba.fei.uim.oop.cards.browncard;

import java.util.ArrayList;
import java.util.LinkedList;

import sk.stuba.fei.uim.oop.Card;
import sk.stuba.fei.uim.oop.Player;
import sk.stuba.fei.uim.oop.cards.BrownCard;

public class Stagecoach extends BrownCard{

    public Stagecoach() {
        super("Dostavnik");
    }

    @Override
    public void play(Player currPlayer, ArrayList<Player> targetPlayers, LinkedList<Card> deck) {
        currPlayer.recieveCard(deck.remove());
        currPlayer.recieveCard(deck.remove());
        super.play(currPlayer, targetPlayers, deck);
    }

    
    
}
