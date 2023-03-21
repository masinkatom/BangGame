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
        System.out.println("card class here");
        currPlayer.getCards().remove(this);
    }
    
}

