package com.codedifferently.casino.games;
/**
 * @author Taia WilliamsRivera
 */
import java.util.HashMap;
import com.codedifferently.casino.utilities.Dice;
import com.codedifferently.casino.utilities.Player;
//import java.util.Scanner;
//import java.util.HashMap;
//import com.codedifferently.casino.intereface.Gamble;
//import com.codedifferently.casino.utilities.Rules;
//import java.text.DecimalFormat;

public class Craps{ //implements Gamble {
    public static final String Assert = null;
    private HashMap<Player,Double> bets;

    private static double money;
    private static Player player;
    private static double bet;
    private static int winnings;
    private static int losses;
    private Dice dice = new Dice();
    private static Craps ob= new Craps();
    
    public Craps() {
        this.bets = new HashMap<Player, Double>();  
    }
    public Craps(Player player) 
    {
        this.player = player;
    }
    public Player getPlayer()
    {
        return this.player;
    }
    public static double getBet()
    {
        return bet;
    }
    public int getBetCount()
    {
        return this.bets.size();
    }
    public void clearBets()
    {
        this.bets.clear();
    }
    
    static int rollSum = Dice.getRollTotal();

    static boolean playCraps() {
        if (rollSum == 2 || rollSum == 3 || rollSum == 12) {
            System.out.println(" Craps You loss with: " + rollSum);
            losses++;
        } else if (rollSum == 7 || rollSum == 11) {
            System.out.println("You win with: " + rollSum);
            winnings++;
        } else {
            int point = rollSum; // numbers such as 4, 5, 6, 8, 9, or 10
            System.out.println("Point: " + point);
            while (true) // roll again
            {
                System.out.println("\nNew roll: " + rollSum);
                if (rollSum == point) {
                    System.out.println("Matched point, won");
                    winnings++;
                    return true;
                }
                if (rollSum == 7) {
                    System.out.println("Sorry you lost with 7");
                    losses++;
                } else
                    System.out.println("No help you still lose");
                losses++;
            }

        }
        System.out.println("Winnings: " + winnings + "\nLosses: " + losses);
        return false;
    }

    public static void win() {// gives back two times the bet
        if (playCraps() == true) {
            // adds wagerMoney*2 to player money
            money += (bet * 2);
        }
        else
        {
            Craps.lose();
        }
    }

    public static void lose() {
        // does given bet back bet
        System.out.println("Sorry, you lose the bet");
    }
    
    public static void bet() {
        System.out.println(bet);
        if(bet <= money)
        {   
            money = money - bet;
        }
        else
        {
            bet = 0;
            System.out.println("You don't have enough money, make a smaller bet");
            System.out.println("You have " + money + "$, left how much would you like to bet?"); 
        }
    }

        /*Scanner scan = new Scanner(System.in);              //Will be added to Casino
        System.out.println("How much would you like to bet?");
        bet = scan.nextInt();  //Can use later
        scan.close();*/
        /*if(money == 0) {
            System.out.println("You don't have any game money");
        } 
        else 
        {   //ask user for bet
            if (bet <= money)
            {
                money = money - bet;
                System.out.println("You have chosen to bet, " + bet + "$, goodluck.");
            } else
            {
                bet = 0;
                System.out.println("You don't have enough money, make a smaller bet");
                System.out.println("You have " + money + "$, left how much would you like to bet?");
                //bet = scan.nextInt();
        
       
        
    
    private static void crapsCommandsChart() {
        System.out.println("Commands: | bet | money | help | restart |");
        }

    /*public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.println("Hello\nWelcome to the Craps Game!!");
        System.out.println("Have you played before? Y/N.");
        String vCheck1 = input.nextLine();

        // Removes invalid inputs.
        while (!(vCheck1.equals("Y")) && !(vCheck1.equals("N"))) {
            System.out.println("Incorrect, please type Y/N.");
            vCheck1 = input.nextLine();
        }

        // If user inputs 'Y' (Yes), print below.
        if (vCheck1.equals("Y")) {
            System.out.println("Good luck!");
        }

        // If user inputs 'N' (No), print Rules for Roulette.
        if (vCheck1.equals("N")) {
            System.out.println(Rules.crapsRules());
            try {
                Thread.sleep(10000);
            } catch (InterruptedException ex) {
                Thread.currentThread().interrupt();
            }
        }
        try {
            Thread.sleep(2000);
        } catch (InterruptedException ex) {
            Thread.currentThread().interrupt();
        }

        //DecimalFormat g = new DecimalFormat("#.00%");
        int dice1val = 0;
        int dice2val = 0;
        int rollSum = 0;
        double winCount = 0;
        double losses = 0;
        int points = 0;
        int rounds = 0;
        //double money =  Craps.getGameMoney();
        System.out.println("Let's begin");
        //System.out.println("You have " + money+ "$.");
        System.out.println("What would you like to do?");
        System.out.println("What would you like to do?");
        crapsCommandsChart();
        String answer = input.next();
        while (!(answer.equals("bet")) && !(answer.equals("money")) && !(answer.equals("cashout")) &&
                !(answer.equals("restart")) && !(answer.equals("help"))) {
            System.out.println("Invalid choice, type 'help' to view the commands.");
            System.out.println("");
            System.out.println("What would you like to do?");
            Craps.crapsCommandsChart();
            answer = input.next();
        }


        
     }

    public void win(Player player) {
    }

    public void lose(Player player) {
    
    }
    /*Scanner scan = new Scanner(System.in);
    System.out.println("How much would you like to bet?");
    bet = scan.nextInt();*/  //Can use later*/

    
}

