package org.progmatic.nov27;

public class Conservative extends Person{
    public Conservative(int money, int bet) {
        super(money, bet);
    }

    public Conservative(int wallet) {
        super(wallet);
    }

    @Override
    public void strategy(RouletteTable rouletteTable) {
        bet = rouletteTable.getMinBet();
        wallet -= bet;
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
