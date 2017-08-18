package org.kodejava.example.lang;

public class UniqueArray {
    /**
     * Return true if number num is appeared only once in the
     * array num is unique.
     */
    public static boolean isUnique(int[] array, int num) {
        for (int i = 0; i < array.length; i++) {
            if (array[i] == num) {
                return false;
            }
        }
        return true;
    }

    /**
     * Convert the given array to an array with unique values
     * without duplicates and returns it.
     */
    public static int[] toUniqueArray(int[] array) {
        int[] temp = new int[array.length];
        for (int i = 0; i < temp.length; i++) {
            temp[i] = -1; // in case u have value of 0 in the array
        }

        int counter = 0;
        for (int i = 0; i < array.length; i++) {
            if (isUnique(temp, array[i]))
                temp[counter++] = array[i];
        }

        int[] uniqueArray = new int[counter];
        System.arraycopy(temp, 0, uniqueArray, 0, uniqueArray.length);
        return uniqueArray;
    }

    /**
     * Print given array
     */
    public static void printArray(int[] array) {
        for (int i = 0; i < array.length; i++) {
            System.out.print(array[i] + " ");
        }

        System.out.println("");
    }

    public static void main(String[] args) {
        int[] array = {1, 1, 2, 3, 4, 1, 4, 7, 9, 7};
        printArray(array);
        printArray(toUniqueArray(array));
    }
}
