package com.codedifferently.casino;

import java.util.LinkedList;
import java.util.Queue;

import com.codedifferently.casino.games.Games;
import com.codedifferently.casino.utilities.Player;

public class Casino {
    public static void main(String[] args){
        // For testing
        Games goFish = new Games("Go Fish", 4, 2);
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
            if(goFish.addPlayer(currentPlayer)){
                System.out.printf("%s has joined the game %s\n",currentPlayer.getName(),goFish.getGameName());
            }
            else{
                System.out.printf("%s could not join the game %s\n",currentPlayer.getName(),goFish.getGameName());
            }
        }


        


    }
}
