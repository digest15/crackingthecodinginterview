package book_data_structures_and_algorithms_lofore.sorts;

public final class SimpleSorts {
    private SimpleSorts() {
        throw new UnsupportedOperationException("This is utility class and it isn't due to  instantiate");
    }

    public static void bubbleSort(long[] array) {
        int countLoop = 0;
        int countPerm = 0;

        for (int out = array.length - 1; out > 1; out--) {
            for (int in = 0; in < out; in++) {
                int next = in + 1;
                if (array[in] > array[next]) {
                    long buf = array[in];
                    array[in] = array[next];
                    array[next] = buf;

                    countPerm++;
                }
                countLoop++;
            }
        }

        System.out.printf("bubbleSort. Колво шагов: %s, колво перестановок: %s\n", countLoop, countPerm);
    }

    public static void selectionSort(long[] array) {
        int countLoop = 0;
        int countPerm = 0;

        for (int out = 0; out < array.length - 1; out++) {
            int min = out;
            for (int in = out + 1; in < array.length; in++) {
                if (array[in] < array[min]) {
                    min = in;
                }

                countLoop++;
            }
            if (out != min){
                long buf = array[out];
                array[out] = array[min];
                array[min] = buf;

                countPerm++;
            }
        }
        System.out.printf("selectionSort. Колво шагов: %s, колво перестановок: %s\n", countLoop, countPerm);
    }

    public static void insertionSort(long[] array) {
        int countLoop = 0;
        int countPerm = 0;

        for (int out = 1; out < array.length; out++) {
            long temp = array[out];
            int in = out;
            while (in > 0 && array[in -1] >= temp) {
                array[in] = array[in - 1];
                --in;

                countPerm++;
            }
            array[in] = temp;

            countLoop++;
        }
        System.out.printf("insertionSort. Колво шагов: %s, колво перестановок: %s\n", countLoop, countPerm);
    }

    public static void oddEvenSort(long[] array) {
        int countLoop = 0;
        int countPerm = 0;

        boolean sorted = false;
        while (!sorted) {
            sorted = true;

            for (int i = 1; i < array.length - 1; i += 2) {
                if (array[i] > array[i + 1]) {
                    long buf = array[i];
                    array[i] = array[i + 1];
                    array[i + 1] = buf;

                    sorted = false;

                    countPerm++;
                }

                countLoop++;
            }
            for (int j = 0; j < array.length - 1; j += 2) {
                if (array[j] > array[j + 1]) {
                    long buf = array[j];
                    array[j] = array[j + 1];
                    array[j + 1] = buf;

                    sorted = false;

                    countPerm++;
                }

                countLoop++;
            }
        }

        System.out.printf("oddEvenSort. Колво шагов: %s, колво перестановок: %s\n", countLoop, countPerm);
    }

}
