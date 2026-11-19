package com.practise;

import java.util.HashMap;
import java.util.Map;

public class FruitIntoBaskets {
    public static int totalFruit(int[] fruits){
        Map<Integer,Integer> basket=new HashMap<>();
        int best=0;
        int left=0;
        int count=0;
        for(int right=0;right<fruits.length;right++){
            if(basket.getOrDefault(fruits[right],0)==0) count+=1;
            basket.merge(fruits[right],1,Integer::sum);
            while(count>2){
                basket.merge(fruits[left],-1,Integer::sum);
                if(basket.get(fruits[left])==0) count--;
                left++;
            }
            best=Math.max(best,right-left+1);
        }
        return best;
    }
}
