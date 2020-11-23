package org.progmatic;

import org.progmatic.nov23.House;

public class Main {
    public static void main(String[] args) {
        House house = new House();
        System.out.println(house);
        house.heating();
        System.out.println(house);
        house.demist();
        System.out.println(house);
    }
}
