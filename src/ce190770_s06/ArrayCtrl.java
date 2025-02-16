/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ce190770_s06;

/**
 *
 * @author PD
 */
public class ArrayCtrl {

    // Array to store integer values with fixed size of 100
    private int[] arr = new int[100];
    // Alternative test array (commented out)
    //int [] arr = {1, 2, 3, -6, 10, 8, 5}; //testing

    // Tracks the current number of elements in the array
    private int arrSize = 0;

    /**
     * Adds a new value to the array
     */
    public void arrAddValue() {
        System.out.print("Please input a value: ");
        // Get valid integer input from user
        int input = InputValidation.getIntInput();
        // Increment array size and add new value
        arrSize++;
        arr[arrSize - 1] = input;
    }

    /**
     * Searches for a value in the array and displays its index if found
     */
    public void arrSearchValue() {
        boolean found = false;
        int i;
        if (arrSize == 0) {
            System.out.println("Array is empty");
        } else {
            System.out.print("Please input a value to search: ");
            // Get value to search for
            int input = InputValidation.getIntInput();
            // Search through array
            for (i = 0; i < arrSize; i++) {
                if (input == arr[i]) {
                    found = true;
                    break;
                }
            }
            // Display search results
            if (!found) {
                System.out.println("Value not found in array");
            } else {
                System.out.printf("Found value at index: %d\n", i);
            }
        }
    }

    /**
     * Prints all values currently in the array
     */
    public void arrPrint() {
        String str = new String();
        if (arrSize == 0) {
            System.out.println("Array is empty");
        } else {
            // Build string of array values
            for (int i = 0; i < arrSize; i++) {
                str += arr[i] + ", ";
            }
            // Remove trailing comma and space
            System.out.println(str.substring(0, str.length() - 2));
        }
    }

    /**
     * Prints values that fall within a user-specified range
     */
    public void arrPrintMinMax() {
        String str = new String();
        if (arrSize == 0) {
            System.out.println("Array is empty");
        } else {
            // Get range bounds from user
            System.out.print("Please input min: ");
            int min = InputValidation.getIntInput();
            System.out.print("Please input max: ");
            int max = InputValidation.getIntInput();
            try {
                // Build string of values within range
                for (int i = 0; i < arrSize; i++) {
                    if (arr[i] >= min && arr[i] <= max) {
                        str += arr[i] + ", ";
                    }
                }
                // Remove trailing comma and space
                System.out.println(str.substring(0, str.length() - 2));
            } catch (Exception e) {
                System.out.println("Invalid range");
            }
        }
    }

    /**
     * Sorts the array in ascending order using merge sort
     */
    public void arrSort() {
        if (arrSize == 0) {
            System.out.println("Array is empty");
        } else {
            // Create temporary array of actual elements
            int[] tempArr = new int[arrSize];
            for (int i = 0; i < arrSize; i++) {
                tempArr[i] = arr[i];
            }
            // Sort temporary array
            mergeSort(tempArr);
            // Copy sorted values back to original array
            for (int i = 0; i < arrSize; i++) {
                arr[i] = tempArr[i];
            }
            System.out.println("Sorted complete:");
            arrPrint();
        }
    }

    /**
     * Merges two sorted arrays into one sorted array
     *
     * @param leftArray The left sub-array
     * @param rightArray The right sub-array
     * @param array The original array to store merged result
     */
    private void merge(int[] leftArray, int[] rightArray, int[] array) {
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

    /**
     * Main merge sort method that recursively divides and sorts the array
     *
     * @param array The array to be sorted
     */
    private void mergeSort(int[] array) {
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
}
