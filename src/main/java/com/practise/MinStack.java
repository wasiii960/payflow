package com.practise;

import java.util.ArrayDeque;
import java.util.Deque;

public class MinStack {
    private final Deque<Integer> stack;
    private final Deque<Integer> minStack;
    public MinStack(){
        this.stack = new ArrayDeque<>();
        this.minStack = new ArrayDeque<>();
    }
    public void push(int val){
        stack.push(val);
        if(minStack.isEmpty() || val<=minStack.peek()){
            minStack.push(val);
        }
    }
    public void pop(){
        if (stack.isEmpty()){ throw new IllegalStateException("Stack is empty"); }
        int toRemove = stack.pop();
        if(!minStack.isEmpty()){
            if(minStack.peek().equals(toRemove)) minStack.pop();
        }
    }
    public int top(){
        if (stack.isEmpty()){ throw new IllegalStateException("Stack is empty"); }
        return stack.peek();
    }
    public int getMin(){
        if (minStack.isEmpty()) throw  new IllegalStateException("Stack is empty");
        return minStack.peek();
    }
}
