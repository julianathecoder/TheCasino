package com.codedifferently.casino.games;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class CardGameTest {

    String name="Go Fish";
    int maxPlayers=7;
    int minPlayers=2;
    int cardCount=32;
    CardGame game;

    @Before
    public void setUp(){
        game=new CardGame(name,maxPlayers,minPlayers,32);
    }

    @Test
    public void constructorTest(){
        // Given
        int playerCount=0;

        // When
        String nameAct=game.getGameName();
        int maxPlayersAct=game.getMaxPlayers();
        int minPlayersAct=game.getMinPlayers();
        int playerCountAct=game.getPlayerAmount();
        int actualCards=game.getNumOfCards();

        // Then
        Assert.assertEquals(name,nameAct);
        Assert.assertEquals(maxPlayers,maxPlayersAct);
        Assert.assertEquals(minPlayers,minPlayersAct);
        Assert.assertEquals(playerCount,playerCountAct);
        Assert.assertEquals(cardCount,actualCards);
    }
    
}