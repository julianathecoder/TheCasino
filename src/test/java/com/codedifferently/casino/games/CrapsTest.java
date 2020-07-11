package com.codedifferently.casino.games;

/**
 * @author Taia WilliamsRivera
 */
import org.junit.Test;

import static org.junit.Assert.assertEquals;

import com.codedifferently.casino.utilities.Dice;
//import com.codedifferently.casino.utilities.Dice;
import com.codedifferently.casino.utilities.Player;
import org.junit.Assert;


public class CrapsTest 
{
  @Test
  public void constructorTest()
  {   
      // given
      Player player = new Player("Laila", 22, 40.0);
      double gameMoney = player.getMoney();
      
      //when
      Craps testCraps = new Craps(player);
      //Double actualgameMoney = Craps.getMoney();
      Player actualPlayer = testCraps.getPlayer();

      //then
      Assert.assertEquals(player, actualPlayer);
      //Assert.assertEquals(gameMoney, actualgameMoney, 0); 
  }
  @Test
  public void betTest()
  {
    //given
    Player player = new Player("Brandon", 23, 200);
    double money = player.getMoney();
    double bet = 50;

    //when
    double actualBet =bet;
    double newMoneyVal = money - bet;
    
    //then
    Assert.assertEquals(50, actualBet, 0);
    Assert.assertEquals(150, newMoneyVal, 0);
  }

  @Test
  public void playCraps()
  {   
    //given
    int rollsum = 11;
    boolean expected = true;
    
    boolean actualVal;
    // when
    actualVal = Craps.playCraps();

    //then
    Assert.assertEquals(expected,actualVal);
  }

  @Test
  public void winTest()
  {
    //given
    double bet = 40;
    double money = 100;
    double actualMoney = 100;

    //when
    actualMoney = actualMoney + (bet * 2);

    //then
    assertEquals(180, actualMoney, 0);

  }
  
}
