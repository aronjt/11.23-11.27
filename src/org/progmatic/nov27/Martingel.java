package org.progmatic.nov27;

public class Martingel extends Person{


    @Override
    public void strategy(RouletteTable rouletteTable) {
        String color = "piros";
        int bet = rouletteTable.getMinBet();
        wallet -= bet;
        int winLoss = rouletteTable.colourBet(color,bet);
        if (winLoss > 0){
            wallet += winLoss;
            bet = rouletteTable.getMinBet();
        } else {
            bet += bet;
        }
    }
}
