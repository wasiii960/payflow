package com.practise;

public class NumArray {
    int[]sumArray;
    NumArray(int[] nums){
        sumArray=nums.clone();
        int sum=0;
        for(int i=0;i<nums.length;i++){
            sum+=nums[i];
            sumArray[i]=sum;
        }
    }
    public int sumRange(int left, int right){
    if (left < 0 || right >= sumArray.length || left>right) throw new IndexOutOfBoundsException();
        if(left==0) return sumArray[right];
        else return sumArray[right]-sumArray[left-1];
    }
}
