package com.practise;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class SubarraySumEqualsKTest {

    @Test
    void leetCodeExample1() {
        assertEquals(2, SubarraySumEqualsK.subarraySumResolve(new int[]{1, 1, 1}, 2));
    }

    @Test
    void leetCodeExample2() {
        assertEquals(2, SubarraySumEqualsK.subarraySumResolve(new int[]{1, 2, 3}, 3));
    }

    @Test
    void noSubarrayMatches() {
        assertEquals(0, SubarraySumEqualsK.subarraySumResolve(new int[]{1, 2, 3}, 7));
    }

    @Test
    void singleElementEqualsK() {
        // fails without map.put(0, 1)
        assertEquals(1, SubarraySumEqualsK.subarraySumResolve(new int[]{3}, 3));
    }

    @Test
    void singleElementNotK() {
        assertEquals(0, SubarraySumEqualsK.subarraySumResolve(new int[]{5}, 3));
    }

    @Test
    void wholeArraySumsToK() {
        assertEquals(1, SubarraySumEqualsK.subarraySumResolve(new int[]{1, 1, 1}, 3));
    }

    @Test
    void negativesAndZero() {
        // [1,-1], [0], [1,-1,0]
        assertEquals(3, SubarraySumEqualsK.subarraySumResolve(new int[]{1, -1, 0}, 0));
    }

    @Test
    void allZerosWithKZero() {
        // every one of the 6 subarrays sums to 0; fails if a total can match itself
        assertEquals(6, SubarraySumEqualsK.subarraySumResolve(new int[]{0, 0, 0}, 0));
    }

    @Test
    void alternatingCancelOut() {
        // [1,-1] x3 positions and the whole array
        assertEquals(4, SubarraySumEqualsK.subarraySumResolve(new int[]{1, -1, 1, -1}, 0));
    }

    @Test
    void negativeK() {
        assertEquals(1, SubarraySumEqualsK.subarraySumResolve(new int[]{-1, -2, 3}, -3));
    }

    @Test
    void overlappingMatches() {
        // [1,2], [2,1], [1,2], [2,1]
        assertEquals(4, SubarraySumEqualsK.subarraySumResolve(new int[]{1, 2, 1, 2, 1}, 3));
    }

    @Test
    void sameTotalSeenTwiceCountsTwice() {
        // totals: 0,1,0,1 -> at the last step total 1 was seen twice before? check:
        // [1,-1,1]: subarrays summing to 1 are [1], [1](index 2), [1,-1,1] -> 3
        assertEquals(3, SubarraySumEqualsK.subarraySumResolve(new int[]{1, -1, 1}, 1));
    }
}