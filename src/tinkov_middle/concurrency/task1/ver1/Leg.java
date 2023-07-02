package tinkov_middle.concurrency.task1.ver1;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.Semaphore;

public class Leg implements Runnable {
    private final Semaphore currentSem;
    private final Semaphore otherSem;
    private final String name;

    public Leg(Semaphore currentSem, Semaphore otherSem, String name) {
        this.currentSem = currentSem;
        this.otherSem = otherSem;
        this.name = name;
    }

    @Override
    public void run() {
        while (true) {
            try {
                currentSem.acquire();
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
                throw new IllegalStateException();
            }
            System.out.println(name);
            otherSem.release();
        }
    }

    public static void main(String[] args) {
        Semaphore leftSem = new Semaphore(0);
        Semaphore rightSem = new Semaphore(1);

        CompletableFuture.allOf(
                CompletableFuture.runAsync(new Leg(leftSem, rightSem, "left")),
                CompletableFuture.runAsync(new Leg(rightSem, leftSem, "right"))
        ).join();
    }
}
