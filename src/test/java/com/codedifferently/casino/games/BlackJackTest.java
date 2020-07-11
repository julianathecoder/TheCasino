package com.codedifferently.casino.games;

import com.codedifferently.casino.utilities.Card;
import com.codedifferently.casino.utilities.Dealer;
import com.codedifferently.casino.utilities.Player;
import com.codedifferently.casino.utilities.cardenums.Color;
import com.codedifferently.casino.utilities.cardenums.Rank;
import com.codedifferently.casino.utilities.cardenums.Suit;

import org.junit.Assert;
import org.junit.Test;
/**
 * @author Aldo Almeida
 */
public class BlackJackTest {

    @Test
    public void constructorTest(){
        // Given
        int size=0;
        boolean dealExpected=true;
        int bustedSize=0;
        boolean isGame=true;

        // When
        BlackJack game=new BlackJack();
        int actual=game.getBetCount();
        boolean actualDealer=game.getDealer() instanceof Dealer;
        int actualBusted=game.getNotBustedPlayers().size();
        boolean actualIsGame=game instanceof Games;


        // Then
        Assert.assertEquals(size, actual);
        Assert.assertEquals(dealExpected, actualDealer);
        Assert.assertEquals(bustedSize, actualBusted);
        Assert.assertEquals(isGame, actualIsGame);
    }


    @Test
    public void getBetsCountTest(){
        // Given
        int size=0;

        // When
        BlackJack game=new BlackJack();
        int actual=game.getBetCount();

        // Then
        Assert.assertEquals(size, actual);
    }
    
    @Test
    public void betTest(){
        // Given
        int size=5;

        // When
        BlackJack game=new BlackJack();
        game.bet(new Player("Bill", 21, 2334.00),100.00);
        game.bet(new Player("Jill", 21, 2334.00),100.00);
        game.bet(new Player("Rill", 21, 2334.00),100.00);
        game.bet(new Player("Lill", 21, 2334.00),100.00);
        game.bet(new Player("Aill", 21, 2334.00),100.00);
        int actual=game.getBetCount();

        // Then
        Assert.assertEquals(size, actual);
    }

    @Test
    public void betLogTest(){
        // Given
        String output="\\---------- BETS ----------/\n";

        // When
        BlackJack game=new BlackJack();
        String actual=game.betLog();

        // Then
        Assert.assertEquals(output, actual);
    }

    @Test
    public void setUpTest(){
        // Given
        int size=2;
        Player bill=new Player("Bill", 21, 2334.00);

        // When
        BlackJack game=new BlackJack();
        game.addPlayer(bill);
        game.setUp();
        int actual=bill.getHandSize();

        // Then
        Assert.assertEquals(size, actual);
    }

    @Test
    public void outcomeLog(){
        // Given
        String output="\\---------- RESULTS ----------/\n";

        // When
        BlackJack game=new BlackJack();
        String actual=game.outcomeLog();

        // Then
        Assert.assertEquals(output, actual);

    }

    @Test
    public void hitTest(){
        // Given
        int size=6;
        Player bill=new Player("Bill", 21, 2334.00);

        // When
        BlackJack game=new BlackJack();
        game.addPlayer(bill);
        game.setUp();
        game.hit(bill);
        game.hit(bill);
        game.hit(bill);
        game.hit(bill);
        int actual=bill.getHandSize();

        // Then
        Assert.assertEquals(size, actual);
    }

    @Test
    public void checkBustedTest(){
        // Given
        boolean busted=true;
        Player bill=new Player("Bill", 21, 2334.00);

        // When
        BlackJack game=new BlackJack();
        game.setUp();
        game.addPlayer(bill);
        game.hit(bill);
        game.hit(bill);
        game.hit(bill);
        game.hit(bill);
        game.hit(bill);
        game.hit(bill);
        boolean actual=game.checkIfBusted(bill);

        // Then
        Assert.assertEquals(busted, actual);
    }

