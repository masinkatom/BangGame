package sk.stuba.fei.uim.oop.cards.browncard;

import java.util.ArrayList;
import java.util.LinkedList;

import sk.stuba.fei.uim.oop.Card;
import sk.stuba.fei.uim.oop.Player;
import sk.stuba.fei.uim.oop.cards.BrownCard;

public class Missed extends BrownCard{

    public Missed() {
        super("Vedla");
    }

    @Override
    public void play(Player currPlayer, ArrayList<Player> targetPlayers, LinkedList<Card> deck) {
        System.out.println("Tato karta sa neda zahrat!");
    }

    
    
}
