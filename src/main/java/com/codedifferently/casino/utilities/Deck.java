package com.codedifferently.casino.utilities;

import java.util.ArrayList;
import java.util.Collections;

import com.codedifferently.casino.utilities.cardenums.Color;
import com.codedifferently.casino.utilities.cardenums.Rank;
import com.codedifferently.casino.utilities.cardenums.Suit;

/**
 * @author Keseana Howard
 */

public class Deck {

    private ArrayList<Card> cards = new ArrayList<Card>();

    public Deck(){
        Color color = null;
        
        for(Suit suit : Suit.values()){

            if(suit.equals(Suit.SPADES) || suit.equals(Suit.CLUBS))
                color = Color.BLACK;
            else
                color = Color.RED;

            for(Rank rank : Rank.values()){

                Card currentCard = new Card(suit, color, rank);
                cards.add(currentCard); 
            }
        }
    }

    public void shuffle(){
        Collections.shuffle(cards);
    }

    public int getDeckSize(){
        return cards.size();
    } 

    public Card pullFromDeck(){

        if(cards.isEmpty())
            shuffle();

        return cards.remove(cards.size() - 1);
    }
}