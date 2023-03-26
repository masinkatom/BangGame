package sk.stuba.fei.uim.oop.cards.bluecard;

import java.util.ArrayList;
import java.util.LinkedList;

import sk.stuba.fei.uim.oop.Card;
import sk.stuba.fei.uim.oop.Player;
import sk.stuba.fei.uim.oop.cards.BlueCard;

public class Dynamite extends BlueCard {

    public Dynamite() {
        super("Dynamit");
    }

    @Override
    public void play(Player currPlayer, ArrayList<Player> targetPlayers, LinkedList<Card> deck) {
        if (!isOnTable()) {
            this.setOnTable(true);
        } else
            System.out.println("Tato karta uz je na stole!");

    }

    @Override
    public Player play(Player player, LinkedList<Card> deck, ArrayList<Player> targetPlayers) {
        int random = (int) (Math.random() * 7);
        if (random == 0) {
            this.throwCard(player, deck);

            boolean dead = player.changeLives(false, 3);
            if (dead) {
                player.kickPLayer(player, targetPlayers, deck);
            }
            return player;
        }
        player.removeCard(this);
        this.prevPlayer(player, targetPlayers).recieveCard(this);
        return player;
    }

    private Player prevPlayer(Player player, ArrayList<Player> players) {
        if (player.getId() <= 0) {
            return players.get(players.size() - 1);
        }
        return players.get(player.getId() - 1);
    }

}
