package sk.stuba.fei.uim.oop.cards;

public abstract class BrownCard extends Card{
    private String type;

    public BrownCard(String name) {
        super(name);
        this.type = "brown";
    }

    public String getType() {
        return type;
    }

    
    
}