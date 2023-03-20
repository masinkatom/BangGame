package sk.stuba.fei.uim.oop;

import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;

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

    private ArrayList<Player> players;
    private LinkedList<Card> deck;
    private Player currPlayer;

    public GameManager() {

        System.out.println("Vitaj v hre BANG!\n");
        int playerCount = ZKlavesnice.readInt("Zadaj pocet hracov tejto hry (2-4): ");
        while (playerCount < 2 || playerCount > 4) {
            playerCount = ZKlavesnice.readInt("\nNespravny pocet hracov!\n\nZadaj pocet hracov tejto hry (2-4): ");
        }

        this.players = new ArrayList<>(playerCount);

        for (int i = 0; i < playerCount; i++) {
            players.add(new Player(i, ZKlavesnice.readString("Zadaj meno hraca " + (i + 1) + ": ")));
        }
        this.startPLaying();

    }

    public ArrayList<Player> getPlayers() {
        return players;
    }

    private void startPLaying() {

        try {
            System.out.println("\n...hra sa zacina");
            Thread.sleep(200);
            System.out.println("\n...rozdavanie kariet\n");
            Thread.sleep(200);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        this.initDeck();
        this.giveCards();

        currPlayer = players.get(0);
        while (players.size() > 1) {    // TODO UPRAVIT UKONCOVACIU PODMIENKU
            if (!currPlayer.isAlive()) {
               // TODO vratit karty do odhadzov. balicka v pripade smrti - a vyhodit hraca z arraylistu
               currPlayer = this.nextPlayer();
            }
            this.playTurn();
            currPlayer = this.nextPlayer();

            // TODO vymazat toto
            ZKlavesnice.readString("Cakam na input");
        }

    }


    private void initDeck() {
        this.deck = new LinkedList<Card>() {
            
        };
        for (int i = 0; i < 30; i++) {
            deck.add(new Bang());
        }

        for (int i = 0; i < 15; i++) {
            deck.add(new Vedla());
        }

        for (int i = 0; i < 8; i++) {
            deck.add(new Pivo());
        }

        for (int i = 0; i < 6; i++) {
            deck.add(new CatBalou());
        }

        for (int i = 0; i < 4; i++) {
            deck.add(new Dostavnik());
        }

        for (int i = 0; i < 2; i++) {
            deck.add(new Indiani());
            deck.add(new Barrel());
        }

        for (int i = 0; i < 3; i++) {
            deck.add(new Vazenie());
        }

        deck.add(new Dynamit());

        Collections.shuffle(deck);

    }

    private void giveCards() {
        for (Player player : players) {
            for (int i = 0; i < 4; i++) {
                player.recieveCard(deck.remove());
            }
        }
    }

    private Player nextPlayer() {
        if (this.currPlayer.getId() >= players.size() - 1) {
            return players.get(0);
        }
        return players.get(this.currPlayer.getId() + 1);
        
    }

    private void playTurn() {
        System.out.println("Na tahu je " + this.currPlayer.getName() + ".");
        this.giveTwoCards();
        System.out.println("Boli ti pridane 2 karty");
        
        boolean endRound = false;
        
        while (!endRound){
            System.out.println("\nTvoje karty: " + currPlayer.getCards());
            String [] playerInput = parseTurnInput();
            switch(playerInput[0]){
                case "h":{
                    currPlayer.getCards().get(Integer.parseInt(playerInput[1])).play(this.currPlayer, players.get(findTarget()),this.deck);
                    // TODO vymazat kartu hracovi po pouziti (mozno v classe Card)
                    break;
    
                }
                case "o":{
                    deck.add(currPlayer.getCards().remove(Integer.parseInt(playerInput[1])));
                    break;
                }
                case "":{
                    System.out.println("Koniec kola");
                    endRound = true;
                    break;
                }
                default: {
                    break;
                }
                
                //Alex Tapsak virginia
            }

        }

    }

    private void giveTwoCards(){
        for (int i = 0; i < 2; i++) {
            currPlayer.recieveCard(deck.remove());
        }
        
    }

    private String[] parseTurnInput(){
        String [] in;
        try{

            do {
                in = ZKlavesnice.readString("\nHraj (h) alebo odhod (o) n-tu kartu (napr. h 3)\nEnter - Koniec kola").split(" ");
                if(in[0].equals("") && in.length == 1) return in;
            }
            while (in.length != 2 || Integer.parseInt(in[1]) > currPlayer.getCards().size() || Integer.parseInt(in[1]) < 1);

            in[1] = Integer.toString(Integer.parseInt(in[1])-1);

        } catch (NumberFormatException e){
           System.out.println("Zly vstup, zadavaj este raz");
           in = parseTurnInput();
        }
        
        return in;
    }

    private int findTarget(){
        int playerNum;
        do {
            playerNum = ZKlavesnice.readInt("Na koho chces zahrat tuto kartu? (zadaj cislo hraca)");
        } while (playerNum > players.size() || playerNum < 1);
        
        return playerNum-1;
    }

}
