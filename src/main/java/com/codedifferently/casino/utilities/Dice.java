package com.codedifferently.casino.utilities;
import java.util.Random;
/**
 * @author Juliana Paul
 */
public class Dice {

    private int myRollCount;   // # times rolled
    private int Sides;          // # sides
    private Random myRandGen;   //the random number generator

    //Construct standard six-sided Dice object
    public Dice(){
	this(6);
    }
    
    /**
     * Constructs a Dice object.
     * @param sides specifies the number of "sides" for the die, e.g., 
     */
    public Dice(int sides){
	Sides = sides;
	myRandGen = new Random();
    }

    //return a random value in range [1..numSides()]
    public int roll(){
    myRollCount++;
	return myRandGen.nextInt(Sides) + 1;
    }

    public int numRolls(){
	return myRollCount;
    }
    
    public static void main(String[] args) 
    {
	Dice die = new Dice(6);
	
	for(int k = 0; k < 2; k++)
	{
	    int roll = die.roll();
	    System.out.println("roll " + die.numRolls() + ": " + roll);
    }
}
}