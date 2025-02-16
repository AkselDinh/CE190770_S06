/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ce190770_s06;

/**
 * S06 - Array Manipulation Program
 * Utility class containing merge sort implementation Provides methods to sort
 * integer arrays in ascending order
 *
 * @author Dinh Cong Phuc - CE190770 - 15/Jan/2025
 */
public class mergeSortArray {

    /**
     * Main merge sort method that recursively divides and sorts the array
     *
     * @param array The array to be sorted
     */
    public static void mergeSort(int[] array) {
        // Store the length of the input array
        int length = array.length;

        // Return if array has 1 or fewer elements (base case)
        if (length <= 1) {
            return;
        }

        // Calculate the middle index of the array
        int middle = length / 2;

        // Create a new array to store the left half of elements
        int[] leftArray = new int[middle];
        // Create a new array to store the right half of elements
        int[] rightArray = new int[length - middle];

        // Initialize index for main array iteration
        int i = 0;
        // Initialize index for right array population
        int j = 0;

        // Iterate through the entire input array
        for (; i < length; i++) {
            // Check if current index is in the left half
            if (i < middle) {
                // Copy element to left array
                leftArray[i] = array[i];
            } else {
                // Copy element to right array
                rightArray[j] = array[i];
                // Increment right array index
                j++;
            }
        }

        // Recursively sort the left sub-array
        mergeSort(leftArray);
        // Recursively sort the right sub-array
        mergeSort(rightArray);

        // Merge the sorted sub-arrays back into the original array
        merge(leftArray, rightArray, array);
    }

    /**
     * Merges two sorted arrays into one sorted array
     *
     * @param leftArray The left sub-array
     * @param rightArray The right sub-array
     * @param array The original array to store merged result
     */
    private static void merge(int[] leftArray, int[] rightArray, int[] array) {
        // Calculate the size of left sub-array
        int leftSize = array.length / 2;
        // Calculate the size of right sub-array
        int rightSize = array.length - leftSize;

        // Initialize index for merged array
        int i = 0;
        // Initialize index for left array
        int l = 0;
        // Initialize index for right array
        int r = 0;

        // Continue merging while both arrays have elements
        while (l < leftSize && r < rightSize) {
            // Compare elements from both arrays
            if (leftArray[l] < rightArray[r]) {
                // Copy smaller element from left array
                array[i] = leftArray[l];
                // Move to next position in merged array
                i++;
                // Move to next position in left array
                l++;
            } else {
                // Copy smaller or equal element from right array
                array[i] = rightArray[r];
                // Move to next position in merged array
                i++;
                // Move to next position in right array
                r++;
            }
        }

        // Copy remaining elements from left array if any
        while (l < leftSize) {
            // Copy element from left array
            array[i] = leftArray[l];
            // Move to next position in merged array
            i++;
            // Move to next position in left array
            l++;
        }

        // Copy remaining elements from right array if any
        while (r < rightSize) {
            // Copy element from right array
            array[i] = rightArray[r];
            // Move to next position in merged array
            i++;
            // Move to next position in right array
            r++;
        }
    }
}
