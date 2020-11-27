package org.progmatic.nov27;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class RouletteTable {

    private final List<Integer> greenNumbers = new ArrayList<>();
    private final List<Integer> redNumbers = new ArrayList<>();
    private final List<Integer> blackNumbers = new ArrayList<>();
    private int minBet;
    private int maxBet;

    public RouletteTable() {
        greenNumbers.add(0);
        redNumbers.add(1);
        redNumbers.add(3);
        redNumbers.add(5);
        redNumbers.add(7);
        redNumbers.add(9);
        redNumbers.add(12);
        redNumbers.add(14);
        redNumbers.add(16);
        redNumbers.add(18);
        redNumbers.add(19);
        redNumbers.add(21);
        redNumbers.add(23);
        redNumbers.add(25);
        redNumbers.add(27);
        redNumbers.add(30);
        redNumbers.add(32);
        redNumbers.add(34);
        redNumbers.add(36);
        blackNumbers.add(2);
        blackNumbers.add(4);
        blackNumbers.add(6);
        blackNumbers.add(8);
        blackNumbers.add(10);
        blackNumbers.add(11);
        blackNumbers.add(13);
        blackNumbers.add(15);
        blackNumbers.add(17);
        blackNumbers.add(20);
        blackNumbers.add(22);
        blackNumbers.add(24);
        blackNumbers.add(26);
        blackNumbers.add(28);
        blackNumbers.add(29);
        blackNumbers.add(31);
        blackNumbers.add(33);
        blackNumbers.add(35);
    }

    public void setMinBet(int minBet) {
        this.minBet = minBet;
    }

    public void setMaxBet(int maxBet) {
        this.maxBet = maxBet;
    }

    private int spin() {
        return (int)(Math.random()*37);
    }

    public int colourBet(String colour, int bet) {
        int spin = spin();
        if (redNumbers.contains(spin) && colour.equalsIgnoreCase("piros")) {
            System.out.println("Piros " + spin);
            System.out.println("Nyeremény: " + bet * 2);
            return bet * 2;
        } else if (redNumbers.contains(spin)) {
            System.out.println("Piros " + spin);
            System.out.println("Vesztettél: " + (-bet));
            return 0;
        }
        if (blackNumbers.contains(spin) && colour.equalsIgnoreCase("fekete")) {
            System.out.println("Fekete " + spin);
            System.out.println("Nyeremény: " + bet * 2);
            return bet * 2;
        } else if (blackNumbers.contains(spin)) {
            System.out.println("Fekete " + spin);
            System.out.println("Vesztettél: " + (-bet));
            return 0;
        }
        if (greenNumbers.contains(spin)) {
            System.out.println("Zöld " + spin);
            System.out.println("Vesztettél: " + (-bet));
        }
        return 0;
    }

    public int parityBet(String parity, int bet) {
        int spin = spin();
        if (spin % 2 == 0 && parity.equalsIgnoreCase("páros") && spin !=0) {
            if (redNumbers.contains(spin)) {
                System.out.println("Piros " + spin);
                System.out.println("Nyeremény: " + bet * 2);
                return bet * 2;
            } else if (blackNumbers.contains(spin)) {
                System.out.println("Fekete " + spin);
                System.out.println("Nyeremény: " + bet * 2);
                return bet * 2;
            }
        } else if (spin % 2 == 0 && spin != 0) {
            if (redNumbers.contains(spin)) {
                System.out.println("Piros " + spin);
                System.out.println("Vesztettél: " + (-bet));
                return 0;
            } else if (blackNumbers.contains(spin)) {
                System.out.println("Fekete " + spin);
                System.out.println("Vesztettél: " + (-bet));
                return 0;
            }
        }
        if (spin % 2 != 0 && parity.equalsIgnoreCase("páratlan")) {
            if (redNumbers.contains(spin)) {
                System.out.println("Piros " + spin);
                System.out.println("Nyeremény: " + bet * 2);
                return bet * 2;
            } else if (blackNumbers.contains(spin)) {
                System.out.println("Fekete " + spin);
                System.out.println("Nyeremény: " + bet * 2);
                return bet * 2;
            }
        } else if (spin % 2 != 0) {
            if (redNumbers.contains(spin)) {
                System.out.println("Piros " + spin);
                System.out.println("Vesztettél: " + (-bet));
                return 0;
            } else if (blackNumbers.contains(spin)) {
                System.out.println("Fekete " + spin);
                System.out.println("Vesztettél: " + (-bet));
                return 0;
            }
        }
        if (spin == 0) {
            System.out.println("Zöld " + spin);
            System.out.println("Vesztettél: " + (-bet));
        }
        return 0;
    }
}
