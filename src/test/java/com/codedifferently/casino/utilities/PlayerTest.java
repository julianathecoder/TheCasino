package com.codedifferently.casino.utilities;

import java.util.ArrayList;

import org.junit.Assert;
import org.junit.Test;

public class PlayerTest {

    @Test
    public void constructorTest(){
        // Given
        String name="Bob";
        int age=21;
        double money=2000.00;

        // When
        Player player=new Player(name,age,money);
        String actualName=player.getName();
        int actualAge=player.getAge();
        double actualMoney=player.getMoney();

        // Then
        Assert.assertEquals(name,actualName);
        Assert.assertEquals(age,actualAge);
        Assert.assertEquals(money,actualMoney,0.00001);
    }

    @Test
    public void getNameTest(){
        // Given
        String name="Bob";
        int age=21;
        double money=2000.00;

        // When
        Player player=new Player(name,age,money);
        String actualName=player.getName();

        // Then
        Assert.assertEquals(name,actualName);

    }

    @Test
    public void getAgeTest(){
        // Given
        String name="Bob";
        int age=21;
        double money=2000.00;

        // When
        Player player=new Player(name,age,money);
        int actualAge=player.getAge();

        // Then
        Assert.assertEquals(age,actualAge);
    }

    @Test
    public void getMoneyTest(){
        // Given
        String name="Bob";
        int age=21;
        double money=2000.00;

        // When
        Player player=new Player(name,age,money);
        double actualMoney=player.getMoney();

        // Then
        Assert.assertEquals(money,actualMoney,0.00001);
    }

    @Test
    public void giveMoneyTest(){
        // Given
        String name="Bob";
        int age=21;
        double money=2000.00;
        double expected=3000.00;

        // When
        Player player=new Player(name,age,money);
        player.giveMoney(1000.00);
        double actualMoney=player.getMoney();

        // Then
        Assert.assertEquals(expected,actualMoney,0.00001);
    }

    @Test
    public void gambleTest(){
        // Given
        String name="Bob";
        int age=21;
        double money=2000.00;
        double expected=1000.00;

        // When
        Player player=new Player(name,age,money);
        player.gamble(1000.00);
        double actualMoney=player.getMoney();

        // Then
        Assert.assertEquals(expected,actualMoney,0.00001);
    }

    @Test
    public void gambleTest2(){
        // Given
        String name="Bob";
        int age=21;
        double money=2000.00;
        double expected=0.00;

        // When
        Player player=new Player(name,age,money);
        player.gamble(6000.00);
        double actualMoney=player.getMoney();

        // Then
        Assert.assertEquals(expected,actualMoney,0.00001);
    }

    @Test
    public void gambleTest3(){
        // Given
        String name="Bob";
        int age=21;
        double money=2000.00;
        double expected=2000.00;

        // When
        Player player=new Player(name,age,money);
        double actualMoney=player.gamble(6000.00);

        // Then
        Assert.assertEquals(expected,actualMoney,0.00001);
    }

    @Test
    public void getHandTest(){
        // Given
        String name="Bob";
        int age=21;
        double money=2000.00;
        Card card=new Card(null, null,null);
        ArrayList<Card> expected=new ArrayList<Card>();
        expected.add(card);
        expected.add(card);

        // When
        Player player=new Player(name,age,money);
        player.giveCard(card);
        player.giveCard(card);
        ArrayList<Card> actual=player.checkCards();
        

        // Then
        Assert.assertEquals(expected,actual);
    }

    @Test
    public void clearHandTest(){
        // Given
        String name="Bob";
        int age=21;
        double money=2000.00;
        int expected=0;

        // When
        Player player=new Player(name,age,money);
        player.giveCard(new Card(null, null, null));
        player.giveCard(new Card(null, null, null));
        player.giveCard(new Card(null, null, null));
        player.emptyHand();
        int actual=player.getHandSize();
        

        // Then
        Assert.assertEquals(expected,actual);
    }

    @Test
    public void getHandSizeTest(){
        // Given
        String name="Bob";
        int age=21;
        double money=2000.00;
        int expected=5;

        // When
        Player player=new Player(name,age,money);
        player.giveCard(new Card(null, null, null));
        player.giveCard(new Card(null, null, null));
        player.giveCard(new Card(null, null, null));
        player.giveCard(new Card(null, null, null));
        player.giveCard(new Card(null, null, null));
        int actual=player.getHandSize();
        

        // Then
        Assert.assertEquals(expected,actual);
    }
    
}