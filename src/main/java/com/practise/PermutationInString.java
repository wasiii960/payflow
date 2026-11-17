package com.practise;

import java.util.HashMap;
import java.util.Map;

public class PermutationInString {
    public static boolean checkInclusion(String s1, String s2){
        Map<Character,Integer> count1 = new HashMap<>();
        Map<Character,Integer> count2 = new HashMap<>();
        int left=0;
        for(int i=0; i<s1.length(); i++){
            count1.put(s1.charAt(i),count1.getOrDefault(s1.charAt(i),0)+1);
        }
        for(int right=0; right<s2.length(); right++){
                count2.put(s2.charAt(right),count2.getOrDefault(s2.charAt(right),0)+1);
                while(count2.getOrDefault(s2.charAt(right),0)> count1.getOrDefault(s2.charAt(right),0)){
                    count2.put(s2.charAt(left),count2.getOrDefault(s2.charAt(left),0)-1);
                    left++;
                }
                if (right-left+1==s1.length()) return true;
            }
        return false;
    }
}
