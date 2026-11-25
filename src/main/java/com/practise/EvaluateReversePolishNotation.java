package com.practise;

import java.util.ArrayDeque;
import java.util.Deque;

public class EvaluateReversePolishNotation {
    public static int evalRPN(String[] tokens){
        Deque<Integer> stack = new ArrayDeque<>();
        for(String token : tokens){
            if(token.equals("+") || token.equals("-") || token.equals("*") || token.equals("/")){
                if (stack.size() < 2) throw new IllegalArgumentException("Invalid expression at: " + token);
                int right=stack.pop();
                int left=stack.pop();
                stack.push(
                        switch(token){
                            case "+" -> left+right;
                            case "-" -> left-right;
                            case "*" -> left*right;
                            case "/" -> left/right;
                            default -> throw new IllegalArgumentException("Invalid expression at: " + token);
                        });
            }else{
                stack.push(Integer.parseInt(token));
            }
        }
        return stack.pop();
    }
}
