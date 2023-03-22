package sk.stuba.fei.uim.oop;

import java.util.ArrayList;
import java.util.LinkedList;

public abstract class Card {
    private String name;

    public Card(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return this.name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void play(Player currPlayer, ArrayList<Player> targetPlayers, LinkedList<Card> deck){  
        throwCard(currPlayer, deck);
    }

    public void throwCard(Player player, LinkedList<Card> deck){
        System.out.println("Bola vyhodena karta " + this.getName());
        player.getCards().remove(this);
        deck.add(this);
    }

    public String getPlayersPrint(Player currPlayer, ArrayList<Player> targetPlayers){
        String out = "[";
        int i = 0;
        for (Player player : targetPlayers) {
            if (player != currPlayer){
                out += ((i+1) + " > " + player.getName());
                out += (", zivoty: " + player.getLives());
                if (i < targetPlayers.size()-1){
                    out += " | ";   
                }
            }
            
            i++;
        }

        out += "]";
        return out;
    }
    
}

