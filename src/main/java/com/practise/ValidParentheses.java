package com.practise;

import java.util.ArrayDeque;
import java.util.Deque;

public class ValidParentheses {
    public static boolean isValid(String s){
        Deque<Character> deque = new ArrayDeque<Character>();
        for(int i = 0; i < s.length(); i++){
            if(s.charAt(i) == '(' || s.charAt(i)== '{' || s.charAt(i)=='['){
                deque.push(s.charAt(i));
            }else {
                if (deque.isEmpty()) return false;
                char c = deque.pop();
                if ((c == '(' && s.charAt(i) != ')') ||
                        (c == '{' && s.charAt(i) != '}') ||
                        (c == '[' && s.charAt(i) != ']')) {
                    return false;
                }
            }
        }
        if(!deque.isEmpty()) return false;
        else return true;
    }
}
