package com.codedifferently.casino.utilities;

import org.junit.Assert;
import org.junit.Test;

public class CardTest {
    
    @Test
    public void constructorTest(){
        Suit givenSuit = DIAMONDS;
        Rank givenRank = 11;
        Color givenColor = Color.RED;

        Card cardTest = new Card(givenSuit, givenColor, givenRank);

        Suit retrieveSuit = cardTest.getSuit();
        Rank retrieveRank = cardTest.getRank();
        Color retrieveColor = cardTest.getColor();

        Assert.assertEquals(expected, actual);
    }
}