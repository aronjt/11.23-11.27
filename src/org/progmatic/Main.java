package org.progmatic;

import org.progmatic.nov27.*;

public class Main {
    public static void main(String[] args) {
        RouletteTable rouletteTable = new RouletteTable(100,100000);
        Casino casino = new Casino();
        System1326 system1326 = new System1326(100000, 500);
        Martingel martingel = new Martingel(100000, rouletteTable.getMinBet());
        AfterSameBet afterSameBet = new AfterSameBet(10000, 500);
        casino.rouletteGame(rouletteTable);
    }
}
