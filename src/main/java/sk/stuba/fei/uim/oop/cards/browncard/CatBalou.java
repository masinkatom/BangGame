package sk.stuba.fei.uim.oop.cards.browncard;

import java.util.ArrayList;
import java.util.LinkedList;

import sk.stuba.fei.uim.oop.Card;
import sk.stuba.fei.uim.oop.Player;
import sk.stuba.fei.uim.oop.cards.BrownCard;
import sk.stuba.fei.uim.oop.utility.ZKlavesnice;

public class CatBalou extends BrownCard {

    public CatBalou() {
        super("Cat Balou");
    }

    @Override
    public void play(Player currPlayer, ArrayList<Player> targetPlayers, LinkedList<Card> deck) {
        super.play(currPlayer, targetPlayers, deck);

        Player target = findTarget(currPlayer, targetPlayers);

        deck.add(chooseCard(target));

    }

    private Card chooseCard(Player player) {
        System.out.println(player.getCardsPrint(false));
        int choice;
        do {
            if (player.getCards().isEmpty()){
                System.out.println("Tento hrac nema ziadne karty!");
                return null;
            }
            choice = ZKlavesnice.readInt("Vyber kartu, ktoru mu chces odobrat: ");
            
        } while (choice > player.getCards().size() || choice < 1);

        return player.getCards().remove(choice - 1);
    }

}
