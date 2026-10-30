package com.practise;

import java.util.HashSet;
import java.util.Set;

public class LongestConsecutiveSequence {

    public static int longestConsecutiveSequence(int[] nums){
        Set<Integer> set = new HashSet<>();
        if(nums==null||nums.length==0) return 0;
        int longestSequence=0;
        for(int i=0;i<nums.length;i++){
            set.add(nums[i]);
        }
        for(Integer i:set){
            int currentElement = i;
            int currentSequence=1;
            if(set.contains(currentElement-1)) continue;
            while(set.contains(currentElement+1)){
                currentSequence++;
                currentElement++;
            }
            longestSequence = Math.max(longestSequence,currentSequence);
        }
        return longestSequence;
    }
}
