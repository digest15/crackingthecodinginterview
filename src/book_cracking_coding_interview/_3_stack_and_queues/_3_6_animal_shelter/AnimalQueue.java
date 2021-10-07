package book_cracking_coding_interview._3_stack_and_queues._3_6_animal_shelter;

import book_cracking_coding_interview._3_stack_and_queues._3_6_animal_shelter.animal.Animal;
import book_cracking_coding_interview._3_stack_and_queues._3_6_animal_shelter.animal.Cat;
import book_cracking_coding_interview._3_stack_and_queues._3_6_animal_shelter.animal.Dog;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.NoSuchElementException;

public class AnimalQueue implements Iterable<Animal> {
    private LinkedList<Dog> dogs = new LinkedList<>();
    private LinkedList<Cat> cats = new LinkedList<>();
    private long order;

    public void add(Animal animal) {
        animal.setOrder(order++);

        if (animal instanceof Dog) {
            dogs.add((Dog) animal);
        } else if (animal instanceof Cat) {
            cats.add((Cat) animal);
        }
    }

    public Animal popAny() throws NoSuchElementException {
        if (dogs.isEmpty()) {
            return popCats();
        } else if (cats.isEmpty()) {
            return popDogs();
        }

        Dog dog = dogs.peek();
        Cat cat = cats.peek();
        if (dog.compareTo(cat) < 0) {
            return popDogs();
        }else {
            return popCats();
        }
    }

    private Animal popCats() {
        return cats.pop();
    }

    private Animal popDogs() {
        return dogs.pop();
    }

    @Override
    public Iterator<Animal> iterator() {
        return new AnimalIterator();
    }


    public class AnimalIterator implements Iterator<Animal> {
        @Override
        public boolean hasNext() {
            return (!dogs.isEmpty() || !cats.isEmpty());
        }

        @Override
        public Animal next() {
            return popAny();
        }
    }
}
