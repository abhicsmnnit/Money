package com.gopay.money;

public class Money {
    private final int paise;

    public Money(int rupee, int paise) {
        this.paise = rupee * 100 + paise;
    }

    public int getRupee() {
        return paise / 100;
    }

    public int getPaise() {
        return paise % 100;
    }

    public int get() {
        return paise;
    }

    public Money add(Money money) {
        int totalAmountInPaise = get() + money.get();
        return new Money(totalAmountInPaise / 100, totalAmountInPaise % 100);
    }

    public Money subtract(Money money) {
        int totalAmountInPaise = get() - money.get();
        return new Money(totalAmountInPaise / 100, totalAmountInPaise % 100);
    }
}
