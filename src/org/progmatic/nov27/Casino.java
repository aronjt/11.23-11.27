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
        int bet;
        String game;
        Scanner scString = new Scanner(System.in);
        do {
            System.out.println("Mire fogadsz?");
            System.out.println("Szín / Paritás / Harmad / Szám / Vége");
            game = scString.nextLine().toLowerCase();
            switch (game) {
                case "szín":
                    System.out.println("Melyikre színre teszel?");
                    System.out.println("Piros / Fekete");
                    String color = scString.nextLine();
                    System.out.print("Tét: ");
                    bet = scInt.nextInt();
                    wallet -= bet;
                    int winLoss = rouletteTable.colourBet(color, bet);
                    wallet += winLoss;
                    System.out.println("Ennyi pénzed van: " + wallet);
                    break;
                case "paritás":
                    System.out.println("Páros vagy páratlan?");
                    String parity = scString.nextLine();
                    System.out.print("Tét: ");
                    bet = scInt.nextInt();
                    wallet -= bet;
                    winLoss = rouletteTable.parityBet(parity, bet);
                    wallet += winLoss;
                    System.out.println("Ennyi pénzed van: " + wallet);
                    break;
                case "szám":
                    System.out.println("Melyik számra teszel?");
                    int number = scInt.nextInt();
                    System.out.print("Tét: ");
                    bet = scInt.nextInt();
                    wallet -= bet;
                    winLoss = rouletteTable.numberBet(number, bet);
                    wallet += winLoss;
                    System.out.println("Ennyi pénzed van: " + wallet);
                    break;
                case "harmad":
                    System.out.println("Hanyadik harmadra teszel?");
                    number = scInt.nextInt();
                    System.out.print("Tét: ");
                    bet = scInt.nextInt();
                    wallet -= bet;
                    winLoss = rouletteTable.thirdBet(number, bet);
                    wallet += winLoss;
                    System.out.println("Ennyi pénzed van: " + wallet);
                    break;
            }
        }

        while (!game.equals("vége"));
        System.out.println("Köszönöm a játékot");

    }
}
