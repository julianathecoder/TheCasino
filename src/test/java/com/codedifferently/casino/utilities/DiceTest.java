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
        int actualRoll = roll.getRollTotal();

        //Then
        Assert.assertEquals(expectedRoll, actualRoll);
    }

    @Test
    public void rollTest(){
        //Given 
        Dice rollTest = new Dice();
        int expectedRoll = rollTest.getDie1() + rollTest.getDie2();

        //When
        int actualRoll = rollTest.getRollTotal();

        //Then
        Assert.assertEquals(expectedRoll, actualRoll);

    }
}