    @Test
    public void checkBustedTest2(){
        // Given
        boolean busted=false;
        Player bill=new Player("Bill", 21, 2334.00);

        // When
        BlackJack game=new BlackJack();
        game.addPlayer(bill);
        game.setUp();
        boolean actual=game.checkIfBusted(bill);

        // Then
        Assert.assertEquals(busted, actual);
    }

    @Test
    public void convertToNumberTest(){
        // Given
        Player bill=new Player("Bill", 21, 2334.00);
        Suit suit = Suit.DIAMONDS;
        Rank rank = Rank.FIVE;
        Color color = Color.RED;
        int expected=10;

        // When
        BlackJack game=new BlackJack();
        game.addPlayer(bill);
        bill.giveCard(new Card(suit, color, rank));
        bill.giveCard(new Card(suit, color, rank));
        int converted=game.convertToNumber(bill);

        // Then
        Assert.assertEquals(expected, converted);
    }

    @Test
    public void clearTest(){
        // Given
        int size=0;

        // When
        BlackJack game=new BlackJack();
        game.bet(new Player("Bill", 21, 2334.00),100.00);
        game.bet(new Player("Jill", 21, 2334.00),100.00);
        game.bet(new Player("Rill", 21, 2334.00),100.00);
        game.bet(new Player("Lill", 21, 2334.00),100.00);
        game.bet(new Player("Aill", 21, 2334.00),100.00);
        game.clearBets();
        int actual=game.getBetCount();

        // Then
        Assert.assertEquals(size, actual);
    }

    @Test
    public void winTest(){
        // Given
        double start=2000.00;
        double money=4000.00;
        Player bill=new Player("Bill", 21, 2000.00);

        // When
        BlackJack game=new BlackJack();
        double actualStart=bill.getMoney();
        game.bet(bill, 2000);
        game.win(bill);
        double actualProfit=bill.getMoney();

        // Then
        Assert.assertEquals(start, actualStart,0.00001);
        Assert.assertEquals(money, actualProfit,0.0001);
    }

    @Test
    public void loseTest(){
        // Given
        double start=2000.00;
        double money=0.00;
        Player bill=new Player("Bill", 21, 2000.00);

        // When
        BlackJack game=new BlackJack();
        double actualStart=bill.getMoney();
        game.bet(bill, 2000);
        game.lose(bill);
        double actualProfit=bill.getMoney();

        // Then
        Assert.assertEquals(start, actualStart,0.00001);
        Assert.assertEquals(money, actualProfit,0.0001);
    }

    @Test
    public void addStandingPlayerTest(){
        // Given
        Player bill=new Player("Bill", 21, 2000.00);
        boolean expected=true;

        // When
        BlackJack game=new BlackJack();
        game.addStandingPlayer(bill);
        boolean actualInArray=game.getNotBustedPlayers().contains(bill);
        Player actual=game.getNotBustedPlayers().get(0);

        // Then
        Assert.assertEquals(bill,actual);
        Assert.assertEquals(expected,actualInArray);
    }

    @Test
    public void checkForAceTest(){
        // Given
        Player bill=new Player("Bill", 21, 2334.00);
        Suit suit = Suit.DIAMONDS;
        Rank rank = Rank.ACE;
        Color color = Color.RED;
        boolean rankExpected=true;

        // When
        BlackJack game=new BlackJack();
        game.addPlayer(bill);
        bill.giveCard(new Card(suit, color, rank));
        boolean converted=game.checkForAce(bill);

        // Then
        Assert.assertEquals(rankExpected, converted);
    }

    @Test
    public void checkForAceTest2(){
        // Given
        Player bill=new Player("Bill", 21, 2334.00);
        Suit suit = Suit.DIAMONDS;
        Rank rank = Rank.DEUCE;
        Color color = Color.RED;
        boolean rankExpected=false;

        // When
        BlackJack game=new BlackJack();
        game.addPlayer(bill);
        bill.giveCard(new Card(suit, color, rank));
        boolean converted=game.checkForAce(bill);

        // Then
        Assert.assertEquals(rankExpected, converted);
    }

