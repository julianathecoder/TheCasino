package com.codedifferently.casino.utilities;

import javax.sound.midi.Track;

import org.junit.Test;

/**
 * @author Juliana Paul
 */

public class DiceTest {

    @Test
    public void constructorTest(){

    }

    @Test
    public void rollTest(){

        Dice dice = new Dice(6);
        int actual = dice.roll();

        if(actual >= 1 && actual <= 6){
            assert(true);
        } else {
            assert(false);
        }

    }

    @Test
    public void numRollTest(){

    }
    
}