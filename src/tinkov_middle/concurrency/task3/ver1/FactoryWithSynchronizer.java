package tinkov_middle.concurrency.task3.ver1;

import java.util.List;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.Semaphore;
import java.util.stream.IntStream;

public class FactoryWithSynchronizer {
    private static final int MACHINES_COUNT = 5;
    private static final int WORKERS_COUNT = 8;

    private static void workOnMachine(int workerId) {
        try {
            System.out.println("worker " + workerId + " occupy production machine ...");
            Thread.sleep(2000);
            System.out.println("worker " + workerId + " release production machine");
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        Semaphore machines = new Semaphore(MACHINES_COUNT);

        IntStream workers = IntStream.range(0, WORKERS_COUNT);
        List<CompletableFuture<Void>> tasks = workers
                .mapToObj(i ->
                        CompletableFuture.runAsync(() -> {
                            try {
                                machines.acquire();
                                workOnMachine(i);
                                machines.release();
                            } catch (InterruptedException e) {
                                Thread.currentThread().interrupt();
                                throw new IllegalStateException();
                            }
                        }))
                .toList();

        tasks.forEach(CompletableFuture::join);
    }
}
