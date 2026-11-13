package com.practise;

public class LongestRepeatingCharacterReplacement {
    public static int characterReplacement(String s, int k){
        int left=0;
        int best=0;
        int [] counts=new int[26];
        for(int right=0;right<s.length();right++){
            counts[s.charAt(right)-'A']++;
            while((right-left+1)-maxOf(counts)>k){
                counts[s.charAt(left)-'A']--;
                left++;
            }
            best=Math.max(best,right-left+1);
        }
        return best;
    }

    private static int maxOf(int[] counts) {
        int max=0;
        for(int count:counts){
            max= Math.max(count,max);
        }
        return max;
    }
}
