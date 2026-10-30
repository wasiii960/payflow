package com.practise;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class BestTimeToBuyAndSellStockTest {

    @Test
    void mainExample() {
        assertEquals(5, BestTimeToBuyAndSellStock.maxProfit(new int[] {7, 1, 5, 3, 6, 4}));
    }

    @Test
    void pricesOnlyFallReturnsZero() {
        assertEquals(0, BestTimeToBuyAndSellStock.maxProfit(new int[] {7, 6, 4, 3, 1}));
    }

    @Test
    void cheapestDayComesAfterBestSellDay() {
        assertEquals(2, BestTimeToBuyAndSellStock.maxProfit(new int[] {2, 4, 1}));
    }

    @Test
    void globalMinimumIsNotTheBestBuy() {
        assertEquals(5, BestTimeToBuyAndSellStock.maxProfit(new int[] {3, 8, 1, 2}));
    }

    @Test
    void allPricesEqualReturnsZero() {
        assertEquals(0, BestTimeToBuyAndSellStock.maxProfit(new int[] {3, 3, 3}));
    }

    @Test
    void buyFirstDaySellLastDay() {
        assertEquals(2, BestTimeToBuyAndSellStock.maxProfit(new int[] {1, 2, 3}));
    }

    @Test
    void singleDayReturnsZero() {
        assertEquals(0, BestTimeToBuyAndSellStock.maxProfit(new int[] {5}));
    }

    @Test
    void lateMinimumIsTheBestBuy() {
        assertEquals(2, BestTimeToBuyAndSellStock.maxProfit(new int[] {2, 1, 2, 1, 0, 1, 2}));
    }

    @Test
    void bestSellIsLastDayNotFirstPeak() {
        assertEquals(9, BestTimeToBuyAndSellStock.maxProfit(new int[] {1, 9, 2, 10}));
    }

    @Test
    void earlyHighPriceIsIgnored() {
        assertEquals(7, BestTimeToBuyAndSellStock.maxProfit(new int[] {9, 1, 8, 2, 7}));
    }

    @Test
    void bestTradeHappensBeforeNewLowerMinimum() {
        assertEquals(3, BestTimeToBuyAndSellStock.maxProfit(new int[] {4, 7, 1, 2}));
    }

    @Test
    void repeatedMinimumValues() {
        assertEquals(10, BestTimeToBuyAndSellStock.maxProfit(new int[] {10, 1, 1, 1, 11}));
    }
}