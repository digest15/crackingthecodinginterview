package book_cracking_coding_interview.stack_and_queues._3_4_queue_via_two_stacks;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.LinkedList;
import java.util.NoSuchElementException;
import java.util.Queue;

import static org.junit.jupiter.api.Assertions.*;

class Test_3_4 {
    @Test
    @DisplayName("Test should get elements by queue")
    void testShouldGetElementsByQueue() {
        Queue<Integer> originQueue =new LinkedList<>();
        for (int i = 0; i < 10; i++) {
            originQueue.add(i);
        }

        MyQueue<Object> myQueue = new MyQueue<>();
        for (Integer origin: originQueue){
            myQueue.add(origin);
        }

        assertEquals(originQueue.size(), myQueue.size(), "Size queues is not equals");

        for (Integer origin : originQueue) {
            assertEquals(origin, myQueue.remove());
        }
    }

    @Test
    @DisplayName("Test should throws NoSuchElementException")
    void testShouldThrowsNoSuchElementException() {
        MyQueue<String> myQueue = new MyQueue<>();

        assertThrows(NoSuchElementException.class, myQueue::remove);
    }
}