package book_cracking_coding_interview.stack_and_queues._3_4_queue_via_two_stacks;

import java.util.EmptyStackException;
import java.util.NoSuchElementException;
import java.util.Stack;

public class MyQueue<T> {
    private Stack<T> newestStack, oldestStack;

    public MyQueue() {
        newestStack = new Stack<>();
        oldestStack = new Stack<>();
    }

    public void add(T element) {
        newestStack.push(element);
    }

    /**
     * Retrieves and removes the head of this queue.
     * This method throws an exception if this queue is empty.
     *
     * @return the head of this queue
     * @throws NoSuchElementException if this queue is empty
     */
    public T remove() {
        shiftStacks();
        try {
            return oldestStack.pop();
        } catch (EmptyStackException e) {
            throw new NoSuchElementException();
        }
    }

    /**
     * Retrieves, but does not remove, the head of this queue
     * This method throws an exception if this queue is empty.
     *
     * @return the head of this queue
     * @throws NoSuchElementException if this queue is empty
     */
    public T peek() {
        shiftStacks();
        try {
            return oldestStack.peek();
        } catch (EmptyStackException e) {
            throw new NoSuchElementException();
        }
    }

    public int size() {
        return oldestStack.size() + newestStack.size();
    }

    public boolean isEmpty() {
        return oldestStack.isEmpty() && newestStack.isEmpty();
    }

    private void shiftStacks() {
        if (oldestStack.isEmpty()) {
            while (!newestStack.isEmpty()){
                oldestStack.push(newestStack.pop());
            }
        }
    }
}
