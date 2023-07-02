## Задача 3

**Условие:** На заводе 5 станков и 8 фрезеровщиков, которые работают на станках. На каждом станке в один момент времени 
может работать только 1 рабочий. Чтобы все работники получили получку за рабочую смену, каждый должен поработать на станке. 
Рабочая смена у всех рабочих 8 часов.

Решить задачу 2мя способами:

1. С использованием пула потоков
2. С использованием синхронайзера из java.util.concurrent

Для работы на станке можно использовать метод

```java
    private static void workOnMachine(int workerId) {
        try {
            System.out.println("worker " + workerId + " occupy production machine ...");
            Thread.sleep(2000);
            System.out.println("worker " + workerId + " release production machine");
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
```