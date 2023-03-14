package sk.stuba.fei.uim.oop;

import java.util.ArrayList;
import java.util.Stack;

import sk.stuba.fei.uim.oop.cards.Card;
import sk.stuba.fei.uim.oop.utility.ZKlavesnice;

public class GameManager {

    private ArrayList <Player> players;
    private Stack <Card> deck;

    public GameManager() {

        System.out.println("Vitaj v hre BANG!\n");
        int playerCount = ZKlavesnice.readInt("Zadaj pocet hracov tejto hry (2-4): ");
        while(playerCount < 2 || playerCount > 4){
            playerCount = ZKlavesnice.readInt("\nNespravny pocet hracov!\n\nZadaj pocet hracov tejto hry (2-4): ");
        }
        this.players = new ArrayList<>(playerCount);
        for (int i = 0; i < playerCount; i++) {
            players.add(new Player(i, ZKlavesnice.readString("Zadaj meno hraca "+(i+1)+": "), null, null));
        }
        this.startPLaying();
        

    }

    public ArrayList<Player> getPlayers() {
        return players;
    }

    private void startPLaying(){
        
        try {
            System.out.println("...hra sa zacina");
            Thread.sleep(100);
            System.out.println("...rozdavanie kariet");
            Thread.sleep(100);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        this.initCards();
        
        System.out.println();
  
    }
    
    private void initCards(){
        deck = new Stack<>();
        for (int i = 0; i < 30; i++) {
            deck.push(null);
        }
    }
    
}
