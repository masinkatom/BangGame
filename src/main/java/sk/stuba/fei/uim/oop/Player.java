package sk.stuba.fei.uim.oop;

import java.util.ArrayList;

import sk.stuba.fei.uim.oop.Karty.Card;

public class Player {
    private int id;
    private String name;
    private ArrayList<Card> cardsTable;
    private ArrayList<Card> cardsHands;

    
    public Player(int id, String name, ArrayList<Card> cardsTable, ArrayList<Card> cardsHands) {
        this.id = id;
        this.name = name;
        this.cardsTable = cardsTable;
        this.cardsHands = cardsHands;
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
    public ArrayList<Card> getCardsTable() {
        return cardsTable;
    }
    public void setCardsTable(ArrayList<Card> cardsTable) {
        this.cardsTable = cardsTable;
    }
    public ArrayList<Card> getCardsHands() {
        return cardsHands;
    }
    public void setCardsHands(ArrayList<Card> cardsHands) {
        this.cardsHands = cardsHands;
    }

}

