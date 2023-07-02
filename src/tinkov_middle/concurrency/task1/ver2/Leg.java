package tinkov_middle.concurrency.task1.ver2;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.Exchanger;

public class Leg implements Runnable {
    private final String name;
    private final Exchanger<Object> synchronizer;

    public Leg(String name, Exchanger<Object> exchanger) {
        this.name = name;
        this.synchronizer = exchanger;
    }

    @Override
    public void run() {
        while (true) {
            try {
                synchronizer.exchange(new Object());
                System.out.println(name);
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
                throw new IllegalStateException();
            }

        }
    }

    public static void main(String[] args) {
        Exchanger<Object> exchanger = new Exchanger<>();
        CompletableFuture.allOf(
                CompletableFuture.runAsync(new Leg("left", exchanger)),
                CompletableFuture.runAsync(new Leg("right", exchanger))
        ).join();
    }
}
