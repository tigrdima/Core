package task1;

import java.util.Arrays;

public class TwoDimensionalArray {

    public static void main(String[] args) throws InterruptedException {
        long[][] array = getRandomArray(10, 10, 1000);

        System.out.printf("Массив - %s\r\n", Arrays.deepToString(array));
        System.out.printf("Min of array - %s\r\n", (long) minMaxAverage(array)[0]);
        System.out.printf("Max of array - %s\r\n", (long) minMaxAverage(array)[1]);
        System.out.printf("Average of array - %s\r\n", minMaxAverage(array)[2]);

    }

    private static long getRandom(long max) throws InterruptedException {
        long random = System.currentTimeMillis();
        Thread.sleep(10);
        return random % max;
    }

    public static long[][] getRandomArray(int row, int cell, long max) throws InterruptedException {
        long[][] array = new long[row][cell];

        for (int i = 0; i < array.length; i++) {
            for (int j = 0; j < array[i].length; j++) {
                array[i][j] = getRandom(max);
            }
        }
        return array;
    }

    public static float[] minMaxAverage(long[][] array) {
        float[] rsl = new float[3];
        long min = array[0][0], max = array[0][0];
        long sum = 0, size = 0;

        for (long[] longs : array) {
            for (long aLong : longs) {
                sum += aLong;
                size++;
                if (aLong < min) {
                    min = aLong;
                } else if (aLong > max){
                    max = aLong;
                }
            }
        }
        rsl[0] = min;
        rsl[1] = max;
        rsl[2] = (float) sum / size;

        return rsl;
    }
}
