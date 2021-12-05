package book_data_structures_and_algorithms_lofore.arrays;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Collections;
import java.util.List;
import java.util.Random;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.*;

class OrderedArrayTest {
    private static List<Integer> testList;
    private static final int size = 100;

    @BeforeAll
    static void initTest() {
        testList = Stream.iterate(0, i -> i + 1)
                .limit(size)
                .collect(Collectors.toList());

        Collections.shuffle(testList);
    }

    @Test
    @DisplayName("Test should throw IllegalArgumentException")
    void testShouldThrowIllegalArgumentException() {
        assertThrows(IllegalArgumentException.class, () -> new OrderedArray<Integer>(-1));
    }

    @Test
    @DisplayName("Test should throw NullPointerException")
    void testShouldThrowNullPointerException() {
        assertThrows(NullPointerException.class, () -> new OrderedArray<Integer>(null));
    }

    @Test
    @DisplayName("Test should constructs container and check correct sorting")
    void testShouldConstructsContainerAndCheckCorrectSorting() {
        OrderedArray<Integer> orderedArray = new OrderedArray<>(testList);

        assertEquals(0, orderedArray.get(0));
        assertEquals(size - 1, orderedArray.get(size - 1));
    }

    @Test
    @DisplayName("Test should check that container grow without exception")
    void testShouldCheckThatContainerGrowWithoutException() {
        OrderedArray<Integer> orderedArray = new OrderedArray<>(size / 4);
        testList.forEach(orderedArray::add);
    }

    @Test
    @DisplayName("Test should check number of elements")
    void testShouldCheckNumberOfElements() {
        OrderedArray<Integer> orderedArray = new OrderedArray<>(testList);
        assertEquals(size, orderedArray.size());
    }

    @Test
    @DisplayName("Test should return negative number")
    void testShouldReturnNegativeNumber() {
        assertTrue(new OrderedArray(0).indexOf(1) < 0);
    }

    @Test
    @DisplayName("Test checks that container return correct element by index")
    void testChecksThatContainerReturnCorrectElementByIndex() {
        OrderedArray<Integer> orderedArray = new OrderedArray<>(testList);
        for (int i = 1; i < size; i = i + 3) {
            assertEquals(i, orderedArray.get(i));
        }
    }

    @Test
    @DisplayName("Test should throw IndexOutOfBoundsException")
    void testShouldThrowIndexOutOfBoundsException() {
        assertThrows(IndexOutOfBoundsException.class, () -> new OrderedArray<Integer>(0).get(10));
    }

    @Test
    @DisplayName("Test should to remove an element and keep container in sorted state")
    void testShouldToRemoveAnElementAndKeepContainerInSortedState() {
        OrderedArray<Integer> orderedArray = new OrderedArray<>(testList);

        for (int i = 0; i < size; i = i + 3) {
            Integer value = orderedArray.remove(i);
            assertEquals(i, value);
        }

        int sizeArray = orderedArray.size();
        Integer one = orderedArray.get(0);
        Integer two = orderedArray.get(sizeArray / 2);
        Integer three = orderedArray.get(sizeArray - 1);

        assertTrue(one <= two && two <= three);
    }

    @Test
    @DisplayName("Test checks container's size after removing")
    void testChecksContainerSSizeAfterRemoving() {
        Random random = new Random();

        OrderedArray<Integer> orderedArray = new OrderedArray<>(testList);
        orderedArray.remove(Math.abs(random.nextInt() % orderedArray.size()));
        orderedArray.remove(Math.abs(random.nextInt() % orderedArray.size()));

        assertEquals(size - 2, orderedArray.size());
    }

    @Test
    @DisplayName("Test should merge two ordered containers")
    void testShouldMergeTwoOrderedContainers() {
        OrderedArray<Integer> oneArray = new OrderedArray<>(testList);
        OrderedArray<Integer> twoArray = new OrderedArray<>(size / 2);
        testList.stream()
                .limit(size / 2)
                .forEach(twoArray::add);

        oneArray.merge(twoArray);

        int sizeArray = oneArray.size();
        Integer one = oneArray.get(0);
        Integer two = oneArray.get(sizeArray / 2);
        Integer three = oneArray.get(sizeArray - 1);

        assertTrue(one <= two && two <= three);
        assertEquals(size + sizeArray / 2, oneArray.size() + twoArray.size() - 2);
    }
}