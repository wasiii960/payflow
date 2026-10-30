package com.practise;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class MoveZeroesTest {

    private void check(int[] input, int[] expected) {
        MoveZeroes.moveZeroes(input);
        assertArrayEquals(expected, input);
    }

    @Test
    void mainExample() {
        check(new int[] {0, 1, 0, 3, 12}, new int[] {1, 3, 12, 0, 0});
    }

    @Test
    void zerosScatteredInTheMiddle() {
        check(new int[] {1, 0, 2, 0, 0, 3}, new int[] {1, 2, 3, 0, 0, 0});
    }

    @Test
    void severalZerosInARowAtTheStart() {
        check(new int[] {0, 0, 1, 2}, new int[] {1, 2, 0, 0});
    }

    @Test
    void manyZerosThenOneNumber() {
        check(new int[] {0, 0, 0, 1}, new int[] {1, 0, 0, 0});
    }

    @Test
    void noZerosLeavesArrayUnchanged() {
        check(new int[] {1, 2, 3}, new int[] {1, 2, 3});
    }

    @Test
    void singleZero() {
        check(new int[] {0}, new int[] {0});
    }

    @Test
    void onlyZeros() {
        check(new int[] {0, 0, 0}, new int[] {0, 0, 0});
    }

    @Test
    void twoElementsZeroAtEnd() {
        check(new int[] {1, 0}, new int[] {1, 0});
    }

    @Test
    void twoElementsZeroAtStart() {
        check(new int[] {0, 1}, new int[] {1, 0});
    }

    @Test
    void mixedGroupsOfZeros() {
        check(new int[] {1, 0, 0, 2, 3, 0, 4}, new int[] {1, 2, 3, 4, 0, 0, 0});
    }

    @Test
    void negativeNumbersKeepTheirOrder() {
        check(new int[] {-1, 0, 5, 0, -3}, new int[] {-1, 5, -3, 0, 0});
    }

    @Test
    void longRunOfZerosInTheMiddle() {
        check(new int[] {4, 0, 0, 0, 0, 7, 0, 8}, new int[] {4, 7, 8, 0, 0, 0, 0, 0});
    }
}