package com.practise;

import java.util.HashMap;
import java.util.Map;

public class SubarraySumEqualsK {

    public static int subarraySumResolve(int[] nums, int k){
        int total=0;
        int count=0;
        Map<Integer,Integer> runningSum = new HashMap<>();
        runningSum.put(0,1);
        for(int i=0;i<nums.length;i++){
            total+=nums[i];
            count+=runningSum.getOrDefault(total-k,0);
            runningSum.merge(total,1,Integer::sum);
        }
        return count;
    }
}
