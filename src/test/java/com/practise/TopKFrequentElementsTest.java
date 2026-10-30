package com.practise;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class TopKFrequentElementsTest {

    @Test
    public void testTopKFrequentElementsAllPositive() {
        int [] nums = {1,1,1,2,2,3};
        Assertions.assertArrayEquals(new int[]{1,2},
        TopKFrequentElements.topKFrequent(nums,2));
    }
    @Test
    public void testTopKFrequentElementsSingleElement() {
        int [] nums = {1};
        Assertions.assertArrayEquals(new int[]{1},
                TopKFrequentElements.topKFrequent(nums,1));
    }
    @Test
    public void testTopKFrequentElementsAllNegative() {
        int [] nums = {-1,-1,-1,-3,-3,-3,-3,-2,-2,-2,-2};
        Assertions.assertArrayEquals(new int[]{-2,-3},
                TopKFrequentElements.topKFrequent(nums,2));
    }
}
