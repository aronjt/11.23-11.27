package org.progmatic.nov27;

public class Martingel extends Person{

    public Martingel(int money) {
        wallet = money;

    }

    @Override
    public void strategy(RouletteTable rouletteTable) {
        String color = "piros";
        bet = rouletteTable.getMinBet();
        wallet -= bet;
        int winLoss = rouletteTable.colourBet(color,bet);
        if (winLoss > 0){
            wallet += winLoss;
            bet = rouletteTable.getMinBet();
        } else {
            bet += bet;
        }
        System.out.println("Jelenleg ennyi pénzed van:" + wallet);
    }
}
