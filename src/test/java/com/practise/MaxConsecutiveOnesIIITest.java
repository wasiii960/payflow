package com.practise;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class MaxConsecutiveOnesIIITest {

    @Test
    void leetCodeExample1() {
        assertEquals(6, MaxConsecutiveOnesIII.longestOnes(new int[]{1, 1, 1, 0, 0, 0, 1, 1, 1, 1, 0}, 2));
    }

    @Test
    void leetCodeExample2() {
        assertEquals(10, MaxConsecutiveOnesIII.longestOnes(
                new int[]{0, 0, 1, 1, 0, 0, 1, 1, 1, 0, 1, 1, 0, 0, 0, 1, 1, 1, 1}, 3));
    }

    @Test
    void allZerosNoFlips() {
        // fails with length - max(counts): a window of zeros is not a run of ones
        assertEquals(0, MaxConsecutiveOnesIII.longestOnes(new int[]{0, 0, 0}, 0));
    }

    @Test
    void allOnesNoFlips() {
        assertEquals(3, MaxConsecutiveOnesIII.longestOnes(new int[]{1, 1, 1}, 0));
    }

    @Test
    void handTraceExample() {
        assertEquals(3, MaxConsecutiveOnesIII.longestOnes(new int[]{1, 0, 1, 0, 1}, 1));
    }

    @Test
    void singleOne() {
        // fails with right - left instead of right - left + 1
        assertEquals(1, MaxConsecutiveOnesIII.longestOnes(new int[]{1}, 0));
    }

    @Test
    void singleZeroNoFlips() {
        assertEquals(0, MaxConsecutiveOnesIII.longestOnes(new int[]{0}, 0));
    }

    @Test
    void singleZeroOneFlip() {
        assertEquals(1, MaxConsecutiveOnesIII.longestOnes(new int[]{0}, 1));
    }

    @Test
    void flipEverything() {
        assertEquals(3, MaxConsecutiveOnesIII.longestOnes(new int[]{0, 0, 0}, 3));
    }

    @Test
    void zeroFlipsTwoSeparateOnes() {
        assertEquals(1, MaxConsecutiveOnesIII.longestOnes(new int[]{1, 0, 0, 1}, 0));
    }

    @Test
    void zerosAtBothEnds() {
        assertEquals(5, MaxConsecutiveOnesIII.longestOnes(new int[]{0, 1, 1, 1, 0}, 2));
    }

    @Test
    void windowMustShrinkSeveralTimes() {
        assertEquals(6, MaxConsecutiveOnesIII.longestOnes(new int[]{1, 0, 1, 1, 0, 1, 0, 0, 1, 1}, 2));
    }
}