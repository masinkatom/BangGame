package sk.stuba.fei.uim.oop.cards.bluecard;

import java.util.ArrayList;
import java.util.LinkedList;

import sk.stuba.fei.uim.oop.Card;
import sk.stuba.fei.uim.oop.Player;
import sk.stuba.fei.uim.oop.cards.BlueCard;

public class Prison extends BlueCard {

    public Prison() {
        super("Vazenie");
    }

    @Override
    public void play(Player currPlayer, ArrayList<Player> targetPlayers, LinkedList<Card> deck) {

        Player target = findTarget(currPlayer, targetPlayers);
        if (this.alreadyOnTable(target)) {
            System.out.println("Tento hrac uz ma jedno vazenie na stole!");
            return;
        }
        currPlayer.removeCard(this);
        this.setOnTable(true);
        target.recieveCard(this);

    }

    @Override
    public Player play(Player player, LinkedList<Card> deck, ArrayList<Player> targetPlayers) {
        this.throwCard(player, deck);
        int random = (int) (Math.random() * 3);
        if (random == 0) {
            return player;
        }
        player = nextPlayer(player, targetPlayers);
        return player;
    }

    private Player nextPlayer(Player player, ArrayList<Player> players) {
        if (player.getId() >= players.size() - 1) {
            return players.get(0);
        }
        return players.get(player.getId() + 1);

    }

}
