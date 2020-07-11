package com.codedifferently.casino.utilities;
/**
 * @author Taia WilliamsRivera
 */
import static org.junit.Assert.assertEquals;

import org.junit.Test;

public class RulesTest {

    @Test
    public void goFishRulesTest()
    {   
        assertEquals("Minimum of 2 players" + "1. The first thing you do is deal cards to the players.\n"
        + "For 2 to 3 players you deal each player 7 cards. If there are more than three players, deal 5 cards each.\n"
        + "2. The rest of the deck is then spread out in the middle of the players face down.\n"
        + "3. During your turn ask another player if they have a particular number card\n"
        + "If the player does not have the card they will tell you to \"GO FISH\"\n"
        + "When you \"GO FISH\" you can take any card from the pool. If you get the cards\n"
        + "you asked for, either from the pool or the opponent, then you get another turn.\n"
        + "If you get all four suits of the same rank, then you can put the cards face up in front of you.\n"
        + "Go Fish is over when one player runs out of cards or there are no more cards in the pool. The winner is then determined\n"
        + "by who has the most piles or suits of cards in front of them.", Rules.goFishRules());
    }

    @Test
    public void blackJackRulesTest()
    {   
        assertEquals("**The goal of blackjack is to beat the dealer's hand without going over 21.**\n"
        + "Face cards are worth 10. Aces are worth 1 or 11, whichever makes a better hand.Each player starts with two\n"
        + "cards, one of the dealer's cards is hidden until the end.\n"
        + "1.Each player starts with two cards, one of the dealer's cards is hidden until the end.\n"
        + "2.To 'Hit' is to ask for another card. To 'Stand' is to hold your total and end your turn.\n"
        + "3.If you go over 21 you bust, and the dealer wins regardless of the dealer's hand.\n"
        + "4. If you are dealt 21 from the start , you got a blackjack.\n"
        + "Split can be done when you have two of the same card(doubles the bet)the pair is split into two hands.\n"
        + "You can only double/split on the first move\n"
        + "You cannot play on two aces after they are split.\n"
        + "You can double on a hand resulting from a split, tripling or quadrupling you bet.", Rules.blackJackRules());
    }

    @Test
    public void crapsRulesTest()
    {   
        assertEquals("1. Player makes a bet. 2. Player rolls two dice to get the first sum, if the first sum is 7 or 11, player automatically\n"
        + "wins and gets two times the bet. If the first sum is 2, 3, or 12, player loses. Any other number, the first sum becomes the point.\n"
        + "3. Player rolls again to get the new sum. If the new sum equals point, player wins. Otherwise if the new sum equals 7, shooter looses. If new sum is less than point player rolls again\n"
        + "until the point is matched,sum is 7 or sum is greater than the point.", Rules.crapsRules());
    }

    @Test
    public void evenFreeSlotsRuleTest()
    {   
        assertEquals("**Objective is to get all 3 matching symbols**\n" + "Bet 1 or the max(3)\n" + "Spin reels", Rules.sevenFreeSlotsRules());
    }


    @Test
    public void rouletteRulesTest()
    {   
        assertEquals("After all the participants in the game have placed their bets on the table,\n"
        +"the dealer spins the wheel and throws in a small ball. Whichever is the number of the slot the ball lands\n"
        +"in is the winning number. If you have bet on that number or on a group of numbers that contain it,\n"
        + "then you’ll get a payout.", Rules.rouletteRules());
    }






    
}
