package com.codedifferently.casino.utilities;
/**
 * @author Juliana Paul
 */
public class Dice {
    
    private int die1;
    private int die2;

    /**
     * Constructor. Rolls the dice, so they initially show some random values.
     */
    
    public Dice(){ 
        roll();
    }
    
    public int roll(){

        die1 = (int)(Math.random()*6) + 1; // 1-6 inclusive
        die2 = (int)(Math.random()*6) + 1;
        return die1 + die1;
    }

    public int getDie1(){
        
        return die1;
    }

    public int getDie2(){
        
        return die2;
    }

    public int getRollTotal(){

        return die1 + die2;
    }

    public static void main(String[] args) {
    
        int die1;  
        int die2;  
        int roll;  
        
        die1 = (int)(Math.random()*6) + 1;
        die2 = (int)(Math.random()*6) + 1;
        roll = die1 + die2;
        
        System.out.println("The first die comes up " + die1);
        System.out.println("The second die comes up " + die2);
        System.out.println("Your total roll is " + roll);
    }
}