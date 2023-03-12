package sk.stuba.fei.uim.oop.Karty;

public abstract class BlueCard extends Card{
    private String type;

    public BlueCard(String name) {
        super(name);
        this.type = "blue";
    }

    public String getType() {
        return type;
    }
    

    
}