    @Test
    public void convertWithAcesTest(){
        // Given
        Player bill=new Player("Bill", 21, 2334.00);
        Suit suit = Suit.DIAMONDS;
        Rank rank = Rank.ACE;
        Color color = Color.RED;
        int expected=11;
        int expected2=1;

        // When
        BlackJack game=new BlackJack();
        game.addPlayer(bill);
        bill.giveCard(new Card(suit, color, rank));
        int converted=game.convertWithAces(bill).get(1);
        int converted2=game.convertWithAces(bill).get(0);
        System.out.println(game.convertWithAces(bill).toString());

        // Then
        Assert.assertEquals(expected, converted);
        Assert.assertEquals(expected2, converted2);
    }

    @Test
    public void convertWithAcesTest2(){
        // Given
        Player bill=new Player("Bill", 21, 2334.00);
        Suit suit = Suit.DIAMONDS;
        Rank rank = Rank.ACE;
        Color color = Color.RED;
        int expected=12;
        int expected2=2;

        // When
        BlackJack game=new BlackJack();
        game.addPlayer(bill);
        bill.giveCard(new Card(suit, color, rank));
        bill.giveCard(new Card(suit, color, rank));
        int converted=game.convertWithAces(bill).get(1);
        int converted2=game.convertWithAces(bill).get(0);
        System.out.println(game.convertWithAces(bill).toString());

        // Then
        Assert.assertEquals(expected, converted);
        Assert.assertEquals(expected2, converted2);
    }

    @Test
    public void convertWithAcesTest3(){
        // Given
        Player bill=new Player("Bill", 21, 2334.00);
        Suit suit = Suit.DIAMONDS;
        Rank rank = Rank.ACE;
        Color color = Color.RED;
        int expected=13;
        int expected2=3;

        // When
        BlackJack game=new BlackJack();
        game.addPlayer(bill);
        bill.giveCard(new Card(suit, color, rank));
        bill.giveCard(new Card(suit, color, rank));
        bill.giveCard(new Card(suit, color, rank));
        int converted=game.convertWithAces(bill).get(1);
        int converted2=game.convertWithAces(bill).get(0);
        System.out.println(game.convertWithAces(bill).toString());

        // Then
        Assert.assertEquals(expected, converted);
        Assert.assertEquals(expected2, converted2);
    }

    @Test
    public void convertWithAcesTest4(){
        // Given
        Player bill=new Player("Bill", 21, 2334.00);
        Suit suit = Suit.DIAMONDS;
        Rank rank = Rank.ACE;
        Color color = Color.RED;
        int expected=16;
        int expected2=6;

        // When
        BlackJack game=new BlackJack();
        game.addPlayer(bill);
        bill.giveCard(new Card(suit, color, rank));
        bill.giveCard(new Card(suit, color, rank));
        bill.giveCard(new Card(suit, color, rank));
        bill.giveCard(new Card(suit, color, rank));
        bill.giveCard(new Card(suit, color, rank));
        bill.giveCard(new Card(suit, color, rank));
        int converted=game.convertWithAces(bill).get(1);
        int converted2=game.convertWithAces(bill).get(0);
        System.out.println(game.convertWithAces(bill).toString());

        // Then
        Assert.assertEquals(expected, converted);
        Assert.assertEquals(expected2, converted2);
    }

    @Test
    public void convertWithAcesTest5(){
        // Given
        Player bill=new Player("Bill", 21, 2334.00);
        Suit suit = Suit.DIAMONDS;
        Rank rank = Rank.EIGHT;
        Rank rank2=Rank.ACE;
        Color color = Color.RED;
        int expected=19;
        int expected2=9;

        // When
        BlackJack game=new BlackJack();
        game.addPlayer(bill);
        bill.giveCard(new Card(suit, color, rank));
        bill.giveCard(new Card(suit, color, rank2));
        int converted=game.convertWithAces(bill).get(1);
        int converted2=game.convertWithAces(bill).get(0);
        System.out.println(game.convertWithAces(bill).toString());

        // Then
        Assert.assertEquals(expected, converted);
        Assert.assertEquals(expected2, converted2);
    }
}