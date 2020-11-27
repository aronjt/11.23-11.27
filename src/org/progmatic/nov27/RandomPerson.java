package org.progmatic.nov27;

public class RandomPerson extends Person {
    public RandomPerson(int money) {
        super(money);
    }


    @Override
    public void strategy(RouletteTable rouletteTable) {
        double x = Math.random();
        String color = "fekete";
        if (x > 0.5) {
            color = "piros";
        }
        bet = (int) (Math.random() * rouletteTable.getMaxBet() + rouletteTable.getMinBet());
        wallet -= bet;
        int winLoss = rouletteTable.colourBet(color, bet);
        if (winLoss > 0) {
            wallet += winLoss;
        } else {
            wallet -= winLoss;
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
