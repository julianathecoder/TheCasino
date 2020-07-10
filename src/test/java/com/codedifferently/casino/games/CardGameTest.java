package com.codedifferently.casino.games;

import java.util.ArrayList;

import com.codedifferently.casino.utilities.Card;
import com.codedifferently.casino.utilities.Player;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
/**
 * @author Aldo Almeida
 */
public class CardGameTest {

    String name="Go Fish";
    int maxPlayers=7;
    int minPlayers=2;
    CardGame game;

    @Before
    public void setUp(){
        game=new CardGame(name,maxPlayers,minPlayers);
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

        // Then
        Assert.assertEquals(name,nameAct);
        Assert.assertEquals(maxPlayers,maxPlayersAct);
        Assert.assertEquals(minPlayers,minPlayersAct);
        Assert.assertEquals(playerCount,playerCountAct);
    }

    @Test
    public void shuffleTest(){
        // Given
        CardGame game2=game;

        // When
        game2.shuffleDeck();
        game.shuffleDeck();
        Card pick1=game2.pullFromDeck();
        Card pick2=game.pullFromDeck();

        // Then
        Assert.assertNotEquals(pick1, pick2);


    }

    @Test
    public void pullFromDeckTest(){
        // Given
        boolean expected=true;

        // When
        Card card=game.pullFromDeck();
        boolean check=card instanceof Card;

        // Then
        Assert.assertEquals(expected, check);

    }

    @Test
    public void pullFromDeckTest2(){
        // Given
        int expected=100;
        int actual=0;

        // When
        for(int i=0;i<100;i++){
            Card card=game.pullFromDeck();
            if(card instanceof Card){
                actual++;
            }

        }

        // Then
        Assert.assertEquals(expected, actual);

    }

    @Test
    public void dealCardsTest(){
        // Given
        int expected=3;

        // When
        game.addPlayer(new Player("Bill", 21, 43413.00));
        game.addPlayer(new Player("Jill", 21, 43413.00));
        game.dealCards(3);
        ArrayList<Player> players=game.getPlayerList();
        Player current=players.get(0);
        int currentNum=current.getHandSize();

        // Then
        Assert.assertEquals(expected, currentNum);

    }
    
}