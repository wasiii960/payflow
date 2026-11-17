package com.practise;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class NumArrayTest {

    private final NumArray numArray = new NumArray(new int[] {-2, 0, 3, -5, 2, -1});

    @Test
    void rangeStartingAtZero() {
        assertEquals(1, numArray.sumRange(0, 2));
    }

    @Test
    void rangeEndingAtLastIndex() {
        assertEquals(-1, numArray.sumRange(2, 5));
    }

    @Test
    void wholeArray() {
        assertEquals(-3, numArray.sumRange(0, 5));
    }

    @Test
    void singleElementInTheMiddle() {
        assertEquals(3, numArray.sumRange(2, 2));
    }

    @Test
    void singleZeroElement() {
        assertEquals(0, numArray.sumRange(1, 1));
    }

    @Test
    void singleFirstElement() {
        assertEquals(-2, numArray.sumRange(0, 0));
    }

    @Test
    void singleLastElement() {
        assertEquals(-1, numArray.sumRange(5, 5));
    }

    @Test
    void rangeThatSumsToZero() {
        assertEquals(0, numArray.sumRange(1, 4));
    }

    @Test
    void manyQueriesOnTheSameArray() {
        // the array must not change between queries
        assertEquals(1, numArray.sumRange(0, 2));
        assertEquals(-1, numArray.sumRange(2, 5));
        assertEquals(1, numArray.sumRange(0, 2));
    }
}