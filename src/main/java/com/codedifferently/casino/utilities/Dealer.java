package com.codedifferently.casino.utilities;

import java.util.ArrayList;

/**
 * @author Juliana Paul
 */
public class Dealer {

    private Deck deck = new Deck();

    public void dealCard(Player player){
        //Get next card and add to hand of the player
         Card removedCard = deck.pullFromDeck();
         player.checkCards().add(removedCard);
     }
}

