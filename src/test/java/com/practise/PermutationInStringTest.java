package com.practise;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class PermutationInStringTest {

    @Test
    void leetCodeExample1() {
        assertTrue(PermutationInString.checkInclusion("ab", "eidbaooo"));
    }

    @Test
    void leetCodeExample2() {
        assertFalse(PermutationInString.checkInclusion("ab", "eidboaoo"));
    }

    @Test
    void permutationInTheMiddle() {
        assertTrue(PermutationInString.checkInclusion("abc", "ccbaxyz"));
    }

    @Test
    void duplicatesInS1Found() {
        assertTrue(PermutationInString.checkInclusion("aab", "abab"));
    }

    @Test
    void duplicatesInS1NotFound() {
        assertFalse(PermutationInString.checkInclusion("aab", "abbab"));
    }

    @Test
    void singleLetterNoMatch() {
        // fails if the entering letter is never checked
        assertFalse(PermutationInString.checkInclusion("a", "b"));
    }

    @Test
    void singleLetterMatch() {
        assertTrue(PermutationInString.checkInclusion("a", "a"));
    }

    @Test
    void letterNotInS1BreaksWindow() {
        // fails if the count of the wrong letter is decreased
        assertFalse(PermutationInString.checkInclusion("ab", "axb"));
    }

    @Test
    void wholeS2IsAPermutation() {
        assertTrue(PermutationInString.checkInclusion("ab", "ba"));
    }

    @Test
    void s1LongerThanS2() {
        assertFalse(PermutationInString.checkInclusion("abc", "ab"));
    }

    @Test
    void extraLetterBeforeMatch() {
        // fails with a "filling" phase that skips the over-limit check
        assertTrue(PermutationInString.checkInclusion("ab", "xab"));
    }

    @Test
    void matchAfterRepeatedLetter() {
        assertTrue(PermutationInString.checkInclusion("adc", "dcda"));
    }

    @Test
    void matchAtTheEndAfterRepeats() {
        assertTrue(PermutationInString.checkInclusion("abc", "bbbca"));
    }

    @Test
    void sameLettersButNeverTogether() {
        assertFalse(PermutationInString.checkInclusion("hello", "ooolleoooleh"));
    }

    @Test
    void tooManyOfOneLetterThenShrink() {
        assertTrue(PermutationInString.checkInclusion("aab", "aabaa"));
    }
}