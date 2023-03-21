package sk.stuba.fei.uim.oop.cards;

import sk.stuba.fei.uim.oop.Card;

public abstract class BlueCard extends Card{
    private boolean onTable;

    public BlueCard(String name) {
        super(name);
        this.onTable = false;
        // TODO pri navrate v nejakej throwAway pamatat na onTable = false;
    }

    public boolean isOnTable() {
        return onTable;
    }

    public void setOnTable(boolean onTable) {
        this.onTable = onTable;
    }

    @Override
    public String toString() {
        if (this.isOnTable()) return this.getName() + " (Na stole)";
        return this.getName();
    }
    
    
}
