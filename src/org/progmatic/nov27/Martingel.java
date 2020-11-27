package org.progmatic.nov27;

public class Martingel extends Person{


    @Override
    public void strategy(RouletteTable rouletteTable) {
        String color = "piros";
        int bet = rouletteTable.getMinBet();
        wallet -= bet;
        wallet += rouletteTable.colourBet(color,bet);

    }
}
