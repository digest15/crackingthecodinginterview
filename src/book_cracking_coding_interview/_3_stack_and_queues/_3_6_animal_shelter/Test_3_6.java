package book_cracking_coding_interview._3_stack_and_queues._3_6_animal_shelter;

import book_cracking_coding_interview._3_stack_and_queues._3_6_animal_shelter.animal.Animal;
import book_cracking_coding_interview._3_stack_and_queues._3_6_animal_shelter.animal.Cat;
import book_cracking_coding_interview._3_stack_and_queues._3_6_animal_shelter.animal.Dog;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.NoSuchElementException;

import static org.junit.jupiter.api.Assertions.*;

class Test_3_6 {
    @Test
    @DisplayName("Test should gets animals by queue")
    void testShouldGetsAnimalsByQueue() {
        AnimalQueue animalQueue = new AnimalQueue();
        animalQueue.add(new Dog("Jack"));
        animalQueue.add(new Cat("Murka"));
        animalQueue.add(new Dog("Dina"));
        animalQueue.add(new Cat("Mirzik"));

        Animal tmp = animalQueue.popAny();
        for (Animal animal: animalQueue) {
            assertTrue(tmp.compareTo(animal) < 0);
            tmp = animal;
        }
    }

    @Test
    @DisplayName("Test should throws NoSuchElementException")
    void testShouldThrowsNoSuchElementException() {
        AnimalQueue animalQueue = new AnimalQueue();

        assertThrows(NoSuchElementException.class, () -> animalQueue.popAny());
    }
}