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
    public static List<List<Integer>> threeSumNoSet(int[] nums){
        List<List<Integer>> result= new ArrayList<>();
        Arrays.sort(nums);

        int i=0;
        while(i+1<nums.length){
            if(i!=0 &&  nums[i]==nums[i-1]){
                i++;
                continue;
            }
            int k=nums.length-1;
            int j=i+1;
            while(k>j){
                if(j!=i+1 && nums[j]==nums[j-1]){
                    j++;
                    continue;
                }
                if(nums[i]+nums[j]+nums[k]==0){
                    result.add(List.of(nums[i],nums[j],nums[k]));
                    k--;
                    j++;
                }
                else if(nums[i]+nums[j]+nums[k]>0) k--;
                else j++;
            }
            i++;
        }
        return result;
    }
}
