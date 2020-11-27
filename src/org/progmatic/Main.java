package org.progmatic;

import org.progmatic.nov27.*;

public class Main {
    public static void main(String[] args) {
        RouletteTable rouletteTable = new RouletteTable(100,10000);
        Martingel martingel = new Martingel(10000, rouletteTable.getMinBet());
        Casino casino = new Casino();
        RandomPerson randomPerson = new RandomPerson(50000);
       // casino.rouletteSimulation(randomPerson, rouletteTable);
        Brave brave = new Brave(5000000, rouletteTable.getMaxBet());
        casino.rouletteSimulation(brave,rouletteTable);
    }
}
