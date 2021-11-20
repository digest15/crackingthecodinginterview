package book_cracking_coding_interview._1_arrays_and_strings._1_2_check_permutation.solution1;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtensionContext;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.ArgumentsProvider;
import org.junit.jupiter.params.provider.ArgumentsSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.*;

class Test_Solution1 {
    @Test
    @DisplayName("Test should return true when strings are permutation")
    void testShouldReturnTrueWhenStringsArePermutation() {
        String s = "Dog";
        String t = "gDo";

        assertTrue(Solution1.isPermutation(s, t));
    }

    @Test
    @DisplayName("Test should return false when strings are not permutation")
    void testShouldReturnFalseWhenStringsAreNotPermutation() {
        String s = "Dog";
        String t = "ert";

        assertFalse(Solution1.isPermutation(s, t));
    }

    @Test
    @DisplayName("Test should return false when strings have different length")
    void testShouldReturnFalseWhenStringsHaveDifferentLength() {
        String s = "123";
        String t = "1234";
        assertFalse(Solution1.isPermutation(s, t));

        s = "123";
        t = "123 ";
        assertFalse(Solution1.isPermutation(s, t));

        s = "123\n";
        t = "123 ";
        assertFalse(Solution1.isPermutation(s, t));
    }

    @Test
    @DisplayName("Test should return false when strings are permutation but have different case for any symbols")
    void testShouldReturnFalseWhenStringsArePermutationButHaveDifferentCaseForAnySymbols() {
        String s = "Dog";
        String t = "dog";

        assertFalse(Solution1.isPermutation(s, t));
    }

    @ParameterizedTest
    @ArgumentsSource(BlankStringsArgumentsProvider.class)
    @DisplayName("Test should throw IllegalArgumentException when any string is Empty or null")
    void testShouldThrowIllegalArgumentExceptionWhenAnyStringIsEmptyOrNull(String s, String t) {
        assertThrows(IllegalArgumentException.class, () -> Solution1.isPermutation(s, t));
    }

    static class BlankStringsArgumentsProvider implements ArgumentsProvider {
        @Override
        public Stream<? extends Arguments> provideArguments(ExtensionContext extensionContext) throws Exception {
            return Stream.of(
                    Arguments.of(null, "1"),
                    Arguments.of("1", null)
            );
        }

        public BlankStringsArgumentsProvider() {
        }
    }
}