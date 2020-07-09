package com.codedifferently.casino.utilities;

import com.codedifferently.casino.utilities.cardenums.Color;
import com.codedifferently.casino.utilities.cardenums.Rank;
import com.codedifferently.casino.utilities.cardenums.Suit;

import org.junit.Assert;
import org.junit.Test;

/**
 * @author Keseana Howard
 */

public class DeckTest {
    
    @Test
    public void constructorTest(){

        Deck deckTest = new Deck();

        Assert.assertNotNull(deckTest);
    }

    @Test
    public void pullFromDeckTest(){

        Deck deck = new Deck();

        Card actual = deck.pullFromDeck();
        Card expected = new Card(Suit.SPADES, Color.BLACK, Rank.KING);

        Assert.assertEquals(expected, actual);
    }
}