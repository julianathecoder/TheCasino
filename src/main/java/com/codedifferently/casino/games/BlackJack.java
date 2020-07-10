package com.codedifferently.casino.games;

import java.util.ArrayList;
import java.util.HashMap;

import com.codedifferently.casino.intereface.Gamble;
import com.codedifferently.casino.utilities.Card;
import com.codedifferently.casino.utilities.Dealer;
import com.codedifferently.casino.utilities.Player;

public class BlackJack extends CardGame implements Gamble {
    private HashMap<Player,Double> bets;
    private ArrayList<Player> notBustedPlayers;
    private Dealer dealer;

    public BlackJack(){
        super("Black Jack", 11, 1);
        this.bets=new HashMap<Player,Double>();
        this.dealer=new Dealer();
        this.notBustedPlayers=new ArrayList<Player>();
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

    public void addStandingPlayer(Player player){
        this.notBustedPlayers.add(player);
    }

    public void hit(Player player){
        player.giveCard(deck.pullFromDeck());//this.dealer.dealCard(player);
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

    public void doubleMove(Player player){
        player.giveCard(deck.pullFromDeck());//this.dealer.dealCard(player);
        double moneyDoubled=this.bets.get(player) * 2;
        this.bets.remove(player);
        bet(player, moneyDoubled);
    }

    public void insurance(Player player){

    }
    
    public void setUp(){
        if(super.startGame()){
            super.dealCards(2);
        }
    }

    public boolean checkIfBusted(Player player){
        return convertToNumber(player) >= 22 || convertToNumber(player) == 0 ;
    }

    public int convertToNumber(Player player){
        int total=0;
        for (Card card : player.checkCards()) {
            total+=card.getRank().returnRank();
        }
        return total;
    }

    public void calculateWinner(){
       int dealerTotal=15; //dealer.getValueOfCards;
       while(dealerTotal < 16){
           this.dealer.pullFromDeck();
           dealerTotal=17; //dealer.getValueOfCards;
       }
        int largestNumber=0;
        for (Player player : getPlayerList()) {
            int number= convertToNumber(player);
            if(number==21)
                win(player);
            else if(number<21 && number > largestNumber){
                largestNumber=number;
                
            }

        }
    }

    public boolean checkForAce(Player player){
        for (Card card : player.checkCards()) {
            if(card.getRank().returnRank()==1)
                return true;
        }
        return false;
    }

    



    

    
}

