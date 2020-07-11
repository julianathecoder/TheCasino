package com.codedifferently.casino.games;

import java.util.HashMap;
import java.util.ArrayList;

import com.codedifferently.casino.utilities.Card;
import com.codedifferently.casino.utilities.Player;
import com.codedifferently.casino.utilities.cardenums.Color;
import com.codedifferently.casino.utilities.cardenums.Rank;
import com.codedifferently.casino.utilities.cardenums.Suit;

/**
 * @author Keseana Howard
 */

public class GoFish extends CardGame{
    
    private HashMap<Player, ArrayList<Card>> hmap;
    private ArrayList<Card> stockPile = new ArrayList<Card>();
    private int cardsPerPerson;
    private int totalBookCount = 0;
    private HashMap<Player, ArrayList<Rank>> bookLog = new HashMap<Player, ArrayList<Rank>>();

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
        ArrayList<Card> hand = playerAsked.checkCards();

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

    public HashMap<Player, ArrayList<Card>> getHashMap(){
        return hmap;
    } 

    public void giveCards(Player playerAsking, Player playerAsked, Rank rankWanted){
        ArrayList<Card> removeCards = hmap.get(playerAsked);
        ArrayList<Card> addCards = hmap.get(playerAsking);
        ArrayList<Card> temp = new ArrayList<Card>();

        for(Card current : removeCards){
            if(current.getRank().equals(rankWanted)){
                temp.add(current);
            }
        }

        for(Card card : temp){
            removeCards.remove(card);
            addCards.add(card);
        }
    }

    public boolean pullFromDeck(Player player, Rank rankWanted){

        ArrayList<Card> hand = hmap.get(player);
        Card newCard = pullFromDeck();

        if(checkHand(hand, rankWanted)){
            hand.add(newCard);
            return true;
        }

        addToStockPile(newCard);
        return false;
    }

    public HashMap<Player, ArrayList<Rank>> getBookLog(){
        return bookLog;
    }

    public void addToBookLog(Player player, Rank rankWon){
        ArrayList<Rank> ranks = new ArrayList<Rank>();
        ranks.add(rankWon);

        bookLog.put(player, ranks);
    }

    public boolean checkForBooks(Player player){

        ArrayList<Card> hand = hmap.get(player);

        for(Card one : hand){
            int count = 0;
            for(Card two : hand){
                if(one.getRank().equals(two.getRank()))
                    count++;
            }

            if(count == 4)
                return removeBooks(player, one, hand);
        }
        return false;
    }

    public boolean removeBooks(Player player, Card card2, ArrayList<Card> arrList){
            
        ArrayList<Card> temp = new ArrayList<Card>();
        
        for(Card card : arrList)
            if(card.getRank().equals(card2.getRank()))
                temp.add(card);

        for(Card card : temp)
            arrList.remove(card);
            
        totalBookCount++;
        Rank rankToAdd = card2.getRank();
        addToBookLog(player, rankToAdd);

        return true;  
    }

    public int getTotalBookCount(){
        return totalBookCount;
    }

    public int getSizeOfPlayerHand(Player player){
        return hmap.get(player).size();
    }

    public void addToStockPile(Card card){
       stockPile.add(card);
    }

    public ArrayList<Card> getStockPile(){
        return stockPile;
    }

    public void emptyStockPile(){
        deck.repopulateDeck(stockPile);
        stockPile.clear();
    }

    public void playerTurn(Player playerAsking, Player playerAsked, Rank rankWanted){
        boolean gotCards = ask(playerAsked, rankWanted);

        if(gotCards)
            giveCards(playerAsking, playerAsked, rankWanted);
        else
            pullFromDeck(playerAsking, rankWanted);
        
        checkForBooks(playerAsking);
    }

    public void deal(){
        dealCards(cardsPerPerson);
    }

    public int getDeckSize(){
        return deck.getDeckSize();
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

        ArrayList<Card> p1Hand = goFishTest.getHashMap().get(p1);
        ArrayList<Card> p2Hand = goFishTest.getHashMap().get(p2);

        p1Hand.add(new Card(Suit.CLUBS, Color.BLACK, Rank.ACE));
        p1Hand.add(new Card(Suit.HEARTS, Color.RED, Rank.KING));
        p1Hand.add(new Card(Suit.CLUBS, Color.BLACK, Rank.QUEEN));
        p1Hand.add(new Card(Suit.SPADES, Color.BLACK, Rank.KING));
        p1Hand.add(new Card(Suit.DIAMONDS, Color.RED, Rank.ACE));

        p2Hand.add(new Card(Suit.SPADES, Color.BLACK, Rank.ACE));
        p2Hand.add(new Card(Suit.CLUBS, Color.BLACK, Rank.QUEEN));
        p2Hand.add(new Card(Suit.SPADES, Color.BLACK, Rank.THREE));
        p2Hand.add(new Card(Suit.HEARTS, Color.RED, Rank.KING));
        p2Hand.add(new Card(Suit.SPADES, Color.RED, Rank.KING));

        goFishTest.giveCards(p1, p2, Rank.KING);
        goFishTest.addToBookLog(p1, Rank.KING);

        HashMap<Player, ArrayList<Rank>> temp = goFishTest.getBookLog();
        for(Player p : temp.keySet()){
            System.out.println(p.getName());
            System.out.println(temp.get(p));
            System.out.println(temp.get(p).size());
        }
    }
}