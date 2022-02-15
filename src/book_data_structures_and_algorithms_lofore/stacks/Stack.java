package book_data_structures_and_algorithms_lofore.stacks;

public interface Stack<T> {

    /**
     * Adds element to top of stack
     * @param value - added element to top of stack
     */
    void push(T value);

    /**
     * Returns the and remove top of this stack.
     *
     * @return the top of this stack.
     */
    T pop();

    /**
     * Returns the top without removing it
     *
     * @return the top of this stack.
     */
    T peek();

    /**
     * Chek that this element is empty
     *
     * @return <cade>true</cade> - if this stack is empty, else <code>false</code>
     */
    boolean isEmpty();

}
