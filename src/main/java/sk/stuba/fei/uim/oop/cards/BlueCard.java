package sk.stuba.fei.uim.oop.cards;

import java.util.ArrayList;
import java.util.LinkedList;

import sk.stuba.fei.uim.oop.Card;
import sk.stuba.fei.uim.oop.Player;

public abstract class BlueCard extends Card{
    private boolean onTable;

    public BlueCard(String name) {
        super(name);
        this.onTable = false;
    }

    public boolean isOnTable() {
        return onTable;
    }

    public void setOnTable(boolean onTable) {
        this.onTable = onTable;
    }

    @Override
    public String toString() {
        if (this.isOnTable()) return this.getName() + " (Na stole)";
        return this.getName();
    }

    @Override
    public void throwCard(Player player, LinkedList<Card> deck) {
        if (this.isOnTable()){
            this.setOnTable(false);
        }
        super.throwCard(player, deck);
    }

    /**
     * @return 
     * <p>0 - barrel unsuccessful/ prison draw success/ dynamite exploded</p>
     * <p>1 - barrel successful </p>
     * <p>2 - prison draw unsuccessful </p>
     * <p>3 - dynamite not detonated </p>
     */
    public abstract int play(Player player, LinkedList<Card> deck, ArrayList<Player> targetPlayers);
    
    
}
