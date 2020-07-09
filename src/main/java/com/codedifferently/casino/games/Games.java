package com.codedifferently.casino.games;

import java.util.ArrayList;

import com.codedifferently.casino.intereface.Game;
import com.codedifferently.casino.utilities.Player;
//import com.codedifferently.casino.utilities.Rules;

public class Games implements Game {
    private String gameName;
    //private Rules rules;
    private ArrayList<Player> players;
    private int maxPlayers;
    private int minPlayers;

    public Games(String name,int max, int min){
        this.gameName=name;
        this.maxPlayers=max;
        this.minPlayers=min;
        this.players= new ArrayList<Player>();
        //this.rules=new Rules();
    }
    public String getGameName(){
        return this.gameName;
    }

    public int getMaxPlayers(){
        return this.maxPlayers;
    }

    public int getMinPlayers(){
        return this.minPlayers;
    }
    public int getPlayerAmount(){
        return this.players.size();
    }

    public String getRules(){
        return "Rules";
    }

    public boolean addPlayer(Player player){
        if(this.players.size()+1<=this.maxPlayers)
            return players.add(player);
        return false;
        
    }

    public void resetGame(){
        this.players.clear();
    }

    public boolean startGame(){
        if(this.players.size()>=this.minPlayers){
            return true;
        }
        return false;

    }



    
}