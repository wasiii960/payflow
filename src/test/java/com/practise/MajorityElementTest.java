package com.practise;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class MajorityElementTest {
    @Test
    public void testMajorityElement2Distinct(){
        int []nums = {2,2,1,1,1,2,2};
        Assertions.assertEquals(2,MajorityElement.majorityElement(nums));
    }
    @Test
    public void testMajorityElement3Distinct(){
        int []nums = {3, 1, 3, 3, 3, 2};
        Assertions.assertEquals(3,MajorityElement.majorityElement(nums));
    }
    @Test
    public void testMajorityElement1DistinctElement(){
        int []nums = {1,1,1,1,1,1};
        Assertions.assertEquals(1,MajorityElement.majorityElement(nums));
    }
    @Test
    public void testMajorityElementNegative2Distinct(){
        int []nums = {-1,-1,2,2,-1,-1};
        Assertions.assertEquals(-1,MajorityElement.majorityElement(nums));
    }
}
