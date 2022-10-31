package com.gopay.money;

public class Money {
    private int rupee;
    private int paise;

    public Money(int rupee, int paise) {
        this.rupee = rupee;
        this.paise = paise;
    }

    public int getRupee() {
        return rupee;
    }

    public int getPaise() {
        return paise;
    }

    public Money add(Money money) {
        return new Money(getRupee() + money.getRupee() + (getPaise() + money.getPaise()) / 100,
                (getPaise() + money.getPaise()) % 100);
    }
}
