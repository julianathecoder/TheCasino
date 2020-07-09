package com.codedifferently.casino.games;

import com.codedifferently.casino.utilities.Player;

import org.junit.Assert;
import org.junit.Test;

public class BlackJackTest {

    @Test
    public void constructorTest(){
        // Given
        int size=0;

        // When
        BlackJack game=new BlackJack();
        int actual=game.getBetCount();

        // Then
        Assert.assertEquals(size, actual);
    }


    @Test
    public void getBetsCountTest(){
        // Given
        int size=0;

        // When
        BlackJack game=new BlackJack();
        int actual=game.getBetCount();

        // Then
        Assert.assertEquals(size, actual);
    }
    
    @Test
    public void betTest(){
        // Given
        int size=5;

        // When
        BlackJack game=new BlackJack();
        game.bet(new Player("Bill", 21, 2334.00),100.00);
        game.bet(new Player("Jill", 21, 2334.00),100.00);
        game.bet(new Player("Rill", 21, 2334.00),100.00);
        game.bet(new Player("Lill", 21, 2334.00),100.00);
        game.bet(new Player("Aill", 21, 2334.00),100.00);
        int actual=game.getBetCount();

        // Then
        Assert.assertEquals(size, actual);
    }

    @Test
    public void betLogTest(){
        // Given
        String output="Aill: 100.0\n";

        // When
        BlackJack game=new BlackJack();
        game.bet(new Player("Aill", 21, 2334.00),100.00);
        String actual=game.betLog();

        // Then
        Assert.assertEquals(output, actual);
    }

    @Test
    public void clearTest(){
        // Given
        int size=0;

        // When
        BlackJack game=new BlackJack();
        game.bet(new Player("Bill", 21, 2334.00),100.00);
        game.bet(new Player("Jill", 21, 2334.00),100.00);
        game.bet(new Player("Rill", 21, 2334.00),100.00);
        game.bet(new Player("Lill", 21, 2334.00),100.00);
        game.bet(new Player("Aill", 21, 2334.00),100.00);
        game.clearBets();
        int actual=game.getBetCount();

        // Then
        Assert.assertEquals(size, actual);
    }

    @Test
    public void winTest(){
        // Given
        double start=2000.00;
        double money=4000.00;
        Player bill=new Player("Bill", 21, 2000.00);

        // When
        BlackJack game=new BlackJack();
        double actualStart=bill.getMoney();
        game.bet(bill, 2000);
        game.win(bill);
        double actualProfit=bill.getMoney();

        // Then
        Assert.assertEquals(start, actualStart,0.00001);
        Assert.assertEquals(money, actualProfit,0.0001);
    }

    @Test
    public void loseTest(){
        // Given
        double start=2000.00;
        double money=0.00;
        Player bill=new Player("Bill", 21, 2000.00);

        // When
        BlackJack game=new BlackJack();
        double actualStart=bill.getMoney();
        game.bet(bill, 2000);
        game.lose(bill);
        double actualProfit=bill.getMoney();

        // Then
        Assert.assertEquals(start, actualStart,0.00001);
        Assert.assertEquals(money, actualProfit,0.0001);
    }
}