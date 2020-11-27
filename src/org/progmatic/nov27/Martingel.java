package org.progmatic.nov27;

public class Martingel extends Person{

    public Martingel(int money, int bet) {
        super(money, bet);
    }

    @Override
    public void strategy(RouletteTable rouletteTable) {
        String color = "piros";
        wallet -= bet;
        int winLoss = rouletteTable.colourBet(color,bet);
        if (winLoss > 0){
            wallet += winLoss;
            bet = rouletteTable.getMinBet();
        } else {
            bet = bet * 2;
        }
        System.out.println("Jelenleg ennyi pénzed van:" + wallet);
    }

    @Override
    public int getWallet() {
        return wallet;
    }

    @Override
    public int getBet() {
        return bet;
    }
}
