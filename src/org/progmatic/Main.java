package org.progmatic;

import org.progmatic.nov23.House;
import org.progmatic.nov27.Martingel;
import org.progmatic.nov27.RouletteTable;

public class Main {
    public static void main(String[] args) {
        RouletteTable rouletteTable = new RouletteTable(100, 1000000);
        Martingel martingel = new Martingel(1000000, rouletteTable.getMinBet());
        int spins = 0;
        int max = 0;
        do {
            martingel.strategy(rouletteTable);
            spins++;
            if (martingel.getWallet() > max) {
                max = martingel.getWallet();
            }
        }
        while (martingel.getBet() < martingel.getWallet());
        System.out.println("Ennyi kör volt: " + spins);
        System.out.println("Ennyi volt a legtöbb pénzed: " + max);
    }
}
