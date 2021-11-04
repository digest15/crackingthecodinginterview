package book_cracking_coding_interview._1_arrays_and_strings._1_1_uniqu_simbol_in_string.solution2;

import java.util.BitSet;

public class Solution2 {

    /**
     * This solution assumes that input string compatible with ASCII format, otherwise 8-byte symbol format
     * and assumes that string to lowercase
     */
    public static boolean isUniqueSymbolString(String str) {
        int checker = 0;
        for (int i = 0; i < str.length(); i++) {
            int val = str.charAt(i) - 'a';
            if ((checker & (1 << val)) > 0) {
                return false;
            }
            checker |= (1 << val);
        }
        return true;
    }

    public static boolean isUniqueSymbolStringWithBitSet(String str) {
        final int ASCII_CHARACTER_SET_SIZE = 256;

        final BitSet checker = new BitSet(ASCII_CHARACTER_SET_SIZE);

        if (str.length() > 256) {
            return false;
        }

        for (int i = 0; i < str.length(); i++) {
            int val = str.charAt(i);
            if (checker.get(val)) {
                return false;
            }
            checker.set(val);
        }

        return true;
    }
}
