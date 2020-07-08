package com.codedifferently.casino.utilities;
/**
 * @author Aldo Almeida
 */
public class Player {
    private String name;
    private int age;
    private double money;

    public Player(String name, int age, double money){
        this.name=name;
        this.age=age;
        this.money=money;
    }

    public String getName(){
        return this.name;
    }

    public int getAge(){
        return this.age;
    }

    public double getMoney(){
        return this.money;
    }

    public void giveMoney(double money){
        this.money+=money;
    }
    
    public double gamble(double bet){
        if(this.money-bet<0){
            double temp=this.money;
            this.money=0;
            return temp;
        }
        else
            this.money-=bet;
        return bet;
    }
}