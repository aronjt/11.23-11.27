package org.progmatic;

import org.progmatic.nov23.House;
import org.progmatic.nov27.*;

public class Main {
    public static void main(String[] args) {
        RouletteTable rouletteTable = new RouletteTable(100, 10000);
        Martingel martingel = new Martingel(10000, rouletteTable.getMinBet());
        Casino casino = new Casino();
        //casino.roulette(martingel, rouletteTable);
        RandomPerson randomPerson = new RandomPerson(5000000);
        //casino.roulette(randomPerson,rouletteTable);
        Conservative conservative = new Conservative(50000, rouletteTable.getMinBet());
        casino.roulette(conservative, rouletteTable);
    }
}
