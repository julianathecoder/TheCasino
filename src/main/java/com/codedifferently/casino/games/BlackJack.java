package com.codedifferently.casino.games;

import java.util.HashMap;

import com.codedifferently.casino.intereface.Gamble;
import com.codedifferently.casino.utilities.Player;

public class BlackJack extends CardGame implements Gamble {
    private HashMap<Player,Double> bets;

    public BlackJack(){
        super("Black Jack", 11, 1);
        this.bets=new HashMap<Player,Double>();
    }

    public int getBetCount(){
        return this.bets.size();
    }

    public void bet(Player player,double money) {
        money=player.gamble(money);
        this.bets.put(player, money);
    }
    
    public String betLog(){
        String output="\\---------- BETS ----------/\n";
        for (Player player : this.bets.keySet()) {
            output+= "\t"+player.getName() +": "+bets.get(player)+"\n";
        }
        return output;
    }

    public void clearBets(){
        this.bets.clear();
    }

    public void win(Player player) {
        double winnings=this.bets.get(player)*2;
        player.giveMoney(winnings);
        this.bets.remove(player);
        player.emptyHand();

    }

    public void lose(Player player) {
        this.bets.remove(player);
        player.emptyHand();

    }

    
}

