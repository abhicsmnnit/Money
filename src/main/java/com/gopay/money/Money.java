package com.gopay.money;

public class Money implements Comparable<Money> {
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

    public String format() {
        return String.format("Rs. %d.%d", getRupee(), Math.abs(getPaise()));
    }

    @Override
    public String toString() {
        return this.format();
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }

        if (obj == null) {
            return false;
        }

        if (this.getClass() != obj.getClass()) {
            return false;
        }

        return this.get() == ((Money) obj).get();
    }

    @Override
    public int hashCode() {
        return get();
    }

    @Override
    public int compareTo(Money money) {
        return this.get() - money.get();
    }
}
