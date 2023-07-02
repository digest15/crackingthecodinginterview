package tinkov_middle.concurrency.task3.ver2;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.stream.IntStream;

public class FactoryWithThreadPool {
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
        ExecutorService machines = Executors.newFixedThreadPool(MACHINES_COUNT);

        IntStream workers = IntStream.range(0, WORKERS_COUNT);
        workers.forEach(i -> machines.submit(() -> workOnMachine(i)));

        machines.shutdown();
    }
}
