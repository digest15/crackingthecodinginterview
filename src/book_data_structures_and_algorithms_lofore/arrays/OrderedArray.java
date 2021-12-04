package book_data_structures_and_algorithms_lofore.arrays;

import java.util.Arrays;
import java.util.Collection;
import java.util.Objects;

public class OrderedArray<T extends Comparable<T>> {
    private Object[] array;
    private int count;
    private int size;

    /**
     * Constructs an empty container with the specified initial capacity.
     *
     * @param  size the initial capacity of the list
     * @throws IllegalArgumentException if the specified size is negative
     */
    public OrderedArray(int size) {
        if (size < 0) {
            throw new IllegalArgumentException(String.format("Incorrect size: %s", size));
        }

        this.size = size + 1; //as prime number
        this.count = 0;

        array = new Object[this.size];
    }

    /**
     * Constructs a container containing the elements of the specified collection
     *  implemented with yourself public method <code>add()</code>
     *
     * @param c the collection whose elements are to be placed into this list
     * @throws NullPointerException if the specified collection is null
     */
    public OrderedArray(Collection<? extends T> c) {
        this.size = c.size();
        this.array = new Object[this.size];
        for (T e : c) {
            add(e);
        }
    }

    /**
     * Adds the specified element to this container.
     *
     * @param value element to be added to this container
     * @return <tt>true</tt> if element was added. <tt>false</tt> if element can't be added.
     */
    public boolean add(T value) {
        Objects.requireNonNull(value);

        if (count == Integer.MAX_VALUE) {
            return false;
        } else if (count == size) {
            grow();
        }

        int j = getInsertIndex(value);
        //if (count - j >= 0) System.arraycopy(array, j, array, j + 1, count - j);
        for (int k = count; j < k; k--) {
            array[k] = array[k - 1];
        }
        array[j] = value;
        count++;

        //System.out.println(String.format("Кол-во перестановок: %s", count - j - 1));
        return true;
    }

    /**
     * Returns index of element.
     * It is due to return <code>-1</code> if container doesn't contain this value.
     *
     * @return Index of element. <code>-1</code> if container doesn't contain this value.
     * @throws NullPointerException – if obj is null
     */
     public int indexOf(T value) {
        Objects.requireNonNull(value);

        return binarySearch(value);
    }

    /**
     * Returns the element at the specified position in this container.
     *
     * @param  index index of the element to return
     * @return the element at the specified position in this container
     * @throws IndexOutOfBoundsException if wrong index
     */
    @SuppressWarnings("uncheked")
    public T get(int index) {
        return (T) array[index];
    }

    /**
     * Remove the specified element from container.
     *
     * @param  value that is due to removed
     * @return the element that was removed from container, <code>null</code> if element wasn't find
     */
    @SuppressWarnings("uncheked")
    public T remove(T value) {
        Objects.requireNonNull(value);

        T removed;

        int j = binarySearch(value);
        if (j == -1) {
            removed = null;
        } else {
            removed = (T) array[j];
            //if (count - j >= 0) System.arraycopy(array, j - 1, array, j, count - j);
            for (int i = j; i < count - 1; i++) {
                array[i] = array[i + 1];
            }
            array[count - 1] = null;
            count--;
        }

        return removed;
    }

    /**
     * Returns the number of elements in this list.
     *
     * @return the number of elements in this list
     */
    public int size() {
        return count;
    }

    @Override
    public String toString() {
        return Arrays.toString(array);
    }

    /**
     * Returns index of element.
     * It is due to return -1 if container doesn't contain this value.
     *
     * @return Index of element. Currant size if container doesn't contain this value.
     */
    @SuppressWarnings("uncheked")
    private int binarySearch(T value) {
        int lowerBound = 0;
        int upperBound = count; //array.length - 1;
        int current;

        int countLoop = 0;

        while (true) {
            countLoop++;

            current = (lowerBound + upperBound) / 2;

            T currentValue = ((T) array[current]);
            if (currentValue != null && currentValue.compareTo(value) == 0) {
                break;
            } else if (lowerBound > upperBound) {
                current = -1;
                break;
            } else if (currentValue != null && currentValue.compareTo(value) < 0) {
                lowerBound = current + 1;
            }else {
                upperBound = current - 1;
            }
        }

        //System.out.println(String.format("Кол-во циклов бинарного поиска: %s", countLoop));
        return current;
    }

    private int getInsertIndex(T value) {
        int countLoop = 0;
        int index = count;

        if (count == 0) {
            index = 0;
        }else {
            int lowerBound = 0;
            int upperBound = count; //array.length - 1;

            while (true) {
                countLoop++;

                index = (lowerBound + upperBound) / 2;
                @SuppressWarnings("uncheked")
                T currentValue = ((T) array[index]);
                if (currentValue == null){
                    break;
                }else {
                    int compareResult = currentValue.compareTo(value);
                    if (currentValue != null && compareResult == 0) {
                        break;
                    } else if (lowerBound > upperBound) {
                            if (compareResult > 0 && index != 0) {
                                index--;
                            } else if (compareResult < 0){
                                index++;
                            }
                        break;
                    } else if (currentValue != null && compareResult < 0) {
                        lowerBound = index + 1;
                    } else {
                        upperBound = index - 1;
                    }
                }
            }
        }

        //System.out.println(String.format("Кол-во циклов бинарного поиска: %s", countLoop));
        return index;
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
