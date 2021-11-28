package book_cracking_coding_interview._1_arrays_and_strings._1_4_palindrome_permutation;

public final class PermutationUtility {

    private PermutationUtility() {
        throw new UnsupportedOperationException("This is utility class and it isn't due to  instantiate");
    }

    public static final int firstEnglishSymbol = Character.getNumericValue('a');
    public static final int lastEnglishSymbol = Character.getNumericValue('z');

    /**
     * Returns symbol number for English alphabet.
     * If symbol is not English alphabet returns -1
     *
     * @return Returns symbol number for English alphabet.
     * If symbol is not English alphabet returns -1
     */
    public static int getChatNumber(char c) {
        int val = Character.getNumericValue(c);
        if (val >= firstEnglishSymbol && val <= lastEnglishSymbol) {
            return val - firstEnglishSymbol;
        }

        return -1;
    }
}
