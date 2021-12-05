package book_cracking_coding_interview._1_arrays_and_strings._1_5_one_away;

public class Solution1 {
    public static boolean isOneAway(String str1, String str2) {
        if (Math.abs(str1.length() - str2.length()) > 1) {
            return false;
        }

        if (str1.equals(str2)) {
            return false;
        }

        String s1 = str1.length() < str2.length() ? str1 : str2;
        String s2 = str1.length() > str2.length() ? str1 : str2;

        int i1 = 0, i2 = 0;
        boolean foundDiff = false;
        while (i1 < s1.length() && i2 < s2.length()) {
            if (s1.charAt(i1) != s2.charAt(i2)) {
                if (foundDiff) {
                    return false;
                }
                foundDiff = true;

                if (s1.length() == s2.length()) {
                    i1++;
                }
            }else {
                i1++;
            }
            i2++;
        }

        return true;
    }
}
