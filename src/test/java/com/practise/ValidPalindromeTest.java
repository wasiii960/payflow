package com.practise;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class ValidPalindromeTest {

    @Test
    void validPalindromeOnlyLetters() {
        String str1="A man a plan a canal panama";
        ValidPalindrome validPalindrome = new ValidPalindrome();
        Assertions.assertTrue(validPalindrome.isPalindrome(str1));
    }

    @Test
    void validPalindromeOnlyDigits() {
        String str1="111111";
        ValidPalindrome validPalindrome = new ValidPalindrome();
        Assertions.assertTrue(validPalindrome.isPalindrome(str1));
    }
    @Test
    void validPalindromeLetterAndDigits() {
        String str1="1a2a1";
        ValidPalindrome validPalindrome = new ValidPalindrome();
        Assertions.assertTrue(validPalindrome.isPalindrome(str1));
    }
    @Test
    void inValidPalindromeLettersOnly() {
        String str1="Race a caR";
        ValidPalindrome validPalindrome = new ValidPalindrome();
        Assertions.assertFalse(validPalindrome.isPalindrome(str1));
    }
    @Test
    void inValidPalindromeDigitsOnly() {
        String str1="111222";
        ValidPalindrome validPalindrome = new ValidPalindrome();
        Assertions.assertFalse(validPalindrome.isPalindrome(str1));
    }
    @Test
    void validPalindromeLetterCommaAndColon() {
        String str1="A man, a plan, a canal, Panama";
        ValidPalindrome validPalindrome = new ValidPalindrome();
        Assertions.assertTrue(validPalindrome.isPalindrome(str1));
    }
}
