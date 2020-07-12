package com.codedifferently.casino;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Random;
import java.util.Scanner;

import com.codedifferently.casino.games.BlackJack;
import com.codedifferently.casino.games.Roulette;
import com.codedifferently.casino.games.SevenFreeSlots;
import com.codedifferently.casino.utilities.Card;
import com.codedifferently.casino.utilities.Player;
import com.codedifferently.casino.utilities.Rules;

public class Casino {
    public static void main(String[] args){
        // For testing
        boolean gamePlaying=false;
        Scanner scan=new Scanner(System.in);
        Player bob=new Player("Bob",20,2030.00);
        Player bill=new Player("Bill",25,3400.00);
        Player jill=new Player("Jill",20,8000.00);
        Player lil=new Player("Lil",19,1000.00);
        Player john=new Player("John",21,900.00);
        Queue<Player> queue=new LinkedList<Player>();
        queue.add(bob);
        queue.add(jill);
        queue.add(bill);
        queue.add(lil);
        queue.add(john);

        System.out.printf("What would you like to play? \n (Go Fish) (Black Jack) (Craps) (Roulette)(Seven Free slots)\n");
        String gameChoice=scan.nextLine();
        if(gameChoice.equalsIgnoreCase("Black Jack")){
            BlackJack blackjack = new BlackJack();
            while(!queue.isEmpty()){
                Player currentPlayer=queue.poll();
                if(blackjack.checkIfValid(currentPlayer)){
                    if(blackjack.addPlayer(currentPlayer))
                        System.out.printf("%s has joined the game %s\n",currentPlayer.getName(),blackjack.getGameName());
                }
                else{
                    System.out.printf("%s could not join the game %s\n",currentPlayer.getName(),blackjack.getGameName());
                }
            }
            System.out.printf("Do you want to read the rules of Black Jack? Yes/No \n");
            gameChoice=scan.nextLine();
            if(gameChoice.equalsIgnoreCase("yes"))
                System.out.println("\n"+Rules.blackJackRules()+"\n");
            if(blackjack.startGame()){
                gamePlaying=true;
                blackjack.setUp();
                while(gamePlaying){
                        System.out.println("SIZE OF PLAYING: "+blackjack.getPlayerList().size());
                        for (Player player : blackjack.getPlayerList()) {
                            Player currentPlayer=player;
                            System.out.printf("%s place your bet: ", currentPlayer.getName());
                            double bet=scan.nextDouble();
                            blackjack.bet(currentPlayer, bet);
                        }
                        System.out.println(blackjack.betLog());
                        // Iterating through players and having them make their choices
                        for (Player player : blackjack.getPlayerList()){
                            Player currentPlayer=player;
                            boolean done=false;
                            // Displays current player's hand
                            checkHand(currentPlayer,blackjack);

                            // Checks for Ace
                            if(blackjack.checkForAce(player))
                                System.out.printf("Possible outcomes with aces: %s\n", blackjack.convertWithAces(player).toString());

                            // Asking player until stand or bust
                            System.out.printf("%s, What would you like to do? \n (Hit) (Stand) (Double)\n",currentPlayer.getName());
                            String choice=scan.next();
                            while(!choice.equalsIgnoreCase("Stand") && done==false){
                                // Choosing player decision
                                if(choice.equalsIgnoreCase("Hit"))
                                    blackjack.hit(currentPlayer);
                                else if(choice.equalsIgnoreCase("Double")){
                                    blackjack.doubleMove(currentPlayer); 
                                    checkHand(currentPlayer,blackjack);
                                    done=true;
                                }
                                // Checks if player busted
                                if(blackjack.checkIfBusted(currentPlayer)){
                                    done=true;
                                    checkHand(currentPlayer,blackjack);
                                    blackjack.lose(currentPlayer);
                                    System.out.println("You have busted, thank you for playing.");
                                }
                                // Makes sure if the user ended their turn without busting
                                if(!done){
                                    if(blackjack.checkForAce(player))
                                        System.out.println(blackjack.convertWithAces(player));
                                    checkHand(currentPlayer,blackjack);
                                    System.out.printf("%s, What would you like to do? \n (Hit) (Stand) (Double)\n",currentPlayer.getName());
                                    choice=scan.next();
                                }
                            }
                            // Checking if player busted and added to standing players waiting for results
                            if(!blackjack.checkIfBusted(currentPlayer))
                                blackjack.addStandingPlayer(currentPlayer);
                        }
                        blackjack.calculateWinner();
                        System.out.println(blackjack.outcomeLog());
                        System.out.printf("Do you want to play again?: Yes/No\n");
                        gameChoice=scan.next();
                        if(gameChoice.equalsIgnoreCase("yes")){
                            blackjack.resetGame();
                            blackjack.setUp();
                        }
                        else
                            gamePlaying=false;
                    }
                    scan.close();
                }
            else
                System.out.println("Not enough players to start, add more players.");
        } else if(gameChoice.equalsIgnoreCase("Seven Free Slots")){
            SevenFreeSlots sevenFreeSlots = new SevenFreeSlots();
            Player player = new Player("jon", 19, 9);
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
        } 
        
        else if (gameChoice.equalsIgnoreCase("Roulette")){
            Roulette roulette = new Roulette();
            Player player = new Player("Kevin", 21, 1000);
            Scanner input = new Scanner(System.in);
            System.out.println("Welcome to the Roulette Game...");
            System.out.println("Have you played before? Y/N.");
            String vCheck1 = input.nextLine();
    
            //Removes invalid inputs.
            while (!(vCheck1.equals("Y")) && !(vCheck1.equals("N"))) {
                System.out.println("Incorrect, please type Y/N.");
                vCheck1 = input.nextLine();
            }
    
            //If user inputs 'Y' (Yes), print below.
            if (vCheck1.equals("Y")) {
                System.out.println("Good luck!");
            }
    
            //If user inputs 'N' (No), print Rules for Roulette.
            if (vCheck1.equals("N")) {
                System.out.println(Rules.rouletteRules());
                try {
                    Thread.sleep(10000);
                } catch (InterruptedException ex) {
                    Thread.currentThread().interrupt();
                }

        String confirmationCashout = "";
        String confirmationRestart = "";
        String bet = "";
        String answer = "";
        int winStreak = 0;
        int gamble = 0;
        int payout = 0;
        int randomNum = 0;
        int money = 1000;
        int rounds = 1;
        Random rand = new Random();
    
        }
    }

        


        


    }
    static void checkHand(Player player, BlackJack game){
        System.out.printf("------ %s's Hand -----\n", player.getName());
        for (Card card : player.checkCards()) {
            System.out.printf("%s %s %s\n",card.getColor(),card.getRank(),card.getSuit());
        }
        System.out.printf("Current total: %s\n", game.convertToNumber(player));
         System.out.println();
        
    }
}
