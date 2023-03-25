package sk.stuba.fei.uim.oop;

import java.util.ArrayList;

import sk.stuba.fei.uim.oop.cards.BlueCard;
import sk.stuba.fei.uim.oop.cards.BrownCard;

public class Player {
    private int id;
    private String name;
    private ArrayList<Card> cards;
    private int lives;

    public Player(int id, String name) {
        this.id = id;
        this.name = name;
        this.cards = new ArrayList<>();
        this.lives = 4;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public ArrayList<Card> getCards() {
        return cards;
    }

    public void setCards(ArrayList<Card> cards) {
        this.cards = cards;
    }

    public int getLives() {
        return lives;
    }

    public void setLives(int lives) {
        this.lives = lives;
        System.out.println("Hrac " + this.getName() + ", zivoty: " + this.getLives());
    }

    public void recieveCard(Card card) {
        this.cards.add(card);
    }

    public boolean isAlive() {
        if (this.getLives() < 1) {
            return false;
        }
        return true;
    }

    public boolean checkCardAmount() {
        if (this.cards.size() >= this.getLives()) {
            return false;
        }
        return true;
    }

    // mode: true - print all cards, false - hide cards which are not on table
    public String getCardsPrint(boolean mode) {
        String out = "[";
        int i = 0;

        for (Card card : this.cards) {
            if (!mode && card instanceof BrownCard){
                out += ((i + 1) + " > " + "<Karta na ruke>");
            }

            else if (!mode && card instanceof BlueCard){
                if (!((BlueCard) card).isOnTable()){
                    out += ((i + 1) + " > " + "<Karta na ruke>");
                }
            }

            else out += ((i + 1) + " > " + card);
            
            if (i < this.cards.size() - 1) {
                out += " | ";
            }
            i++;
        }

        out += "]";
        return out;
    }

    // mode: true - increase lives, false - decrease lives
    public void changeLives(boolean mode, int amount) {
        if (this.isAlive()) {
            if (mode) {
                this.setLives(this.getLives() + amount);
                return;
            }
            this.setLives(this.getLives() - amount);
        }

    }
}
