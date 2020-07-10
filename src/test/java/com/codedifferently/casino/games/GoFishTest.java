package com.codedifferently.casino.games;

import com.codedifferently.casino.utilities.Player;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class GoFishTest {

    GoFish goFishTest;
    Player p1;
    Player p2;

    @Before
    public void initialize(){

        goFishTest = new GoFish();
        p1 = new Player("Eli", 15, 0);
        p2 = new Player("Azlia", 18, 0);

        goFishTest.addPlayer(p1);
        goFishTest.addPlayer(p2);

        goFishTest.deal();

    }

    @Test
    public void constructorTest(){

        int actual = goFishTest.getCardsPerPerson();
        int expected = 7;

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
   