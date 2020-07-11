package com.codedifferently.casino.games;

import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;

import com.codedifferently.casino.intereface.Gamble;
import com.codedifferently.casino.utilities.Player;

public class SevenFreeSlots implements Gamble {

    final static ArrayList<String> slots = new ArrayList<String>(50);

    public SevenFreeSlots() {

        slots.add("7RED");
        slots.add("7BLUE");
        slots.add("7WHITE");
        slots.add("BAR");
        slots.add("CHERRY");
        slots.add("WILD");
        slots.add("BLANK");
    }

    public void setUp() {
    }

    // Game buttons
    public void spinReels(Player player) {
        player.gamble(3);

        double slotPick = Math.random();
        for (int i = 0; i < slots.size(); i++) {
            System.out.println(slots.get(i));
        }
    }

    public void betMax(Player player) {
        player.gamble(3);
    }

    public String getRandomElement(ArrayList<String> ArrList) 
    { 
        Random rand = new Random(); 
        return ArrList.get(rand.nextInt(ArrList.size())); 
    } 

    public void betOne(Player player) {
        player.gamble(1);

        // TODO: Push a button marked "Bet One" until you've reached the number of coins
        // you wish to play
        // Then when spin reels is pressed deduct that amount of coins from player money
    }

    // Stats
    public void win(Player player) {
        // TODO: calculate winnings for current bet and update money

        // TODO: report if Gambler won or lost

        // TODO: Check to see if they still have money left

    }

    public void lose(Player player) {

    }

    public void bet(Player player, double money) {

    }

    public static void main(String[] args) {
        SevenFreeSlots sevenFreeSlots = new SevenFreeSlots();
        Player player = new Player("jon", 19, 9);
        Scanner scan = new Scanner(System.in);
        sevenFreeSlots.spinReels(player);

        System.out.println("Welcome to 7 Free Slots !");
        System.out.printf("Push a button. \n (Bet One) (Bet Max) (SPIN REELS)\n");
        String buttonSelected = scan.nextLine();
        if (buttonSelected.equalsIgnoreCase("Bet One")) {
            System.out.println("SPINNING!\n");
            try {
                Thread.sleep(1000);
            } catch (InterruptedException ex) {
                Thread.currentThread().interrupt();
            }
        }
        System.out.println(sevenFreeSlots.getRandomElement(slots));

}
}