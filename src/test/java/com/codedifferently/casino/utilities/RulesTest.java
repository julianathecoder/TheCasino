package com.codedifferently.casino.utilities;

import org.junit.Assert;
import org.junit.Test;

public class RulesTest {
    @Test
    public void constructorTest(){
        // given
        String goFishRules = "Minimum of 2 players" + "1. The first thing you do is deal cards to the players.\n"
        + "For 2 to 3 players you deal each player 7 cards. If there are more than three players, deal 5 cards each.\n"
        + "2. The rest of the deck is then spread out in the middle of the players face down.\n"
        + "3. During your turn ask another player if they have a particular number card\n"
        + "If the player does not have the card they will tell you to \"GO FISH\"\n"
        + "When you \"GO FISH\" you can take any card from the pool. If you get the cards\n"
        + "you asked for, either from the pool or the opponent, then you get another turn.\n"
        + "If you get all four suits of the same rank, then you can put the cards face up in front of you.\n"
        + "Go Fish is over when one player runs out of cards or there are no more cards in the pool. The winner is then determined\n"
        + "by who has the most piles or suits of cards in front of them.";

        String blackJackRules = "**The goal of blackjack is to beat the dealer's hand without going over 21.**\n"
        + "Face cards are worth 10. Aces are worth 1 or 11, whichever makes a better hand.Each player starts with two\n"
        + "cards, one of the dealer's cards is hidden until the end.\n"
        + "1.Each player starts with two cards, one of the dealer's cards is hidden until the end.\n"
        + "2.To 'Hit' is to ask for another card. To 'Stand' is to hold your total and end your turn.\n"
        + "3.If you go over 21 you bust, and the dealer wins regardless of the dealer's hand.\n"
        + "4. If you are dealt 21 from the start , you got a blackjack.\n"
        + "Split can be done when you have two of the same card(doubles the bet)the pair is split into two hands.\n"
        + "You can only double/split on the first move\n"+"You cannot play on two aces after they are split.\n"
        + "You can double on a hand resulting from a split, tripling or quadrupling you bet.";

        String crapsRules = "1. Each round in craps starts with what is known as the come-out roll. It is required that the\n"
        +"shooter place a bet before making this roll on either the pass line or the don’t pass line.\n"
        +"2. If the combined value of the two dice on a come-out roll equals 2, 3, or 12, then this is \"CRAPPING OUT\"n"
        +"and the round is over. Players will lose pass line bets and win don’t pass bets. If the come-out roll is\n"
        +"7 or 11, the round is also over.\n"+ "3. If any other value is rolled on the come-out roll i.e. 4, 5, 6, 8, 9 or 10,\n"
        +"then a point is established, equal to the value rolled, and the round continues into the next stage.\n"
        +"4. The shooter continues to roll with players betting on the outcome of each, until they roll either a 7 or the point\n"
        +"value that has been established.\n"+"5.Following a roll of either 7 or the point value, the round is\n"
        +"over and a new come-out roll is required. It’s standard practice for the shooter to pass the dice to\n"
        +"another player if a round ends with a 7, and to stay as shooter if the round ends with the point value\n"
        +"being rolled.";

        String sevenFreeSlotsRules = "**Objective is to get all 3 matching symbols**\n"
        +"Bet 1 or the max(3)\n"+"Spin reels";

        String rouletteRules = "After all the participants in the game have placed their bets on the table,\n"
        +"the dealer spins the wheel and throws in a small ball. Whichever is the number of the slot the ball lands\n"
        +"in is the winning number. If you have bet on that number or on a group of numbers that contain it,\n"
        + "then you’ll get a payout.";
  
        // when
        Rules Rulestest = new Rules(goFishRules, blackJackRules, crapsRules, sevenFreeSlotsRules, rouletteRules);
        String actualGoFishRules = Rulestest.getGoFishRules();
        String actualBlackJackRules = Rulestest.getBlackJackRules();
        String actualCrapsRules = Rulestest.getCrapsRules();
        String actualSevenFreeSlotRules = Rulestest.getSevenFreeSlotsRules();
        String actualRouletteRules = Rulestest.getRouletteRules();


        // then
        Assert.assertEquals(goFishRules, actualGoFishRules);
        Assert.assertEquals(blackJackRules, actualBlackJackRules);
        Assert.assertEquals(crapsRules, actualCrapsRules);
        Assert.assertEquals(sevenFreeSlotsRules, actualSevenFreeSlotRules);
        Assert.assertEquals(rouletteRules, actualRouletteRules);
        
    } 
}