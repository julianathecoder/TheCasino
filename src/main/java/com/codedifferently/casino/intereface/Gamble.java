package com.codedifferently.casino.intereface;

import com.codedifferently.casino.utilities.Player;

public interface Gamble {
    public void win();
    public void lose();
    public void bet(Player player,double money);
}