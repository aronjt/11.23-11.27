package org.progmatic;

import org.progmatic.nov23.House;
import org.progmatic.nov27.Casino;
import org.progmatic.nov27.Martingel;
import org.progmatic.nov27.RandomPerson;
import org.progmatic.nov27.RouletteTable;

public class Main {
    public static void main(String[] args) {
        RouletteTable rouletteTable = new RouletteTable(100, 10000);
        Martingel martingel = new Martingel(10000, rouletteTable.getMinBet());
        Casino casino = new Casino();
        //casino.roulette(martingel, rouletteTable);
        RandomPerson randomPerson = new RandomPerson(5000000);
        casino.roulette(randomPerson,rouletteTable);
    }
}
