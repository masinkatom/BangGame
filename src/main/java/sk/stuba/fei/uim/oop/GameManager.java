package sk.stuba.fei.uim.oop;

import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;

import sk.stuba.fei.uim.oop.cards.BlueCard;
import sk.stuba.fei.uim.oop.cards.bluecard.Barrel;
import sk.stuba.fei.uim.oop.cards.bluecard.Dynamite;
import sk.stuba.fei.uim.oop.cards.bluecard.Prison;
import sk.stuba.fei.uim.oop.cards.browncard.Bang;
import sk.stuba.fei.uim.oop.cards.browncard.CatBalou;
import sk.stuba.fei.uim.oop.cards.browncard.Stagecoach;
import sk.stuba.fei.uim.oop.cards.browncard.Indians;
import sk.stuba.fei.uim.oop.cards.browncard.Beer;
import sk.stuba.fei.uim.oop.cards.browncard.Missed;
import sk.stuba.fei.uim.oop.utility.ZKlavesnice;

public class GameManager {

    private ArrayList<Player> players;
    private LinkedList<Card> deck;
    private Player currPlayer;

    public GameManager() {

        System.out.println("Vitaj v hre BANG!\n");
        int playerCount = ZKlavesnice.readInt("Zadaj pocet hracov tejto hry (2-4): ");
        while (playerCount < 2 || playerCount > 4) {
            playerCount = ZKlavesnice.readInt("\n! Nespravny pocet hracov!\n\nZadaj pocet hracov tejto hry (2-4): ");
        }

        this.players = new ArrayList<>(playerCount);

        for (int i = 0; i < playerCount; i++) {
            players.add(new Player(i, ZKlavesnice.readString("Zadaj meno hraca " + (i + 1) + ": ")));
        }
        this.startPLaying();

    }

    private void startPLaying() {
        this.getHorizontalLine();
        System.out.println("\n...hra sa zacina");
        System.out.println("\n...rozdavanie kariet\n");

        this.initDeck();
        this.giveCards();

        currPlayer = players.get(0);
        while (players.size() > 1) {
            if (!currPlayer.isAlive()) {
                currPlayer = this.nextPlayer();
                players.remove(currPlayer);
            }
            this.playTurn();
            currPlayer = this.nextPlayer();

            this.getHorizontalLine();
            ZKlavesnice.readString("STLAC NEJAKU KLAVESU a ENTER PRE ZACATIE KOLA");
            this.getHorizontalLine();
        }
        // TODO VITAZOM HRY JE ...

    }

    private void initDeck() {
        this.deck = new LinkedList<Card>() {

        };
        for (int i = 0; i < 30; i++) {
            deck.add(new Bang());
        }

        for (int i = 0; i < 15; i++) {
            deck.add(new Missed());
        }

        for (int i = 0; i < 8; i++) {
            deck.add(new Beer());
        }

        for (int i = 0; i < 6; i++) {
            deck.add(new CatBalou());
        }

        for (int i = 0; i < 4; i++) {
            deck.add(new Stagecoach());
        }

        for (int i = 0; i < 2; i++) {
            deck.add(new Indians());
            deck.add(new Barrel());
        }

        for (int i = 0; i < 3; i++) {
            deck.add(new Prison());
        }

        deck.add(new Dynamite());

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
        Player currP = this.currPlayer;
        this.getHorizontalLine();
        System.out.println("Na tahu je " + this.currPlayer.getName() + ".");
        this.getHorizontalLine(); // TODO DOROBIT

        this.playOnTable();

        if (currP != this.currPlayer) {
            return;
        }

        this.giveTwoCards();
        System.out.println("Boli ti pridane 2 karty");

        boolean endRound = false;

        while (!endRound && currPlayer.isAlive() && players.size() > 1) {
            String[] playerInput = parseTurnInput();
            switch (playerInput[0]) {
                case "h": {
                    currPlayer.getCards().get(Integer.parseInt(playerInput[1])).play(this.currPlayer, players,
                            this.deck);
                    break;
                }
                case "o": { // TODO odhadzovanie az v tretej faze
                    deck.add(currPlayer.getCards().remove(Integer.parseInt(playerInput[1])));
                    break;
                }
                case "": {
                    if (!currPlayer.checkCardAmount()) {
                        System.out.println("Pocet tvojich kariet prevysuje tvoj pocet zivotov!\n\tZahod nejake karty!");
                        break;
                    }
                    this.getHorizontalLine();
                    System.out.println("Koniec kola");
                    this.getHorizontalLine();
                    endRound = true;
                    break;
                }
                default: {
                    break;
                }
                // TODO Alex Tapsak virginia
            }
        }
    }

    private void giveTwoCards() {
        for (int i = 0; i < 2; i++) {
            currPlayer.recieveCard(deck.remove());
        }

    }

    private String[] parseTurnInput() {
        String[] in;
        try {
            do {
                this.getHorizontalLine();
                System.out.println("Tvoje karty: " + currPlayer.getCardsPrint(true));
                this.getHorizontalLine();

                in = ZKlavesnice.readString("Hraj (h) alebo odhod (o) n-tu kartu (napr. h 3)\nEnter - Koniec kola")
                        .split(" ");
                if (in[0].equals("") && in.length == 1)
                    return in;
            } while (in.length != 2 || Integer.parseInt(in[1]) > currPlayer.getCards().size()
                    || Integer.parseInt(in[1]) < 1);

            in[1] = Integer.toString(Integer.parseInt(in[1]) - 1);

        } catch (NumberFormatException e) {
            System.out.println("Zly vstup, zadavaj este raz");
            in = parseTurnInput();
        }

        return in;
    }

    public void playOnTable() {

        for (Card card : this.currPlayer.getCardsOnTable()) {

            this.currPlayer = ((BlueCard) card).play(this.currPlayer, deck, players);

        } // TODO DOROBIT
    }

    private void getHorizontalLine(){
        System.out.println("\n--------------------------------\n");
    }

}
