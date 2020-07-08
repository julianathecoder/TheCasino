package com.codedifferently.casino.utilities;

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
    
}