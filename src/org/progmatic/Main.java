package org.progmatic;

import org.progmatic.nov23.House;
import org.progmatic.nov27.RouletteTable;

public class Main {
    public static void main(String[] args) {
        RouletteTable rouletteTable = new RouletteTable();
        rouletteTable.colourBet("piros", 500);
        rouletteTable.parityBet("páros", 500);
    }
}
