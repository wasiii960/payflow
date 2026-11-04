package com.practise;

public class RemoveDuplicatesFromSortedArray {

    public static int removeDuplicates(int[] nums){
        if(nums==null || nums.length==0) return 0;
        int previous=nums[0];
        int k=1;
        int updateIndex=-1;
        for(int i=1;i<nums.length;i++){
            if(nums[i]==previous && updateIndex==-1){
                updateIndex=i;
            }else if(nums[i] != previous){
                previous=nums[i];
                if(updateIndex!=-1){
                    int temp=nums[updateIndex];
                    nums[updateIndex]=nums[i];
                    nums[i]=temp;
                    updateIndex++;
                }
                k++;
            }
        }
        return k;
    }
}
