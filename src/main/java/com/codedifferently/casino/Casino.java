package com.codedifferently.casino;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

import com.codedifferently.casino.games.BlackJack;
import com.codedifferently.casino.utilities.Card;
import com.codedifferently.casino.utilities.Player;

public class Casino {
    public static void main(String[] args){
        // For testing
        boolean gamePlaying=false;
        Scanner scan=new Scanner(System.in);
        BlackJack blackjack = new BlackJack();
        Player bob=new Player("Bob",21,2030.00);
        Player bill=new Player("Bill",25,3400.00);
        Player jill=new Player("Jill",24,8000.00);
        Player lil=new Player("Lil",22,1000.00);
        Player john=new Player("John",21,900.00);
        Queue<Player> queue=new LinkedList<Player>();
        queue.add(bob);
        queue.add(bill);
        queue.add(jill);
        queue.add(lil);
        queue.add(john);

        while(!queue.isEmpty()){
            Player currentPlayer=queue.poll();
            if(blackjack.addPlayer(currentPlayer)){
                System.out.printf("%s has joined the game %s\n",currentPlayer.getName(),blackjack.getGameName());
            }
            else{
                System.out.printf("%s could not join the game %s\n",currentPlayer.getName(),blackjack.getGameName());
            }
        }
        System.out.printf("What would you like to play? \n (Go Fish) (Black Jack) (Craps) (Roulette)(Seven Free slots)\n");
        String gameChoice=scan.nextLine();
        if(gameChoice.equalsIgnoreCase("Black Jack")){
            if(blackjack.startGame()){
                gamePlaying=true;
                blackjack.setUp();
                blackjack.shuffleDeck();
                while(gamePlaying){
                        System.out.println("SIZE OF PLAYING: "+blackjack.getPlayerList().size());
                        for (Player player : blackjack.getPlayerList()) {
                            Player currentPlayer=player;
                            System.out.printf("%s place your bet: ", currentPlayer.getName());
                            double bet=scan.nextDouble();
                            blackjack.bet(currentPlayer, bet);
                        }
                        System.out.println(blackjack.betLog());
                        for (Player player : blackjack.getPlayerList()){
                            Player currentPlayer=player;
                            checkHand(currentPlayer);
                            System.out.printf("Current total: %s\n", blackjack.convertToNumber(player));
                            System.out.printf("%s, What would you like to do? \n (Hit) (Stand) (Double)\n",currentPlayer.getName());
                            String choice=scan.next();
                            while(!choice.equalsIgnoreCase("Stand")){
                                if(choice.equalsIgnoreCase("Hit")){
                                    blackjack.win(currentPlayer);
    
                                }
                                else if(choice.equalsIgnoreCase("Double")){
                                    blackjack.lose(currentPlayer);
    
                                }
                                checkHand(currentPlayer);
                                System.out.printf("%s, What would you like to do? \n (Hit) (Stand) (Double)\n",currentPlayer.getName());
                                choice=scan.next();
    
                            }
                            
    
                        }
                        System.out.println(blackjack.outcomeLog());
                        gamePlaying=false;
                    }
                    scan.close();
                }
            else
                System.out.println("Not enough players to start.");
        }

        


        


    }
    static void checkHand(Player player){
        System.out.printf("------ %s's Hand -----\n", player.getName());
        for (Card card : player.checkCards()) {
            System.out.printf("%s %s %s\n",card.getColor(),card.getRank(),card.getSuit());
        }
    }
}
