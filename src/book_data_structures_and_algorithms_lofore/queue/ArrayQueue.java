package book_data_structures_and_algorithms_lofore.queue;

import java.util.*;

/**
 * Cyclic array implementation of queue
 */
public class ArrayQueue<T>  implements Iterable<T>{
    private int maxSize;
    private Object[] queArray;
    private int front;
    private int rear;
    private int nItems;

    /**
     * Constructs an empty queue with the specified capacity.
     *
     * @param  size the initial capacity of the list
     * @throws IllegalArgumentException if the specified size is negative
     */
    public ArrayQueue(int size) {
        if (size <= 0) {
            throw new IllegalArgumentException(String.format("Incorrect size: %s", size));
        }
        init(size);
    }

    /**
     * Constructs a queue  containing the elements of the specified
     * collection, in the order they are returned by the collection's
     * iterator.
     *
     * @param c the collection whose elements are to be placed into this list
     * @throws NullPointerException if the specified collection is null
     * @throws IllegalArgumentException if the collection is empty
     */
    public ArrayQueue(Collection<? extends T> c) {
        Objects.requireNonNull(c);
        init(c.size());
        c.forEach(this::add);
    }

    private void init(int size) {
        maxSize = size;
        queArray = new Object[maxSize];
        front = 0;
        rear = -1;
        nItems = 0;
    }

    /**
     * Adds the specified element to this queue.
     *
     * @param value element to be added
     * @throws NullPointerException – if obj is null
     * @throws IllegalStateException if the element cannot be added at this time due to capacity
     */
    public void add(T value) {
        Objects.requireNonNull(value);
        if (isFull()) {
            throw new IllegalStateException("Queue is full");
        }

        if (rear == maxSize - 1) {
            rear = -1;
        }
        queArray[++rear] = value;
        nItems++;
    }

    /**
     * Retrieves and removes the head of this queue.
     *
     * @return the head of this queue
     * @throws NoSuchElementException if this queue is empty
     */
    public T remove() {
        if (isEmpty()) {
            throw new NoSuchElementException("Queue is empty");
        }

        @SuppressWarnings("uncheked")
        T temp = (T) queArray[front++];
        if (front == maxSize) {
            front = 0;
        }
        nItems--;

        return temp;
    }

    /**
     * Retrieves, but does not remove, the head of this queue.
     *
     * @return the head of this queue
     * @throws NoSuchElementException if this queue is empty
     */
    public T peek() {
        if (isEmpty()) {
            throw new NoSuchElementException("Queue is empty");
        }

        @SuppressWarnings("uncheked")
        T temp = (T) queArray[front];

        return temp;
    }

    public boolean isEmpty() {
        return nItems == 0;
    }

    public boolean isFull() {
        return nItems == maxSize;
    }

    public int size() {
        return nItems;
    }

    @Override
    public Iterator<T> iterator() {
        return new Itr();
    }

    @Override
    public String toString() {
        StringJoiner sj = new StringJoiner(",");
        forEach(e -> sj.add(e.toString()));

        return "[" + sj.toString() + "]";
    }

    private class Itr implements Iterator<T> {
        private int front;
        private int nItems;

        public Itr() {
            front = ArrayQueue.this.front;
            nItems = ArrayQueue.this.nItems;
        }

        @Override
        public boolean hasNext() {
            return nItems != 0;
        }

        @Override
        public T next() {
            if (nItems == 0) {
                throw new NoSuchElementException();
            }

            @SuppressWarnings("uncheked")
            T temp = (T) queArray[front++];
            if (front == maxSize) {
                front = 0;
            }
            nItems--;

            return temp;
        }
    }

}
