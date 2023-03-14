package sk.stuba.fei.uim.oop;

import java.util.ArrayList;

public class Player {
    private int id;
    private String name;
    private ArrayList<Card> cards;
    private int lives;

    public Player(int id, String name, int lives) {
        this.id = id;
        this.name = name;
        this.cards = new ArrayList<>();
        this.lives = lives;
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
    }

    public void recieveCard(Card card){
        this.cards.add(card);
    }
    
}
