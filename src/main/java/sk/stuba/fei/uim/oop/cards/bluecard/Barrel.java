package sk.stuba.fei.uim.oop.cards.bluecard;

import java.util.ArrayList;
import java.util.LinkedList;

import sk.stuba.fei.uim.oop.Card;
import sk.stuba.fei.uim.oop.Player;
import sk.stuba.fei.uim.oop.cards.BlueCard;

public class Barrel extends BlueCard{

    public Barrel() {
        super("Barrel");
    }

    @Override
    public void play(Player currPlayer, ArrayList<Player> targetPlayers, LinkedList<Card> deck) {
        // TODO osetrit pridanie druhej karty barrel (v BlueCard asi)
        this.setOnTable(true);
        
    }

    


    
}
