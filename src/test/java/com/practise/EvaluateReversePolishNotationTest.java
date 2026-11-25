package com.practise;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class EvaluateReversePolishNotationTest {

    @Test
    void leetCodeExample1() {
        assertEquals(9, EvaluateReversePolishNotation.evalRPN(new String[]{"2", "1", "+", "3", "*"}));
    }

    @Test
    void leetCodeExample2() {
        assertEquals(6, EvaluateReversePolishNotation.evalRPN(new String[]{"4", "13", "5", "/", "+"}));
    }

    @Test
    void leetCodeExample3() {
        assertEquals(22, EvaluateReversePolishNotation.evalRPN(
                new String[]{"10", "6", "9", "3", "+", "-11", "*", "/", "*", "17", "+", "5", "+"}));
    }

    @Test
    void subtractionOrder() {
        // fails if the operands are swapped: must be 5 - 2, not 2 - 5
        assertEquals(3, EvaluateReversePolishNotation.evalRPN(new String[]{"5", "2", "-"}));
    }

    @Test
    void subtractionGivingNegative() {
        assertEquals(-3, EvaluateReversePolishNotation.evalRPN(new String[]{"2", "5", "-"}));
    }

    @Test
    void divisionOrder() {
        // must be 12 / 4, not 4 / 12
        assertEquals(3, EvaluateReversePolishNotation.evalRPN(new String[]{"12", "4", "/"}));
    }

    @Test
    void divisionTruncatesTowardZeroPositive() {
        assertEquals(2, EvaluateReversePolishNotation.evalRPN(new String[]{"7", "3", "/"}));
    }

    @Test
    void divisionTruncatesTowardZeroNegative() {
        // -3.5 truncates to -3 (toward zero), not -4
        assertEquals(-3, EvaluateReversePolishNotation.evalRPN(new String[]{"7", "-2", "/"}));
    }

    @Test
    void singleNumber() {
        assertEquals(42, EvaluateReversePolishNotation.evalRPN(new String[]{"42"}));
    }

    @Test
    void singleNegativeNumber() {
        // fails if "-11" is treated as the minus operator
        assertEquals(-11, EvaluateReversePolishNotation.evalRPN(new String[]{"-11"}));
    }

    @Test
    void negativeNumberInExpression() {
        assertEquals(-1, EvaluateReversePolishNotation.evalRPN(new String[]{"3", "-4", "+"}));
    }

    @Test
    void multiplyThenSubtract() {
        // (3 * 4) - 5
        assertEquals(7, EvaluateReversePolishNotation.evalRPN(new String[]{"3", "4", "*", "5", "-"}));
    }
}