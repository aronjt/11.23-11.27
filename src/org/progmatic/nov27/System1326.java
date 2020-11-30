package org.progmatic.nov27;

public class System1326 extends Person{

    int bet2 = bet * 3;
    int bet3 = bet * 2;
    int bet4 = bet * 6;


    public System1326(int money, int bet) {
        super(money, bet);
    }

    @Override
    public void strategy(RouletteTable rouletteTable) {
        while (wallet > bet) {
            String color = "piros";
            wallet -= bet;
            int winLoss = rouletteTable.colourBet(color, bet);
            if (winLoss > 0) {
                wallet += winLoss;
                System.out.println("Kassza: " + wallet);
                wallet -= bet2;
                int winLoss2 = rouletteTable.colourBet(color, bet2);
                if (winLoss2 > 0) {
                    wallet += winLoss2;
                    System.out.println("Kassza: " + wallet);
                    wallet -= bet3;
                    int winLoss3 = rouletteTable.colourBet(color, bet3);
                    if (winLoss3 > 0) {
                        wallet += winLoss3;
                        System.out.println("Kassza: " + wallet);
                        wallet -= bet4;
                        int winLoss4 = rouletteTable.colourBet(color, bet4);
                        if (winLoss4 > 0) {
                            wallet += winLoss4;
                            System.out.println("Kassza: " + wallet);
                        }
                    }
                }
            } else {
                System.out.println("Kassza: " + wallet);
                strategy(rouletteTable);
            }
        }
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
