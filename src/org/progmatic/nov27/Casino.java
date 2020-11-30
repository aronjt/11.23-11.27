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
                    do {
                        System.out.print("Tét: ");
                        bet = scInt.nextInt();
                    }
                    while (bet > wallet);
                    wallet -= bet;
                    int winLoss = rouletteTable.colourBet(color, bet);
                    wallet += winLoss;
                    System.out.println("Ennyi pénzed van: " + wallet);
                    break;
                case "paritás":
                    System.out.println("Páros vagy páratlan?");
                    String parity = scString.nextLine();
                    do {
                        System.out.print("Tét: ");
                        bet = scInt.nextInt();
                    }
                    while (bet > wallet);
                    wallet -= bet;
                    winLoss = rouletteTable.parityBet(parity, bet);
                    wallet += winLoss;
                    System.out.println("Ennyi pénzed van: " + wallet);
                    break;
                case "szám":
                    int number = 0;
                    boolean check = false;
                    System.out.println("Melyik számra teszel?");
                    while (!check) {
                        try {
                            number = scInt.nextInt();
                            check = true;
                        } catch (Exception e) {
                            System.out.println("Számot írj be");
                            scInt = new Scanner(System.in);
                        }
                    }
                    do {
                        System.out.print("Tét: ");
                        bet = scInt.nextInt();
                    }
                    while (bet > wallet);
                    wallet -= bet;
                    winLoss = rouletteTable.numberBet(number, bet);
                    wallet += winLoss;
                    System.out.println("Ennyi pénzed van: " + wallet);
                    break;
                case "harmad":
                    number = 0;
                    check = false;
                    System.out.println("Hanyadik harmadra teszel?");
                    while (!check) {
                        try {
                            number = scInt.nextInt();
                            check = true;
                        } catch (Exception e) {
                            System.out.println("Számot írj be");
                            scInt = new Scanner(System.in);
                        }
                    }
                    do {
                        System.out.print("Tét: ");
                        bet = scInt.nextInt();
                    }
                    while (bet > wallet);
                    wallet -= bet;
                    winLoss = rouletteTable.thirdBet(number, bet);
                    wallet += winLoss;
                    System.out.println("Ennyi pénzed van: " + wallet);
                    break;
            }
            if (wallet < rouletteTable.getMinBet()) {
                System.out.println("Elfogyott a pénzed");
                System.out.print("Helyezzen be pénz: ");
                try {
                    wallet += scInt.nextInt();
                }
                catch (Exception e) {
                    System.out.println("Játék vége");
                    game = "vége";
                }
            }
        }

        while (!game.equals("vége"));
        System.out.println("Köszönöm a játékot");

    }
}
