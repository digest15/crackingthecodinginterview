package book_data_structures_and_algorithms_lofore.sorts;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.LongStream;
import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.*;

class SimpleSortsTest {
    private static List<Long> testList;
    private static final int size = 1000;

    @BeforeAll
    static void initTest() {
        testList = LongStream.iterate(0, i -> i + 1)
                .limit(size).boxed()
                .collect(Collectors.toList());

        Collections.shuffle(testList);
    }


    @Test
    @DisplayName("Test should checks bubble sort for primitives")
    void testShouldChecksBubbleSortForPrimitives() {
        long[] array = testList.stream().mapToLong(i -> i).toArray();

        SimpleSorts.bubbleSort(array);

        for (int i = 0; i < array.length - 1 ; i++)     {
            assertTrue(array[i] < array[i + 1]);
        }
    }

    @Test
    @DisplayName("Test should checks selection sort for primitives")
    void testShouldChecksSelectionSortForPrimitives() {
        long[] array = testList.stream().mapToLong(i -> i).toArray();

        SimpleSorts.selectionSort(array);

        for (int i = 0; i < array.length - 1 ; i++)     {
            assertTrue(array[i] < array[i + 1]);
        }
    }

    @Test
    @DisplayName("Test should checks insertion sort for primitives")
    void testShouldChecksInsertionSortForPrimitives() {
        long[] array = testList.stream().mapToLong(i -> i).toArray();

        SimpleSorts.insertionSort(array);

        for (int i = 0; i < array.length - 1 ; i++)     {
            assertTrue(array[i] < array[i + 1]);
        }
    }

    @Test
    @DisplayName("Test should checks odd even sort for primitives")
    void testShouldChecksOddEvenSortForPrimitives() {
        long[] array = testList.stream().mapToLong(i -> i).toArray();

        SimpleSorts.oddEvenSort(array);

        for (int i = 0; i < array.length - 1 ; i++)     {
            assertTrue(array[i] < array[i + 1]);
        }
    }
}