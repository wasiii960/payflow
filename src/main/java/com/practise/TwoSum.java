package com.practise;

import java.util.HashMap;
import java.util.Map;

public class TwoSum {
    public static int[] twoSum(int[] nums, int target){
        Map<Integer, Integer> map = new HashMap<>();
        for(int i=0;i<nums.length;i++){
            map.put(nums[i],i);
        }
        for (int i=0;i<nums.length;i++){
            int compliment = target-nums[i];
            if(map.containsKey(compliment) && map.get(compliment)!=i) {
                int[] targetArray = new int[2];
                targetArray[0]=i;
                targetArray[1]=map.get(compliment);
                return targetArray;
            }
        }
        return null;
    }
}
