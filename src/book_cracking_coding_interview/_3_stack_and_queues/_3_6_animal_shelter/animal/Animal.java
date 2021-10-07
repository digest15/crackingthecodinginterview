package book_cracking_coding_interview._3_stack_and_queues._3_6_animal_shelter.animal;

public abstract class Animal implements Comparable<Animal> {
    private long order;
    private String name;

    public Animal(String name) {
        this.name = name;
    }

    @Override
    public int compareTo(Animal animal) {
        return (int) (this.order - animal.getOrder());
    }

    public long getOrder() {
        return order;
    }

    public void setOrder(long order) {
        this.order = order;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
