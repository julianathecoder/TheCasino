package com.codedifferently.casino.utilities;

import org.junit.Assert;
import org.junit.Test;

/**
 * @author Juliana Paul
 */

public class DiceTest {

    @Test
    public void constructorTest(){
        //Given
        Dice roll = new Dice();
        int expectedRoll = roll.roll();

        //When
        int actualRoll = Dice.getRollTotal();

        //Then
        Assert.assertEquals(expectedRoll, actualRoll);
    }

    @Test
    public void rollTest(){
        //Given 
        Dice rollTest = new Dice();
        int expectedRoll = rollTest.getDie1() + rollTest.getDie2();

        //When
        int actualRoll = Dice.getRollTotal();

        //Then
        Assert.assertEquals(expectedRoll, actualRoll);
    }

    @Test
    public void getDie1Test(){
        //Given 
        Dice rollTest = new Dice();
        int expectedRoll = rollTest.getDie1();

        //When
        int actualRoll = rollTest.getDie1();

        //Then
        Assert.assertEquals(expectedRoll, actualRoll);
    }

    @Test
    public void getDie2Test(){
        //Given 
        Dice rollTest = new Dice();
        int expectedRoll = rollTest.getDie2();

        //When
        int actualRoll = rollTest.getDie2();

        //Then
        Assert.assertEquals(expectedRoll, actualRoll);
    }

    @Test
    public void getRollTotalTest() {
        //Given 
        int expectedRoll = Dice.getRollTotal();

        //When
        int actualRoll = Dice.getRollTotal();

        //Then
        Assert.assertEquals(expectedRoll, actualRoll);
    }
}