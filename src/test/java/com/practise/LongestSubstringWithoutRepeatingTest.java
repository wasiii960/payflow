package com.practise;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class LongestSubstringWithoutRepeatingTest {

    @Test
    void leetCodeExample1() {
        assertEquals(3, LongestSubstringWithoutRepeating.lengthOfLongestSubstring("abcabcbb"));
    }

    @Test
    void allSameCharacter() {
        assertEquals(1, LongestSubstringWithoutRepeating.lengthOfLongestSubstring("bbbbb"));
    }

    @Test
    void answerIsSubstringNotSubsequence() {
        // "pwke" is longer but not contiguous
        assertEquals(3, LongestSubstringWithoutRepeating.lengthOfLongestSubstring("pwwkew"));
    }

    @Test
    void emptyString() {
        assertEquals(0, LongestSubstringWithoutRepeating.lengthOfLongestSubstring(""));
    }

    @Test
    void singleCharacter() {
        assertEquals(1, LongestSubstringWithoutRepeating.lengthOfLongestSubstring("a"));
    }

    @Test
    void noRepeatsAtAllCheckedAfterLoop() {
        // fails if the last window is never compared
        assertEquals(6, LongestSubstringWithoutRepeating.lengthOfLongestSubstring("abcdef"));
    }

    @Test
    void repeatMustNotClearValidCharacters() {
        // fails with set.clear(): "vdf" keeps the v
        assertEquals(3, LongestSubstringWithoutRepeating.lengthOfLongestSubstring("dvdf"));
    }

    @Test
    void removalMustStopAtLeftEdge() {
        // fails if removal goes back to index 0
        assertEquals(5, LongestSubstringWithoutRepeating.lengthOfLongestSubstring("abcadbe"));
    }

    @Test
    void oldCopyBeforeWindowIsIgnored() {
        // at the last 'a', its old copy is already outside the window
        assertEquals(2, LongestSubstringWithoutRepeating.lengthOfLongestSubstring("abba"));
    }

    @Test
    void longestAtTheEnd() {
        assertEquals(5, LongestSubstringWithoutRepeating.lengthOfLongestSubstring("tmmzuxt"));
    }

    @Test
    void spacesAndSymbolsCountAsCharacters() {
        assertEquals(4, LongestSubstringWithoutRepeating.lengthOfLongestSubstring("a b!"));
    }

    @Test
    void twoCharactersAlternating() {
        assertEquals(2, LongestSubstringWithoutRepeating.lengthOfLongestSubstring("ababab"));
    }
    @Test
    void singleSpace() {
        assertEquals(1, LongestSubstringWithoutRepeating.lengthOfLongestSubstring(" "));
    }

    @Test
    void spaceCountsAsACharacter() {
        assertEquals(2, LongestSubstringWithoutRepeating.lengthOfLongestSubstring("a a"));
    }
}