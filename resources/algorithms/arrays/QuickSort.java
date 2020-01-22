package resources.algorithms.arrays;

import static java.lang.System.out;

import java.util.Arrays;
import java.util.Random;

public class QuickSort {

    private static int[] sortedArray;

    private QuickSort(final int[] array) {
        this.sortedArray = array;
        initSort(this.sortedArray);
    }

    public static int[] getSortedArray() {
        return sortedArray;
    }

    public static QuickSort doSortOf(final int[] array) {
        return new QuickSort(array);
    }

    public static void main(String[] args) {
        final int[] array = generateRandomArray(10);
        out.println("Unsorted: " + Arrays.toString(array));

        QuickSort sortedArray = QuickSort.doSortOf(array);
        out.println("Sorted:   " + Arrays.toString(sortedArray.getSortedArray()));
    }

    public static int[] generateRandomArray(final int arraySize) {
        int[] newStuff = new int[arraySize];

        for (int i = 0; i < arraySize; i++) {
            newStuff[i] = (new Random().nextInt() * arraySize) + 10;
        }

        return newStuff;
    }

    private int[] initSort(int[] arrayToSort) {
        doQuickSort(0, arrayToSort.length - 1);

        return new int[1];
    }

    private void doQuickSort(int left, int right) {
        if (right - left <= 0) {
            return;
        }

        int pivot = this.sortedArray[right];
        int location = partitionArray(left, right, pivot);

        doQuickSort(left, location - 1);
        doQuickSort(location + 1, right);
    }

    private int partitionArray(final int left, final int right, final int pivot) {
        int leftPointer = left - 1;
        int rightPointer = right;

        while (true) {
            while (this.sortedArray[++leftPointer] < pivot) {
                ;
            }
            while (rightPointer > 0 && this.sortedArray[--rightPointer] > pivot) {
                ;
            }
            if (leftPointer >= rightPointer) {

                break;

            } else {
                swapValues(leftPointer, rightPointer);
            }
        }

        swapValues(leftPointer, right);

        return leftPointer;
    }

    private void swapValues(int firstIndex, int secondIndex) {
        int savedValue = this.sortedArray[firstIndex];
        this.sortedArray[firstIndex] = this.sortedArray[secondIndex];
        this.sortedArray[secondIndex] = savedValue;
    }
}