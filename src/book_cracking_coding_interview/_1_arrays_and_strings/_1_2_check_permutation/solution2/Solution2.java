package book_cracking_coding_interview._1_arrays_and_strings._1_2_check_permutation.solution2;

public class Solution2 {
    /**
     * Check that strings is permutation.
     * This solution more efficient that solution1.
     * It is assumed that check is case and whitespace sensitive.
     * It is assumed that strings compatible with ASCII format, otherwise 8-byte symbol format
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

        int[] letters = new int[256];

        for (int i = 0; i < s.length(); i++) {
            letters[s.charAt(i)]++;
        }
        for (int i = 0; i < t.length(); i++) {
            char c = t.charAt(i);
            letters[c]--;
            if (letters[c] < 0) {
                return false;
            }
        }

        return true;
    }
}
