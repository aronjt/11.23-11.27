package org.progmatic;

import org.progmatic.nov27.Casino;
import org.progmatic.nov27.Martingel;
import org.progmatic.nov27.RouletteTable;

public class Main {
    public static void main(String[] args) {
        RouletteTable rouletteTable = new RouletteTable(100, 1000000);
        Martingel martingel = new Martingel(10000, rouletteTable.getMinBet());
        Casino casino = new Casino();
        casino.rouletteGame(rouletteTable);

    }
}
