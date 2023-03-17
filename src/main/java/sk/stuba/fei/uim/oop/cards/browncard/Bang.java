package sk.stuba.fei.uim.oop.cards.browncard;

import sk.stuba.fei.uim.oop.cards.BrownCard;

public class Bang extends BrownCard{

    public Bang() {
        super("BANG");
    }

    @Override
    public String toString() {
        return this.getName();
    }

    @Override
    public void play() {
        System.out.println("hello "+ this.getName() + " here");
        super.play();
    }

    

    
}
