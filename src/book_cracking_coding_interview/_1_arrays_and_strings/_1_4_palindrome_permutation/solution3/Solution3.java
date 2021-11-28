package book_cracking_coding_interview._1_arrays_and_strings._1_4_palindrome_permutation.solution3;

import book_cracking_coding_interview._1_arrays_and_strings._1_4_palindrome_permutation.PermutationUtility;

public class Solution3 {

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

        int bitVector = createBitVector(phrase);
        if (bitVector < 0) {
            return false;
        }else {
            return bitVector == 0 || checkBitVector(bitVector);
        }
    }

    /**
     * Creates bit vector with <code>int</code> number
     *
     * @return Negative number if string doesn't contain English alphabet letters
     * else positive number or zero
     */
    private static int createBitVector(String phrase) {
        int bitVector = 0;
        int countNonAlphabetLetters = 0;

        for (char c : phrase.toCharArray()) {
            int x = PermutationUtility.getChatNumber(c);
            if (x < 0) {
                countNonAlphabetLetters++;
            }else {
                bitVector = toggle(bitVector, x);
            }
        }

        if (countNonAlphabetLetters == phrase.length()){
            return -1;
        } else {
            return bitVector;
        }
    }

    private static int toggle(int bitVector, int i) {
        if (i < 0) {
            return bitVector;
        }

        int mask = 1 << i;
        if ((bitVector & mask) == 0) {
            bitVector |= mask;
        } else {
            bitVector &= ~mask;
        }

        return bitVector;
    }


    private static boolean checkBitVector(int bitVector) {
        return (bitVector & (bitVector - 1)) == 0;
    }
}
