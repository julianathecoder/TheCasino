package com.codedifferently.casino.games;

import java.util.HashMap;

import com.codedifferently.casino.utilities.Card;
import com.codedifferently.casino.utilities.Player;

/**
 * @author Keseana Howard
 */

public class GoFish extends CardGame{
    
    private HashMap<Player, Card[]> hmap = new HashMap<Player, Card[]>();
    private final int cardsPerPerson;

    public GoFish(){
        super("Go Fish", 6, 2);
        if(hmap.size() >= 2 && hmap.size() <= 3)
            cardsPerPerson = 7;
        else   
            cardsPerPerson = 5;
    }

    public

    public boolean ask(Player player, Card card){
        Card[] hand = hmap.get(player);

        for(Card current : hand){
            if(current.equals(card))
                return true;
        }

        return false;
    }

    public boolean won(){
        return false;
    }

    public boolean checkHand(){
        return false;
    }

    public void giveCards(){

    }

    public Card pullFromDeck(){
        return null;
    }

    public int getMaxPlayers(){

    }
}