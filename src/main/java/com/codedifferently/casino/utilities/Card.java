package com.codedifferently.casino.utilities;

/**
 * @author Keseana Howard
 */

public enum Suit{CLUBS, DIAMONDS, HEARTDS, SPADES}
public enum Rank{
    A(1), Ace(11), J(10), Q(10), K(10), TWO(2), THREE(3), FOUR(4), FIVE(5), SIX(6), SEVEN(7), EIGHT(8), NINE(9), TEN(10);
    
    private int numericalValue;
    
    private Rank(int numericalValue){
        this.numericalValue = numericalValue;
    }
    public int getNUmericalValue(){
        return numericalValue;
    }
}
public enum Color{BLACK, RED}

public class Card {
    
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