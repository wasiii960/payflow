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
    public static int[] twoSumSinglePassSorted(int[] nums, int target){
        int i=0;int j=nums.length-1;
        int [] ans = new int[2];
        while(i<j){
            if(nums[i]+nums[j]==target){
                ans[0]=i;
                ans[1]=j;
                return ans;
            }
            else if(nums[i]+nums[j]>target)j--;
            else i++;
        }
        return null;
    }
    public static int[] twoSumSinglePassUnSorted(int[] nums, int target){
        Map<Integer,Integer> map = new HashMap<>();
        for(int i=0;i<nums.length;i++){
            if(map.containsKey(target-nums[i])){
                return new int[]{map.get(target-nums[i]),i};
            }else{
                map.put(nums[i],i);
            }
        }
        return null;
    }
}
