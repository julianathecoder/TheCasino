package com.codedifferently.casino.games;


import java.util.Random;
import java.util.Scanner;

import com.codedifferently.casino.intereface.Gamble;
import com.codedifferently.casino.intereface.Game;
import com.codedifferently.casino.utilities.BallResults;
import com.codedifferently.casino.utilities.Player;





public class Roulette {

    public static void main(String[] args) {
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
    

}
