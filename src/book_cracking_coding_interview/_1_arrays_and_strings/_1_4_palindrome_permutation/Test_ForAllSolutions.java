package book_cracking_coding_interview._1_arrays_and_strings._1_4_palindrome_permutation;

import book_cracking_coding_interview._1_arrays_and_strings._1_4_palindrome_permutation.solution1.Solution1;
import book_cracking_coding_interview._1_arrays_and_strings._1_4_palindrome_permutation.solution2.Solution2;
import book_cracking_coding_interview._1_arrays_and_strings._1_4_palindrome_permutation.solution3.Solution3;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class Test_ForAllSolutions {
    @Test
    @DisplayName("Test should check that input string is PalindromePermutation")
    void testShouldCheckThatInputStringIsPalindromePermutation() {
        String phrase = "Tact CoA";
        assertTrue(Solution1.isPalindromePermutation(phrase));
        assertTrue(Solution2.isPalindromePermutation(phrase));
        assertTrue(Solution3.isPalindromePermutation(phrase));
    }

    @Test
    @DisplayName("Test should return false if string have not letter of English alphabet")
    void testShouldReturnFalseIfStringHaveNotLetterOfEnglishAlphabet() {
        String notPhrase = "111 ";
        assertFalse(Solution1.isPalindromePermutation(notPhrase));
        assertFalse(Solution2.isPalindromePermutation(notPhrase));
        assertFalse(Solution3.isPalindromePermutation(notPhrase));
    }
}