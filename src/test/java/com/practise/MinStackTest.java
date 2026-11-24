package com.practise;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class MinStackTest {

    @Test
    void leetCodeExample() {
        MinStack s = new MinStack();
        s.push(-2);
        s.push(0);
        s.push(-3);
        assertEquals(-3, s.getMin());
        s.pop();
        assertEquals(0, s.top());
        assertEquals(-2, s.getMin());
    }

    @Test
    void singleElement() {
        MinStack s = new MinStack();
        s.push(5);
        assertEquals(5, s.top());
        assertEquals(5, s.getMin());
    }

    @Test
    void duplicateMinimumSurvivesOnePop() {
        // fails with "<" instead of "<=" when pushing onto the min stack
        MinStack s = new MinStack();
        s.push(1);
        s.push(1);
        s.pop();
        assertEquals(1, s.getMin());
    }

    @Test
    void poppingNonMinimumKeepsMinimum() {
        // fails if the min stack is popped on every pop
        MinStack s = new MinStack();
        s.push(2);
        s.push(5);
        s.pop();
        assertEquals(2, s.getMin());
        assertEquals(2, s.top());
    }

    @Test
    void increasingPushesMinStaysFirst() {
        MinStack s = new MinStack();
        s.push(1);
        s.push(2);
        s.push(3);
        assertEquals(1, s.getMin());
        s.pop();
        s.pop();
        assertEquals(1, s.getMin());
    }

    @Test
    void decreasingPushesMinFollowsPops() {
        MinStack s = new MinStack();
        s.push(3);
        s.push(2);
        s.push(1);
        assertEquals(1, s.getMin());
        s.pop();
        assertEquals(2, s.getMin());
        s.pop();
        assertEquals(3, s.getMin());
    }

    @Test
    void largeValuesOutsideIntegerCache() {
        // fails if Integer objects are compared with == (only -128..127 are cached)
        MinStack s = new MinStack();
        s.push(1000);
        s.push(1000);
        s.push(2000);
        s.pop();
        s.pop();
        assertEquals(1000, s.getMin());
    }

    @Test
    void negativeValues() {
        MinStack s = new MinStack();
        s.push(-1);
        s.push(-5);
        s.push(-3);
        assertEquals(-5, s.getMin());
        s.pop();
        assertEquals(-5, s.getMin());
        s.pop();
        assertEquals(-1, s.getMin());
    }

    @Test
    void minChangesBackAndForth() {
        MinStack s = new MinStack();
        s.push(5);
        s.push(3);
        s.push(7);
        s.push(3);
        assertEquals(3, s.getMin());
        s.pop();                     // removes 3
        assertEquals(3, s.getMin()); // the other 3 is still there
        s.pop();                     // removes 7
        s.pop();                     // removes 3
        assertEquals(5, s.getMin());
    }
}