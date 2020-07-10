package com.codedifferently.casino.utilities;

import java.util.ArrayList;

/**
 * @author Juliana Paul
 */
public class Dealer {

     //Keeps track of the number of cards that have been dealt from deck so far
    private int cardsUsed;
    private ArrayList<Card> cards = new ArrayList<Card>();

    public Card pullFromDeck(){

        Card removedCard = cards.remove(cards.size() - 1);
        return removedCard;
    }

    public void dealCard(Player player){
        //Get next card and add to hand of the player
         Card removedCard = cards.remove(cards.size() - 1);
         player.checkCards().add(removedCard);

     }
}

