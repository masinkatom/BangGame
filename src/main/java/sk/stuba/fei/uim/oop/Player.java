package sk.stuba.fei.uim.oop;

import java.util.ArrayList;

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
        System.out.println("Hrac "+ this.getName() + ", zivoty: " + this.getLives());
    }

    public void recieveCard(Card card){
        this.cards.add(card);
    }
    
    public boolean isAlive(){
        if (this.getLives() < 1){
            return false;
        }
        return true;
    }

    public boolean checkCardAmount(){
        if (this.cards.size() >= this.getLives()){
            return false;
        }
        return true;
    }

    public String getCardsPrint(){
        String out = "[";
        for (int i = 0; i < this.cards.size(); i++) {
            out += ((i+1) + " > " + this.cards.get(i));
            if (i < this.cards.size()-1){
                out += " | ";   
            }
        }
        out += "]";
        return out;
    }

    // mode: true - increase lives, false - decrease lives
    public void changeLives(boolean mode, int amount){
        if (mode){
            this.setLives(this.getLives()+amount);
            return;
        }
        this.setLives(this.getLives()-amount);
    }
}
