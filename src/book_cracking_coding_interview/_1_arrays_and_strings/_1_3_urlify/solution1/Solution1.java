package book_cracking_coding_interview._1_arrays_and_strings._1_3_urlify.solution1;

public class Solution1 {
    public static String replaceSpaces(String str) {
        int trueLength = str.replaceAll(" *$", "").length();
        return String
                .valueOf( replaceSpaces(str.toCharArray(), trueLength) )
                .trim();
    }

    private static char[] replaceSpaces(char[] str, int trueLength) {
        int spaceCount = 0;
        int index;
        int i = 0;

        for (i = 0; i < trueLength; i++) {
            if (str[i] == ' ') {
                spaceCount++;
            }
        }

        if (trueLength < str.length) {
            str[trueLength] = '\0';
        }

        index = trueLength + spaceCount * 2;
        for (i = trueLength - 1; i >= 0; i--) {
            if (str[i] == ' ') {
                str[index - 1] = '0';
                str[index - 2] = '2';
                str[index - 3] = '%';
                index = index - 3;
            } else {
                str[index - 1] = str[i];
                index--;
            }
        }

        return str;
    }
}
