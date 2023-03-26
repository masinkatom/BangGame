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

    public abstract Player play(Player player, LinkedList<Card> deck, ArrayList<Player> targetPlayers);
    
    public boolean alreadyOnTable(Player player){
        for (Card card : player.getCardsOnTable()) {
            if (card.getName().equals(this.getName())){
                return true;
            }
        }
        return false;
    }
    
}
