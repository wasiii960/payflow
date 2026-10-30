package com.practise;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class ProductOfArrayExceptSelfTest {
    @Test
    public void testProductOfArrayExceptSelfPositiveNumber() {
        int [] nums={1,2,3,4};
        Assertions.assertArrayEquals(new int[]{24,12,8,6},
                ProductOfArrayExceptSelf.productExceptSelf(nums));
    }
    @Test
    public void testProductOfArrayExceptSelfPositiveAndNegativeNumber() {
        int [] nums={-1, 1, 0, -3, 3};
        Assertions.assertArrayEquals(new int[]{0, 0, 9, 0, 0},
                ProductOfArrayExceptSelf.productExceptSelf(nums));
    }
    @Test
    public void testProductOfArrayExceptSelfZeroInMiddle() {
        int [] nums={5,0,2};
        Assertions.assertArrayEquals(new int[]{0, 10,0},
                ProductOfArrayExceptSelf.productExceptSelf(nums));
    }
    @Test
    public void testProductOfArrayExceptAllNegativeNumbers() {
        int [] nums={-2, -3, -4};
        Assertions.assertArrayEquals(new int[]{12,8,6},
                ProductOfArrayExceptSelf.productExceptSelf(nums));
    }
}
