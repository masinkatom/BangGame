package sk.stuba.fei.uim.oop;

import java.util.ArrayList;
import java.util.Comparator;

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
        this.lives = 1;
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

    public void recieveCard(Card card) {
        this.cards.add(card);
    }

    public void removeCard(Card card){
        this.cards.remove(card);  
    }

    public boolean isAlive() {
        if (this.getLives() < 1) {
            return false;
        }
        return true;
    }

    /**
     * @return False if player has more cards than lives, True otherwise
     */
    public boolean checkCardAmount() {
        if ((this.cards.size() - this.getCardsOnTable().size()) > this.getLives()) {
            return false;
        }
        return true;
    }

    /**
     * @param mode true - print all cards, false - hide cards which are not on table
     */
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

    /**
     * @param mode true - increase lives, false - decrease lives
     */
    public boolean changeLives(boolean mode, int amount) {
        if (this.isAlive()) {
            if (mode) {
                this.setLives(this.getLives() + amount);
                System.out.println("Hrac " + this.getName() + ", zivoty: " + this.getLives());
                return false;
            }
            this.setLives(this.getLives() - amount);
            System.out.println("Hrac " + this.getName() + ", zivoty: " + this.getLives());

            if(this.getLives() <= 0){
                this.setLives(0);
                System.out.println("\n! Hrac '" + this.getName() + "' zomrel :( !");
                return true;
            }
        }
        return false;
        

    }

    public ArrayList<Card> getCardsOnTable(){
        ArrayList<Card> cardsOnTable = new ArrayList<>();
        for (Card card : this.cards) {
            if (card instanceof BlueCard){
                if (((BlueCard)card).isOnTable()){
                    cardsOnTable.add(card);
                }
            }
        }
        cardsOnTable.sort(new Comparator<Card>() {
            @Override
            public int compare(Card o1, Card o2) {
                return o1.getName().compareTo(o2.getName());
            };
        });

        return cardsOnTable;
    }

}
