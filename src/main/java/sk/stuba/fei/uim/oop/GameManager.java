package sk.stuba.fei.uim.oop;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Stack;

import sk.stuba.fei.uim.oop.cards.bluecard.Barrel;
import sk.stuba.fei.uim.oop.cards.bluecard.Dynamit;
import sk.stuba.fei.uim.oop.cards.bluecard.Vazenie;
import sk.stuba.fei.uim.oop.cards.browncard.Bang;
import sk.stuba.fei.uim.oop.cards.browncard.CatBalou;
import sk.stuba.fei.uim.oop.cards.browncard.Dostavnik;
import sk.stuba.fei.uim.oop.cards.browncard.Indiani;
import sk.stuba.fei.uim.oop.cards.browncard.Pivo;
import sk.stuba.fei.uim.oop.cards.browncard.Vedla;
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
            players.add(new Player(i, ZKlavesnice.readString("Zadaj meno hraca "+(i+1)+": "), 4));
        }
        this.startPLaying();
        
    }

    public ArrayList<Player> getPlayers() {
        return players;
    }

    private void startPLaying(){
        
        try {
            System.out.println("\n...hra sa zacina");
            Thread.sleep(200);
            System.out.println("\n...rozdavanie kariet");
            Thread.sleep(200);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        this.initDeck();
        this.giveCards();
        
        // TODO

        
        System.out.println();
  
    }
    
    private void initDeck(){
        deck = new Stack<>();
        for (int i = 0; i < 30; i++) {
            deck.push(new Bang());
        }

        for (int i = 0; i < 15; i++) {
            deck.push(new Vedla());
        }

        for (int i = 0; i < 8; i++) {
            deck.push(new Pivo());
        }

        for (int i = 0; i < 6; i++) {
            deck.push(new CatBalou());
        }

        for (int i = 0; i < 4; i++) {
            deck.push(new Dostavnik());
        }

        for (int i = 0; i < 2; i++) {
            deck.push(new Indiani());
            deck.push(new Barrel());
        }

        for (int i = 0; i < 3; i++) {
            deck.push(new Vazenie());
        }

        deck.push(new Dynamit());

        Collections.shuffle(deck);
        
    }

    private void giveCards(){
        for (Player player : players) {
            for (int i = 0; i < 4; i++) {
                player.recieveCard(deck.pop());
            }
        }
    }
    
}

