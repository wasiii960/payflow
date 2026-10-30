package com.practise;

public class MajorityElement {

    public static int majorityElement(int[] nums){
        int count=0;
        int currentElement=Integer.MIN_VALUE;
        for(int i=0;i<nums.length;i++){
            /*
            * Switch Candidate
            * */
            if(count==0){
                currentElement=nums[i];
                count=1;
            }else if(nums[i] == currentElement)count++;
            else if(nums[i]!=currentElement)count--;
        }
        return currentElement;
    }
}
