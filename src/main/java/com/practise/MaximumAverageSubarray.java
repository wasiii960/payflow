package com.practise;

public class MaximumAverageSubarray {
    public static double findMaxAverage(int[] nums, int k){
        double total=0;
        double maxAvg= Integer.MIN_VALUE;
        for(int i=0;i<nums.length;i++){
            if(i<k){
                total+=nums[i];
                if(i+1==k) maxAvg=Math.max(maxAvg,total/k);
            }else{
                total=nums[i]+total-nums[i-k];
                maxAvg=Math.max(maxAvg,total/k);
            }
        }
        return maxAvg;
    }
}
