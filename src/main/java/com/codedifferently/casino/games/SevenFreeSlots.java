package com.codedifferently.casino.games;

import java.util.ArrayList;

import com.codedifferently.casino.utilities.Player;

public class SevenFreeSlots {

    private double credits; //Players coins/money
    private int maxBet;
    private int oneBet;
    final ArrayList<String> pieces = new ArrayList<String>();

    public SevenFreeSlots(Player player){
        credits = player.getMoney(); //Initialized with amount of money player has
        maxBet = 3;
        oneBet = 1;
        pieces.add("7");
        pieces.add("BAR");
        pieces.add("CHERRY");
        pieces.add("WILD");
    }

    public double spinReels(Player player){
        return 0;
    }

    public double betMax(Player player){
        if(player.getMoney() == 0){
            throw new IllegalStateException("Insefficient credits!");
        }
        return 0;
    }
}
