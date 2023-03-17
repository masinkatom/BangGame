package sk.stuba.fei.uim.oop.cards.browncard;

import sk.stuba.fei.uim.oop.cards.BrownCard;

public class CatBalou extends BrownCard{

    public CatBalou() {
        super("Cat Balou");
    }
    
    @Override
    public String toString() {
        return this.getName();
    }
}
