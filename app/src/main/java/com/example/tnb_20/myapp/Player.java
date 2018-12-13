package com.example.tnb_20.myapp;

public class Player implements Comparable<Player>{

    private String name;
    private int intents;

    public Player(String name, int intents) {
        this.name = name;
        this.intents = intents;
    }

    public String getName() {
        return name;
    }

    public int getIntents() {
        return intents;
    }

    @Override
    public String toString() {
        return "Nombre:" + name + " => Intentos:" + intents + "\n";
    }

    @Override
    public int compareTo(Player player){
        return this.intents - player.intents;

    }
}
