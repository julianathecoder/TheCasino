package com.codedifferently.casino.utilities;

/**
 * @author Juliana Paul
 */
public class Dealer {

    private Deck deck = new Deck();

    public void dealCard(Player player){
        //Get next card and add to hand of the player
         Card removedCard = deck.pullFromDeck();
         player.giveCard(removedCard);
     }
     
     public void dealersHand(Player player){

        //TODO hand that can be compared to players
        
     }
}

