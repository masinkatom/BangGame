package sk.stuba.fei.uim.oop;

import java.util.ArrayList;

import sk.stuba.fei.uim.oop.utility.ZKlavesnice;

public class GameManager {

    private ArrayList <Player> players; 

    public GameManager() {
        int b = ZKlavesnice.readInt("Zadaj cislo");
        System.out.println(b);

        System.out.println("Vitaj v hre BANG!");
        
    }

    public ArrayList<Player> getPlayers() {
        return players;
    }
    
    
    
}
