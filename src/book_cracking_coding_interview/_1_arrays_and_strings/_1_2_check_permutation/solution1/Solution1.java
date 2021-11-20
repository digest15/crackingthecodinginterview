package book_cracking_coding_interview._1_arrays_and_strings._1_2_check_permutation.solution1;

import java.util.Arrays;

public class Solution1 {

    /**
     * Check that strings is permutation.
     * It is assumed that check is case and whitespace sensitive.
     *
     * @return <code>true</code> if string are permutation else <code>false</code>
     * @throws IllegalArgumentException if strings are null or empty
     */
    public static boolean isPermutation(String s, String t) {
        if (s == null || t == null || s.isEmpty() || t.isEmpty()) {
            throw new IllegalArgumentException(String.format("Illegal argument s: %s, t: %s", s, t));
        }

        if (s.length() != t.length()) {
            return false;
        }

        return sort(s).equals(sort(t));
    }

    private static String sort(String s) {
        char[] content = s.toCharArray();
        Arrays.sort(content);
        return new String(content);
    }
}
