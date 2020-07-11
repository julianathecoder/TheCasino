package com.codedifferently.casino.utilities;

import java.util.ArrayList;
import java.util.Arrays;

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
        Deck deckTest = new Deck();

        Card actual = deckTest.pullFromDeck();

        Assert.assertEquals(Suit.SPADES, actual.getSuit());
        Assert.assertEquals(Color.BLACK, actual.getColor());
        Assert.assertEquals(Rank.KING, actual.getRank());
    }

    @Test
    public void getDeckSizeTest(){
        Deck deckTest = new Deck();

        int actual = deckTest.getDeckSize();
        int expected = 52;
        
        Assert.assertEquals(expected, actual);
    }

    @Test
    public void getDeckSizeTest2(){
        Deck deckTest = new Deck();

        deckTest.pullFromDeck();
        deckTest.pullFromDeck();

        int actual = deckTest.getDeckSize();
        int expected = 50;

        Assert.assertEquals(expected, actual);
    }

    @Test
    public void shuffleTest(){
        Deck deckTest = new Deck();

        Card actual = deckTest.pullFromDeck();
        deckTest.shuffle();
        Card expected = deckTest.pullFromDeck();

        Assert.assertNotEquals(expected, actual);
    }

    @Test
    public void repopulateDeckTest(){
        Deck deckTest = new Deck();
        deckTest.getDeck().clear();

        Card one = new Card(Suit.CLUBS, Color.BLACK, Rank.ACE);
        Card two = new Card(Suit.CLUBS, Color.BLACK, Rank.QUEEN);
        Card three = new Card(Suit.SPADES, Color.BLACK, Rank.DEUCE);
        Card four = new Card(Suit.HEARTS, Color.RED, Rank.FIVE);

        ArrayList<Card> testStockPile = new ArrayList<Card>(Arrays.asList(one, two, three, four));
        deckTest.repopulateDeck(testStockPile);

        int actual = deckTest.getDeckSize();
        int expected = 4;

        Assert.assertEquals(expected, actual);
    }
}