package com.codedifferently.casino.utilities;

/**
 * @author Keseana Howard
 */

public class Card {

    public enum Rank{
        Ace(1), DUECE(2), THREE(3), 
        FOUR(4), FIVE(5), SIX(6), 
        SEVEN(7), EIGHT(8), NINE(9), 
        TEN(10), JACK(10), QUEEN(10), 
        KING(10);
    
        private final int rankValue;
    
        private Rank(int rankValue){
            this.rankValue = rankValue; 
        }

        public int getRank(){ 
            return rankValue; 
        }
    }

    public enum Suit{CLUBS, DIAMONDS, HEARTDS, SPADES}
    public enum Color{BLACK, RED}
    

    private Suit suit;
    private Rank rank;
    private Color color;

    public Card(Suit suit, Color color, Rank rank){
        this.suit = suit;
        this.color = color;
        this.rank = rank;
    }

    public Suit getSuit(){
        return suit;
    }

    public Rank getRank(){
        return rank;
    }

    public Color getColor(){
        return color;
    }

}

