package com.practise;

import java.util.HashMap;
import java.util.Map;

public class LongestSubstringWithoutRepeating {
    public static int lengthOfLongestSubstring(String s){
        Map<Character,Integer> map=new HashMap<>();
        int maxLength=0;
        int currentLength=0;
        int left=0;
        for(int i=0;i<s.length();i++){
            if(!map.containsKey(s.charAt(i))){
                map.put(s.charAt(i),i);
                currentLength++;
            }
            else{
                maxLength=Math.max(maxLength,currentLength);
                int previous = map.get(s.charAt(i));
                int index = previous;
                while(index>=left){
                    map.remove(s.charAt(index)); index--;currentLength--;
                }
                left=previous+1;
                map.put(s.charAt(i),i);
                currentLength++;
            }
        }
       maxLength =  Math.max(currentLength,maxLength);
        return maxLength;
    }
}
