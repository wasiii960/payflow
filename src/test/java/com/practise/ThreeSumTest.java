package com.practise;

import org.junit.jupiter.api.Test;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

import static org.junit.jupiter.api.Assertions.*;

class ThreeSumTest {

    // Compares ignoring the order of triplets
    private void check(int[] nums, List<List<Integer>> expected) {
        List<List<Integer>> actual = ThreeSum.threeSum(nums);
        assertEquals(expected.size(), actual.size(), "wrong number of triplets (duplicates?)");
        assertEquals(new HashSet<>(expected), new HashSet<>(actual));
    }

    @Test
    void mainExample() {
        check(new int[] {-1, 0, 1, 2, -1, -4},
                List.of(List.of(-1, -1, 2), List.of(-1, 0, 1)));
    }

    @Test
    void allZerosGiveOneTriplet() {
        check(new int[] {0, 0, 0}, List.of(List.of(0, 0, 0)));
    }

    @Test
    void manyZerosStillGiveOnlyOneTriplet() {
        check(new int[] {0, 0, 0, 0}, List.of(List.of(0, 0, 0)));
    }

    @Test
    void noTripletSumsToZero() {
        check(new int[] {0, 1, 1}, List.of());
    }

    @Test
    void fewerThanThreeElements() {
        check(new int[] {1, 2}, List.of());
    }

    @Test
    void emptyArray() {
        check(new int[] {}, List.of());
    }

    @Test
    void secondNumberMustMoveNotFirst() {
        // the case that broke the single-loop version
        check(new int[] {-4, -2, 1, 2, 3}, List.of(List.of(-4, 1, 3)));
    }

    @Test
    void sameFirstNumberWithTwoDifferentPairs() {
        check(new int[] {-2, 0, 1, 1, 2},
                List.of(List.of(-2, 0, 2), List.of(-2, 1, 1)));
    }

    @Test
    void unsortedInputWithSeveralTriplets() {
        check(new int[] {3, 0, -2, -1, 1, 2},
                List.of(List.of(-2, -1, 3), List.of(-2, 0, 2), List.of(-1, 0, 1)));
    }
}