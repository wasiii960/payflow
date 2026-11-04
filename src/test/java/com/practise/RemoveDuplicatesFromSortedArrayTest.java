package com.practise;

import org.junit.jupiter.api.Test;
import java.util.Arrays;
import static org.junit.jupiter.api.Assertions.*;

class RemoveDuplicatesFromSortedArrayTest {

    // Checks k, then only the first k elements (the rest is allowed to be anything)
    private void check(int[] nums, int expectedK, int[] expectedFirstK) {
        int k = RemoveDuplicatesFromSortedArray.removeDuplicates(nums);
        assertEquals(expectedK, k, "wrong count k");
        assertArrayEquals(expectedFirstK, Arrays.copyOf(nums, k), "wrong first k elements");
    }

    @Test
    void mainExampleTwoUniques() {
        check(new int[] {1, 1, 2}, 2, new int[] {1, 2});
    }

    @Test
    void manyDuplicatesOfEachValue() {
        check(new int[] {0, 0, 1, 1, 1, 2, 2, 3, 3, 4}, 5, new int[] {0, 1, 2, 3, 4});
    }

    @Test
    void noDuplicatesAtAll() {
        check(new int[] {1, 2, 3}, 3, new int[] {1, 2, 3});
    }

    @Test
    void singleElement() {
        check(new int[] {1}, 1, new int[] {1});
    }

    @Test
    void emptyArray() {
        check(new int[] {}, 0, new int[] {});
    }

    @Test
    void allElementsEqual() {
        check(new int[] {2, 2, 2, 2}, 1, new int[] {2});
    }

    @Test
    void duplicateInTheMiddle() {
        check(new int[] {1, 2, 2, 3}, 3, new int[] {1, 2, 3});
    }

    @Test
    void negativeNumbers() {
        check(new int[] {-3, -3, -1, 0, 0}, 3, new int[] {-3, -1, 0});
    }

    @Test
    void duplicatesAtStartAndEnd() {
        check(new int[] {1, 1, 2, 2, 3}, 3, new int[] {1, 2, 3});
    }
}