package sk.stuba.fei.uim.oop.cards.browncard;

import sk.stuba.fei.uim.oop.cards.BrownCard;

public class Pivo extends BrownCard {

    public Pivo() {
        super("Pivo");
    }
    
    @Override
    public String toString() {
        return this.getName();
    }
}
