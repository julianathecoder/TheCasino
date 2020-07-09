package com.codedifferently.casino.games;


import java.util.Random;
import java.util.Scanner;

import com.codedifferently.casino.intereface.Gamble;
import com.codedifferently.casino.intereface.Game;
import com.codedifferently.casino.utilities.BallResults;
import com.codedifferently.casino.utilities.Player;
import com.codedifferently.casino.utilities.Rules;





public class Roulette {

/**     public static void main(String[] args) {
        Random r = new Random();
        int money = 1000;

        Scanner player = new Scanner(System.in);
        System.out.println("Please enter bet.");


        int betMoney = player.nextInt();

        int bet = Math.min(betMoney, money);
            
            int spinNumber = r.nextInt(37);
            //int spinColor = 

            if (spinNumber != 0 && spinNumber <= 18) {
                money = money + bet;
            } else {
                money = money - bet;
            }

            System.out.println("betting $" + bet + ", spin is " + spinNumber + ", money now = $" + money);
            System.out.println("Would you want to spin again?");

        player.close();
    }
    */
    
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.println("Welcome to the Roulette Game...");
        System.out.println("Have you played before? Y/N.");
        String vCheck1 = input.nextLine();
    
        //Validation Check -- Removes invalid inputs.
        while (!(vCheck1.equals("y")) && !(vCheck1.equals("n"))) {
            System.out.println("Incorrect, please type Y/N.");
            vCheck1 = input.nextLine();
        }
    
        //If user inputs 'y' (yes), print below.
        if (vCheck1.equals("y")) {
            System.out.println("Good luck!");
        }
    
        //If user inputs 'n' (no), print Rules for Roulette from Rules.
        if (vCheck1.equals("n")) {
            Rules.rouletteRules();
            try {
                Thread.sleep(10000);
            } catch (InterruptedException ex) {
                Thread.currentThread().interrupt();
            }
    
        }
        try {
            Thread.sleep(2000);
        } catch (InterruptedException ex) {
            Thread.currentThread().interrupt();
        }
    
        // Setting up variables to be updated in the loop to be printed after game.
        String confirmationCashout = "";
        String confirmationRestart = "";
        String bet = "";
        String answer = "";
        int winStreak = 0;
        int gamble = 0;
        int payout = 0;
        int randomNum = 0;
        int money = 1000;
        int rounds = 1;;
        Random rand = new Random();

    }
}




