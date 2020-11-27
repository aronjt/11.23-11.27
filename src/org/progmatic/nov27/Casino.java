package org.progmatic.nov27;

import java.util.Scanner;

public class Casino {


    public void rouletteSimulation(Person person, RouletteTable rouletteTable) {
        do {
            person.strategy(rouletteTable);
        }
        while (person.getBet() < person.getWallet());
    }

    public void rouletteGame(RouletteTable rouletteTable) {
        Scanner scInt = new Scanner(System.in);
        System.out.print("Kezdő pénz: ");
        int wallet = scInt.nextInt();
        Scanner scString = new Scanner(System.in);
        System.out.println("Mire fogadsz?");
        System.out.println("Szín / Paritás / Harmad / Szám");
        String game = scString.nextLine().toLowerCase();
        int bet;

        switch (game) {
            case "szín":
                System.out.println("Melyikre színre teszel?");
                String color = scString.nextLine();
                System.out.print("Tét: ");
                bet = scInt.nextInt();
                wallet -= bet;
                int winLoss = rouletteTable.colourBet(color, bet);
                wallet += winLoss;
                System.out.println("Ennyi pénzed van: " + wallet);
            case "paritás":
                System.out.println("Páros vagy páratlan?");
                String parity = scString.nextLine();
                System.out.print("Tét: ");
                bet = scInt.nextInt();
                wallet -= bet;
                winLoss = rouletteTable.parityBet(parity, bet);
                wallet += winLoss;
                System.out.println("Ennyi pénzed van: " + wallet);

        }
    }
}
