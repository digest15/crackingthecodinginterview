package book_cracking_coding_interview._1_arrays_and_strings._1_5_one_away;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class Test_Solution1 {
    @Test
    @DisplayName("Test for replacement")
    void testForReplacement() {
        String s1 = "bale";
        String s2 = "pale";

        assertTrue(Solution1.isOneAway(s1, s2));
    }

    @Test
    @DisplayName("Test for insertion and removal")
    void testForInsertionAndRemoval() {
        String s1 = "apple";
        String s2 = "aple";

        assertTrue(Solution1.isOneAway(s1, s2));
    }

    @Test
    @DisplayName("Test for string with difference more one character")
    void testForStringWithDifferenceMoreOneCharacter() {
        String s1 = "apple123";
        String s2 = "aple";

        assertFalse(Solution1.isOneAway(s1, s2));
    }

    @Test
    @DisplayName("Test for strings with same string")
    void testForStringsWithSameString() {
        String s1 = new String("apple");
        String s2 = new String("apple");

        assertFalse(Solution1.isOneAway(s1, s2));
    }
}