package com.codedifferently.casino.utilities;

import java.util.Random;

import com.codedifferently.casino.utilities.cardenums.Suit;

/**
 * @author Keseana Howard
 */

public class Deck {

    private Card[] cards;
    Random rIndex = new Random();

    public Deck(){
        cards = new Card[52];
        
        int index = rIndex.nextInt(52);
        for(int i = 0; i < Suit.values().length; i++){
        }
    }


}