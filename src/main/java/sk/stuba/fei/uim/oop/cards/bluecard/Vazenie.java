package sk.stuba.fei.uim.oop.cards.bluecard;

import sk.stuba.fei.uim.oop.cards.BlueCard;

public class Vazenie extends BlueCard{

    public Vazenie() {
        super("Vazenie");
    }
    
    @Override
    public String toString() {
        return this.getName();
    }
}
