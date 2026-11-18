package com.practise;

public class MaxConsecutiveOnesIII {
    public static int longestOnes(int[] nums, int k){
        int [] zeros = new int[1];
        int left=0;
        int best=0;
        for(int right=0;right<nums.length;right++){
            if(nums[right]==0) zeros[0]=zeros[0]+1;
            while(zeros[0]>k) {
                if(nums[left]==0) zeros[0]--;
                left++;
            }
            best=Math.max(best,right-left+1);
        }
        return best;
    }
}
