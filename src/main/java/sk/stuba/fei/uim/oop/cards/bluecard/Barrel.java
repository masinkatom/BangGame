package sk.stuba.fei.uim.oop.cards.bluecard;

import java.util.ArrayList;
import java.util.LinkedList;

import sk.stuba.fei.uim.oop.Card;
import sk.stuba.fei.uim.oop.Player;
import sk.stuba.fei.uim.oop.cards.BlueCard;

public class Barrel extends BlueCard{

    public Barrel() {
        super("Barrel");
    }

    @Override
    public void play(Player currPlayer, ArrayList<Player> targetPlayers, LinkedList<Card> deck) {
        // TODO osetrit pridanie druhej karty barrel (v BlueCard asi)
        if (!this.isOnTable()){
            this.setOnTable(true);
        }
        else System.out.println("Tato karta uz je na stole!");
        
    }

    @Override
    public int play(Player player, LinkedList<Card> deck, ArrayList<Player> targetPlayers) {
        int rand = (int) (Math.random()*3);
        if (rand == 0){
            return 1;
        }
        return 0;
    }



    

   

    


    
}
