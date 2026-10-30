package com.practise;

import java.util.Arrays;

public class MoveZeroes {
    public static void moveZeroes(int[] nums){
        int last0Index=-1;
        for(int i=0;i<nums.length;i++){
            if(nums[i]==0 && last0Index==-1){
                last0Index=i;
            }else if(nums[i]!=0 && last0Index!=-1) {
                nums[last0Index]=nums[i];
                nums[i]=0;
                last0Index++;
            }
        }
    System.out.println(Arrays.toString(nums));
    }
}
