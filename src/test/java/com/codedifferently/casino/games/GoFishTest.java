package com.codedifferently.casino.games;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;

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
        ArrayList<Card> player1Hand = testMap.get(p1);
        ArrayList<Card> player2Hand = testMap.get(p2);

        player1Hand.add(new Card(Suit.CLUBS, Color.BLACK, Rank.ACE));
        player1Hand.add(new Card(Suit.HEARTS, Color.RED, Rank.FIVE));
        player1Hand.add(new Card(Suit.CLUBS, Color.BLACK, Rank.KING));
        player1Hand.add(new Card(Suit.SPADES, Color.BLACK, Rank.DEUCE));
        player1Hand.add(new Card(Suit.DIAMONDS, Color.RED, Rank.ACE));

        player2Hand.add(new Card(Suit.SPADES, Color.BLACK, Rank.ACE));
        player2Hand.add(new Card(Suit.CLUBS, Color.BLACK, Rank.QUEEN));
        player2Hand.add(new Card(Suit.SPADES, Color.BLACK, Rank.THREE));
        player2Hand.add(new Card(Suit.HEARTS, Color.RED, Rank.KING));
        player2Hand.add(new Card(Suit.SPADES, Color.RED, Rank.KING));

        goFishTest.giveCards(p1, p2, Rank.KING);

        int player1Actual = player1Hand.size();
        int player2Actual = player2Hand.size();

        int player1Expected = 7;
        int player2Expected = 3;

        Assert.assertEquals(player1Expected, player1Actual);
        Assert.assertEquals(player2Expected, player2Actual);

    }

    @Test
    public void pullFromDeckTest(){

        HashMap<Player, ArrayList<Card>> testMap = goFishTest.getHashMap();
        ArrayList<Card> player1Hand = testMap.get(p1);

        player1Hand.add(new Card(Suit.CLUBS, Color.BLACK, Rank.ACE));
        player1Hand.add(new Card(Suit.HEARTS, Color.RED, Rank.FIVE));
        player1Hand.add(new Card(Suit.CLUBS, Color.BLACK, Rank.QUEEN));
        player1Hand.add(new Card(Suit.SPADES, Color.BLACK, Rank.DEUCE));
        player1Hand.add(new Card(Suit.DIAMONDS, Color.RED, Rank.ACE));

        boolean actual = goFishTest.pullFromDeck(p1, Rank.QUEEN);
        boolean expected = true;

        Assert.assertEquals(expected, actual);

    }
    
    @Test
    public void showHandTest(){

        String actual1 = goFishTest.showHand(p1);
        String actual2 = goFishTest.showHand(p2);

        String expected1 = "";
        String expected2 = "";

        Assert.assertEquals(expected1, actual1);
        Assert.assertEquals(expected2, actual2);
    }
}
   