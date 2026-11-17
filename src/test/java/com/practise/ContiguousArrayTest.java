package com.practise;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ContiguousArrayTest {

    @Test
    void twoElementsBalanced() {
        assertEquals(2, ContiguousArray.findMaxLength(new int[]{0, 1}));
    }

    @Test
    void threeElementsBestIsTwo() {
        assertEquals(2, ContiguousArray.findMaxLength(new int[]{0, 1, 0}));
    }

    @Test
    void wholeArrayBalancedNeedsFirstIndex() {
        // fails if the map overwrites the first index
        assertEquals(4, ContiguousArray.findMaxLength(new int[]{0, 1, 0, 1}));
    }

    @Test
    void longestInTheMiddle() {
        assertEquals(6, ContiguousArray.findMaxLength(new int[]{0, 0, 1, 0, 0, 0, 1, 1}));
    }

    @Test
    void allZerosHasNoBalancedSubarray() {
        assertEquals(0, ContiguousArray.findMaxLength(new int[]{0, 0, 0}));
    }

    @Test
    void allOnesHasNoBalancedSubarray() {
        assertEquals(0, ContiguousArray.findMaxLength(new int[]{1, 1, 1}));
    }

    @Test
    void singleElement() {
        assertEquals(0, ContiguousArray.findMaxLength(new int[]{1}));
    }

    @Test
    void balancedFromIndexZeroNeedsStartingEntry() {
        // fails without map.put(0, -1)
        assertEquals(2, ContiguousArray.findMaxLength(new int[]{1, 0, 1, 1}));
    }

    @Test
    void laterShorterMatchMustNotReplaceLongerOne() {
        // fails if length is overwritten instead of taking the max
        assertEquals(4, ContiguousArray.findMaxLength(new int[]{0, 0, 1, 1, 0}));
    }

    @Test
    void longAlternating() {
        assertEquals(10, ContiguousArray.findMaxLength(new int[]{1, 0, 1, 0, 1, 0, 1, 0, 1, 0}));
    }

    @Test
    void balancedPartAtTheEnd() {
        assertEquals(2, ContiguousArray.findMaxLength(new int[]{1, 1, 1, 0}));
    }

    @Test
    void resolveTwoElementsBalanced() {
        // fails without map.put(0, -1)
        assertEquals(2, ContiguousArray.findMaxLengthResolve(new int[]{0, 1}));
    }

    @Test
    void resolveThreeElementsBestIsTwo() {
        assertEquals(2, ContiguousArray.findMaxLengthResolve(new int[]{0, 1, 0}));
    }

    @Test
    void resolveWholeArrayBalanced() {
        // fails if the map overwrites the first index
        assertEquals(4, ContiguousArray.findMaxLengthResolve(new int[]{0, 1, 0, 1}));
    }

    @Test
    void resolveLongestInTheMiddle() {
        assertEquals(6, ContiguousArray.findMaxLengthResolve(new int[]{0, 0, 1, 0, 0, 0, 1, 1}));
    }

    @Test
    void resolveAllZeros() {
        assertEquals(0, ContiguousArray.findMaxLengthResolve(new int[]{0, 0, 0}));
    }

    @Test
    void resolveAllOnes() {
        assertEquals(0, ContiguousArray.findMaxLengthResolve(new int[]{1, 1, 1}));
    }

    @Test
    void resolveSingleElement() {
        assertEquals(0, ContiguousArray.findMaxLengthResolve(new int[]{1}));
    }

    @Test
    void resolveBalancedFromIndexZero() {
        // fails with map.put(0, 0) instead of (0, -1)
        assertEquals(2, ContiguousArray.findMaxLengthResolve(new int[]{1, 0, 1, 1}));
    }

    @Test
    void resolveLaterShorterMatchMustNotReplaceLonger() {
        // fails if length is overwritten instead of taking the max
        assertEquals(4, ContiguousArray.findMaxLengthResolve(new int[]{0, 0, 1, 1, 0}));
    }

    @Test
    void resolveLongAlternating() {
        assertEquals(10, ContiguousArray.findMaxLengthResolve(new int[]{1, 0, 1, 0, 1, 0, 1, 0, 1, 0}));
    }

    @Test
    void resolveBalancedPartAtTheEnd() {
        assertEquals(2, ContiguousArray.findMaxLengthResolve(new int[]{1, 1, 1, 0}));
    }
}