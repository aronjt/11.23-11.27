package org.progmatic.nov27;

import java.util.Scanner;

public class Casino {


    public void rouletteSimulation(Person person, RouletteTable rouletteTable) {
        do {
            person.strategy(rouletteTable);
        }
        while (person.getBet() < person.getWallet());
    }

    public void rouletteOneSimulation(Person person, RouletteTable rouletteTable) {
        person.strategy(rouletteTable);
    }

    public void rouletteGame(RouletteTable rouletteTable) {
        Scanner scInt = new Scanner(System.in);
        System.out.print("Kezdő pénz: ");
        int wallet = 0;
        while (wallet <= 0) {
            try {
                wallet = scInt.nextInt();
                System.out.println("Kassza: " + wallet);
            } catch (Exception e) {
                System.out.println("Számot írj be");
                scInt = new Scanner(System.in);
            }
        }
        int bet;
        String game;
        Scanner scString = new Scanner(System.in);
        do {
            System.out.println("Mire fogadsz?");
            System.out.println("Szín / Paritás / Harmad / Szám / Vége");
            game = scString.nextLine().toLowerCase();
            switch (game) {
                case "szín":
                    String color;
                    do {
                        System.out.println("Melyikre színre teszel?");
                        System.out.println("Piros / Fekete");
                        color = scString.nextLine().toLowerCase();
                    }
                    while (!color.equals("piros") && !color.equals("fekete"));
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
                    String parity;
                    do {
                        System.out.println("Páros vagy páratlan?");
                        parity = scString.nextLine().toLowerCase();
                    }
                    while (!parity.equals("páros") && !parity.equals("páratlan"));
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
                            do {
                                System.out.println("0 - 36");
                                number = scInt.nextInt();
                            }
                            while (number > 36);
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
                            do {
                                System.out.println("1 / 2 / 3");
                                number = scInt.nextInt();
                            }
                            while (number != 1 && number != 2 && number != 3);
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
        if (wallet > 0) {
            System.out.println("Kifizetés Papp Gergőnél van");
            System.out.println("Összeg: " + wallet + " HUF");
        }

    }
}
