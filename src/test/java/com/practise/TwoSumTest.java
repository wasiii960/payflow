package com.practise;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;
import static org.junit.jupiter.api.Assertions.assertNull;


public class TwoSumTest {

    @Test
    void findsPairWhenSideBySide() {
        // Arrange: prepare the input
        int[] nums = {3, 2, 4};
        int target = 6;

        // Act: call the method being tested
        int[] result = TwoSum.twoSum(nums, target);

        // Assert: check the result
        assertArrayEquals(new int[] {1, 2}, result);
    }
    @Test
    void findTargetNotExist(){
        int [] nums = {3, 2, 4};
        int target=19;
        int[] result = TwoSum.twoSum(nums, target);
        assertNull(result);
    }
    @Test
    void findNegativeTargetExist(){
        int [] nums = {-1,-1,-3};
        int target=-2;
        int[] result = TwoSum.twoSum(nums, target);
        assertArrayEquals(new int[] {0, 1}, result);
    }
    @Test
    void findTargetWhenNotSideBySide(){
        int [] nums = {3, 2, 4};
        int target=7;
        int[] result = TwoSum.twoSum(nums, target);
        Assertions.assertArrayEquals(new int[] {0, 2}, result);
    }
    @Test
    void findTargetWhenSideBySideSorted(){
        int [] nums = {1,3,4,5,7,11};
        int target=9;
        Assertions.assertArrayEquals(
                new int[]{2,3},
                TwoSum.twoSumSinglePassSorted(nums,target)
        );
    }
    @Test
    void findTargetWhenNegativeSorted(){
        int [] nums = {-10,-3,10};
        int target=-13;
        Assertions.assertArrayEquals(
                new int[]{0,1},
                TwoSum.twoSumSinglePassSorted(nums,target)
        );
    }
    @Test
    void findTargetSortedNotExist(){
        int [] nums = {-10,-3,10};
        int target=-14;
        Assertions.assertNull(TwoSum.twoSumSinglePassSorted(nums,target)
        );
    }
}
