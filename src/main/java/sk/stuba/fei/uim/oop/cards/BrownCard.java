package sk.stuba.fei.uim.oop.cards;

import java.util.ArrayList;

import sk.stuba.fei.uim.oop.Card;
import sk.stuba.fei.uim.oop.Player;

public abstract class BrownCard extends Card{

    public BrownCard(String name) {
        super(name);
    }
    
    public String getPlayersPrint(ArrayList<Player> targetPlayers){
        String out = "[";
        for (int i = 0; i < targetPlayers.size(); i++) {
            out += ((i+1) + " > " + targetPlayers.get(i).getName());
            if (i < targetPlayers.size()-1){
                out += " | ";   
            }
        }
        out += "]";
        return out;
    }
    
}
