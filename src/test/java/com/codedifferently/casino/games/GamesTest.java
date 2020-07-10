package com.codedifferently.casino.games;

import java.util.ArrayList;

import com.codedifferently.casino.utilities.Player;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
/**
 * @author Aldo Almeida
 */
public class GamesTest {

    String name="Go Fish";
    int maxPlayers=7;
    int minPlayers=2;
    int playerCount=0;
    Games game;

    @Before
    public void setUp(){
        game=new Games(name,maxPlayers,minPlayers);
    }

    @Test
    public void constructorTest(){
        // Given

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
    public void getGameNameTest(){
        // Given;

        // When
        String nameAct=game.getGameName();

        // Then
        Assert.assertEquals(name,nameAct);
    }

    @Test
    public void getMaxTest(){
        // Given;

        // When
        int maxPlayersAct=game.getMaxPlayers();

        // Then
        Assert.assertEquals(maxPlayers,maxPlayersAct);
    }

    @Test
    public void getMinTest(){
        // Given

        // When
        int maxPlayersAct=game.getMaxPlayers();

        // Then
        Assert.assertEquals(maxPlayers,maxPlayersAct);
    }

    @Test
    public void getPlayerAmountTest(){
        // Given

        // When
        int playerCountAct=game.getPlayerAmount();

        // Then
        Assert.assertEquals(playerCount,playerCountAct);
    }

    @Test
    public void addPlayerTest(){
        // Given
        Player bob=new Player("Bob",21,2000.00);
        Player bill=new Player("Bill",21,2000.00);
        int count=2;
        boolean firstAdd=true;
        boolean secondAdd=true;

        // When
        boolean actual1=game.addPlayer(bob);
        boolean actual2=game.addPlayer(bill);
        int actualCount=game.getPlayerAmount();

        // Then
        Assert.assertEquals(count, actualCount);
        Assert.assertEquals(firstAdd,actual1);
        Assert.assertEquals(secondAdd,actual2);

    }

    @Test
    public void addPlayerTest2(){
        // Given
        Player bob=new Player("Bob",21,2000.00);
        Player bill=new Player("Bill",21,2000.00);
        boolean lastPlayer=false;
        game.resetGame();

        // When
        game.addPlayer(bob);
        game.addPlayer(bill);
        game.addPlayer(bill);
        game.addPlayer(bill);
        game.addPlayer(bill);
        game.addPlayer(bill);
        game.addPlayer(bill);
        boolean check=game.addPlayer(bob);

        // Then
        Assert.assertEquals(lastPlayer,check);

    }

    @Test
    public void resetGameTest(){
        // Given
        Player bob=new Player("Bob",21,2000.00);
        Player bill=new Player("Bill",21,2000.00);

        // When
        game.addPlayer(bob);
        game.addPlayer(bill);
        game.resetGame();
        int actual=game.getPlayerAmount();

        // Then
        Assert.assertEquals(playerCount, actual);

    }

    @Test
    public void startGameTest(){
        // Given
        Player bob=new Player("Bob",21,2000.00);
        Player bill=new Player("Bill",21,2000.00);
        boolean expected=true;
        game.resetGame();

        // When
        game.addPlayer(bob);
        game.addPlayer(bill);
        game.startGame();
        boolean actual=game.startGame();

        // Then
        Assert.assertEquals(expected, actual);

    }

    @Test
    public void startGameTest2(){
        // Given
        Player bob=new Player("Bob",21,2000.00);
        Player bill=new Player("Bill",21,2000.00);
        boolean expected=false;
        game.resetGame();

        // When
        game.addPlayer(bob);
        game.startGame();
        boolean actual=game.startGame();

        // Then
        Assert.assertEquals(expected, actual);

    }

    @Test
    public void startGameTest3(){
        // Given
        Player bob=new Player("Bob",21,2000.00);
        Player bill=new Player("Bill",21,2000.00);
        boolean expected=true;
        game.resetGame();

        // When
        game.addPlayer(bob);
        game.addPlayer(bill);
        game.addPlayer(bill);
        game.addPlayer(bill);
        game.addPlayer(bill);
        game.addPlayer(bill);
        boolean actual=game.startGame();

        // Then
        Assert.assertEquals(expected, actual);

    }

    @Test
    public void startGameTest4(){
        // Given
        Player bob=new Player("Bob",21,2000.00);
        Player bill=new Player("Bill",21,2000.00);
        boolean expected=true;
        game.resetGame();

        // When
        game.addPlayer(bob);
        game.addPlayer(bill);
        game.addPlayer(bill);
        game.addPlayer(bill);
        game.addPlayer(bill);
        game.addPlayer(bill);
        game.addPlayer(bill);
        game.addPlayer(bob);
        boolean actual=game.startGame();

        // Then
        Assert.assertEquals(expected, actual);

    }

    @Test
    public void playerListTest(){
        // Given
        game.resetGame();
        Player bob=new Player("Bob",21,2000.00);
        Player bill=new Player("Bill",21,2000.00);
        ArrayList<Player> players= new ArrayList<Player>();
        players.add(bob);
        players.add(bill);

        // When
        game.addPlayer(bob);
        game.addPlayer(bill);
        ArrayList<Player> actual=game.getPlayerList();

        // Then
        Assert.assertEquals(players, actual);

    }

    @Test
    public void playerListTest2(){
        // Given
        game.resetGame();
        Player bob=new Player("Bob",21,2000.00);
        Player bill=new Player("Bill",21,1300.00);
        Player jill=new Player("Jill",21,2600.00);
        Player Dill=new Player("Dill",22,6230.00);
        ArrayList<Player> players= new ArrayList<Player>();
        players.add(bob);
        players.add(bill);
        players.add(jill);
        players.add(Dill);

        // When
        game.addPlayer(bob);
        game.addPlayer(bill);
        game.addPlayer(jill);
        game.addPlayer(Dill);
        ArrayList<Player> actual=game.getPlayerList();

        // Then
        Assert.assertEquals(players, actual);

    }
    
}