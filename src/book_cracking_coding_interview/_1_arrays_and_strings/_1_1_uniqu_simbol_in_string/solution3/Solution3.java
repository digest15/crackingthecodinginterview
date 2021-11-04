package book_cracking_coding_interview._1_arrays_and_strings._1_1_uniqu_simbol_in_string.solution3;

import java.util.HashSet;
import java.util.Set;

public class Solution3 {
    public static String getUniqueSymbol(String str) {
        Set<Character> symbolSet = new HashSet<>();
        for (int i = 0; i < str.length(); i++) {
            symbolSet.add(str.charAt(i));
        }
        StringBuilder builder = new StringBuilder();
        symbolSet.forEach(builder::append);

        return builder.toString();
    }
}
