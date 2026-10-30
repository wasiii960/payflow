package com.practise;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class LongestConsecutiveSequenceTest {
    @Test
    public void longestConsecutiveSequencePositiveNumberTest(){
        int [] nums={100,4,200,1,3,2};
        Assertions.assertEquals(4,
                LongestConsecutiveSequence.longestConsecutiveSequence(nums));
    }
    @Test
    public void longestConsecutiveSequenceNegativeNumberTest(){
        int [] nums={100,4,200,-1,-3,-2};
        Assertions.assertEquals(3,
                LongestConsecutiveSequence.longestConsecutiveSequence(nums));
    }

    @Test
    public void longestConsecutiveSequenceNoSequenceTest(){
        int [] nums={0,0,0,0,0,0};
        Assertions.assertEquals(1,
                LongestConsecutiveSequence.longestConsecutiveSequence(nums));
    }
    @Test
    public void longestConsecutiveSequenceEmptyArrayTest(){
        int [] nums=null;
        Assertions.assertEquals(0,
                LongestConsecutiveSequence.longestConsecutiveSequence(nums));
    }

}
