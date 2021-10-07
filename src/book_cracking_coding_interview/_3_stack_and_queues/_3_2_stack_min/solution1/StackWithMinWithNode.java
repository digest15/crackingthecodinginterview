package book_cracking_coding_interview._3_stack_and_queues._3_2_stack_min.solution1;

import java.util.EmptyStackException;
import java.util.LinkedList;
import java.util.NoSuchElementException;

public class StackWithMinWithNode<T extends Comparable<T>> {
    private LinkedList<Node<T>> stack = new LinkedList<>();

    public void push(T value) {
        T min = min(value);
        stack.push(new Node<>(value, min));
    }

    /**
     * Retrieves and removes the top of this stack.
     * This method throws an exception if this stack is empty.
     *
     * @return the top of this stack
     * @throws EmptyStackException if this stack is empty
     */
    public T pop() {
        try {
            return stack.pop().value;
        } catch (NoSuchElementException e) {
            throw new EmptyStackException();
        }
    }

    /**
     * Get min element of this stack.
     * This method throws an exception if this stack is empty.
     *
     * @return min element of this stack
     * @throws EmptyStackException if this stack is empty
     */
    public T getMin() {
        Node<T> node = stack.peek();
        if (node == null) {
            throw new EmptyStackException();
        }
        return node.min;
    }

    private T min(T value) {
        Node<T> node = stack.peek();
        if (node == null) {
            return value;
        }

        T min = node.min;
        if (value.compareTo(min) < 0) {
            return value;
        }else {
            return min;
        }
    }

    private class Node<T> {

        public Node(T value, T min) {
            this.value = value;
            this.min = min;
        }

        T value;
        T min;
    }

}
