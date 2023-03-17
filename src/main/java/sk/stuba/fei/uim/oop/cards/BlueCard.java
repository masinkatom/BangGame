package sk.stuba.fei.uim.oop.cards;

import sk.stuba.fei.uim.oop.Card;

public abstract class BlueCard extends Card{
    private boolean onTable;

    public BlueCard(String name) {
        super(name);
        onTable = false;
    }

    public boolean isOnTable() {
        return onTable;
    }

    public void setOnTable(boolean onTable) {
        this.onTable = onTable;
    }

    @Override
    public void play() {
        this.setOnTable(true);
        super.play();
    }
    
    
}
