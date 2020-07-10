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
    private ArrayList<Card> stockPile = new ArrayList<Card>();
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

        ArrayList<Card> hand = hmap.get(player);
        Card newCard = pullFromDeck();

        for(Card c : hand){
            if(c.getRank().equals(newCard.getRank()))
                hand.add(newCard);
            else
                addToStockPile(newCard);
        }
        return null;
    }

    public boolean checkForBooks(Player player){
        int count = 0;

        ArrayList<Card> hand = hmap.get(player);

        for(Card one : hand){
            for(Card two : hand){
                if(one.getRank().equals(two.getRank()))
                    count++;
            }

            if(count == 4){ 
                for(int i = 0; i < 4; i++)
                    hand.remove(one);
                
                return true;
            }
        }
        return false;
    }

    public void addToStockPile(Card card){
       stockPile.add(card);
    }

    public void playerTurn(Player playerAsking, Player playerAsked, Rank rankWanted){
        boolean gotCards = ask(playerAsked, rankWanted);

        if(gotCards)
            giveCards(playerAsking, playerAsked, rankWanted);
        else
            pullFromDeck(playerAsking, rankWanted);
    }

    public void deal(){
        dealCards(cardsPerPerson);
    }
}