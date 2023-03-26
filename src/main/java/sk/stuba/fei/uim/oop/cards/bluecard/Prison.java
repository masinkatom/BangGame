package sk.stuba.fei.uim.oop.cards.bluecard;

import java.util.ArrayList;
import java.util.LinkedList;

import sk.stuba.fei.uim.oop.Card;
import sk.stuba.fei.uim.oop.Player;
import sk.stuba.fei.uim.oop.cards.BlueCard;

public class Prison extends BlueCard{

    public Prison() {
        super("Vazenie");
    }

    @Override
    public void play(Player currPlayer, ArrayList<Player> targetPlayers, LinkedList<Card> deck) {
        
        Player target = findTarget(currPlayer, targetPlayers);
        // TODO osetrit pridanie na viac kariet prison
        currPlayer.removeCard(this);
        this.setOnTable(true);
        target.recieveCard(this);

    }

    @Override
    public int play(Player player, LinkedList<Card> deck, ArrayList<Player> targetPlayers) {
        this.throwCard(player, deck);
        int random = (int) (Math.random()*3);
        if (random == 0){
            return 0;
        }
        return 2;
    }

    
    
    

}
