package org.progmatic;

import org.progmatic.nov27.*;

public class Main {
    public static void main(String[] args) {
        RouletteTable rouletteTable = new RouletteTable(100,10000);
        Casino casino = new Casino();
        System1326 system1326 = new System1326(10000, 100);
        casino.rouletteGame(rouletteTable);
    }
}
