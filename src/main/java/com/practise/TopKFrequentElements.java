package com.practise;

import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;

public class TopKFrequentElements {

    public static int[] topKFrequent(int[] nums, int k){
        Map<Integer, Integer> map = new HashMap<>();
        PriorityQueue<Map.Entry<Integer, Integer>> queue = new PriorityQueue<>(
            (a,b)->b.getValue()-a.getValue());
        int [] ans = new int [k];
        for(int i=0;i<nums.length;i++){
            map.put(nums[i],map.getOrDefault(nums[i],0)+1);
        }
        for(Map.Entry<Integer, Integer> entry:map.entrySet()){
            queue.add(entry);
        }
        int i=0;
        while(!queue.isEmpty() && i<k){
            ans[i] = queue.poll().getKey();
            i++;
        }
        return ans;
    }
}
