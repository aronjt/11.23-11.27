package org.progmatic.nov27;

public class Casino {


    public void roulette(Person person, RouletteTable rouletteTable) {
        do {
            person.strategy(rouletteTable);
        }
        while (person.getBet() < person.getWallet());
    }


}
