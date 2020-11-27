package org.progmatic.nov27;

public class Brave extends Person {
    public Brave(int money, int bet) {
        super(money, bet);
    }

    public Brave(int wallet) {
        super(wallet);
    }

    @Override
    public void strategy(RouletteTable rouletteTable) {
        bet = rouletteTable.getMaxBet();
        int winLoss = rouletteTable.colourBet("piros", bet);
        if (winLoss > 0) {
            wallet += winLoss;
        } else {
            wallet -= winLoss;
        }
        wallet -= bet;
        System.out.println(wallet);
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
