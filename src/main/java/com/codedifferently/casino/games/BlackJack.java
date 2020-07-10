package com.codedifferently.casino.games;

import java.util.HashMap;

import com.codedifferently.casino.intereface.Gamble;
import com.codedifferently.casino.utilities.Card;
import com.codedifferently.casino.utilities.Dealer;
import com.codedifferently.casino.utilities.Player;

public class BlackJack extends CardGame implements Gamble {
    private HashMap<Player,Double> bets;
    private Dealer dealer;

    public BlackJack(){
        super("Black Jack", 11, 1);
        this.bets=new HashMap<Player,Double>();
        this.dealer=new Dealer();
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

    public String outcomeLog(){
        String output="\\---------- RESULTS ----------/\n";
        for (Player player : this.bets.keySet()) {
            output+= "\t"+player.getName() +": "+bets.get(player)+"\n";
        }
        this.bets.clear();
        return output;
    }

    public void clearBets(){
        this.bets.clear();
    }

    public void hit(Player player){
        player.giveCard(this.dealer.pullFromDeck());
        int total=convertToNumber(player);
        if(total==21)
            win(player);
        else if(convertToNumber(player)>21)
            lose(player);
    }

    public void win(Player player) {
        double winnings=this.bets.get(player)*2;
        player.giveMoney(winnings);
        this.bets.replace(player, winnings);
        player.emptyHand();

    }

    public void lose(Player player) {
        double lose=this.bets.get(player);
        this.bets.replace(player, -lose);
        player.emptyHand();

    }
    
    public void setUp(){
        if(super.startGame()){
            super.dealCards(2);
        }
    }

    public int convertToNumber(Player player){
        int total=0;
        for (Card card : player.checkCards()) {
            total+=card.getRank().returnRank();
        }
        return total;
    }



    

    
}

