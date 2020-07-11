package com.codedifferently.casino.games;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Set;

import com.codedifferently.casino.utilities.Card;
import com.codedifferently.casino.utilities.Player;
import com.codedifferently.casino.utilities.cardenums.Color;
import com.codedifferently.casino.utilities.cardenums.Rank;
import com.codedifferently.casino.utilities.cardenums.Suit;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class GoFishTest {

    GoFish goFishTest;
    Player p1;
    Player p2;

    @Before
    public void initialize() {

        goFishTest = new GoFish();
        p1 = new Player("Eli", 15, 0);
        p2 = new Player("Azlia", 18, 0);

        goFishTest.addPlayer(p1);
        goFishTest.addPlayer(p2);

        goFishTest.initializePlayers();
        goFishTest.setCardNumber();

    }

    @Test
    public void getCardsPerPersonTest() {
        int actual = goFishTest.getCardsPerPerson();
        int expected = 7;

        Assert.assertEquals(expected, actual);
    }

    @Test
    public void setCardNumberTest() {
        Player p3 = new Player("Zack", 21, 0);
        Player p4 = new Player("Ali", 25, 0);

        goFishTest.addPlayer(p3);
        goFishTest.addPlayer(p4);

        goFishTest.initializePlayers();
        goFishTest.setCardNumber();

        int actual = goFishTest.getCardsPerPerson();
        int expected = 5;

        Assert.assertEquals(expected, actual);
    }

    @Test
    public void initializePlayersTest() {

        ArrayList<Player> actual = goFishTest.getPlayerList();
        ArrayList<Player> expected = new ArrayList<Player> (Arrays.asList(p1, p2));

        Assert.assertEquals(expected, actual);
    }

    @Test
    public void askTest(){

        ArrayList<Card> testHand = new ArrayList<Card>();
        testHand.add(new Card(Suit.CLUBS, Color.BLACK, Rank.ACE));
        testHand.add(new Card(Suit.HEARTS, Color.RED, Rank.FIVE));
        testHand.add(new Card(Suit.CLUBS, Color.BLACK, Rank.QUEEN));
        testHand.add(new Card(Suit.SPADES, Color.BLACK, Rank.DEUCE));
        testHand.add(new Card(Suit.DIAMONDS, Color.RED, Rank.ACE));

        boolean actual = goFishTest.checkHand(testHand, Rank.ACE);
        boolean expected = true;

        Assert.assertEquals(expected, actual);
    }

    @Test
    public void askTest2(){

        ArrayList<Card> testHand = new ArrayList<Card>();
        testHand.add(new Card(Suit.CLUBS, Color.BLACK, Rank.ACE));
        testHand.add(new Card(Suit.HEARTS, Color.RED, Rank.FIVE));
        testHand.add(new Card(Suit.CLUBS, Color.BLACK, Rank.QUEEN));
        testHand.add(new Card(Suit.SPADES, Color.BLACK, Rank.DEUCE));
        testHand.add(new Card(Suit.DIAMONDS, Color.RED, Rank.ACE));

        boolean actual = goFishTest.checkHand(testHand, Rank.SEVEN);
        boolean expected = false;

        Assert.assertEquals(expected, actual);
    }

    @Test
    public void giveCardsTest(){

        HashMap<Player, ArrayList<Card>> testMap = goFishTest.getHashMap();
        ArrayList<Card> p1Hand = testMap.get(p1);
        ArrayList<Card> p2Hand = testMap.get(p2);

        p1Hand.add(new Card(Suit.CLUBS, Color.BLACK, Rank.ACE));
        p1Hand.add(new Card(Suit.HEARTS, Color.RED, Rank.FIVE));
        p1Hand.add(new Card(Suit.CLUBS, Color.BLACK, Rank.QUEEN));
        p1Hand.add(new Card(Suit.SPADES, Color.BLACK, Rank.DEUCE));
        p1Hand.add(new Card(Suit.DIAMONDS, Color.RED, Rank.ACE));

        p2Hand.add(new Card(Suit.SPADES, Color.BLACK, Rank.ACE));
        p2Hand.add(new Card(Suit.CLUBS, Color.BLACK, Rank.QUEEN));
        p2Hand.add(new Card(Suit.SPADES, Color.BLACK, Rank.THREE));
        p2Hand.add(new Card(Suit.HEARTS, Color.RED, Rank.KING));
        p2Hand.add(new Card(Suit.SPADES, Color.RED, Rank.KING));

        goFishTest.giveCards(p1, p2, Rank.KING);

        int player1Actual = p1Hand.size();
        int player2Actual = p2Hand.size();

        int player1Expected = 7;
        int player2Expected = 3;

        Assert.assertEquals(player1Expected, player1Actual);
        Assert.assertEquals(player2Expected, player2Actual);

    }

    @Test
    public void pullFromDeckTest(){

        HashMap<Player, ArrayList<Card>> testMap = goFishTest.getHashMap();
        ArrayList<Card> p1Hand = testMap.get(p1);

        p1Hand.add(new Card(Suit.CLUBS, Color.BLACK, Rank.ACE));
        p1Hand.add(new Card(Suit.HEARTS, Color.RED, Rank.FIVE));
        p1Hand.add(new Card(Suit.CLUBS, Color.BLACK, Rank.QUEEN));
        p1Hand.add(new Card(Suit.SPADES, Color.BLACK, Rank.DEUCE));
        p1Hand.add(new Card(Suit.DIAMONDS, Color.RED, Rank.ACE));

        boolean actual = goFishTest.pullFromDeck(p1, Rank.QUEEN);
        boolean expected = true;

        Assert.assertEquals(expected, actual);
    }

    @Test
    public void pullFromDeckTest2(){

        HashMap<Player, ArrayList<Card>> testMap = goFishTest.getHashMap();
        ArrayList<Card> p1Hand = testMap.get(p1);

        p1Hand.add(new Card(Suit.CLUBS, Color.BLACK, Rank.ACE));
        p1Hand.add(new Card(Suit.HEARTS, Color.RED, Rank.FIVE));
        p1Hand.add(new Card(Suit.CLUBS, Color.BLACK, Rank.QUEEN));
        p1Hand.add(new Card(Suit.SPADES, Color.BLACK, Rank.DEUCE));
        p1Hand.add(new Card(Suit.DIAMONDS, Color.RED, Rank.ACE));

        boolean actual = goFishTest.pullFromDeck(p1, Rank.SEVEN);
        boolean expected = false;

        Assert.assertEquals(expected, actual);
    }

    @Test
    public void addBookTest(){
        HashMap<Player, ArrayList<Card>> testMap = goFishTest.getHashMap();
        ArrayList<Card> p1Hand = testMap.get(p1);
        ArrayList<Card> p2Hand = testMap.get(p2);

        p1Hand.add(new Card(Suit.CLUBS, Color.BLACK, Rank.ACE));
        p1Hand.add(new Card(Suit.HEARTS, Color.RED, Rank.KING));
        p1Hand.add(new Card(Suit.CLUBS, Color.BLACK, Rank.QUEEN));
        p1Hand.add(new Card(Suit.SPADES, Color.BLACK, Rank.KING));
        p1Hand.add(new Card(Suit.DIAMONDS, Color.RED, Rank.ACE));

        p2Hand.add(new Card(Suit.SPADES, Color.BLACK, Rank.ACE));
        p2Hand.add(new Card(Suit.CLUBS, Color.BLACK, Rank.QUEEN));
        p2Hand.add(new Card(Suit.SPADES, Color.BLACK, Rank.THREE));
        p2Hand.add(new Card(Suit.HEARTS, Color.RED, Rank.KING));
        p2Hand.add(new Card(Suit.SPADES, Color.RED, Rank.KING));

        goFishTest.giveCards(p1, p2, Rank.KING);
        goFishTest.addToBookLog(p1,Rank.KING);

        HashMap<Player, ArrayList<Rank>> testBookLog = goFishTest.getBookLog();

        int actual = testBookLog.get(p1).size();
        int expected = 1;

        Assert.assertEquals(expected, actual);
    }

    @Test
    public void checkForBooksTest(){
        HashMap<Player, ArrayList<Card>> testMap = goFishTest.getHashMap();
        ArrayList<Card> p1Hand = testMap.get(p1);
        ArrayList<Card> p2Hand = testMap.get(p2);

        p1Hand.add(new Card(Suit.CLUBS, Color.BLACK, Rank.ACE));
        p1Hand.add(new Card(Suit.HEARTS, Color.RED, Rank.KING));
        p1Hand.add(new Card(Suit.CLUBS, Color.BLACK, Rank.QUEEN));
        p1Hand.add(new Card(Suit.SPADES, Color.BLACK, Rank.KING));
        p1Hand.add(new Card(Suit.DIAMONDS, Color.RED, Rank.ACE));

        p2Hand.add(new Card(Suit.SPADES, Color.BLACK, Rank.ACE));
        p2Hand.add(new Card(Suit.CLUBS, Color.BLACK, Rank.QUEEN));
        p2Hand.add(new Card(Suit.SPADES, Color.BLACK, Rank.THREE));
        p2Hand.add(new Card(Suit.HEARTS, Color.RED, Rank.KING));
        p2Hand.add(new Card(Suit.SPADES, Color.RED, Rank.KING));

        goFishTest.giveCards(p1, p2, Rank.KING);
        goFishTest.addToBookLog(p1,Rank.KING);
        goFishTest.checkForBooks(p1);
         
        int actualSize = goFishTest.getSizeOfPlayerHand(p1);
        int expectedSize = 3;

        HashMap<Player, ArrayList<Rank>> testBookLog = goFishTest.getBookLog();
        boolean actualrank = testBookLog.get(p1).contains(Rank.KING);
        boolean expectedRank = true;

        int actualBookCount = goFishTest.getTotalBookCount();
        int expectedBookCount = 1;

        Assert.assertEquals(expectedSize, actualSize);
        Assert.assertEquals(expectedRank, actualrank);
        Assert.assertEquals(expectedBookCount, actualBookCount);
    }

    /*@Test
    public void removeBooksTest(){

        boolean actual = false;
        boolean expected = false;

        Assert.assertEquals(expected, actual);
    }*/

    @Test
    public void addToStockPileTest(){

        goFishTest.addToStockPile(new Card(Suit.CLUBS, Color.BLACK, Rank.EIGHT));

        int actual = goFishTest.getStockPile().size();
        int expected = 1;

        Assert.assertEquals(expected, actual);
    }
    
    @Test
    public void addToStockPileTest2(){
        goFishTest.addToStockPile(new Card(Suit.CLUBS, Color.BLACK, Rank.EIGHT));
        goFishTest.addToStockPile(new Card(Suit.HEARTS, Color.RED, Rank.JACK));

        int actual = goFishTest.getStockPile().size();
        int expected = 2;

        Assert.assertEquals(expected, actual);
    }

    @Test
    public void emptyStockPileTest(){

        HashMap<Player, ArrayList<Card>> testMap = goFishTest.getHashMap();
        ArrayList<Card> p1Hand = testMap.get(p1);

        goFishTest.addToStockPile(new Card(Suit.CLUBS, Color.BLACK, Rank.ACE));
        goFishTest.addToStockPile(new Card(Suit.HEARTS, Color.RED, Rank.FIVE));
        goFishTest.addToStockPile(new Card(Suit.CLUBS, Color.BLACK, Rank.QUEEN));
        goFishTest.addToStockPile(new Card(Suit.SPADES, Color.BLACK, Rank.DEUCE));
        goFishTest.addToStockPile(new Card(Suit.DIAMONDS, Color.RED, Rank.ACE));

        goFishTest.deck.getDeck().clear();
        goFishTest.emptyStockPile();

        boolean actual = goFishTest.getStockPile().isEmpty();
        boolean expected = true;

        int actualDeckSize = goFishTest.getDeckSize();
        int expectedDeckSize = 5;

        Assert.assertEquals(expected, actual);
        Assert.assertEquals(expectedDeckSize, actualDeckSize);
    }

    /*@Test
    public void playerTurn(){

    }*/

    @Test
    public void dealTest(){

        goFishTest.deal();
        HashMap<Player, ArrayList<Card>> testMap = goFishTest.getHashMap();

        boolean actual = testMap.isEmpty();
        boolean expected = false;

        Assert.assertEquals(expected, actual);
    }

    @Test
    public void showBooksTest(){

        HashMap<Player, ArrayList<Card>> testMap = goFishTest.getHashMap();
        HashMap<Player, ArrayList<Rank>> testBookLog = goFishTest.getBookLog();
        ArrayList<Card> p1Hand = testMap.get(p1);
        ArrayList<Card> p2Hand = testMap.get(p2);

        p1Hand.add(new Card(Suit.CLUBS, Color.BLACK, Rank.ACE));
        p1Hand.add(new Card(Suit.HEARTS, Color.RED, Rank.KING));
        p1Hand.add(new Card(Suit.CLUBS, Color.BLACK, Rank.QUEEN));
        p1Hand.add(new Card(Suit.SPADES, Color.BLACK, Rank.KING));
        p1Hand.add(new Card(Suit.DIAMONDS, Color.RED, Rank.ACE));

        p2Hand.add(new Card(Suit.SPADES, Color.BLACK, Rank.ACE));
        p2Hand.add(new Card(Suit.CLUBS, Color.BLACK, Rank.QUEEN));
        p2Hand.add(new Card(Suit.SPADES, Color.BLACK, Rank.THREE));
        p2Hand.add(new Card(Suit.HEARTS, Color.RED, Rank.KING));
        p2Hand.add(new Card(Suit.SPADES, Color.RED, Rank.KING));

        goFishTest.giveCards(p1, p2, Rank.KING);
        goFishTest.addToBookLog(p1,Rank.KING);
        goFishTest.checkForBooks(p1);

        String actual1 = goFishTest.showBooks(p1);
        String actual2 = goFishTest.showBooks(p2);

        String expected1 = "Number of Books: " + testBookLog.get(p1).size() + "\tBooks: " +testBookLog.get(p1).toString(); 
        String expected2 = "Number of Books: " + testBookLog.get(p2).size() + "\tBooks: " +testBookLog.get(p2).toString();

        Assert.assertEquals(expected1, actual1);
        Assert.assertEquals(expected2, actual2);
    }

    @Test 
    public void showHandTest(){

        HashMap<Player, ArrayList<Card>> testMap = goFishTest.getHashMap();
        ArrayList<Card> p1Hand = testMap.get(p1);
        ArrayList<Card> p2Hand = testMap.get(p2);

        p1Hand.add(new Card(Suit.CLUBS, Color.BLACK, Rank.ACE));
        p1Hand.add(new Card(Suit.HEARTS, Color.RED, Rank.KING));
        p1Hand.add(new Card(Suit.CLUBS, Color.BLACK, Rank.QUEEN));
        p1Hand.add(new Card(Suit.SPADES, Color.BLACK, Rank.KING));
        p1Hand.add(new Card(Suit.DIAMONDS, Color.RED, Rank.ACE));

        p2Hand.add(new Card(Suit.SPADES, Color.BLACK, Rank.ACE));
        p2Hand.add(new Card(Suit.CLUBS, Color.BLACK, Rank.QUEEN));
        p2Hand.add(new Card(Suit.SPADES, Color.BLACK, Rank.THREE));
        p2Hand.add(new Card(Suit.HEARTS, Color.RED, Rank.KING));
        p2Hand.add(new Card(Suit.SPADES, Color.RED, Rank.KING));

        goFishTest.giveCards(p1, p2, Rank.KING);
        goFishTest.addToBookLog(p1,Rank.KING);
        goFishTest.checkForBooks(p1);

        String actual = goFishTest.showHand(p1);

        String expected = p1.getName() + "'s Hand: " + testMap.get(p1).toString();

        Assert.assertEquals(expected, actual);
    }
}
   