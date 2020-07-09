package com.codedifferently.casino.utilities;

import com.codedifferently.casino.utilities.cardenums.Suit;
import com.codedifferently.casino.utilities.cardenums.Rank;
import com.codedifferently.casino.utilities.cardenums.Color;

import org.junit.Assert;
import org.junit.Test;

public class CardTest{
    
    @Test
    public void constructorTest(){
        Suit givenSuit = Suit.DIAMONDS;
        Rank givenRank = Rank.FIVE;
        Color givenColor = Color.RED;

        Card cardTest = new Card(givenSuit, givenColor, givenRank);

        Suit retrieveSuit = cardTest.getSuit();
        Rank retrieveRank = cardTest.getRank();
        Color retrieveColor = cardTest.getColor();

        Assert.assertEquals(givenSuit, retrieveSuit);
        Assert.assertEquals(givenRank, retrieveRank);
        Assert.assertEquals(givenColor, retrieveColor);
    }

    @Test
    public void getSuitTest(){

        Card cardTest = new Card(Suit.CLUBS, Color.RED, Rank.KING);

        Suit actual = cardTest.getSuit();
        Suit expected = Suit.CLUBS;

        Assert.assertEquals(expected, actual);
    }

    @Test
    public void getRankTest(){

        Card cardTest = new Card(Suit.HEARTS, Color.BLACK, Rank.DEUCE);

        Rank actual = cardTest.getRank();
        Rank expected = Rank.DEUCE;

        Assert.assertEquals(expected, actual);
    }

    @Test
    public void getColorTest(){

        Card cardTest = new Card(Suit.SPADES, Color.BLACK, Rank.ACE);

        Color actual = cardTest.getColor();
        Color expected = Color.BLACK;

        Assert.assertEquals(expected, actual);
    }
}