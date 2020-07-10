package com.codedifferently.casino.games;

import java.util.HashMap;
import java.util.ArrayList;

import com.codedifferently.casino.utilities.Card;
import com.codedifferently.casino.utilities.Player;
import com.codedifferently.casino.utilities.cardenums.Rank;

/**
 * @author Keseana Howard
 */

public class GoFish extends CardGame{
    
    private HashMap<Player, ArrayList<Card>> hmap;
    private ArrayList<Card> stockPile = new ArrayList<Card>();
    private int cardsPerPerson;
    private int totalBookCount = 0;
    private HashMap<Player,ArrayList<Rank>> bookLog = new HashMap<Player, ArrayList<Rank>>();
 

    public GoFish(){

        super("Go Fish", 6, 2);
        this.hmap = new HashMap<Player, ArrayList<Card>>();
        
    }

    public void setCardNumber(){
        if(hmap.size() == 2 || hmap.size() == 3)
            cardsPerPerson = 7;
        else if(hmap.size() > 3 && hmap.size() <= 6)
            cardsPerPerson = 5;
        else
            cardsPerPerson = 0;
    }

    public void initializePlayers(){
        for(Player player :  players){
            hmap.put(player, new ArrayList<Card>());
        }
    }

    public int getCardsPerPerson(){
        return cardsPerPerson;
    }

    public boolean ask(Player playerAsked, Rank rankWanted){
        ArrayList<Card> hand = hmap.get(playerAsked);

        boolean cardFound = checkHand(hand, rankWanted);

        return cardFound;
    }

    public boolean checkHand(ArrayList<Card> hand, Rank rankWanted){
        
        for(Card current : hand){
            Rank rank = current.getRank();
            if(rank.equals(rankWanted))
                return true;
        }
        return false;
    }

    public void giveCards(Player playerAsking, Player playerAsked, Rank rankWanted){
        ArrayList<Card> removeCards = hmap.get(playerAsked);
        ArrayList<Card> addCards = hmap.get(playerAsking);

        for(Card current : removeCards){
            if(current.getRank().equals(rankWanted)){
                removeCards.remove(current);
                addCards.add(current);
            }
        }
    }

    public boolean pullFromDeck(Player player, Rank rankWanted){

        ArrayList<Card> hand = hmap.get(player);
        Card newCard = pullFromDeck();

        for(Card c : hand){
            if(c.getRank().equals(newCard.getRank())){
                hand.add(newCard);
                return true;
            }                
            else
                addToStockPile(newCard);
        }
        return false;
    }

    public void createBookLog(){
        for(Player player : hmap.keySet()){
            bookLog.put(player, null);
        }
    }

    public void addBook(Player player, Rank rank){
        for(ArrayList<Rank> r : bookLog.values()){
            for(Rank currentRank : r){
                if(!(currentRank.equals(rank))){
                    ArrayList<Rank> ranks = bookLog.get(player);
                    ranks.add(rank);
                }
            }
        }
    }

    public boolean checkForBooks(Player player){
        int count = 0;

        ArrayList<Card> hand = hmap.get(player);

        for(Card one : hand){
            for(Card two : hand){
                if(one.getRank().equals(two.getRank()))
                    count++;
            }

            if(count == 4){ 
                for(int i = 0; i < 4; i++)
                    hand.remove(one);
                
                totalBookCount ++;
                Rank rankToAdd = one.getRank();
                addBook(player, rankToAdd);
                return true;
            }
        }
        return false;
    }

    public void addToStockPile(Card card){
       stockPile.add(card);
    }

    public void playerTurn(Player playerAsking, Player playerAsked, Rank rankWanted){
        boolean gotCards = ask(playerAsked, rankWanted);

        if(gotCards)
            giveCards(playerAsking, playerAsked, rankWanted);
        else{
            pullFromDeck(playerAsking, rankWanted);
        
        checkForBooks(playerAsking);
        }
    }

    public void deal(){
        dealCards(cardsPerPerson);
    }

    public String showBooks(Player player){
        ArrayList<Rank> out = bookLog.get(player);

        String output = String.format("Number of Books: %d \tBooks: %s", out.size(), out.toString());

        return output;
    }

    public String showHand(Player player){
        ArrayList<Card> hand = hmap.get(player);

        String output = String.format("%s's Hand: %s", player.getName(), hand.toString());

        return output;
    }

    public static void main(String[] args) {
        GoFish goFishTest = new GoFish();
        Player p1 = new Player("Eli", 15, 0);
        Player p2 = new Player("Azlia", 18, 0);

        goFishTest.addPlayer(p1);
        goFishTest.addPlayer(p2);

        goFishTest.initializePlayers();
        goFishTest.setCardNumber();

        ArrayList<Player> p = goFishTest.getPlayerList();

        for(Player pl : p){
            System.out.println(pl.getName());
        }

        System.out.println(goFishTest.getCardsPerPerson());
    }
}