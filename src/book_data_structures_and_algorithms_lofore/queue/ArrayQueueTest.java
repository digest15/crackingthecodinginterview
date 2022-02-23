package book_data_structures_and_algorithms_lofore.queue;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;
import java.util.NoSuchElementException;

import static org.junit.jupiter.api.Assertions.*;

class ArrayQueueTest {
    @Test
    @DisplayName("Test should throw IllegalArgumentException with constructor")
    void TestShouldThrowIllegalArgumentExceptionWithConstructor() {
        assertThrows(IllegalArgumentException.class, () -> new ArrayQueue<String>(0));
        assertThrows(IllegalArgumentException.class, () -> new ArrayQueue<String>(-1));
    }

    @Test
    @DisplayName("Test should throw NullPointerException when add null")
    void TestShouldThrowNullPointerExceptionWhenAddNull() {
        assertThrows(NullPointerException.class, () -> new ArrayQueue<String>(1).add(null));
    }

    @Test
    @DisplayName("Test should throw IllegalStateException when the element cannot be added at this time due to capacity")
    void TestShouldThrowIllegalStateExceptionWithCapacityRestriction() {
        ArrayQueue<String> arrayQueue = new ArrayQueue<>(1);
        arrayQueue.add("one");
        assertThrows(IllegalStateException.class, () -> arrayQueue.add("two"));
    }

    @Test
    @DisplayName("Test should throw NoSuchElementException when remove or peek from empty queue")
    void TestShouldThrowNoSuchElementExceptionWhenRemoveOrPeekFromEmptyQueue() {
        ArrayQueue<String> arrayQueue = new ArrayQueue<>(1);
        assertThrows(NoSuchElementException.class, arrayQueue::remove);
        assertThrows(NoSuchElementException.class, arrayQueue::peek);
    }

    @Test
    @DisplayName("Test should fill and get elements with right order")
    void TestShouldFillAndGetElementsWithRightOrder() {
        List<Integer> list = List.of(1, 2, 3, 4);
        ArrayQueue<Integer> arrayQueue = new ArrayQueue<>(list.size());
        list.forEach(arrayQueue::add);
        list.forEach(i -> assertEquals(i, arrayQueue.remove()));
    }

    @Test
    @DisplayName("Test should tests iterator")
    void TestShouldTestIterator() {
        List<Integer> list = List.of(1, 2, 3, 4);
        ArrayQueue<Integer> arrayQueue = new ArrayQueue<>(list);

        int i = 0;
        for (Integer e : arrayQueue) {
            assertEquals(list.get(i), e);
            i++;
        }
    }
}