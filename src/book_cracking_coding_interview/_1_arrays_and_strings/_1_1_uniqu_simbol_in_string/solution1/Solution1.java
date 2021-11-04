package book_cracking_coding_interview._1_arrays_and_strings._1_1_uniqu_simbol_in_string.solution1;


/**
 * This solution assumes that input string compatible with ASCII format, otherwise 8-byte symbol format
 */
public class Solution1 {
    public static boolean isUniqueSymbolString(String str) {
        if (str.length() > 128) {
            return false;
        }

        boolean[] charSet = new boolean[128];
        for (int i = 0; i < str.length(); i++) {
            int val = str.charAt(i);
            if (charSet[val]){
                return false;
            }
            charSet[val] = true;
        }
        return true;
    }
}
