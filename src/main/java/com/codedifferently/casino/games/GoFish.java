package com.codedifferently.casino.games;

import java.util.HashMap;
import java.util.ArrayList;

import com.codedifferently.casino.utilities.Card;
import com.codedifferently.casino.utilities.Player;
import com.codedifferently.casino.utilities.cardenums.Rank;

/**
 * @author Keseana Howard
 */

public class GoFish extends CardGame{
    
    private HashMap<Player, ArrayList<Card>> hmap = new HashMap<Player, ArrayList<Card>>();
    private final int cardsPerPerson;

    public GoFish(){
        super("Go Fish", 6, 2);
        if(hmap.size() >= 2 && hmap.size() <= 3)
            cardsPerPerson = 7;
        else   
            cardsPerPerson = 5;
    }


    public boolean ask(Player playerAsked, Rank rankWanted){
        ArrayList<Card> hand = hmap.get(playerAsked);

        boolean cardFound = checkHand(hand, rankWanted);

        return cardFound;
    }

    public boolean checkHand(ArrayList<Card> hand, Rank rankWanted){
        
        for(Card current : hand){
            Rank rank = current.getRank();
            if(rank.equals(rankWanted))
                return true;
        }
        return false;
    }

    public void giveCards(Player playerAsking, Player playerAsked, Rank rankWanted){
        ArrayList<Card> removeCards = hmap.get(playerAsked);
        ArrayList<Card> addCards = hmap.get(playerAsking);

        for(Card current : removeCards){
            if(current.getRank().equals(rankWanted)){
                removeCards.remove(current);
                addCards.add(current);
            }
        }
    }

    public Card pullFromDeck(Player player, Rank rankWanted){
        
        Card newCard = pullFromDeck();
        if(newCard.getRank().equals(rankWanted)){
            ArrayList<Card> hand = hmap.get(player);
            hand.add(newCard);
        }
        return null;
    }

    public void playerTurn(Player playerAsking, Player playerAsked, Rank rankWanted){
        boolean gotCards = ask(playerAsked, rankWanted);

        if(gotCards)
            giveCards(playerAsking, playerAsked, rankWanted);
        else

    }

    public void deal(){
        dealCards(cardsPerPerson);
    }
}