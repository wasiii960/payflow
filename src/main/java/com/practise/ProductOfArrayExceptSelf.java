package com.practise;

public class ProductOfArrayExceptSelf {

    public static int[] productExceptSelf(int[] nums){
        int [] ans = new int[nums.length];
        int rightMul=1;int leftMul=1;
        for(int i=nums.length-1;i>=0;i--){
            if(i+1>=nums.length)ans[i]=1;
            else{
                ans[i]=nums[i+1]*rightMul;
                rightMul=nums[i+1]*rightMul;
            }
        }
        for(int i=0;i<nums.length;i++){
            if(i-1<0) leftMul=1;
            else{
                leftMul=nums[i-1]*leftMul;
                ans[i]=ans[i]*leftMul;
            }
        }
        return ans;
    }
}
