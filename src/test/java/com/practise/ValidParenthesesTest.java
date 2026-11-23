package com.practise;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ValidParenthesesTest {

    @Test
    void simplePair() {
        assertTrue(ValidParentheses.isValid("()"));
    }

    @Test
    void threeTypesInARow() {
        assertTrue(ValidParentheses.isValid("()[]{}"));
    }

    @Test
    void wrongType() {
        assertFalse(ValidParentheses.isValid("(]"));
    }

    @Test
    void wrongOrder() {
        // fails if you only count brackets instead of matching the top of the stack
        assertFalse(ValidParentheses.isValid("([)]"));
    }

    @Test
    void nested() {
        assertTrue(ValidParentheses.isValid("{[]}"));
    }

    @Test
    void deeplyNestedAllTypes() {
        assertTrue(ValidParentheses.isValid("{[()()]}"));
    }

    @Test
    void onlyOpening() {
        // fails if you forget to check the stack is empty at the end
        assertFalse(ValidParentheses.isValid("("));
    }

    @Test
    void twoOpeningNeverClosed() {
        assertFalse(ValidParentheses.isValid("(("));
    }

    @Test
    void onlyClosing() {
        // fails if you pop without checking the stack is empty
        assertFalse(ValidParentheses.isValid(")"));
    }

    @Test
    void closingBeforeOpening() {
        assertFalse(ValidParentheses.isValid("){"));
    }

    @Test
    void unbalancedClosingAtEnd() {
        assertFalse(ValidParentheses.isValid("(()))"));
    }

    @Test
    void unbalancedOpeningAtStart() {
        assertFalse(ValidParentheses.isValid("(()"));
    }

    @Test
    void sameTypeNested() {
        assertTrue(ValidParentheses.isValid("((()))"));
    }

    @Test
    void mixedSiblingsInsideBrackets() {
        assertTrue(ValidParentheses.isValid("([]{})"));
    }

    @Test
    void emptyStringIsValid() {
        // nothing to match; LeetCode guarantees length >= 1, but it's a good edge case
        assertTrue(ValidParentheses.isValid(""));
    }
}