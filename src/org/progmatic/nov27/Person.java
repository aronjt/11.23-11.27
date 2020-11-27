package org.progmatic.nov27;

public abstract class Person {

    protected int wallet;
    protected int bet;

    public Person(int money, int bet) {
        this.wallet = money;
        this.bet = bet;
    }

    public abstract void strategy(RouletteTable rouletteTable);

    public abstract int getWallet();

    public abstract int getBet();
}
