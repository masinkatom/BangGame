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

            if (players.size() < 2) {
                break;
            }

            this.getHorizontalLine();
            ZKlavesnice.readString("ZADAJ NEJAKY VSTUP PRE ZACATIE TAHU!");
            this.getHorizontalLine();
        }
        this.getHorizontalLine();
        System.out.println("VITAZOM HRY SA STAVA '" + currPlayer.getName() + "', gratulujem!");
        this.getHorizontalLine();
        System.exit(0);

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
        System.out.println("Na tahu je " + this.currPlayer.getName() + ", zivoty: " + this.currPlayer.getLives());
        this.getHorizontalLine();

        this.playOnTable();

        if (currP != this.currPlayer) {
            return;
        }

        this.giveTwoCards();
        System.out.println("Boli ti pridane 2 karty");

        boolean endRound = false;
        boolean phase = false;

        while (!endRound && currPlayer.isAlive() && players.size() > 1) {
            String[] playerInput = parseTurnInput(phase);
            switch (playerInput[0]) {
                case "h": {
                    currPlayer.getCards().get(Integer.parseInt(playerInput[1])).play(this.currPlayer, players,
                            this.deck);
                    break;
                }
                case "o": {
                    deck.add(currPlayer.getCards().remove(Integer.parseInt(playerInput[1])));
                    break;
                }
                case "": {
                    if (!currPlayer.checkCardAmount()) {
                        this.getHorizontalLine();
                        System.out.println(
                                "! Pocet tvojich kariet prevysuje tvoj pocet zivotov !\n\tZahod nejake karty! ");
                        phase = true;
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
            }
        }
    }

    private void giveTwoCards() {
        for (int i = 0; i < 2; i++) {
            currPlayer.recieveCard(deck.remove());
        }

    }

    private String[] parseTurnInput(boolean phase) {
        String[] in = new String[2];
        String in2 = "";
        try {
            do {
                this.getHorizontalLine();
                System.out.println("Tvoje karty: " + currPlayer.getCardsPrint(true));
                this.getHorizontalLine();
                if (!phase) {
                    in2 = ZKlavesnice.readString("Hraj n-tu kartu (napr. 2)\nEnter - Koniec kola");
                    if (in2.equals("")) {
                        in[0] = "";
                        in[1] = "0";
                        return in;
                    }
                    in[0] = "h";
                    in[1] = in2.toString();
                } else {
                    in2 = ZKlavesnice.readString("Odhod n-tu kartu (napr. 1)\nEnter - Koniec kola");
                    if (in2.equals("")) {
                        in[0] = "";
                        in[1] = "0";
                        return in;
                    }
                    in[0] = "o";
                    in[1] = in2.toString();
                }

            } while (Integer.parseInt(in[1]) > currPlayer.getCards().size() || Integer.parseInt(in[1]) < 1);

            in[1] = Integer.toString(Integer.parseInt(in[1]) - 1);

        } catch (NumberFormatException e) {
            System.out.println("Zly vstup, zadavaj este raz");
            in = parseTurnInput(phase);
        }

        return in;
    }

    public void playOnTable() {

        for (Card card : this.currPlayer.getCardsOnTable()) {

            this.currPlayer = ((BlueCard) card).play(this.currPlayer, deck, players);

        }
    }

    private void getHorizontalLine() {
        System.out.println("\n--------------------------------\n");
    }

}
