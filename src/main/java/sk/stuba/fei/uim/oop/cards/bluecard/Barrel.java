package sk.stuba.fei.uim.oop.cards.bluecard;

import sk.stuba.fei.uim.oop.cards.BlueCard;

public class Barrel extends BlueCard{

    public Barrel() {
        super("Barrel");
    }

    @Override
    public String toString() {
        return this.getName();
    }
    
}
