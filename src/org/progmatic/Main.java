package org.progmatic;

import org.progmatic.nov23.House;
import org.progmatic.nov27.Martingel;
import org.progmatic.nov27.RouletteTable;

public class Main {
    public static void main(String[] args) {
        RouletteTable rouletteTable = new RouletteTable(100, 1000000);
        Martingel martingel = new Martingel(5000);
        martingel.strategy(rouletteTable);
    }
}
