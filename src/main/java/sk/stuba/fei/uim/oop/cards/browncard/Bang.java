package sk.stuba.fei.uim.oop.cards.browncard;

import java.util.ArrayList;
import java.util.LinkedList;

import sk.stuba.fei.uim.oop.Card;
import sk.stuba.fei.uim.oop.Player;
import sk.stuba.fei.uim.oop.cards.BrownCard;
import sk.stuba.fei.uim.oop.cards.bluecard.Barrel;
import sk.stuba.fei.uim.oop.utility.ZKlavesnice;

public class Bang extends BrownCard {

    public Bang() {
        super("BANG");
    }

    @Override
    public void play(Player currPlayer, ArrayList<Player> targetPlayers, LinkedList<Card> deck) {
        targetPlayers = findTarget(targetPlayers);
        // TODO do cyklu dat podla velkosti targetPlayerov
        Barrel barrel = checkForDefense(targetPlayers.get(0));
        if (barrel != null) {

            System.out.println("SUPER");
        }

        super.play(currPlayer, targetPlayers, deck);
    }

    private Barrel checkForDefense(Player targetPlayer) {
        for (Card card : targetPlayer.getCards()) {
            if (card instanceof Barrel) {
                if (((Barrel) card).isOnTable()) {
                    return (Barrel) card;
                }
            }
        }

        return null;
    }

    private ArrayList<Player> findTarget(ArrayList<Player> targetPlayers) {
        int playerNum;
        do {
            System.out.println("\nHraci: " + getPlayersPrint(targetPlayers) + "\n");
            playerNum = ZKlavesnice.readInt("Na koho chces zahrat tuto kartu? (zadaj cislo hraca)");
        } while (playerNum > targetPlayers.size() || playerNum < 1);

        return targetPlayers;
    }

}
