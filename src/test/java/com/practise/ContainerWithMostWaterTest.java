package com.practise;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class ContainerWithMostWaterTest {

    @Test
    void mainExample() {
        assertEquals(49, ContainerWithMostWater.maxArea(new int[] {1, 8, 6, 2, 5, 4, 8, 3, 7}));
    }

    @Test
    void twoLinesOnly() {
        assertEquals(1, ContainerWithMostWater.maxArea(new int[] {1, 1}));
    }

    @Test
    void allLinesSameHeightUsesFullWidth() {
        assertEquals(12, ContainerWithMostWater.maxArea(new int[] {4, 4, 4, 4}));
    }

    @Test
    void bestPairIsAtTheFarEnds() {
        assertEquals(20, ContainerWithMostWater.maxArea(new int[] {5, 1, 1, 1, 5}));
    }

    @Test
    void bestPairIsNextToEachOther() {
        // two tall lines side by side beat wider, shorter pairs
        assertEquals(17, ContainerWithMostWater.maxArea(new int[] {2, 3, 4, 5, 18, 17, 6}));
    }

    @Test
    void bestPairIsNotTheTallestLines() {
        // the case that broke the "best so far" idea
        assertEquals(4, ContainerWithMostWater.maxArea(new int[] {1, 2, 4, 3}));
    }

    @Test
    void tallMiddleWithShortEnds() {
        assertEquals(100, ContainerWithMostWater.maxArea(new int[] {1, 100, 100, 1}));
    }

    @Test
    void increasingHeights() {
        assertEquals(6, ContainerWithMostWater.maxArea(new int[] {1, 2, 3, 4, 5}));
    }

    @Test
    void decreasingHeights() {
        assertEquals(6, ContainerWithMostWater.maxArea(new int[] {5, 4, 3, 2, 1}));
    }

    @Test
    void zeroHeightsHoldNoWater() {
        assertEquals(0, ContainerWithMostWater.maxArea(new int[] {0, 0}));
    }

    @Test
    void zeroAtBothEndsHoldsNoWater() {
        assertEquals(0, ContainerWithMostWater.maxArea(new int[] {0, 5, 0}));
    }
}