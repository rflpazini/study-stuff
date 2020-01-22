package resources.algorithms.arrays;

import java.io.IOException;
import java.util.Arrays;

public class LeftRotation {

    // O(N)
    // Solved with modular arithmetic
    static int[] rotLeft(final int[] a, int d) {
        int arrayLength = a.length;

        d %= arrayLength;
        int[] afterLeftRot = new int[arrayLength];

        for (int i = 0; i < arrayLength; i++) {
            afterLeftRot[i] = a[(i + d) % arrayLength]; // gets the item in the position of module result
        }

        return afterLeftRot;
    }

    static int[] rotRight(int[] a, int d) {
        int arrayLength = a.length;

        d %= arrayLength;
        int[] afterRightRot = new int[arrayLength];

        for (int i = 0; i < arrayLength; i++) {
            afterRightRot[i] = a[(i + (arrayLength - d)) % arrayLength];
        }

        return afterRightRot;
    }

    public static void main(String[] args) throws IOException {
        int[] a = {1, 2, 3, 4, 5};

        int[] resultLeft = rotLeft(a, 2);
        int[] resultRight = rotLeft(a, 2);

        System.out.println("O: " + Arrays.toString(a));
        System.out.println("L: " + Arrays.toString(resultLeft)); // [3, 4, 5, 1, 2]
        System.out.println("R: " + Arrays.toString(resultRight));// [4, 5, 1, 2, 3]
    }
}
