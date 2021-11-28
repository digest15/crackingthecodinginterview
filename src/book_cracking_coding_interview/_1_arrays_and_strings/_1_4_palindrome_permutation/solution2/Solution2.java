package book_cracking_coding_interview._1_arrays_and_strings._1_4_palindrome_permutation.solution2;

import book_cracking_coding_interview._1_arrays_and_strings._1_4_palindrome_permutation.PermutationUtility;

public class Solution2 {

    /**
     * Check that strings is palindrome permutation.
     * It is assumed that check is case and whitespace sensitive and contains only English alphabet letters.
     *
     * @return <code>true</code> if string are palindrome permutation else <code>false</code>
     * @throws IllegalArgumentException if string are null or empty
     */
    public static boolean isPalindromePermutation(String phrase) {
        if (phrase == null || phrase.isEmpty()) {
            throw new IllegalArgumentException(String.format("Illegal argument phrase: %s", phrase));
        }

        int countOdd = 0;
        int countLetters = 0;

        int[] table = new int[PermutationUtility.lastEnglishSymbol -
                                    PermutationUtility.firstEnglishSymbol + 1];

        for (char c : phrase.toCharArray()) {
            int x = PermutationUtility.getChatNumber(c);
            if (x != -1) {
                countLetters++;
                table[x]++;
                if (table[x] % 2 == 1) {
                    countOdd++;
                }else {
                    countOdd--;
                }
            }
        }
        return countOdd <= 1 && countLetters != 0;
    }
}
