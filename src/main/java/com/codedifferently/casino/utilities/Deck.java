package com.codedifferently.casino.utilities;

import java.util.ArrayList;
//import java.util.Arrays;
import java.util.Random;

import com.codedifferently.casino.utilities.cardenums.Color;
import com.codedifferently.casino.utilities.cardenums.Rank;
import com.codedifferently.casino.utilities.cardenums.Suit;

/**
 * @author Keseana Howard
 */

public class Deck {

    //private Card[] cards;
    private ArrayList<Card> cards = new ArrayList<Card>(52);

    public Deck(){
        //cards = new Card[52];

        Random rIndex = new Random();
        int randomIndex = rIndex.nextInt(52);
        Suit[] suits = Suit.values();
        Color currentColor = null;
        Rank[] ranks = Rank.values();
        

        for(int i = 0; i < suits.length; i++){
            Suit currentSuit = suits[i];

            if(currentSuit.equals(Suit.SPADES) || currentSuit.equals(Suit.CLUBS))
                currentColor = Color.BLACK;
            else
                currentColor = Color.RED;

            for(int j = 0; j < ranks.length; j++){
                Rank currentRank = ranks[i];
                Card currentCard = new Card(currentSuit, currentColor, currentRank);

                if(!(cards.contains(currentCard))){                 //cards[randomIndex] == null){
                    cards.add(currentCard);     //cards[randomIndex] = currentCard;
                }
            }
        }
    }

    public int getDeckSize(){
        return cards.size();
    }

    public Card pullFromDeck(){

        if(!(cards.isEmpty())){
            //Card currentCard = cards[getDeckSize() - 1];
            //Card[] tempCards = Arrays.copyOf(cards, getDeckSize());
            return cards.remove(cards.size() - 1);
        }
        
        return null;
    }


}