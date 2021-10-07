package book_cracking_coding_interview._3_stack_and_queues._3_3_stack_of_stacks;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.*;

import static org.junit.jupiter.api.Assertions.*;

class Test_3_3 {
    @Test
    @DisplayName("Test should get all element with FIFO")
    void testShouldGetAllElementWithFifo() {
        StackOfStacks<Object> stack = new StackOfStacks<>(2);
        Deque<Integer> originDeque = new LinkedList<>();

        for (int i = 0; i < 5; i++) {
            originDeque.add(i);
            stack.push(i);
        }

        while (!originDeque.isEmpty()){
            assertEquals(originDeque.removeLast(), stack.pop(), "Error stack order");
        }
    }

    @Test
    @DisplayName("Test should throw EmptyStackException")
    void testShouldThrowEmptyStackException() {
        StackOfStacks<Integer> stack = new StackOfStacks<>(10);
        assertThrows(EmptyStackException.class, stack::pop);
    }

    @Test
    @DisplayName("Test should pop first stack of stack and get true order")
    void testShouldPopFirstStackOfStackAndGetTrueOrder() {
        int NUMBER_OF_ELEMETS           = 5;
        int NUMBER_OF_ELEMETS_IN_STACK  = 2;
        int NUMBER_OF_STACKS            = (NUMBER_OF_ELEMETS / NUMBER_OF_ELEMETS_IN_STACK) + (NUMBER_OF_ELEMETS % NUMBER_OF_ELEMETS_IN_STACK > 0 ? 1 :0);
        int INDEX_OF_STACK              = 0;

        StackOfStacks<Object> stack = new StackOfStacks<>(NUMBER_OF_ELEMETS_IN_STACK);
        LinkedList<Integer> origin = new LinkedList<>();

        for (int i = 0; i < NUMBER_OF_ELEMETS; i++) {
            origin.add(i);
            stack.push(i);
        }

        Integer originElement = origin.remove(((INDEX_OF_STACK + 1) * NUMBER_OF_ELEMETS_IN_STACK) - 1);
        assertEquals(originElement, stack.popAt(0));

        assertEquals(NUMBER_OF_STACKS -1, stack.numberOfStacks(), "Wrong number of stacks in stack");

        while (!origin.isEmpty()){
            assertEquals(origin.removeLast(), stack.pop(), "Error stack order");
        }
    }

    @Test
    @DisplayName("Test should throw IndexOutOfBoundsException")
    void testShouldThrowIndexOutOfBoundsException() {
        StackOfStacks<Integer> stack = new StackOfStacks<>(1);
        assertThrows(IndexOutOfBoundsException.class, () -> stack.popAt(1));
    }
}