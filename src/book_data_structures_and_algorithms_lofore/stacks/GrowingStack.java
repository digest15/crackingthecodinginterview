package book_data_structures_and_algorithms_lofore.stacks;

import java.util.Arrays;
import java.util.Objects;

public class GrowingStack<T> implements Stack<T> {
    private int size;
    private Object[] array;
    private int top;

    /**
     * Constructs an empty stack with the specified initial capacity.
     *
     * @param  initCapaсity the initial capacity of the stack
     * @throws IllegalArgumentException if the specified initial capacity is negative
     */
    public GrowingStack(int initCapaсity) {
        if (initCapaсity < 0) {
            throw new IllegalArgumentException(String.format("Incorrect init capaсity: %s", initCapaсity));
        }

        this.size = initCapaсity;
        this.array = new Object[size];
        this.top = 0;
    }


    /**
     * @inheritDoc
     * @throws NullPointerException if value is null
     * @throws IllegalStateException if size of stack was reached <code>Integer.MAX_VALUE</code>
     */
    @Override
    public void push(T value) {
        Objects.requireNonNull(value);

        if (top == Integer.MAX_VALUE) {
            throw new IllegalStateException("Size of stack is was reached the limit size");
        } else if ( (top + 1) == size) {
            grow();
        }

        array[++top] = value;
    }

    /**
     * @inheritDoc
     * @throws IllegalStateException - if stack is empty
     */
    @Override
    public T pop() {
        if (isEmpty()) {
            throw new IllegalStateException("This stack is empty");
        }

        @SuppressWarnings("uncheked")
        T value = (T) array[top];
        array[top--] = null;

        return value;
    }

    /**
     * @inheritDoc
     * @throws IllegalStateException - if stack is empty
     */
    @Override
    public T peek() {
        if (isEmpty()) {
            throw new IllegalStateException("This stack is empty");
        }

        @SuppressWarnings("uncheked")
        T value = (T) array[top];

        return value;
    }

    @Override
    public boolean isEmpty() {
        return top == 0;
    }

    private void grow() {
        int newSize = size * 2 + 1;
        if (newSize < 0) {
            newSize = Integer.MAX_VALUE;
        }

        array = Arrays.copyOf(array, newSize);

        size = newSize;
    }
}
