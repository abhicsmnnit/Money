package com.gopay.money;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class MoneyTest {

    @Test
    public void shouldAddMoney() {
        Money amount1 = new Money(10, 10);
        Money amount2 = new Money(20, 20);

        Money result = amount1.add(amount2);

        assertEquals(30, result.getRupee());
        assertEquals(30, result.getPaise());
    }

    @Test
    public void shouldAddMoneyWhenPaiseOverflowDuringAddition() {
        Money amount1 = new Money(10, 50);
        Money amount2 = new Money(20, 70);

        Money result = amount1.add(amount2);

        assertEquals(31, result.getRupee());
        assertEquals(20, result.getPaise());
    }
}
