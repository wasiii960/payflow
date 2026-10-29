package com.practise;

public class ValidPalindrome {
    public static boolean isPalindrome(String str) {
        int i=0;int j=str.length()-1;
        while(i<j){
            boolean bypassIteration=false;
            if(!Character.isLetterOrDigit(str.charAt(i))){
                bypassIteration=true;
                i++;
            }
            if(!Character.isLetterOrDigit(str.charAt(j))){
                bypassIteration=true;
                j--;
            }
            if(!bypassIteration && Character.toLowerCase(str.charAt(i))!=Character.toLowerCase(str.charAt(j)))return false;
            if(!bypassIteration){
                i++;
                j--;
            }
        }
        return true;
    }
}
