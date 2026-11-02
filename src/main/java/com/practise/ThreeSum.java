package com.practise;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;

public class ThreeSum {

    public static List<List<Integer>> threeSum(int[] nums){
        HashSet<List<Integer>> set = new HashSet<List<Integer>>();
        List<List<Integer>> list = new ArrayList<List<Integer>>();
        Arrays.sort(nums);
        for(int i=0;i<nums.length;i++){
            int j=i+1;int k=nums.length-1;
            while(j<k)
            {
                if(nums[i]+nums[j]+nums[k]==0){
                    set.add(List.of(nums[i],nums[j],nums[k]));
                    j++;
                    k--;
                }else if(nums[i]+nums[j]+nums[k]<0) j++;
                else k--;
            }
        }
        list.addAll(set);
        return list;
    }
}
