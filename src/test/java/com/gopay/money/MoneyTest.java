package com.gopay.money;

import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertIterableEquals;

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

    @Test
    public void shouldSubtractMoney() {
        Money amount1 = new Money(10, 10);
        Money amount2 = new Money(20, 20);

        Money result = amount2.subtract(amount1);

        assertEquals(10, result.getRupee());
        assertEquals(10, result.getPaise());
    }

    @Test
    public void shouldSubtractMoneyWhenResultingAmountIsNegative() {
        Money amount1 = new Money(10, 10);
        Money amount2 = new Money(20, 20);

        Money result = amount1.subtract(amount2);

        assertEquals(-10, result.getRupee());
        assertEquals(-10, result.getPaise());
    }

    @Test
    public void shouldPrintMoneyInRupeesAndPaise() {
        assertEquals("Rs. 10.10", new Money(10, 10).format());
        assertEquals("Rs. -9.90", new Money(-10, 10).format());
        assertEquals("Rs. 9.90", new Money(10, -10).format());
        assertEquals("Rs. -10.10", new Money(-10, -10).format());
    }

    @Test
    public void shouldSortMoney() {
        List<Money> moneyList = Arrays.asList(new Money(10, 10), new Money(-10, 10), new Money(10, -10), new Money(-10, -10), new Money(20, 20), new Money(-20, -20));
        Collections.sort(moneyList);
        assertIterableEquals(Arrays.asList(new Money(-20, -20), new Money(-10, -10), new Money(-10, 10), new Money(10, -10), new Money(10, 10), new Money(20, 20)), moneyList);
    }
}
