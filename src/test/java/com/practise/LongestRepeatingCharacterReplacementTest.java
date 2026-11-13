package com.practise;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class LongestRepeatingCharacterReplacementTest {

    @Test
    void leetCodeExample1() {
        assertEquals(4, LongestRepeatingCharacterReplacement.characterReplacement("ABAB", 2));
    }

    @Test
    void leetCodeExample2() {
        assertEquals(4, LongestRepeatingCharacterReplacement.characterReplacement("AABABBA", 1));
    }

    @Test
    void alreadyAllSameWithNoChanges() {
        assertEquals(4, LongestRepeatingCharacterReplacement.characterReplacement("AAAA", 0));
    }

    @Test
    void singleCharacter() {
        assertEquals(1, LongestRepeatingCharacterReplacement.characterReplacement("A", 0));
    }

    @Test
    void kBiggerThanString() {
        // can't be longer than the string itself
        assertEquals(1, LongestRepeatingCharacterReplacement.characterReplacement("A", 5));
    }

    @Test
    void allDifferentNoChanges() {
        assertEquals(1, LongestRepeatingCharacterReplacement.characterReplacement("ABCD", 0));
    }

    @Test
    void allDifferentEnoughChanges() {
        assertEquals(4, LongestRepeatingCharacterReplacement.characterReplacement("ABCD", 4));
    }

    @Test
    void allDifferentOneChange() {
        assertEquals(2, LongestRepeatingCharacterReplacement.characterReplacement("ABCDE", 1));
    }

    @Test
    void keptLetterSwitchesAndDoubleShrink() {
        // the dry-run example: A is best early, B is best at the end
        assertEquals(6, LongestRepeatingCharacterReplacement.characterReplacement("BAAACBBBB", 2));
    }

    @Test
    void bestLetterIsNotTheMostCommonOverall() {
        // A is most common overall, but the answer keeps B ("BBBC")
        assertEquals(4, LongestRepeatingCharacterReplacement.characterReplacement("AABBBCAA", 1));
    }

    @Test
    void windowMustNotRestartAtRepeat() {
        // best window "AABAAA" keeps the letters before the second B
        assertEquals(6, LongestRepeatingCharacterReplacement.characterReplacement("AABAABAAA", 1));
    }

    @Test
    void bestWindowAtTheEnd() {
        assertEquals(5, LongestRepeatingCharacterReplacement.characterReplacement("ABBBAAAA", 1));
    }

    @Test
    void firstLetterIsNotTheOneToKeep() {
        // keep A, change the leading B
        assertEquals(5, LongestRepeatingCharacterReplacement.characterReplacement("BAAAA", 1));
    }

    @Test
    void threeLettersInBlocks() {
        assertEquals(6, LongestRepeatingCharacterReplacement.characterReplacement("AAABBBCCC", 3));
    }
}