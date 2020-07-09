package com.codedifferently.casino.games;

import com.codedifferently.casino.utilities.Card;
import com.codedifferently.casino.utilities.Deck;

public class CardGame extends Games {
    private int numOfCards;
    private Deck deck;

    public CardGame(String name,int max, int min, int numOfCards){
        super(name, max, min);
        this.numOfCards=numOfCards;
        this.deck=new Deck();
    }
    
    public int getNumOfCards(){
        return this.numOfCards;
    }

    public Card pullFromDeck(){
        return this.deck.pullFromDeck();
    }

    public void shuffleDeck(){
        this.deck.shuffle();
    }
}
