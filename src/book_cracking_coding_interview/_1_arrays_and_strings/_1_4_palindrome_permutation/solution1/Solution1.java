package book_cracking_coding_interview._1_arrays_and_strings._1_4_palindrome_permutation.solution1;

import book_cracking_coding_interview._1_arrays_and_strings._1_4_palindrome_permutation.PermutationUtility;

public class Solution1 {

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

        int[] charTable = buildCharFrequencyTable(phrase);
        return isHaveMaxOneOdd(charTable);
    }

    private static int[] buildCharFrequencyTable(String phrase) {
        int a = PermutationUtility.firstEnglishSymbol;
        int z = PermutationUtility.lastEnglishSymbol;

        int[] table = new int[z - a + 1];

        for (char c : phrase.toCharArray()) {
            int x = PermutationUtility.getChatNumber(c);
            if (x != -1) {
                table[x]++;
            }
        }

        return table;
    }

    private static boolean isHaveMaxOneOdd(int[] table) {
        boolean isFoundOdd = false;
        int countLetters = 0;
        for (int count : table) {
            if (count != 0) {
                countLetters++;
            }

            if (count % 2 == 1) {
                if (isFoundOdd) {
                    return false;
                }
                isFoundOdd = true;
            }
        }
        return countLetters > 0;
    }


}
