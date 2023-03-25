package sk.stuba.fei.uim.oop.cards.bluecard;

import java.util.ArrayList;
import java.util.LinkedList;

import sk.stuba.fei.uim.oop.Card;
import sk.stuba.fei.uim.oop.Player;
import sk.stuba.fei.uim.oop.cards.BlueCard;

public class Prison extends BlueCard{

    public Prison() {
        super("Vazenie");
    }

    @Override
    public void play(Player currPlayer, ArrayList<Player> targetPlayers, LinkedList<Card> deck) {
        
        super.play(currPlayer, targetPlayers, deck);
    }
    
    

}
