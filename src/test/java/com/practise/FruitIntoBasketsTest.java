package com.practise;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class FruitIntoBasketsTest {

    @Test
    void leetCodeExample1() {
        assertEquals(3, FruitIntoBaskets.totalFruit(new int[]{1, 2, 1}));
    }

    @Test
    void leetCodeExample2() {
        assertEquals(3, FruitIntoBaskets.totalFruit(new int[]{0, 1, 2, 2}));
    }

    @Test
    void leetCodeExample3() {
        assertEquals(4, FruitIntoBaskets.totalFruit(new int[]{1, 2, 3, 2, 2}));
    }

    @Test
    void longerMixedRow() {
        assertEquals(5, FruitIntoBaskets.totalFruit(new int[]{3, 3, 3, 1, 2, 1, 1, 2, 3, 3, 4}));
    }

    @Test
    void singleTree() {
        assertEquals(1, FruitIntoBaskets.totalFruit(new int[]{1}));
    }

    @Test
    void allSameType() {
        assertEquals(4, FruitIntoBaskets.totalFruit(new int[]{1, 1, 1, 1}));
    }

    @Test
    void exactlyTwoTypes() {
        assertEquals(2, FruitIntoBaskets.totalFruit(new int[]{1, 2}));
    }

    @Test
    void repeatsMustBeCounted() {
        // fails if the map only records a type when it's new, or sets it to 1
        assertEquals(4, FruitIntoBaskets.totalFruit(new int[]{1, 1, 1, 2, 3, 3}));
    }

    @Test
    void removingOneCopyKeepsTheType() {
        // fails if count is lowered on every removal
        assertEquals(3, FruitIntoBaskets.totalFruit(new int[]{1, 1, 2, 3}));
    }

    @Test
    void allDifferent() {
        assertEquals(2, FruitIntoBaskets.totalFruit(new int[]{1, 2, 3, 4, 5}));
    }

    @Test
    void longestAtTheEnd() {
        assertEquals(5, FruitIntoBaskets.totalFruit(new int[]{1, 2, 1, 2, 3, 3, 3, 3}));
    }

    @Test
    void typeReturnsAfterLeaving() {
        assertEquals(5, FruitIntoBaskets.totalFruit(new int[]{0, 1, 6, 6, 4, 4, 6}));
    }
}