package sk.stuba.fei.uim.oop;

import java.util.ArrayList;
import java.util.LinkedList;

import sk.stuba.fei.uim.oop.utility.ZKlavesnice;

public abstract class Card {
    private String name;

    public Card(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return this.name;
    }

    public String getName() {
        return name;
    }

    public void play(Player currPlayer, ArrayList<Player> targetPlayers, LinkedList<Card> deck) {
        throwCard(currPlayer, deck);
    }

    public void throwCard(Player player, LinkedList<Card> deck) {
        player.removeCard(this);
        deck.add(this);
    }

    public String getPlayersPrint(ArrayList<Player> targetPlayers) {
        String out = "[";
        int i = 0;
        for (Player player : targetPlayers) {

            out += ((i + 1) + " > " + player.getName());
            out += (", zivoty: " + player.getLives());
            if (i < targetPlayers.size() - 1) {
                out += " | ";
            }
            i++;
        }
        out += "]";
        return out;
    }

    public Player findTarget(Player currPlayer, ArrayList<Player> targetPlayers) {
        int playerNum;
        ArrayList<Player> copyTargPlayers = new ArrayList<>();
        copyTargPlayers.addAll(targetPlayers);
        copyTargPlayers.remove(currPlayer);

        do {
            System.out.println("\nHraci: " + getPlayersPrint(copyTargPlayers) + "\n");
            playerNum = ZKlavesnice.readInt("Na koho chces zahrat tuto " + this.getName() + " kartu? (zadaj cislo hraca)");
        } while (playerNum > copyTargPlayers.size() || playerNum < 1);

        return copyTargPlayers.get(playerNum - 1);
    }

    

}
