package com.practise;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class MaximumAverageSubarrayTest {

    private static final double DELTA = 1e-9;

    @Test
    void leetCodeExample() {
        assertEquals(12.75, MaximumAverageSubarray.findMaxAverage(new int[]{1, 12, -5, -6, 50, 3}, 4), DELTA);
    }

    @Test
    void arrayLengthEqualsK() {
        assertEquals(5.0, MaximumAverageSubarray.findMaxAverage(new int[]{5}, 1), DELTA);
    }

    @Test
    void wholeArrayIsTheOnlyWindow() {
        assertEquals(2.5, MaximumAverageSubarray.findMaxAverage(new int[]{1, 2, 3, 4}, 4), DELTA);
    }

    @Test
    void kIsOneReturnsMaxElement() {
        assertEquals(9.0, MaximumAverageSubarray.findMaxAverage(new int[]{3, 9, -2, 7}, 1), DELTA);
    }

    @Test
    void allNegativeNumbers() {
        assertEquals(-1.0, MaximumAverageSubarray.findMaxAverage(new int[]{-1, -2, -3}, 1), DELTA);
    }

    @Test
    void allNegativeWithLargerWindow() {
        assertEquals(-2.5, MaximumAverageSubarray.findMaxAverage(new int[]{-5, -2, -3, -8}, 2), DELTA);
    }

    @Test
    void bestWindowIsTheFirst() {
        assertEquals(5.5, MaximumAverageSubarray.findMaxAverage(new int[]{10, 1, 1}, 2), DELTA);
    }

    @Test
    void bestWindowIsTheLast() {
        assertEquals(9.5, MaximumAverageSubarray.findMaxAverage(new int[]{1, 1, 9, 10}, 2), DELTA);
    }

    @Test
    void averageIsNotAWholeNumber() {
        // catches integer division: 7 / 2 must be 3.5, not 3
        assertEquals(3.5, MaximumAverageSubarray.findMaxAverage(new int[]{3, 4, 1}, 2), DELTA);
    }

    @Test
    void allEqualValues() {
        assertEquals(4.0, MaximumAverageSubarray.findMaxAverage(new int[]{4, 4, 4, 4}, 3), DELTA);
    }

    @Test
    void zerosAndNegatives() {
        assertEquals(0.0, MaximumAverageSubarray.findMaxAverage(new int[]{-1, 0, 0, -1}, 2), DELTA);
    }
}