package org.progmatic.nov27;

import java.util.ArrayList;
import java.util.List;

public class AfterSameBet extends Person{

    public AfterSameBet(int money, int bet) {
        super(money, bet);
    }

    @Override
    public void strategy(RouletteTable rouletteTable) {
        List<String > spins = new ArrayList<>();
        int sameSpin = 0;
        String color = null;
        while (sameSpin != 5) {
            int spin = rouletteTable.spin();
            if (rouletteTable.getRedNumbers().contains(spin)) {
                spins.add("piros");
                System.out.println("piros");
            } else if (spin == 0) {
                spins.add("zöld");
                System.out.println("zöld");
            } else {
                spins.add("fekete");
                System.out.println("fekete");
            }
            if (spins.size() > 4) {
                for (int i = spins.size()-1; i > spins.size()-5; i--) {
                    if (spins.get(spins.size()-1).equals(spins.get(i - 1))) {
                        sameSpin++;
                        color = spins.get(spins.size()-1);
                    } else {
                        break;
                    }
                }
            }
            if (sameSpin > 4) {
                wallet -= bet;
                if (color.equals("piros")) {
                    wallet += rouletteTable.colourBet("fekete", bet);
                } else if (color.equals("fekete")) {
                    wallet += rouletteTable.colourBet("piros", bet);
                } else {
                    wallet += rouletteTable.colourBet("piros", bet);
                }

            } else {
                sameSpin = 1;
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
